/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2013-2015 akimisaki3@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r69
 https://github.com/mrdoob/three.js

The MIT License

Copyright &copy; 2010-2014 three.js authors

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
package com.akjava.gwt.three.client.js.extras.audio;

import com.akjava.gwt.three.client.js.core.Object3D;
import com.google.gwt.core.client.JavaScriptObject;


//TODO wrap Web Audio
public class Audio extends Object3D{
	protected Audio() {
	}
	
	
public final native JavaScriptObject getContext()/*-{
return this.context;
}-*/;



public final native JavaScriptObject getSource()/*-{
return this.source;
}-*/;


public final native JavaScriptObject getGain()/*-{
return this.gain;
}-*/;



public final native JavaScriptObject getPanner()/*-{
return this.panner;
}-*/;


public final native void load(String file)/*-{
this.load(file);
}-*/;

public final native void setLoop(boolean value)/*-{
this.setLoop(value);
}-*/;

public final native void setRefDistance(double value)/*-{
this.setRefDistance(value);
}-*/;

public final native void setRolloffFactor(double value)/*-{
this.setRolloffFactor(value);
}-*/;


public final native boolean getAutoplay()/*-{
return this.autoplay;
}-*/;

public final native boolean getIsPlaying()/*-{
return this.isPlaying;
}-*/;

public final native void play()/*-{
this.play();
}-*/;

public final native void pause()/*-{
this.play();
}-*/;

public final native void stop()/*-{
this.play();
}-*/;

}
