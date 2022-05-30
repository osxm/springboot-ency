/**  
* @Title: CorsRest.java
* @Package com.osxm.springbootency.rest
* @Description: TODO
* @author XM
* @date 2022年5月12日 上午6:44:52
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.springbootency.rest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CorsRest {
	
	
	@RequestMapping("/corsmethod")
	@CrossOrigin(origins = "*")
	public Map<String,String> corsMethod(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("用户名", "刘备");
		return map;
	}
	
    @GetMapping(value="/corsresponsehead") 
    public Map<String,Object> corsResponseHead(HttpServletResponse response) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("param","Success");
        response.setHeader("Access-Control-Allow-Origin","*");
        return map;             
    }

}
