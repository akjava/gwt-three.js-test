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

import com.akjava.gwt.three.client.gwt.extras.Uniforms;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.cameras.OrthographicCamera;
import com.akjava.gwt.three.client.js.materials.MeshDepthMaterial;
import com.akjava.gwt.three.client.js.materials.ShaderMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderTarget;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JavaScriptObject;


public class BokehPass extends JavaScriptObject{
	protected BokehPass() {
	}

public final native Scene getScene()/*-{
return this.scene;
}-*/;

//public final native void setScene(Object scene)/*-{
//this.scene = scene;
//}-*/;


public final native Camera getCamera()/*-{
return this.camera;
}-*/;

//public final native void setCamera(Object camera)/*-{
//this.camera = camera;
//}-*/;


public final native WebGLRenderTarget getRenderTargetColor()/*-{
return this.renderTargetColor;
}-*/;

//public final native void setRenderTargetColor(WebGLRenderTarget renderTargetColor)/*-{
//this.renderTargetColor = renderTargetColor;
//}-*/;


public final native WebGLRenderTarget getRenderTargetDepth()/*-{
return this.renderTargetDepth;
}-*/;

//public final native void setRenderTargetDepth(Object renderTargetDepth)/*-{
//this.renderTargetDepth = renderTargetDepth;
//}-*/;


public final native MeshDepthMaterial getMaterialDepth()/*-{
return this.materialDepth;
}-*/;

//public final native void setMaterialDepth(MeshDepthMaterial materialDepth)/*-{
//this.materialDepth = materialDepth;
//}-*/;


public final native ShaderMaterial getMaterialBokeh()/*-{
return this.materialBokeh;
}-*/;

//public final native void setMaterialBokeh(ShaderMaterial materialBokeh)/*-{
//this.materialBokeh = materialBokeh;
//}-*/;


public final native Uniforms getUniforms()/*-{
return this.uniforms;
}-*/;


//can't replace
//public final native void setUniforms(Object uniforms)/*-{
//this.uniforms = uniforms;
//}-*/;


public final native boolean isEnabled()/*-{
return this.enabled;
}-*/;

public final native void setEnabled(boolean enabled)/*-{
this.enabled = enabled;
}-*/;


public final native boolean isNeedsSwap()/*-{
return this.needsSwap;
}-*/;

public final native void setNeedsSwap(boolean needsSwap)/*-{
this.needsSwap = needsSwap;
}-*/;


public final native boolean isRenderToScreen()/*-{
return this.renderToScreen;
}-*/;

public final native void setRenderToScreen(boolean renderToScreen)/*-{
this.renderToScreen = renderToScreen;
}-*/;


public final native boolean isClear()/*-{
return this.clear;
}-*/;

public final native void setClear(boolean clear)/*-{
this.clear = clear;
}-*/;


public final native OrthographicCamera getCamera2()/*-{
return this.camera2;
}-*/;

public final native void setCamera2(OrthographicCamera camera2)/*-{
this.camera2 = camera2;
}-*/;


public final native Scene getScene2()/*-{
return this.scene2;
}-*/;

//public final native void setScene2(Scene scene2)/*-{
//this.scene2 = scene2;
//}-*/;


public final native Mesh getQuad2()/*-{
return this.quad2;
}-*/;

//public final native void setQuad2(Mesh quad2)/*-{
//this.quad2 = quad2;
//}-*/;

public final native void render(WebGLRenderer renderer,WebGLRenderTarget writeBuffer,WebGLRenderTarget readBuffer,double delta,boolean maskActive)/*-{
this.render(renderer,writeBuffer,readBuffer,delta,maskActive);
}-*/;


}
