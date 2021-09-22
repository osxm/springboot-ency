/**  
* @Title: DataSourceConfiguration.java
* @Package com.osxm.springbootency.config
* @Description: TODO
* @author XM
* @date 2021年9月19日 上午10:29:16
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName DataSourceConfiguration
 * @Description TODO
 * @author XM 
 * @date 2021年9月19日
 * 
 */
@Configuration
public class DataSourceConfiguration {
	
	@Primary
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.mysql")
	public DataSource mySqlDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.oracle")
	public DataSource oracleDataSource() {
		return DataSourceBuilder.create().build();
	}
}
