/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2011 aki@akjava.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r45
 https://github.com/mrdoob/three.js
 The MIT License

Copyright (c) 2010-2011 three.js Authors. All rights reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
  
 */
package com.akjava.gwt.three.client.js.math;

import com.akjava.gwt.three.client.gwt.core.Intersect;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Ray extends JavaScriptObject{
protected Ray(){}

public final native Vector3 getOrigin()/*-{
return this.origin;
}-*/;

public final native Vector3 getDirection()/*-{
return this.direction;
}-*/;



public final native Ray set(Vector3 origin,Vector3 direction)/*-{
return this.set(origin,direction);
}-*/;

public final native Ray copy(Ray ray)/*-{
return this.copy(ray);
}-*/;


public final native Vector3 at(double t,Vector3 optionalTarget)/*-{
return this.at(t,optionalTarget);
}-*/;

public final native Ray recast(double t)/*-{
return this.recast();
}-*/;

public final native Vector3 closestPointToPoint(Vector3 point,Vector3 optionalTarget)/*-{
return this.closestPointToPoint(point,optionalTarget);
}-*/;

public final native double distanceToPoint(Vector3 point)/*-{
return this.distanceToPoint(point);
}-*/;

public final native double distanceSqToSegment(Vector3 v0,Vector3 v1,Vector3 optionalPointOnRay,Vector3 optionalPointOnSegment)/*-{
return this.distanceSqToSegment(v0,v1,optionalPointOnRay,optionalPointOnSegment);
}-*/;

public final native boolean isIntersectionSphere(Sphere sphere)/*-{
return this.isIntersectionSphere(sphere);
}-*/;

public final native boolean isIntersectionPlane(Plane plane)/*-{
return this.isIntersectionPlane(plane);
}-*/;

public final native Double distanceToPlane(Plane plane)/*-{
return this.distanceToPlane(plane);
}-*/;

public final native Vector3 intersectPlane(Plane plane,Vector3 optionalTarget)/*-{
return this.intersectPlane(plane,optionalTarget);
}-*/;

public final native boolean isIntersectionBox(Box3 box)/*-{
return this.isIntersectionBox(box);
}-*/;

public final native Vector3 intersectBox(Box3 box,Vector3 optionalTarget)/*-{
return this.intersectBox(box,optionalTarget);
}-*/;

public final native Vector3 intersectTriangle(Vector3 a,Vector3 b,Vector3 c,boolean backfaceCulling,Vector3 optionalTarget)/*-{
return this.intersectTriangle();
}-*/;

public final native Ray applyMatrix4(Matrix4 matrix4)/*-{
return this.applyMatrix4(matrix4);
}-*/;

public final native boolean equals(Ray ray)/*-{
return this.equals(ray);
}-*/;



/**
 * @deprecated?
 */
public final native JsArray<Intersect> intersectScene(Scene scene)/*-{
				return  this.intersectScene( scene );
}-*/;

/**
 * @deprecated?
 */
public final native JsArray<Intersect> intersectObjects(JsArray<Object3D> objects)/*-{
			return  this.intersectObjects( objects );
}-*/;

/**
 * @deprecated?
 */
public final native JsArray<Intersect> intersectObject(Object3D object)/*-{
			return  this.intersectObject( object );

}-*/;

public final native Vector3 intersectSphere (Sphere sphere,Vector3 optionalTarget)/*-{
return this.intersectSphere(sphere,optionalTarget);
}-*/;

public final  native Ray clone()/*-{
return this.clone();
}-*/;

public final native double distanceSqToPoint(Vector3 point)/*-{
return this.distanceSqToPoint(point);
}-*/;
}
