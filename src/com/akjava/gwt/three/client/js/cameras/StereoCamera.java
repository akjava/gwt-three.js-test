package com.akjava.gwt.three.client.js.cameras;
import com.google.gwt.core.client.JavaScriptObject;
public class StereoCamera extends JavaScriptObject{
protected StereoCamera(){}

public final  native String getType()/*-{
return this.type;
}-*/;
public final  native double getAspect()/*-{
return this.aspect;
}-*/;
public final  native PerspectiveCamera getCameraL()/*-{
return this.cameraL;
}-*/;
public final  native PerspectiveCamera getCameraR()/*-{
return this.cameraR;
}-*/;

public final  native void update(PerspectiveCamera camera)/*-{
this.update(camera);
}-*/;


}