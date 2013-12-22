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
package com.akjava.gwt.three.client.java;

import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * @deprecated use LineBasicMaterialParameter
 * @author aki
 *
 */
public class LineBasicMaterialBuilder extends JavaScriptObject{
	protected LineBasicMaterialBuilder(){}
	public final static LineBasicMaterialBuilder create(){
		return (LineBasicMaterialBuilder) LineBasicMaterialBuilder.createObject();
	}
	
	public final static LineBasicMaterialBuilder create(int color){
		LineBasicMaterialBuilder builder= (LineBasicMaterialBuilder) LineBasicMaterialBuilder.createObject();
		return builder.color(color);
	}
	
	public final LineBasicMaterialBuilder color(int r,int g,int b){
		int c=(0xff & r)<<16| (0xff & g)<<8|(0xff & b);
		return color(c);
	}
	
	
	
	public final native LineBasicMaterialBuilder color(int c)/*-{
	this["color"]=c;
	return this;
	}-*/;
	
	public final native LineBasicMaterialBuilder morphTargets(boolean w)/*-{
	this["morphTargets"]=w;
	return this;
	}-*/;
	
	public final native LineBasicMaterialBuilder map(Texture texture)/*-{
	this["map"]=texture;
	return this;
	}-*/;
	
	
	
	public final native LineBasicMaterialBuilder linewidth(double linewidth)/*-{
	this.linewidth=linewidth;
	return this;
	}-*/;
	
	public final native LineBasicMaterialBuilder opacity(double opacity)/*-{
	this.opacity=opacity;
	return this;
	}-*/;
	
	public final native LineBasicMaterialBuilder reflectivity(boolean reflectivity)/*-{
	this.reflectivity=reflectivity;
	return this;
	}-*/;
	public final native LineBasicMaterialBuilder transparent(boolean transparent)/*-{
	this.transparent=transparent;
	return this;
	}-*/;
	
	public final native LineBasicMaterialBuilder wireFrame(boolean w)/*-{
	this["wireframe"]=w;
	return this;
	}-*/;
	
	public final native LineBasicMaterialBuilder blending(int type)/*-{
	this["blending"]=type;
	return this;
	}-*/;
	
	public final native LineBasicMaterialBuilder wireFrame()/*-{
	this["wireframe"]=true;
	return this;
	}-*/;
	public final Material build(){
		return build(this);
	}
	
	private final native Material build(JavaScriptObject object)/*-{
	return new $wnd.THREE.LineBasicMaterial(object);
	}-*/;
	
	
}
