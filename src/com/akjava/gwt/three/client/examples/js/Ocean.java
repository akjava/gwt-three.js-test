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
package com.akjava.gwt.three.client.examples.js;

import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.cameras.OrthographicCamera;
import com.akjava.gwt.three.client.js.materials.ShaderMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderTarget;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * just automatic created & fixed for example
 * @author aki
 *
 */
public class Ocean extends JavaScriptObject{
	protected Ocean() {
	}
	
	public final native void gwtInitUniforms(Camera camera)/*-{
	this.materialOcean.uniforms.u_projectionMatrix = { type: "m4", value: camera.projectionMatrix };
	this.materialOcean.uniforms.u_viewMatrix = { type: "m4", value: camera.matrixWorldInverse };
	this.materialOcean.uniforms.u_cameraPosition = { type: "v3", value: camera.position };
	}-*/;

	public final native Mesh getOceanMesh()/*-{
	return this.oceanMesh;
	}-*/;
	

public final native void setChanged(boolean changed)/*-{
this.changed=changed;
}-*/;

public final native boolean isChanged()/*-{
return this.changed;
}-*/;


public final native boolean isInitial()/*-{
return this.initial;
}-*/;

public final native void setInitial(boolean initial)/*-{
this.initial = initial;
}-*/;

public final native void setDeltaTime(double deltaTime)/*-{
this.deltaTime = deltaTime;
}-*/;


public final native OrthographicCamera getOceanCamera()/*-{
return this.oceanCamera;
}-*/;

public final native void setOceanCamera(OrthographicCamera oceanCamera)/*-{
this.oceanCamera = oceanCamera;
}-*/;


public final native Object getRenderer()/*-{
return this.renderer;
}-*/;

public final native void setRenderer(Object renderer)/*-{
this.renderer = renderer;
}-*/;


public final native Scene getScene()/*-{
return this.scene;
}-*/;

public final native void setScene(Scene scene)/*-{
this.scene = scene;
}-*/;


public final native Object getOptions()/*-{
return this.options;
}-*/;

public final native void setOptions(Object options)/*-{
this.options = options;
}-*/;


public final native Object getClearColor()/*-{
return this.clearColor;
}-*/;

public final native void setClearColor(Object clearColor)/*-{
this.clearColor = clearColor;
}-*/;


public final native Object getGeometryOrigin()/*-{
return this.geometryOrigin;
}-*/;

public final native void setGeometryOrigin(Object geometryOrigin)/*-{
this.geometryOrigin = geometryOrigin;
}-*/;


public final native double getSunDirectionX()/*-{
return this.sunDirectionX;
}-*/;

public final native void setSunDirectionX(double sunDirectionX)/*-{
this.sunDirectionX = sunDirectionX;
}-*/;


public final native double getSunDirectionY()/*-{
return this.sunDirectionY;
}-*/;

public final native void setSunDirectionY(double sunDirectionY)/*-{
this.sunDirectionY = sunDirectionY;
}-*/;


public final native double getSunDirectionZ()/*-{
return this.sunDirectionZ;
}-*/;

public final native void setSunDirectionZ(double sunDirectionZ)/*-{
this.sunDirectionZ = sunDirectionZ;
}-*/;


public final native Object getOceanColor()/*-{
return this.oceanColor;
}-*/;

public final native void setOceanColor(Object oceanColor)/*-{
this.oceanColor = oceanColor;
}-*/;


public final native Object getSkyColor()/*-{
return this.skyColor;
}-*/;

public final native void setSkyColor(Object skyColor)/*-{
this.skyColor = skyColor;
}-*/;


public final native double getExposure()/*-{
return this.exposure;
}-*/;

public final native void setExposure(double exposure)/*-{
this.exposure = exposure;
}-*/;


public final native Object getGeometryResolution()/*-{
return this.geometryResolution;
}-*/;

public final native void setGeometryResolution(Object geometryResolution)/*-{
this.geometryResolution = geometryResolution;
}-*/;


public final native Object getGeometrySize()/*-{
return this.geometrySize;
}-*/;

public final native void setGeometrySize(Object geometrySize)/*-{
this.geometrySize = geometrySize;
}-*/;


public final native Object getResolution()/*-{
return this.resolution;
}-*/;

public final native void setResolution(Object resolution)/*-{
this.resolution = resolution;
}-*/;


public final native Object getFloatSize()/*-{
return this.floatSize;
}-*/;

public final native void setFloatSize(Object floatSize)/*-{
this.floatSize = floatSize;
}-*/;


public final native double getWindX()/*-{
return this.windX;
}-*/;

public final native void setWindX(double windX)/*-{
this.windX = windX;
}-*/;


public final native double getWindY()/*-{
return this.windY;
}-*/;

public final native void setWindY(double windY)/*-{
this.windY = windY;
}-*/;


public final native double getSize()/*-{
return this.size;
}-*/;

public final native void setSize(double size)/*-{
this.size = size;
}-*/;


public final native double getChoppiness()/*-{
return this.choppiness;
}-*/;

public final native void setChoppiness(double choppiness)/*-{
this.choppiness = choppiness;
}-*/;


public final native boolean isMatrixNeedsUpdate()/*-{
return this.matrixNeedsUpdate;
}-*/;

public final native void setMatrixNeedsUpdate(boolean matrixNeedsUpdate)/*-{
this.matrixNeedsUpdate = matrixNeedsUpdate;
}-*/;


public final native WebGLRenderTarget getInitialSpectrumFramebuffer()/*-{
return this.initialSpectrumFramebuffer;
}-*/;

public final native void setInitialSpectrumFramebuffer(WebGLRenderTarget initialSpectrumFramebuffer)/*-{
this.initialSpectrumFramebuffer = initialSpectrumFramebuffer;
}-*/;


public final native WebGLRenderTarget getSpectrumFramebuffer()/*-{
return this.spectrumFramebuffer;
}-*/;

public final native void setSpectrumFramebuffer(WebGLRenderTarget spectrumFramebuffer)/*-{
this.spectrumFramebuffer = spectrumFramebuffer;
}-*/;


public final native WebGLRenderTarget getPingPhaseFramebuffer()/*-{
return this.pingPhaseFramebuffer;
}-*/;

public final native void setPingPhaseFramebuffer(WebGLRenderTarget pingPhaseFramebuffer)/*-{
this.pingPhaseFramebuffer = pingPhaseFramebuffer;
}-*/;


public final native WebGLRenderTarget getPongPhaseFramebuffer()/*-{
return this.pongPhaseFramebuffer;
}-*/;

public final native void setPongPhaseFramebuffer(WebGLRenderTarget pongPhaseFramebuffer)/*-{
this.pongPhaseFramebuffer = pongPhaseFramebuffer;
}-*/;


public final native WebGLRenderTarget getPingTransformFramebuffer()/*-{
return this.pingTransformFramebuffer;
}-*/;

public final native void setPingTransformFramebuffer(WebGLRenderTarget pingTransformFramebuffer)/*-{
this.pingTransformFramebuffer = pingTransformFramebuffer;
}-*/;


public final native WebGLRenderTarget getPongTransformFramebuffer()/*-{
return this.pongTransformFramebuffer;
}-*/;

public final native void setPongTransformFramebuffer(WebGLRenderTarget pongTransformFramebuffer)/*-{
this.pongTransformFramebuffer = pongTransformFramebuffer;
}-*/;


public final native WebGLRenderTarget getDisplacementMapFramebuffer()/*-{
return this.displacementMapFramebuffer;
}-*/;

public final native void setDisplacementMapFramebuffer(WebGLRenderTarget displacementMapFramebuffer)/*-{
this.displacementMapFramebuffer = displacementMapFramebuffer;
}-*/;


public final native WebGLRenderTarget getNormalMapFramebuffer()/*-{
return this.normalMapFramebuffer;
}-*/;

public final native void setNormalMapFramebuffer(WebGLRenderTarget normalMapFramebuffer)/*-{
this.normalMapFramebuffer = normalMapFramebuffer;
}-*/;


public final native ShaderMaterial getMaterialOceanHorizontal()/*-{
return this.materialOceanHorizontal;
}-*/;

public final native void setMaterialOceanHorizontal(ShaderMaterial materialOceanHorizontal)/*-{
this.materialOceanHorizontal = materialOceanHorizontal;
}-*/;


public final native ShaderMaterial getMaterialOceanVertical()/*-{
return this.materialOceanVertical;
}-*/;

public final native void setMaterialOceanVertical(ShaderMaterial materialOceanVertical)/*-{
this.materialOceanVertical = materialOceanVertical;
}-*/;


public final native ShaderMaterial getMaterialInitialSpectrum()/*-{
return this.materialInitialSpectrum;
}-*/;

public final native void setMaterialInitialSpectrum(ShaderMaterial materialInitialSpectrum)/*-{
this.materialInitialSpectrum = materialInitialSpectrum;
}-*/;


public final native ShaderMaterial getMaterialPhase()/*-{
return this.materialPhase;
}-*/;

public final native void setMaterialPhase(ShaderMaterial materialPhase)/*-{
this.materialPhase = materialPhase;
}-*/;


public final native ShaderMaterial getMaterialSpectrum()/*-{
return this.materialSpectrum;
}-*/;

public final native void setMaterialSpectrum(ShaderMaterial materialSpectrum)/*-{
this.materialSpectrum = materialSpectrum;
}-*/;


public final native ShaderMaterial getMaterialNormal()/*-{
return this.materialNormal;
}-*/;

public final native void setMaterialNormal(ShaderMaterial materialNormal)/*-{
this.materialNormal = materialNormal;
}-*/;



public final native ShaderMaterial getMaterialOcean()/*-{
return this.materialOcean;
}-*/;

public final native void setMaterialOcean(ShaderMaterial materialOcean)/*-{
this.materialOcean = materialOcean;
}-*/;

public final native void setOverrideMaterial(ShaderMaterial overrideMaterial)/*-{
this.overrideMaterial = overrideMaterial;
}-*/;

public final native Mesh getScreenQuad()/*-{
return this.screenQuad;
}-*/;

public final native void setScreenQuad(Mesh screenQuad)/*-{
this.screenQuad = screenQuad;
}-*/;

public final native void generateMesh()/*-{
this.generateMesh();
}-*/;

public final native void render()/*-{
this.render();
}-*/;

public final native void generateSeedPhaseTexture()/*-{
this.generateSeedPhaseTexture();
}-*/;

public final native void renderInitialSpectrum()/*-{
this.renderInitialSpectrum();
}-*/;

public final native void renderWavePhase()/*-{
this.renderWavePhase();
}-*/;

public final native void renderSpectrum()/*-{
this.renderSpectrum();
}-*/;

public final native void renderSpectrumFFT()/*-{
this.renderSpectrumFFT();
}-*/;

public final native void renderNormalMap()/*-{
this.renderNormalMap();
}-*/;


}
