package com.akjava.gwt.three.client.extras.core;

import com.akjava.gwt.three.client.math.Vector2;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ShapeUtils {
private ShapeUtils(){}


public final native JavaScriptObject removeHoles(JsArray<Vector2> contour,JsArray<JsArray<Vector2>> holes)/*-{
return this.removeHoles(contour,holes);
}-*/;

public final native JavaScriptObject triangulateShape(JsArray<Vector2> contour,JsArray<JsArray<Vector2>> holes)/*-{
return this.triangulateShape(contour,holes);
}-*/;

public final native JavaScriptObject triangulate2(JsArray<Vector2> pts,JsArray<JsArray<Vector2>> holes)/*-{
return this.triangulate2(pts,holes);
}-*/;

public final native boolean isClockWise(JsArray<Vector2> pts)/*-{
return this.isClockWise(pts);
}-*/;

public final native double b2p0(double t,double p)/*-{
return this.b2p0(t,p);
}-*/;

public final native double b2p1(double t,double p)/*-{
return this.b2p1(t,p);
}-*/;

public final native double b2p2(double t,double p)/*-{
return this.b2p2(t,p);
}-*/;

public final native double b2(double t,double p0,double p1,double p2)/*-{
return this.b2(t,p0,p1,p2);
}-*/;

public final native double b3p0(double t,double p)/*-{
return this.b3p0(t,p);
}-*/;

public final native double b3p1(double t,double p)/*-{
return this.b3p1(t,p);
}-*/;

public final native double b3p2(double t,double p)/*-{
return this.b3p2(t,p);
}-*/;

public final native double b3p3(double t,double p)/*-{
return this.b3p3(t,p);
}-*/;

public final native double b3(double t,double p0,double p1,double p2,double p3)/*-{
return this.b3(t,p0,p1,p2,p3);
}-*/;

}
