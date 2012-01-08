package com.akjava.gwt.three.client.gwt.animation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Vector3;
import com.google.gwt.core.client.JsArray;

public class AnimationBonesMatrix {
	private List<Matrix4> bonesMatrix;
	JsArray<AnimationBone> bones;
	Map<String,Matrix4> bonesHash=new HashMap<String,Matrix4>();
	
	public AnimationBonesMatrix(JsArray<AnimationBone> bones,List<Matrix4> bonesMatrix){
		this.bonesMatrix=bonesMatrix;
		this.bones=bones;
		bonePath=boneToPath(bones);
	}
	
	private List<List<Integer>> bonePath;
	
	public int getLength(){
		return bones.length();
	}
	
	public Vector3 getPosition(int index){
		List<Integer> path=bonePath.get(index);
		
		Matrix4 tmpmx=bonesMatrix.get(path.get(path.size()-1));
		Vector3 pos=THREE.Vector3();
		pos.setPositionFromMatrix(tmpmx);
		
		
		Matrix4 matrix=THREE.Matrix4();
		for(int j=0;j<path.size()-1;j++){//last is boneself
		//	log(""+path.get(j));
			Matrix4 mx=bonesMatrix.get(path.get(j));
			matrix.multiply(matrix, mx);
		}
		matrix.multiplyVector3(pos);
		return pos;
	}
	
	public int getBoneIndex(String name){
		for(int i=0;i<bones.length();i++){
			if(bones.get(i).getName().equals(name)){
				return i;
			}
		}
		return -1;
	}
	
	public Matrix4 getBoneMatrix(String name){
		return bonesHash.get(name);
	}
	
	public Matrix4 getBoneMatrix(int index){
		return bonesMatrix.get(index);
	}
	
public static List<Matrix4> boneToMatrix(JsArray<AnimationBone> bones,AnimationData animationData,int index){
		
		List<Matrix4> boneMatrix=new ArrayList<Matrix4>();
		//analyze bone matrix
		
		for(int i=0;i<bones.length();i++){
			
			AnimationHierarchyItem item=animationData.getHierarchy().get(i);
			AnimationKey motion=item.getKeys().get(index);
			
			//log(bone.getName());
			
			Matrix4 mx=THREE.Matrix4();
			Vector3 motionPos=AnimationBone.jsArrayToVector3(motion.getPos());
			//seems same as bone
		//	LogUtils.log(motionPos);
			mx.setTranslation(motionPos.getX(), motionPos.getY(), motionPos.getZ());
			Matrix4 mx2=THREE.Matrix4();
			mx2.setRotationFromQuaternion(motion.getRot());
			mx.multiplySelf(mx2);
			
			/*
			Vector3 tmpRot=THREE.Vector3();
			tmpRot.setRotationFromMatrix(mx);
			Vector3 tmpPos=THREE.Vector3();
			tmpPos.setPositionFromMatrix(mx);
			*/
			//LogUtils.log(tmpPos.getX()+","+tmpPos.getY()+","+tmpPos.getZ());
			//LogUtils.log(Math.toDegrees(tmpRot.))
			boneMatrix.add(mx);
		}
		return boneMatrix;
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
}
