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
import com.akjava.gwt.three.client.js.textures.Texture;

/**

 * @author aki
 *
 */
public final class MeshBasicMaterialParameter extends JSParameter{
	protected MeshBasicMaterialParameter(){}
	public final static MeshBasicMaterialParameter create(){
		return (MeshBasicMaterialParameter) MeshBasicMaterialParameter.createObject();
	}
	
	public final MeshBasicMaterialParameter color(int r,int g,int b){
		int c=(0xff & r)<<16| (0xff & g)<<8|(0xff & b);
		return color(c);
	}
	public final native MeshBasicMaterialParameter color(int color)/*-{
	this.color=color;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter map(Texture map)/*-{
	this.map=map;
	return this;
	}-*/;
	/**
	 * @deprecated on r72
	 * @param lightMap
	 * @return
	 */
	public final native MeshBasicMaterialParameter lightMap(Texture lightMap)/*-{
	this.lightMap=lightMap;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter aoMap(Texture aoMap)/*-{
	this.aoMap=aoMap;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter aoMapIntensity(double aoMapIntensity)/*-{
	this.aoMapIntensity=aoMapIntensity;
	return this;
	}-*/;
	
	
	public final native MeshBasicMaterialParameter specularMap(Texture specularMap)/*-{
	this.specularMap=specularMap;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter envMap(Texture envMap)/*-{
	this.envMap=envMap;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter alphaMap(Texture alphaMap)/*-{
	this.alphaMap=alphaMap;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter combine(int combine)/*-{
	this.combine=combine;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter combine(double reflectivity)/*-{
	this.reflectivity=reflectivity;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter refractionRatio(double refractionRatio)/*-{
	this.refractionRatio=refractionRatio;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter fog(boolean fog)/*-{
	this.fog=fog;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter shading(int shading)/*-{
	this.shading=shading;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter wireframe(boolean wireframe)/*-{
	this.wireframe=wireframe;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter wireframeLinewidth(double wireframeLinewidth)/*-{
	this.wireframeLinewidth=wireframeLinewidth;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter wireframeLinecap(String wireframeLinecap)/*-{
	this.wireframeLinecap=wireframeLinecap;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter wireframeLinejoin(String wireframeLinejoin)/*-{
	this.wireframeLinejoin=wireframeLinejoin;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter wireframeLinejoin(int vertexColors)/*-{
	this.vertexColors=vertexColors;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter skinning(boolean skinning)/*-{
	this.skinning=skinning;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter morphTargets(boolean morphTargets)/*-{
	this.morphTargets=morphTargets;
	return this;
	}-*/;
	
	
	
	public final native MeshBasicMaterialParameter side(int side)/*-{
	this.side=side;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter opacity(double opacity)/*-{
	this.opacity=opacity;
	return this;
	}-*/;
	public final native MeshBasicMaterialParameter transparent(boolean transparent)/*-{
	this.transparent=transparent;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter depthTest(boolean depthTest)/*-{
	this.depthTest=depthTest;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter depthWrite(boolean depthWrite)/*-{
	this.depthWrite=depthWrite;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter polygonOffset(boolean polygonOffset)/*-{
	this.polygonOffset=polygonOffset;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter blending(int blending)/*-{
	this.blending=blending;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter blendSrc(int blendSrc)/*-{
	this.blendSrc=blendSrc;
	return this;
	}-*/;
	
	
	
	public final native MeshBasicMaterialParameter blendDst(int blendDst)/*-{
	this.blendDst=blendDst;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter blendEquation(int blendEquation)/*-{
	this.blendEquation=blendEquation;
	return this;
	}-*/;
	
	
	public final native MeshBasicMaterialParameter vertexColors(int vertexColors)/*-{
	this.vertexColors=vertexColors;
	return this;
	}-*/;
	
	
	
	
	
	public final native MeshBasicMaterialParameter polygonOffsetFactor(double polygonOffsetFactor)/*-{
	this.polygonOffsetFactor=polygonOffsetFactor;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter polygonOffsetUnits(double polygonOffsetUnits)/*-{
	this.polygonOffsetUnits=polygonOffsetUnits;
	return this;
	}-*/;
	public final native MeshBasicMaterialParameter alphaTest(double alphaTest)/*-{
	this.alphaTest=alphaTest;
	return this;
	}-*/;
	public final native MeshBasicMaterialParameter overdraw(boolean overdraw)/*-{
	this.overdraw=overdraw;
	return this;
	}-*/;
	public final native MeshBasicMaterialParameter needsUpdate(boolean needsUpdate)/*-{
	this.needsUpdate=needsUpdate;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter reflectivity(double reflectivity)/*-{
	this.reflectivity=reflectivity;
	return this;
	}-*/;
	
	public final native MeshBasicMaterialParameter visible(boolean visible)/*-{
	this.visible=visible;
	return this;
	}-*/;
	
}
