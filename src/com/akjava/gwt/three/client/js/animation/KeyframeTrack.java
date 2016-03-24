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
import com.google.gwt.json.client.JSONValue;


public class KeyframeTrack extends JavaScriptObject{
	protected KeyframeTrack() {
	}

public final native String getName()/*-{
return this.name;
}-*/;

/*
 * default Float32Array
 */
public final native JavaScriptObject getTimes()/*-{
return this.times;
}-*/;
/*
 * default Float32Array
 */
public final native JavaScriptObject getValues()/*-{
return this.values;
}-*/;

public final native void setInterpolation(int interpolation)/*-{
this.setInterpolation(interpolation);
}-*/;

public final native int getInterpolation()/*-{
return this.getInterpolation();
}-*/;

public final native int getValueSize()/*-{
return this.getValueSize();
}-*/;

public final native KeyframeTrack shift(double timeOffset)/*-{
return this.shift(timeOffset);
}-*/;

public final native KeyframeTrack scale(double timeScale)/*-{
return this.scale(timeScale);
}-*/;

public final native KeyframeTrack trim(double startTime,double endTime)/*-{
return this.trim(startTime,endTime);
}-*/;

public final native KeyframeTrack sort()/*-{
return this.sort();
}-*/;

public final native boolean validate()/*-{
return this.validate();
}-*/;

public final native KeyframeTrack optimize()/*-{
return this.optimize();
}-*/;



public static final native KeyframeTrack parse(JSONValue json)/*-{
return $wnd.THREE.KeyframeTrack.parse(json);
}-*/;

public static final native JSONValue toJSon(KeyframeTrack track)/*-{
return $wnd.THREE.KeyframeTrack.toJSon(track);
}-*/;

public final native String getValueTypeName()/*-{
return this.ValueTypeName;
}-*/;

//TODO implement others
}
