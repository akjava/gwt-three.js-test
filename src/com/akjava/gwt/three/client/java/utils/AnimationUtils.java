package com.akjava.gwt.three.client.java.utils;

import com.akjava.gwt.three.client.gwt.animation.AnimationBone;
import com.akjava.gwt.three.client.gwt.animation.AnimationData;
import com.akjava.gwt.three.client.gwt.animation.AnimationHierarchyItem;
import com.akjava.gwt.three.client.gwt.animation.AnimationKey;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;


public class AnimationUtils {
private AnimationUtils(){}
public static AnimationData createAnimationData(){
	AnimationData data=(AnimationData) AnimationData.createObject();
	GWT.log("create:"+data);
	JsArray<AnimationHierarchyItem> array=(JsArray<AnimationHierarchyItem>) JsArray.createArray();
	data.setHierarchy(array);
	data.setJIT(0);
	return data;
}

public static AnimationHierarchyItem createAnimationHierarchyItem(){
	AnimationHierarchyItem data=(AnimationHierarchyItem) AnimationHierarchyItem.createObject();
	JsArray<AnimationKey> array=(JsArray<AnimationKey>) JsArray.createArray();
	data.setKeys(array);
	return data;
}

public static AnimationKey createAnimationKey(){
	AnimationKey data=(AnimationKey) AnimationKey.createObject();
	data.setScl(1,1,1);
	return data;
}
public static AnimationBone createAnimationBone(){
	AnimationBone data=(AnimationBone) AnimationBone.createObject();
	data.setScl(1,1,1);
	data.setRotq(0,0,0,1);
	return data;
}

public static Vector3 getPosition(AnimationKey key){
	return THREE.Vector3(key.getPos().get(0),key.getPos().get(1),key.getPos().get(2));
}

public static Vector3 getPosition(AnimationBone key){
	return THREE.Vector3(key.getPos().get(0),key.getPos().get(1),key.getPos().get(2));
}

}
