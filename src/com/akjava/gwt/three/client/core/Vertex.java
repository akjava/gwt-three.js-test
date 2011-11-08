package com.akjava.gwt.three.client.core;

import com.google.gwt.core.client.JavaScriptObject;

public class Vertex extends JavaScriptObject{
protected Vertex(){}


public final native Vector3 getPosition()/*-{
return this.position;
}-*/;

}
