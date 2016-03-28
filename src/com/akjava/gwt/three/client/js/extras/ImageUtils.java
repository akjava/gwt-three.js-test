package com.akjava.gwt.three.client.js.extras;

import com.akjava.gwt.three.client.js.textures.CompressedTexture;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

/**
 * @deprecated gone on r74
 * @author aki
 *
 */
public class ImageUtils extends JavaScriptObject{
protected ImageUtils(){}

public static final native Texture loadTexture(String url,int mapping,ImageUtilsLoadHandler handler)/*-{
if(handler){
return $wnd.THREE.ImageUtils.loadTexture(url,mapping,function ( texture ) {
		handler.@com.akjava.gwt.three.client.js.extras.ImageUtils$ImageUtilsLoadHandler::onLoad(Lcom/google/gwt/core/client/JavaScriptObject;)(texture);
		},function ( onError ) {
		handler.@com.akjava.gwt.three.client.js.extras.ImageUtils$ImageUtilsLoadHandler::onError(Lcom/google/gwt/dom/client/NativeEvent;)(onError);
		});
}else{
	return $wnd.THREE.ImageUtils.loadTexture(url,mapping);
}
}-*/;

public static final native CompressedTexture loadCompressedTexture(String url,int mapping,ImageUtilsLoadHandler handler)/*-{
if(handler){
	return $wnd.THREE.ImageUtils.loadCompressedTexture(url,mapping,function ( texture ) {
		handler.@com.akjava.gwt.three.client.js.extras.ImageUtils$ImageUtilsLoadHandler::onLoad(Lcom/google/gwt/core/client/JavaScriptObject;)(texture);
		},onError);
}else{
	return $wnd.THREE.ImageUtils.loadCompressedTexture(url,mapping);
}
}-*/;


public static final native Texture loadTextureCube(JsArrayString array)/*-{
return $wnd.THREE.ImageUtils.loadTextureCube(array);
}-*/;



public static final native Texture loadTextureCube(JsArrayString array,int mapping,ImageUtilsLoadHandler handler)/*-{
if(handler){
return $wnd.THREE.ImageUtils.loadTextureCube(array,mapping,function ( texture ) {
		handler.@com.akjava.gwt.three.client.js.extras.ImageUtils$ImageUtilsLoadHandler::onLoad(Lcom/google/gwt/core/client/JavaScriptObject;)(texture);
		},onError);
}else{
	return $wnd.THREE.ImageUtils.loadTextureCube(array,mapping);
}
}-*/;
	

public static final native CompressedTexture loadCompressedTextureCube(JsArrayString array,int mapping,ImageUtilsLoadHandler handler)/*-{
if(handler){
$wnd.THREE.ImageUtils.loadCompressedTextureCube(array,mapping,function ( texture ) {
		handler.@com.akjava.gwt.three.client.js.extras.ImageUtils$ImageUtilsLoadHandler::onLoad(Lcom/google/gwt/core/client/JavaScriptObject;)(texture);
		},onError);
}else{
	$wnd.THREE.ImageUtils.loadCompressedTextureCube(array,mapping);
}
}-*/;

public static final native CompressedTexture loadCompressedTextureCube(String url,JavaScriptObject mapping,ImageUtilsLoadHandler handler)/*-{
if(handler){
$wnd.THREE.ImageUtils.loadCompressedTextureCube(url,mapping,function ( texture ) {
		handler.@com.akjava.gwt.three.client.js.extras.ImageUtils$ImageUtilsLoadHandler::onLoad(Lcom/google/gwt/core/client/JavaScriptObject;)(texture);
		},onError);
}else{
	$wnd.THREE.ImageUtils.loadCompressedTextureCube(url,mapping);
}
}-*/;


/**
 * @deprecated
 */
public static final native CompressedTexture loadDDSTexture(String url,JavaScriptObject mapping,ImageUtilsLoadHandler handler)/*-{
	if(handler){
$wnd.THREE.ImageUtils.loadDDSTexture(url,mapping,function ( texture ) {
		handler.@com.akjava.gwt.three.client.js.extras.ImageUtils$ImageUtilsLoadHandler::onLoad(Lcom/google/gwt/core/client/JavaScriptObject;)(texture);
		},onError);
}else{
	$wnd.THREE.ImageUtils.loadDDSTexture(url,mapping);
}
}-*/;

/**
 * i have no idea
 * @param buffer
 * @param loadMipmaps
 * @return
 */
public static final native JavaScriptObject parseDDS(JavaScriptObject buffer,boolean loadMipmaps)/*-{
return $wnd.THREE.ImageUtils.parseDDS(buffer,loadMipmaps);
}-*/;

/**
 * i'm not sure
 * @param image
 * @param depth
 * @return
 */


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
