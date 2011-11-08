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
package com.akjava.gwt.three.client.renderers;

import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.FocusWidget;

public class WebGLRenderer extends JavaScriptObject{

	protected WebGLRenderer(){}
	
	public native final void setSize(int w,int h)/*-{
	this.setSize(w,h);
	}-*/;
	
	public  native final Element getDomElement()/*-{
	return this.domElement;
	}-*/;
	
	public  native final void render(Scene scene,Camera camera)/*-{
	this.render(scene,camera);
	}-*/;
	
	public  native final void clear()/*-{
	this.clear();
	}-*/;
	
	public  native final void setClearColorHex(int color,double alpha)/*-{
	this.setClearColorHex(color,alpha);
	}-*/;
	
	public final native void setShadowMapEnabled (boolean bool)/*-{
	this.shadowMapEnabled =bool;
	}-*/;
	
	public static final class WebGLCanvas extends FocusWidget{
		private WebGLRenderer renderer;
		public WebGLRenderer getRenderer() {
			return renderer;
		}
		public WebGLCanvas(WebGLRenderer renderer){
		super(renderer.getDomElement());
		this.renderer=renderer;
		}
		
		public void setClearColorHex(int hex){
			
			getElement().getStyle().setBackgroundColor("#"+Integer.toHexString(hex));
			renderer.setClearColorHex(hex, 1);
		}
	}
}
