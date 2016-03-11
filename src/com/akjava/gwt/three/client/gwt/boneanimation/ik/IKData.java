package com.akjava.gwt.three.client.gwt.boneanimation.ik;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.math.Vector3;

public class IKData  {
	public IKData(String name){
		this.name=name;
	}
	public void setBones(String[] boneNames){
		bones.clear();
		for(int i=0;i<boneNames.length;i++){
			bones.add(boneNames[i]);
		}
	}
	public String getLastBoneName() {
		return lastBoneName;
	}
	public void setLastBoneName(String lastBoneName) {
		this.lastBoneName = lastBoneName;
	}
	public List<String> getBones() {
		return bones;
	}
	public void setBones(List<String> bones) {
		this.bones = bones;
	}
	public Vector3 getTargetPos() {
		return targetPos;
	}
	public void setTargetPos(Vector3 targetPos) {
		this.targetPos = targetPos;
	}
	public int getIteration() {
		return iteration;
	}
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String lastBoneName;
	private List<String> bones=new ArrayList<String>();;
	private Vector3 targetPos=THREE.Vector3();
	private int iteration=11;
}
