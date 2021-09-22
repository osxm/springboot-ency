/**
 * @Title: OracleTests.java
 * @Package com.osxm.springbootency.jpa
 * @Description: TODO
 * @author oscarchen
 * @date 2021年6月19日
 * @version V1.0
 */
package com.osxm.springbootency.jpa;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
  * @ClassName: OracleTests
  * @Description: TODO
  * @author oscarchen
  */
@SpringBootTest
public class OracleTests {

	@Autowired
	private EntityManager em;
	
	@Test
	public void test() {
		SbImage sbImage = em.createQuery("from SbImage",SbImage.class).getSingleResult();
		System.out.println(sbImage.getName());
		Assertions.assertNotNull(sbImage);
	}
}
