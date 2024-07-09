/**  
* @Title: MyUser.java
* @Package com.osxm.springbootency.chp03.jpaview
* @Description: TODO
* @author XM
* @date 2024年7月9日 下午9:42:54
* @Copyright: 2024
* @version V1.0  
*/
package com.osxm.springbootency.chp03.jpaview;

/**
 * @ClassName MyUser
 * @Description TODO
 * @author XM 
 * @date 2024年7月9日
 * 
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "MY_USER")
@NamedQuery(name = "MyUser.findAll", query = "SELECT e FROM MyUser e")
public class MyUser {

    @Id
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}