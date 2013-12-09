package com.akjava.gwt.three.client.extras;

import com.akjava.gwt.three.client.materials.MeshLambertMaterialParameter;
import com.akjava.gwt.three.client.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;

public  class Uniforms extends JavaScriptObject{
	public final static Uniforms create(){
		return (Uniforms) MeshLambertMaterialParameter.createObject();
	}
	
	protected Uniforms(){}
	//TODO test and more
	public native final void setDouble(String key,double value)/*-{
	this[key]={type:"f",value:value};
	}-*/;
	public native final void set(String key,Texture texture)/*-{
	this[key].value=texture;
	}-*/;
	public native final void set(String key,boolean bool)/*-{
	this[key].value=bool;
	}-*/;
	public native final void setHex(String key,int hex)/*-{
	this[key].value.setHex(hex);
	}-*/;
	public native final void set(String key,double x,double y)/*-{
	this[key].value.set(x,y);
	}-*/;
}