/**  
* @Title: RestTemplateOAuthDemo.java
* @Package com.osxm.springbootency.topics.rest
* @Description: TODO
* @author XM
* @date 2023年1月10日 下午9:50:52
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.springbootency.topics.rest;

import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.HashMap;

import javax.net.ssl.SSLContext;


import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
// import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplateOAuthDemo
 * @Description TODO
 * @author XM 
 * @date 2023年1月10日
 * 
 */
public class RestTemplateOAuthDemo {
	
	private String clientId = "";
	private String clientSecret = "";
	private String tokenUrl = "";
	private String callurl = "";
	
	// @Test
	// public void fetchToken() throws Exception {
	// 	//1. 构造信任所有证书的请求工厂
	// 	TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
	// 	SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
	// 			.build();
	// 	SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
	// 	CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
	// 	HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
	//     requestFactory.setHttpClient(httpClient);
        
	//     //2. RestTemplate 
	// 	RestTemplate restTemplate = new RestTemplate();
	// 	restTemplate.setRequestFactory(requestFactory);
	// 	String basicToken = "Basic " + Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());
	// 	HttpHeaders httpHeaders = new HttpHeaders();
	// 	httpHeaders.add("Authorization", basicToken);
	// 	//httpHeaders.add("Content-Type", "application/json");
		
	// 	HashMap<String, String> bodyMap = new HashMap<String, String>();
	// 	bodyMap.put("grant_type", "client_credentials");
	// 	HttpEntity<Object> entity = new HttpEntity<>(bodyMap, httpHeaders);
	// 	ResponseEntity<String> responseEntity = restTemplate.exchange(tokenUrl, HttpMethod.POST, entity, String.class);
	// 	System.out.println(responseEntity.getBody());
	// }
	
	// @Test
	// public void useTokenCall() throws Exception {
	// 	String token = "x";
	// 	//1. 构造信任所有证书的请求工厂
	// 	TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
	// 	SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
	// 			.build();
	// 	SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
	// 	CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
	// 	HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
	//     requestFactory.setHttpClient(httpClient);
	    
	//     //2. RestTemplate 
  	// 	RestTemplate restTemplate = new RestTemplate();
  	// 	restTemplate.setRequestFactory(requestFactory);
  	// 	HttpHeaders httpHeaders = new HttpHeaders();
  	// 	httpHeaders.add("Authorization", "Bearer " + token);
  	// 	HttpEntity<Object> entity = new HttpEntity<>(null, httpHeaders);
  	// 	ResponseEntity<String> responseEntity = restTemplate.exchange(callurl, HttpMethod.GET, entity, String.class);
  	// 	System.out.println(responseEntity.getBody());
	    	    
	// }
}
