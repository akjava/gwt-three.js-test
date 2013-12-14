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
import com.akjava.gwt.three.client.js.math.Vector2;
import com.google.gwt.core.client.JsArray;


public class Path extends CurvePath {
protected Path(){}

public final native void fromPoints(JsArray<Vector2> vectors)/*-{
this.fromPoints(vectors);
}-*/;

public final native void moveTo(double x,double y)/*-{
this.moveTo(x,y);
}-*/;

public final native void lineTo(double x,double y)/*-{
this.lineTo(x,y);
}-*/;
public final native void quadraticCurveTo(double  aCPx,double aCPy,double aX,double aY)/*-{
this.lineTo( aCPx, aCPy, aX, aY);
}-*/;

public final native void bezierCurveTo(double  aCP1x,double aCP1y,double aCP2x,double aCP2y,double aX,double aY )/*-{
this.lineTo(  aCP1x, aCP1y, aCP2x, aCP2y, aX, aY );
}-*/;

public final native void splineThru(JsArray<Vector2> pts)/*-{
this.fromPoints(pts);
}-*/;

public final native void arc(double aX,double  aY,double  aRadius,double aStartAngle,double  aEndAngle,boolean aClockwise)/*-{
this.arc(aX, aY, aRadius,aStartAngle, aEndAngle, aClockwise);
}-*/;

public final native void absarc(double aX,double aY,double aRadius,double aStartAngle,double aEndAngle,boolean aClockwise)/*-{
this.absarc(aX, aY, aRadius,aStartAngle, aEndAngle, aClockwise);
}-*/;
public final native void ellipse(double  aX,double aY,double xRadius,double yRadius,double aStartAngle,double aEndAngle,boolean aClockwise)/*-{
this.ellipse( aX, aY, xRadius, yRadius,aStartAngle, aEndAngle, aClockwise);
}-*/;

public final native void absellipse(double   aX,double aY,double xRadius,double yRadius,double aStartAngle,double aEndAngle,boolean aClockwise)/*-{
this.absellipse( aX, aY, xRadius, yRadius, aStartAngle, aEndAngle, aClockwise);
}-*/;
public final native JsArray<XYZObject> getSpacedPoints(int divisions,boolean closedPath)/*-{
return this.getSpacedPoints( divisions, closedPath);
}-*/;
public final native JsArray<XYZObject> getPoints(int divisions,boolean closedPath)/*-{
this.getPoints( divisions, closedPath);
}-*/;
public final native JsArray<Shape> toShapes(boolean isCCW)/*-{
this.getPoints(  isCCW);
}-*/;

}