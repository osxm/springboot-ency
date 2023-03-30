/**  
* @Title: ParamController.java
* @Package com.osxm.springbootency.extjs
* @Description: TODO
* @author XM
* @date 2023年3月27日 下午9:58:15
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.springbootency.extjs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osxm.springbootency.com.vo.UsrVo;



@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.PUT})
public class ParamController {
	

	@RequestMapping(value="/params/urlparam",produces="application/json")
	public Map<String,String> urlParam(@RequestParam String param1){
		Map<String,String> map = new HashMap<String,String>();
		String msg = "传递的参数 param1="+param1;
		map.put("msg",msg);
		return map; 
	}
	
	
	@RequestMapping(value="/params/useparams",produces="application/json")
	public Map<String,String> useParams(UsrVo user){
		Map<String,String> map = new HashMap<String,String>();
		String msg = "传递的参数,自动装配 user="+user.toString();
		map.put("msg",msg);
		return map; 
	}
}
