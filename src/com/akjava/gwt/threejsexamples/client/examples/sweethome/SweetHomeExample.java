package com.akjava.gwt.threejsexamples.client.examples.sweethome;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.controls.FirstPersonControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.ThreeLog;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.extras.geometries.PlaneBufferGeometry;
import com.akjava.gwt.three.client.js.extras.helpers.PointLightHelper;
import com.akjava.gwt.three.client.js.lights.AmbientLight;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.lights.PointLight;
import com.akjava.gwt.three.client.js.loaders.ObjectLoader;
import com.akjava.gwt.three.client.js.loaders.ObjectLoader.ObjectLoadHandler;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class SweetHomeExample extends AbstractExample{

	@Override
	public String getName() {
		return "SweetHome/loadjson";
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
	private FirstPersonControls controls;
	
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
		
		
		
		
				
		
		// renderer
		
		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(true) );//renderer = new THREE.WebGLRenderer( { antialias: true } );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );//renderer.setPixelRatio( window.devicePixelRatio );
		renderer.setSize( WIDTH, HEIGHT );
		
		renderer.setGammaInput(true);//renderer.gammaInput = true;
		renderer.setGammaOutput(true);//renderer.gammaOutput = true;

		renderer.getShadowMap().setEnabled(true);//renderer.shadowMap.enabled = true;
		
		container.getElement().appendChild( renderer.getDomElement() );

		
		// camera
		camera = THREE.PerspectiveCamera(70, getWindowInnerWidth()/getWindowInnerHeight(), 1, 10000 );
		camera.getPosition().set( -226, 100, -340 );
		
		
		controls = THREEExp.FirstPersonControls( camera, renderer.getDomElement());
		controls.setMovementSpeed(100);//controls.movementSpeed = 70;
		controls.setLookSpeed(0.1);//small is slow
		controls.setLookVertical(false);
		
		
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
		
		
		
		
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		
	/*	JSONLoader loader = THREE.JSONLoader();//var loader = new THREE.ObjectLoader();
		
		loader.load( "untitled.json",new JSONLoadHandler() {
			
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				// TODO Auto-generated method stub
				LogUtils.log("material");
				LogUtils.log(materials);
				Mesh mesh=THREE.Mesh(geometry,THREE.MeshBasicMaterial());
				scene.add(mesh);
				
			}
		});*/
		
	ObjectLoader loader = THREE.ObjectLoader();//var loader = new THREE.ObjectLoader();
		
		loader.load( "sweethome/userguideexample.json",new ObjectLoadHandler() {
			
			
			
			@Override
			public void onLoad(Object3D object) {
				scene = object.cast();
				
				
				AmbientLight ambientLight=THREE.AmbientLight(0x333333);
				scene.add(ambientLight);
				
				DirectionalLight dlight=THREE.DirectionalLight(0x222222);
				dlight.getPosition().set(-1, 1, 1).normalize();
				
				JsArray<Object3D> objects=scene.getChildren();
				for(int i=0;i<objects.length();i++){
					Object3D obj=objects.get(i);
					if(obj.getName().endsWith("628") || obj.getName().endsWith("634") || obj.getName().endsWith("622")|| obj.getName().endsWith("640")){
						Mesh mesh=obj.cast();
						addLight(mesh);
						//mesh.setVisible(false);
					}
				}
				
				LogUtils.log("scene loaded");
				
			}
			
			
		} );
	}
	
	private void addLight(Mesh mesh){
		mesh.getGeometry().computeBoundingSphere();
		Vector3 pos=mesh.getGeometry().getBoundingSphere().getCenter().clone();
		
		pos.applyEuler(mesh.getRotation());
		
		PointLight pointLight = THREE.PointLight( 0x333333 );//var directionalLight = new THREE.DirectionalLight( 0x444444 );
		pointLight.setDistance(0);
		pointLight.setIntensity(1);
		pointLight.setDecay(0.9);
		pointLight.getPosition().copy(pos);
		scene.add( pointLight );
		
		PointLightHelper pheloper=THREE.PointLightHelper(pointLight, 5);
		scene.add(pheloper);
		
	}
	

	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
	}
	

	

	
	
	public void onWindowResize() {
		windowHalfX = getWindowInnerWidth() / 2;
		windowHalfY = getWindowInnerHeight() / 2;
		
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );

		controls.handleResize();
	}
	
	public void render(double now) {
		if(scene==null){
			return;
		}
		double delta=clock.getDelta();
	//ThreeLog.log(camera.getPosition());
		controls.update( delta );
		
		renderer.render( scene, camera );
	}

	@Override
	public String getTokenKey() {
		return "sweethome_json";
	}
}
