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

import com.akjava.gwt.three.client.js.cameras.OrthographicCamera;
import com.akjava.gwt.three.client.js.materials.ShaderMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderTarget;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JavaScriptObject;


public class BloomPass extends JavaScriptObject{
	protected BloomPass() {
	}

public final native Object getStrength()/*-{
return this.strength;
}-*/;

public final native void setStrength(Object strength)/*-{
this.strength = strength;
}-*/;


public final native Object getKernelSize()/*-{
return this.kernelSize;
}-*/;

public final native void setKernelSize(Object kernelSize)/*-{
this.kernelSize = kernelSize;
}-*/;


public final native Object getSigma()/*-{
return this.sigma;
}-*/;

public final native void setSigma(Object sigma)/*-{
this.sigma = sigma;
}-*/;


public final native Object getResolution()/*-{
return this.resolution;
}-*/;

public final native void setResolution(Object resolution)/*-{
this.resolution = resolution;
}-*/;


public final native WebGLRenderTarget getRenderTargetX()/*-{
return this.renderTargetX;
}-*/;

public final native void setRenderTargetX(WebGLRenderTarget renderTargetX)/*-{
this.renderTargetX = renderTargetX;
}-*/;


public final native WebGLRenderTarget getRenderTargetY()/*-{
return this.renderTargetY;
}-*/;

public final native void setRenderTargetY(WebGLRenderTarget renderTargetY)/*-{
this.renderTargetY = renderTargetY;
}-*/;


public final native Object getCopyUniforms()/*-{
return this.copyUniforms;
}-*/;

public final native void setCopyUniforms(Object copyUniforms)/*-{
this.copyUniforms = copyUniforms;
}-*/;


public final native ShaderMaterial getMaterialCopy()/*-{
return this.materialCopy;
}-*/;

public final native void setMaterialCopy(ShaderMaterial materialCopy)/*-{
this.materialCopy = materialCopy;
}-*/;


public final native Object getConvolutionUniforms()/*-{
return this.convolutionUniforms;
}-*/;

public final native void setConvolutionUniforms(Object convolutionUniforms)/*-{
this.convolutionUniforms = convolutionUniforms;
}-*/;


public final native ShaderMaterial getMaterialConvolution()/*-{
return this.materialConvolution;
}-*/;

public final native void setMaterialConvolution(ShaderMaterial materialConvolution)/*-{
this.materialConvolution = materialConvolution;
}-*/;


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


public final native boolean isClear()/*-{
return this.clear;
}-*/;

public final native void setClear(boolean clear)/*-{
this.clear = clear;
}-*/;


public final native OrthographicCamera getCamera()/*-{
return this.camera;
}-*/;

public final native void setCamera(OrthographicCamera camera)/*-{
this.camera = camera;
}-*/;


public final native Scene getScene()/*-{
return this.scene;
}-*/;

public final native void setScene(Scene scene)/*-{
this.scene = scene;
}-*/;


public final native Mesh getQuad()/*-{
return this.quad;
}-*/;

public final native void setQuad(Mesh quad)/*-{
this.quad = quad;
}-*/;

public final native void render(Object renderer,Object writeBuffer,Object readBuffer,Object delta,Object maskActive)/*-{
this.render(renderer,writeBuffer,readBuffer,delta,maskActive);
}-*/;


}
