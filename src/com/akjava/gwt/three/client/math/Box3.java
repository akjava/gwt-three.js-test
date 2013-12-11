/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2013 akimisaki3@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r63
 https://github.com/mrdoob/three.js
 The MIT License

Copyright (c) 2010-2013 three.js Authors. All rights reserved.

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
package com.akjava.gwt.three.client.math;

import javax.swing.Box;

import com.akjava.gwt.three.client.core.Object3D;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


public class Box3 extends Object3D{
	protected Box3() {
	}

public final native Vector3 getMin()/*-{
return this.min;
}-*/;




public final native Vector3 getMax()/*-{
return this.max;
}-*/;



public final native Box3 set(Vector3 min,Vector3 max)/*-{
return this.set(min,max);
}-*/;

public final native void addPoint(Vector3 point)/*-{
this.addPoint(point);
}-*/;

public final native Box3 setFromPoints(JsArray<Vector3> points)/*-{
return this.setFromPoints(points);
}-*/;

public final native Box3 setFromCenterAndSize(Vector3 center,Vector3 size)/*-{
return this.setFromCenterAndSize();
}-*/;
/** i have no idea*/
public final native Box3 setFromObject(Object3D object)/*-{
return this.setFromObject();
}-*/;

public final native Box3 copy(Box3 box)/*-{
return this.copy(box);
}-*/;

public final native Box3 makeEmpty()/*-{
return this.makeEmpty();
}-*/;

public final native boolean empty()/*-{
return this.empty();
}-*/;

public final native Vector3 center(Vector3 optionalTarget)/*-{
return this.center(optionalTarget);
}-*/;

public final native Vector3 size(Vector3 optionalTarget)/*-{
return this.size(optionalTarget);
}-*/;

public final native Box3 expandByPoint(Vector3 point)/*-{
return this.expandByPoint(point);
}-*/;

public final native Box3 expandByVector(Vector3 vector)/*-{
return this.expandByVector(vector);
}-*/;

public final native Object expandByScalar(double scalar)/*-{
return this.expandByScalar(scalar);
}-*/;

public final native boolean containsPoint(Vector3 point)/*-{
return this.containsPoint(point);
}-*/;

public final native boolean containsBox(Box3 box)/*-{
return this.containsBox(box);
}-*/;

public final native Vector3 getParameter(Vector3 point)/*-{
return this.getParameter(point);
}-*/;

public final native boolean isIntersectionBox(Box3 box)/*-{
return this.isIntersectionBox(box);
}-*/;

public final native Vector3 clampPoint(Vector3 point,Vector3 optionalTarget)/*-{
return this.clampPoint(point,optionalTarget);
}-*/;

public final native Vector3 distanceToPoint(Vector3 point)/*-{
return this.distanceToPoint(point);
}-*/;
//TODO implement sphere
public final native Vector3 getBoundingSphere(JavaScriptObject sphere)/*-{
return this.getBoundingSphere(sphere);
}-*/;

public final native Box3 intersect(Box3 box)/*-{
return this.intersect(box);
}-*/;

public final native Box3 union(Box3 box)/*-{
return this.union(box);
}-*/;

public final native Box3 applyMatrix4(Matrix4 matrix)/*-{
return this.applyMatrix4();
}-*/;

public final native Box3 translate(Vector3 offset)/*-{
return this.translate(offset);
}-*/;

public final native boolean equals(Box3 box)/*-{
return this.equals(box);
}-*/;

public final native Box3 clone()/*-{
return this.clone();
}-*/;


}
