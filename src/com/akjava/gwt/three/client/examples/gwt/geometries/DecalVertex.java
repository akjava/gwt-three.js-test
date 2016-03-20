package com.akjava.gwt.three.client.examples.gwt.geometries;

import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;

public class DecalVertex extends JavaScriptObject{
	protected DecalVertex(){}
	
	public final native Vector3 getVertex()/*-{
	return this.vertex;
	}-*/;
	
	public final native Vector3 getNormal()/*-{
	return this.normal;
	}-*/;
	public final native DecalVertex clone()/*-{
	return this.clone();
	}-*/;
	
	public static final native DecalVertex create(Vector3 vertex,Vector3 normal)/*-{
	return $wnd.THREE.DecalVertex(vertex,normal);
	}-*/;
}
