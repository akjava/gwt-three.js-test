/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2011 aki@akjava.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r45
 https://github.com/mrdoob/three.js
 The MIT License

Copyright (c) 2010-2011 three.js Authors. All rights reserved.

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

import com.akjava.gwt.three.client.gwt.math.HSL;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

public class Color extends JavaScriptObject{
protected Color(){}

public final native Color set(Color value)/*-{
return this.set( value );
}-*/;

public final native Color set(String value)/*-{
return this.set( value );
}-*/;

public final native Color set(int value)/*-{
return this.set( value );
}-*/;

public final native Color setHex(int hex)/*-{
return this.setHex(hex);
}-*/;

public final native int getHex()/*-{
return this.getHex();
}-*/;

public final  void setIntRGB(int r,int g,int b){
	r=r%256;
	g=g%256;
	b=b%256;
	setRGB((double)r/255,(double)g/255,(double)b/255);
}

public final native Color setRGB(double r,double g,double b)/*-{
return this.setRGB(r,g,b);
}-*/;
/**
 * @deprecated ?
 */
public final native void setHSV(double h,double s,double v)/*-{
return this.setHSV(h,s,v);
}-*/;

public final native Object setHSL(double h,double s,double l)/*-{
return this.setHSL(h,s,l);
}-*/;

public final native Color setStyle(String style)/*-{
return this.setStyle(style);
}-*/;

public final native Color copy(Color color)/*-{
return this.copy(color);
}-*/;

public final native Color copyGammaToLinear(Color color)/*-{
return this.copyGammaToLinear(color);
}-*/;

public final native Color copyLinearToGamma(Color color)/*-{
return this.copyLinearToGamma(color);
}-*/;

public final native Color convertGammaToLinear()/*-{
return this.convertGammaToLinear();
}-*/;

public final native Color convertLinearToGamma()/*-{
return this.convertLinearToGamma();
}-*/;


public final native String getHexString()/*-{
return this.getHexString();
}-*/;

public final native HSL getHSL(HSL hsl)/*-{
return this.getHSL(hsl);
}-*/;

public final native HSL getHSL()/*-{
return this.getHSL();
}-*/;

public final native String getStyle()/*-{
return this.getStyle();
}-*/;

public final native Color offsetHSL(double h,double s,double l)/*-{
return this.offsetHSL(h,s,l);
}-*/;

public final native Color add(Color color)/*-{
return this.add(color);
}-*/;

public final native Object addColors(Color color1,Color color2)/*-{
return this.addColors(color1,color2);
}-*/;

public final native Color addScalar(double s)/*-{
return this.addScalar(s);
}-*/;

public final native Color multiply(Color color)/*-{
return this.multiply(color);
}-*/;

public final native Object multiplyScalar(double s)/*-{
return this.multiplyScalar(s);
}-*/;

public final native Color lerp(Color color,double alpha)/*-{
return this.lerp(color,alpha);
}-*/;

public final native boolean equals(Color c)/*-{
return this.equals(c);
}-*/;

public final native Color fromArray(JsArrayNumber array)/*-{
return this.fromArray(array);
}-*/;

public final native JsArrayNumber toArray()/*-{
return this.toArray();
}-*/;

public final native Color clone()/*-{
return this.clone();
}-*/;

}
