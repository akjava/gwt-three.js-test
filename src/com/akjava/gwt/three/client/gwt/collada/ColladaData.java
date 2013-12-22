package com.akjava.gwt.three.client.gwt.collada;

import com.akjava.gwt.three.client.js.core.Geometry;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

public class ColladaData extends JavaScriptObject{
protected ColladaData(){}


public native final Geometry getGeometry()/*-{
return this.skins[0].geometry;
}-*/;

public native final JsArrayString getJoints()/*-{
return this.skins[0].skinController.skin.joints;
}-*/;

public native final JsArray<JsArray<WeightData>> getWeights()/*-{
return this.skins[0].skinController.skin.weights;
}-*/;



}
