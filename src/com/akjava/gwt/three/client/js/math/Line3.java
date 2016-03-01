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


public class Line3 extends JavaScriptObject{
	protected Line3() {
	}

public final native Vector3 getStart()/*-{
return this.start;
}-*/;



public final native Vector3 getEnd()/*-{
return this.end;
}-*/;



public final native Line3 set(Vector3 start,Vector3 end)/*-{
return this.set(start,end);
}-*/;

public final native Line3 copy(Line3 line)/*-{
return this.copy(line);
}-*/;

public final native Vector3 center(Vector3 optionalTarget)/*-{
return this.center(optionalTarget);
}-*/;

public final native Vector3 delta(Vector3 optionalTarget)/*-{
return this.delta(optionalTarget);
}-*/;

public final native double distanceSq()/*-{
return this.distanceSq();
}-*/;

public final native double distance()/*-{
return this.distance();
}-*/;

public final native Vector3 at(double t,Vector3 optionalTarget)/*-{
return this.at(t,optionalTarget);
}-*/;

public final native double closestPointToPointParameter(Vector3 point ,boolean clampToLine)/*-{
return this.closestPointToPointParameter(point,clampToLine);
}-*/;

public final native Vector3 closestPointToPoint(Vector3 point,boolean clampToLine,Vector3 optionalTarget)/*-{
return this.closestPointToPoint(point,clampToLine,optionalTarget);
}-*/;

public final native Line3 applyMatrix4(Matrix4 matrix)/*-{
return this.applyMatrix4(matrix);
}-*/;

public final native boolean equals(Line3 line)/*-{
return this.equals(line);
}-*/;

public final  native Line3 clone()/*-{
return this.clone();
}-*/;


}
