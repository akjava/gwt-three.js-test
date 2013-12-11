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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


public class Triangle extends JavaScriptObject{
	protected Triangle() {
	}

public final native Vector3 getA()/*-{
return this.a;
}-*/;

public final native Vector3 getB()/*-{
return this.b;
}-*/;

public final native Vector3 getC()/*-{
return this.c;
}-*/;

public static final native Vector3 normal(Vector3 a,Vector3 b,Vector3 c,Vector3 optionalTarget)/*-{
return $wnd.THREE.Triangle.normal( a, b, c, optionalTarget );
}-*/;


public static final native Triangle barycoordFromPoint(Vector3 point, Vector3 a, Vector3 b, Vector3 c,Vector3  optionalTarget )/*-{
return $wnd.THREE.Triangle.barycoordFromPoint( point,  a,  b,  c,optionalTarget);
}-*/;

public final native boolean containsPoint(Vector3 point, Vector3 a, Vector3 b, Vector3 c)/*-{
return $wnd.THREE.Triangle.containsPoint(point,  a,  b,  c);
}-*/;

public final native Triangle set(Vector3 a,Vector3 b,Vector3 c)/*-{
return this.set(a,b,c);
}-*/;

public final native Triangle setFromPointsAndIndices(JsArray<Vector3> points,int i0,int i1,int i2)/*-{
return this.setFromPointsAndIndices(points,i0,i1,i2);
}-*/;

public final native Triangle copy(Triangle triangle)/*-{
return this.copy(triangle);
}-*/;

public final native double area()/*-{
return this.area();
}-*/;

public final native Vector3 midpoint(Vector3 optionalTarget)/*-{
return this.midpoint(optionalTarget);
}-*/;

public final native Vector3 normal(Vector3 optionalTarget)/*-{
return this.normal(optionalTarget);
}-*/;

public final native Plane plane(Plane optionalTarget)/*-{
return this.plane(optionalTarget);
}-*/;

public final native Vector3 barycoordFromPoint(Vector3 point,Vector3 optionalTarget)/*-{
return this.barycoordFromPoint(point,optionalTarget);
}-*/;

public final native boolean containsPoint(Vector3 point)/*-{
return this.containsPoint(point);
}-*/;

public final native boolean equals(Triangle triangle)/*-{
return this.equals(triangle);
}-*/;

public final native Triangle clone()/*-{
return this.clone();
}-*/;


}
