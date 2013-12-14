/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2011 aki@akjava.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r45
 https://github.com/mrdoob/three.js
 The MIT License

Copyright (c) 2010-2011 three.js Authors. All rights reserved.

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
package com.akjava.gwt.three.client.js.scenes;

import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.materials.Material;

public class Scene extends Object3D{
protected Scene(){}

//you have to check by yourself
public final native Fog getFog()/*-{
return this.fog;
}-*/;
//you have to check by yourself
public final native FogExp2 getFogExp2()/*-{
return this.fog;
}-*/;

//should i support FogEx2?
public final native void setFog(Fog fog)/*-{
this.fog = fog;
}-*/;

public final native void setFogExp2(FogExp2 fog)/*-{
this.fog = fog;
}-*/;

/**
 * i'm not sure
 * @return
 */
public final native Material getOverrideMaterial()/*-{
return this.overrideMaterial;
}-*/;
/**
 * i'm not sure
 * @return
 */
public final native void setOverrideMaterial(Material overrideMaterial)/*-{
this.overrideMaterial = overrideMaterial;
}-*/;


public final native boolean isAutoUpdate()/*-{
return this.autoUpdate;
}-*/;

public final native void setAutoUpdate(boolean autoUpdate)/*-{
this.autoUpdate = autoUpdate;
}-*/;

public final native Scene clone(Scene object)/*-{
return this.clone(object);
}-*/;

}
