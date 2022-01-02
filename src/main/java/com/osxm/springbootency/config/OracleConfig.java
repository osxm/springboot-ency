/**  
* @Title: OracleConfig.java
* @Package com.osxm.springbootency.config
* @Description: TODO
* @author XM
* @date 2021年9月19日 上午10:41:02
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.config;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName OracleConfig
 * @Description TODO
 * @author XM 
 * @date 2021年9月19日
 * 
 */
@Profile("withdb")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackages="com.osxm.springbootency.com.dao.oracle",
  entityManagerFactoryRef = "entityManagerFactoryOracle",
  transactionManagerRef = "transactionManagerOracle"
  ) 
public class OracleConfig {
	
	@Autowired
	 private JpaProperties jpaProperties;
	 
	//数据源
	 @Autowired
	 @Qualifier("oracleDataSource")
	 private DataSource oracleDataSource;
	 

	 
	 @Bean(name = "entityManagerFactoryOracle")
	 @Profile("withdb")
	 public LocalContainerEntityManagerFactoryBean entityManagerFactoryOralce(EntityManagerFactoryBuilder builder) {
	  return builder
	    .dataSource(oracleDataSource).packages("com.osxm.springbootency.com.entity.oracle").persistenceUnit("oraclePersistenceUnit").build();
	    //.properties(jpaProperties.getProperties())
	    //.packages("xxxx") //设置实体类所在位置
	    //.persistenceUnit("oraclePersistenceUnit")
	    //.build();
	 }
	 
	 @Bean(name = "entityManagerOracle")
	 public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
	  return entityManagerFactoryOralce(builder).getObject().createEntityManager();
	 }
	 
	 
	 //private Map getVendorProperties(DataSource dataSource) {
	 // return jpaProperties.getHibernateProperties(dataSource);
	// }
	 
	 //事务
	 @Bean(name = "transactionManagerOracle")
	 PlatformTransactionManager transactionManagerOracle(EntityManagerFactoryBuilder builder) {
	  return new JpaTransactionManager(entityManagerFactoryOralce(builder).getObject());
	 }
}
