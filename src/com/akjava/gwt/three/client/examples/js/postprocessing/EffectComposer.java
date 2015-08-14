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

import com.akjava.gwt.three.client.js.renderers.WebGLRenderTarget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


public class EffectComposer extends JavaScriptObject{
	protected EffectComposer() {
	}

public final native Object getRenderer()/*-{
return this.renderer;
}-*/;

public final native void setRenderer(Object renderer)/*-{
this.renderer = renderer;
}-*/;


public final native WebGLRenderTarget getRenderTarget()/*-{
return this.renderTarget;
}-*/;

public final native void setRenderTarget(WebGLRenderTarget renderTarget)/*-{
this.renderTarget = renderTarget;
}-*/;


public final native WebGLRenderTarget getRenderTarget1()/*-{
return this.renderTarget1;
}-*/;

public final native void setRenderTarget1(WebGLRenderTarget renderTarget1)/*-{
this.renderTarget1 = renderTarget1;
}-*/;


public final native WebGLRenderTarget getRenderTarget2()/*-{
return this.renderTarget2;
}-*/;

public final native void setRenderTarget2(WebGLRenderTarget renderTarget2)/*-{
this.renderTarget2 = renderTarget2;
}-*/;


public final native Object getWriteBuffer()/*-{
return this.writeBuffer;
}-*/;

public final native void setWriteBuffer(Object writeBuffer)/*-{
this.writeBuffer = writeBuffer;
}-*/;


public final native Object getReadBuffer()/*-{
return this.readBuffer;
}-*/;

public final native void setReadBuffer(Object readBuffer)/*-{
this.readBuffer = readBuffer;
}-*/;


public final native JsArray<JavaScriptObject> getPasses()/*-{
return this.passes;
}-*/;

public final native void setPasses(JsArray<JavaScriptObject> passes)/*-{
this.passes = passes;
}-*/;


public final native ShaderPass getCopyPass()/*-{
return this.copyPass;
}-*/;

public final native void setCopyPass(ShaderPass copyPass)/*-{
this.copyPass = copyPass;
}-*/;

public final native void swapBuffers()/*-{
this.swapBuffers();
}-*/;

public final native void addPass(JavaScriptObject pass)/*-{
this.addPass(pass);
}-*/;

public final native void insertPass(Object pass,Object index)/*-{
this.insertPass(pass,index);
}-*/;

public final native void render()/*-{
this.render();
}-*/;

public final native void render(Object delta)/*-{
this.render(delta);
}-*/;

public final native void reset(Object renderTarget)/*-{
this.reset(renderTarget);
}-*/;

public final native void setSize(int width,int height)/*-{
this.setSize(width,height);
}-*/;


}
