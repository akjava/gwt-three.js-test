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


public final native JsArray<KeyframeTrack> getTracks()/*-{
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



/**
 * possible any type(Object,number,boolean,String)
 * @return
 */
public final native JsArray<JavaScriptObject> getResults()/*-{
return this.results;
}-*/;

public final native void setResults(JsArray<JavaScriptObject> results)/*-{
this.results = results;
}-*/;

public final native JavaScriptObject getAt(double clipTime)/*-{
return this.getAt(clipTime);
}-*/;

public final native AnimationClip trim()/*-{
return this.trim();
}-*/;

public final native AnimationClip optimize()/*-{
return this.optimize();
}-*/;



public final native AnimationClip findByName(AnimationClip clipArray,String name)/*-{
return this.findByName(clipArray,name);
}-*/;



public final native AnimationClip parse(JSONValue json)/*-{
return this.parse(json);
}-*/;

public final native AnimationClip parseAnimation(AnimationData animation,JsArray<Bone> bones,String nodeName)/*-{
return this.parseAnimation(animation,bones,nodeName);
}-*/;

public static final native JsArray<AnimationClip> CreateClipsFromMorphTargetSequences(JsArray<MorphTarget> morphTargets,double fps)/*-{
return $wnd.THREE.AnimationClip.CreateClipsFromMorphTargetSequences(morphTargets,fps);
}-*/;

public static final native AnimationClip CreateFromMorphTargetSequence(String name,MorphTarget morphTarget,double fps)/*-{
return $wnd.THREE.AnimationClip.CreateFromMorphTargetSequence(name,morphTarget,fps);
}-*/;

}