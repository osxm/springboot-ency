/**
 * @Title: Address.java
 * @Package com.osxm.springbootency.com.entity
 * @Description: TODO
 * @author oscarchen
 * @date 2021年6月15日
 * @version V1.0
 */
package com.osxm.springbootency.com.entity;

import javax.persistence.Embeddable;

/**
  * @ClassName: Address
  * @Description: TODO
  * @author oscarchen
  */
@Embeddable
public class Address {

	private String country;
	private String city;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
