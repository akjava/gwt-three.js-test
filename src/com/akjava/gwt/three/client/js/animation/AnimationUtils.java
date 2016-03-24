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
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;



public class AnimationUtils extends JavaScriptObject{
	protected AnimationUtils() {
		
	}

public static final native JavaScriptObject arraySlice(JavaScriptObject array,int from,int to)/*-{
return $wnd.THREE.AnimationUtils.arraySlice(array,from,to);
}-*/;

public static final native JavaScriptObject convertArray(JavaScriptObject array,JavaScriptObject type,boolean forceClone)/*-{
return $wnd.THREE.AnimationUtils.convertArray(array,type,forceClone);
}-*/;

public static final native boolean isTypedArray(JavaScriptObject object)/*-{
return $wnd.THREE.AnimationUtils.isTypedArray(object);
}-*/;

public static final native JsArray<JavaScriptObject> getKeyframeOrder(JsArray<JavaScriptObject> times)/*-{
return $wnd.THREE.AnimationUtils.getKeyframeOrder(times);
}-*/;

public static final native boolean sortedArray(JsArray<JavaScriptObject> values,int stride,JsArray<JavaScriptObject> order)/*-{
return $wnd.THREE.AnimationUtils.sortedArray(values, stride, order);
}-*/;

public static final native void flattenJSON(JsArrayString jsonKeys,JsArray<JavaScriptObject> times, JsArray<JavaScriptObject>values,String valuePropertyName)/*-{
$wnd.THREE.AnimationUtils.flattenJSON(jsonKeys, times, values, valuePropertyName);
}-*/;
}
