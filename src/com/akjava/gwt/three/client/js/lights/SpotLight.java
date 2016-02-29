/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2013 akimisaki3@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r63
 https://github.com/mrdoob/three.js
 The MIT License

Copyright (c) 2010-2013 three.js Authors. All rights reserved.

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

import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.math.Matrix4;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderTarget;


public class SpotLight extends Light{
	protected SpotLight() {
	}

public final native Object3D getTarget()/*-{
return this.target;
}-*/;

public final native void setTarget(Object3D target)/*-{
this.target = target;
}-*/;


public final native double getIntensity()/*-{
return this.intensity;
}-*/;

public final native void setIntensity(double intensity)/*-{
this.intensity = intensity;
}-*/;


public final native double getDistance()/*-{
return this.distance;
}-*/;

public final native void setDistance(double distance)/*-{
this.distance = distance;
}-*/;


public final native double getAngle()/*-{
return this.angle;
}-*/;

public final native void setAngle(double angle)/*-{
this.angle = angle;
}-*/;


public final native double getExponent()/*-{
return this.exponent;
}-*/;

public final native void setExponent(double exponent)/*-{
this.exponent = exponent;
}-*/;





public final native boolean isOnlyShadow()/*-{
return this.onlyShadow;
}-*/;

public final native void setOnlyShadow(boolean onlyShadow)/*-{
this.onlyShadow = onlyShadow;
}-*/;


public final native double getShadowCameraNear()/*-{
return this.shadowCameraNear;
}-*/;

public final native void setShadowCameraNear(double shadowCameraNear)/*-{
this.shadowCameraNear = shadowCameraNear;
}-*/;


public final native double getShadowCameraFar()/*-{
return this.shadowCameraFar;
}-*/;

public final native void setShadowCameraFar(double shadowCameraFar)/*-{
this.shadowCameraFar = shadowCameraFar;
}-*/;


public final native double getShadowCameraFov()/*-{
return this.shadowCameraFov;
}-*/;

public final native void setShadowCameraFov(double shadowCameraFov)/*-{
this.shadowCameraFov = shadowCameraFov;
}-*/;


public final native boolean isShadowCameraVisible()/*-{
return this.shadowCameraVisible;
}-*/;

public final native void setShadowCameraVisible(boolean shadowCameraVisible)/*-{
this.shadowCameraVisible = shadowCameraVisible;
}-*/;


public final native double getShadowBias()/*-{
return this.shadowBias;
}-*/;

public final native void setShadowBias(double shadowBias)/*-{
this.shadowBias = shadowBias;
}-*/;


public final native double getShadowDarkness()/*-{
return this.shadowDarkness;
}-*/;

public final native void setShadowDarkness(double shadowDarkness)/*-{
this.shadowDarkness = shadowDarkness;
}-*/;


public final native double getShadowMapWidth()/*-{
return this.shadowMapWidth;
}-*/;

public final native void setShadowMapWidth(double shadowMapWidth)/*-{
this.shadowMapWidth = shadowMapWidth;
}-*/;


public final native double getShadowMapHeight()/*-{
return this.shadowMapHeight;
}-*/;

public final native void setShadowMapHeight(double shadowMapHeight)/*-{
this.shadowMapHeight = shadowMapHeight;
}-*/;


public final native WebGLRenderTarget getShadowMap()/*-{
return this.shadowMap;
}-*/;

public final native void setShadowMap(WebGLRenderTarget shadowMap)/*-{
this.shadowMap = shadowMap;
}-*/;

//FUTURE after implement Vector2
//public final native Vector2 getShadowMapSize()/*-{
//return this.shadowMapSize;
//}-*/;

//public final native void setShadowMapSize(Vector2 shadowMapSize)/*-{
//this.shadowMapSize = shadowMapSize;
//}-*/;


public final native Camera getShadowCamera()/*-{
return this.shadowCamera;
}-*/;

public final native void setShadowCamera(Camera shadowCamera)/*-{
this.shadowCamera = shadowCamera;
}-*/;


public final native Matrix4 getShadowMatrix()/*-{
return this.shadowMatrix;
}-*/;

public final native void setShadowMatrix(Matrix4 shadowMatrix)/*-{
this.shadowMatrix = shadowMatrix;
}-*/;



public final native double getDecay()/*-{
return this.decay;
}-*/;

public final native void setDecay(double decay)/*-{
this.decay = decay;
}-*/;

}
