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

import com.akjava.gwt.three.client.gwt.boneanimation.AnimationData;
import com.akjava.gwt.three.client.gwt.core.MorphTarget;
import com.akjava.gwt.three.client.js.objects.Bone;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;


public class AnimationClip extends JavaScriptObject{
	protected AnimationClip() {
	}

public final native String getName()/*-{
return this.name;
}-*/;

public final native void setName(String name)/*-{
this.name = name;
}-*/;


public final native JsArray<? extends KeyframeTrack> getTracks()/*-{
return this.tracks;
}-*/;

public final native void setTracks(JsArray<KeyframeTrack> tracks)/*-{
this.tracks = tracks;
}-*/;




public final native void setDuration(double duration)/*-{
this.duration = duration;
}-*/;


public final native double getDuration()/*-{
return this.duration;
}-*/;

public final native void resetDuration()/*-{
 this.resetDuration();
}-*/;



public final native AnimationClip trim()/*-{
return this.trim();
}-*/;

public final native AnimationClip optimize()/*-{
return this.optimize();
}-*/;



public static final native AnimationClip findByName(JsArray<AnimationClip> clipArray,String name)/*-{
return $wnd.THREE.AnimationClip.findByName(clipArray,name);
}-*/;

public static final native JavaScriptObject toJSON(AnimationClip clip)/*-{
return $wnd.THREE.AnimationClip.toJSON(clip);
}-*/;

public static final native AnimationClip parse(JSONValue json)/*-{
return $wnd.THREE.AnimationClip.parse(json);
}-*/;

public static final native AnimationClip parseAnimation(AnimationData animation,JsArray<Bone> bones,String nodeName)/*-{
return $wnd.THREE.AnimationClip.parseAnimation(animation,bones,nodeName);
}-*/;

public static final native JsArray<AnimationClip> CreateClipsFromMorphTargetSequences(JsArray<MorphTarget> morphTargets,double fps)/*-{
return $wnd.THREE.AnimationClip.CreateClipsFromMorphTargetSequences(morphTargets,fps);
}-*/;

public static final native AnimationClip CreateFromMorphTargetSequence(String name,JsArray<MorphTarget> morphTarget,double fps)/*-{
return $wnd.THREE.AnimationClip.CreateFromMorphTargetSequence(name,morphTarget,fps);
}-*/;

}
