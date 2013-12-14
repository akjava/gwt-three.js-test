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
package com.akjava.gwt.three.client.extras.objects;

import com.akjava.gwt.three.client.objects.Mesh;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


public class MorphBlendMesh extends Mesh{
	protected MorphBlendMesh() {
	}
	
//TODO implement
public final native JavaScriptObject getAnimationsMap()/*-{
return this.animationsMap;
}-*/;

public final native void setAnimationsMap(Object animationsMap)/*-{
this.animationsMap = animationsMap;
}-*/;


public final native JsArray<JavaScriptObject> getAnimationsList()/*-{
return this.animationsList;
}-*/;

public final native void createAnimation(String name,int start,int end,double fps)/*-{
this.createAnimation(name,start,end,fps);
}-*/;

public final native void autoCreateAnimations(double fps)/*-{
this.autoCreateAnimations(fps);
}-*/;

public final native void setAnimationDirectionForward(String name)/*-{
this.setAnimationDirectionForward(name);
}-*/;

public final native void setAnimationDirectionBackward(String name)/*-{
this.setAnimationDirectionBackward(name);
}-*/;

public final native void setAnimationFPS(String name,double fps)/*-{
this.setAnimationFPS(name,fps);
}-*/;

public final native void setAnimationDuration(String name,double duration)/*-{
this.setAnimationDuration(name,duration);
}-*/;

public final native void setAnimationWeight(String name,double weight)/*-{
this.setAnimationWeight(name,weight);
}-*/;

public final native void setAnimationTime(String name,double time)/*-{
this.setAnimationTime(name,time);
}-*/;

public final native double getAnimationTime(String name)/*-{
return this.getAnimationTime(name);
}-*/;

public final native double getAnimationDuration(String name)/*-{
return this.getAnimationDuration(name);
}-*/;

public final native void playAnimation(String name)/*-{
this.playAnimation(name);
}-*/;

public final native void stopAnimation(String name)/*-{
this.stopAnimation(name);
}-*/;

public final native void update(double delta)/*-{
this.update(delta);
}-*/;


}
