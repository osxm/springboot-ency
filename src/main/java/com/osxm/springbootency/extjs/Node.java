/**  
* @Title: Node.java
* @Package com.osxm.springbootency.extjs
* @Description: TODO
* @author XM
* @date 2022年10月9日 下午9:50:03
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.springbootency.extjs;

public class Node {

	public Node(String id,String text) {
		this.id = id;
		this.text = text;
	}
	
	private String id;
	
	private String text;
	
	private boolean leaf;
	
	private boolean expanded;

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
