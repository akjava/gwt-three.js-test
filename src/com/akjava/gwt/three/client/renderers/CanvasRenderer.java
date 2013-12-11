package com.akjava.gwt.three.client.renderers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class CanvasRenderer extends WebGLRenderer{
	public final native JavaScriptObject getParameters()/*-{
	return this.parameters;
	}-*/;
	
	//public final native Element getDomElement()/*-{
	//return this.domElement;
	//}-*/;
	

	

	public final native boolean isSortElements()/*-{
	return this.sortElements;
	}-*/;

	public final native void setSortElements(boolean sortElements)/*-{
	this.sortElements = sortElements;
	}-*/;
}
