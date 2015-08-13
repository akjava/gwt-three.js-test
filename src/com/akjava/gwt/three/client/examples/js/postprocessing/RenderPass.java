/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2013-2015 akimisaki3@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r69
 https://github.com/mrdoob/three.js

The MIT License

Copyright &copy; 2010-2014 three.js authors

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
package com.akjava.gwt.three.client.examples.js.postprocessing;

import com.akjava.gwt.three.client.js.math.Color;
import com.google.gwt.core.client.JavaScriptObject;


public class RenderPass extends JavaScriptObject{
	protected RenderPass() {
	}

public final native Object getScene()/*-{
return this.scene;
}-*/;

public final native void setScene(Object scene)/*-{
this.scene = scene;
}-*/;


public final native Object getCamera()/*-{
return this.camera;
}-*/;

public final native void setCamera(Object camera)/*-{
this.camera = camera;
}-*/;


public final native Object getOverrideMaterial()/*-{
return this.overrideMaterial;
}-*/;

public final native void setOverrideMaterial(Object overrideMaterial)/*-{
this.overrideMaterial = overrideMaterial;
}-*/;


public final native Object getClearColor()/*-{
return this.clearColor;
}-*/;

public final native void setClearColor(Object clearColor)/*-{
this.clearColor = clearColor;
}-*/;


public final native Object getClearAlpha()/*-{
return this.clearAlpha;
}-*/;

public final native void setClearAlpha(Object clearAlpha)/*-{
this.clearAlpha = clearAlpha;
}-*/;


public final native Color getOldClearColor()/*-{
return this.oldClearColor;
}-*/;

public final native void setOldClearColor(Color oldClearColor)/*-{
this.oldClearColor = oldClearColor;
}-*/;


public final native double getOldClearAlpha()/*-{
return this.oldClearAlpha;
}-*/;

public final native void setOldClearAlpha(double oldClearAlpha)/*-{
this.oldClearAlpha = oldClearAlpha;
}-*/;


public final native boolean isEnabled()/*-{
return this.enabled;
}-*/;

public final native void setEnabled(boolean enabled)/*-{
this.enabled = enabled;
}-*/;


public final native boolean isClear()/*-{
return this.clear;
}-*/;

public final native void setClear(boolean clear)/*-{
this.clear = clear;
}-*/;


public final native boolean isNeedsSwap()/*-{
return this.needsSwap;
}-*/;

public final native void setNeedsSwap(boolean needsSwap)/*-{
this.needsSwap = needsSwap;
}-*/;

public final native void render(Object renderer,Object writeBuffer,Object readBuffer,Object delta)/*-{
this.render(renderer,writeBuffer,readBuffer,delta);
}-*/;


}
