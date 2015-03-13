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
package com.akjava.gwt.three.client.js.core;

import com.akjava.gwt.three.client.gwt.core.Intersect;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.math.Ray;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


public class Raycaster extends JavaScriptObject{
	protected Raycaster() {
	}

public final native Ray getRay()/*-{
return this.ray;
}-*/;

public final native void setRay(Ray ray)/*-{
this.ray = ray;
}-*/;


public final native double getNear()/*-{
return this.near;
}-*/;

public final native void setNear(double near)/*-{
this.near = near;
}-*/;


public final native double getFar()/*-{
return this.far;
}-*/;

public final native void setFar(double far)/*-{
this.far = far;
}-*/;


public final native void set(Vector3 origin,Vector3 direction)/*-{
this.set(origin,direction);
}-*/;

public  final native JsArray<Intersect> intersectObject(Object3D object,boolean recursive)/*-{
return this.intersectObject(object,recursive);
}-*/;

/**
 * 
 * @param objects
 * possible warning:'THREE.Raycaster.intersectObjects: objects is not an Array.'  if array created by normal-way
 * must be create by javascript ,otherway use JavaScriptUtils
 * JsArray<Object3D> meshs=((JsArray<Object3D>) JavaScriptUtils.createJSArray().cast());
 * 
 * @param recursive
 * @return
 */
public  final native JsArray<Intersect> intersectObjects(JsArray<Object3D> objects,boolean recursive)/*-{
return this.intersectObjects(objects,recursive);
}-*/;

public final native void setFromCamera(Vector3 coords,Camera camera)/*-{
this.setFromCamera(coords,camera);
}-*/;
}
