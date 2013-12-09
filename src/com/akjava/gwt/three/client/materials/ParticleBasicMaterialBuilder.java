package com.akjava.gwt.three.client.materials;

import com.akjava.gwt.three.client.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;
/**
 * @deprecated
 * @author aki
 *
 */
public class ParticleBasicMaterialBuilder extends JavaScriptObject{
	protected ParticleBasicMaterialBuilder(){}
	public final static ParticleBasicMaterialBuilder create(){
		return (ParticleBasicMaterialBuilder) ParticleBasicMaterialBuilder.createObject();
	}

	public final ParticleBasicMaterial build(){
		return build(this);
	}
	
	private final native ParticleBasicMaterial build(JavaScriptObject object)/*-{
	return new $wnd.THREE.ParticleBasicMaterial(object);
	}-*/;
	
	public final ParticleBasicMaterialBuilder color(int r,int g,int b){
		int c=(0xff & r)<<16| (0xff & g)<<8|(0xff & b);
		return color(c);
	}
	
	public final native ParticleBasicMaterialBuilder transparent(boolean transparent)/*-{
	this["transparent"]=transparent;
	return this;
	}-*/;
	
	public final native ParticleBasicMaterialBuilder sizeAttenuation(boolean sizeAttenuation)/*-{
	this["sizeAttenuation"]=sizeAttenuation;
	return this;
	}-*/;
	
	
	public final native ParticleBasicMaterialBuilder depthTest(boolean depthTest)/*-{
	this.depthTest=depthTest;
	return this;
	}-*/;
	
	public final native ParticleBasicMaterialBuilder map(Texture texture)/*-{
	this["map"]=texture;
	return this;
	}-*/;
	
	public final native ParticleBasicMaterialBuilder blending(int type)/*-{
	this["blending"]=type;
	return this;
	}-*/;
	
	public final native ParticleBasicMaterialBuilder color(int c)/*-{
	this["color"]=c;
	return this;
	}-*/;
	
	public final native ParticleBasicMaterialBuilder opacity(double opacity)/*-{
	this["opacity"]=opacity;
	return this;
	}-*/;
	
	public final native ParticleBasicMaterialBuilder size(double size)/*-{
	this["size"]=size;
	return this;
	}-*/;
	
	public final native double getSize()/*-{
	return this["size"];
	}-*/;
}
