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
package com.akjava.gwt.three.client.js.extras.curves;

import com.akjava.gwt.three.client.js.extras.core.GWTCurve2;


public class EllipseCurve extends GWTCurve2{
	protected EllipseCurve() {
	}




	public final  native double getAX()/*-{
	return this.aX;
	}-*/;
	public final  native void setAX(double  param)/*-{
	this.aX=param;
	}-*/;


	public final  native double getAY()/*-{
	return this.aY;
	}-*/;
	public final  native void setAY(double  param)/*-{
	this.aY=param;
	}-*/;


	public final  native double getXRadius()/*-{
	return this.xRadius;
	}-*/;
	public final  native void setXRadius(double  param)/*-{
	this.xRadius=param;
	}-*/;


	public final  native double getYRadius()/*-{
	return this.yRadius;
	}-*/;
	public final  native void setYRadius(double  param)/*-{
	this.yRadius=param;
	}-*/;


	public final  native double getAStartAngle()/*-{
	return this.aStartAngle;
	}-*/;
	public final  native void setAStartAngle(double  param)/*-{
	this.aStartAngle=param;
	}-*/;


	public final  native double getAEndAngle()/*-{
	return this.aEndAngle;
	}-*/;
	public final  native void setAEndAngle(boolean  param)/*-{
	this.aEndAngle=param;
	}-*/;


	public final  native boolean isAClockwise()/*-{
	return this.aClockwise;
	}-*/;
	public final  native void setAClockwise(double  param)/*-{
	this.aClockwise=param;
	}-*/;


	public final  native double getARotation()/*-{
	return this.aRotation;
	}-*/;
	public final  native void setARotation(double  param)/*-{
	this.aRotation=param;
	}-*/;

}
