package com.akjava.gwt.three.client.extras;

import com.akjava.gwt.three.client.math.Color;
import com.akjava.gwt.three.client.textures.CompressedTexture;
import com.akjava.gwt.three.client.textures.DataTexture;
import com.akjava.gwt.three.client.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

public class ImageUtils extends JavaScriptObject{
	

public static final native Texture loadTexture(String url,JavaScriptObject mapping,ImageUtilsLoadHandler handler)/*-{
if(handler){
return this.loadTexture(url,mapping,function ( texture ) {
		handler.@com.akjava.gwt.three.client.extras.ImageUtils$ImageUtilsLoadHandler::onLoad(Lcom/google/gwt/core/client/JavaScriptObject;)(texture);
		},function ( onError ) {
		handler.@com.akjava.gwt.three.client.extras.ImageUtils$ImageUtilsLoadHandler::onError(Lcom/google/gwt/dom/client/NativeEvent;)(onError);
		});
}else{
	return this.loadTexture(url,mapping);
}
}-*/;

public static final native CompressedTexture loadCompressedTexture(String url,JavaScriptObject mapping,ImageUtilsLoadHandler handler)/*-{
if(handler){
	return this.loadCompressedTexture(url,mapping,function ( texture ) {
		handler.@com.akjava.gwt.three.client.extras.ImageUtils$ImageUtilsLoadHandler::onLoad(Lcom/google/gwt/core/client/JavaScriptObject;)(texture);
		},onError);
}else{
	return this.loadCompressedTexture(url,mapping);
}
}-*/;


public static final native Texture loadTextureCube(JsArrayString array,JavaScriptObject mapping,ImageUtilsLoadHandler handler)/*-{
if(handler){
return this.loadTextureCube(array,mapping,function ( texture ) {
		handler.@com.akjava.gwt.three.client.extras.ImageUtils$ImageUtilsLoadHandler::onLoad(Lcom/google/gwt/core/client/JavaScriptObject;)(texture);
		},onError);
}else{
	return this.loadTextureCube(array,mapping);
}
}-*/;
	

public static final native CompressedTexture loadCompressedTextureCube(JsArrayString array,JavaScriptObject mapping,ImageUtilsLoadHandler handler)/*-{
if(handler){
this.loadCompressedTextureCube(array,mapping,function ( texture ) {
		handler.@com.akjava.gwt.three.client.extras.ImageUtils$ImageUtilsLoadHandler::onLoad(Lcom/google/gwt/core/client/JavaScriptObject;)(texture);
		},onError);
}else{
	this.loadCompressedTextureCube(array,mapping);
}
}-*/;

public static final native CompressedTexture loadCompressedTextureCube(String url,JavaScriptObject mapping,ImageUtilsLoadHandler handler)/*-{
if(handler){
this.loadCompressedTextureCube(url,mapping,function ( texture ) {
		handler.@com.akjava.gwt.three.client.extras.ImageUtils$ImageUtilsLoadHandler::onLoad(Lcom/google/gwt/core/client/JavaScriptObject;)(texture);
		},onError);
}else{
	this.loadCompressedTextureCube(url,mapping);
}
}-*/;


public static final native CompressedTexture loadDDSTexture(String url,JavaScriptObject mapping,ImageUtilsLoadHandler handler)/*-{
	if(handler){
this.loadDDSTexture(url,mapping,function ( texture ) {
		handler.@com.akjava.gwt.three.client.extras.ImageUtils$ImageUtilsLoadHandler::onLoad(Lcom/google/gwt/core/client/JavaScriptObject;)(texture);
		},onError);
}else{
	this.loadDDSTexture(url,mapping);
}
}-*/;

/**
 * i have no idea
 * @param buffer
 * @param loadMipmaps
 * @return
 */
public static final native JavaScriptObject parseDDS(JavaScriptObject buffer,boolean loadMipmaps)/*-{
return this.parseDDS(buffer,loadMipmaps);
}-*/;

/**
 * i'm not sure
 * @param image
 * @param depth
 * @return
 */
public static final native CanvasElement getNormalMap(ImageElement image,int depth)/*-{
return this.getNormalMap(image,depth);
}-*/;

public static final native DataTexture generateDataTexture(int width,int height,Color color)/*-{
return this.generateDataTexture(width,height,color);
}-*/;

	public static  final Texture loadTexture(String url){
		return loadTexture(url,-1);
	}
	
	
	//public static native final Texture loadTexture(String url)/*-{
	//return $wnd.THREE.ImageUtils.loadTexture(url);
	//}-*/;
	
	public static  final Texture loadTexture(ImageResource resources){
		Image img=new Image(resources);
		return loadTexture(img.getUrl(),-1);//why -1
	}
	
	public static native final Texture loadTexture(String url,int id)/*-{
	var mapping;
	if(id==0 ){
		mapping=$wnd.THREE.UVMapping;
	}
	else if(id==1){
		mapping=$wnd.THREE.LatitudeReflectionMapping;
	}else if(id==2){
		mapping=$wnd.THREE.CubeReflectionMapping;
	}else if(id==3){
		mapping=$wnd.THREE.SphericalReflectionMapping;
	}
		
	return $wnd.THREE.ImageUtils.loadTexture(url,mapping);
	}-*/;
	
	public static interface ImageUtilsLoadHandler {
		public void onLoad(JavaScriptObject object);
		public void onError(NativeEvent error);
	}
}
