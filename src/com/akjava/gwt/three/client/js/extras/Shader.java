package com.akjava.gwt.three.client.js.extras;


import com.google.gwt.core.client.JavaScriptObject;

public class Shader extends JavaScriptObject{
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
