/**  
* @Title: DataMigrateClient.java
* @Package com.osxm.springbootency.datamigrate
* @Description: TODO
* @author XM
* @date 2022年9月21日 下午9:58:28
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.springbootency.datamigrate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class DataMigrateClient {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager em;
	
    @BeforeAll
    public static void setup() throws Exception{
         String persistenceUnitName = "my_jpa";
         entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
         em = entityManagerFactory.createEntityManager();   
    }

    @AfterAll
    public static void destroy() throws Exception {

        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
