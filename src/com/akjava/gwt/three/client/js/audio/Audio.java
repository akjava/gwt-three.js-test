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
package com.akjava.gwt.three.client.js.audio;

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


public final  native boolean isHasPlaybackControl()/*-{
return this.hasPlaybackControl;
}-*/;

public final  native void setHasPlaybackControl(boolean  param)/*-{
this.hasPlaybackControl=param;
}-*/;
public final  native String getSourceType()/*-{
return this.sourceType;
}-*/;

public final  native void setSourceType(String  param)/*-{
this.sourceType=param;
}-*/;

/**
 * 
 * @return depend on class
 * Audio return this.context.createGain()
 * PositionalAudio return this.context.createPanner();
 * 
 */
public final native JavaScriptObject getOutput()/*-{
return this.getOutput();
}-*/;



public final native void load(String file)/*-{
this.load(file);
}-*/;

public final native void setLoop(boolean value)/*-{
this.setLoop(value);
}-*/;




public final native boolean isAutoplay()/*-{
return this.autoplay;
}-*/;

public final native boolean isIsPlaying()/*-{
return this.isPlaying;
}-*/;

public final native void play()/*-{
this.play();
}-*/;

public final native void pause()/*-{
this.pause();
}-*/;

public final native void stop()/*-{
this.stop();
}-*/;

public final native void setVolume(double volume)/*-{
this.setVolume(volume);
}-*/;



public final  native void setAutoplay(boolean  param)/*-{
this.autoplay=param;
}-*/;
public final  native double getStartTime()/*-{
return this.startTime;
}-*/;

public final  native void setStartTime(double  param)/*-{
this.startTime=param;
}-*/;

public final  native void setNodeSource(JavaScriptObject value)/*-{
this.setNodeSource(value);
}-*/;

public final  native void setBuffer(JavaScriptObject value)/*-{
this.setBuffer(value);
}-*/;

public final  native void connect()/*-{
this.connect();
}-*/;

public final  native void disconnect()/*-{
this.disconnect();
}-*/;

public final  native JavaScriptObject getFilter()/*-{
return this.getFilter();
}-*/;

public final  native void setFilter(JavaScriptObject value)/*-{
this.setFilter(value);
}-*/;

public final  native void setPlaybackRate(double value)/*-{
this.setPlaybackRate(value);
}-*/;

public final  native double getPlaybackRate()/*-{
return this.getPlaybackRate();
}-*/;



public final  native boolean getLoop()/*-{
return this.getLoop();
}-*/;



public final  native double getVolume()/*-{
return this.getVolume();
}-*/;

}
