package com.akjava.gwt.three.client.java;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import com.akjava.gwt.lib.client.CanvasUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.textures.CubeTexture;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.ImageElement;

public class SkyboxUtils {
	private SkyboxUtils(){}
	
	/*
	 right,left,up,down,front,back
	 
	 size must be power-of 2
	 */
	public static CubeTexture createCubeTexture(List<ImageElement> images,int size){
		CubeTexture texture=THREE.CubeTexture();
		texture.setFormat(THREE.RGBFormat);//cubeMap.format = THREE.RGBFormat;
		texture.setFlipY(false);
		
		setCubeTexture(texture, images,size);
		
		return texture;
	}
	public static void setCubeTexture(CubeTexture texture,List<ImageElement> images,int size){
		checkNotNull(images);
		checkArgument(images.size()==6, "need 6 images");
		
		
		
		
		texture.getImages().set(0, paintToCanvas(images.get(0),size));
		texture.getImages().set(1, paintToCanvas(images.get(1),size));
		texture.getImages().set(2, paintToCanvas(images.get(2),size));
		texture.getImages().set(3, paintToCanvas(images.get(3),size));
		texture.getImages().set(4, paintToCanvas(images.get(4),size));
		texture.getImages().set(5, paintToCanvas(images.get(5),size));
		texture.setNeedsUpdate(true);
	
	}
	
	public static ImageElement paintToCanvas(ImageElement element,int size){
		Canvas canvas=CanvasUtils.createCanvas(size, size);
		canvas.getContext2d().drawImage(element, 0, 0,size,size);
		
		return canvas.getCanvasElement().cast();
		
	}
}
