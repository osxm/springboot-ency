/**  
* @Title: WebSecurityConfig.java
* @Package com.osxm.springbootency.config
* @Description: TODO
* @author XM
* @date 2023年3月30日 上午6:44:27
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.springbootency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {


	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.headers().frameOptions().disable().and().authorizeRequests().
				antMatchers("/**").anonymous().and().csrf().disable().build();
	}
}
