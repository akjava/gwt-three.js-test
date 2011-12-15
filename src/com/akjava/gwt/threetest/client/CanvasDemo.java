package com.akjava.gwt.threetest.client;

import java.util.HashMap;
import java.util.Map;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.extras.ImageUtils;
import com.akjava.gwt.three.client.gwt.MultiImageLoader;
import com.akjava.gwt.three.client.gwt.MultiImageLoader.LoadMonitor;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.akjava.gwt.three.client.textures.Texture;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

public class CanvasDemo extends AbstractDemo{
private Timer timer;
private Mesh mesh;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		if(timer!=null){
			timer.cancel();
			timer=null;
		}
		
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 20);
		
		
		
		final Scene scene=THREE.Scene();
		GWT.log("xx");
		
		final Canvas canvas=Canvas.createIfSupported();
		canvas.setSize("200px", "200px");
		canvas.setCoordinateSpaceWidth(200);
		canvas.setCoordinateSpaceHeight(200);
		
		
		//TODO csv
		Map<String,String> imageLists=new HashMap<String, String>();
		String value=Bundles.INSTANCE.face().getSafeUri().asString();
		log("url:"+value);
		imageLists.put("face", value);
		imageLists.put("eye", Bundles.INSTANCE.r_eye().getSafeUri().asString());
		MultiImageLoader multiImageLoader=new MultiImageLoader(imageLists,new LoadMonitor() {
			
			@Override
			public void loadComplete(Map<String, Image> geos) {
				//Window.alert("loaded");
				final Context2d context=canvas.getContext2d();
				context.setFillStyle("#ff0000");
				context.fillRect(0, 0, 50, 50);
				context.fillRect(50, 50, 50, 50);
				context.drawImage(ImageElement.as(geos.get("face").getElement()),0,0);
				context.drawImage(ImageElement.as(geos.get("eye").getElement()),60,80);

				context.translate(canvas.getCoordinateSpaceWidth(), 0);
				context.scale(-1, 1);
				
				context.drawImage(ImageElement.as(geos.get("eye").getElement()),30,80);
				//snap shot of image
				Image img=new Image(canvas.toDataUrl());
				RootPanel.get().add(img);
				
				mesh = THREE.Mesh(THREE.CubeGeometry(5, 5, 5), 
						THREE.MeshBasicMaterial().map(ImageUtils.loadTexture(canvas.toDataUrl())).build());
				scene.add(mesh);
			}
		});
		multiImageLoader.startLoad();
		
		
		
	
		
		
		
		
		Texture texture=ImageUtils.loadTexture(canvas.toDataUrl());
		Material material=THREE.MeshBasicMaterial().map(texture).build();
		
		Material material2=THREE.MeshBasicMaterial().color(0x00ff00).wireFrame(true).build();
		Material[] ms=new Material[]{
				material2,material,material,material,material,material
		};
		
		mesh = THREE.Mesh(THREE.Cube(5, 5, 5,1,1,1,ms), 
				THREE.MeshFaceMaterial());
		
		//scene.add(mesh);
		GWT.log("xx2");
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		scene.add(light);
		
		
		
		
		timer = new Timer(){
			public void run(){
				try{
				
				//cancel();
				mesh.getRotation().incrementX(0.02);
				mesh.getRotation().incrementY(0.02);
				renderer.render(scene, camera);
				}catch(Exception e){
					GWT.log(e.getMessage());
				}
			}
		};
		//timer.schedule(2000);
		timer.scheduleRepeating(1000/60);
	}

	@Override
	public void stop() {
		timer.cancel();
	}

	@Override
	public String getName() {
		return "Texture";
	}
}
