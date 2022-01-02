/**
 * @Title: UsrController.java
 * @Package com.osxm.springbootency.chp03
 * @Description: TODO
 * @author oscarchen
 * @date 2021年7月19日
 * @version V1.0
 */
package com.osxm.springbootency.chp03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.osxm.springbootency.com.entity.Usr;

/**
  * @ClassName: UsrController
  * @Description: TODO
  * @author oscarchen
  */
@Controller
@RequestMapping("/chp03/usr")
public class UsrController {

	@RequestMapping("/info")
	public ModelAndView info() {
		ModelAndView mv = new ModelAndView("usrinfo");
		Usr usr = new Usr("刘备");
		//usr.setPhone("13800000001");
		mv.addObject("usr", usr);
		return mv;
	}
	
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("usrlist");
		return mv;
	}
}
