/**  
* @Title: MyWebMvcConfig.java
* @Package com.osxm.springbootency.config
* @Description: TODO
* @author XM
* @date 2022年5月11日 下午10:12:04
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.springbootency.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	    	//通过register注册拦截器，通过addpathPatterns添加拦截路径
	        registry.addInterceptor(new OptionsRequestInterceptor()).addPathPatterns("/**"); //拦截所有路径
	    }
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //是否发送Cookie
                //.allowCredentials(true) ,allowCredentials设置为 true,则 Origin 不能设置设置为*
                //放行的域
                .allowedOrigins("*")
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
    
    
}
