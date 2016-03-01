package com.akjava.gwt.three.client.js.core;

import com.google.gwt.core.client.JavaScriptObject;

public class InterleavedBufferAttribute extends JavaScriptObject{
	protected InterleavedBufferAttribute(){}
	


	public final  native int getUuid()/*-{
	return this.uuid;
	}-*/;



	public final  native InterleavedBuffer getData()/*-{
	return this.data;
	}-*/;
	public final  native void setData(InterleavedBuffer  param)/*-{
	this.data=param;
	}-*/;


	public final  native JavaScriptObject getItemsize()/*-{
	return this.itemsize;
	}-*/;
	public final  native void setItemsize(JavaScriptObject  param)/*-{
	this.itemsize=param;
	}-*/;


	public final  native JavaScriptObject getOffset()/*-{
	return this.offset;
	}-*/;
	public final  native void setOffset(JavaScriptObject  param)/*-{
	this.offset=param;
	}-*/;

	/**
	 * @deprecated 
	 * console.warn( 'THREE.BufferAttribute: .length has been deprecated. Please use .count.' );
	 * @return
	 */
	public final  native int length()/*-{
	return this.length;
	}-*/;
	
	public final  native int getCount()/*-{
	return this.count;
	}-*/;
	
	public final  native void setX(int index,double value)/*-{
	this.setX(index,value);
	}-*/;
	
	public final  native void setY(int index,double value)/*-{
	this.setY(index,value);
	}-*/;
	
	public final  native void setZ(int index,double value)/*-{
	this.setZ(index,value);
	}-*/;
	
	public final  native void setW(int index,double value)/*-{
	this.setW(index,value);
	}-*/;
	
	public final  native double getX(int index)/*-{
	return this.getX(index);
	}-*/;
	
	public final  native double getY(int index)/*-{
	return this.getX(index);
	}-*/;
	
	public final  native double getW(int index)/*-{
	return this.getX(index);
	}-*/;
	
	public final  native double getZ(int index)/*-{
	return this.getX(index);
	}-*/;
	
	public final  native void setXY(int index,double x,double y)/*-{
	this.setXY(index,x,y);
	}-*/;
	
	public final  native void setXYZ(int index,double x,double y,double z)/*-{
	this.setXY(index,x,y,z);
	}-*/;
	
	public final  native void setXYZW(int index,double x,double y,double z,double w)/*-{
	this.setXY(index,x,y,z,w);
	}-*/;
}
