package com.indi.kodt.core.spring;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.indi.kodt.core.spring.config.Constant;


/**
 * CustomDispatcherServlet
 *
 * @since 2017.10.11
 * @author Ryan
 *
 */
@SuppressWarnings("serial")
public class CustomDispatcherServlet extends DispatcherServlet {
    /**
     * Logger for this class
     */
	private static final Logger logger = LoggerFactory.getLogger(CustomDispatcherServlet.class);

    private static String SERVER = null;
    private static String APIURL = null;
    private static String CONTEXTPATH = null;
    private static String DB = null;
    private static String DIVCD = null;
    private static String DIVNM = null;
    private static String TRTCNT = null;

    /**
     * @return the server
     */
    public static String getServer() {
        return SERVER;
    }

    public static String getApiUrl() {
        return APIURL;
    }

    public static String getContextPath() {
        return CONTEXTPATH;
    }

    public static String getDb() {
    	return DB;
    }

    public static String getDivCd() {
    	return DIVCD;
    }

    public static String getDivNm() {
    	return DIVNM;
    }

    public static String getBatchDayTrtCnt() {
    	return TRTCNT;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        if (logger.isDebugEnabled()) {
            logger.debug("init(ServletConfig) - start"); //$NON-NLS-1$
        }

        try {
//	        String[] realHostnames = config.getServletContext().getInitParameter("real.hostname").split(",");
//	        System.out.println("realHostnames=" + Arrays.toString(realHostnames));
//	        String[] devHostnames = config.getServletContext().getInitParameter("dev.hostname").split(",");
//	        System.out.println("devHostnames=" + Arrays.toString(devHostnames));
//			String currentHostname = InetAddress.getLocalHost().getHostName();
//			System.out.println("currentHostname="+currentHostname);
//
//			if (SERVER == null) {
//		        for (String realHostname : realHostnames) {
//		        	if (currentHostname.equals(realHostname)) {
//		        		SERVER = Constant.SERVER_REAL;
//		        		break;
//		        	}
//		        }
//			}
//
//			if (SERVER == null) {
//		        for (String devHostname : devHostnames) {
//		        	if (currentHostname.equals(devHostname)) {
//		        		SERVER = Constant.SERVER_DEV;
//		        		break;
//		        	}
//		        }
//			}

			/**
			 * -Dspring.profiles.active=real
			 * -Dspring.profiles.active=dev
			 * -Dspring.profiles.active=local
			 */
			if (SERVER == null) {
				//1순위 (java 실행옵션으로 주는 경우)
				System.out.println("CustomDispatcherServlet - spring.profiles.active=" + System.getProperty("spring.profiles.active"));
				if (System.getProperty("spring.profiles.active")==null) {

					//2순위 (web.xml에 default를 real로 주고 실제 IP와 맞지 않으면 local로 세팅한다.)
					System.out.println("CustomDispatcherServlet - spring.profiles.default=" + config.getServletContext().getInitParameter("spring.profiles.default"));
					SERVER = config.getServletContext().getInitParameter("spring.profiles.default");
					DB = config.getServletContext().getInitParameter("spring.profiles.default");
					DIVCD = config.getServletContext().getInitParameter("org.div.cd");
					DIVNM = config.getServletContext().getInitParameter("org.div.nm");
					TRTCNT = config.getServletContext().getInitParameter("batch.day.cnt");
					if (SERVER.indexOf(Constant.SERVER_REAL) != -1) {
						SERVER = Constant.SERVER_REAL;
						APIURL = config.getServletContext().getInitParameter("real.api.url");
					} else if (SERVER.indexOf(Constant.SERVER_DEV) != -1) {
						SERVER = Constant.SERVER_DEV;
						APIURL = config.getServletContext().getInitParameter("dev.api.url");
					} else {
						SERVER = Constant.SERVER_LOCAL;
						APIURL = config.getServletContext().getInitParameter("local.api.url");
					}
					CONTEXTPATH = config.getServletContext().getInitParameter("context.path");
					System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, SERVER);

					//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
					//context.getEnvironment().setActiveProfiles(SERVER);
					//context.close();

				} else {
					SERVER = System.getProperty("spring.profiles.active");
				}
			}

			System.out.println("CustomDispatcherServlet - SERVER="+SERVER);
			System.out.println("CustomDispatcherServlet - APIURL="+APIURL);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        loadLog4jConfig(config);

        super.init(config);

        bugfixWeblogic();

        //IPV6, IPV4 가 둘다 사용 가능할 경우 디폴트로 JVM 이 IPV6 를 우선 사용하는데, IPV4 주소를 우선 사용하도록 설정
        System.setProperty("java.net.preferIPv4Stack" , "true");

        //쿼리 로그가 한줄로 안나오고 여러줄로 나오게 해주는 설정
        System.setProperty("log4jdbc.dump.sql.maxlinelength" , "0");

        if (logger.isDebugEnabled()) {
            logger.debug("init(ServletConfig) - end"); //$NON-NLS-1$
        }
    }

	@Autowired ConfigurableWebApplicationContext servContext;
	@SuppressWarnings("unused")
	private void setProfile(String newProfile) {
		ConfigurableWebApplicationContext rootContext  = (ConfigurableWebApplicationContext) servContext.getParent();

		rootContext.getEnvironment().setActiveProfiles(newProfile);
		rootContext.refresh();

		// Refreshing Spring-servlet WebApplicationContext
		servContext.getEnvironment().setActiveProfiles(newProfile);
		servContext.refresh();
	}

    /**
     * weblogic 관련 에러 예방.
     */
    private void bugfixWeblogic() {
        System.setProperty("http.keepAlive", "false");
        System.setProperty("java.net.preferIPv4Stack" , "true");
    }

    private void loadLog4jConfig(ServletConfig config) {
        if (logger.isDebugEnabled()) {
            logger.debug("loadLog4jConfig(ServletConfig) - start"); //$NON-NLS-1$
        }

        if (!"".equals(SERVER)) {
        	//log4j ver 1.*
            //logger.debug("log4jPath="+log4jPath);
            //PropertyConfigurator.configure(log4jPath);

			try {
				String logfile = "/WEB-INF/config/properties/log4j2_" + SERVER + ".xml";
				URI uri = config.getServletContext().getResource(logfile).toURI();
				Configurator.initialize("config", null, uri);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }

        if (logger.isDebugEnabled()) {
            logger.debug("loadLog4jConfig(ServletConfig) - end"); //$NON-NLS-1$
        }
    }

    /**
     * 현재 서버 IP 와 web.xml 파라미터의 서버 IP 를 비교해서 서버 종류를 리턴한다.
     *
	 * @param config
     * @return
     */
	private String getParameterServerIp(ServletConfig config) {
    	String server = null;

		System.out.println("CustomDispatcherServlet - web.xml - server.ip.real=" + config.getServletContext().getInitParameter("server.ip.real"));
		System.out.println("CustomDispatcherServlet - web.xml - server.ip.dev=" + config.getServletContext().getInitParameter("server.ip.dev"));
		String serverIpReal = config.getServletContext().getInitParameter("server.ip.real");
		String serverIpDev = config.getServletContext().getInitParameter("server.ip.dev");

		String[] serverIpsReal = null;
		String[] serverIpsDev = null;
		if (serverIpReal !=null) {
			serverIpsReal = serverIpReal.split(",");
		}
		if (serverIpDev !=null) {
			serverIpsDev = serverIpDev.split(",");
		}

		String hostAddress = null;
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            hostAddress = inetAddress.getHostAddress();
            System.out.println("CustomDispatcherServlet - hostAddress="+hostAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        if (server==null && serverIpsReal!=null) {
	        for (int i=0; i<serverIpsReal.length; i++) {
	        	if (hostAddress.equals(serverIpsReal[i])) {
	        		server = Constant.SERVER_REAL;
	        		break;
	        	}
	        }
        }
        if (server==null && serverIpsDev!=null) {
	        for (int i=0; i<serverIpsDev.length; i++) {
	        	if (hostAddress.equals(serverIpsDev[i])) {
	        		server = Constant.SERVER_DEV;
	        		break;
	        	}
	        }
        }

        System.out.println("CustomDispatcherServlet - getParameterServerIp server=" + server);
		return server;
    }
}
