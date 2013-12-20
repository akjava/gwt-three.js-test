package com.akjava.gwt.three.client.gwt;

import com.google.gwt.core.client.JavaScriptObject;

public class MetaData extends JavaScriptObject{
	protected MetaData(){}
	
	public native final void setFormatVersion(double version)/*-{
	this["formatVersion"]=version;
	}-*/;
	
	public native final double getFormatVersion()/*-{
	return this["formatVersion"];
	}-*/;
	
	public native final void setGeneratedBy(String generatedBy)/*-{
	this["generatedBy"]=generatedBy;
	}-*/;
	
	public native final double getGeneratedBy()/*-{
	return this["generatedBy"];
	}-*/;
	
	
	
	public native final MetaData clone()/*-{
	var copy = {};
    for (var attr in this) {
        if (this.hasOwnProperty(attr)) copy[attr] = this[attr];
    }
    return copy;
	}-*/;
	
}
