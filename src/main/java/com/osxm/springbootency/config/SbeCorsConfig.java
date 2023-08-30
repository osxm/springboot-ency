/**  
* @Title: SbeCorsConfig.java
* @Package com.osxm.springbootency.config
* @Description: TODO
* @author XM
* @date 2022年5月12日 上午6:24:54
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.springbootency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SbeCorsConfig {
	
	@Bean
    public CorsFilter corsFilter() {
        //1. 初始CORS配置
        CorsConfiguration config = new CorsConfiguration();
        //允许的域
        config.addAllowedOrigin("*");
        //是否发送 Cookie
        // config.setAllowCredentials(true); 不能设置
        // 允许的方法
        config.addAllowedMethod("*");
        //放行哪些原始请求头部信息
        config.addAllowedHeader("*");
        //暴露哪些头部信息
        config.addExposedHeader("*");
        //2. 添加映射路径
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**",config);
        //3. 返回CorsFilter
        return new CorsFilter(corsConfigurationSource);
    }
}
