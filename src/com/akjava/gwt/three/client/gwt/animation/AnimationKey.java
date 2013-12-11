package com.akjava.gwt.three.client.gwt.animation;

import com.akjava.gwt.three.client.math.Quaternion;
import com.akjava.gwt.three.client.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

public class AnimationKey extends JavaScriptObject {
	protected AnimationKey(){}
	public native final double getTime()/*-{
	return this['time'];
	}-*/;

	public native final void setTime(double time)/*-{
	this['time']=time;
	}-*/;
	
	
	public final void setPos(Vector3 vec){
		setPos(vec.getX(),vec.getY(),vec.getZ());
	}
	public native final void setPos(double x,double y,double z)/*-{
	this['pos']=[x,y,z];
	}-*/;
	
	/*
	 * sometime it's empty
	 */
	public native final JsArrayNumber getPos()/*-{
	return this['pos'];
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
	

	public native final JsArrayNumber getRot()/*-{
	return this['rot'];
	}-*/;

	public native final void setRot(JsArrayNumber rot)/*-{
	this['rot']=rot;
	}-*/;
	
	public native final Quaternion getRotq()/*-{
	return this['rotq'];
	}-*/;

	public native final void setRotq(Quaternion rot)/*-{
	this['rotq']=rot;
	}-*/;
	
	//need angle for Animation Bone Data
	public native final Vector3 getAngle()/*-{
	return this['angle'];
	}-*/;

	public native final void setAngle(Vector3 rot)/*-{
	this['angle']=rot;
	}-*/;
}
