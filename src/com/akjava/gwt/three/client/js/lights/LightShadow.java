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
package com.akjava.gwt.three.client.js.lights;

import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.math.Matrix4;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderTarget;
import com.google.gwt.core.client.JavaScriptObject;


public class LightShadow extends JavaScriptObject{
	protected LightShadow() {
	}

public final native Camera getCamera()/*-{
return this.camera;
}-*/;

public final native void setCamera(Camera camera)/*-{
this.camera = camera;
}-*/;


public final native double getBias()/*-{
return this.bias;
}-*/;

public final native void setBias(double bias)/*-{
this.bias = bias;
}-*/;


public final native double getDarkness()/*-{
return this.darkness;
}-*/;

public final native void setDarkness(double darkness)/*-{
this.darkness = darkness;
}-*/;


public final native Vector2 getMapSize()/*-{
return this.mapSize;
}-*/;

public final native void setMapSize(Vector2 mapSize)/*-{
this.mapSize = mapSize;
}-*/;


public final native WebGLRenderTarget getMap()/*-{
return this.map;
}-*/;

public final native void setMap(WebGLRenderTarget map)/*-{
this.map = map;
}-*/;


public final native Matrix4 getMatrix()/*-{
return this.matrix;
}-*/;

public final native void setMatrix(Matrix4 matrix)/*-{
this.matrix = matrix;
}-*/;

public final native void copy(LightShadow source)/*-{
this.copy(source);
}-*/;

public final native LightShadow clone()/*-{
return this.clone();
}-*/;


}
