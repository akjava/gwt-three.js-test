package com.akjava.gwt.three.client.gwt.collada;

import com.google.gwt.core.client.JavaScriptObject;

public class WeightData extends JavaScriptObject{
protected WeightData(){}

public native final int getJoint()/*-{
return this.joint;
}-*/;

public native final double getWeight()/*-{
return this.weight;
}-*/;

}
