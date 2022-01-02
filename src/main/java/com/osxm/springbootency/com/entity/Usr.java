/**
 * @Title: Usr.java
 * @Package com.osxm.springbootency.com.entity
 * @Description: TODO
 * @author oscarchen
 * @date 2021年6月11日
 * @version V1.0
 */
package com.osxm.springbootency.com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Profile;

/**
 * @ClassName: Usr
 * @Description: TODO
 * @author oscarchen
 */
@Profile({"mysql"})
@Entity
public class Usr {

	@Id

	@Column(name = "ID")
	private long id;

	private String name;
	
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="detailId",referencedColumnName = "id")
	private UsrDetail usrDetail;
	
	@ManyToOne
	private Dept dept;
	
	public UsrDetail getUsrDetail() {
		return usrDetail;
	}

	public void setUsrDetail(UsrDetail usrDetail) {
		this.usrDetail = usrDetail;
	}
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Usr() {

	}
	
	public Usr(String name) {
		this.name = name;
	}
	public Usr(long id,String name) {
		this.id = id;
		this.name = name;
	}

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



	@Override
	public String toString() {
		return "name="+name+",dept="+dept.getName();
	}
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsrId")
	//@SequenceGenerator(name = "seqUsrId", sequenceName = "SEQ_USR_ID ", allocationSize = 1)
	
	//private long deptId;
	
		//@ManyToOne(fetch=FetchType.LAZY)//关联的对象，采用懒加载查询
		//@ManyToOne(fetch=FetchType.EAGER)
		//@JoinColumn(name="KINGDOM_ID" )//指定在多方表中的外键列名称
		//@JoinColumn(name="kingdomid",referencedColumnName = "id")
		//@ManyToOne
		//private KingDom kingDom;

		/*public KingDom getKingdom() {
			return kingdom;
		}

		public void setKingdom(KingDom kingdom) {
			this.kingdom = kingdom;
		}*/


		/*public KingDom getKingDom() {
			return kingDom;
		}

		public void setKingDom(KingDom kingDom) {
			this.kingDom = kingDom;
		}*/


		//private String phone;

		//@Embedded
		//private Address address;

		/*public long getDeptId() {
			return deptId;
		}

		public void setDeptId(long deptId) {
			this.deptId = deptId;
		}*/

}
