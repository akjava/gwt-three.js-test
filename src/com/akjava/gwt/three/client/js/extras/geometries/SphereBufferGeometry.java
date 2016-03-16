package com.akjava.gwt.three.client.js.extras.geometries;

import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.js.core.BufferGeometry;

public class SphereBufferGeometry extends BufferGeometry{
	protected SphereBufferGeometry() {
	}


	public final  native JSParameter getParameters()/*-{
	return this.parameters;
	}-*/;
	
}
