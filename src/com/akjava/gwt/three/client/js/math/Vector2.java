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

import com.akjava.gwt.three.client.gwt.math.XY;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;


public class Vector2 extends XY{
	protected Vector2() {
	}



public final native Vector2 set(double x,double y)/*-{
return this.set(x,y);
}-*/;

public final native Vector2 setX(double x)/*-{
return this.setX(x);
}-*/;

public final native Vector2 setY(double y)/*-{
return this.setY(y);
}-*/;

public final native void setComponent(int index,double value)/*-{
this.setComponent(index,value);
}-*/;

public final native double getComponent(int index)/*-{
return this.getComponent(index);
}-*/;

public final native Vector2 copy(Vector2 v)/*-{
return this.copy(v);
}-*/;

public final native Vector2 add(Vector2 v)/*-{
return this.add(v);
}-*/;

public final native Vector2 addVectors(Vector2 a,Vector2 b)/*-{
return this.addVectors(a,b);
}-*/;

public final native Vector2 addScalar(double s)/*-{
return this.addScalar(s);
}-*/;

public final native Object sub(Vector2 v)/*-{
return this.sub(v);
}-*/;

public final native Vector2 subVectors(Vector2 a,Vector2 b)/*-{
return this.subVectors(a,b);
}-*/;

public final native Vector2 multiplyScalar(double s)/*-{
return this.multiplyScalar(s);
}-*/;

public final native Vector2 divideScalar(double scalar)/*-{
return this.divideScalar(scalar);
}-*/;

public final native Vector2 min(Vector2 v)/*-{
return this.min(v);
}-*/;

public final native Vector2 max(Vector2 v)/*-{
return this.max(v);
}-*/;

public final native Vector2 clamp(Vector2 min,Vector2 max)/*-{
return this.clamp(min,max);
}-*/;

public final native Vector2 negate()/*-{
return this.negate();
}-*/;

public final native double dot(Vector2 v)/*-{
return this.dot(v);
}-*/;

public final native Vector2 lengthSq()/*-{
return this.lengthSq();
}-*/;

public final native double length()/*-{
return this.length();
}-*/;

public final native Vector2 normalize()/*-{
return this.normalize();
}-*/;

public final native double distanceTo(Vector2 v)/*-{
return this.distanceTo(v);
}-*/;

public final native double distanceToSquared(Vector2 v)/*-{
return this.distanceToSquared(v);
}-*/;

public final native Vector2 setLength(double l)/*-{
return this.setLength(l);
}-*/;

public final native Vector2 lerp(Vector2 v,Object alpha)/*-{
return this.lerp(v,alpha);
}-*/;

public final native boolean equals(Vector2 v)/*-{
return this.equals(v);
}-*/;

public final native Object fromArray(JsArrayNumber array)/*-{
return this.fromArray(array);
}-*/;

public final native JsArrayNumber toArray()/*-{
return this.toArray();
}-*/;

public final native Vector2 clone()/*-{
return this.clone();
}-*/;

public final native Vector2 clampScalar(double minVal,double maxVal)/*-{
return this.clampScalar(minVal,maxVal);
}-*/;

public final native Vector2 floor()/*-{
return this.floor();
}-*/;

public final native Vector2 ceil()/*-{
return this.ceil();
}-*/;

public final native Vector2 round()/*-{
return this.round();
}-*/;

public final native Vector2 roundToZero()/*-{
return this.roundToZero();
}-*/;

public final native Vector2 fromArray(JsArrayNumber array,int offset)/*-{
return this.fromArray(array,offset);
}-*/;

public final native JsArrayNumber toArray(JsArrayNumber array)/*-{
return this.toArray(array);
}-*/;

public final native JsArrayNumber toArray(JsArrayNumber array,int offset)/*-{
return this.toArray(array,offset);
}-*/;

public final native Vector2 fromAttribute(JavaScriptObject attribute,int index,int offset)/*-{
return this.fromAttribute(attribute,index,offset);
}-*/;

}
