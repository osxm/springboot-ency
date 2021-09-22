/**
 * @Title: GlobalExceptionHandler.java
 * @Package com.osxm.springbootency.chp04
 * @Description: TODO
 * @author oscarchen
 * @date 2021年7月19日
 * @version V1.0
 */
package com.osxm.springbootency.chp04;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
  * @ClassName: GlobalExceptionHandler
  * @Description: TODO
  * @author oscarchen
  */
@ControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(value=NullPointerException.class)
	public ModelAndView nullExceptionHandler(HttpServletRequest req, Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", e);
		mv.setViewName("error");
		return mv;
	}
	
	@ExceptionHandler(value=SbModelViewException.class)
	public ModelAndView mvExceptionHandler(HttpServletRequest req, Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", e);
		mv.setViewName("error");
		return mv;
	}
	
	@ExceptionHandler(value=SbJsonException.class)
	@ResponseBody
	public Map<String,Object> jsonExceptionHandler(HttpServletRequest req, Exception e) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", false);
		return map;
	}
}
