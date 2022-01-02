/**  
* @Title: HttpClientTests.java
* @Package com.osxm.springbootency.httpclient
* @Description: TODO
* @author XM
* @date 2021年12月30日 下午9:47:01
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

public class HttpClientTests {

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void get() throws Exception {
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
		    HttpGet httpGet = new HttpGet("http://www.baidu.com");
		    try (CloseableHttpResponse response = httpclient.execute(httpGet)) {    	
		    	System.out.println(response.getStatusLine());  //获取响应状态,比如 HTTP/1.1 200 OK
		        HttpEntity entity = response.getEntity();	//获取响应结果
		        String rtn = EntityUtils.toString(entity);
		        System.out.println(rtn);		     
		        EntityUtils.consume(entity); //如果返回内容是输入流类型， 关闭输入流
		    }	  
		}
	}
	
    // The underlying HTTP connection is still held by the response object
    // to allow the response content to be streamed directly from the network socket.
    // In order to ensure correct deallocation of system resources
    // the user MUST call CloseableHttpResponse#close() from a finally clause.
    // Please note that if response content is not fully consumed the underlying
    // connection cannot be safely re-used and will be shut down and discarded
    // by the connection manager.
	
	public void post() {
		  HttpPost httpPost = new HttpPost("http://httpbin.org/post");
		  /*  List<NameValuePair> nvps = new ArrayList<>();
		    nvps.add(new BasicNameValuePair("username", "vip"));
		    nvps.add(new BasicNameValuePair("password", "secret"));
		    httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		    try (CloseableHttpResponse response2 = httpclient.execute(httpPost)) {
		        System.out.println(response2.getCode() + " " + response2.getReasonPhrase());
		        HttpEntity entity2 = response2.getEntity();
		        // do something useful with the response body
		        // and ensure it is fully consumed
		        EntityUtils.consume(entity2);
		    }*/
	}
}
