/**  
* @Title: ExtJsRest.java
* @Package com.osxm.springbootency.rest
* @Description: TODO
* @author XM
* @date 2022年7月30日 下午8:35:19
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.springbootency.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/extjs")
public class ExtJsRest {

	@RequestMapping(value="/kingdoms",produces="application/json")
	public  List<Map<String,String>> getKingdoms(){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> user1 = new HashMap<String,String>();
		user1.put("name","魏");
		user1.put("monarch","曹操");
		user1.put("city","豫州");
		Map<String,String> user2 = new HashMap<String,String>();
		user2.put("name","蜀");
		user2.put("monarch","刘备");
		user2.put("city","荆州");
		Map<String,String> user3 = new HashMap<String,String>();
		user3.put("name","吴");
		user3.put("monarch","孙权");
		user3.put("city","扬州");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		return list;
	}
}
