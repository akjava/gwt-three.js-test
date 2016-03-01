package com.akjava.gwt.three.client.js.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @deprecated on r72
 * @author aki
 *
 */
public class DynamicBufferAttribute extends BufferAttribute {

	protected DynamicBufferAttribute() {
	}
	
	/**
	 * you can cast JSParameter
	 * @return
	 */
	public final native JavaScriptObject getUpdateRange()/*-{
	return this.updateRange;
	}-*/;
	
	public final  native void gwtSetUpdateRange(int offset,int count)/*-{
	this.updateRange.offset=offset;
	this.updateRange.count=count;
	}-*/;
}
