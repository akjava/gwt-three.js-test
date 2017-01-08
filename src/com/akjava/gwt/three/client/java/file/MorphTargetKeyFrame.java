package com.akjava.gwt.three.client.java.file;


public class MorphTargetKeyFrame {

	/**
	 * possible not exist in morphtarget
	 */
	private String keyName;

public MorphTargetKeyFrame(String keyName, double time, double value) {
		super();
		this.keyName = keyName;
		this.time = time;
		this.value = value;
	}
/**
 * millisecond base.
 */

public String toString(){
	return keyName+":"+time+":"+value;
}

private double time;

public String getKeyName() {
	return keyName;
}
public void setKeyName(String keyName) {
	this.keyName = keyName;
}
public double getTime() {
	return time;
}
public void setTime(double time) {
	this.time = time;
}
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}
/*
 * some key,need fix for fitting model
 */
private double value;
}
