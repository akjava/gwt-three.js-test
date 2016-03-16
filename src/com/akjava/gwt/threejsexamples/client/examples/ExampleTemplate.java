package com.akjava.gwt.threejsexamples.client.examples;

import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class ExampleTemplate extends AbstractExample{

	@Override
	public String getName() {
		return "test";
	}

	@Override
	public void animate(double timestamp) {

		render(timestamp);
		stats.update();//really deprecate?many still use this
	}

	private WebGLRenderer renderer;
	private Scene scene;
	private PerspectiveCamera camera;
	private Stats stats;

	int SCREEN_WIDTH;
	int SCREEN_HEIGHT;

	
	private int windowHalfX,windowHalfY;
	//private int mouseX,mouseY;

	Clock clock;
	@Override
	public void init() {
	
		clock=THREE.Clock();
		
		 SCREEN_WIDTH = (int)getWindowInnerWidth();
		 SCREEN_HEIGHT = (int)getWindowInnerHeight();
		 
		 windowHalfX=(int) (getWindowInnerWidth()/2);
		 windowHalfY=(int) (getWindowInnerHeight()/2);

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer();
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );

		// scene
		scene = THREE.Scene();
	
		// camera
		camera = THREE.PerspectiveCamera(55, getWindowInnerWidth()/getWindowInnerHeight(), 0.5, 300000);
		camera.getPosition().set(0, 0, 400);
		

		
		
		

		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - test</div>"
				,100,10));
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		
	}
	

	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
	}
	

	



	
	
	public void onWindowResize() {
		SCREEN_WIDTH = (int)getWindowInnerWidth();
		SCREEN_HEIGHT = (int)getWindowInnerHeight();
	
		//re read because of double
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( SCREEN_WIDTH , SCREEN_HEIGHT );
	
		 windowHalfX=(int) (getWindowInnerWidth()/2);
		 windowHalfY=(int) (getWindowInnerHeight()/2);
	}
	
	public void render(double now) {
		double delta=clock.getDelta();
		//do something
		
		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "test";
	}
}
