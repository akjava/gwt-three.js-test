package com.akjava.gwt.three.client.java.bone;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.three.client.gwt.boneanimation.AnimationBone;
import com.akjava.gwt.three.client.java.ThreeLog;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.math.Vector4;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gwt.core.client.JsArray;

/*
 * not support initial bone-matrix
 */
public class SimpleAutoWeight {
private int influence;


public SimpleAutoWeight(int influence){
	checkArgument(influence>0 && influence<=4,"influence 1-4");
	this.influence=influence;
}



public static  List<List<Integer>> boneToPath(JsArray<AnimationBone> bones){
	List<List<Integer>> data=new ArrayList<List<Integer>>();
	for(int i=0;i<bones.length();i++){
		List<Integer> path=new ArrayList<Integer>();
		AnimationBone bone=bones.get(i);
		path.add(i);
		data.add(path);
		while(bone.getParent()!=-1){
			//path.add(bone.getParent());
			path.add(0,bone.getParent());
			bone=bones.get(bone.getParent());
		}
	}
	return data;
}


public List<Vector3> convertAbsolutePosition(JsArray<AnimationBone> bones){
	List<Vector3> bonePositions=Lists.newArrayList();
	for(int j=0;j<bones.length();j++){//TODO make a function
		AnimationBone ab=bones.get(j);
		Vector3 bonePos=THREE.Vector3().fromArray(ab.getPos());
		bonePositions.add(bonePos);
	}
	return convertAbsolutePosition(bonePositions, boneToPath(bones));
}

//no care about rotate matrix
private List<Vector3> convertAbsolutePosition(List<Vector3> positions,List<List<Integer>> paths){
	List<Vector3> absolutePositions=Lists.newArrayList();
	checkArgument(positions.size()==paths.size(),"sumPosition:must be same");
	
	for(int i=0;i<paths.size();i++){
		Vector3 pos=THREE.Vector3();
		List<Integer> path=paths.get(i);
		for(int index:path){
			pos.add(positions.get(index));
		}
		absolutePositions.add(pos);
	}
	
	
	return absolutePositions;
}

public WeightResult autoWeight(Geometry geometry,JsArray<AnimationBone> bones){
	return autoWeight(geometry, bones,Lists.<Integer>newArrayList());
}

private List<Integer> enableBones;

public SimpleAutoWeight enableBones(List<Integer> enableBones){
	this.enableBones=enableBones;
	return this;
}

/*
 * some case no need root,suchc case add 0 to ignore
 * 
 * TODO ignore root option usually root 0 ignored
 */
public WeightResult autoWeight(Geometry geometry,JsArray<AnimationBone> bones,List<Integer> ignoreBones){
	List<Vector3> bonePositions=Lists.newArrayList();
	
	JsArray<Vector4> bodyIndicesArray=JavaScriptUtils.createJSArray();
	 JsArray<Vector4> bodyWeightArray=JavaScriptUtils.createJSArray();
	 
	for(int j=0;j<bones.length();j++){//TODO make a function
		AnimationBone ab=bones.get(j);
		Vector3 bonePos=THREE.Vector3().fromArray(ab.getPos());
		bonePositions.add(bonePos);
	
		//ThreeLog.log("bone:"+j,bonePos);
	}
	
	List<Vector3> absolutePositions=convertAbsolutePosition(bonePositions,boneToPath(bones));
	
	for(int j=0;j<bones.length();j++){
		//ThreeLog.log("ab:"+j,absolutePositions.get(j));
	}
	
	
	//LogUtils.log("bones:"+bonePositions.size()+",vertices:"+geometry.getVertices().length());
	
	for(int i=0;i<geometry.getVertices().length();i++){
		List<DistanceData> distanceDatas=Lists.newArrayList();
		Vector3 vertex=geometry.getVertices().get(i);
		
		//ThreeLog.log("vertex:"+i,vertex);
		
		for(int j=0;j<absolutePositions.size();j++){
			
			double distance=absolutePositions.get(j).distanceTo(vertex);
			if(ignoreBones.contains(j)){
				distance=Double.MAX_VALUE;
			}
			
			if(enableBones!=null && !enableBones.contains(j)){
				distance=Double.MAX_VALUE;
			}
			
			
			distanceDatas.add(new DistanceData(j, distance));
		}
		//sort
		java.util.Collections.sort(distanceDatas);
		if(i==0){
		//	LogUtils.log(Joiner.on("\n").join(distanceDatas));
		}
		
		Vector4 vector4=THREE.Vector4(0,0,0,0);
		
		
		
		for(int k=0;k<influence;k++){
			vector4.gwtSet(k,distanceDatas.get(k).getDistance());
		}
		
		if(i==121){
		//	ThreeLog.log("distance",vector4);
		}
		
		vector4.normalize();
		if(i==121){
		//	ThreeLog.log("normalized",vector4);
		}
		
		double total=0;
		for(int k=0;k<influence;k++){
			total+=vector4.gwtGet(k);
		}
		
		for(int k=0;k<influence;k++){
			vector4.gwtSet(k,vector4.gwtGet(k)/total);
		}
		
		//TODO make test
		
		//switch value
		for(int k=0;k<influence;k++){
			vector4.gwtSet(k,1-vector4.gwtGet(k));
		}
		
		if(i==121){
		//	ThreeLog.log("clone one is bigger",vector4);
		}
		
		double total2=0;
		for(int k=0;k<influence;k++){
			total2+=vector4.gwtGet(k);
		}
		
		for(int k=0;k<influence;k++){
			vector4.gwtSet(k,vector4.gwtGet(k)/total2);
		}
		
		//if multiple 0 exist,but no need solve divided total
		//vector4.normalize();
		
		
		
		
		
		
		//NaN on JavaScript
		//LogUtils.log("test:"+(1-(0/0)));
		
		
		
		if(i==121){
		//	ThreeLog.log("modify total",vector4);
		}
		
		
		if(influence==1){
			vector4.gwtSet(0,1);
		}
		
		
		Vector4 bodyIndices=THREE.Vector4(0,0,0,0);
		for(int k=0;k<influence;k++){
			bodyIndices.gwtSet(k, distanceDatas.get(k).getBoneIndex());
			
			//LogUtils.log("vertex="+i+",index="+distanceDatas.get(k).getBoneIndex()+",distance="+distanceDatas.get(k).getDistance());
		}
		
		bodyWeightArray.push(vector4);
		bodyIndicesArray.push(bodyIndices);
		
		
	}
	
	return new WeightResult(bodyIndicesArray, bodyWeightArray).setInfluence(influence);
}



//TODO make independent class


}
