/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2015 akimisaki3@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r67
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
package com.akjava.gwt.three.client.js.objects;

import com.akjava.gwt.three.client.js.math.Matrix4;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.typedarrays.shared.Float32Array;


public class Skeleton extends JavaScriptObject{
	protected Skeleton() {
	}


public final native Bone addBone(Bone bone)/*-{
return bone;
}-*/;

public final native void calculateInverses(Bone bone)/*-{
this.calculateInverses(bone);
}-*/;



public final native JsArray<Bone> getBones()/*-{
return this.bones;
}-*/;

public final native Float32Array getBoneMatrices()/*-{
return this.boneMatrices;
}-*/;

public final native JsArray<Matrix4> getBoneInverses()/*-{
return this.boneInverses;
}-*/;

public final native void pose()/*-{
this.pose();
}-*/;

public final native void update()/*-{
this.update();
}-*/;

public final native Skeleton copy(Skeleton source)/*-{
return this.copy(source);
}-*/;

public final native Skeleton clone()/*-{
return this.copy(source);
}-*/;

public final Bone gwtGetBoneByName(String name){
	 JsArray<Bone> bones=getBones();
	 for(int i=0;i<bones.length();i++){
		 if(bones.get(i).getName().equals(name)){
			 return bones.get(i);
		 }
	 }
	 return null;
}
}
