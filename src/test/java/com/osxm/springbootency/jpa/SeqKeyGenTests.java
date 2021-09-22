/**
 * @Title: SeqKeyGenTests.java
 * @Package com.osxm.springbootency.jpa
 * @Description: TODO
 * @author oscarchen
 * @date 2021年7月25日
 * @version V1.0
 */
package com.osxm.springbootency.jpa;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.osxm.springbootency.com.entity.Usr;

/**
 * @ClassName: SeqKeyGenTests
 * @Description: TODO
 * @author oscarchen
 */
@SpringBootTest
public class SeqKeyGenTests {
	
	@Autowired
	private EntityManager entityManager;

	@Test
	@Transactional
	@Rollback(false)
	public void addUsr() {
		Usr usr = new Usr("刘备");
		entityManager.persist(usr);
	}

}
