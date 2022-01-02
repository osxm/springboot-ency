/**  
* @Title: SpecificationTests.java
* @Package com.osxm.springbootency.jpa
* @Description: TODO
* @author XM
* @date 2021年12月8日 下午9:28:24
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.jpa;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import com.osxm.springbootency.com.entity.Usr;

@SpringBootTest
public class SpecificationTests {

	@Autowired
	private UsrRepository usrDao;

	@SuppressWarnings("serial")
	//@Test
	public void queryBySpecification() {
		Specification<Usr> spec = new Specification<Usr>() {
			@Override
			public Predicate toPredicate(Root<Usr> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.获取比较的属性
				Path<Object> custId = root.get("id");
				// 2.构造查询条件
				Predicate predicate = cb.equal(custId, 1);
				return predicate;
			}
		};
		Optional<Usr> usr = usrDao.findOne(spec);
		System.out.println(usr.get());
	}
	
	@Test
	public void queryBySpecificationLamba() {
		//Specification<Usr> spec = (root,query,cb) -> {return cb.equal(root.get("id"),1);};
		Specification<Usr> spec = (root,query,cb) -> cb.equal(root.get("id"),1);
		Optional<Usr> usr = usrDao.findOne(spec);
		System.out.println(usr.get());
		
		usr = usrDao.findOne((root,query,cb) -> cb.equal(root.get("id"),1));
		System.out.println(usr.get());
	}
}
