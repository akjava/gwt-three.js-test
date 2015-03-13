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
import com.akjava.gwt.three.client.gwt.extras.Defines;
import com.akjava.gwt.three.client.gwt.extras.Uniforms;
import com.akjava.gwt.three.client.java.ShaderMaterialBuilder;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * can't overwrite.copy this as base
 * @author aki
 *
 */
public final class ShaderMaterialParameter extends JSParameter{
	protected ShaderMaterialParameter(){}
	public final static ShaderMaterialParameter create(){
		return (ShaderMaterialParameter) ShaderMaterialParameter.createObject();
	}
	public final native ShaderMaterialParameter fragmentShader(String fragmentShader)/*-{
	this.fragmentShader=fragmentShader;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter vertexShader(String vertexShader)/*-{
	this.vertexShader=vertexShader;
	return this;
	}-*/;
	public final native ShaderMaterialParameter vertexShader(Uniforms uniforms)/*-{
	this.uniforms=uniforms;
	return this;
	}-*/;
	public final native ShaderMaterialParameter defines(Defines defines)/*-{
	this.defines=defines;
	return this;
	}-*/;
	public final native ShaderMaterialParameter shading(int shading)/*-{
	this.shading=shading;
	return this;
	}-*/;

	public final native ShaderMaterialParameter uniforms(Uniforms uniforms)/*-{
	this["uniforms"]=uniforms;
	return this;
	}-*/;
	/**

	this.linewidth = 1;

	this.wireframe = false;
	this.wireframeLinewidth = 1;

	this.fog = false; // set to use scene fog

	this.lights = false; // set to use scene lights

	this.vertexColors = THREE.NoColors; // set to use "color" attribute stream

	this.skinning = false; // set to use skinning attribute streams

	this.morphTargets = false; // set to use morph targets
	this.morphNormals = false; // set to use morph normals

	// When rendered geometry doesn't include these attributes but the material does,
	// use these default values in WebGL. This avoids errors when buffer data is missing.
	this.defaultAttributeValues = {
		"color" : [ 1, 1, 1],
		"uv" : [ 0, 0 ],
		"uv2" : [ 0, 0 ]
	};

	// By default, bind position to attribute index 0. In WebGL, attribute 0
	// should always be used to avoid potentially expensive emulation.
	this.index0AttributeName = "position";
	 * 
	 * @param side
	 * @return
	 */
	
	public final native ShaderMaterialParameter linewidth(double linewidth)/*-{
	this.linewidth=linewidth;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter wireframe(boolean wireframe)/*-{
	this.wireframe=wireframe;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter wireframeLinewidth(double wireframeLinewidth)/*-{
	this.wireframeLinewidth=wireframeLinewidth;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter fog(boolean fog)/*-{
	this.fog=fog;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter lights(boolean lights)/*-{
	this.lights=lights;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter vertexColors(int vertexColors)/*-{
	this.vertexColors=vertexColors;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter morphTargets(boolean morphTargets)/*-{
	this.morphTargets=morphTargets;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter morphNormals(boolean morphNormals)/*-{
	this.morphNormals=morphNormals;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter skinning(boolean skinning)/*-{
	this.skinning=skinning;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter defaultAttributeValues(JavaScriptObject defaultAttributeValues)/*-{
	this.defaultAttributeValues=defaultAttributeValues;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter index0AttributeName(String index0AttributeName)/*-{
	this.index0AttributeName=index0AttributeName;
	return this;
	}-*/;
	
	public final native PointCloudMaterialParameter side(int side)/*-{
	this.side=side;
	return this;
	}-*/;
	
	
	public final native ShaderMaterialParameter opacity(double opacity)/*-{
	this.opacity=opacity;
	return this;
	}-*/;
	public final native ShaderMaterialParameter transparent(boolean transparent)/*-{
	this.transparent=transparent;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter depthTest(boolean depthTest)/*-{
	this.depthTest=depthTest;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter depthWrite(boolean depthWrite)/*-{
	this.depthWrite=depthWrite;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter polygonOffset(boolean polygonOffset)/*-{
	this.polygonOffset=polygonOffset;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter blending(int blending)/*-{
	this.blending=blending;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter blendSrc(int blendSrc)/*-{
	this.blendSrc=blendSrc;
	return this;
	}-*/;
	
	
	
	public final native ShaderMaterialParameter blendDst(int blendDst)/*-{
	this.blendDst=blendDst;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter blendEquation(int blendEquation)/*-{
	this.blendEquation=blendEquation;
	return this;
	}-*/;
	
	
	
	
	public final native ShaderMaterialParameter polygonOffsetFactor(double polygonOffsetFactor)/*-{
	this.polygonOffsetFactor=polygonOffsetFactor;
	return this;
	}-*/;
	
	public final native ShaderMaterialParameter polygonOffsetUnits(double polygonOffsetUnits)/*-{
	this.polygonOffsetUnits=polygonOffsetUnits;
	return this;
	}-*/;
	public final native ShaderMaterialParameter alphaTest(double alphaTest)/*-{
	this.alphaTest=alphaTest;
	return this;
	}-*/;
	public final native ShaderMaterialParameter overdraw(double overdraw)/*-{
	this.overdraw=overdraw;
	return this;
	}-*/;
	public final native ShaderMaterialParameter needsUpdate(boolean needsUpdate)/*-{
	this.needsUpdate=needsUpdate;
	return this;
	}-*/;
	
}
