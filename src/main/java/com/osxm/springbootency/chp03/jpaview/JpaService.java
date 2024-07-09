/**  
* @Title: JpaService.java
* @Package com.osxm.springbootency.chp03.jpaview
* @Description: TODO
* @author XM
* @date 2024年7月9日 下午9:48:58
* @Copyright: 2024
* @version V1.0  
*/
package com.osxm.springbootency.chp03.jpaview;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName JpaService
 * @Description TODO
 * @author XM 
 * @date 2024年7月9日
 * 
 */
@Service
public class JpaService {
	
	@Autowired
	private EntityManager em;
	
	@Transactional
	public void setViewObject() {
		MyUserV myUserV= em.find(MyUserV.class, "user001");
		myUserV.setName("User Change");
	}

}
