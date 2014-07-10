package com.birlax.traversal;

public class Parent extends GrandParent {

	private int parentId;

	private String parentName;

	private Parent child;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Parent getChild() {
		return child;
	}

	public void setChild(Parent child) {
		this.child = child;
	}

}
