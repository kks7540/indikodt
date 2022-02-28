package com.indi.kodt.system.view;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RestController
public class systemView{

	private static final Logger logger = LoggerFactory.getLogger(systemView.class);

	/**
	 * main 화면 표시
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/system/main.do")
	public String kcontent(Locale locale, Model model) {
		logger.info("[ main view open ]");
		return "system/main.tiles";
	}
	

}
