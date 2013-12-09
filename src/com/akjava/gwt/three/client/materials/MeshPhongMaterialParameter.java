/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2011 aki@akjava.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r45
 https://github.com/mrdoob/three.js
 The MIT License

Copyright (c) 2010-2011 three.js Authors. All rights reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
  
 */
package com.akjava.gwt.three.client.materials;

import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.math.Vector2;
import com.akjava.gwt.three.client.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * can't overwrite.copy this as base
 * @author aki
 *  color: <hex>,
 *  ambient: <hex>,
 *  emissive: <hex>,
 *  specular: <hex>,
 *  shininess: <float>,
 
 */
public final class MeshPhongMaterialParameter extends JSParameter{
	protected MeshPhongMaterialParameter(){}
	public final static MeshPhongMaterialParameter create(){
		return (MeshPhongMaterialParameter) MeshPhongMaterialParameter.createObject();
	}
	public final MeshPhongMaterialParameter color(int r,int g,int b){
		int c=(0xff & r)<<16| (0xff & g)<<8|(0xff & b);
		return color(c);
	}
	public final native MeshPhongMaterialParameter color(int color)/*-{
	this.color=c;
	return this;
	}-*/;
	
	public final MeshPhongMaterialParameter ambient(int r,int g,int b){
		int c=(0xff & r)<<16| (0xff & g)<<8|(0xff & b);
		return ambient(c);
	}
	public final native MeshPhongMaterialParameter ambient(int ambient)/*-{
	this.ambient=ambient;
	return this;
	}-*/;
	public final MeshPhongMaterialParameter emissive(int r,int g,int b){
		int c=(0xff & r)<<16| (0xff & g)<<8|(0xff & b);
		return emissive(c);
	}
	public final native MeshPhongMaterialParameter emissive(int emissive)/*-{
	this.emissive=emissive;
	return this;
	}-*/;
	public final MeshPhongMaterialParameter specular(int r,int g,int b){
		int c=(0xff & r)<<16| (0xff & g)<<8|(0xff & b);
		return specular(c);
	}
	public final native MeshPhongMaterialParameter specular(int specular)/*-{
	this.specular=specular;
	return this;
	}-*/;
	/*



	public final native MeshPhongMaterialParameter shininess(double shininess)/*-{
	this.shininess=shininess;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter map(Texture map)/*-{
	this.map=map;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter lightMap(Texture lightMap)/*-{
	this.lightMap=lightMap;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter bumpMap(Texture bumpMap)/*-{
	this.bumpMap=bumpMap;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter bumpScale(double bumpScale)/*-{
	this.bumpScale=bumpScale;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter normalMap(Texture normalMap)/*-{
	this.normalMap=normalMap;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter normalScale(Vector2 normalScale)/*-{
	this.normalScale=normalScale;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter specularMap(Texture specularMap)/*-{
	this.specularMap=specularMap;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter envMap(JavaScriptObject envMap)/*-{
	this.envMap=envMap;
	return this;
	}-*/;

	public final native MeshPhongMaterialParameter combine(int envMap)/*-{
	this.combine=combine;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter reflectivity(double reflectivity)/*-{
	this.reflectivity=reflectivity;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter refractionRatio(double refractionRatio)/*-{
	this.refractionRatio=refractionRatio;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter wireframe(boolean wireframe)/*-{
	this.wireframe=wireframe;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter wireframeLinewidth(double wireframeLinewidth)/*-{
	this.wireframeLinewidth=wireframeLinewidth;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter vertexColors(int vertexColors)/*-{
	this.vertexColors=vertexColors;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter shading(int shading)/*-{
	this.shading=shading;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter skinning(boolean skinning)/*-{
	this.skinning=skinning;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter morphTargets(boolean morphTargets)/*-{
	this.morphTargets=morphTargets;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter morphNormals(boolean morphNormals)/*-{
	this.morphNormals=morphNormals;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter fog(boolean fog)/*-{
	this.fog=fog;
	return this;
	}-*/;
	
	
	public final native MeshPhongMaterialParameter side(int side)/*-{
	this.side=side;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter opacity(double opacity)/*-{
	this.opacity=opacity;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter transparent(boolean transparent)/*-{
	this.transparent=transparent;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter depthTest(boolean depthTest)/*-{
	this.depthTest=depthTest;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter depthWrite(boolean depthWrite)/*-{
	this.depthWrite=depthWrite;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter polygonOffset(boolean polygonOffset)/*-{
	this.polygonOffset=polygonOffset;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter blending(int blending)/*-{
	this.blending=blending;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter blendSrc(int blendSrc)/*-{
	this.blendSrc=blendSrc;
	return this;
	}-*/;
	
	
	
	public final native MeshPhongMaterialParameter blendDst(int blendDst)/*-{
	this.blendDst=blendDst;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter blendEquation(int blendEquation)/*-{
	this.blendEquation=blendEquation;
	return this;
	}-*/;
	
	
	
	
	public final native MeshPhongMaterialParameter polygonOffsetFactor(double polygonOffsetFactor)/*-{
	this.polygonOffsetFactor=polygonOffsetFactor;
	return this;
	}-*/;
	
	public final native MeshPhongMaterialParameter polygonOffsetUnits(double polygonOffsetUnits)/*-{
	this.polygonOffsetUnits=polygonOffsetUnits;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter alphaTest(double alphaTest)/*-{
	this.alphaTest=alphaTest;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter overdraw(double overdraw)/*-{
	this.overdraw=overdraw;
	return this;
	}-*/;
	public final native MeshPhongMaterialParameter needsUpdate(boolean needsUpdate)/*-{
	this.needsUpdate=needsUpdate;
	return this;
	}-*/;
	
}
