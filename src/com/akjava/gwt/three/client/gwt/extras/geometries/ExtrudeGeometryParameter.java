package com.akjava.gwt.three.client.gwt.extras.geometries;

import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.gwt.materials.MeshPhongMaterialParameter;
import com.akjava.gwt.three.client.js.extras.core.CurvePath;
import com.akjava.gwt.three.client.js.extras.core.GWTCurve3;
import com.google.gwt.core.client.JavaScriptObject;

public class ExtrudeGeometryParameter extends JSParameter{

	protected ExtrudeGeometryParameter(){}
	
	public final native ExtrudeGeometryParameter curveSegments(int value)/*-{
	this.curveSegments=value;
	return this;
	}-*/;

	public final native ExtrudeGeometryParameter steps(int value)/*-{
	this.steps=value;
	return this;
	}-*/;

	public final native ExtrudeGeometryParameter amount(int value)/*-{
	this.amount=value;
	return this;
	}-*/;

	public final native ExtrudeGeometryParameter bevelEnabled(boolean value)/*-{
	this.bevelEnabled=value;
	return this;
	}-*/;

	public final native ExtrudeGeometryParameter bevelThickness(double value)/*-{
	this.bevelThickness=value;
	return this;
	}-*/;

	public final native ExtrudeGeometryParameter bevelSize(double value)/*-{
	this.bevelSize=value;
	return this;
	}-*/;

	public final native ExtrudeGeometryParameter bevelSegments(int value)/*-{
	this.bevelSegments=value;
	return this;
	}-*/;

	public final native ExtrudeGeometryParameter extrudePath(CurvePath value)/*-{
	this.extrudePath=value;
	return this;
	}-*/;
	public final native ExtrudeGeometryParameter extrudePath(GWTCurve3 value)/*-{
	this.extrudePath=value;
	return this;
	}-*/;

	//TODO support
	public final native ExtrudeGeometryParameter frames(JavaScriptObject value)/*-{
	this.frames=value;
	return this;
	}-*/;

	public final native void uvGenerator(JavaScriptObject value)/*-{
	this.uvGenerator=value;
	return this;
	}-*/;
	
	public final static ExtrudeGeometryParameter create(){
		return (ExtrudeGeometryParameter) ExtrudeGeometryParameter.createObject();
	}

}
