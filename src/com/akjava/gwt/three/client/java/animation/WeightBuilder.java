package com.akjava.gwt.three.client.java.animation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.gwt.animation.AnimationBone;
import com.akjava.gwt.three.client.gwt.animation.NameAndVector3;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.math.Vector4;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;
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


  public static boolean isHasIndex(Vector4 v4,int target){
	return v4.getX()==target || v4.getY()==target;  
  }
  public static int getAnother(Vector4 v4,int target){
	  if(v4.getX()==target){
		  return (int)v4.getY();
	  }else if(v4.getY()==target){
		  return (int)v4.getX();
	  } 
	  return -1;
  }
 
  public static void replaceIndex(Vector4 v4,int target,int replace){
	  if(v4.getX()==target){
		  v4.setX(replace);
	  }else if(v4.getY()==target){
		  v4.setY(replace);
	  }
  }
  public static boolean isConnected(Vector4 v4,JsArray<AnimationBone> bones){
	  //same
	  if(v4.getX()==v4.getY()){
		  return true;
	  }
	  
	  //100% value no need to check
	  if(v4.getZ()==1 || v4.getW()==1){
		  return true;
	  }
	 
	  
	  return bones.get((int)v4.getX()).getParent()==v4.getY() || bones.get((int)v4.getY()).getParent()==v4.getX();  
  }
  
  
    //is this slow?
  	public static Set<NameAndVector3>  sortNameAndPosition(List<NameAndVector3> nameAndPositions,Vector3 vertexPos){
  		
  		Map<NameAndVector3,Integer> map=new HashMap<NameAndVector3, Integer>();
  		final Ordering<NameAndVector3> orders=Ordering.natural().reverse().nullsLast().onResultOf(Functions.forMap(map, null));
  		LogUtils.log(ImmutableSortedMap.copyOf(map, orders));
  		
  		return ImmutableSortedMap.copyOf(map, orders).keySet();
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
