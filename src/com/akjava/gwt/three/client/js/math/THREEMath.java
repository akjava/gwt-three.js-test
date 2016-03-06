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


//THREE.MATH
/*
 * renamed because too much conflict Math.java
 */
public class THREEMath extends JavaScriptObject{
	protected THREEMath() {
	}

	public static final native double PI2()/*-{
	return this.PI2;
	}-*/;
	
public static final native String generateUUID()/*-{
return  $wnd.THREE.Math.generateUUID();
}-*/;

public static final native double clamp(double x,double a,double b)/*-{
return $wnd.THREE.Math.clamp(x,a,b);
}-*/;

/**
 * @deprecated on r73
 * @param x
 * @param a
 * @return
 */
public static final native double clampBottom(double x,double a)/*-{
return  $wnd.THREE.Math.clampBottom(x,a);
}-*/;

public static final native double mapLinear(double x,double a1,double a2,double b1,double b2)/*-{
return  $wnd.THREE.Math.mapLinear(x,a1,a2,b1,b2);
}-*/;

public static final native double smoothstep(double x,double min,double max)/*-{
return  $wnd.THREE.Math.smoothstep(x,min,max);
}-*/;

public static final native double smootherstep(double x,double min,double max)/*-{
return  $wnd.THREE.Math.smootherstep(x,min,max);
}-*/;

public static final native double random16()/*-{
return  $wnd.THREE.Math.random16();
}-*/;

public static final native int randInt(int low,int high)/*-{
return  $wnd.THREE.Math.randInt(low,high);
}-*/;

public static final native double randFloat(double low,double high)/*-{
return  $wnd.THREE.Math.randFloat(low,high);
}-*/;

public static final native double randFloatSpread(double range)/*-{
return  $wnd.THREE.Math.randFloatSpread(range);
}-*/;

public static final native double sign(double x)/*-{
return  $wnd.THREE.Math.sign(x);
}-*/;

public static final native double degToRad(double degrees)/*-{
return  $wnd.THREE.Math.degToRad(degrees);
}-*/;

public static final native double radToDeg(double radians)/*-{
return  $wnd.THREE.Math.radToDeg(radians);
}-*/;

public static final native boolean isPowerOfTwo(double value)/*-{
return  $wnd.THREE.Math.isPowerOfTwo(value);
}-*/;

public static final native int nextPowerOfTwo(int value)/*-{
return  $wnd.THREE.Math.nextPowerOfTwo(value);
}-*/;
}
