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
package com.akjava.gwt.three.client.extras.core;

import com.akjava.gwt.three.client.gwt.math.XYZObject;
import com.akjava.gwt.three.client.math.Vector2;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;


public class Curve extends JavaScriptObject{
	protected Curve() {
	}

public final native Vector2 getPoint(double t)/*-{
return this.getPoint(t);
}-*/;

public final native Vector2 getPointAt(double u)/*-{
return this.getPointAt(u);
}-*/;

public final native JsArray<Vector2> getPoints(double divisions)/*-{
return this.getPoints(divisions);
}-*/;

public final native JsArray<Vector2> getSpacedPoints(double divisions)/*-{
return this.getSpacedPoints(divisions);
}-*/;

public final native double getLength()/*-{
return this.getLength();
}-*/;

public final native JsArrayNumber getLengths(double divisions)/*-{
return this.getLengths(divisions);
}-*/;

public final native void updateArcLengths()/*-{
this.updateArcLengths();
}-*/;

public final native double getUtoTmapping(double u,double distance)/*-{
return this.getUtoTmapping(u,distance);
}-*/;

public final native Vector2 getTangent(double t)/*-{
return this.getTangent(t);
}-*/;

public final native Vector2 getTangentAt(double u)/*-{
return this.getTangentAt(u);
}-*/;



}
