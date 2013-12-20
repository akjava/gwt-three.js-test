package com.akjava.gwt.three.client.java;

import com.akjava.gwt.three.client.java.utils.ShaderUtils.Uniforms;
import com.akjava.gwt.three.client.js.materials.Material;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * @deprecated
 * @author aki
 *
 */
public class ShaderMaterialBuilder extends JavaScriptObject{
	
		protected ShaderMaterialBuilder(){}
		public final static ShaderMaterialBuilder create(){
			return (ShaderMaterialBuilder) ShaderMaterialBuilder.createObject();
		}
		
		public final native ShaderMaterialBuilder fragmentShader(String fragment)/*-{
		this["fragmentShader"]=fragment;
		return this;
		}-*/;
		
		public final native ShaderMaterialBuilder vertexShader(String vertex)/*-{
		this["vertexShader"]=vertex;
		return this;
		}-*/;
		
		public final native ShaderMaterialBuilder uniforms(Uniforms uniforms)/*-{
		this["uniforms"]=uniforms;
		return this;
		}-*/;
		
		public final native ShaderMaterialBuilder lights(boolean bool)/*-{
		this["lights"]=bool;
		return this;
		}-*/;
		
		
		
		
		public final native ShaderMaterialBuilder morphTargets(boolean w)/*-{
		this["morphTargets"]=w;
		return this;
		}-*/;
		
		public final Material build(){
			return build(this);
		}
		private final native Material build(JavaScriptObject object)/*-{
		return new $wnd.THREE.ShaderMaterial(object);
		}-*/;
}
