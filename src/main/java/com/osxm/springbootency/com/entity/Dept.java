/**  
* @Title: Dept.java
* @Package com.osxm.springbootency.com.entity.mysql
* @Description: TODO
* @author XM
* @date 2021年12月4日 上午8:20:42
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.com.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Profile;

@Profile({"mysql"})
@Entity
public class Dept {
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="dept_id")
	private Set<Usr> usrs =  new HashSet<Usr>(); 
	
	
	public Dept() {
		
	}
	public Set<Usr> getUsrs() {
		return usrs;
	}

	public void setUsrs(Set<Usr> usrs) {
		this.usrs = usrs;
	}

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

}
