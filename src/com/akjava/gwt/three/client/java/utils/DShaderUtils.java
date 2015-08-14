package com.akjava.gwt.three.client.java.utils;

import com.akjava.gwt.three.client.js.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;

public class DShaderUtils {

	public static native final DShader lib(String name)/*-{
	return $wnd.THREE.ShaderUtils.lib[ name ];
	}-*/;

	
/**
 * @deprecated
 * @author aki
 *
 */
public static  class DShader extends JavaScriptObject{
	protected DShader(){}
	
	public  native final String fragmentShader()/*-{
	return this.fragmentShader;
	}-*/;
	
	public  native final String vertexShader()/*-{
	return this.vertexShader;
	}-*/;
	
	
	
	public  native final DUniforms uniforms()/*-{
	return this.uniforms;
	
	}-*/;
}

/**
 * @deprecated useUniforms
 * @author aki
 *
 */
public static class DUniforms extends JavaScriptObject{
	protected DUniforms(){}
	
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
