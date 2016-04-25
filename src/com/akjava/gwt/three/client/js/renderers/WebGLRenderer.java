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
package com.akjava.gwt.three.client.js.renderers;

import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.gwt.renderers.WebGLContext;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.math.Color;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.webgl.WebGLShadowMap;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.FocusWidget;

public class WebGLRenderer extends JavaScriptObject{

	protected WebGLRenderer(){}
	
	//**public properties
	public  native final Element getDomElement()/*-{
	return this.domElement;
	}-*/;
	
	
	//i have no idea
	public final native WebGLContext getContext()/*-{
	return this.context;
	}-*/;
	
	public final native double getDevicePixelRatio()/*-{
	return this.devicePixelRatio;
	}-*/;
	
	
	

public final native boolean isAutoClear()/*-{
return this.autoClear;
}-*/;

public final native void setAutoClear(boolean autoClear)/*-{
this.autoClear = autoClear;
}-*/;


public final native boolean isAutoClearColor()/*-{
return this.autoClearColor;
}-*/;

public final native void setAutoClearColor(boolean autoClearColor)/*-{
this.autoClearColor = autoClearColor;
}-*/;


public final native boolean isAutoClearDepth()/*-{
return this.autoClearDepth;
}-*/;

public final native void setAutoClearDepth(boolean autoClearDepth)/*-{
this.autoClearDepth = autoClearDepth;
}-*/;


public final native boolean isAutoClearStencil()/*-{
return this.autoClearStencil;
}-*/;

public final native void setAutoClearStencil(boolean autoClearStencil)/*-{
this.autoClearStencil = autoClearStencil;
}-*/;


//**scene graph
public final native boolean isSortObjects()/*-{
return this.sortObjects;
}-*/;

public final native void setSortObjects(boolean sortObjects)/*-{
this.sortObjects = sortObjects;
}-*/;

/**
 * @deprecated
 * 
 * removed on r68
 */
public final native boolean isAutoUpdateObjects()/*-{
return this.autoUpdateObjects;
}-*/;
/**
 * @deprecated
 * 
 * removed on r68
 */
public final native void setAutoUpdateObjects(boolean autoUpdateObjects)/*-{
this.autoUpdateObjects = autoUpdateObjects;
}-*/;

//**physically based shading
public final native boolean isGammaInput()/*-{
return this.gammaInput;
}-*/;

public final native void setGammaInput(boolean gammaInput)/*-{
this.gammaInput = gammaInput;
}-*/;


public final native boolean isGammaOutput()/*-{
return this.gammaOutput;
}-*/;

public final native void setGammaOutput(boolean gammaOutput)/*-{
this.gammaOutput = gammaOutput;
}-*/;



	

//**shadow map
//TODO implement WebGLShadowMap
public final native WebGLShadowMap getShadowMap()/*-{
return this.shadowMap;
}-*/;

/**
 * @deprecated
 * @moved to WebGLShadowMap
 * @return
 */
public final native boolean isShadowMapEnabled()/*-{
return this.shadowMapEnabled;
}-*/;
/**
 * @deprecated
 * @moved to WebGLShadowMap
 * @return
 */
public final native void setShadowMapEnabled(boolean shadowMapEnabled)/*-{
this.shadowMapEnabled = shadowMapEnabled;
}-*/;

/**
 * @deprecated
 * @moved to WebGLShadowMap
 * @return
 */
public final native boolean isShadowMapAutoUpdate()/*-{
return this.shadowMapAutoUpdate;
}-*/;
/**
 * @deprecated
 * @moved to WebGLShadowMap
 * @return
 */
public final native void setShadowMapAutoUpdate(boolean shadowMapAutoUpdate)/*-{
this.shadowMapAutoUpdate = shadowMapAutoUpdate;
}-*/;

/**
 * @deprecated
 * @moved to WebGLShadowMap
 * @return
 */
public final native int getShadowMapType()/*-{
return this.shadowMapType;
}-*/;
/**
 * @deprecated
 * @moved to WebGLShadowMap
 * @return
 */
public final native void setShadowMapType(int shadowMapType)/*-{
this.shadowMapType = shadowMapType;
}-*/;

/**
 * @deprecated
 * @moved to WebGLShadowMap
 * @return
 */
public final native int getShadowMapCullFace()/*-{
return this.shadowMapCullFace;
}-*/;
/**
 * @deprecated
 * @moved to WebGLShadowMap
 * @return
 */
public final native void setShadowMapCullFace(int shadowMapCullFace)/*-{
this.shadowMapCullFace = shadowMapCullFace;
}-*/;

/**
 * @deprecated
 * @moved to WebGLShadowMap
 * @return
 */
public final native boolean isShadowMapDebug()/*-{
return this.shadowMapDebug;
}-*/;
/**
 * @deprecated
 * @moved to WebGLShadowMap
 * @return
 */
public final native void setShadowMapDebug(boolean shadowMapDebug)/*-{
this.shadowMapDebug = shadowMapDebug;
}-*/;

/**
 * @deprecated
 * @moved to WebGLShadowMap
 * @return
 */
public final native boolean isShadowMapCascade()/*-{
return this.shadowMapCascade;
}-*/;

public final native void setShadowMapCascade(boolean shadowMapCascade)/*-{
this.shadowMapCascade = shadowMapCascade;
}-*/;


//**morphs
public final native double getMaxMorphTargets()/*-{
return this.maxMorphTargets;
}-*/;

public final native void setMaxMorphTargets(double maxMorphTargets)/*-{
this.maxMorphTargets = maxMorphTargets;
}-*/;


public final native double getMaxMorphNormals()/*-{
return this.maxMorphNormals;
}-*/;

public final native void setMaxMorphNormals(double maxMorphNormals)/*-{
this.maxMorphNormals = maxMorphNormals;
}-*/;
	
//**flags
public final native boolean isAutoScaleCubemaps()/*-{
return this.autoScaleCubemaps;
}-*/;

public final native void setAutoScaleCubemaps(boolean autoScaleCubemaps)/*-{
this.autoScaleCubemaps = autoScaleCubemaps;
}-*/;


public final native JsArray getRenderPluginsPre()/*-{
return this.renderPluginsPre;
}-*/;

public final native void setRenderPluginsPre(JsArray renderPluginsPre)/*-{
this.renderPluginsPre = renderPluginsPre;
}-*/;


public final native JsArray getRenderPluginsPost()/*-{
return this.renderPluginsPost;
}-*/;

public final native void setRenderPluginsPost(JsArray renderPluginsPost)/*-{
this.renderPluginsPost = renderPluginsPost;
}-*/;

//TODO implement it
public final native JavaScriptObject getInfo()/*-{
return this.info;
}-*/;

//APIS


public final native boolean supportsVertexTextures()/*-{
return this.supportsVertexTextures;
}-*/;

public final native boolean supportsFloatTextures()/*-{
return this.supportsFloatTextures;
}-*/;

public final native boolean supportsStandardDerivatives()/*-{
return this.supportsStandardDerivatives;
}-*/;


public final native boolean sSupportsCompressedTextureS3TC()/*-{
return this.supportsCompressedTextureS3TC;
}-*/;

public final native double getGetMaxAnisotropy()/*-{
return this.getMaxAnisotropy;
}-*/;

public final native String getPrecision()/*-{
return this.getPrecision;
}-*/;
	
	public native final void setSize(double w,double h)/*-{
	this.setSize(w,h);
	}-*/;
	public native final void setSize(double w,double h,boolean updateStyle)/*-{
	this.setSize(w,h,updateStyle);
	}-*/;
	
	

public final native void setViewport(double x,double y,double width,double height)/*-{
this.setViewport(x,y,width,height);
}-*/;

public final native void setScissor(double x,double y,double width,double height)/*-{
this.setScissor(x,y,width,height);
}-*/;

public final native void enableScissorTest(boolean enable)/*-{
this.enableScissorTest(enable);
}-*/;



public final native void setClearColor(int color)/*-{
this.setClearColor(color);
}-*/;

public final native void setClearColor(String color)/*-{
this.setClearColor(color);
}-*/;

public final native void setClearColor(Color color)/*-{
this.setClearColor(color);
}-*/;
public final native void setClearColor(int color,double alpha)/*-{
this.setClearColor(color,alpha);
}-*/;

public final native void setClearColor(String color,double alpha)/*-{
this.setClearColor(color,alpha);
}-*/;

public final native void setClearColor(Color color,double alpha)/*-{
this.setClearColor(color,alpha);
}-*/;
/**
 * @deprecated
 * @param hex
 * @param alpha
 */
public final native void setClearColorHex(String hex,double alpha)/*-{
this.setClearColorHex(hex,alpha);
}-*/;

public final native Color getClearColor()/*-{
return this.getClearColor();
}-*/;

public final native double getClearAlpha()/*-{
return this.getClearAlpha();
}-*/;

//maybe
public final native void clear(int color,int depth,int stencil)/*-{
this.clear(color,depth,stencil);
}-*/;

public final native void clearColor()/*-{
this.clearColor();
}-*/;
public final native void clearDepth()/*-{
this.clearDepth();
}-*/;
public final native void clearStencil()/*-{
this.clearStencil();
}-*/;


//i have no idea
public final native void clearTarget(WebGLRenderTarget renderTarget,int color,int depth,int stencil)/*-{
this.clearTarget(renderTarget,color,depth,stencil);
}-*/;
//i have no idea
public final native void addPostPlugin(JavaScriptObject plugin)/*-{
this.addPostPlugin(plugin);
}-*/;
//i have no idea
public final native void addPrePlugin(JavaScriptObject plugin)/*-{
this.addPrePlugin(plugin);
}-*/;

public final native void updateShadowMap(Scene scene,Camera camera)/*-{
return this.updateShadowMap(scene,camera);
}-*/;
	
	/*
	 * if flick background use Canvas setClearColor()
	 */
	public  native final void render(Scene scene,Camera camera)/*-{
	this.render(scene,camera);
	}-*/;
	
	public  native final void render(Scene scene,Camera camera,WebGLRenderTarget target,boolean forceUpdate)/*-{
	this.render(scene,camera,target,forceUpdate);
	}-*/;
	
	public  native final void clear()/*-{
	this.clear();
	}-*/;
	
	/**
	 * @deprecated
	 * @param color
	 * @param alpha
	 */
	public  native final void setClearColorHex(int color,double alpha)/*-{
	this.setClearColor(color,alpha);
	//this.setClearColorHex(color,alpha);
	}-*/;
	

	/**
	 * must be created
	 * new THREE.WebGLRenderer({preserveDrawingBuffer: true})
	 * option antialias: true, 
	 * @return
	 */
	public final native String gwtPngDataUrl ()/*-{
	return this.domElement.toDataURL("image/png");
	}-*/;
	
	public final native String gwtJpeggDataUrl ()/*-{
	return this.domElement.toDataURL("image/jpeg");
	}-*/;
	
	public final native CanvasElement gwtCanvas ()/*-{
	return this.domElement;
	}-*/;
	
	/**
	 * you should set this by yourself
	 * @param type
	 * @return
	 */
	public final native String gwtSetType (String type)/*-{
	this.gwtType=type;
}-*/;
	
	public final native String gwtGetType ()/*-{
		return this.gwtType;
	}-*/;
	
	
	/**
	 * this is just container.should rename it
	 * @author aki
	 *
	 */
	public static final class WebGLCanvas extends FocusWidget{
		private WebGLRenderer renderer;
		public WebGLRenderer getRenderer() {
			return renderer;
		}
		public WebGLCanvas(WebGLRenderer renderer){
		super(renderer.getDomElement());
		this.renderer=renderer;
		}
		public void setClearColor(int hex){
			//getElement().getStyle().setBackgroundColor("#"+Integer.toHexString(hex));
			renderer.setClearColor(hex, 1);
		}
		public void setClearColorHex(int hex){
			
			//getElement().getStyle().setBackgroundColor("#"+Integer.toHexString(hex));
			renderer.setClearColorHex(hex, 1);
		}
		
		/*
		 * just set this div's bg color
		 */
		public void setBackground(int hex){
			getElement().getStyle().setBackgroundColor("#"+Integer.toHexString(hex));
		}
		
	}
	//TODO create group class
	public final native JSParameter makeGroups(Geometry geometry,boolean usesFaceMaterial)/*-{
	return this.makeGroups(geometry,usesFaceMaterial);
	}-*/;
	
	public final native void uploadTexture (Texture texture)/*-{
	return this.uploadTexture(texture);
}-*/;
	
	public final native double getPixelRatio()/*-{
	return this.getPixelRatio();
	}-*/;
	
	public final native void setPixelRatio(double value)/*-{
	this.setPixelRatio(value);
	}-*/;
	
	public final native JavaScriptObject forceContextLoss()/*-{
	return this.forceContextLoss();
	}-*/;
	
	/**
	 * 
	 * @param geometryGroup,i have no idea,
	 * @param object maybe mesh has geometry
	 * @param hint maybe 
	 * @param dispose
	 * @param material
	 */
	public final native void setMeshBuffers(JavaScriptObject geometryGroup, Mesh object,int hint,boolean dispose,Material material)/*-{
	this.setMeshBuffers(geometryGroup, object, hint, dispose, material);
	}-*/;
	
	public final native void setGammaFactor(double gammaFactor)/*-{
	this.gammaFactor=gammaFactor;
	}-*/;
	
	public final native double getGammaFactor()/*-{
	return this.gammaFactor;
	}-*/;
	
	public final native void readRenderTargetPixels(WebGLRenderTarget target,int x,int y,int width,int height,JavaScriptObject buffer)/*-{
	return this.readRenderTargetPixels(target,x,y,width,height,buffer);
	}-*/;
	
	/**
	 * width:
	 * height:
	 * @return
	 */
	public final native JSParameter getSize()/*-{
	return this.getSize();
	}-*/;
	
	/**
	 * TODO implements extensions
	 * @return
	 */
	public final native JavaScriptObject getExtensions()/*-{
	return this.extensions;
	}-*/;
	
	public final native JavaScriptObject getContextAttributes()/*-{
	return this.getContextAttributes();
	}-*/;
	
	public final native void dispose()/*-{
	 this.dispose();
	}-*/;
}
