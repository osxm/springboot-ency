/**  
* @Title: RestDemoController.java
* @Package com.osxm.springbootency.demo
* @Description: TODO
* @author XM
* @date 2022年4月16日 上午8:33:07
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.springbootency.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/rest")
public class RestDemoController {

	@RequestMapping("")
	public Map<String,String> hello(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("用户名", "刘备");
		return map;
	}
}
