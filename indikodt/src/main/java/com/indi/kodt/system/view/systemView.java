package com.indi.kodt.system.view;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 *
 * <pre>
 * com.indi.kodt.system.systemView
 *  - systemView.java
 * </pre>
 *
 * @ClassName   : systemView
 * @Description : 시스템관련 화면 view
 * @Author      : kks
 * @Date        : 2022. 02. 24.
 * @Version     : 1.0
 *
 */
@Controller
public class systemView{

	private static final Logger logger = LoggerFactory.getLogger(systemView.class);

	/**
	 * main 화면 표시
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/system/main.do",method = {RequestMethod.GET})
	public String main(HttpServletRequest request, HttpServletResponse response) {
		logger.info("[ main view open ]");
		return "system/main.tiles";
	}

	/**
	 * main 화면 표시
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/system/main_back.do",method={RequestMethod.POST})
	public String main_back(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> paramMap) {
		logger.info("[ main view open ]");
		System.out.println(request.getParameter("tabpageNo"));
		System.out.println(String.valueOf(paramMap.get("tabpageNo")));
		String tabPage = String.valueOf(paramMap.get("tabpageNo"));
		return "system/dashBoard.tiles."+tabPage;
	}

}
