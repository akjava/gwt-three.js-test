package com.akjava.gwt.threedemos.client;

import com.akjava.gwt.three.client.gwt.materials.MeshLambertMaterialParameter;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.user.client.ui.FocusPanel;

/**
 * simple three.js test
 * @author aki
 *
 */
public class CubeDemo extends AbstractDemo {

	private WebGLRenderer renderer;
	private Scene scene;
	private Camera camera;

	@Override
	public String getName() {
		return "CubeDemo";
	}

	@Override
	public void animate(double timestamp) {
		renderer.render(scene, camera);
	}

	@Override
	public void init() {
		//setup panels
		//need focusPanel to get events
		FocusPanel focusPanel = new FocusPanel();
		getParent().add(focusPanel);
		
		/*
		 * no need make dummy html panel?
		HTMLPanel div=new HTMLPanel(""); 
		div.getElement().appendChild(renderer.getDomElement());
		focusPanel.add(div);
		*/
		
		int width=getParent().getOffsetWidth();
		int height=getParent().getOffsetHeight();
		
		
		//setup renderer
		renderer = THREE.WebGLRenderer();
		
		focusPanel.getElement().appendChild(renderer.getDomElement());
		
		renderer.setSize(width, height);
		renderer.setClearColor(0xffffff, 1);
		
		
		
		
		scene = THREE.Scene();
		camera = THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		scene.add(camera);
		
		camera.getPosition().setZ(20);
		
		
		final Mesh mesh=THREE.Mesh(THREE.BoxGeometry(5, 5, 5), 
				THREE.MeshLambertMaterial(MeshLambertMaterialParameter.create().color(0xff0000)));
		scene.add(mesh);
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		scene.add(light);
		
	}

	@Override
	public void onWindowResize() {
		// TODO Auto-generated method stub
		
	}

}
