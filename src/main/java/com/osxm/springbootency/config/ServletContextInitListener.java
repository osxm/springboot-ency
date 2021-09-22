/**
 * @Title: ServletContextInitListener.java
 * @Package com.osxm.springbootency.config
 * @Description: TODO
 * @author oscarchen
 * @date 2021年6月28日
 * @version V1.0
 */
package com.osxm.springbootency.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * @ClassName: ServletContextInitListener
 * @Description: TODO
 * @author oscarchen
 */
@Component
public class ServletContextInitListener implements ApplicationListener<ContextRefreshedEvent> {

	@Value("${system.app-name:SpringBootEncy}")
	private String appName;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		WebApplicationContext webApplicationContext = (WebApplicationContext) contextRefreshedEvent
				.getApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		servletContext.setAttribute("appName", appName);
	}
}