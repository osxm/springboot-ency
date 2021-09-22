/**
 * @Title: Usr.java
 * @Package com.osxm.springbootency.com.entity
 * @Description: TODO
 * @author oscarchen
 * @date 2021年6月11日
 * @version V1.0
 */
package com.osxm.springbootency.com.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @ClassName: Usr
 * @Description: TODO
 * @author oscarchen
 */
@Entity
public class Usr {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsrId")
	@SequenceGenerator(name = "seqUsrId", sequenceName = "SEQ_USR_ID ", allocationSize = 1)
	@Column(name = "ID")
	private long id;

	private String name;

	private String phone;


	@Embedded
	private Address address;

	public Usr() {

	}

	public Usr(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
    }

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
