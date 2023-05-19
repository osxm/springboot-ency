/**  
* @Title: RedisTests.java
* @Package com.osxm.springbootency.redis
* @Description: TODO
* @author XM
* @date 2023年4月18日 下午10:35:42
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.springbootency.redis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.osxm.springbootency.topics.redis.RedisClient;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class RedisTests {

	@Autowired
	private RedisClient redisClient;
	
	@Test
	public void get() {
		String value = redisClient.get("mykey");
		Assertions.assertEquals("myvalue", value);
	}
}
