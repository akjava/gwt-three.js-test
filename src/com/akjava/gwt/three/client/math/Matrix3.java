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

import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;


public class Matrix3 extends JavaScriptObject{
	protected Matrix3() {
	}


public final native Matrix3 set(double n11,double n12,double n13,double n21,double n22,double n23,double n31,double n32,double n33)/*-{
return this.set(n11,n12,n13,n21,n22,n23,n31,n32,n33);
}-*/;

public final native Matrix3 identity()/*-{
return this.identity();
}-*/;

public final native Matrix3 copy(Matrix3 m)/*-{
return this.copy(m);
}-*/;
/**
 * @deprecated
 * @param vector
 * @return
 */
public final native Matrix3 multiplyVector3(Vector3 vector)/*-{
return this.multiplyVector3(vector);
}-*/;

public final native JsArrayNumber multiplyVector3Array(JsArrayNumber a)/*-{
return this.multiplyVector3Array(a);
}-*/;

public final native Matrix3 multiplyScalar(double s)/*-{
return this.multiplyScalar(s);
}-*/;

public final native double determinant()/*-{
return this.determinant();
}-*/;

public final native Matrix3 getInverse(Matrix4 matrix,boolean throwOnInvertible)/*-{
return this.getInverse(matrix,throwOnInvertible);
}-*/;

public final native Matrix3 transpose()/*-{
return this.transpose();
}-*/;

public final native Matrix3 getNormalMatrix(Matrix4 m)/*-{
return this.getNormalMatrix(m);
}-*/;

public final native Matrix3 transposeIntoArray(JsArrayNumber r)/*-{
return this.transposeIntoArray(r);
}-*/;

public final native Matrix3 clone()/*-{
return this.clone();
}-*/;


}
