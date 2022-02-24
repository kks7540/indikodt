package com.indi.kodt;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indi.kodt.core.mvc.ParentMapper;

@Controller
public class HomeController extends ParentMapper {
  private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

  @RequestMapping(value = {"/"}, method = {RequestMethod.GET})
  public String home(Locale locale, Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(1, 1, locale);
    String formattedDate = dateFormat.format(date);
    List<Map<String, Object>> map = queryForList("stockDAO.selectStockList");
    model.addAttribute("serverTime", formattedDate);
    model.addAttribute("mapList", map.toString());
    return "common/login";
  }
}
