/**
 * @Title: UsrRestController.java
 * @Package com.osxm.springbootency.ceshi
 * @Description: TODO
 * @author oscarchen
 * @date 2021年6月15日
 * @version V1.0
 */
package com.osxm.springbootency.ceshi;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.osxm.springbootency.com.entity.Usr;

/**
  * @ClassName: UsrRestController
  * @Description: TODO
  * @author oscarchen
  */
//@RestController
@RequestMapping("/ceshi/users")
public class UsrRestController {
	
	@Autowired
	private EntityManager em;
	
	//@GetMapping("/{id}")
	@GetMapping(value = "/{id}",produces = "application/json; charset=utf-8")
	public Usr get(@PathVariable int id) {
		return em.createQuery("from Usr where id=:id",Usr.class).setParameter("id", id).getSingleResult();
	}
	
	@GetMapping(value = "/param/{pathv}")
	public void param(@PathVariable int pathv) {
		System.out.println(pathv);
	}

}
