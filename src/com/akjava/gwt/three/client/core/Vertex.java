package com.akjava.gwt.three.client.core;

import com.akjava.gwt.three.client.math.Vector3;
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
