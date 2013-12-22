package com.akjava.gwt.three.client.js.extras.core;

public class CurveUtils {

public static  final native double tangentQuadraticBezier(double t,double p0,double p1,double p2)/*-{
return $wnd.THREE.Curve.Utils.tangentQuadraticBezier(t,p0,p1,p2);
}-*/;

public final native double tangentCubicBezier(double t,double p0,double p1,double p2,double p3)/*-{
return $wnd.THREE.Curve.Utils.tangentCubicBezier(t,p0,p1,p2,p3);
}-*/;

public final native double tangentSpline(double t,double p0,double p1,double p2,double p3)/*-{
return $wnd.THREE.Curve.Utils.tangentSpline(t,p0,p1,p2,p3);
}-*/;

public final native double interpolate(double p0,double p1,double p2,double p3,double t)/*-{
return $wnd.THREE.Curve.Utils.interpolate(p0,p1,p2,p3,t);
}-*/;


}
