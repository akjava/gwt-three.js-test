package com.akjava.gwt.three.client.gwt.animation;

import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.math.Vector3;

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

public String toString(){
	return name+","+index+","+position;
}

@Override
public boolean equals(Object object){
	NameAndVector3 target=null;
	if(object instanceof NameAndVector3){
		target=(NameAndVector3)object;
	}else{
		return false;
	}
	if(name==null){
	if(target.getName()!=null){
		return false;
	}
	}else{
	if(!name.equals(target.getName())){
		return false;
	}
	}
	
	if(index!=target.getIndex()){
		return false;
	}
	if(index!=target.getIndex()){
		return false;
	}
	if(position==null){
		if(target.getVector3()!=null){
			return false;
		}
	}else{
		if(target.getVector3()==null){
			return false;
		}else{
			if(position.getX()!=target.getVector3().getX() || position.getY()!=target.getVector3().getY() ||position.getZ()!=target.getVector3().getZ()){
				return false;
			}
		}
	}
	
	return true;
}

}
