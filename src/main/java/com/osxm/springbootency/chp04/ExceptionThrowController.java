/**
 * @Title: ExceptionController.java
 * @Package com.osxm.springbootency.chp04
 * @Description: TODO
 * @author oscarchen
 * @date 2021年7月21日
 * @version V1.0
 */
package com.osxm.springbootency.chp04;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.osxm.springbootency.chp04.service.ExceptionDemoService;
import com.osxm.springbootency.com.entity.Usr;

/**
  * @ClassName: ExceptionController
  * @Description: TODO
  * @author oscarchen
  */
@Controller
@RequestMapping("/chp04")
public class ExceptionThrowController {
	
	
	@Autowired 
	private ExceptionDemoService  exceptionDemoService;
	
	@RequestMapping("/mvexp")
	public ModelAndView mvExpThrow(){
		
		ModelAndView mv = new ModelAndView("usrinfo");
		Usr usr = new Usr("刘备");
		//usr.setPhone("13800000001");
		mv.addObject("usr", usr);
		exceptionDemoService.throwSbModelViewException();
		return mv;
	}
	
	@RequestMapping("/jsonexp")
	@ResponseBody
	public Map<String,Object> jsonExpThrow(){
		Map<String,Object> map = new HashMap<String,Object>();
	    exceptionDemoService.throwJsonException();
		return map ;
	}
	
	@RequestMapping("/nullexp")
	public void nullExpThrow(){
		exceptionDemoService.throwNullExp();
	}
}
