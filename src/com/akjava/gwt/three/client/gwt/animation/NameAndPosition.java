package com.akjava.gwt.three.client.gwt.animation;

import com.akjava.gwt.three.client.core.Vector3;

public class NameAndPosition {
private String name;
private Vector3 position;
private int index;
public int getIndex() {
	return index;
}
public void setIndex(int index) {
	this.index = index;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Vector3 getPosition() {
	return position;
}
public void setPosition(Vector3 position) {
	this.position = position;
}
public NameAndPosition(String name,Vector3 position,int index){
	this.name=name;
	this.position=position;
	this.index=index;
}
}
