/**  
* @Title: MyAppication.java
* @Package com.osxm.springbootency.base.feature
* @Description: TODO
* @author XM
* @date 2021年9月28日 下午9:19:53
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.base.feature;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class MyApplication {
	   public static void main(String[] args) {
	        SpringApplication application = new SpringApplication(MyApplication.class);
	        application.setBannerMode(Banner.Mode.OFF);
	        application.run(args);
	    }
}
