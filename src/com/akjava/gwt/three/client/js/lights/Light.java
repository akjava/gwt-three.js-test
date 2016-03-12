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
package com.akjava.gwt.three.client.js.lights;

import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.math.Color;


public class Light extends Object3D{
protected Light(){}

public final native Color getColor()/*-{
return this.color;
}-*/;

public final native Light copy(Light source)/*-{
return this.copy(source);
}-*/;

public final  native Light clone()/*-{
return this.clone();
}-*/;



/**
 * @deprecated
 */
public final native boolean isOnlyShadow()/*-{
return this.onlyShadow;
}-*/;
/**
 * @deprecated
 */
public final native void setOnlyShadow(boolean onlyShadow)/*-{
this.onlyShadow = onlyShadow;
}-*/;


public final native void setShadowCameraFov(double shadowCameraFov)/*-{
this.shadowCameraFov = shadowCameraFov;
}-*/;

public final native void setShadowCameraNear(double shadowCameraNear)/*-{
this.shadowCameraNear = shadowCameraNear;
}-*/;



public final native void setShadowCameraFar(double shadowCameraFar)/*-{
this.shadowCameraFar = shadowCameraFar;
}-*/;




public final native void setShadowCameraLeft(double shadowCameraLeft)/*-{
this.shadowCameraLeft = shadowCameraLeft;
}-*/;



public final native void setShadowCameraRight(double shadowCameraRight)/*-{
this.shadowCameraRight = shadowCameraRight;
}-*/;




public final native void setShadowCameraTop(double shadowCameraTop)/*-{
this.shadowCameraTop = shadowCameraTop;
}-*/;



public final native void setShadowCameraBottom(double shadowCameraBottom)/*-{
this.shadowCameraBottom = shadowCameraBottom;
}-*/;



public final native void setShadowCameraVisible(boolean shadowCameraVisible)/*-{
this.shadowCameraVisible = shadowCameraVisible;
}-*/;



public final native void setShadowBias(double shadowBias)/*-{
this.shadowBias = shadowBias;
}-*/;




public final native void setShadowDarkness(double shadowDarkness)/*-{
this.shadowDarkness = shadowDarkness;
}-*/;



public final native void setShadowMapWidth(double shadowMapWidth)/*-{
this.shadowMapWidth = shadowMapWidth;
}-*/;



public final native void setShadowMapHeight(double shadowMapHeight)/*-{
this.shadowMapHeight = shadowMapHeight;
}-*/;
}
