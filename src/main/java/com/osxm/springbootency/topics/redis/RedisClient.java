/**  
* @Title: RedisClient.java
* @Package com.osxm.springbootency.topics.redis
* @Description: TODO
* @author XM
* @date 2023年4月18日 下午9:56:03
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.springbootency.topics.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisClient {

	private final StringRedisTemplate stringRedisTemplate;
	
	public RedisClient(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}
	
	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(key); 
	}
}
