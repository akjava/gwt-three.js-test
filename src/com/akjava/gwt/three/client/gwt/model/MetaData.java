package com.akjava.gwt.three.client.gwt.model;

import com.google.gwt.core.client.JavaScriptObject;

public class MetaData extends JavaScriptObject{
	protected MetaData(){}
	
	public native final void setFormatVersion(double version)/*-{
	this["formatVersion"]=version;
	}-*/;
	
	public native final double getFormatVersion()/*-{
	return this["formatVersion"];
	}-*/;
}
