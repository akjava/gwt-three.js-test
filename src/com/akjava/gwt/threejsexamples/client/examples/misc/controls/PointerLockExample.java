package com.akjava.gwt.threejsexamples.client.examples.misc.controls;

import com.akjava.gwt.html5.client.pointerlock.PointerLock;
import com.akjava.gwt.html5.client.pointerlock.PointerLock.PointerLockListener;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.controls.PointerLockControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.core.Intersect;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Face3;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.core.Raycaster;
import com.akjava.gwt.three.client.js.lights.HemisphereLight;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.materials.MeshBasicMaterial;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
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


public class PointerLockExample extends AbstractExample{

	@Override
	public String getName() {
		return "misc/controls/pointerlock";
	}

	@Override
	public void animate(double timestamp) {
		//do requestAnimationFrame on super class
		render(timestamp);
		stats.update();//really deprecate?many still use this
	}

	private WebGLRenderer renderer;
	private Scene scene;
	private PerspectiveCamera camera;
	
	
	private PointerLockControls controls;
	private Light light;
	
	private boolean moveForward;
	private boolean moveLeft;
	private boolean moveBackward;
	private boolean moveRight;
	private boolean canJump;
	
	private Vector3 velocity ;
	private Raycaster raycaster;
	private Geometry geometry;
	private MeshBasicMaterial material;
	
	private JsArray<Object3D> objects;
	
	boolean controlsEnabled;
	
	double prevTime;
	@Override
	public void init() {
		final Element bodyElement=RootPanel.getBodyElement();
		
		prevTime=System.currentTimeMillis();
		
		if(!PointerLock.havePointerLock()){
			Window.alert("This browser does not support Pointer Lock API.quit!" );
			return;
		}else{
			LogUtils.log("Have Pointer API");
		}
		
		LogUtils.log(bodyElement);
		
		PointerLock.addPointerLockChange(new PointerLockListener() {
			@Override
			public void pointerLockChanged(NativeEvent event) {
				//LogUtils.log("Pointer Api Changed");
				
				
				
				if(PointerLock.isPointerLockElement(bodyElement)){
					controlsEnabled=true;
					controls.setEnabled(true);
					LogUtils.log("Pointer Api Changed:true");
				}else{
					controlsEnabled=false;
					controls.setEnabled(false);
					popup.show();
					LogUtils.log("Pointer Api Changed:false");
				}
			}
		});
		
		final FocusPanel container = createContainerPanel();
		
		popup = new PopupPanel(false);
		VerticalPanel mainPanel=new VerticalPanel();
		Label label1=new Label("Click here to Play!");
		mainPanel.add(label1);
		Label label2=new Label("(W, A, S, D = Move, SPACE = Jump, MOUSE = Look around)");
		mainPanel.add(label2);
		popup.add(mainPanel);
		popup.center();
		popup.show();
		
		
		//To get event on root
		popup.addDomHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
			popup.hide();
			container.setFocus(true);
			
			PointerLock.requestPointerLock(bodyElement);
			
			}
		},  MouseDownEvent.getType());
		
		
		container.getElement();
		
		velocity= THREE.Vector3();
		objects=JsArray.createArray().cast();
		
		
		camera = THREE.PerspectiveCamera( 75, getWindowInnerWidth() / getWindowInnerHeight(), 1, 1000 );//camera = new THREE.PerspectiveCamera( 75, window.innerWidth / window.innerHeight, 1, 1000 );

		scene = THREE.Scene();//scene = new THREE.Scene();
		scene.setFog(THREE.Fog( 0xffffff, 0, 750 ));//scene.fog = new THREE.Fog( 0xffffff, 0, 750 );

		HemisphereLight light = THREE.HemisphereLight( 0xeeeeff, 0x777788, 0.75 );//var light = new THREE.HemisphereLight( 0xeeeeff, 0x777788, 0.75 );
		light.getPosition().set( 0.5, 1, 0.75 );//light.position.set( 0.5, 1, 0.75 );
		scene.add( light );

		controls = THREEExp.PointerLockControls( camera );//controls = new THREE.PointerLockControls( camera );
		scene.add( controls.getObject() );

		
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
		
		raycaster = THREE.Raycaster( THREE.Vector3(), THREE.Vector3( 0, - 1, 0 ), 0, 10 );//raycaster = new THREE.Raycaster( new THREE.Vector3(), new THREE.Vector3( 0, - 1, 0 ), 0, 10 );

		// floor

		geometry = THREE.PlaneGeometry( 2000, 2000, 100, 100 );//geometry = new THREE.PlaneGeometry( 2000, 2000, 100, 100 );
		geometry.rotateX( - Math.PI / 2 );

		for ( int i = 0, l = geometry.getVertices().length(); i < l; i ++ ) {//for ( var i = 0, l = geometry.vertices.length; i < l; i ++ ) {

		Vector3 vertex = geometry.vertices().get(i);
		vertex.gwtIncrementX(Math.random() * 20 - 10);
		vertex.gwtIncrementY(Math.random() * 2);
		vertex.gwtIncrementZ(Math.random() * 20 - 10);

		}

		for ( int i = 0, l = geometry.getFaces().length(); i < l; i ++ ) {//for ( var i = 0, l = geometry.faces.length; i < l; i ++ ) {

		Face3 face = geometry.faces().get(i);
		face.getVertexColors().set(0,THREE.Color().setHSL( Math.random() * 0.3 + 0.5, 0.75, Math.random() * 0.25 + 0.75 ));//face.vertexColors[ 0 ] = new THREE.Color().setHSL( Math.random() * 0.3 + 0.5, 0.75, Math.random() * 0.25 + 0.75 );
		face.getVertexColors().set(1,THREE.Color().setHSL( Math.random() * 0.3 + 0.5, 0.75, Math.random() * 0.25 + 0.75 ));//face.vertexColors[ 1 ] = new THREE.Color().setHSL( Math.random() * 0.3 + 0.5, 0.75, Math.random() * 0.25 + 0.75 );
		face.getVertexColors().set(2,THREE.Color().setHSL( Math.random() * 0.3 + 0.5, 0.75, Math.random() * 0.25 + 0.75 ));//face.vertexColors[ 2 ] = new THREE.Color().setHSL( Math.random() * 0.3 + 0.5, 0.75, Math.random() * 0.25 + 0.75 );

		}

		material = THREE.MeshBasicMaterial( GWTParamUtils.MeshBasicMaterial().vertexColors(THREE.VertexColors) );//material = new THREE.MeshBasicMaterial( { vertexColors: THREE.VertexColors } );

		mesh = THREE.Mesh( geometry, material );//mesh = new THREE.Mesh( geometry, material );
		scene.add( mesh );

		// objects

		geometry = THREE.BoxGeometry( 20, 20, 20 );//geometry = new THREE.BoxGeometry( 20, 20, 20 );

		for ( int i = 0, l = geometry.getFaces().length(); i < l; i ++ ) {//for ( var i = 0, l = geometry.faces.length; i < l; i ++ ) {

		Face3 face = geometry.faces().get(i);
		face.getVertexColors().set(0,THREE.Color().setHSL( Math.random() * 0.3 + 0.5, 0.75, Math.random() * 0.25 + 0.75 ));//face.vertexColors[ 0 ] = new THREE.Color().setHSL( Math.random() * 0.3 + 0.5, 0.75, Math.random() * 0.25 + 0.75 );
		face.getVertexColors().set(1,THREE.Color().setHSL( Math.random() * 0.3 + 0.5, 0.75, Math.random() * 0.25 + 0.75 ));//face.vertexColors[ 1 ] = new THREE.Color().setHSL( Math.random() * 0.3 + 0.5, 0.75, Math.random() * 0.25 + 0.75 );
		face.getVertexColors().set(2,THREE.Color().setHSL( Math.random() * 0.3 + 0.5, 0.75, Math.random() * 0.25 + 0.75 ));//face.vertexColors[ 2 ] = new THREE.Color().setHSL( Math.random() * 0.3 + 0.5, 0.75, Math.random() * 0.25 + 0.75 );

		
		}

		for ( int i = 0; i < 500; i ++ ) {

		MeshPhongMaterial material = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().specular(0xffffff).shading(THREE.FlatShading).vertexColors(THREE.VertexColors) );//material = new THREE.MeshPhongMaterial( { specular: 0xffffff, shading: THREE.FlatShading, vertexColors: THREE.VertexColors } );

		Mesh mesh = THREE.Mesh( geometry, material );//var mesh = new THREE.Mesh( geometry, material );
		mesh.getPosition().setX(Math.floor( Math.random() * 20 - 10 ) * 20);//mesh.position.x = Math.floor( Math.random() * 20 - 10 ) * 20;
		mesh.getPosition().setY(Math.floor( Math.random() * 20 ) * 20 + 10);//mesh.position.y = Math.floor( Math.random() * 20 ) * 20 + 10;
		mesh.getPosition().setZ(Math.floor( Math.random() * 20 - 10 ) * 20);//mesh.position.z = Math.floor( Math.random() * 20 - 10 ) * 20;
		scene.add( mesh );

		material.getColor().setHSL( Math.random() * 0.2 + 0.5, 0.75, Math.random() * 0.25 + 0.75 );//material.color.setHSL( Math.random() * 0.2 + 0.5, 0.75, Math.random() * 0.25 + 0.75 );

		objects.push( mesh );

		}
		
		// renderer

		renderer = THREE.WebGLRenderer();//renderer = new THREE.WebGLRenderer();
		renderer.setClearColor( 0xffffff );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );//renderer.setPixelRatio( window.devicePixelRatio );
		renderer.setSize( getWindowInnerWidth(), getWindowInnerHeight() );//renderer.setSize( window.innerWidth, window.innerHeight );
		
		
		container.getElement().appendChild( renderer.getDomElement() );

		

		

		//animate();
		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		
	}
	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		gui.setVisible(false);//no need?
		
	}
	

	



	
	
	public void onWindowResize() {

		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
	}
	
	
	
	
	Mesh mesh;
	private Stats stats;
	private PopupPanel popup;
	public void render(double now) {//GWT animateFrame has time
		
		if ( controlsEnabled ) {
			raycaster.getRay().getOrigin().copy( controls.getObject().getPosition());//raycaster.ray.origin.copy( controls.getObject().position );
			raycaster.getRay().getOrigin().gwtIncrementY(-10);//raycaster.ray.origin.y -= 10;

			JsArray<Intersect> intersections = raycaster.intersectObjects( objects );

			boolean isOnObject = intersections.length() > 0;

			double time = now;
			double delta = ( time - prevTime ) / 1000;

			velocity.gwtIncrementX(-(velocity.getX() * 10.0 * delta)) ;
			velocity.gwtIncrementZ(-(velocity.getZ() * 10.0 * delta)) ;

			velocity.gwtIncrementY(-(9.8 * 100.0 * delta)); // 100.0 = mass

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

			if ( controls.getObject().getPosition().getY() < 10 ) {//if ( controls.getObject().position.y < 10 ) {

			velocity.setY(0);//velocity.y = 0;
			controls.getObject().getPosition().setY(10);//controls.getObject().position.y = 10;

			canJump = true;

			}

			prevTime = time;

			}
		
		renderer.render( scene, camera );
	}

	@Override
	public String getTokenKey() {
		return "pointerlock";
	}
}
