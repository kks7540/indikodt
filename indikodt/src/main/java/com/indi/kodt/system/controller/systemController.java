package com.indi.kodt.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * <pre>
 * com.indi.kodt.system.controller
 *  - systemController.java
 * </pre>
 *
 * @ClassName   : systemController
 * @Description : 시스템 관리 프로그램.
 * @Author      : kks
 * @Date        : 2022. 02. 24.
 * @Version     : 1.0
 *
 */
@Controller
public class systemController{

	private static final Logger logger = LoggerFactory.getLogger(systemController.class);

	//@Resource(name="system.service.systemService")
	//private SystemService systemService;

	/**
	 * @Title       : loginChk
	 * @Description : 로그인 유효성 체크
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/login/loginChk.do")
	@ResponseBody
	public Map<String, Object> loginChk(HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String, Object> paramMap) throws Exception{
		logger.info("[Request Mapping] : " + request.getRequestURI());
		logger.debug("[Request data] : " + paramMap.toString());
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("result", "true");
		resultMap.put("message", "로그인 성공.");
		return resultMap;

	}
	
	/**
	 * @Title       : afterLogin
	 * @Description : 로그인 처리
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/login/afterLogin.do",method = {RequestMethod.POST})
	public String afterLogin(HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String, Object> paramMap, SessionStatus status) throws Exception{
		logger.info("[Request Mapping] : " + request.getRequestURI());
		logger.debug("[Request data] : " + paramMap.toString());
		
		request.getSession().setAttribute("userInfo", paramMap);
		// 중복 submit방지
		status.setComplete();
		
		return "system/dashBoard.tiles";
	}
}
