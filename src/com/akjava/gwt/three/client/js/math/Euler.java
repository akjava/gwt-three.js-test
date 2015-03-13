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
import com.google.gwt.core.client.JsArrayNumber;


public class Euler extends JavaScriptObject{
	protected Euler() {
	}

	
	public static final String XYZ="XYZ";
	public static final String YZX="YZX";
	public static final String ZXY="ZXY";
	public static final String XZY="XZY";
	public static final String YXZ="YXZ";
	public static final String ZYX="ZYX";


public final native Euler set(double x,double y,double z,String order)/*-{
return this.set(x,y,z,order);
}-*/;

public final native Euler set(double x,double y,double z)/*-{
return this.set(x,y,z);
}-*/;

public final native Euler copy(Euler euler)/*-{
return this.copy(euler);
}-*/;

public final native Euler setFromRotationMatrix(Matrix4 m,String order)/*-{
return this.setFromRotationMatrix(m,order);
}-*/;

public final native Euler setFromQuaternion(Quaternion q,String order,boolean update)/*-{
return this.setFromQuaternion(q,order,update);
}-*/;

public final native Euler reorder()/*-{
return this.reorder();
}-*/;

public final native Euler fromArray(JsArrayNumber array)/*-{
return this.fromArray(array);
}-*/;

public final native JsArrayNumber toArray()/*-{
return this.toArray();
}-*/;

public final native boolean equals(Euler euler)/*-{
return this.equals(euler);
}-*/;

public final native Euler clone()/*-{
return this.clone();
}-*/;
public final native double getX()/*-{
return this.x;
}-*/;

public final native double getY()/*-{
return this.y;
}-*/;

public final native double getZ()/*-{
return this.z;
}-*/;

public final native String getOrder()/*-{
return this.order;
}-*/;
public final native void setX(double value)/*-{
this.x=value;
}-*/;

public final native void setY(double value)/*-{
this.y=value;
}-*/;

public final native void setZ(double value)/*-{
this.z=value;
}-*/;

public final native void setOrder(String value)/*-{
this.order=value;
}-*/;

/** Euler.js 's getter will _updateQuaternion */
public native final void gwtIncrementX(double x)/*-{
this.x+=x;
}-*/;
/** Euler.js 's getter will _updateQuaternion */
public native final void gwtIncrementY(double y)/*-{
this.y+=y;
}-*/;
/** Euler.js 's getter will _updateQuaternion */
public native final void gwtIncrementZ(double z)/*-{
this.z+=z;
}-*/;

public final native Euler setFromRotationMatrix(Matrix4 m,String order,boolean update)/*-{
return this.setFromRotationMatrix(m,order,update);
}-*/;

public final native Vector3 toVector3(Vector3 optionalResult)/*-{
return toVector3(optionalResult);
}-*/;

}
