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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

public class Vector4 extends JavaScriptObject{
	protected Vector4(){};
	


public final native Vector4 set(double x,double y,double z,double w)/*-{
return this.set(x,y,z,w);
}-*/;

public final native Vector4 setX(double x)/*-{
return this.setX(x);
}-*/;

public final native Vector4 setY(double y)/*-{
return this.setY(y);
}-*/;

public final native Vector4 setZ(double z)/*-{
return this.setZ(z);
}-*/;

public final native Vector4 setW(double w)/*-{
return this.setW(w);
}-*/;

public final native void setComponent(int index,double value)/*-{
this.setComponent(index,value);
}-*/;

public final native double getComponent(int index)/*-{
return this.getComponent(index);
}-*/;

public final native Vector4 copy(Vector4 v)/*-{
return this.copy(v);
}-*/;

public final native Vector4 add(Vector4 v)/*-{
return this.add(v);
}-*/;

/**
 * @deprecated
 * @param v
 * @param w
 * @return
 */
public final native Vector4 add(Vector4 v,Vector4 w)/*-{
return this.add(v,w);
}-*/;

public final native Vector4 addScalar(double s)/*-{
return this.addScalar(s);
}-*/;

public final native Vector4 addVectors(Vector4 a,Vector4 b)/*-{
return this.addVectors(a,b);
}-*/;
public final native Vector4 sub(Vector4 v)/*-{
return this.sub(v);
}-*/;
/**
 * @deprecated
 */
public final native Vector4 sub(Vector4 v,Vector4 w)/*-{
return this.sub(v,w);
}-*/;

public final native Vector4 subVectors(Vector4 a,Vector4 b)/*-{
return this.subVectors(a,b);
}-*/;

public final native Vector4 multiplyScalar(double scalar)/*-{
return this.multiplyScalar(scalar);
}-*/;

public final native Vector4 applyMatrix4(Matrix4 m)/*-{
return this.applyMatrix4(m);
}-*/;

public final native Vector4 divideScalar(double scalar)/*-{
return this.divideScalar(scalar);
}-*/;

public final native Vector4 setAxisAngleFromQuaternion(Quaternion q)/*-{
return this.setAxisAngleFromQuaternion(q);
}-*/;

public final native Vector4 setAxisAngleFromRotationMatrix(Matrix4 m)/*-{
return this.setAxisAngleFromRotationMatrix(m);
}-*/;

public final native Vector4 min(Vector4 v)/*-{
return this.min(v);
}-*/;

public final native Vector4 max(Vector4 v)/*-{
return this.max(v);
}-*/;

public final native Vector4 clamp(Vector4 min,Vector4 max)/*-{
return this.clamp(min,max);
}-*/;

public final native Vector4 negate()/*-{
return this.negate();
}-*/;

public final native double dot(Vector4 v)/*-{
return this.dot(v);
}-*/;

public final native double lengthSq()/*-{
return this.lengthSq();
}-*/;

public final native double length()/*-{
return this.length();
}-*/;

public final native double lengthManhattan()/*-{
return this.lengthManhattan();
}-*/;

public final native Vector4 normalize()/*-{
return this.normalize();
}-*/;

public final native Vector4 setLength(double l)/*-{
return this.setLength(l);
}-*/;

public final native Vector4 lerp(Vector4 v,double alpha)/*-{
return this.lerp(v,alpha);
}-*/;

public final native boolean equals(Vector4 v)/*-{
return this.equals(v);
}-*/;

public final native Vector4 fromArray(JsArrayNumber array)/*-{
return this.fromArray(array);
}-*/;

public final native JsArrayNumber toArray()/*-{
return this.toArray();
}-*/;

public final native Vector4 clone()/*-{
return this.clone();
}-*/;
	


public native final void gwtIncrementX(double x)/*-{
this.x+=x;
}-*/;

public native final void gwtIncrementY(double y)/*-{
this.y+=y;
}-*/;

public native final void gwtIncrementZ(double z)/*-{
this.z+=z;
}-*/;

public native final void gwtIncrementW(double w)/*-{
this.w+=w;
}-*/;



public native final double getX()/*-{
return this.x;
}-*/;
public native final double getY()/*-{
return this.y;
}-*/;
public native final double getZ()/*-{
return this.z;
}-*/;

public native final double getW()/*-{
return this.w;
}-*/;

public final native Vector4 clampScalar(double minVal,double maxVal)/*-{
return this.clampScalar(minVal,maxVal);
}-*/;

public final native Vector4 floor()/*-{
return this.floor();
}-*/;

public final native Vector4 ceil()/*-{
return this.ceil();
}-*/;

public final native Vector4 round()/*-{
return this.round();
}-*/;

public final native Vector4 roundToZero()/*-{
return this.roundToZero();
}-*/;

public final native Vector4 fromArray(JsArrayNumber array,int offset)/*-{
return this.fromArray(array,offset);
}-*/;

public final native JsArrayNumber toArray(JsArrayNumber array)/*-{
return this.toArray(array);
}-*/;

public final native JsArrayNumber toArray(JsArrayNumber array,int offset)/*-{
return this.toArray(array,offset);
}-*/;

public final native Vector4 fromAttribute(JavaScriptObject attribute,int index,int offset)/*-{
return this.fromAttribute(attribute,index,offset);
}-*/;

public final native Vector4 subScalar(double s)/*-{
return this.subScalar(s);
}-*/;

public final native Vector4 lerpVectors(Vector4 v,Vector4 v2,double alpha)/*-{
return this.lerpVectors(v,v2,alpha);
}-*/;

}

