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
import com.akjava.gwt.three.client.js.cameras.OrthographicCamera;
import com.akjava.gwt.three.client.js.materials.ShaderMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JavaScriptObject;


public class ShaderPass extends JavaScriptObject{
	protected ShaderPass() {
	}

public final native Object getTextureID()/*-{
return this.textureID;
}-*/;

public final native void setTextureID(Object textureID)/*-{
this.textureID = textureID;
}-*/;


public final native Uniforms getUniforms()/*-{
return this.uniforms;
}-*/;

public final native void setUniforms(Uniforms uniforms)/*-{
this.uniforms = uniforms;
}-*/;


public final native ShaderMaterial getMaterial()/*-{
return this.material;
}-*/;

public final native void setMaterial(ShaderMaterial material)/*-{
this.material = material;
}-*/;


public final native boolean isRenderToScreen()/*-{
return this.renderToScreen;
}-*/;

public final native void setRenderToScreen(boolean renderToScreen)/*-{
this.renderToScreen = renderToScreen;
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

public final native void render(Object renderer,Object writeBuffer,Object readBuffer,Object delta)/*-{
this.render(renderer,writeBuffer,readBuffer,delta);
}-*/;


}
