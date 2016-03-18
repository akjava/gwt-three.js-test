package com.akjava.gwt.threejsexamples.client.examples.geometries;

import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.materials.MeshLambertMaterial;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class GeometriesExample extends AbstractExample{

	@Override
	public String getName() {
		return "geometries";
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

	double SCREEN_WIDTH;
	double SCREEN_HEIGHT;

	

	Clock clock;
	private DirectionalLight light;
	private Object3D object;
	@Override
	public void init() {
	
		clock=THREE.Clock();
		
		 SCREEN_WIDTH = getWindowInnerWidth();
		 SCREEN_HEIGHT = getWindowInnerHeight();
		 

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer();
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );

		// scene
		scene = THREE.Scene();
	
		// camera
		camera = THREE.PerspectiveCamera(45, getWindowInnerWidth()/getWindowInnerHeight(), 1, 2000);
		camera.getPosition().set(0, 400, 0);
		
		scene.add( THREE.AmbientLight( 0x404040 ) );//scene.add( new THREE.AmbientLight( 0x404040 ) );

		light = THREE.DirectionalLight( 0xffffff );//light = new THREE.DirectionalLight( 0xffffff );
		light.getPosition().set( 0, 1, 0 );//light.position.set( 0, 1, 0 );
		scene.add( light );
		
		Texture map = ImageUtils.loadTexture( "textures/UV_Grid_Sm.jpg" );//var map = THREE.ImageUtils.loadTexture( 'textures/UV_Grid_Sm.jpg' );
		map.setWrapS(THREE.RepeatWrapping);//map.wrapS = map.wrapT = THREE.RepeatWrapping;
		map.setWrapT(THREE.RepeatWrapping);
		map.setAnisotropy(16);//map.anisotropy = 16;

		MeshLambertMaterial material = THREE.MeshLambertMaterial( GWTParamUtils.MeshLambertMaterial().map(map).side(THREE.DoubleSide) );//var material = new THREE.MeshLambertMaterial( { map: map, side: THREE.DoubleSide } );
		
		object = THREE.Mesh( THREE.SphereGeometry( 75, 20, 10 ), material );//object = new THREE.Mesh( new THREE.SphereGeometry( 75, 20, 10 ), material );
		object.getPosition().set( -400, 0, 200 );//object.position.set( -400, 0, 200 );
		scene.add( object );

		object = THREE.Mesh( THREE.IcosahedronGeometry( 75, 1 ), material );//object = new THREE.Mesh( new THREE.IcosahedronGeometry( 75, 1 ), material );
		object.getPosition().set( -200, 0, 200 );//object.position.set( -200, 0, 200 );
		scene.add( object );

		object = THREE.Mesh( THREE.OctahedronGeometry( 75, 2 ), material );//object = new THREE.Mesh( new THREE.OctahedronGeometry( 75, 2 ), material );
		object.getPosition().set( 0, 0, 200 );//object.position.set( 0, 0, 200 );
		scene.add( object );

		object = THREE.Mesh( THREE.TetrahedronGeometry( 75, 0 ), material );//object = new THREE.Mesh( new THREE.TetrahedronGeometry( 75, 0 ), material );
		object.getPosition().set( 200, 0, 200 );//object.position.set( 200, 0, 200 );
		scene.add( object );

		//
		
		object = THREE.Mesh( THREE.PlaneGeometry( 100, 100, 4, 4 ), material );//object = new THREE.Mesh( new THREE.PlaneGeometry( 100, 100, 4, 4 ), material );
		object.getPosition().set( -400, 0, 0 );//object.position.set( -400, 0, 0 );
		scene.add( object );

		object = THREE.Mesh( THREE.BoxGeometry( 100, 100, 100, 4, 4, 4 ), material );//object = new THREE.Mesh( new THREE.BoxGeometry( 100, 100, 100, 4, 4, 4 ), material );
		object.getPosition().set( -200, 0, 0 );//object.position.set( -200, 0, 0 );
		scene.add( object );

		object = THREE.Mesh( THREE.CircleGeometry( 50, 20, 0, Math.PI * 2 ), material );//object = new THREE.Mesh( new THREE.CircleGeometry( 50, 20, 0, Math.PI * 2 ), material );
		object.getPosition().set( 0, 0, 0 );//object.position.set( 0, 0, 0 );
		scene.add( object );

		object = THREE.Mesh( THREE.RingGeometry( 10, 50, 20, 5, 0, Math.PI * 2 ), material );//object = new THREE.Mesh( new THREE.RingGeometry( 10, 50, 20, 5, 0, Math.PI * 2 ), material );
		object.getPosition().set( 200, 0, 0 );//object.position.set( 200, 0, 0 );
		scene.add( object );

		object = THREE.Mesh( THREE.CylinderGeometry( 25, 75, 100, 40, 5 ), material );//object = new THREE.Mesh( new THREE.CylinderGeometry( 25, 75, 100, 40, 5 ), material );
		object.getPosition().set( 400, 0, 0 );//object.position.set( 400, 0, 0 );
		scene.add( object );
		
		JsArray<Vector3> points = JavaScriptObject.createArray().cast();

		for ( int i = 0; i < 50; i ++ ) {

		points.push( THREE.Vector3( Math.sin( i * 0.2 ) * Math.sin( i * 0.1 ) * 15 + 50, 0, ( i - 5 ) * 2 ) );//points.push( new THREE.Vector3( Math.sin( i * 0.2 ) * Math.sin( i * 0.1 ) * 15 + 50, 0, ( i - 5 ) * 2 ) );

		}
	
		object = THREE.Mesh( THREE.LatheGeometry( points, 20 ), material );//object = new THREE.Mesh( new THREE.LatheGeometry( points, 20 ), material );
		object.getPosition().set( -400, 0, -200 );//object.position.set( -400, 0, -200 );
		scene.add( object );

		object = THREE.Mesh( THREE.TorusGeometry( 50, 20, 20, 20 ), material );//object = new THREE.Mesh( new THREE.TorusGeometry( 50, 20, 20, 20 ), material );
		object.getPosition().set( -200, 0, -200 );//object.position.set( -200, 0, -200 );
		scene.add( object );

		object = THREE.Mesh( THREE.TorusKnotGeometry( 50, 10, 50, 20 ), material );//object = new THREE.Mesh( new THREE.TorusKnotGeometry( 50, 10, 50, 20 ), material );
		object.getPosition().set( 0, 0, -200 );//object.position.set( 0, 0, -200 );
		scene.add( object );
		
		object = THREE.AxisHelper( 50 );//object = new THREE.AxisHelper( 50 );
		object.getPosition().set( 200, 0, -200 );//object.position.set( 200, 0, -200 );
		scene.add( object );

		object = THREE.ArrowHelper( THREE.Vector3( 0, 1, 0 ), THREE.Vector3( 0, 0, 0 ), 50 );//object = new THREE.ArrowHelper( new THREE.Vector3( 0, 1, 0 ), new THREE.Vector3( 0, 0, 0 ), 50 );
		object.getPosition().set( 400, 0, -200 );//object.position.set( 400, 0, -200 );
		scene.add( object );
		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - webgl - geometries</div>"
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
		SCREEN_WIDTH = getWindowInnerWidth();
		SCREEN_HEIGHT = getWindowInnerHeight();
	
		//re read because of double
		camera.setAspect(SCREEN_WIDTH / SCREEN_HEIGHT);
		camera.updateProjectionMatrix();

		renderer.setSize( SCREEN_WIDTH , SCREEN_HEIGHT );
	
	}
	
	public void render(double now) {
		double timer = now * 0.0001;

		camera.getPosition().setX(Math.cos( timer ) * 800);//camera.position.x = Math.cos( timer ) * 800;
		camera.getPosition().setZ(Math.sin( timer ) * 800);//camera.position.z = Math.sin( timer ) * 800;

		camera.lookAt( scene.getPosition());//camera.lookAt( scene.position );
		
		for ( int i = 0, l = scene.getChildren().length(); i < l; i ++ ) {//for ( var i = 0, l = scene.children.length; i < l; i ++ ) {

		Object3D object = scene.getChildren().get(i);

		object.getRotation().setX(timer * 5);//object.rotation.x = timer * 5;
		object.getRotation().setY(timer * 2.5);//object.rotation.y = timer * 2.5;

		}

		
		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "geometries";
	}
}
