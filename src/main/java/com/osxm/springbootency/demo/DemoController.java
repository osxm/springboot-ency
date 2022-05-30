/**  
* @Title: DemoController.java
* @Package com.osxm.springbootency.demo
* @Description: TODO
* @author XM
* @date 2022年5月12日 下午9:59:36
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.springbootency.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	
	@GetMapping(value="/json",produces="application/json")
	@ResponseBody
	public Map<String,String> rest() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("name","刘备");
		return map;
	}

	@GetMapping("/responseEntity")
	public ResponseEntity<String> responseEntity(@RequestParam String callbackfunc) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(callbackfunc + "('Hello')", headers, HttpStatus.OK);
	}

	@GetMapping("/output")
	public void output(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String callbackfunc = request.getParameter("callbackfunc");
		String callbackfunc = request.getParameter("callback");
		//response.setContentType("text/html");
		response.setContentType("application/javascript");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//out.print("myCallBackFunc({\"mystatus\":\"成功\"})");
		out.print(callbackfunc + "({\"mystatus\":\"成功\"})");
		
	}

}
