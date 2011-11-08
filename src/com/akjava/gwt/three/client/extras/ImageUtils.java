package com.akjava.gwt.three.client.extras;

import com.akjava.gwt.three.client.textures.Texture;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

public class ImageUtils {
	public static  final Texture loadTexture(String url){
		return loadTexture(url,-1);
	}
	
	public static  final Texture loadTexture(ImageResource resources){
		Image img=new Image(resources);
		return loadTexture(img.getUrl(),-1);
	}
	
	public static native final Texture loadTexture(String url,int id)/*-{
	var mapping;
	if(id==0){
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
}
