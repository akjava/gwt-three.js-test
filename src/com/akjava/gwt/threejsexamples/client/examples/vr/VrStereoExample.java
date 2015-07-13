package com.akjava.gwt.threejsexamples.client.examples.vr;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.controls.MouseControls;
import com.akjava.gwt.three.client.examples.js.controls.OrbitControls;
import com.akjava.gwt.three.client.examples.js.controls.VRControls;
import com.akjava.gwt.three.client.examples.js.effects.StereoEffect;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.core.Intersect;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Raycaster;
import com.akjava.gwt.three.client.js.extras.geometries.BoxGeometry;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.materials.MeshLambertMaterial;
import com.akjava.gwt.three.client.js.math.THREEMath;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class VrStereoExample extends AbstractExample{

	@Override
	public String getName() {
		return "vr/cubes";
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
	


	Mesh mesh;
	private Stats stats;
	private VRControls vrControls;

	private VRControls headControls;
	private StereoEffect vrEffect;
	private Raycaster raycaster;
	
	Vector2 mouse=THREE.Vector2();
	Mesh INTERSECTED;
	private MouseControls mouseControls;
	@Override
	public void init() {
		FocusPanel container = createContainerPanel();

		container.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				onDocumentMouseMove(event);
			}
		});
		
		camera = THREE.PerspectiveCamera( 70, getWindowInnerWidth() / getWindowInnerHeight(), 1, 10000 );//camera = new THREE.PerspectiveCamera( 70, window.innerWidth / window.innerHeight, 1, 10000 );

		scene = THREE.Scene();//scene = new THREE.Scene();

		DirectionalLight light = THREE.DirectionalLight( 0xffffff, 1 );//var light = new THREE.DirectionalLight( 0xffffff, 1 );
		light.getPosition().set( 1, 1, 1 ).normalize();//light.position.set( 1, 1, 1 ).normalize();
		scene.add( light );

		BoxGeometry geometry = THREE.BoxGeometry( 20, 20, 20 );//var geometry = new THREE.BoxGeometry( 20, 20, 20 );

		for ( int i = 0; i < 2000; i ++ ) {

		Mesh object = THREE.Mesh( geometry, THREE.MeshLambertMaterial( GWTParamUtils.MeshLambertMaterial().color((int)(Math.random() * 0xffffff)) ) );//var object = new THREE.Mesh( geometry, new THREE.MeshLambertMaterial( { color: Math.random() * 0xffffff } ) );

		object.getPosition().setX(Math.random() * 800 - 400);//object.position.x = Math.random() * 800 - 400;
		object.getPosition().setY(Math.random() * 800 - 400);//object.position.y = Math.random() * 800 - 400;
		object.getPosition().setZ(Math.random() * 800 - 400);//object.position.z = Math.random() * 800 - 400;

		object.getRotation().setX(Math.random() * 2 * Math.PI);//object.rotation.x = Math.random() * 2 * Math.PI;
		object.getRotation().setY(Math.random() * 2 * Math.PI);//object.rotation.y = Math.random() * 2 * Math.PI;
		object.getRotation().setZ(Math.random() * 2 * Math.PI);//object.rotation.z = Math.random() * 2 * Math.PI;

		object.getScale().setX(Math.random() + 0.5);//object.scale.x = Math.random() + 0.5;
		object.getScale().setY(Math.random() + 0.5);//object.scale.y = Math.random() + 0.5;
		object.getScale().setZ(Math.random() + 0.5);//object.scale.z = Math.random() + 0.5;

		scene.add( object );

		}
		raycaster = THREE.Raycaster();//raycaster = new THREE.Raycaster();

		
		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(true) );
		renderer.setClearColor( 0xf0f0f0);
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( getWindowInnerWidth(), getWindowInnerHeight()  );
		renderer.setSortObjects(false);
		

		//TODO handle mouse button
		//var fullScreenButton = document.querySelector( '.full-screen' );
		//var mouseLookButton = document.querySelector( '.mouse-look' );
		boolean mouseLook = false;//var mouseLook = false;

		/*
		fullScreenButton.setOnclick(function() {)//fullScreenButton.onclick = function() {
		vrEffect.setFullScreen( true );
		};
		*/
		vrControls = THREEExp.VRControls(camera);//vrControls = new THREE.VRControls(camera);
		mouseControls = THREEExp.MouseControls(camera);//mouseControls = new THREE.MouseControls(camera);
		headControls = vrControls;

		/*TODO handle buttons
		mouseLookButton.setOnclick(function() {)//mouseLookButton.onclick = function() {
		mouseLook = !mouseLook;

		if (mouseLook) {
		headControls = mouseControls;
		mouseLookButton.getClassList().add('enabled');//mouseLookButton.classList.add('enabled');
		} else {
		headControls = vrControls;
		mouseLookButton.getClassList().remove('enabled');//mouseLookButton.classList.remove('enabled');
		}
		}
		*/
		vrEffect = THREEExp.StereoEffect(renderer);

		
		
		
		
		// renderer
		
		container.getElement().appendChild( renderer.getDomElement() );

		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<a href='http://threejs.org' target='_blank'>three.js</a> webgl - interactive cubes (StereoEffect version)"
				,100,10));
		
		
		onWindowResize();//somehow oninitial fail to draw
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		
		
	}
	protected void onDocumentMouseMove(MouseMoveEvent event) {
		event.preventDefault();
		
		mouse.setX(( event.getClientX() / getWindowInnerWidth()) * 2 - 1);//mouse.x = ( event.clientX / window.innerWidth ) * 2 - 1;
		mouse.setY(- ( event.getClientY() / getWindowInnerHeight()) * 2 + 1);//mouse.y = - ( event.clientY / window.innerHeight ) * 2 + 1;
	}
	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
		//TODO create-gui
		
	}
	

	



	
	
	public void onWindowResize() {

		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		vrEffect.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
	}
	
	
	double theta;
	double radius = 100;
	
	
	public MeshLambertMaterial toMeshLambertMaterial(Material material){
		return material.cast();
	}
	
	private int INTERSECTED_currentHex;
	
	public void render(double now) {//GWT animateFrame has time
		theta += 0.1;

		camera.getPosition().setX(radius * Math.sin( THREEMath.degToRad( theta ) ));//camera.position.x = radius * Math.sin( THREE.Math.degToRad( theta ) );
		camera.getPosition().setY(radius * Math.sin( THREEMath.degToRad( theta ) ));//camera.position.y = radius * Math.sin( THREE.Math.degToRad( theta ) );
		camera.getPosition().setZ(radius * Math.cos( THREEMath.degToRad( theta ) ));//camera.position.z = radius * Math.cos( THREE.Math.degToRad( theta ) );
		camera.lookAt( scene.getPosition());//camera.lookAt( scene.position );

		camera.updateMatrixWorld();

		// find intersections

		raycaster.setFromCamera( mouse, camera );

		JsArray<Intersect> intersects = raycaster.intersectObjects( scene.getChildren());//var intersects = raycaster.intersectObjects( scene.children );

		if ( intersects.length() > 0 ) {

		if ( INTERSECTED != intersects.get(0).getObject()) {//if ( INTERSECTED != intersects[ 0 ].object ) {

		if ( INTERSECTED!=null ) toMeshLambertMaterial(INTERSECTED.getMaterial()).getEmissive().setHex( INTERSECTED_currentHex);//if ( INTERSECTED ) INTERSECTED.material.emissive.setHex( INTERSECTED.currentHex );

		INTERSECTED = intersects.get(0).getObject().cast();
		INTERSECTED_currentHex=toMeshLambertMaterial(INTERSECTED.getMaterial()).getEmissive().getHex();
		
		toMeshLambertMaterial(INTERSECTED.getMaterial()).getEmissive().setHex( 0xff0000 );//INTERSECTED.material.emissive.setHex( 0xff0000 );

		}

		} else {

		if ( INTERSECTED!=null ) toMeshLambertMaterial(INTERSECTED.getMaterial()).getEmissive().setHex( INTERSECTED_currentHex);//if ( INTERSECTED ) INTERSECTED.material.emissive.setHex( INTERSECTED.currentHex );

		INTERSECTED = null;

		}

		headControls.update();
		vrEffect.render( scene, camera );
	}

	@Override
	public String getTokenKey() {
		return "stereocubes";
	}
}
