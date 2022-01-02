/**
 * @Title: JpaCriteriaTests.java
 * @Package com.osxm.springbootency.jpa
 * @Description: TODO
 * @author oscarchen
 * @date 2021年6月12日
 * @version V1.0
 */
package com.osxm.springbootency.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osxm.springbootency.com.entity.KingDom;
import com.osxm.springbootency.com.entity.Usr;

/**
  * @ClassName: JpaCriteriaTests
  * @Description: TODO
  * @author oscarchen
  */

@SpringBootTest
public class JpaCriteriaTests {
	
	@Autowired
	private EntityManager entityManager;

	//@Test
	public void appendQuery() {
		String sId = "1";
		String hql = "from Usr n where id="+sId;
		List<Usr> usrList = entityManager.createQuery(hql, Usr.class).getResultList();		
		Assertions.assertTrue(usrList.size()==1);
		
		sId = "1 or id !=1";
		hql = "from Usr n where id="+sId;
		usrList = entityManager.createQuery(hql, Usr.class).getResultList();	
		Assertions.assertTrue(usrList.size()>1);
		//Assertions.assertEquals(usrList.get(0).getName(), "刘备");
	}
	
	//@Test
	public void setParameter() {
	    String hql = "from Usr n where n.id=:id";
		//String hql = "from Usr n";
		List<Usr> usrList = entityManager.createQuery(hql, Usr.class).setParameter("id", 1).getResultList();
	    //List<Usr> usrList = entityManager.createQuery(hql, Usr.class).getResultList();
		Assertions.assertEquals(usrList.get(0).getName(), "刘备");
		
		hql = "from Usr n where n.id=?0";
		//hql = "from Usr n where n.id=?";// 已经不支持了
	     usrList = entityManager.createQuery(hql, Usr.class).setParameter(0, 1).getResultList();
		Assertions.assertEquals(usrList.get(0).getName(), "刘备");
		
	}
	
	//@Test 
	public void cretiriaQuery() {
		//1. 通过实体管理器构造条件构造器
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		//2. 通过条件构造器构造条件查询对象
		CriteriaQuery<Usr> criteriaQuery = criteriaBuilder.createQuery(Usr.class);
		//3. 条件查询对象从哪查询， 相对于 from 子句
		Root<Usr> root = criteriaQuery.from(Usr.class);
	    //4. 查询条件的列表 ， 也就是where 子句后面的条件
		Predicate  predicate = criteriaBuilder.equal(root.get("id"),1);
		criteriaQuery.where(predicate); 
		//criteriaQuery.select(root); //查询结果， 相对于 select *
		//5. 使用构造的条件查询对象查询
		List<Usr> usrList = entityManager.createQuery(criteriaQuery).getResultList();
		Assertions.assertEquals(usrList.get(0).getName(), "刘备");
		//Assertions.assertEquals(usrList.get(0).getKingDom().getName(), "蜀");
	}
	
	//@Test
	public void cretiriaQuery2() {
		//1. 通过实体管理器构造条件构造器
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		//2. 通过条件构造器构造条件查询对象
		CriteriaQuery<KingDom> criteriaQuery = criteriaBuilder.createQuery(KingDom.class);
		//3. 条件查询对象从哪查询， 相对于 from 子句
		Root<KingDom> root = criteriaQuery.from(KingDom.class);
	    //4. 查询条件的列表 ， 也就是where 子句后面的条件
		//Predicate  predicate = criteriaBuilder.equal(root.get("id"),1);
		//criteriaQuery.where(predicate); 
		//criteriaQuery.select(root); //查询结果， 相对于 select *
		//5. 使用构造的条件查询对象查询
		List<KingDom> kingDomList = entityManager.createQuery(criteriaQuery).getResultList();
		Assertions.assertEquals(kingDomList.get(0).getName(), "蜀");
		//Assertions.assertEquals(usrList.get(0).getKingdom().getName(), "蜀");
	}
	
	@Test
	public void queryUsrInMysql() {
		//1. 通过实体管理器构造条件构造器
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		//2. 通过条件构造器构造条件查询对象
		CriteriaQuery<Usr> criteriaQuery = criteriaBuilder.createQuery(Usr.class);
		//3. 条件查询对象从哪查询， 相对于 from 子句
		Root<Usr> root = criteriaQuery.from(Usr.class);
	    //4. 查询条件的列表 ， 也就是where 子句后面的条件
		Predicate  predicate = criteriaBuilder.equal(root.get("id"),1);
		criteriaQuery.where(predicate); 
		criteriaQuery.select(root); //查询结果， 相对于 select *
		//5. 使用构造的条件查询对象查询
		List<Usr> usrList = entityManager.createQuery(criteriaQuery).getResultList();
		System.out.println(usrList.size());
		Assertions.assertEquals(usrList.get(0).getName(), "刘备");
		//Assertions.assertEquals(usrList.get(0).getKingDom().getName(), "蜀");
	}
	
	
	
}
