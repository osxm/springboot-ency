/**  
* @Title: GridController.java
* @Package com.osxm.springbootency.extjs
* @Description: TODO
* @author XM
* @date 2023年1月25日 下午4:34:18
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.springbootency.extjs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osxm.springbootency.com.entity.Usr;

@RestController
@RequestMapping("/grid")
public class GridController {

	@GetMapping(value = "/users", produces = "application/json")
	@CrossOrigin(origins = "*")
	public Map<String, Object> listUser(@RequestParam(required = false) int page,
			@RequestParam(required = false) int start, @RequestParam(required = false) int limit) {
		int total = 102; // 总数
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		List<Usr> userLisr = new ArrayList<Usr>();
		int maxCount = start + limit;
		if (maxCount > total) { // 不超过总数
			maxCount = total;
		}
		for (int i = start; i < maxCount; i++) {
			int id = i+1;
			Usr usr = new Usr();
			usr.setId(id);
			usr.setName("User_" + id);
			userLisr.add(usr);
		}

		rtnMap.put("status", "success");
		rtnMap.put("total", total);  //总数， 返回给前端计算页数
		rtnMap.put("datas", userLisr); //当前页的集合
		return rtnMap;
	}

}
