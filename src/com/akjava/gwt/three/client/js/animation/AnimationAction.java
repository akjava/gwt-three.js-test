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


public class AnimationAction extends JavaScriptObject{
	protected AnimationAction() {
	}

public final native AnimationClip getClip()/*-{
return this.clip;
}-*/;

public final native void setClip(AnimationClip clip)/*-{
this.clip = clip;
}-*/;


public final native JavaScriptObject getLocalRoot()/*-{
return this.localRoot;
}-*/;

public final native void setLocalRoot(JavaScriptObject localRoot)/*-{
this.localRoot = localRoot;
}-*/;


public final native double getStartTime()/*-{
return this.startTime;
}-*/;

public final native void setStartTime(double startTime)/*-{
this.startTime = startTime;
}-*/;


public final native double getTimeScale()/*-{
return this.timeScale;
}-*/;

public final native void setTimeScale(double timeScale)/*-{
this.timeScale = timeScale;
}-*/;


/**
 * 
 * @return possible number,default is 1
 */
public final native KeyframeTrack getWeight()/*-{
return this.weight;
}-*/;

public final native void setWeight(KeyframeTrack weight)/*-{
this.weight = weight;
}-*/;

public final native void setWeight(double weight)/*-{
this.weight = weight;
}-*/;

/*
THREE.LoopOnce = 2200;
THREE.LoopRepeat = 2201;
THREE.LoopPingPing = 2202;
*/

public final native int getLoop()/*-{
return this.loop;
}-*/;

public final native void setLoop(int loop)/*-{
this.loop = loop;
}-*/;


public final native int getLoopCount()/*-{
return this.loopCount;
}-*/;

public final native void setLoopCount(int loopCount)/*-{
this.loopCount = loopCount;
}-*/;


public final native boolean isEnabled()/*-{
return this.enabled;
}-*/;

public final native void setEnabled(boolean enabled)/*-{
this.enabled = enabled;
}-*/;


public final native double getActionTime()/*-{
return this.actionTime;
}-*/;

public final native void setActionTime(double actionTime)/*-{
this.actionTime = actionTime;
}-*/;


public final native double getClipTime()/*-{
return this.clipTime;
}-*/;

public final native void setClipTime(double clipTime)/*-{
this.clipTime = clipTime;
}-*/;


public final native JsArray<PropertyBinding> getPropertyBindings()/*-{
return this.propertyBindings;
}-*/;

public final native void setPropertyBindings(JsArray<PropertyBinding> propertyBindings)/*-{
this.propertyBindings = propertyBindings;
}-*/;

public final native AnimationAction setLocalRoot(Object localRoot)/*-{
return this.setLocalRoot(localRoot);
}-*/;

public final native double updateTime(double clipDeltaTime)/*-{
return this.updateTime(clipDeltaTime);
}-*/;

public final native AnimationAction syncWith(AnimationAction action)/*-{
return this.syncWith(action);
}-*/;

public final native AnimationAction warpToDuration(Object duration)/*-{
return this.warpToDuration(duration);
}-*/;

public final native AnimationAction init(double time)/*-{
return this.init(time);
}-*/;

/*
 * possible any type
 */
public final native JsArray update(double clipDeltaTime)/*-{
return this.update(clipDeltaTime);
}-*/;

public final native double getTimeScaleAt(double time)/*-{
return this.getTimeScaleAt(time);
}-*/;

public final native double getWeightAt(double time)/*-{
return this.getWeightAt(time);
}-*/;


}
