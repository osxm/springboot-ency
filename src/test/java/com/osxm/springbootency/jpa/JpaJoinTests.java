/**  
* @Title: JpaJoinTest.java
* @Package com.osxm.springbootency.jpa
* @Description: TODO
* @author XM
* @date 2021年12月4日 上午8:19:51
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.jpa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.osxm.springbootency.com.entity.Dept;
import com.osxm.springbootency.com.entity.Usr;
import com.osxm.springbootency.com.entity.UsrDetail;

@SpringBootTest
@Transactional
@Rollback(false)
public class JpaJoinTests {

	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void creTables() {
		
	}
	
	//@Test 
	public void addDept() {
		Dept dept = new Dept();
		HashSet<Usr> usrs = new HashSet<Usr>();
		Usr usr = new Usr();
		usr.setId(1);
		usr.setName("张三");
		usrs.add(usr);
		dept.setId(1);
		dept.setName("HR");
		dept.setUsrs(usrs);
		entityManager.persist(dept);
	}
	
	//@Test
	public void queryDept() {
		Dept dept = entityManager.createQuery("from Dept d",Dept.class).getSingleResult();
		Set<Usr> usrs  = dept.getUsrs();
		Iterator<Usr> it = usrs.iterator();
		while(it.hasNext()) {
			Usr usr = (Usr) it.next();
			System.out.println(usr.getName());
		}
	}
	
	//@Test
	public void queryUsr() {
		Usr usr = entityManager.createQuery("from Usr u where u.id=2",Usr.class).getSingleResult();
		System.out.println(usr.getUsrDetail().getPhone());
		System.out.println(usr.toString());
	}
	
	//@Test
	public void oneToOneAdd() {
		Usr usr = new Usr();
		usr.setId(2);
		usr.setName("李四");
		UsrDetail usrDetail = new UsrDetail();
		usrDetail.setId(1);
		usrDetail.setPhone("123");
		usr.setUsrDetail(usrDetail);
		entityManager.persist(usr);
	}
	
	/**
	 * 非关系维护方
	 */
	
	@Test
	public void oneToOneQuery() {
		UsrDetail usrDetail = entityManager.createQuery("from UsrDetail u where u.id=1",UsrDetail.class).getSingleResult();
		System.out.println(usrDetail.getUsr().getName());
			
	}
	
}
