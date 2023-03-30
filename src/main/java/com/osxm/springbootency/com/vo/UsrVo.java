/**  
* @Title: UsrVo.java
* @Package com.osxm.springbootency.com.vo
* @Description: TODO
* @author XM
* @date 2022年8月6日 下午6:44:20
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.springbootency.com.vo;

public class UsrVo {
	private int id;
	
	private String name;
	
	
    public int getId() {
		return id;
	}


	public void setId(int id) {
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
		return "name="+name+",id="+id;
	}

}
