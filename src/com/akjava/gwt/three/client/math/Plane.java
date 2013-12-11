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

import com.akjava.gwt.three.client.core.Vector3;
import com.google.gwt.core.client.JavaScriptObject;


public class Plane extends JavaScriptObject{
	protected Plane() {
	}

public final native Vector3 getNormal()/*-{
return this.normal;
}-*/;




public final native double getConstant()/*-{
return this.constant;
}-*/;



public final native Plane set(Vector3 normal,double constant)/*-{
return this.set(normal,constant);
}-*/;

public final native Plane setComponents(double x,double y,double z,double w)/*-{
return this.setComponents(x,y,z,w);
}-*/;

public final native Plane setFromNormalAndCoplanarPoint(Vector3 normal,Vector3 point)/*-{
return this.setFromNormalAndCoplanarPoint(normal,point);
}-*/;

public final native Plane setFromCoplanarPoints(Vector3 a,Vector3 b,Vector3 c)/*-{
return this.setFromCoplanarPoints(a,b,c);
}-*/;

public final native Plane copy(Plane plane)/*-{
return this.copy(plane);
}-*/;

public final native Plane normalize()/*-{
return this.normalize();
}-*/;

public final native Plane negate()/*-{
return this.negate();
}-*/;

public final native Vector3 distanceToPoint(Vector3 point)/*-{
return this.distanceToPoint(point);
}-*/;

public final native Vector3 distanceToSphere(Sphere sphere)/*-{
return this.distanceToSphere(sphere);
}-*/;

public final native Object projectPoint(Vector3 point,Vector3 optionalTarget)/*-{
return this.projectPoint(point,optionalTarget);
}-*/;

public final native Object orthoPoint(Vector3 point,Vector3 optionalTarget)/*-{
return this.orthoPoint(point,optionalTarget);
}-*/;

public final native boolean isIntersectionLine(Line3 line)/*-{
return this.isIntersectionLine(line);
}-*/;

public final native Vector3 intersectLine()/*-{
return this.intersectLine();
}-*/;

public final native Vector3 coplanarPoint(Vector3 optionalTarget)/*-{
return this.coplanarPoint(optionalTarget);
}-*/;

public final native Plane applyMatrix4(Matrix4 matrix,Matrix3 optionalNormalMatrix)/*-{
return this.applyMatrix4(matrix,optionalNormalMatrix);
}-*/;

public final native Plane translate(Vector3 offset)/*-{
return this.translate(offset);
}-*/;

public final native boolean equals(Plane plane)/*-{
return this.equals(plane);
}-*/;

public final native Plane clone()/*-{
return this.clone();
}-*/;


}
