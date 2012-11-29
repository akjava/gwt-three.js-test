package com.akjava.gwt.three.client.extras;

import com.akjava.gwt.three.client.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;

public class ShaderUtils {

	public static native final Shader lib(String name)/*-{
	return $wnd.THREE.ShaderUtils.lib[ name ];
	}-*/;

	

public static  class Shader extends JavaScriptObject{
	protected Shader(){}
	
	public  native final String fragmentShader()/*-{
	return this.fragmentShader;
	}-*/;
	
	public  native final String vertexShader()/*-{
	return this.vertexShader;
	}-*/;
	
	
	
	public  native final Uniforms uniforms()/*-{
	return this.uniforms;
	
	}-*/;
}

public static class Uniforms extends JavaScriptObject{
	protected Uniforms(){}
	
	public native final void set(String key,double value)/*-{
	this[key].value=value;
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



}
