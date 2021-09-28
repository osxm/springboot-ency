/**  
* @Title: MySqlConfig.java
* @Package com.osxm.springbootency.config
* @Description: TODO
* @author XM
* @date 2021年9月19日 上午10:34:35
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.config;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *  * @ClassName MySqlConfig  * @Description TODO  * @author XM
 *  * @date 2021年9月19日  *   
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.osxm.springbootency.com.dao.mysql",
entityManagerFactoryRef = "entityManagerFactoryMySql",
transactionManagerRef = "transactionManagerMySql")
public class MySqlConfig {

	@Autowired
	@Qualifier("mySqlDataSource")
	private DataSource mySqlDataSource;

	@Autowired
	private JpaProperties jpaProperties;

	@Autowired
	private HibernateProperties hibernateProperties;

	@Primary
	@Bean(name = "entityManagerMySql")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactoryMySql(builder).getObject().createEntityManager();
	}

	@Primary
	@Bean(name = "entityManagerFactoryMySql")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryMySql(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(mySqlDataSource)
				.properties(getVendorProperties())
				.packages("com.osxm.springbootency.com.entity.mysql").
				persistenceUnit("mySqlPersistenceUnit").build();
	}

	@Primary
	@Bean(name = "transactionManagerMySql")
	public PlatformTransactionManager transactionManagerMySql(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactoryMySql(builder).getObject());
	}

	private Map<String, Object> getVendorProperties() {
		return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
	}

}
