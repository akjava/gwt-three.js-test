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

/**
 * now this is mixer's internal class ,officially called _Action
 * @author aki
 *
 */
public class AnimationMixerAction extends JavaScriptObject{
	protected AnimationMixerAction() {
	}
	
	

public final native AnimationMixerAction play()/*-{
return this.play();
}-*/;

public final native AnimationMixerAction stop()/*-{
return this.stop();
}-*/;

public final native AnimationMixerAction reset()/*-{
return this.reset();
}-*/;

public final native boolean isRunning()/*-{
return this.isRunning();
}-*/;

public final native boolean isScheduled()/*-{
return this.isScheduled();
}-*/;

public final native AnimationMixerAction startAt(double time)/*-{
return this.startAt(time);
}-*/;

public final native AnimationMixerAction setLoop(int mode,double repetitions)/*-{
return this.setLoop(mode,repetitions);
}-*/;

public final native AnimationMixerAction setEffectiveWeight(double weight)/*-{
return this.setEffectiveWeight(weight);
}-*/;

public final native double getEffectiveWeight()/*-{
return this.getEffectiveWeight();
}-*/;

public final native AnimationMixerAction fadeIn(double duration)/*-{
return this.fadeIn(duration);
}-*/;

public final native AnimationMixerAction fadeOut(double duration)/*-{
return this.fadeOut(duration);
}-*/;

public final native AnimationMixerAction crossFadeFrom(AnimationMixerAction fadeOutAction,double duration,boolean warp)/*-{
return this.crossFadeFrom(fadeOutAction,duration,warp);
}-*/;

public final native AnimationMixerAction crossFadeTo(AnimationMixerAction fadeInAction,double duration,boolean warp)/*-{
return this.crossFadeTo(fadeInAction,duration,warp);
}-*/;

public final native AnimationMixerAction stopFading()/*-{
return this.stopFading();
}-*/;

public final native AnimationMixerAction setEffectiveTimeScale(double timeScale)/*-{
return this.setEffectiveTimeScale(timeScale);
}-*/;

public final native double getEffectiveTimeScale()/*-{
return this.getEffectiveTimeScale();
}-*/;

public final native AnimationMixerAction setDuration(double duration)/*-{
return this.setDuration(duration);
}-*/;

public final native AnimationMixerAction syncWith(AnimationMixerAction action)/*-{
return this.syncWith(action);
}-*/;

public final native AnimationMixerAction halt(double duration)/*-{
return this.halt(duration);
}-*/;

public final native AnimationMixerAction warp(double startTimeScale,double endTimeScale,double duration)/*-{
return this.warp(startTimeScale,endTimeScale,duration);
}-*/;

public final native AnimationMixerAction stopWarping()/*-{
return this.stopWarping();
}-*/;

public final native AnimationMixer getMixer()/*-{
return this.getMixer();
}-*/;

public final native AnimationClip getClip()/*-{
return this.getClip();
}-*/;

public final native JavaScriptObject getRoot()/*-{
return this.getRoot();
}-*/;






public final native double getTime()/*-{
return this.time;
}-*/;
public final native void setTime(double time)/*-{
this.time = time;
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




public final native boolean isEnabled()/*-{
return this.enabled;
}-*/;

public final native void setEnabled(boolean enabled)/*-{
this.enabled = enabled;
}-*/;

/*
 * TODO check 
 * 
repetitions
paused
clampWhenFinished
zeroSlopeAtStart
zeroSlopeAtEnd
 */

}
