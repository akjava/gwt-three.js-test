package com.akjava.gwt.three.client.gwt;

import java.util.List;

import com.akjava.gwt.three.client.gwt.math.XYObject;


/**
 * but now Spline is in three.js
 * http://sole.github.com/tween.js/examples/05_spline.html
 * @author aki
 *
 */
public class GWTSpline {

	public static XYObject get2DPoint(List<XYObject> points,double value){
		double point = ( points.size() - 1 ) * value;
		int intPoint = (int) java.lang.Math.floor( point );
		double weight = point - intPoint;
		int[] c=new int[4];
		
		c[ 0 ] = intPoint == 0 ? intPoint : intPoint - 1;
		c[ 1 ] = intPoint;
		c[ 2 ] = intPoint > points.size() - 2 ? intPoint : intPoint + 1;
		c[ 3 ] = intPoint > points.size() - 3 ? intPoint : intPoint + 2;
		
		double x = GWTSpline.interpolate( points.get(c[0]).getX(), points.get(c[1]).getX(),points.get(c[2]).getX(),points.get(c[3]).getX(), weight );
		double y = GWTSpline.interpolate( points.get(c[0]).getY(), points.get(c[1]).getY(),points.get(c[2]).getY(),points.get(c[3]).getY(), weight );
	
		return XYObject.create(x, y);
	}
	
	// Catmull-Rom
	public static  final native double interpolate(double p0,double p1,double p2,double p3,double t)/*-{
	var v0 = ( p2 - p0 ) * 0.5;
					var v1 = ( p3 - p1 ) * 0.5;
					var t2 = t * t;
					var t3 = t * t2;
					return ( 2 * p1 - 2 * p2 + v0 + v1 ) * t3 + ( - 3 * p1 + 3 * p2 - 2 * v0 - v1 ) * t2 + v0 * t + p1;
	}-*/;
}
