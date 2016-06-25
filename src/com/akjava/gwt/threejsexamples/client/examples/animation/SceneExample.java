package com.akjava.gwt.threejsexamples.client.examples.animation;

import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.loader.ObjectHasAnimations;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.extras.geometries.PlaneBufferGeometry;
import com.akjava.gwt.three.client.js.loaders.ObjectLoader;
import com.akjava.gwt.three.client.js.loaders.ObjectLoader.ObjectLoadHandler;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.math.THREEMath;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class SceneExample extends AbstractExample{

	@Override
	public String getName() {
		return "animation/scene";
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

	int WIDTH;
	int HEIGHT;

	double FLOOR;
	
	double windowHalfX,windowHalfY;
	
	double mouseX=0;
	double mouseY=0;
	
	Clock clock;
	
	AnimationMixer mixer;
	AnimationClip sceneAnimationClip;
	
	@Override
	public void init() {
	
		//global
		FLOOR= -250;//var FLOOR = -250;

		windowHalfX = getWindowInnerWidth() / 2;//var windowHalfX = window.innerWidth / 2;
		windowHalfY = getWindowInnerHeight() / 2;//var windowHalfY = window.innerHeight / 2;

		clock = THREE.Clock();//var clock = new THREE.Clock();
		
		
		 WIDTH = (int)getWindowInnerWidth();
		 HEIGHT = (int)getWindowInnerHeight();

		FocusPanel container = createContainerPanel();
		
		
		
		// scene
		scene = THREE.Scene();
		scene.setFog(THREE.Fog( 0xffffff, 2000, 10000 ));
				
		
		// renderer
		
		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(true) );//renderer = new THREE.WebGLRenderer( { antialias: true } );
		renderer.setClearColor( scene.getFog().getColor());//renderer.setClearColor( scene.fog.color );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );//renderer.setPixelRatio( window.devicePixelRatio );
		renderer.setSize( WIDTH, HEIGHT );
		
		renderer.setGammaInput(true);//renderer.gammaInput = true;
		renderer.setGammaOutput(true);//renderer.gammaOutput = true;

		renderer.getShadowMap().setEnabled(true);//renderer.shadowMap.enabled = true;
		
		container.getElement().appendChild( renderer.getDomElement() );

		
		// camera
		camera = THREE.PerspectiveCamera(55, getWindowInnerWidth()/getWindowInnerHeight(), 1, 10000 );
		camera.getPosition().set(0, 0, 150);
		
		PlaneBufferGeometry geometry = THREE.PlaneBufferGeometry( 16000, 16000 );//var geometry = new THREE.PlaneBufferGeometry( 16000, 16000 );
		MeshPhongMaterial material = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().emissive(0x000000) );//var material = new THREE.MeshPhongMaterial( { emissive: 0x000000 } );

		Mesh ground = THREE.Mesh( geometry, material );//var ground = new THREE.Mesh( geometry, material );
		ground.getPosition().set( 0, FLOOR, 0 );//ground.position.set( 0, FLOOR, 0 );
		ground.getRotation().setX(-Math.PI/2);//ground.rotation.x = -Math.PI/2;
		/*scene.add( ground );*/

		ground.setReceiveShadow(true);//ground.receiveShadow = true;
		
		

		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - scene animation</a>"
				,100,10));
		
		container.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				onDocumentMouseMove(event);
			}
		});
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		
		ObjectLoader loader = THREE.ObjectLoader();//var loader = new THREE.ObjectLoader();
		
		loader.load( "models/json/scene-animation.json",new ObjectLoadHandler() {
			
			
			
			@Override
			public void onLoad(Object3D object) {
				ObjectHasAnimations hasAnimation=object.cast();
				sceneAnimationClip = hasAnimation.getAnimations().get(0);
				scene = object.cast();
				scene.add( camera );
				scene.setFog(THREE.Fog( 0xffffff, 2000, 10000 ));//scene.fog = new THREE.Fog( 0xffffff, 2000, 10000 );

				mixer = THREE.AnimationMixer( scene );//mixer = new THREE.AnimationMixer( scene );

				mixer.clipAction( sceneAnimationClip ).play();//mixer.addAction( new THREE.AnimationAction( sceneAnimationClip ) );

			}
			
			
		} );
	}
	

	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
	}
	

	
	protected void onDocumentMouseMove(MouseMoveEvent event) {
		mouseX = ( event.getClientX() - windowHalfX );
		mouseY = ( event.getClientY() - windowHalfY );
	}


	
	
	public void onWindowResize() {
		windowHalfX = getWindowInnerWidth() / 2;
		windowHalfY = getWindowInnerHeight() / 2;
		
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
		
	}
	
	public void render(double now) {
		double delta = 0.75 * clock.getDelta();

		camera.getPosition().gwtIncrementX( ( mouseX - camera.getPosition().getX()) * .05);//camera.position.x += ( mouseX - camera.position.x ) * .05;
		camera.getPosition().setY(THREEMath.clamp( camera.getPosition().getY() + ( - mouseY - camera.getPosition().getY()) * .05, 0, 1000 ));//camera.position.y = THREE.Math.clamp( camera.position.y + ( - mouseY - camera.position.y ) * .05, 0, 1000 );

		camera.lookAt( scene.getPosition());//camera.lookAt( scene.position );

		if( mixer!=null ) {
		//console.log( "updating mixer by " + delta );
		mixer.update( delta );
		}

		renderer.render( scene, camera );
	}

	@Override
	public String getTokenKey() {
		return "scene";
	}
}
