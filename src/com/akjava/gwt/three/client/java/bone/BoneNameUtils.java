package com.akjava.gwt.three.client.java.bone;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.akjava.gwt.three.client.gwt.boneanimation.AnimationBone;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.google.gwt.core.client.JsArray;

public class BoneNameUtils {
	private BoneNameUtils(){}
	public static Vector2 parsePlainBoneName(String boneName){
		checkNotNull(boneName,"boneName is  null");
		checkArgument(boneName.indexOf(",")!=-1,"not plain-bone name ");
		String[] name=boneName.split(",");
		int atX=Integer.parseInt(name[0]);
		int atY=Integer.parseInt(name[1]);
		return THREE.Vector2(atX, atY);
	}
	public static String makePlainBoneName(int x,int y){
		return x+","+y;
	}
	public static int findBoneByName(JsArray<AnimationBone> bones,String name){
		checkNotNull(name,"boneName is  null");
		checkNotNull(bones,"no bones");
		for(int i=0;i<bones.length();i++){
			if(bones.get(i).getName().equals(name)){
				return i;
			}
		}
		return -1;
	}
}
