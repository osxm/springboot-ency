/**
 * @Title: JpqlTests.java
 * @Package com.osxm.springbootency.jpa
 * @Description: TODO
 * @author oscarchen
 * @date 2021年6月14日
 * @version V1.0
 */
package com.osxm.springbootency.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osxm.springbootency.com.entity.Usr;

/**
  * @ClassName: JpqlTests
  * @Description: TODO
  * @author oscarchen
  */
@SpringBootTest
public class JpqlTests {
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void getCount() {
		Long iCount = entityManager.createQuery("select COUNT(u) from Usr u",Long.class).getSingleResult();
		Assertions.assertTrue(iCount==3);	
	}
	@Test
	public void getMax() {
		String str = entityManager.createQuery("select Max(u.name) from Usr u",String.class).getSingleResult();
		Assertions.assertEquals(str, "张飞");
	}
	
	@Test
	public void getEntities() {
		TypedQuery<Usr> query =entityManager.createQuery("select u from Usr u", Usr.class);
        List<Usr> results = query.getResultList();
        Assertions.assertTrue(results.size()>0);	
	}
	
	@Test
	public void delEntity() {
		//entityManager.getTransaction().begin();
		///entityManager.remove(user); 
		//entityManager.getTransaction().commit();
	}
	
	@Test
	public void embedded() {
		Usr usr = entityManager.createQuery("from Usr u where u.id=1", Usr.class).getSingleResult();
		//Assertions.assertEquals("成都",usr.getAddress().getCity());
	}
	
	
}
