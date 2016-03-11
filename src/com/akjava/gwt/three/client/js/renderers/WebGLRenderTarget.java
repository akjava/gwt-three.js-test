package com.akjava.gwt.three.client.js.renderers;

import com.akjava.gwt.three.client.js.core.EventDispatcher;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;

public class WebGLRenderTarget extends EventDispatcher{

	protected WebGLRenderTarget(){}
	

public final native int getWidth()/*-{
return this.width;
}-*/;

public final native void setWidth(int width)/*-{
this.width = width;
}-*/;


public final native int getHeight()/*-{
return this.height;
}-*/;

public final native void setHeight(int height)/*-{
this.height = height;
}-*/;


public final native JavaScriptObject getOptions()/*-{
return this.options;
}-*/;

public final native void setOptions(JavaScriptObject options)/*-{
this.options = options;
}-*/;


public final native int getWrapS()/*-{
return this.wrapS;
}-*/;

public final native void setWrapS(int wrapS)/*-{
this.wrapS = wrapS;
}-*/;


public final native int getWrapT()/*-{
return this.wrapT;
}-*/;

public final native void setWrapT(int wrapT)/*-{
this.wrapT = wrapT;
}-*/;


public final native int getMagFilter()/*-{
return this.magFilter;
}-*/;

public final native void setMagFilter(int magFilter)/*-{
this.magFilter = magFilter;
}-*/;


public final native int getMinFilter()/*-{
return this.minFilter;
}-*/;

public final native void setMinFilter(int minFilter)/*-{
this.minFilter = minFilter;
}-*/;


public final native int getAnisotropy()/*-{
return this.anisotropy;
}-*/;

public final native void setAnisotropy(int anisotropy)/*-{
this.anisotropy = anisotropy;
}-*/;


public final native Vector2 getOffset()/*-{
return this.offset;
}-*/;

public final native void setOffset(Vector2 offset)/*-{
this.offset = offset;
}-*/;


public final native Vector2 getRepeat()/*-{
return this.repeat;
}-*/;

public final native void setRepeat(Vector2 repeat)/*-{
this.repeat = repeat;
}-*/;


public final native int getFormat()/*-{
return this.format;
}-*/;

public final native void setFormat(int format)/*-{
this.format = format;
}-*/;


public final native int getType()/*-{
return this.type;
}-*/;

public final native void setType(int type)/*-{
this.type = type;
}-*/;


public final native boolean isDepthBuffer()/*-{
return this.depthBuffer;
}-*/;

public final native void setDepthBuffer(boolean depthBuffer)/*-{
this.depthBuffer = depthBuffer;
}-*/;


public final native boolean isStencilBuffer()/*-{
return this.stencilBuffer;
}-*/;

public final native void setStencilBuffer(boolean stencilBuffer)/*-{
this.stencilBuffer = stencilBuffer;
}-*/;


public final native boolean isGenerateMipmaps()/*-{
return this.generateMipmaps;
}-*/;

public final native void setGenerateMipmaps(boolean generateMipmaps)/*-{
this.generateMipmaps = generateMipmaps;
}-*/;

/**
 * i have no idea
 * @return
 */
public final native JavaScriptObject getShareDepthFrom()/*-{
return this.shareDepthFrom;
}-*/;

public final native void setShareDepthFrom(JavaScriptObject shareDepthFrom)/*-{
this.shareDepthFrom = shareDepthFrom;
}-*/;



public final native void dispose()/*-{
this.dispose();
}-*/;

public final native JavaScriptObject getWebglTexture()/*-{
return this.__webglTexture;
}-*/;

public final native Texture gwtCastTexture()/*-{
return this;
}-*/;

}
