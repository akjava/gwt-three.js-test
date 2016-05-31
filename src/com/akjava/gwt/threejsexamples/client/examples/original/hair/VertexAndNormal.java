package com.akjava.gwt.threejsexamples.client.examples.original.hair;

import com.akjava.gwt.three.client.js.math.Vector3;
/**
 * @deprecated don't modify here
 * @author aki
 *
 */
public class VertexAndNormal {
private Vector3 vertex;
public VertexAndNormal(Vector3 vertex, Vector3 vertexNormal) {
	super();
	this.vertex = vertex;
	this.vertexNormal = vertexNormal;
}
public Vector3 getVertex() {
	return vertex;
}
public void setVertex(Vector3 vertex) {
	this.vertex = vertex;
}
public Vector3 getVertexNormal() {
	return vertexNormal;
}
public void setVertexNormal(Vector3 vertexNormal) {
	this.vertexNormal = vertexNormal;
}
private Vector3 vertexNormal;
}
