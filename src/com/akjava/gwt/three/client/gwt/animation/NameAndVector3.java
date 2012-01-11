package com.akjava.gwt.three.client.gwt.animation;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.core.Vector3;

public class NameAndVector3 {
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
public Vector3 getVector3() {
	return position;
}
public void setVector3(Vector3 position) {
	this.position = position;
}
public NameAndVector3(String name,double x,double y,double z){
	this(name,THREE.Vector3(x, y, z),0);
}

public NameAndVector3(String name,Vector3 position){
	this(name,position,0);
}
public NameAndVector3(String name,Vector3 position,int index){
	this.name=name;
	this.position=position;
	this.index=index;
}
}
