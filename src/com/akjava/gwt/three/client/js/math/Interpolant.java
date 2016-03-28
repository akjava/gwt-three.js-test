package com.akjava.gwt.three.client.js.math;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * abstract class no need to constructor
 * @author aki
 *
 */
public class Interpolant extends JavaScriptObject{
protected Interpolant(){}

public final  native JsArrayNumber getParameterPositions()/*-{
return this.parameterPositions;
}-*/;

public final  native void setParameterPositions(JsArrayNumber  param)/*-{
this.parameterPositions=param;
}-*/;
/**
 * usually JsArrayNumber
 * @return
 */
public final  native JavaScriptObject getSampleValues()/*-{
return this.sampleValues;
}-*/;

public final  native void setSampleValues(JavaScriptObject  param)/*-{
this.sampleValues=param;
}-*/;
public final  native int getSampleSize()/*-{
return this.sampleSize;
}-*/;

public final  native void setSampleSize(int  param)/*-{
this.sampleSize=param;
}-*/;


public final  native JsArrayMixed getResultBuffer()/*-{
return this.resultBuffer;
}-*/;

public final  native void setResultBuffer(JsArrayMixed  param)/*-{
this.resultBuffer=param;
}-*/;

public final  native JavaScriptObject getSettings()/*-{
return this.settings;
}-*/;

public final  native void setSettings(JavaScriptObject  param)/*-{
this.settings=param;
}-*/;
}