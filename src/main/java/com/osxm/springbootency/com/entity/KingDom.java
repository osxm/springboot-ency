/**  
* @Title: KingDom.java
* @Package com.osxm.springbootency.com.entity
* @Description: TODO
* @author XM
* @date 2021年12月1日 下午9:41:09
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="KING_DOM")
public class KingDom {
	
	@Id
	@Column(name = "ID")
	private long id;
	
	private String name;
	
	private String capital;
	
	//private List<Usr> usrList =new ArrayList<Usr>();

	//@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	//@JoinColumn(name="KINGDOM_ID") 
	//public List<Usr> getUsrList() {
	//	return usrList;
	//}

	//public void setUsrList(List<Usr> usrList) {
	//	this.usrList = usrList;
	//}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

}
