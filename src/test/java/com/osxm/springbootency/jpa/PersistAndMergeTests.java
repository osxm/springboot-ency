/**  
* @Title: PersistAndMergeTests.java
* @Package com.osxm.springbootency.jpa
* @Description: TODO
* @author XM
* @date 2021年12月6日 上午6:58:37
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.jpa;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.osxm.springbootency.com.entity.Usr;

@SpringBootTest
@Transactional
@Rollback(false)
public class PersistAndMergeTests {
	
	@Autowired
	private EntityManager entityManager;

	//@Test
	public void persist() {
		Usr usr = new Usr(1,"张三");
		entityManager.persist(usr);  
		usr.setName("李四");
		//事务结束， 对Name属性的修改更新到数据库
		Assertions.assertTrue("李四".equals(usr.getName()));
	}
	
	//@Test
	public void merge() {
		Usr usr = new Usr(1,"张三");	
		entityManager.merge(usr);   // 用户名  张三
		usr.setName("李四");
		//事务结束， 对Name属性的修改不会更新到数据库，数据库中的名字还是张三
	
	}
	
	@Test
	public void merge2() {
		Usr usr = new Usr(1,"张三");	
		Usr usr2 = entityManager.merge(usr);   // 用户名  张三
		usr2.setName("李四");
	
	}
	
	//Usr usr = entityManager.createQuery("from Usr u where u.id=1", Usr.class).getSingleResult();
}
