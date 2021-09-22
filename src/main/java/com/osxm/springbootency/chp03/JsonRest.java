/**
 * @Title: FastJsonRest.java
 * @Package com.osxm.springbootency.chp04
 * @Description: TODO
 * @author oscarchen
 * @date 2021年7月12日
 * @version V1.0
 */
package com.osxm.springbootency.chp03;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.osxm.springbootency.com.entity.Usr;

/**
  * @ClassName: FastJsonRest
  * @Description: TODO
  * @author oscarchen
  */
@RestController
@RequestMapping("/chp03")
public class JsonRest {

	@RequestMapping("/json")
	public Usr getJson() {
		Usr usr = new Usr("关羽");	
		return usr;
	}
	
	@RequestMapping("/fastjson")
	public String getFastJson() {
		Usr usr = new Usr("关羽");
		return JSONObject.toJSONString(usr);
    }
	
}
