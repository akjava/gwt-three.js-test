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
package com.akjava.gwt.three.client.js.extras.core;

import com.akjava.gwt.three.client.gwt.math.XYZObject;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;


public class CurvePath extends GWTCurve2{
	protected CurvePath() {
	}

public final native JsArray<GWTCurve2> getCurves()/*-{
return this.curves;
}-*/;

public final native void setCurves(JsArray<GWTCurve2> curves)/*-{
this.curves = curves;
}-*/;


public final native JsArray<Path> getBends()/*-{
return this.bends;
}-*/;

public final native void setBends(JsArray<Path> bends)/*-{
this.bends = bends;
}-*/;


public final native boolean isAutoClose()/*-{
return this.autoClose;
}-*/;



public final native void add(GWTCurve2 curve)/*-{
this.add(curve);
}-*/;

public final native void checkConnection()/*-{
this.checkConnection();
}-*/;

public final native void closePath()/*-{
this.closePath();
}-*/;



public final native JsArrayNumber getCurveLengths()/*-{
return this.getCurveLengths();
}-*/;

/**
 * TODO implement object
 * @return
 */
public final native JavaScriptObject getBoundingBox()/*-{
return this.getBoundingBox();
}-*/;

public final native Geometry createPointsGeometry(double divisions)/*-{
return this.createPointsGeometry(divisions);
}-*/;

public final native Geometry createSpacedPointsGeometry(double divisions)/*-{
return this.createSpacedPointsGeometry(divisions);
}-*/;

public final native Geometry createGeometry(JsArray<XYZObject> points)/*-{
return this.createGeometry(points);
}-*/;

public final native void addWrapPath(Object bendpath)/*-{
this.addWrapPath(bendpath);
}-*/;

public final native JsArray<XYZObject> getTransformedPoints(int segments,JsArray<Path> bends)/*-{
return this.getTransformedPoints(segments,bends);
}-*/;

public final native JsArray<XYZObject> getTransformedSpacedPoints(int segments,JsArray<Path> bends)/*-{
return this.getTransformedSpacedPoints(segments,bends);
}-*/;

public final native JsArray<XYZObject> getWrapPoints(JsArray<XYZObject> oldPts,Path path)/*-{
return this.getWrapPoints(oldPts,path);
}-*/;


}
