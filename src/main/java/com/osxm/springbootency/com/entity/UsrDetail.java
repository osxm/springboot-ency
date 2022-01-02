/**  
* @Title: UsrDetail.java
* @Package com.osxm.springbootency.com.entity
* @Description: TODO
* @author XM
* @date 2021年12月8日 上午6:42:06
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UsrDetail {

	@Id
	private long id;

	private String address;

	private String phone;
	
	@OneToOne(mappedBy = "usrDetail")
	private Usr usr;

	public Usr getUsr() {
		return usr;
	}

	public void setUsr(Usr usr) {
		this.usr = usr;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
