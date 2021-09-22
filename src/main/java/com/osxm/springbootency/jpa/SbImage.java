/**
 * @Title: SbImage.java
 * @Package com.osxm.springbootency.jpa
 * @Description: TODO
 * @author oscarchen
 * @date 2021年6月19日
 * @version V1.0
 */
package com.osxm.springbootency.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
  * @ClassName: SbImage
  * @Description: TODO
  * @author oscarchen
  */
@Entity
public class SbImage {

	@Id
	private String name;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "CONTENT", columnDefinition = "BLOB",nullable=true)
	private byte[] content;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private String remark;

	
	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
