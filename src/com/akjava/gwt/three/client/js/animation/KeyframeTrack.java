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

import com.akjava.gwt.three.client.gwt.animation.KeyframeTrackKey;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONObject;


public class KeyframeTrack extends JavaScriptObject{
	protected KeyframeTrack() {
	}

public final native String getName()/*-{
return this.name;
}-*/;



//maybe array
public final native JsArray<KeyframeTrackKey> getKeys()/*-{
return this.keys;
}-*/;

public final native void setKeys(JsArray<KeyframeTrackKey> keys)/*-{
this.keys = keys;
}-*/;


public final native int getLastIndex()/*-{
return this.lastIndex;
}-*/;

public final native void setLastIndex(int lastIndex)/*-{
this.lastIndex = lastIndex;
}-*/;

//return any it's impossible implement on gwt
public final native Object getAt(double time)/*-{
return this.getAt(time);
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

public final native KeyframeTrack validate()/*-{
return this.validate();
}-*/;

public final native KeyframeTrack optimize()/*-{
return this.optimize();
}-*/;



public final native KeyframeTrack parse(JSONObject json)/*-{
return this.parse(json);
}-*/;

}
