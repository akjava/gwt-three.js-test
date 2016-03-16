package com.akjava.gwt.threejsexamples.client.examples.shadowmap;

import java.util.List;

import com.akjava.gwt.lib.client.GWTUtils;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.controls.FirstPersonControls;
import com.akjava.gwt.three.client.examples.js.geometries.TextGeometry;
import com.akjava.gwt.three.client.examples.js.shaders.ExampleShaders;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.extras.Shader;
import com.akjava.gwt.three.client.gwt.extras.Uniforms;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.cameras.OrthographicCamera;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.geometries.PlaneBufferGeometry;
import com.akjava.gwt.three.client.js.lights.AmbientLight;
import com.akjava.gwt.three.client.js.lights.SpotLight;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.materials.MeshLambertMaterial;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.materials.ShaderMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.renderers.shaders.WebGLShaders.ShaderChunk.UniformsUtils;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.akjava.gwt.threejsexamples.client.Example;
import com.google.common.collect.Lists;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class ShadowmapExample extends AbstractExample{

	@Override
	public String getName() {
		return "shadowmap";
	}

	@Override
	public void animate(double timestamp) {

		render(timestamp);
		stats.update();//really deprecate?many still use this
	}

	//don't set value here,because of abstract class 
	private WebGLRenderer renderer;
	private Scene scene;
	private PerspectiveCamera camera;
	private Stats stats;

	int WIDTH;
	int HEIGHT;

	
	private int windowHalfX,windowHalfY;
	//private int mouseX,mouseY;

	Clock clock;
	
	private double NEAR,FAR;
	private FirstPersonControls controls;
	private SpotLight light;
	private int SHADOW_MAP_WIDTH,SHADOW_MAP_HEIGHT;
	private OrthographicCamera cameraOrtho;
	private Mesh hudMesh;
	private Scene sceneHUD;
	private double HUD_MARGIN;
	private double FLOOR;
	
	private List<MeshData> morphs;
	private boolean showHUD=false;//for test
	@Override
	public void init() {
		NEAR=10;
		FAR=3000;
		
		SHADOW_MAP_WIDTH=2048;
		SHADOW_MAP_HEIGHT=1024;
		
		HUD_MARGIN=0.05;
	
		FLOOR=-250;
		
		clock=THREE.Clock();
		
		 WIDTH = (int)getWindowInnerWidth();
		 HEIGHT = (int)getWindowInnerHeight();
		 
		 windowHalfX=(int) (getWindowInnerWidth()/2);
		 windowHalfY=(int) (getWindowInnerHeight()/2);
		 
		 morphs=Lists.newArrayList();
		 
		// scene
		scene = THREE.Scene();
		scene.setFog(THREE.Fog( 0x59472b, 1000, FAR ));//scene.fog = new THREE.Fog( 0x59472b, 1000, FAR );
		
		
		// renderer
		 FocusPanel container = createContainerPanel();
		
		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(true) );//renderer = new THREE.WebGLRenderer( { antialias: true } );
		renderer.setClearColor( scene.getFog().getColor());//renderer.setClearColor( scene.fog.color );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );//renderer.setPixelRatio( window.devicePixelRatio );
		renderer.setSize( WIDTH, HEIGHT );
		
		renderer.setAutoClear(false);//renderer.autoClear = false;
		
		container.getElement().appendChild( renderer.getDomElement() );

		renderer.getShadowMap().setEnabled(true);//renderer.shadowMap.enabled = true;
		renderer.getShadowMap().setType(THREE.PCFShadowMap);//renderer.shadowMap.type = THREE.PCFShadowMap;
		
		
		
		
		// camera
		camera = THREE.PerspectiveCamera(23, getWindowInnerWidth()/getWindowInnerHeight(), NEAR, FAR);
		camera.getPosition().set(700, 50, 1900);
		
		
		//controls
		controls = THREEExp.FirstPersonControls( camera);//controls = new THREE.FirstPersonControls( camera );
		
		controls.setLookSpeed(0.0125);//controls.lookSpeed = 0.0125;
		controls.setMovementSpeed(500);//controls.movementSpeed = 500;
		//controls.setNoFly(false);//controls.noFly = false;
		controls.setLookVertical(true);//controls.lookVertical = true;
		controls.setConstrainVertical(true);//controls.constrainVertical = true;
		controls.setVerticalMin(1.5);//controls.verticalMin = 1.5;
		controls.setVerticalMax(2.0);//controls.verticalMax = 2.0;

		controls.setLon(250);//controls.lon = 250;
		controls.setLat(30);//controls.lat = 30;
		
		//lights
		AmbientLight ambient = THREE.AmbientLight( 0x444444 );//var ambient = new THREE.AmbientLight( 0x444444 );
		scene.add( ambient );

		light = THREE.SpotLight( 0xffffff, 1, 0, Math.PI / 2, 1 );//light = new THREE.SpotLight( 0xffffff, 1, 0, Math.PI / 2, 1 );
		light.getPosition().set( 0, 1500, 1000 );//light.position.set( 0, 1500, 1000 );
		light.getTarget().getPosition().set( 0, 0, 0 );//light.target.position.set( 0, 0, 0 );

		light.setCastShadow(true);//light.castShadow = true;

		light.setShadowCameraNear(1200);//light.shadowCameraNear = 1200;
		light.setShadowCameraFar(2500);//light.shadowCameraFar = 2500;
		light.setShadowCameraFov(50);//light.shadowCameraFov = 50;

		//light.setShadowCameraVisible(true);////light.shadowCameraVisible = true;

		light.setShadowBias(0.0001);//light.shadowBias = 0.0001;

		light.setShadowMapWidth(SHADOW_MAP_WIDTH);//light.shadowMapWidth = SHADOW_MAP_WIDTH;
		light.setShadowMapHeight(SHADOW_MAP_HEIGHT);//light.shadowMapHeight = SHADOW_MAP_HEIGHT;

		scene.add( light );
		
		
		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - test</div> shadowmap - models by <a href=\"http://mirada.com/\">mirada</a> from <a href=\"http://ro.me\">rome</a></br>move camera with WASD / RF + mouse<br/>"
				,100,10));
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		createHUD();
		createScene();
		
		
		GWTUtils.addKeyDownHandlerToDocument(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				//LogUtils.log("key"+event.getNativeKeyCode());
				if(event.getNativeKeyCode() ==84){// t
					showHUD=!showHUD;
				}
			}
		});
		
	}
	

	
	private void createScene() {
		// GROUND

		PlaneBufferGeometry geometry = THREE.PlaneBufferGeometry( 100, 100 );//var geometry = new THREE.PlaneBufferGeometry( 100, 100 );
		MeshPhongMaterial planeMaterial = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffdd99) );//var planeMaterial = new THREE.MeshPhongMaterial( { color: 0xffdd99 } );

		Mesh ground = THREE.Mesh( geometry, planeMaterial );//var ground = new THREE.Mesh( geometry, planeMaterial );

		ground.getPosition().set( 0, FLOOR, 0 );//ground.position.set( 0, FLOOR, 0 );
		ground.getRotation().setX(- Math.PI / 2);//ground.rotation.x = - Math.PI / 2;
		ground.getScale().set( 100, 100, 100 );//ground.scale.set( 100, 100, 100 );

		ground.setCastShadow(false);//ground.castShadow = false;
		ground.setReceiveShadow(true);//ground.receiveShadow = true;

		scene.add( ground );
		
		// TEXT
		TextGeometry textGeo = THREEExp.TextGeometry( "THREE.JS", GWTParamUtils.TextGeometry().size(200).height(50).curveSegments(12).font("helvetiker").weight("bold").style("normal").bevelThickness(2).bevelSize(5).bevelEnabled(true));//var textGeo = new THREE.TextGeometry( "THREE.JS", {size: 200,height: 50,curveSegments: 12,font: "helvetiker",weight: "bold",style: "normal",bevelThickness: 2,bevelSize: 5,bevelEnabled: true});
	
		textGeo.computeBoundingBox();
		double centerOffset = -0.5 * ( textGeo.getBoundingBox().getMax().getX() - textGeo.getBoundingBox().getMin().getX());//var centerOffset = -0.5 * ( textGeo.boundingBox.max.x - textGeo.boundingBox.min.x );

		MeshPhongMaterial textMaterial = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xff0000).specular(0xffffff) );//var textMaterial = new THREE.MeshPhongMaterial( { color: 0xff0000, specular: 0xffffff } );

		Mesh mesh = THREE.Mesh( textGeo, textMaterial );//var mesh = new THREE.Mesh( textGeo, textMaterial );
		mesh.getPosition().setX(centerOffset);//mesh.position.x = centerOffset;
		mesh.getPosition().setY(FLOOR + 67);//mesh.position.y = FLOOR + 67;

		mesh.setCastShadow(true);//mesh.castShadow = true;
		mesh.setReceiveShadow(true);//mesh.receiveShadow = true;

		scene.add( mesh );
		
		// CUBE
		mesh = THREE.Mesh( THREE.BoxGeometry( 1500, 220, 150 ), planeMaterial );//var mesh = new THREE.Mesh( new THREE.BoxGeometry( 1500, 220, 150 ), planeMaterial );

		mesh.getPosition().setY(FLOOR - 50);//mesh.position.y = FLOOR - 50;
		mesh.getPosition().setZ(20);//mesh.position.z = 20;

		mesh.setCastShadow(true);//mesh.castShadow = true;
		mesh.setReceiveShadow(true);//mesh.receiveShadow = true;

		scene.add( mesh );

		mesh = THREE.Mesh( THREE.BoxGeometry( 1600, 170, 250 ), planeMaterial );//var mesh = new THREE.Mesh( new THREE.BoxGeometry( 1600, 170, 250 ), planeMaterial );

		mesh.getPosition().setY(FLOOR - 50);//mesh.position.y = FLOOR - 50;
		mesh.getPosition().setZ(20);//mesh.position.z = 20;

		mesh.setCastShadow(true);//mesh.castShadow = true;
		mesh.setReceiveShadow(true);//mesh.receiveShadow = true;

		scene.add( mesh );
		
		JSONLoader loader=THREE.JSONLoader();
		loader.load("models/animated/horse.js", new JSONLoadHandler() {
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				addMorph( geometry, 550, 1, 100 - Math.random() * 1000, FLOOR, 300, true );
				addMorph( geometry, 550, 1, 100 - Math.random() * 1000, FLOOR, 450, true );
				addMorph( geometry, 550, 1, 100 - Math.random() * 1000, FLOOR, 600, true );

				addMorph( geometry, 550, 1, 100 - Math.random() * 1000, FLOOR, -300, true );
				addMorph( geometry, 550, 1, 100 - Math.random() * 1000, FLOOR, -450, true );
				addMorph( geometry, 550, 1, 100 - Math.random() * 1000, FLOOR, -600, true );
			}
		});
		loader.load("models/animated/flamingo.js", new JSONLoadHandler() {
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				addMorph( geometry, 500, 1, 500 - Math.random() * 500, FLOOR + 350, 40 ,false);
			}
		});
		loader.load("models/animated/stork.js", new JSONLoadHandler() {
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				addMorph( geometry, 350, 1, 500 - Math.random() * 500, FLOOR + 350, 340,false );
			}
		});
		loader.load("models/animated/parrot.js", new JSONLoadHandler() {
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				addMorph( geometry, 450, 0.5, 500 - Math.random() * 500, FLOOR + 300, 700,false );
			}
		});
	}

	private void createHUD() {
		double aspect = (double)WIDTH / HEIGHT;
		
		//LogUtils.log(aspect);

		cameraOrtho = THREE.OrthographicCamera( - aspect, aspect,  1, - 1, 1, 10 );//cameraOrtho = new THREE.OrthographicCamera( - aspect, aspect,  1, - 1, 1, 10 );
		cameraOrtho.getPosition().setZ(5);//cameraOrtho.position.z = 5;

		Shader shader = ExampleShaders.UnpackDepthRGBAShader();
		Uniforms uniforms = UniformsUtils.clone( shader.uniforms());//var uniforms = new THREE.UniformsUtils.clone( shader.uniforms );

		//there are no shadowmap
		//uniforms.set("tDiffuse",light.getShadowMap());//uniforms.tDiffuse.value = light.shadowMap;

		ShaderMaterial hudMaterial = THREE.ShaderMaterial( GWTParamUtils.ShaderMaterial().uniforms(uniforms).vertexShader(shader.vertexShader()).fragmentShader(shader.fragmentShader()) );//ShaderMaterial hudMaterial = THREE.ShaderMaterial( {uniforms: uniforms,vertexShader: shader.vertexShader,fragmentShader: shader.fragmentShader} );

		double hudHeight = 2.0 / 3;//watch out original integer value make problem.

		double hudWidth = hudHeight * SHADOW_MAP_WIDTH / SHADOW_MAP_HEIGHT;

		PlaneBufferGeometry hudGeo = THREE.PlaneBufferGeometry( hudWidth, hudHeight );//var hudGeo = new THREE.PlaneBufferGeometry( hudWidth, hudHeight );
		hudGeo.translate( hudWidth / 2, hudHeight / 2, 0 );

		hudMesh = THREE.Mesh( hudGeo, hudMaterial );//hudMesh = new THREE.Mesh( hudGeo, hudMaterial );

		hudMesh.getPosition().setX(cameraOrtho.getLeft() + HUD_MARGIN);//hudMesh.position.x = cameraOrtho.left + HUD_MARGIN;
		hudMesh.getPosition().setY(cameraOrtho.getBottom() + HUD_MARGIN);//hudMesh.position.y = cameraOrtho.bottom + HUD_MARGIN;

		sceneHUD = THREE.Scene();//sceneHUD = new THREE.Scene();
		sceneHUD.add( hudMesh );

		cameraOrtho.lookAt( sceneHUD.getPosition());//cameraOrtho.lookAt( sceneHUD.position );
	}

	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
	}
	
	private class MeshData{
		private Mesh mesh;
		public MeshData(Mesh mesh, double speed, AnimationMixer mixer) {
			super();
			this.mesh = mesh;
			this.speed = speed;
			this.mixer = mixer;
		}
		public Mesh getMesh() {
			return mesh;
		}
		public double getSpeed() {
			return speed;
		}
		public AnimationMixer getMixer() {
			return mixer;
		}
		private double speed;
		private AnimationMixer mixer;
	}
	
	
	private void addMorph(Geometry geometry,double speed, double duration, double x,double y,double z,boolean fudgeColor ){
		MeshLambertMaterial material = THREE.MeshLambertMaterial( GWTParamUtils.MeshLambertMaterial().color(0xffaa55).morphTargets(true).vertexColors(THREE.FaceColors) );//var material = new THREE.MeshLambertMaterial( { color: 0xffaa55, morphTargets: true, vertexColors: THREE.FaceColors } );

		if ( fudgeColor ) {

		material.getColor().offsetHSL( 0, Math.random() * 0.5 - 0.25, Math.random() * 0.5 - 0.25 );//material.color.offsetHSL( 0, Math.random() * 0.5 - 0.25, Math.random() * 0.5 - 0.25 );

		}
		
		

		Mesh mesh = THREE.Mesh( geometry, material );//var mesh = new THREE.Mesh( geometry, material );
		//mesh.setSpeed(speed);//mesh.speed = speed;

		AnimationMixer mixer = THREE.AnimationMixer( mesh );//var mixer = new THREE.AnimationMixer( mesh );
		mixer.addAction( THREE.AnimationAction( geometry.getAnimations().get(0) ).warpToDuration( duration ) );//mixer.addAction( new THREE.AnimationAction( geometry.animations[0] ).warpToDuration( duration ) );
		mixer.update( 600 * Math.random() );
		//mesh.setMixer(mixer);//mesh.mixer = mixer;

		mesh.getPosition().set( x, y, z );//mesh.position.set( x, y, z );
		mesh.getRotation().setY(Math.PI/2);//mesh.rotation.y = Math.PI/2;

		mesh.setCastShadow(true);//mesh.castShadow = true;
		mesh.setReceiveShadow(true);//mesh.receiveShadow = true;

		scene.add( mesh );

		MeshData data=new MeshData(mesh, speed, mixer);
		morphs.add( data );
	}
	

	



	
	
	public void onWindowResize() {
		
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
	
		 windowHalfX=(int) (getWindowInnerWidth()/2);
		 windowHalfY=(int) (getWindowInnerHeight()/2);
		 
		 
		 double aspect = getWindowInnerWidth() / getWindowInnerHeight();
		 
		 cameraOrtho.setLeft(- aspect);//cameraOrtho.left = - aspect;
		 cameraOrtho.setRight(aspect);//cameraOrtho.right = aspect;
		 cameraOrtho.setTop(1);//cameraOrtho.top = 1;
		 cameraOrtho.setBottom(- 1);//cameraOrtho.bottom = - 1;
		 cameraOrtho.updateProjectionMatrix();

		 hudMesh.getPosition().setX(cameraOrtho.getLeft() + HUD_MARGIN);//hudMesh.position.x = cameraOrtho.left + HUD_MARGIN;
		 hudMesh.getPosition().setY(cameraOrtho.getBottom() + HUD_MARGIN);//hudMesh.position.y = cameraOrtho.bottom + HUD_MARGIN;

		 controls.handleResize();
	}
	
	public void render(double now) {
		double delta=clock.getDelta();
		//do something
		for ( int i = 0; i < morphs.size(); i ++ ) {

			Mesh morph = morphs.get(i).getMesh();

			morphs.get(i).getMixer().update( delta );

			morph.getPosition().gwtIncrementX(morphs.get(i).getSpeed() * delta);//morph.position.x += morph.speed * delta;

			if ( morph.getPosition().getX()  > 2000 )  {//if ( morph.position.x  > 2000 )  {

				morph.getPosition().setX(-1000 - Math.random() * 500);//morph.position.x = -1000 - Math.random() * 500;

			}

		}

		controls.update( delta );

		renderer.clear();
		renderer.render( scene, camera );

		// Render debug HUD with shadow map

		if ( showHUD ) {
			//LogUtils.log("showHUD");
			renderer.clearDepth();
			renderer.render( sceneHUD, cameraOrtho );

		}
		
	}

	@Override
	public String getTokenKey() {
		return "shadowmap";
	}


}
