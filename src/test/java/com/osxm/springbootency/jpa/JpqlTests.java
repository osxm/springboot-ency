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
import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.osxm.springbootency.com.entity.Usr;

/**
  * @ClassName: JpqlTests
  * @Description: TODO
  * @author oscarchen
  */
@SpringBootTest
@Transactional
@Rollback(false)
public class JpqlTests {
	
	@Autowired
	private EntityManager entityManager;
	
	//@Test
	public void getCount() {
		Long iCount = entityManager.createQuery("select COUNT(u) from Usr u",Long.class).getSingleResult();
		Assertions.assertTrue(iCount==3);	
	}
	//@Test
	public void getMax() {
		String str = entityManager.createQuery("select Max(u.name) from Usr u",String.class).getSingleResult();
		Assertions.assertEquals(str, "张飞");
	}
	
	//@Test
	public void getEntities() {
		TypedQuery<Usr> query =entityManager.createQuery("select u from Usr u", Usr.class);
        List<Usr> results = query.getResultList();
        Assertions.assertTrue(results.size()>0);	
	}
	
	//@Testq
	public void delEntity() {
		//entityManager.getTransaction().begin();
		///entityManager.remove(user); 
		//entityManager.getTransaction().commit();
	}
	
	//@Test
	public void embedded() {
		Usr usr = entityManager.createQuery("from Usr u where u.id=1", Usr.class).getSingleResult();
		//Assertions.assertEquals("成都",usr.getAddress().getCity());
	}
	
	//@Test
	public void hibernateAutoCreTbl() {
		Assertions.assertTrue(true);	
	}
	
	//@Test
	public void add() {
		//Usr usr = new Usr(1,"张三",1);
		//entityManager.persist(usr);
	}
	
	 //@Test
	public void update() {
		//Usr usr = new Usr(1,"李四",1);
		//entityManager.merge(usr);
	}
	
	//@Test
	public void query() {
		Usr usr = entityManager.createQuery("from Usr u where u.id=1", Usr.class).getSingleResult();
		Assertions.assertEquals(usr.getName(), "李四");
	}
	
	@Test
	public void delete() {
		Usr usr = entityManager.createQuery("from Usr u where u.id=1", Usr.class).getSingleResult();
		entityManager.remove(usr); 
	}
}
