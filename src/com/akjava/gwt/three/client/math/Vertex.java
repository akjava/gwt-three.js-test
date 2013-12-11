package com.akjava.gwt.three.client.math;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @deprecated  totall removed at r49
 * @author aki
 *
 */
public class Vertex extends JavaScriptObject{
protected Vertex(){}


public final native Vector3 getPosition()/*-{
return this.position;
}-*/;

}
