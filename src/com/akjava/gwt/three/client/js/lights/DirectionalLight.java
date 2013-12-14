package com.akjava.gwt.three.client.js.lights;

import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

public class DirectionalLight extends Light{
	protected DirectionalLight(){}
	

public final native Object3D getTarget()/*-{
return this.target;
}-*/;

public final native void setTarget(Object3D target)/*-{
this.target = target;
}-*/;


public final native Object getIntensity()/*-{
return this.intensity;
}-*/;

public final native void setIntensity(Object intensity)/*-{
this.intensity = intensity;
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


public final native double getShadowCameraLeft()/*-{
return this.shadowCameraLeft;
}-*/;

public final native void setShadowCameraLeft(double shadowCameraLeft)/*-{
this.shadowCameraLeft = shadowCameraLeft;
}-*/;


public final native double getShadowCameraRight()/*-{
return this.shadowCameraRight;
}-*/;

public final native void setShadowCameraRight(double shadowCameraRight)/*-{
this.shadowCameraRight = shadowCameraRight;
}-*/;


public final native double getShadowCameraTop()/*-{
return this.shadowCameraTop;
}-*/;

public final native void setShadowCameraTop(double shadowCameraTop)/*-{
this.shadowCameraTop = shadowCameraTop;
}-*/;


public final native double getShadowCameraBottom()/*-{
return this.shadowCameraBottom;
}-*/;

public final native void setShadowCameraBottom(double shadowCameraBottom)/*-{
this.shadowCameraBottom = shadowCameraBottom;
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


public final native boolean isShadowCascade()/*-{
return this.shadowCascade;
}-*/;

public final native void setShadowCascade(boolean shadowCascade)/*-{
this.shadowCascade = shadowCascade;
}-*/;


public final native Vector3 getShadowCascadeOffset()/*-{
return this.shadowCascadeOffset;
}-*/;

public final native void setShadowCascadeOffset(Vector3 shadowCascadeOffset)/*-{
this.shadowCascadeOffset = shadowCascadeOffset;
}-*/;


public final native double getShadowCascadeCount()/*-{
return this.shadowCascadeCount;
}-*/;

public final native void setShadowCascadeCount(double shadowCascadeCount)/*-{
this.shadowCascadeCount = shadowCascadeCount;
}-*/;


public final native JsArrayNumber getShadowCascadeBias()/*-{
return this.shadowCascadeBias;
}-*/;

public final native void setShadowCascadeBias(JsArrayNumber shadowCascadeBias)/*-{
this.shadowCascadeBias = shadowCascadeBias;
}-*/;


public final native JsArrayNumber getShadowCascadeWidth()/*-{
return this.shadowCascadeWidth;
}-*/;

public final native void setShadowCascadeWidth(JsArrayNumber shadowCascadeWidth)/*-{
this.shadowCascadeWidth = shadowCascadeWidth;
}-*/;


public final native JsArrayNumber getShadowCascadeHeight()/*-{
return this.shadowCascadeHeight;
}-*/;

public final native void setShadowCascadeHeight(JsArrayNumber shadowCascadeHeight)/*-{
this.shadowCascadeHeight = shadowCascadeHeight;
}-*/;


public final native JsArrayNumber getShadowCascadeNearZ()/*-{
return this.shadowCascadeNearZ;
}-*/;

public final native void setShadowCascadeNearZ(JsArrayNumber shadowCascadeNearZ)/*-{
this.shadowCascadeNearZ = shadowCascadeNearZ;
}-*/;


public final native JsArrayNumber getShadowCascadeFarZ()/*-{
return this.shadowCascadeFarZ;
}-*/;

public final native void setShadowCascadeFarZ(JsArrayNumber shadowCascadeFarZ)/*-{
this.shadowCascadeFarZ = shadowCascadeFarZ;
}-*/;


public final native JsArray<JavaScriptObject> getShadowCascadeArray()/*-{
return this.shadowCascadeArray;
}-*/;

public final native void setShadowCascadeArray(JsArray<JavaScriptObject> shadowCascadeArray)/*-{
this.shadowCascadeArray = shadowCascadeArray;
}-*/;


public final native Object getShadowMap()/*-{
return this.shadowMap;
}-*/;

public final native void setShadowMap(Object shadowMap)/*-{
this.shadowMap = shadowMap;
}-*/;


public final native Object getShadowMapSize()/*-{
return this.shadowMapSize;
}-*/;

public final native void setShadowMapSize(Object shadowMapSize)/*-{
this.shadowMapSize = shadowMapSize;
}-*/;


public final native Object getShadowCamera()/*-{
return this.shadowCamera;
}-*/;

public final native void setShadowCamera(Object shadowCamera)/*-{
this.shadowCamera = shadowCamera;
}-*/;


public final native Object getShadowMatrix()/*-{
return this.shadowMatrix;
}-*/;

public final native void setShadowMatrix(Object shadowMatrix)/*-{
this.shadowMatrix = shadowMatrix;
}-*/;

public final native DirectionalLight clone()/*-{
return this.clone();
}-*/;

}
