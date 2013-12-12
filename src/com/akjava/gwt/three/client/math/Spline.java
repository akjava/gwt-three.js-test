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
import com.google.gwt.core.client.JsArrayNumber;


public class Spline extends JavaScriptObject{
	protected Spline() {
	}

public final native JsArray<XYZPoint> getPoints()/*-{
return this.points;
}-*/;

public final native void initFromArray(JsArray<JsArrayNumber> a)/*-{
this.initFromArray(a);
}-*/;

public final native XYZPoint getPoint(double k)/*-{
return this.getPoint(k);
}-*/;

public final native JsArray<JsArrayNumber> getControlPointsArray()/*-{
return this.getControlPointsArray();
}-*/;

public final native GWTSplineLength getLength(double nSubDivisions)/*-{
return this.getLength(nSubDivisions);
}-*/;

public final native void reparametrizeByArcLength(double samplingCoef)/*-{
this.reparametrizeByArcLength(samplingCoef);
}-*/;

public static final native double interpolate(double p0, double p1, double p2, double p3, double t, double t2, double t3)/*-{
return interpolate( p0, p1, p2, p3, t, t2, t3);
}-*/;
}
