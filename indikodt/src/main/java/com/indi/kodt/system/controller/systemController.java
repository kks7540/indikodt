package com.indi.kodt.system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * <pre>
 * com.indi.kodt.system.controller
 *  - systemController.java
 * </pre>
 *
 * @ClassName   : systemController
 * @Description : 시스템관리 컨트롤러
 * @Author      : kks
 * @Date        : 2022. 02. 24.
 * @Version     : 1.0
 *
 */
@RestController
public class systemController{

	private static final Logger logger = LoggerFactory.getLogger(systemController.class);

	//@Resource(name="system.service.systemService")
	//private SystemService systemService;

	/**
	 * @Title       : selectList601
	 * @Description : 평가 대상 내역 조회 ( 평가대상 조회(list_601) )
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/login/loginService.do")
	public void selectList601(HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.debug("Request data : " + request.getParameter("a"));

	}

}
