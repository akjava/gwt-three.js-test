package com.akjava.gwt.three.client.js.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

public class BufferAttribute extends JavaScriptObject{
	protected BufferAttribute() {
	}
	
	public final  native double getLength()/*-{
	return this.length;
	}-*/;
	
	/**
	 * 
	 * possible ArrayBufferViewNative
	 * @return
	 */
	public final  native JavaScriptObject getArray()/*-{
	return this.array;
	}-*/;
	
	/**
	 * 
	 * possible ArrayBufferViewNative
	 * @return
	 */
	public final  native void setArray(JavaScriptObject  param)/*-{
	this.array=param;
	}-*/;
	
	public final  native void setNeedsUpdate(boolean  needsUpdate)/*-{
	this.needsUpdate=needsUpdate;
	}-*/;


	public final  native int getItemSize()/*-{
	return this.itemSize;
	}-*/;
	public final  native void setItemSize(int  param)/*-{
	this.itemSize=param;
	}-*/;
	
	
	public final  native BufferAttribute set(JsArrayNumber param)/*-{
	return this.set(param);
	}-*/;
	
	public final  native BufferAttribute setX(int index,int param)/*-{
	return this.setX(index,param);
	}-*/;
	
	public final  native BufferAttribute setY(int index,int param)/*-{
	return this.setY(index,param);
	}-*/;
	
	public final  native BufferAttribute setZ(int index,int param)/*-{
	return this.setZ(index,param);
	}-*/;
	
	public final  native BufferAttribute setXY(int index,int x,int y)/*-{
	return this.setXY(index,x,y);
	}-*/;
	
	public final  native BufferAttribute setXYZ(int index,int x,int y,int z)/*-{
	return this.setXYZ(index,x,y,z);
	}-*/;
	
	public final  native BufferAttribute setXYZW(int index,int x,int y,int z,int w)/*-{
	return this.setXYZW(index,x,y,z,w);
	}-*/;
	
	public final  native BufferAttribute clone()/*-{
	return this.clone();
	}-*/;
	
	public final native BufferAttribute copy(BufferAttribute source)/*-{
	return this.copy(source);
	}-*/;
	
	public final  native int getCount()/*-{
	return this.count;
	}-*/;
	
}
