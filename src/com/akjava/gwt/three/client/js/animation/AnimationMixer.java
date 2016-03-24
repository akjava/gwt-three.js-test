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

import com.akjava.gwt.three.client.js.core.EventDispatcher;
import com.google.gwt.core.client.JavaScriptObject;


public class AnimationMixer extends EventDispatcher{
	protected AnimationMixer() {
	}

	
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

public final native AnimationMixerAction clipAction(AnimationClip clip)/*-{
return this.clipAction(clip);
}-*/;
public final native AnimationMixerAction clipAction(String clip)/*-{
return this.clipAction(clip);
}-*/;

public final native AnimationMixerAction clipAction(AnimationClip clip,JavaScriptObject optionalRoot)/*-{
return this.clipAction(clip,optionalRoot);
}-*/;
public final native AnimationMixerAction clipAction(String clip,JavaScriptObject optionalRoot)/*-{
return this.clipAction(clip,optionalRoot);
}-*/;

public final native AnimationMixerAction existingAction(AnimationClip clip,JavaScriptObject optionalRoot)/*-{
return this.existingAction(clip,optionalRoot);
}-*/;
public final native AnimationMixerAction existingAction(String clip,JavaScriptObject optionalRoot)/*-{
return this.existingAction(clip,optionalRoot);
}-*/;

public final native AnimationMixer stopAllAction()/*-{
return this.stopAllAction();
}-*/;


public final native AnimationMixer update(double deltaTime)/*-{
return this.update(deltaTime);
}-*/;

public final native void uncacheClip(AnimationClip clip)/*-{
 this.uncacheClip(clip);
}-*/;

public final native void uncacheRoot(JavaScriptObject root)/*-{
 this.uncacheRoot(root);
}-*/;

public final native void uncacheAction(AnimationClip clip,JavaScriptObject optionalRoot)/*-{
this.uncacheAction(clip, optionalRoot );
}-*/;

}
