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


public class Math extends JavaScriptObject{
	protected Math() {
	}

	public static final native double PI2()/*-{
	return this.PI2;
	}-*/;
	
public static final native String generateUUID()/*-{
return this.generateUUID();
}-*/;

public static final native double clamp(double x,double a,double b)/*-{
return this.clamp(x,a,b);
}-*/;

public static final native double clampBottom(double x,double a)/*-{
return this.clampBottom(x,a);
}-*/;

public static final native double mapLinear(double x,double a1,double a2,double b1,double b2)/*-{
return this.mapLinear(x,a1,a2,b1,b2);
}-*/;

public static final native double smoothstep(double x,double min,double max)/*-{
return this.smoothstep(x,min,max);
}-*/;

public static final native double smootherstep(double x,double min,double max)/*-{
return this.smootherstep(x,min,max);
}-*/;

public static final native double random16()/*-{
return this.random16();
}-*/;

public static final native int randInt(int low,int high)/*-{
return this.randInt(low,high);
}-*/;

public static final native double randFloat(double low,double high)/*-{
return this.randFloat(low,high);
}-*/;

public static final native double randFloatSpread(double range)/*-{
return this.randFloatSpread(range);
}-*/;

public static final native double sign(double x)/*-{
return this.sign(x);
}-*/;

public static final native double degToRad(double degrees)/*-{
return this.degToRad(degrees);
}-*/;

public static final native double radToDeg(double radians)/*-{
return this.radToDeg(radians);
}-*/;


}
