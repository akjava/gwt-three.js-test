/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2013-2016 akimisaki3@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r73
 https://github.com/mrdoob/three.js

The MIT License

Copyright &copy; 2010-2016 three.js authors

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
package com.akjava.gwt.three.client.js.animation;

import com.google.gwt.core.client.JavaScriptObject;



public class AnimationUtils extends JavaScriptObject{
	protected AnimationUtils() {
		
	}

public static final native JavaScriptObject getEqualsFunc(JavaScriptObject exemplarValue)/*-{
return this.getEqualsFunc(exemplarValue);
}-*/;



public static final native JavaScriptObject clone(JavaScriptObject exemplarValue)/*-{
return this.clone(exemplarValue);
}-*/;

public static final native JavaScriptObject lerp(JavaScriptObject a,JavaScriptObject b,double alpha,boolean interTrack)/*-{
return this.lerp(a,b,alpha,interTrack);
}-*/;

public static final native double lerp(double a,double b,double alpha,boolean interTrack)/*-{
return this.lerp(a,b,alpha,interTrack);
}-*/;

public static final native boolean lerp(boolean a,boolean b,double alpha,boolean interTrack)/*-{
return this.lerp(a,b,alpha,interTrack);
}-*/;

public static final native String lerp(String a,String b,double alpha,boolean interTrack)/*-{
return this.lerp(a,b,alpha,interTrack);
}-*/;

public static final native JavaScriptObject lerp_object(JavaScriptObject a,JavaScriptObject b,double alpha)/*-{
return this.lerp_object(a,b,alpha);
}-*/;

public static final native JavaScriptObject slerp_object(JavaScriptObject a,JavaScriptObject b,double alpha)/*-{
return this.slerp_object(a,b,alpha);
}-*/;

public static final native double lerp_number(double a,double b,double alpha)/*-{
return this.lerp_number(a,b,alpha);
}-*/;

public static final native Object lerp_boolean(boolean a,boolean b,double alpha)/*-{
return this.lerp_boolean(a,b,alpha);
}-*/;

public static final native boolean lerp_boolean_immediate(boolean a,boolean b,double alpha)/*-{
return this.lerp_boolean_immediate(a,b,alpha);
}-*/;

public static final native String lerp_string(String a,String b,double alpha)/*-{
return this.lerp_string(a,b,alpha);
}-*/;

public static final native String lerp_string_immediate(String a,String b,double alpha)/*-{
return this.lerp_string_immediate(a,b,alpha);
}-*/;

public static final native JavaScriptObject getLerpFunc(JavaScriptObject exemplarValue,boolean interTrack)/*-{
return this.getLerpFunc(exemplarValue,interTrack);
}-*/;


}
