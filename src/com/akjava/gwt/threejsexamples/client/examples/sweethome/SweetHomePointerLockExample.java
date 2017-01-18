package com.akjava.gwt.threejsexamples.client.examples.sweethome;

import com.akjava.gwt.html5.client.pointerlock.PointerLock;
import com.akjava.gwt.html5.client.pointerlock.PointerLock.PointerLockListener;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.controls.PointerLockControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.core.Intersect;
import com.akjava.gwt.three.client.java.ThreeLog;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.core.Raycaster;
import com.akjava.gwt.three.client.js.extras.geometries.PlaneBufferGeometry;
import com.akjava.gwt.three.client.js.extras.helpers.BoxHelper;
import com.akjava.gwt.three.client.js.extras.helpers.PointLightHelper;
import com.akjava.gwt.three.client.js.extras.helpers.SpotLightHelper;
import com.akjava.gwt.three.client.js.lights.AmbientLight;
import com.akjava.gwt.three.client.js.lights.PointLight;
import com.akjava.gwt.three.client.js.loaders.ObjectLoader;
import com.akjava.gwt.three.client.js.loaders.ObjectLoader.ObjectLoadHandler;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class SweetHomePointerLockExample extends AbstractExample{

	@Override
	public String getName() {
		return "SweetHome/loadjson_pointerlock";
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
	private PointerLockControls controls;
	
	private boolean controlsEnabled;
	private PopupPanel titlePopup;
	private Raycaster raycaster;
	
	private boolean moveForward;
	private boolean moveLeft;
	private boolean moveBackward;
	private boolean moveRight;
	private boolean canJump;
	
	private Vector3 velocity ;
	private JsArray<Object3D> objects;
	
	@Override
	public void init() {
		if(!PointerLock.havePointerLock()){
			Window.alert("This browser does not support Pointer Lock API.quit!" );
			return;
		}else{
			LogUtils.log("Have Pointer API");
		}
		
		velocity= THREE.Vector3();
		objects=JsArray.createArray().cast();
		
		
		PointerLock.addPointerLockChange(new PointerLockListener() {
		

			@Override
			public void pointerLockChanged(NativeEvent event) {
				//LogUtils.log("Pointer Api Changed");
				
				
				
				if(PointerLock.isPointerLocked()){
					controlsEnabled=true;
					controls.setEnabled(true);
					LogUtils.log("Pointer Api Changed:true");
				}else{
					controlsEnabled=false;
					controls.setEnabled(false);
					titlePopup.show();
					LogUtils.log("Pointer Api Changed:false");
				}
			}
		});
		
		//do pointer lock,TODO method
		titlePopup = new PopupPanel(false);
		VerticalPanel mainPanel=new VerticalPanel();
		Label label1=new Label("Click here to Play!");
		mainPanel.add(label1);
		Label label2=new Label("(W, A, S, D = Move, SPACE = Jump, MOUSE = Look around)");
		mainPanel.add(label2);
		titlePopup.add(mainPanel);
		titlePopup.center();
		titlePopup.show();
		
		final FocusPanel container = createContainerPanel();
		
		//To get event on root
		titlePopup.addDomHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
			titlePopup.hide();
			container.setFocus(true);
			
			PointerLock.requestPointerLock(RootPanel.getBodyElement());
			
			}
		},  MouseDownEvent.getType());
		
	
		container.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				// TODO Auto-generated method stub
				switch ( event.getNativeKeyCode() ) {

				case 38: // up
				case 87: // w
					moveForward = true;
					break;

				case 37: // left
				case 65: // a
					moveLeft = true; break;

				case 40: // down
				case 83: // s
					moveBackward = true;
					break;

				case 39: // right
				case 68: // d
					moveRight = true;
					break;

				case 32: // space
					if ( canJump == true ) velocity.gwtIncrementY(350);
					canJump = false;
					LogUtils.log("jumping");
					break;

			}
			}
		});

		container.addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {
				switch( event.getNativeKeyCode() ) {

				case 38: // up
				case 87: // w
					moveForward = false;
					break;

				case 37: // left
				case 65: // a
					moveLeft = false;
					break;

				case 40: // down
				case 83: // s
					moveBackward = false;
					break;

				case 39: // right
				case 68: // d
					moveRight = false;
					break;

			}
			}
		});
		
		raycaster = THREE.Raycaster( THREE.Vector3(), THREE.Vector3( 0, - 1, 0 ), 0, 10 );
		
		//global
		FLOOR= -250;//var FLOOR = -250;

		windowHalfX = getWindowInnerWidth() / 2;//var windowHalfX = window.innerWidth / 2;
		windowHalfY = getWindowInnerHeight() / 2;//var windowHalfY = window.innerHeight / 2;

		clock = THREE.Clock();//var clock = new THREE.Clock();
		
		
		 WIDTH = (int)getWindowInnerWidth();
		 HEIGHT = (int)getWindowInnerHeight();

		
		
		
		
		// scene
		scene = null;//load later
				
		
		// renderer
		
		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(true) );//renderer = new THREE.WebGLRenderer( { antialias: true } );
		//renderer.setClearColor( scene.getFog().getColor());//renderer.setClearColor( scene.fog.color );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );//renderer.setPixelRatio( window.devicePixelRatio );
		renderer.setSize( WIDTH, HEIGHT );
		
		renderer.setGammaInput(true);//renderer.gammaInput = true;
		renderer.setGammaOutput(true);//renderer.gammaOutput = true;

		renderer.getShadowMap().setEnabled(true);//renderer.shadowMap.enabled = true;
		
		container.getElement().appendChild( renderer.getDomElement() );

		
		// camera
		camera = THREE.PerspectiveCamera(90, getWindowInnerWidth()/getWindowInnerHeight(), 1, 1000 );
		camera.getPosition().set( -226, 100, -340 );
		
		
		controls = THREEExp.PointerLockControls( camera );//controls = new THREE.PointerLockControls( camera );
		
		
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
		
		loader.load( "sweethome/untitled.json",new ObjectLoadHandler() {
			
			
			
			

			@Override
			public void onLoad(Object3D object) {
				//ObjectHasAnimations hasAnimation=object.cast();
				//sceneAnimationClip = hasAnimation.getAnimations().get(0);
				scene = object.cast();
				
				JsArray<Object3D> objects=scene.getChildren();
				Vector3 pos=null;
				for(int i=0;i<objects.length();i++){
					Object3D obj=objects.get(i);
					
					//LogUtils.log(obj.getType()+":"+obj.getName());
					//ThreeLog.log(obj.getName(),pos);
					
					//somehow mesh has euler
					//if(obj.getName().equals("Track_Track_Black_paint_616")){
					if(obj.getName().endsWith("628")){
						//pos=obj.getWorldPosition(null);
						
						Mesh mesh=obj.cast();
						mesh.getGeometry().computeBoundingBox();
						ThreeLog.log("box:",mesh.getGeometry().getBoundingBox());
						mesh.getGeometry().computeBoundingSphere();
						
						
						
						ThreeLog.log("sphere:",mesh.getGeometry().getBoundingSphere());
						LogUtils.log(mesh);
						Vector3 center=mesh.getGeometry().getBoundingSphere().getCenter();
						center.applyEuler(mesh.getRotation());
						pos=center;
						ThreeLog.log(pos);
						BoxHelper helper=THREE.BoxHelper(obj);
						scene.add(helper);
						
						
						Vector3 diff=THREE.Vector3().copy(pos).sub(camera.getPosition()).divideScalar(10);
						//pos.sub(diff);
						
						AmbientLight light=THREE.AmbientLight(0x111111);
						scene.add(light);
						
						PointLight pointLight = THREE.PointLight( 0xeeeeee );//var directionalLight = new THREE.DirectionalLight( 0x444444 );
						pointLight.setDistance(600);
						pointLight.setIntensity(2);
						pointLight.setDecay(0.9);
						//directionalLight.getPosition().set( -0.5, 1, -1 ).normalize();//directionalLight.position.set( -1, 1, 1 ).normalize();
						pointLight.getPosition().copy(pos);
						scene.add( pointLight );
						LogUtils.log("scene loaded");
						PointLightHelper pheloper=THREE.PointLightHelper(pointLight, 5);
						scene.add(pheloper);
						
						scene.add( controls.getObject() );
					}else{
						
					}
				}
				
				
				//scene.setFog(THREE.Fog( 0xffffff, 2000, 10000 ));//scene.fog = new THREE.Fog( 0xffffff, 2000, 10000 );
//
				//mixer = THREE.AnimationMixer( scene );//mixer = new THREE.AnimationMixer( scene );

				//mixer.clipAction( sceneAnimationClip ).play();//mixer.addAction( new THREE.AnimationAction( sceneAnimationClip ) );

			}
			
			
		} );
	}
	private SpotLightHelper lightHelper;

	
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

	}
	
	public void render(double now) {
		if(scene==null){
			return;//not loaded yet;
		}
		if(lightHelper!=null){
		
		lightHelper.update(); 
		}
		double delta=clock.getDelta();
		
		if ( controlsEnabled ) {
			raycaster.getRay().getOrigin().copy( controls.getObject().getPosition());//raycaster.ray.origin.copy( controls.getObject().position );
			raycaster.getRay().getOrigin().gwtIncrementY(-10);//raycaster.ray.origin.y -= 10;

			JsArray<Intersect> intersections = raycaster.intersectObjects( objects );

			boolean isOnObject = intersections.length() > 0;

			//double time = now;
			//double delta = ( time - prevTime ) / 1000;

			velocity.gwtDecrementX((velocity.getX() * 10.0 * delta)) ;
			velocity.gwtDecrementZ((velocity.getZ() * 10.0 * delta)) ;

			velocity.gwtDecrementY((9.8 * 100.0 * delta)); // 100.0 = mass

			if ( moveForward ) velocity.gwtDecrementZ(400.0 * delta);
			if ( moveBackward ) velocity.gwtIncrementZ(400.0 * delta);

			if ( moveLeft ) velocity.gwtDecrementX(400.0 * delta);
			if ( moveRight ) velocity.gwtIncrementX(400.0 * delta);

			if ( isOnObject == true ) {
			velocity.setY(Math.max( 0, velocity.getY()));//velocity.y = Math.max( 0, velocity.y );

			canJump = true;
			}

			controls.getObject().translateX( velocity.getX() * delta );
			controls.getObject().translateY( velocity.getY() * delta );
			controls.getObject().translateZ( velocity.getZ() * delta );

			if ( controls.getObject().getPosition().getY() < 75 ) {//if ( controls.getObject().position.y < 10 ) {

			velocity.setY(0);//velocity.y = 0;
			controls.getObject().getPosition().setY(75);//controls.getObject().position.y = 10;

			canJump = true;

			}

			//prevTime = time;

			}
		ThreeLog.log(controls.getObject().getPosition());
		renderer.render( scene, camera );
	}

	@Override
	public String getTokenKey() {
		return "sweethome_json_pointerlock";
	}
}
