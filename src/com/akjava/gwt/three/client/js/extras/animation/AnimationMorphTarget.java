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
package com.akjava.gwt.three.client.js.extras.animation;

import com.akjava.gwt.three.client.gwt.animation.AnimationData;
import com.akjava.gwt.three.client.gwt.animation.AnimationHierarchyItem;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


public class AnimationMorphTarget extends JavaScriptObject{
	protected AnimationMorphTarget() {
	}

public final native Object3D getRoot()/*-{
return this.root;
}-*/;




public final native AnimationData getData()/*-{
return this.data;
}-*/;




public final native JsArray<AnimationHierarchyItem> getHierarchy()/*-{
return this.hierarchy;
}-*/;




public final native double getCurrentTime()/*-{
return this.currentTime;
}-*/;

public final native void setCurrentTime(double currentTime)/*-{
this.currentTime = currentTime;
}-*/;


public final native double getTimeScale()/*-{
return this.timeScale;
}-*/;

public final native void setTimeScale(double timeScale)/*-{
this.timeScale = timeScale;
}-*/;


public final native boolean isIsPlaying()/*-{
return this.isPlaying;
}-*/;

public final native void setIsPlaying(boolean isPlaying)/*-{
this.isPlaying = isPlaying;
}-*/;


public final native boolean isIsPaused()/*-{
return this.isPaused;
}-*/;

public final native void setIsPaused(boolean isPaused)/*-{
this.isPaused = isPaused;
}-*/;


public final native boolean isLoop()/*-{
return this.loop;
}-*/;

public final native void setLoop(boolean loop)/*-{
this.loop = loop;
}-*/;


public final native double getInfluence()/*-{
return this.influence;
}-*/;

public final native void setInfluence(double influence)/*-{
this.influence = influence;
}-*/;

public final native void play(boolean loop,double startTimeMS)/*-{
this.play(loop,startTimeMS);
}-*/;

public final native void pause()/*-{
this.pause();
}-*/;

public final native void stop()/*-{
this.stop();
}-*/;

public final native void update(double deltaTimeMS)/*-{
return this.update(deltaTimeMS);
}-*/;


}
