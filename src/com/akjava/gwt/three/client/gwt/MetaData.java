package com.akjava.gwt.three.client.gwt;

import com.google.gwt.core.client.JavaScriptObject;

/*
 * this meta is for old jsonfile-format
 */
public class MetaData extends JavaScriptObject{
	protected MetaData(){}
	
	public native final void setFormatVersion(double version)/*-{
	this["formatVersion"]=version;
	}-*/;
	
	public native final double getFormatVersion()/*-{
	return this["formatVersion"];
	}-*/;
	
	/**
	 * technically not file-format
	 * @return
	 */
	public native final double getVersion()/*-{
	return this["version"];
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
