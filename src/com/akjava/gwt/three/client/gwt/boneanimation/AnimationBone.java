package com.akjava.gwt.three.client.gwt.boneanimation;

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.math.Quaternion;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

/*
 * before THREE.BONE JSON-Data
 * Geometry Bone
 * 
 * relative path
 */
public class AnimationBone extends JavaScriptObject{
	protected AnimationBone(){}
	public native final String getName ()/*-{
	return this['name'];
	}-*/;

	public native final void setName (String name)/*-{
	this['name']=name;
	}-*/;
	
	public native final int getParent ()/*-{
	return this['parent'];
	}-*/;

	public native final void setParent (int parent)/*-{
	this['parent']=parent;
	}-*/;
	
	public native final void setRotq(Quaternion q)/*-{
	this['rotq']=[q.x,q.y,q.z,q.w];
	}-*/;
	
	public native final void setRotq(double x,double y,double z,double w)/*-{
	this['rotq']=[x,y,z,w];
	}-*/;
	public native final void setRotq(JsArrayNumber array)/*-{
	this['rotq']=array;
	}-*/;
	
	/*
	 * sometime it's empty
	 */
	public native final JsArrayNumber getRotq()/*-{
	return this['rotq'];
	}-*/;
	
	//I'm not sure still exist?
	public native final void setRot(JsArrayNumber array)/*-{
	this['rot']=array;
	}-*/;
	
	//I'm not sure still exist?
	//really work?
	public native final void setRot(double x,double y,double z)/*-{
	this['rot']=[x,y,z];
	}-*/;
	
	//I'm not sure still exist?
	public native final void setRot(double x,double y,double z,double w)/*-{
	this['rot']=[x,y,z,w];
	}-*/;
	
	
	
	//I'm not sure still exist?
	/*
	 * sometime it's empty
	 */
	public native final JsArrayNumber getRot()/*-{
	return this['rot'];
	}-*/;
	
	public native final void setPos(Vector3 vec)/*-{
	this['pos']=[vec.x,vec.y,vec.z];
	}-*/;
	
	public native final void setPos(double x,double y,double z)/*-{
	this['pos']=[x,y,z];
	}-*/;
	public native final void setPos(JsArrayNumber array)/*-{
	this['pos']=array;
	}-*/;
	
	
	public static final JsArray<AnimationBone> gwtClone(JsArray<AnimationBone> bones){
		JsArray<AnimationBone> array=JavaScriptUtils.createJSArray();
		for(int i=0;i<bones.length();i++){
			array.push(bones.get(i).gwtClone());
		}
		return array;
	}
	
	public  final AnimationBone gwtClone(){
		AnimationBone bone=AnimationBone.createObject().cast();
		
		bone.setName(getName());
		bone.setParent(getParent());
		
		if(getPos()!=null){
			bone.setPos(JavaScriptUtils.clone(getPos()));
		}
		if(getRotq()!=null){
			bone.setRotq(JavaScriptUtils.clone(getRotq()));
		}
		if(getRot()!=null){
			bone.setRot(JavaScriptUtils.clone(getRot()));
		}
		if(getScl()!=null){
			bone.setScl(JavaScriptUtils.clone(getScl()));
		}
		
		return bone;
	}
	
	/**
	 * @deprecated
	 * @param array
	 * @return
	 */
	public static final Vector3 jsArrayToVector3(JsArrayNumber array){
		return THREE.Vector3(array.get(0),array.get(1), array.get(2));
	}

	/**
	 * @deprecated
	 * @param array
	 * @return
	 */
	public static final Quaternion jsArrayToQuaternion(JsArrayNumber array){
		return THREE.Quaternion(array.get(0),array.get(1), array.get(2),array.get(3));
	}
	/*
	 * sometime it's empty
	 */
	public native final JsArrayNumber getPos()/*-{
	return this['pos'];
	}-*/;
	
	public native final void setScl(JsArrayNumber array)/*-{
	this['scl']=array;
	}-*/;
	public native final void setScl(double x,double y,double z)/*-{
	this['scl']=[x,y,z];
	}-*/;
	
	/*
	 * sometime it's empty
	 */
	public native final JsArrayNumber getScl()/*-{
	return this['scl'];
	}-*/;
	
	
}
