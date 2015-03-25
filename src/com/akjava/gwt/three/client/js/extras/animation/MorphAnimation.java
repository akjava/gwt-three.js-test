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
package com.akjava.gwt.three.client.js.extras.animation;

import com.akjava.gwt.three.client.js.objects.MorphAnimMesh;
import com.google.gwt.core.client.JavaScriptObject;


public class MorphAnimation extends JavaScriptObject{
	protected MorphAnimation() {
	}

public final native MorphAnimMesh getMesh()/*-{
return this.mesh;
}-*/;



public final native int getFrames()/*-{
return this.frames;
}-*/;

public final native void setFrames(int frames)/*-{
this.frames = frames;
}-*/;


public final native int getCurrentTime()/*-{
return this.currentTime;
}-*/;

public final native void setCurrentTime(int currentTime)/*-{
this.currentTime = currentTime;
}-*/;


public final native int getDuration()/*-{
return this.duration;
}-*/;

public final native void setDuration(int duration)/*-{
this.duration = duration;
}-*/;


public final native boolean isLoop()/*-{
return this.loop;
}-*/;

public final native void setLoop(boolean loop)/*-{
this.loop = loop;
}-*/;


public final native int getLastFrame()/*-{
return this.lastFrame;
}-*/;

public final native void setLastFrame(int lastFrame)/*-{
this.lastFrame = lastFrame;
}-*/;


public final native int getCurrentFrame()/*-{
return this.currentFrame;
}-*/;

public final native void setCurrentFrame(int currentFrame)/*-{
this.currentFrame = currentFrame;
}-*/;


public final native boolean isIsPlaying()/*-{
return this.isPlaying;
}-*/;

public final native void setIsPlaying(boolean isPlaying)/*-{
this.isPlaying = isPlaying;
}-*/;

public final native void play()/*-{
this.play();
}-*/;

public final native void pause()/*-{
this.pause();
}-*/;

//possible set large value
public final native void update(double delta)/*-{
this.update(delta);
}-*/;


}
