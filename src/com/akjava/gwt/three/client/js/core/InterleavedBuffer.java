package com.akjava.gwt.three.client.js.core;

import com.akjava.gwt.three.client.gwt.JSParameter;
import com.google.gwt.core.client.JavaScriptObject;

public class InterleavedBuffer extends JavaScriptObject{
	protected InterleavedBuffer(){}
	


	public final  native int getUuid()/*-{
	return this.uuid;
	}-*/;


	public final  native JavaScriptObject getArray()/*-{
	return this.array;
	}-*/;
	public final  native void setArray(JavaScriptObject  param)/*-{
	this.array=param;
	}-*/;


	public final  native int getStride()/*-{
	return this.stride;
	}-*/;
	public final  native void setStride(int  param)/*-{
	this.stride=param;
	}-*/;


	public final  native boolean isDynamic()/*-{
	return this.dynamic;
	}-*/;
	
	/**
	 * there are method
	 * @param param
	 * @return
	 */
	public final  native InterleavedBuffer  setDynamic(boolean  param)/*-{
	return setDynamic(param);
	}-*/;


	/**
	 * default { offset: 0, count: - 1 }
	 * @return
	 */
	public final  native JSParameter getUpdateRange()/*-{
	return this.updateRange;
	}-*/;
	public final  native void setUpdateRange(JavaScriptObject  param)/*-{
	this.updateRange=param;
	}-*/;


	public final  native int getVersion()/*-{
	return this.version;
	}-*/;
	public final  native void setVersion(int  param)/*-{
	this.version=param;
	}-*/;

	public final  native int length()/*-{
	return this.length;
	}-*/;
	/**
	 * possible double?i'm not sure
	 *  on js:return this.array.length / this.stride;
	 * @return
	 */
	public final  native int count()/*-{
	return this.count;
	}-*/;
	
	public final  native void setNeedUpdate(boolean needUpdate)/*-{
	return this.needUpdate=needUpdate;
	}-*/;
	
	public final  native InterleavedBuffer  copy(InterleavedBuffer  param)/*-{
	return this.copy(param);
	}-*/;
	
	
	public final  native InterleavedBuffer  copyAt(int index1,InterleavedBuffer  param,int index2)/*-{
	 return copyAt(index1,param,index2);
	}-*/;
	public final  native void  set(int value,int offset)/*-{
	 this.set(value,offset);
	}-*/;
	
	public final  native InterleavedBuffer clone()/*-{
	return this.clone();
	}-*/;
}
