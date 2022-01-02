/**  
* @Title: RestTemplateTests.java
* @Package com.osxm.springbootency.rest
* @Description: TODO
* @author XM
* @date 2021年12月16日 下午9:36:02
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class RestTemplateTests {

	
	@Test
	public void httpCall() {
		RestTemplate restTemplate = new RestTemplate();
		String httpUrl = "http://localhost:8080/myapp";
		ResponseEntity<String> resEntity = restTemplate.getForEntity(httpUrl, String.class);
		System.out.println(resEntity.getBody());
	}
	
	@Test
	public void httpsCall() {
		RestTemplate restTemplate = new RestTemplate();
		String httpsUrl = "https://localhost:8443/myapp";
		ResponseEntity<String> resEntity = restTemplate.getForEntity(httpsUrl, String.class);
		System.out.println(resEntity.getBody());
	}
}
