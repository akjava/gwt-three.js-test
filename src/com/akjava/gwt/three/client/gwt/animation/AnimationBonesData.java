package com.akjava.gwt.three.client.gwt.animation;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.gwt.GWTThreeUtils;
import com.akjava.gwt.three.client.gwt.ThreeLog;
import com.google.gwt.core.client.JsArray;

public class AnimationBonesData {
	private List<AngleAndMatrix> bonesMatrixs;
	private List<Vector3> baseBonePositions;
	public List<AngleAndMatrix> getBonesAngleAndMatrixs() {
		return bonesMatrixs;
	}

	public void setBonesAngleAndMatrixs(List<AngleAndMatrix> bonesMatrixs) {
		this.bonesMatrixs = bonesMatrixs;
	}
	public static List<Matrix4>  cloneMatrix(List<Matrix4> matrixs){
		List<Matrix4> ret=new ArrayList<Matrix4>();
		for(int i=0;i<matrixs.size();i++){
			ret.add(matrixs.get(i).clone());
		}
		return ret;
	}
	public static List<AngleAndMatrix>  cloneAngleAndMatrix(List<AngleAndMatrix> matrixs){
		List<AngleAndMatrix> ret=new ArrayList<AngleAndMatrix>();
		for(int i=0;i<matrixs.size();i++){
			ret.add(matrixs.get(i).clone());
		}
		return ret;
	}

	JsArray<AnimationBone> bones;
	
	
	public AnimationBonesData(JsArray<AnimationBone> bones,List<AngleAndMatrix> bonesMatrix){
		this.bonesMatrixs=bonesMatrix;
		this.bones=bones;
		bonePath=boneToPath(bones);
		baseBonePositions=boneToPositions(bones);
	}
	public Vector3 getBaseBonePosition(int index){
		return baseBonePositions.get(index);
	}
	public Vector3 getBaseParentBonePosition(int index){
		return baseBonePositions.get(bones.get(index).getParent());
	}
	
	public static List<Vector3> boneToPositions(JsArray<AnimationBone> bones){
		List<Vector3> positions=new ArrayList<Vector3>();
		for(int i=0;i<bones.length();i++){
			AnimationBone bone=bones.get(i);
			Vector3 bpos=AnimationBone.jsArrayToVector3(bone.getPos());
			
			if(bone.getParent()!=-1){
				Vector3 parentPos=positions.get(bone.getParent());
				bpos.addSelf(parentPos);
			}
			
			positions.add(bpos);
			
		}
		return positions;
		
	}
	
	private List<List<Integer>> bonePath;
	
	public int getLength(){
		return bones.length();
	}
	
	public Vector3 getPosition(String name){
		return getPosition(getBoneIndex(name));
	}
	
	
	public Vector3 getPosition(int index){
		List<Integer> path=bonePath.get(index);
		
		Matrix4 tmpmx=bonesMatrixs.get(path.get(path.size()-1)).getMatrix();
		Vector3 pos=THREE.Vector3();
		pos.setPositionFromMatrix(tmpmx);
		
		
		Matrix4 matrix=THREE.Matrix4();
		for(int j=0;j<path.size()-1;j++){//last is boneself
		//	log(""+path.get(j));
			Matrix4 mx=bonesMatrixs.get(path.get(j)).getMatrix();
			matrix.multiply(matrix, mx);
		}
		matrix.multiplyVector3(pos);
		return pos;
	}
	public Vector3 getParentPosition(String name){
		return getParentPosition(getBoneIndex(name));
	}
	//dont call 0(root)
	public Vector3 getParentPosition(int parent){
		int index=bones.get(parent).getParent();
		List<Integer> path=bonePath.get(index);
		
		Matrix4 tmpmx=bonesMatrixs.get(path.get(path.size()-1)).getMatrix();
		Vector3 pos=THREE.Vector3();
		pos.setPositionFromMatrix(tmpmx);
		
		
		Matrix4 matrix=THREE.Matrix4();
		for(int j=0;j<path.size()-1;j++){//last is boneself
		//	log(""+path.get(j));
			Matrix4 mx=bonesMatrixs.get(path.get(j)).getMatrix();
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
	public String getBoneName(int index){
		return bones.get(index).getName();
	}
	
	public AngleAndMatrix getBoneAngleAndMatrix(String name){
		return getBoneAngleAndMatrix(getBoneIndex(name));
	}
	
	public void setBoneAngleAndMatrix(int index,AngleAndMatrix matrix){
		 bonesMatrixs.set(index,matrix);
	}
	
	public AngleAndMatrix getBoneAngleAndMatrix(int index){
		return bonesMatrixs.get(index);
	}
	
	

public static List<AngleAndMatrix> boneToAngleAndMatrix(JsArray<AnimationBone> bones,AnimationData animationData,int index){
		
		List<AngleAndMatrix> boneMatrix=new ArrayList<AngleAndMatrix>();
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
			
			Vector3 rot=GWTThreeUtils.toDegreeAngle(mx2);
			//LogUtils.log("before-angle:"+ThreeLog.get(rot));
			//LogUtils.log(mx2);
			//LogUtils.log(rot);
			Vector3 rotR=GWTThreeUtils.degreeToRagiant(rot);
			//LogUtils.log("rot:"+ThreeLog.get(rotR));
			//LogUtils.log("rot-r:"+ThreeLog.get(GWTThreeUtils.radiantToDegree(rotR)));
			Matrix4 changed=GWTThreeUtils.rotationToMatrix4(rotR);
			
			Vector3 tmpVec=THREE.Vector3();
			tmpVec.setRotationFromMatrix(changed);
			//LogUtils.log("mx:"+ThreeLog.get(tmpVec));
			//LogUtils.log("mx-r:"+ThreeLog.get(GWTThreeUtils.radiantToDegree(tmpVec)));
			
			//LogUtils.log("after-angle:"+ThreeLog.get(GWTThreeUtils.toDegreeAngle(changed)));
			//LogUtils.log(changed);
		
			
			/*
			Vector3 tmpRot=THREE.Vector3();
			tmpRot.setRotationFromMatrix(mx);
			Vector3 tmpPos=THREE.Vector3();
			tmpPos.setPositionFromMatrix(mx);
			*/
			//LogUtils.log(tmpPos.getX()+","+tmpPos.getY()+","+tmpPos.getZ());
			//LogUtils.log(Math.toDegrees(tmpRot.))
			boneMatrix.add(new AngleAndMatrix(motion.getAngle(),mx));
		}
		return boneMatrix;
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
			
			Vector3 rot=GWTThreeUtils.toDegreeAngle(mx2);
			//LogUtils.log("before-angle:"+ThreeLog.get(rot));
			//LogUtils.log(mx2);
			//LogUtils.log(rot);
			Vector3 rotR=GWTThreeUtils.degreeToRagiant(rot);
			//LogUtils.log("rot:"+ThreeLog.get(rotR));
			//LogUtils.log("rot-r:"+ThreeLog.get(GWTThreeUtils.radiantToDegree(rotR)));
			Matrix4 changed=GWTThreeUtils.rotationToMatrix4(rotR);
			
			Vector3 tmpVec=THREE.Vector3();
			tmpVec.setRotationFromMatrix(changed);
			//LogUtils.log("mx:"+ThreeLog.get(tmpVec));
			//LogUtils.log("mx-r:"+ThreeLog.get(GWTThreeUtils.radiantToDegree(tmpVec)));
			
			//LogUtils.log("after-angle:"+ThreeLog.get(GWTThreeUtils.toDegreeAngle(changed)));
			//LogUtils.log(changed);
		
			
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