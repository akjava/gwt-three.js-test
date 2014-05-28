package com.akjava.gwt.three.client.java.animation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.gwt.animation.AnimationBone;
import com.akjava.gwt.three.client.gwt.animation.NameAndVector3;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.math.Vector4;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Window;

/**
 * creating 2-bone indices and weight from geometry and bone position.
 * some algorithm is totally experimental.
 * @author aki
 *
 */
public class WeightBuilder {
public static final int MODE_NearSingleBone=0;
public static final int MODE_NearSpecial=1;
public static final int MODE_NearAgressive=2;
public static final int MODE_NearParentAndChildren=3;
public static final int MODE_NearParentAndChildrenAgressive=5;
public static final int MODE_MODE_Start_And_Half_ParentAndChildrenAgressive=6;
public static final int MODE_FROM_GEOMETRY=4;	//use geometry own 
public static final int MODE_ROOT_ALL=7;	
public static final int MODE_MAKEHUMAN=8;	//special for makehuman model

public static final String KEY_HALF="_half_";
public static final String KEY_ENDSITE="_ENDSITE_";
public static final String KEY_END="_end_";
public static final String KEY_START="_start_";
	public static Vector4 findNearSingleBone(List<NameAndVector3> nameAndPositions,Vector3 pos,JsArray<AnimationBone> bones){
		Vector3 pt=nameAndPositions.get(0).getVector3().clone();
		Vector3 near=pt.sub(pos);
		int index1=nameAndPositions.get(0).getIndex();
		double near1=pt.length();

		for(int i=1;i<nameAndPositions.size();i++){
			Vector3 npt=nameAndPositions.get(i).getVector3().clone();
			near=npt.sub(pos);
			double l=near.length();
			if(l<near1){
				index1=nameAndPositions.get(i).getIndex();
				near1=l;
			}
		}
		return THREE.Vector4(index1,index1,1,0);
	}
	
	
	public static Vector4 findNearBoneParentAndChildren(List<NameAndVector3> nameAndPositions,Vector3 pos,JsArray<AnimationBone> bones,int xloop){
		Vector3 pt=nameAndPositions.get(0).getVector3().clone();
		Vector3 near=pt.sub(pos);
		int index1=nameAndPositions.get(0).getIndex();
		double near1=pt.length();
		int index2=nameAndPositions.get(0).getIndex();
		double near2=pt.length();
		
		//First Bone must real bone.
		for(int i=1;i<nameAndPositions.size();i++){
			if(nameAndPositions.get(i).getName().startsWith(KEY_HALF)){
				continue;
			}
			Vector3 npt=nameAndPositions.get(i).getVector3().clone();
			near=npt.sub(pos);
			double l=near.length();
			if(l<near1){
				int tmp=index1;
				double tmpL=near1;
				index1=nameAndPositions.get(i).getIndex();
				near1=l;
				if(tmpL<near2){
					index2=tmp;
					near2=tmpL;
				}
			}else if(l<near2){
				index2=nameAndPositions.get(i).getIndex();
				near2=l;
			}
		}
		
		int indexHalf=-1;
		double nearHalf=0;
		for(int i=1;i<nameAndPositions.size();i++){
			if(!nameAndPositions.get(i).getName().startsWith(KEY_HALF)){
				continue;
			}
			Vector3 npt=nameAndPositions.get(i).getVector3().clone();
			near=npt.sub(pos);
			double l=near.length();
			if(l<near1){
				indexHalf=nameAndPositions.get(i).getIndex();
				nearHalf=l;
			}else if(l<near2){
				indexHalf=nameAndPositions.get(i).getIndex();
				nearHalf=l;
			}
		}
		
		
		
		if(indexHalf!=-1){
			if(bones.get(index1).getParent()==indexHalf || bones.get(indexHalf).getParent()==index1 ||indexHalf==index1){
				index2=indexHalf;
				near2=nearHalf;
			}
		}
		
		//only child & parent
		/*
		 * TODO future support
		 * 
		
		*/
		
		//near1*=near1*near1*near1;
		//near2*=near2*near2*near2;
		
		
		for(int i=0;i<xloop;i++){
			near1*=near1;
			near2*=near2;
		}
		
		if(index1==index2){
			return THREE.Vector4(index1,index1,1,0);
		}else{
			
			double total=near1+near2;
			return THREE.Vector4(index1,index2,(total-near1)/total,(total-near2)/total);
		}
	}
	
	public static Vector4 findNearBoneStartAndHalfParentAndChildren(List<NameAndVector3> nameAndPositions,Vector3 pos,JsArray<AnimationBone> bones,int xloop){
		//LogUtils.log("findNearBoneStartAndHalfParentAndChildren");
		Vector3 pt=nameAndPositions.get(0).getVector3().clone();
		Vector3 near=pt.sub(pos);
		int index1=nameAndPositions.get(0).getIndex();
		double near1=pt.length();
		int index2=nameAndPositions.get(0).getIndex();
		double near2=pt.length();
		
		//First Bone must real bone.
		for(int i=1;i<nameAndPositions.size();i++){
			if(nameAndPositions.get(i).getName().startsWith(KEY_END)){
				continue;
			}
			Vector3 npt=nameAndPositions.get(i).getVector3().clone();
			near=npt.sub(pos);
			double l=near.length();
			if(l<near1){
				int tmp=index1;
				double tmpL=near1;
				index1=nameAndPositions.get(i).getIndex();
				near1=l;
				if(tmpL<near2){
					index2=tmp;
					near2=tmpL;
				}
			}else if(l<near2){
				index2=nameAndPositions.get(i).getIndex();
				near2=l;
			}
		}
		
		/*
		int indexHalf=-1;
		double nearHalf=0;
		for(int i=1;i<nameAndPositions.size();i++){
			if(nameAndPositions.get(i).getName().startsWith(KEY_END)){
				continue;
			}
			Vector3 npt=nameAndPositions.get(i).getVector3().clone();
			near=npt.sub(pos);
			double l=near.length();
			if(l<near1){
				indexHalf=nameAndPositions.get(i).getIndex();
				nearHalf=l;
			}else if(l<near2){
				indexHalf=nameAndPositions.get(i).getIndex();
				nearHalf=l;
			}
		}
		
		
		
		
		if(indexHalf!=-1){
			if(bones.get(index1).getParent()==indexHalf || bones.get(indexHalf).getParent()==index1 ||indexHalf==index1){
				index2=indexHalf;
				near2=nearHalf;
			}
		}
		*/
		
		//only child & parent
		/*
		 * TODO future support
		 * 
		
		*/
		
		//near1*=near1*near1*near1;
		//near2*=near2*near2*near2;
		
		
		for(int i=0;i<xloop;i++){
			near1*=near1;
			near2*=near2;
		}
		
		if(index1==index2){
			return THREE.Vector4(index1,index1,1,0);
		}else{
			
			double total=near1+near2;
			return THREE.Vector4(index1,index2,(total-near1)/total,(total-near2)/total);
		}
	}
	
	
	
	public static Vector4 findNearBoneAggresive(List<NameAndVector3> nameAndPositions,Vector3 pos,JsArray<AnimationBone> bones){
		Vector3 pt=nameAndPositions.get(0).getVector3().clone();
		Vector3 near=pt.sub(pos);
		int index1=nameAndPositions.get(0).getIndex();
		double near1=pt.length();
		int index2=nameAndPositions.get(0).getIndex();
		double near2=pt.length();
		
		
		for(int i=1;i<nameAndPositions.size();i++){
			Vector3 npt=nameAndPositions.get(i).getVector3().clone();
			near=npt.sub(pos);
			double l=near.length();
			if(l<near1){
				int tmp=index1;
				double tmpL=near1;
				index1=nameAndPositions.get(i).getIndex();
				near1=l;
				if(tmpL<near2){
					index2=tmp;
					near2=tmpL;
				}
			}else if(l<near2){
				index2=nameAndPositions.get(i).getIndex();
				near2=l;
			}
		}
		near1*=near1*near1*near1;
		near2*=near2*near2*near2;
		
		//only child & parent
		/*
		 * TODO future support
		 * 
		if(bones.get(index1).getParent()!=index2 && bones.get(index2).getParent()!=index1){
			index2=index1;
		}
		*/
		
		
		if(index1==index2){
			return THREE.Vector4(index1,index1,1,0);
		}else{
			
			double total=near1+near2;
			return THREE.Vector4(index1,index2,(total-near1)/total,(total-near2)/total);
		}
	}
	

public static Vector4 findNearSpecial(List<NameAndVector3> nameAndPositions,Vector3 pos,JsArray<AnimationBone> bones,int vindex){
	
	Vector3 pt=nameAndPositions.get(0).getVector3().clone();
	Vector3 near=pt.sub(pos);
	int index1=nameAndPositions.get(0).getIndex();
	double near1=near.length();
	int index2=index1;
	double near2=near1;
	
	int nameIndex1=0;
	int nameIndex2=0;
	
	for(int i=1;i<nameAndPositions.size();i++){
		Vector3 npt=nameAndPositions.get(i).getVector3().clone();
		Vector3 subPos=npt.sub(pos);
		double l=subPos.length();
		//if(vindex==250)log(nameAndPositions.get(i).getName()+","+l);
		
		if(l<near1){
			int tmp=index1;
			double tmpL=near1;
			int tmpName=nameIndex1;
			
			index1=nameAndPositions.get(i).getIndex();
			near1=l;
			nameIndex1=i;
			if(tmpL<near2){
				index2=tmp;
				near2=tmpL;
				nameIndex2=tmpName;
			}
		}else if(l<near2){
			index2=nameAndPositions.get(i).getIndex();
			near2=l;
			nameIndex2=i;
		}
	}
	
	
	
		
		Map<Integer,Double> totalLength=new HashMap<Integer,Double>();
		Map<Integer,Integer> totalIndex=new HashMap<Integer,Integer>();
		
		//zero is largest
		Vector3 rootNear=nameAndPositions.get(0).getVector3().clone();
		rootNear.sub(pos);
		
		
		
		for(int i=0;i<nameAndPositions.size();i++){
			int index=nameAndPositions.get(i).getIndex();
			Vector3 nearPos=nameAndPositions.get(i).getVector3().clone();
			nearPos.sub(pos);
			double l=nearPos.length();
			
			Double target=totalLength.get(index);
			double cvalue=0;
			if(target!=null){
				cvalue=target.doubleValue();
			}
			cvalue+=l;
			
			totalLength.put(index,cvalue);
			
			
			
			Integer count=totalIndex.get(index);
			int countV=0;
			if(count!=null){
				countV=count;
			}
			countV++;
			totalIndex.put(index, countV);
		}
		
		
		//do average for end like head
		Integer[] keys=totalLength.keySet().toArray(new Integer[0]);
		for(int i=0;i<keys.length;i++){
			int index=keys[i];
			int count=totalIndex.get(index);
			totalLength.put(index, totalLength.get(index)/count);
		}
		
		if(index1==index2){
			return THREE.Vector4(index1,index1,1,0);
		}else{
			double near1Length=totalLength.get(index1);
			double near2Length=totalLength.get(index2);
			
			double total=near1Length+near2Length;
			return THREE.Vector4(index1,index2,(total-near1Length)/total,(total-near2Length)/total);
		}
		
	}



public static void autoWeight(Geometry geometry,JsArray<AnimationBone> bones,List<List<Vector3>> endSites,int mode,JsArray<Vector4> bodyIndices,JsArray<Vector4> bodyWeight){
	List<NameAndVector3> nameAndPositions=boneToNameAndPosition(bones,endSites);
	for(int i=0;i<geometry.vertices().length();i++){
		Vector4 ret=null;
		if(mode==MODE_NearSingleBone){
		ret=findNearSingleBone(nameAndPositions,geometry.vertices().get(i),bones);
		}else if(mode==MODE_NearSpecial){
			ret=findNearSpecial(nameAndPositions,geometry.vertices().get(i),bones,i);	
		}else if(mode==MODE_NearAgressive){
			ret=findNearBoneAggresive(nameAndPositions,geometry.vertices().get(i),bones);	
		}else if(mode==MODE_NearParentAndChildren){
			ret=findNearBoneParentAndChildren(nameAndPositions,geometry.vertices().get(i),bones,2);	
		}else if(mode==MODE_NearParentAndChildrenAgressive){
			ret=findNearBoneParentAndChildren(nameAndPositions,geometry.vertices().get(i),bones,3);	
		}else if(mode==MODE_MODE_Start_And_Half_ParentAndChildrenAgressive){
			ret=findNearBoneStartAndHalfParentAndChildren(nameAndPositions,geometry.vertices().get(i),bones,3);	
		}else if(mode==MODE_FROM_GEOMETRY){
			ret=fromGeometry(geometry,i);	
		}else if(mode==MODE_ROOT_ALL){
			ret=THREE.Vector4(0,0,1,0);	
		}else if(mode==MODE_MAKEHUMAN){
			ret=makehuman(nameAndPositions,bones,geometry,i);	
		}else{
			Window.alert("null mode");
		}
		
		//now support only 2 bones
		Vector4 v4=THREE.Vector4();
		v4.set(ret.getX(), ret.getY(), 0, 0);
		bodyIndices.push(v4);
		
		Vector4 v4w=THREE.Vector4();
		v4w.set(ret.getZ(), ret.getW(), 0, 0);
		bodyWeight.push(v4w);
		}
	}


  public static Vector4 makehuman(List<NameAndVector3> nameAndPositions,JsArray<AnimationBone> bones,Geometry geometry,int index){
	  Vector4 v4=THREE.Vector4();
		
		v4.setX(geometry.getSkinIndices().get(index).getX());
		v4.setY(geometry.getSkinIndices().get(index).getY());
		
		v4.setZ(geometry.getSkinWeight().get(index).getX());
		v4.setW(geometry.getSkinWeight().get(index).getY());
		
		
		boolean firstIsEmpty=false;
	    boolean isEmpty=false;
	    
	   
		
		if(v4.getX()==0 && v4.getY()==0){//both is root
			
			if(v4.getW()==1 || v4.getZ()==1){//totally root;
				return v4;
			}
			if(v4.getZ()==0){
				firstIsEmpty=true;
				isEmpty=true;
			}else if(v4.getW()==0){
				isEmpty=true;
			}
			
			
			if(isEmpty){
				//rThigh or lThigh;
				double centerX=bones.get(0).getPos().get(0);
				
				
				
				double centerY=bones.get(0).getPos().get(1)+bones.get(7).getPos().get(1)/2;//half
				double atX=geometry.getVertices().get(index).getX();
				double atY=geometry.getVertices().get(index).getY();
				
				if(atY<centerY){
				if(atX<centerX){
					
					if(firstIsEmpty){
						v4.setX(4);//lThigh
						v4.setZ(1-v4.getW());
					}else{
						v4.setY(4);//lThigh
						v4.setW(1-v4.getZ());
					}
					
				}else if(atX>centerX){
					
					if(firstIsEmpty){
						v4.setX(1);//rThigh
						v4.setZ(1-v4.getW());
					}else{
						v4.setY(1);//rThigh
						v4.setW(1-v4.getZ());
					}
				}
				}else{
					double v;
					if(firstIsEmpty){
						v=(1-v4.getW());
					}else{
						v=(1-v4.getZ());
					}
					
					if(v<0.2){//small is usually legs,TODO check by position
						if(atX<centerX){
							
							if(firstIsEmpty){
								v4.setX(4);//lThigh
								v4.setZ(1-v4.getW());
							}else{
								v4.setY(4);//lThigh
								v4.setW(1-v4.getZ());
							}
							
						}else if(atX>centerX){
							
							if(firstIsEmpty){
								v4.setX(1);//rThigh
								v4.setZ(1-v4.getW());
							}else{
								v4.setY(1);//rThigh
								v4.setW(1-v4.getZ());
							}
						}
					}else{
						if(firstIsEmpty){
							v4.setX(7);
						}else{
							v4.setY(7);
						}
					}
					
					
					
					if(firstIsEmpty){
						v4.setZ(1-v4.getW());
					}else{
						v4.setW(1-v4.getZ());
					}
					
				}
			}
			
			
		}else{
			
			
			if(v4.getX()==0 && v4.getZ()==0 && v4.getW()!=1){
				firstIsEmpty=true;
				isEmpty=true;
			}
			else if(v4.getY()==0 && v4.getW()==0 && v4.getZ()!=1){
				isEmpty=true;
			}
			
			if(isEmpty){//fix arms
				int target;
				if(firstIsEmpty){
					target=(int) v4.getY();
				}else{
					target=(int) v4.getX();
				}
				
				int second=findClosedBone(nameAndPositions, geometry.getVertices().get(index), target);
				//LogUtils.log(target+",second="+second);
				
				
				
				if(firstIsEmpty){
					v4.setX(second);
					v4.setZ(1-v4.getW());
				}else{
					v4.setY(second);
					v4.setW(1-v4.getZ());
				}
				
				//horrible rThigh & lThigh case
				if(target==1 && second==4){
					if(firstIsEmpty){
						v4.setX(0);
					}else{
						v4.setY(0);
					}
				}else if(target==4 && second==1){
					if(firstIsEmpty){
						v4.setX(0);
					}else{
						v4.setY(0);
					}
				}
				
			}
			
			//not allow chest-sholder
			if(v4.getX()==8 && v4.getY()==10){//chest-rsholder to rcolor-rsholder
				v4.setX(9);
			}
			else if(v4.getX()==8 && v4.getY()==14){//chest-lsholder to lcolor-lsholder
				v4.setX(13);
			}else if(v4.getY()==8 && v4.getX()==10){//chest-rsholder to rcolor-rsholder
				v4.setY(9);
			}
			else if(v4.getY()==8 && v4.getX()==14){//chest-lsholder to lcolor-lsholder
				v4.setY(13);
			}
			
			//now allow chest-neck
			//not good at check to color
			/*
			if(v4.getX()==8 && v4.getY()==17){//chest-rsholder to rcolor-rsholder
				double centerX=bones.get(0).getPos().get(0);
				double atX=geometry.getVertices().get(index).getX();
				
				if(atX<centerX){
					v4.setX(9);
					
				}else if(atX>centerX){
					v4.setX(13);
					
				}
				
				
			}else if(v4.getY()==8 && v4.getX()==17){//neck
				double centerX=bones.get(0).getPos().get(0);
				double atX=geometry.getVertices().get(index).getX();
				
				if(atX<centerX){
					v4.setY(9);
					
				}else if(atX>centerX){
					v4.setY(13);
					
				}
			}
			*/
			
		}
		
		return v4;
  }
  
	public static int  findClosedBone(List<NameAndVector3> nameAndPositions,Vector3 vertexPos,int ignoreIndex){
		int minIndex=-1;
		double minLength=Double.MAX_VALUE;
		for(int i=0;i<nameAndPositions.size();i++){
			if(nameAndPositions.get(i).getIndex()==ignoreIndex){
				continue;
			}
			Vector3 bonePosition=nameAndPositions.get(i).getVector3().clone();
			Vector3 diffPos=bonePosition.sub(vertexPos);
			double l=diffPos.length();
			if(l<minLength){
				minIndex=nameAndPositions.get(i).getIndex();
				minLength=l;
			}
		}
		return minIndex;
	}




	public static void autoWeight(Geometry geometry,JsArray<AnimationBone> bones,int mode,JsArray<Vector4> bodyIndices,JsArray<Vector4> bodyWeight){
		autoWeight(geometry,bones,null,mode,bodyIndices,bodyWeight);
	}
	
	
	
	private static Vector4 fromGeometry(Geometry geometry,int index) {
		Vector4 v4=THREE.Vector4();
		
		v4.setX(geometry.getSkinIndices().get(index).getX());
		v4.setY(geometry.getSkinIndices().get(index).getY());
		
		v4.setZ(geometry.getSkinWeight().get(index).getX());
		v4.setW(geometry.getSkinWeight().get(index).getY());
		
		return v4;
	}

	
	
	
	public static List<NameAndVector3> boneToNameAndPosition(JsArray<AnimationBone> bones){
		return boneToNameAndPosition(bones,null);
	}
	//add all bones start,half end position
	public static List<NameAndVector3> boneToNameAndPosition(JsArray<AnimationBone> bones,List<List<Vector3>> endSites){
		List<NameAndVector3> lists=new ArrayList<NameAndVector3>();
		List<Vector3> absolutePos=new ArrayList<Vector3>();
		List<Integer> hasChild=new ArrayList<Integer>();
		for(int i=0;i<bones.length();i++){
			AnimationBone bone=bones.get(i);
			if(bone.getParent()!=-1){
				hasChild.add(bone.getParent());
			}
		}
		for(int i=0;i<bones.length();i++){
			AnimationBone bone=bones.get(i);
			
			Vector3 pos=AnimationBone.jsArrayToVector3(bone.getPos());
			String parentName=null;
			//add start
			//add center
			Vector3 parentPos=null;
			Vector3 endPos=null;
			int parentIndex=0;
			if(bone.getParent()!=-1){
				parentIndex=bone.getParent();
				parentName=bones.get(parentIndex).getName();
				
				parentPos=absolutePos.get(parentIndex);
				
				if(pos.getX()!=0 || pos.getY()!=0 || pos.getZ()!=0){
				endPos=pos.clone().multiplyScalar(.9).add(parentPos);
				Vector3 half=pos.clone().multiplyScalar(.5).add(parentPos);
				
				lists.add(new NameAndVector3(parentName,endPos,parentIndex));//start pos
				lists.add(new NameAndVector3(KEY_HALF+parentName,half,parentIndex));//half pos
				
				if(!hasChild.contains(i)){
					//end
				//	LogUtils.log("end "+bone.getName());
					Vector3 end=pos.clone().multiplyScalar(2).add(parentPos);
					lists.add(new NameAndVector3(KEY_END+bone.getName(),end,i));//end pos
					}
				}else{
					
				}
			}
			//add end
			
			if(parentPos!=null){
				pos.add(parentPos);
			}
			absolutePos.add(pos);
			
			
			if(endSites!=null){
				List<Vector3> ends=endSites.get(i);
				for(Vector3 endSite:ends){
					lists.add(new NameAndVector3(KEY_ENDSITE+bone.getName(),pos.clone().add(endSite),i));//
				}
			}
			
			
			lists.add(new NameAndVector3(bone.getName(),pos,i));//end pos
		}
		return lists;
	}
}
