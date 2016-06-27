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
package com.akjava.gwt.three.client.js.math;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


public class Sphere extends JavaScriptObject{
	protected Sphere() {
	}

public final native Vector3 getCenter()/*-{
return this.center;
}-*/;




public final native double getRadius()/*-{
return this.radius;
}-*/;



public final native Sphere set(Vector3 center,double radius)/*-{
return this.set(center,radius);
}-*/;

public final native Sphere setFromPoints(JsArray<Vector3> points,Vector3 optionalCenter)/*-{
return this.setFromPoints(points,optionalCenter);
}-*/;
public final native Sphere setFromPoints(JsArray<Vector3> points)/*-{
return this.setFromPoints(points);
}-*/;

public final native Sphere copy(Sphere sphere)/*-{
return this.copy(sphere);
}-*/;

public final native boolean empty()/*-{
return this.empty();
}-*/;

public final native boolean containsPoint(Vector3 point)/*-{
return this.containsPoint(point);
}-*/;

public final native double distanceToPoint(Sphere point)/*-{
return this.distanceToPoint(point);
}-*/;

public final native boolean intersectsSphere(Sphere sphere)/*-{
return this.intersectsSphere(sphere);
}-*/;

public final native Vector3 clampPoint(Vector3 point,Vector3 optionalTarget)/*-{
return this.clampPoint(point,optionalTarget);
}-*/;

public final native Box3 getBoundingBox(Box3 optionalTarget)/*-{
return this.getBoundingBox(optionalTarget);
}-*/;

public final native Sphere applyMatrix4(Matrix4 matrix)/*-{
return this.applyMatrix4(matrix);
}-*/;

public final native Sphere translate(Vector3 offset)/*-{
return this.translate(offset);
}-*/;

public final native boolean equals(Sphere sphere)/*-{
return this.equals(sphere);
}-*/;

public final native Sphere clone()/*-{
return this.clone();
}-*/;

public final native boolean intersectsBox(Box3 box)/*-{
return this.intersectsBox(box);
}-*/;

public final native boolean intersectsPlane(Plane plane)/*-{
return this.intersectsPlane(plane);
}-*/;

}
