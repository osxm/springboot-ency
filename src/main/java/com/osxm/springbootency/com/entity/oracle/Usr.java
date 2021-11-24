/**  
* @Title: Usr.java
* @Package com.osxm.springbootency.com.entity.oracle
* @Description: TODO
* @author XM
* @date 2021年9月22日 下午10:24:25
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.com.entity.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Profile;

/**
 * @ClassName Usr
 * @Description TODO
 * @author XM 
 * @date 2021年9月22日
 * 
 */
@Profile("withdb")
@Entity(name="USR2")
public class Usr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "id="+id+",name="+name;
	}
}
