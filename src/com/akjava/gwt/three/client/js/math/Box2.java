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

import com.akjava.gwt.three.client.js.core.Face3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


public class Box2 extends JavaScriptObject{
	protected Box2() {
	}

public final native Vector2 getMin()/*-{
return this.min;
}-*/;



public final native Vector2 getMax()/*-{
return this.max;
}-*/;



public final native Box2 set(Vector2 min,Vector2 max)/*-{
return this.set(min,max);
}-*/;

public final native Box2 setFromPoints(JsArray<Vector2> points)/*-{
return this.setFromPoints(points);
}-*/;

public final native Box2 setFromCenterAndSize(Vector2 center,Vector2 size)/*-{
return this.setFromCenterAndSize();
}-*/;



public final native Box2 makeEmpty()/*-{
return this.makeEmpty();
}-*/;

public final native boolean empty()/*-{
return this.empty();
}-*/;

public final native Vector2 center(Vector2 optionalTarget)/*-{
return this.center(optionalTarget);
}-*/;

public final native Vector2 size(Object optionalTarget)/*-{
return this.size(optionalTarget);
}-*/;

public final native Box2 expandByPoint(Vector2 point)/*-{
return this.expandByPoint(point);
}-*/;

public final native Box2 expandByVector(Vector2 vector)/*-{
return this.expandByVector(vector);
}-*/;

public final native Box2 expandByScalar(double scalar)/*-{
return this.expandByScalar(scalar);
}-*/;

public final native boolean containsPoint(Vector2 point)/*-{
return this.containsPoint(point);
}-*/;

public final native boolean containsBox(Box2 box)/*-{
return this.containsBox(box);
}-*/;

public final native Vector2 getParameter(Vector2 point)/*-{
return this.getParameter(point);
}-*/;
public final native Vector2 getParameter(Vector2 point,Vector2 optionalTarget)/*-{
return this.getParameter(point,optionalTarget);
}-*/;

public final native boolean isIntersectionBox(Box2 box)/*-{
return this.isIntersectionBox(box);
}-*/;

public final native Vector2 clampPoint(Vector2 point,Vector2 optionalTarget)/*-{
return this.clampPoint(point,optionalTarget);
}-*/;

public final native Vector2 distanceToPoint(Vector2 point)/*-{
return this.distanceToPoint(point);
}-*/;

public final native Box2 intersect(Box2 box)/*-{
return this.intersect(box);
}-*/;

public final native Box2 union(Box2 box)/*-{
return this.union(box);
}-*/;

public final native Box2 translate(Vector2 offset)/*-{
return this.translate(offset);
}-*/;

public final native boolean equals(Box2 box)/*-{
return this.equals(box);
}-*/;



public final native Box2 copy(Box2 source)/*-{
return this.copy(source);
}-*/;

public final  native Box2 clone()/*-{
return this.clone();
}-*/;
}
