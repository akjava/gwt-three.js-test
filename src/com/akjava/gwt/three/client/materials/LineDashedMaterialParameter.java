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

/**
 * can't overwrite.copy this as base
 * @author aki
 *
 */
public final class LineDashedMaterialParameter extends JSParameter{
	protected LineDashedMaterialParameter(){}
	public final static LineDashedMaterialParameter create(){
		return (LineDashedMaterialParameter) LineDashedMaterialParameter.createObject();
	}
	public final LineDashedMaterialParameter color(int r,int g,int b){
		int c=(0xff & r)<<16| (0xff & g)<<8|(0xff & b);
		return color(c);
	}
	
	
	
	public final native LineDashedMaterialParameter color(int color)/*-{
	this.color=color;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter lineWidth(double lineWidth)/*-{
	this.lineWidth=lineWidth;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter scale(double scale)/*-{
	this.scale=scale;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter dashSize(double dashSize)/*-{
	this.dashSize=dashSize;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter gapSize(double gapSize)/*-{
	this.gapSize=gapSize;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter vertexColors(boolean vertexColors)/*-{
	this.vertexColors=vertexColors;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter fog(boolean fog)/*-{
	this.fog=fog;
	return this;
	}-*/;
	
	
	public final native LineDashedMaterialParameter side(int side)/*-{
	this.side=side;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter opacity(double opacity)/*-{
	this.opacity=opacity;
	return this;
	}-*/;
	public final native LineDashedMaterialParameter transparent(boolean transparent)/*-{
	this.transparent=transparent;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter depthTest(boolean depthTest)/*-{
	this.depthTest=depthTest;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter depthWrite(boolean depthWrite)/*-{
	this.depthWrite=depthWrite;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter polygonOffset(boolean polygonOffset)/*-{
	this.polygonOffset=polygonOffset;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter blending(int blending)/*-{
	this.blending=blending;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter blendSrc(int blendSrc)/*-{
	this.blendSrc=blendSrc;
	return this;
	}-*/;
	
	
	
	public final native LineDashedMaterialParameter blendDst(int blendDst)/*-{
	this.blendDst=blendDst;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter blendEquation(int blendEquation)/*-{
	this.blendEquation=blendEquation;
	return this;
	}-*/;
	
	
	
	
	public final native LineDashedMaterialParameter polygonOffsetFactor(double polygonOffsetFactor)/*-{
	this.polygonOffsetFactor=polygonOffsetFactor;
	return this;
	}-*/;
	
	public final native LineDashedMaterialParameter polygonOffsetUnits(double polygonOffsetUnits)/*-{
	this.polygonOffsetUnits=polygonOffsetUnits;
	return this;
	}-*/;
	public final native LineDashedMaterialParameter alphaTest(double alphaTest)/*-{
	this.alphaTest=alphaTest;
	return this;
	}-*/;
	public final native LineDashedMaterialParameter overdraw(double overdraw)/*-{
	this.overdraw=overdraw;
	return this;
	}-*/;
	public final native LineDashedMaterialParameter needsUpdate(boolean needsUpdate)/*-{
	this.needsUpdate=needsUpdate;
	return this;
	}-*/;
	
}
