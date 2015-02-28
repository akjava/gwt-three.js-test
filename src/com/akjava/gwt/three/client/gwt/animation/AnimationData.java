package com.akjava.gwt.three.client.gwt.animation;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class AnimationData extends JavaScriptObject{
protected AnimationData(){}

public native final String getName ()/*-{
return this["name"];
}-*/;

public native final void setName (String name)/*-{
this["name"]=name;
}-*/;

public native final double getFps ()/*-{
return this["fps"];
}-*/;

public native final void setFps (double fps)/*-{
this["fps"]=fps;
}-*/;

/**
 * length is very important if length != last keys.time,app become a browser crasher.
 * @return
 */
public native final double getLength ()/*-{
return this["length"];
}-*/;

public native final void setLength (double length)/*-{
this["length"]=length;
}-*/;

public native final int getJIT ()/*-{
return this["JIT"];
}-*/;

public native final void setJIT (int jit)/*-{
this["JIT"]=jit;
}-*/;

public native final JsArray<AnimationHierarchyItem> getHierarchy ()/*-{
return this["hierarchy"];
}-*/;

public native final void setHierarchy (JsArray<AnimationHierarchyItem> hierarchy)/*-{
this["hierarchy"]=hierarchy;
}-*/;

public native final double getNode ()/*-{
return this["node"];
}-*/;

public native final boolean isInitialized ()/*-{
return this["initialized"];
}-*/;

}
