/**
 * @Title: JpaQueryTests.java
 * @Package com.osxm.springbootency.jpa
 * @Description: TODO
 * @author oscarchen
 * @date 2021年6月11日
 * @version V1.0
 */
package com.osxm.springbootency.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.osxm.springbootency.com.entity.Usr;

/**
  * @ClassName: JpaQueryTests
  * @Description: TODO
  * @author oscarchen
  */
@SpringBootTest
public class JpaQueryTests {

	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void simpleQuery() {
		String hql = "from Usr n";
		List<Usr> list = entityManager.createQuery(hql,Usr.class).getResultList(); 	//如果为空， 返回 []， 而不是null
		Assertions.assertNotNull(list);		
	}
	
	
	@Test
	public void getSingleResult() {
		String hql = "from Usr n";
		Usr usr = null;
		List<Usr> list = entityManager.createQuery(hql,Usr.class).getResultList();
        if(list.size()>0) { //可以不判断为null
        	 usr = list.get(0);
        }
		
		//usr = entityManager.createQuery(hql,Usr.class).getSingleResult(); //没找到抛异常， 找到多个也会抛异常
		Assertions.assertNotNull(usr);		
	}
	
	@Test
	public void getCount() {
		String hql = "select count(n) from Usr n";
		long lCount = entityManager.createQuery(hql,Long.class).getSingleResult();
		Assertions.assertEquals(lCount, 3);
	}
	
	
	
	@Test
	public void getAttrsList() {
		String hql = "select name from Usr n";
		List<String> nameList = entityManager.createQuery(hql,String.class).getResultList();
		for(String name:nameList) {
			
		}
	}
	
	@Test
	public void nativeQuery() {
		String sql = "select * from USR";
		List<Usr> list = entityManager.createNativeQuery(sql, Usr.class).getResultList();
		System.out.println("==============begin nativeQuery==============");
		for(Usr usr:list) {
			System.out.println(usr.getName());
		}
		
		list = entityManager.createNativeQuery(sql).getResultList();
		for(Object row:list) {
			Object[] cells = (Object[])row;
			System.out.println(cells[0]+":"+cells[1]);
		}
		System.out.println("==============end nativeQuery==============");
	}
	
	
	
	
	@Test
	public void getSingleResult2() {
		String hql = "from Usr n where id=4";
		List<Usr> list = entityManager.createQuery(hql,Usr.class).getResultList(); //没找到则返回不包含元素的集合
		Assertions.assertTrue(list.size()==0); 
		
	}
}
