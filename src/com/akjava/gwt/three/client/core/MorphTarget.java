package com.akjava.gwt.three.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class MorphTarget extends JavaScriptObject{
protected MorphTarget(){}

public final native JsArray<Vertex> getVertices()/*-{
return this.vertices;
}-*/;
}
