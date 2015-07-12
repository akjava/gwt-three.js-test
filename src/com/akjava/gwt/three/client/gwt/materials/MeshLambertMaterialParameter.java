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
package com.akjava.gwt.three.client.gwt.materials;

import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.js.math.Color;
import com.akjava.gwt.three.client.js.textures.Texture;

/**

 * @author aki

 */
public final class MeshLambertMaterialParameter extends JSParameter{
	protected MeshLambertMaterialParameter(){}
	public final static MeshLambertMaterialParameter create(){
		return (MeshLambertMaterialParameter) MeshLambertMaterialParameter.createObject();
	}
	public final static MeshLambertMaterialParameter create(JSParameter parameter){
		return (MeshLambertMaterialParameter) parameter;
	}

	public final MeshLambertMaterialParameter color(int r,int g,int b){
		int c=(0xff & r)<<16| (0xff & g)<<8|(0xff & b);
		return color(c);
	}
	public final native MeshLambertMaterialParameter color(int color)/*-{
	this.color=color;
	return this;
	}-*/;
	
	public final MeshLambertMaterialParameter ambient(int r,int g,int b){
		int c=(0xff & r)<<16| (0xff & g)<<8|(0xff & b);
		return ambient(c);
	}
	public final native MeshLambertMaterialParameter ambient(int ambient)/*-{
	this.ambient=ambient;
	return this;
	}-*/;
	public final MeshLambertMaterialParameter emissive(int r,int g,int b){
		int c=(0xff & r)<<16| (0xff & g)<<8|(0xff & b);
		return emissive(c);
	}
	public final native MeshLambertMaterialParameter emissive(int emissive)/*-{
	this.emissive=emissive;
	return this;
	}-*/;

	public final native MeshLambertMaterialParameter wrapAround(boolean wrapAround)/*-{
	this.wrapAround=wrapAround;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter map(Texture map)/*-{
	this.map=map;
	return this;
	}-*/;
	public final native MeshLambertMaterialParameter lightMap(Texture lightMap)/*-{
	this.lightMap=lightMap;
	return this;
	}-*/;
	public final native MeshLambertMaterialParameter specularMap(Texture specularMap)/*-{
	this.specularMap=specularMap;
	return this;
	}-*/;
	public final native MeshLambertMaterialParameter envMap(Texture envMap)/*-{
	this.envMap=envMap;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter alphaMap(Texture alphaMap)/*-{
	this.alphaMap=alphaMap;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter combine(int combine)/*-{
	this.combine=combine;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter reflectivity(double reflectivity)/*-{
	this.reflectivity=reflectivity;
	return this;
	}-*/;
	public final native MeshLambertMaterialParameter refractionRatio(double refractionRatio)/*-{
	this.refractionRatio=refractionRatio;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter fog(boolean fog)/*-{
	this.fog=fog;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter shading(int shading)/*-{
	this.shading=shading;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter wireframe(boolean wireframe)/*-{
	this.wireframe=wireframe;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter wireframeLinewidth(double wireframeLinewidth)/*-{
	this.wireframeLinewidth=wireframeLinewidth;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter wireframeLinecap(String wireframeLinecap)/*-{
	this.wireframeLinecap=wireframeLinecap;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter wireframeLinejoin(String wireframeLinejoin)/*-{
	this.wireframeLinejoin=wireframeLinejoin;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter vertexColors(int vertexColors)/*-{
	this.vertexColors=vertexColors;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter skinning(boolean skinning)/*-{
	this.skinning=skinning;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter morphTargets(boolean morphTargets)/*-{
	this.morphTargets=morphTargets;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter morphNormals(boolean morphNormals)/*-{
	this.morphNormals=morphNormals;
	return this;
	}-*/;
	
	
	//
	public final native MeshLambertMaterialParameter side(int side)/*-{
	this.side=side;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter opacity(double opacity)/*-{
	this.opacity=opacity;
	return this;
	}-*/;
	public final native MeshLambertMaterialParameter transparent(boolean transparent)/*-{
	this.transparent=transparent;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter depthTest(boolean depthTest)/*-{
	this.depthTest=depthTest;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter depthWrite(boolean depthWrite)/*-{
	this.depthWrite=depthWrite;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter polygonOffset(boolean polygonOffset)/*-{
	this.polygonOffset=polygonOffset;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter blending(int blending)/*-{
	this.blending=blending;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter blendSrc(int blendSrc)/*-{
	this.blendSrc=blendSrc;
	return this;
	}-*/;
	
	
	
	public final native MeshLambertMaterialParameter blendDst(int blendDst)/*-{
	this.blendDst=blendDst;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter blendEquation(int blendEquation)/*-{
	this.blendEquation=blendEquation;
	return this;
	}-*/;
	
	
	
	
	public final native MeshLambertMaterialParameter polygonOffsetFactor(double polygonOffsetFactor)/*-{
	this.polygonOffsetFactor=polygonOffsetFactor;
	return this;
	}-*/;
	
	public final native MeshLambertMaterialParameter polygonOffsetUnits(double polygonOffsetUnits)/*-{
	this.polygonOffsetUnits=polygonOffsetUnits;
	return this;
	}-*/;
	public final native MeshLambertMaterialParameter alphaTest(double alphaTest)/*-{
	this.alphaTest=alphaTest;
	return this;
	}-*/;
	public final native MeshLambertMaterialParameter overdraw(boolean overdraw)/*-{
	this.overdraw=overdraw;
	return this;
	}-*/;
	public final native MeshLambertMaterialParameter needsUpdate(boolean needsUpdate)/*-{
	this.needsUpdate=needsUpdate;
	return this;
	}-*/;
	
}
