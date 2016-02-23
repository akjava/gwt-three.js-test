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
package com.akjava.gwt.three.client.js.materials;

import com.akjava.gwt.three.client.js.core.EventDispatcher;
import com.akjava.gwt.three.client.js.math.Color;
import com.google.gwt.core.client.JavaScriptObject;

public class Material extends EventDispatcher{
protected Material(){}

public final native int getId()/*-{
return this.id;
}-*/;

public final native void setId(Object id)/*-{
this.id = id;
}-*/;


public final native String getUuid()/*-{
return this.uuid;
}-*/;

public final native void setUuid(String uuid)/*-{
this.uuid = uuid;
}-*/;


public final native String getName()/*-{
return this.name;
}-*/;

public final native void setName(String name)/*-{
this.name = name;
}-*/;

public final native int getSide()/*-{
return this.side;
}-*/;

public final native void setSide(int side)/*-{
this.side = side;
}-*/;

public final native boolean isTransparent()/*-{
return this.transparent;
}-*/;

public final native void setTransparent(boolean transparent)/*-{
this.transparent = transparent;
}-*/;

/**
 * THREE.BLENDING
 */
public final native int getBlending()/*-{
return this.blending;
}-*/;
/**
 * THREE.BLENDING
 */
public final native void setBlending(int blending)/*-{
this.blending = blending;
}-*/;



public final native void setOpacity(double opacity)/*-{
this.opacity=opacity;
}-*/;

public final native double getOpacity()/*-{
return this.opacity;
}-*/;




public final native int getBlendSrc()/*-{
return this.blendSrc;
}-*/;

public final native void setBlendSrc(int blendSrc)/*-{
this.blendSrc = blendSrc;
}-*/;


public final native int getBlendDst()/*-{
return this.blendDst;
}-*/;

public final native void setBlendDst(int blendDst)/*-{
this.blendDst = blendDst;
}-*/;


public final native int getBlendEquation()/*-{
return this.blendEquation;
}-*/;

public final native void setBlendEquation(int blendEquation)/*-{
this.blendEquation = blendEquation;
}-*/;


public final native boolean isDepthTest()/*-{
return this.depthTest;
}-*/;

public final native void setDepthTest(boolean depthTest)/*-{
this.depthTest = depthTest;
}-*/;


public final native boolean isDepthWrite()/*-{
return this.depthWrite;
}-*/;

public final native void setDepthWrite(boolean depthWrite)/*-{
this.depthWrite = depthWrite;
}-*/;


public final native boolean isPolygonOffset()/*-{
return this.polygonOffset;
}-*/;

public final native void setPolygonOffset(boolean polygonOffset)/*-{
this.polygonOffset = polygonOffset;
}-*/;


public final native double getPolygonOffsetFactor()/*-{
return this.polygonOffsetFactor;
}-*/;

public final native void setPolygonOffsetFactor(double polygonOffsetFactor)/*-{
this.polygonOffsetFactor = polygonOffsetFactor;
}-*/;


public final native double getPolygonOffsetUnits()/*-{
return this.polygonOffsetUnits;
}-*/;

public final native void setPolygonOffsetUnits(double polygonOffsetUnits)/*-{
this.polygonOffsetUnits = polygonOffsetUnits;
}-*/;


public final native double getAlphaTest()/*-{
return this.alphaTest;
}-*/;

public final native void setAlphaTest(double alphaTest)/*-{
this.alphaTest = alphaTest;
}-*/;


public final native double getOverdraw()/*-{
return this.overdraw;
}-*/;

public final native void setOverdraw(double overdraw)/*-{
this.overdraw = overdraw;
}-*/;


public final native boolean isVisible()/*-{
return this.visible;
}-*/;

public final native void setVisible(boolean visible)/*-{
this.visible = visible;
}-*/;


public final native boolean isNeedsUpdate()/*-{
return this.needsUpdate;
}-*/;

public final native void setNeedsUpdate(boolean needsUpdate)/*-{
this.needsUpdate = needsUpdate;
}-*/;

public final native Material clone(Material material)/*-{
return this.clone(material);
}-*/;

public final native void dispose()/*-{
this.dispose();
}-*/;

public final native void setValues(JavaScriptObject parameters)/*-{
 this.setValues(parameters);
}-*/;

//force get color
public final native Color gwtGetColor()/*-{
return this.color;
}-*/;

public final native void gwtSet(String name,double value)/*-{
this[name]=value;
}-*/;
public final native void gwtSet(String name,String value)/*-{
this[name]=value;
}-*/;
public final native void gwtSet(String name,boolean value)/*-{
this[name]=value;
}-*/;
public final native void gwtSet(String name,JavaScriptObject value)/*-{
this[name]=value;
}-*/;
public final native void gwtSet(String name,Color value)/*-{
this[name]=value;
}-*/;

public final native int getBlendSrcAlpha()/*-{
return this.blendSrcAlpha;
}-*/;

public final native void setBlendSrcAlpha(int blendSrcAlpha)/*-{
this.blendSrcAlpha = blendSrcAlpha;
}-*/;

public final native void gwtClearBlendSrcAlpha()/*-{
this.blendSrcAlpha=null;
}-*/;

public final native int getBlendDstAlpha()/*-{
return this.blendDstAlpha;
}-*/;

public final native void setBlendDstcAlpha(int blendDstAlpha)/*-{
this.blendDstAlpha = blendDstAlpha;
}-*/;

public final native void gwtClearBlendDstAlpha()/*-{
this.blendDstAlpha=null;
}-*/;

public final native int getBlendEquationAlpha()/*-{
return this.blendEquationAlpha;
}-*/;

public final native void setBlendEquationcAlpha(int blendEquationAlpha)/*-{
this.blendEquationAlpha = blendEquationAlpha;
}-*/;

public final native void gwtClearBlendEquationAlpha()/*-{
this.blendEquationAlpha=null;
}-*/;

}
