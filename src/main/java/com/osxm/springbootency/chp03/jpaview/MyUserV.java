/**  
* @Title: MyUserV.java
* @Package com.osxm.springbootency.chp03.jpaview
* @Description: TODO
* @author XM
* @date 2024年7月9日 下午9:43:42
* @Copyright: 2024
* @version V1.0  
*/
package com.osxm.springbootency.chp03.jpaview;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @ClassName MyUserV
 * @Description TODO
 * @author XM 
 * @date 2024年7月9日
 * 
 */
public class MyUserV {
	@Id
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
