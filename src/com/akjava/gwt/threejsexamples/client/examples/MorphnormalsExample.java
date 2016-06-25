package com.akjava.gwt.threejsexamples.client.examples;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.math.THREEMath;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class MorphnormalsExample extends AbstractExample{

	@Override
	public String getName() {
		return "morphnormals";
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

	
	private Vector3 cameraTarget;

	JsArray<AnimationMixer> mixers;
	Clock clock;
	
	@Override
	public void init() {
		mixers=JavaScriptObject.createArray().cast();
		
		clock=THREE.Clock();
		
	
		 WIDTH = (int)getWindowInnerWidth();
		 HEIGHT = (int)getWindowInnerHeight();

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer();
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( WIDTH, HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );

		// scene
		scene = THREE.Scene();
	
		// camera
		camera = THREE.PerspectiveCamera(40,getWindowInnerWidth()/getWindowInnerHeight(), 1, 10000);
		camera.getPosition().set(0, 300,0);
		cameraTarget=THREE.Vector3( 0, 150, 0 );

		
		//light
		scene.add( THREE.HemisphereLight( 0x443333, 0x222233 ) );//scene.add( new THREE.HemisphereLight( 0x443333, 0x222233 ) );

		DirectionalLight light = THREE.DirectionalLight( 0xffffff, 1 );//var light = new THREE.DirectionalLight( 0xffffff, 1 );
		light.getPosition().set( 1, 1, 1 );//light.position.set( 1, 1, 1 );
		scene.add( light );
		

		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - webgl hemisphere light example - flamingo by mirada from rome</a><br>press h to toggle hemisphere light, d to toggle directional light"
				,100,10));
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		JSONLoader loader=THREE.JSONLoader();
		loader.load("models/animated/flamingo.js", new JSONLoadHandler() {
			
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				MeshPhongMaterial material = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff).specular(0xffffff).shininess(20).morphTargets(true).vertexColors(THREE.FaceColors).shading(THREE.FlatShading) );//var material = new THREE.MeshPhongMaterial( { color: 0xffffff, specular: 0xffffff, shininess: 20, morphTargets: true, vertexColors: THREE.FaceColors, shading: THREE.FlatShading } );
				Mesh mesh = THREE.Mesh( geometry, material );//var mesh = new THREE.Mesh( geometry, material );


				
				
				mesh.getPosition().setX(-150);//mesh.position.x = 150;
				mesh.getPosition().setY(150);//mesh.position.y = 150;
				mesh.getScale().set( 1.5, 1.5, 1.5 );//mesh.scale.set( 1.5, 1.5, 1.5 );
				
				
				scene.add( mesh );

				AnimationMixer mixer = THREE.AnimationMixer( mesh );//var mixer = new THREE.AnimationMixer( mesh );
				mixer.clipAction(  geometry.getAnimations().get(0) ).setDuration( 1 ).play() ;//mixer.addAction( new THREE.AnimationAction( geometry.animations[ 0 ] ).warpToDuration( 1 ) );
				mixers.push( mixer );
			}
		});
		
		loader.load("models/animated/flamingo.js", new JSONLoadHandler() {
			
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				MeshPhongMaterial material = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff).specular(0xffffff).shininess(20).morphTargets(true).morphNormals(true).vertexColors(THREE.FaceColors).shading(THREE.SmoothShading) );//var material = new THREE.MeshPhongMaterial( { color: 0xffffff, specular: 0xffffff, shininess: 20, morphTargets: true, vertexColors: THREE.FaceColors, shading: THREE.FlatShading } );
				Mesh mesh = THREE.Mesh( geometry, material );//var mesh = new THREE.Mesh( geometry, material );

				geometry.computeVertexNormals();
				geometry.computeMorphNormals();
				
				
				mesh.getPosition().setX(150);//mesh.position.x = 150;
				mesh.getPosition().setY(150);//mesh.position.y = 150;
				mesh.getScale().set( 1.5, 1.5, 1.5 );//mesh.scale.set( 1.5, 1.5, 1.5 );
				
				
				scene.add( mesh );

				AnimationMixer mixer = THREE.AnimationMixer( mesh );//var mixer = new THREE.AnimationMixer( mesh );
				mixer.clipAction(geometry.getAnimations().get(0) ).setDuration( 1 ).play();
				mixers.push( mixer );
			}
		});
		
	}
	

	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
	}
	

	



	
	
	public void onWindowResize() {
		
		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
		
		//0.5*
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		
		
	}
	
	double radius = 600;
	double theta = 0;
	
	public void render(double now) {
		theta += 0.1;

		camera.getPosition().setX(radius * Math.sin( THREEMath.degToRad( theta ) ));//camera.position.x = radius * Math.sin( THREE.Math.degToRad( theta ) );
		camera.getPosition().setZ(radius * Math.cos( THREEMath.degToRad( theta ) ));//camera.position.z = radius * Math.cos( THREE.Math.degToRad( theta ) );

		camera.lookAt( cameraTarget);//camera.lookAt( camera.target );

		double delta = clock.getDelta();

		for ( int i = 0; i < mixers.length(); i ++ ) {

		mixers.get(i).update( delta );

		}
		
		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "morphnormals";
	}
}
