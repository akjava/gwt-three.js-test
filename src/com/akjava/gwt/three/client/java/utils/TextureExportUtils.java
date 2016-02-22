package com.akjava.gwt.three.client.java.utils;

import com.akjava.gwt.three.client.gwt.renderers.WebGLContext;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderTarget;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.CanvasElement;

public class TextureExportUtils {

	public static final  String toDataUrl(WebGLRenderer renderer,WebGLRenderTarget renderTarget,Canvas canvas){
		int w= renderTarget.getWidth();
		int h= renderTarget.getHeight();
		CanvasElement element=canvas!=null?canvas.getCanvasElement():null;
		
		return toDataUrl(renderer.getContext(), renderTarget.getWebglTexture(),w,h, element);
	}
			
	public static final native String toDataUrl(WebGLContext gl, JavaScriptObject texture, int width, int height,CanvasElement c)/*-{
	  // Create a framebuffer backed by the texture
				    var framebuffer = gl.createFramebuffer();
				    gl.bindFramebuffer(gl.FRAMEBUFFER, framebuffer);
				    gl.framebufferTexture2D(gl.FRAMEBUFFER, gl.COLOR_ATTACHMENT0, gl.TEXTURE_2D, texture, 0);

				    // Read the contents of the framebuffer
				    var data = new Uint8Array(width * height * 4);
				    gl.readPixels(0, 0, width, height, gl.RGBA, gl.UNSIGNED_BYTE, data);

				    gl.deleteFramebuffer(framebuffer);

				    // Create a 2D canvas to store the result 
				    var canvas;
				    if(c){
				 	canvas=c;
				    }else{	
				    canvas= document.createElement('canvas');
				    canvas.width = width;
				    canvas.height = height;
				    }
				    var context = canvas.getContext('2d');

				    // Copy the pixels to a 2D canvas
				    var imageData = context.createImageData(width, height);
				    imageData.data.set(data);
				    context.putImageData(imageData, 0, 0);

				    return canvas.toDataURL();
	}-*/;
}
