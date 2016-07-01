package com.akjava.gwt.three.client.java.bone;

public class DistanceData implements Comparable<DistanceData> {
private int boneIndex;
public DistanceData(int boneIndex, double distance) {
	super();
	this.boneIndex = boneIndex;
	this.distance = distance;
}
private double distance;
public int getBoneIndex() {
	return boneIndex;
}
public void setBoneIndex(int boneIndex) {
	this.boneIndex = boneIndex;
}
public double getDistance() {
	return distance;
}
public void setDistance(double distance) {
	this.distance = distance;
}
@Override
public int compareTo(DistanceData o) {
	if(this.distance<o.distance){
		return -1;
	}else if(this.distance==o.distance){
		return 0;
	}else{
		return 1;
	}
}
public String toString(){
	return "boneIndex="+boneIndex+",distance="+distance;
}
}
