package com.akjava.gwt.threejsexamples.client.examples.geometries;

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.controls.TrackballControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.extras.geometries.ExtrudeGeometryParameter;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.extras.core.Shape;
import com.akjava.gwt.three.client.js.extras.curves.CatmullRomCurve3;
import com.akjava.gwt.three.client.js.extras.geometries.ExtrudeGeometry;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.lights.PointLight;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.materials.MeshLambertMaterial;
import com.akjava.gwt.three.client.js.math.THREEMath;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class ExtrudeShapesExample extends AbstractExample{

	@Override
	public String getName() {
		return "geometry/extrude shapes";
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

	
	private int windowHalfX,windowHalfY;
	//private int mouseX,mouseY;

	Clock clock;
	private TrackballControls controls;
	@Override
	public void init() {
	
		clock=THREE.Clock();
		
		 SCREEN_WIDTH = getWindowInnerWidth();
		 SCREEN_HEIGHT = getWindowInnerHeight();
		 
		 windowHalfX= (int)(SCREEN_WIDTH/2);
		 windowHalfY= (int)(SCREEN_HEIGHT/2);

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer();
		renderer.setClearColor( 0x222222 );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );

		// scene
		scene = THREE.Scene();
	
		// camera
		camera = THREE.PerspectiveCamera(45, getWindowInnerWidth()/getWindowInnerHeight(), 0.5, 300000);
		camera.getPosition().set(0, 0, 500);
		

		
		controls = THREEExp.TrackballControls( camera, renderer.getDomElement());//controls = new THREE.TrackballControls( camera, renderer.domElement );
		controls.setMinDistance(200);//controls.minDistance = 200;
		controls.setMaxDistance(500);//controls.maxDistance = 500;
		
		
		scene.add( THREE.AmbientLight( 0x222222 ) );//scene.add( new THREE.AmbientLight( 0x222222 ) );

		//temporaly fix maybe newer three.js solve this problem
		Light light=THREE.DirectionalLight(0xffffff);
		light.getPosition().set(0, 1, 1);
		scene.add(light);
		/*
		PointLight light = THREE.PointLight( 0xffffff ,70000);//var light = new THREE.PointLight( 0xffffff );
		
		light.getPosition().copy( camera.getPosition());//light.position.copy( camera.position );
		scene.add( light );
		*/
		

		CatmullRomCurve3 closedSpline = THREE.CatmullRomCurve3(
				(JsArray<Vector3>)JavaScriptUtils.createJSArray(THREE.Vector3( -60, -100,  60 ),
THREE.Vector3( -60,   20,  60 ),
THREE.Vector3( -60,  120,  60 ),
THREE.Vector3(  60,   20, -60 ),
THREE.Vector3(  60, -100, -60 )
				));
		
		ExtrudeGeometryParameter extrudeSettings = GWTParamUtils.ExtrudeGeometry().steps(100).bevelEnabled(false).extrudePath(closedSpline);//var extrudeSettings = {steps			: 100,bevelEnabled	: false,extrudePath		: closedSpline};
		
		JsArray<Vector2> pts = JavaScriptUtils.createJSArray();
		
		int count = 3;

		for ( int i = 0; i < count; i ++ ) {

		double l = 20;//var l = 20;

		double a = (double)(2 * i) / count * Math.PI;

		pts.push( THREE.Vector2 ( Math.cos( a ) * l, Math.sin( a ) * l ) );//pts.push( new THREE.Vector2 ( Math.cos( a ) * l, Math.sin( a ) * l ) );

		}
		
		Shape shape = THREE.Shape( pts );//var shape = new THREE.Shape( pts );

		ExtrudeGeometry geometry = THREE.ExtrudeGeometry( shape, extrudeSettings );//var geometry = new THREE.ExtrudeGeometry( shape, extrudeSettings );

		MeshLambertMaterial material = THREE.MeshLambertMaterial( GWTParamUtils.MeshLambertMaterial().color(0xb00000).wireframe(false) );//var material = new THREE.MeshLambertMaterial( { color: 0xb00000, wireframe: false } );

		Mesh mesh = THREE.Mesh( geometry, material );//var mesh = new THREE.Mesh( geometry, material );

		scene.add( mesh );

		JsArray<Vector3> randomPoints = JavaScriptUtils.createJSArray();

		for ( int i = 0; i < 10; i ++ ) {

		randomPoints.push( THREE.Vector3( ( i - 4.5 ) * 50, THREEMath.randFloat( - 50, 50 ), THREEMath.randFloat( - 50, 50 ) ) );//randomPoints.push( new THREE.Vector3( ( i - 4.5 ) * 50, THREE.Math.randFloat( - 50, 50 ), THREE.Math.randFloat( - 50, 50 ) ) );

		}

		CatmullRomCurve3 randomSpline =  THREE.CatmullRomCurve3( randomPoints );//var randomSpline =  new THREE.CatmullRomCurve3( randomPoints );
		
		extrudeSettings = GWTParamUtils.ExtrudeGeometry().steps(200).bevelEnabled(false).extrudePath(randomSpline);//var extrudeSettings = {steps			: 200,bevelEnabled	: false,extrudePath		: randomSpline};
		
		pts  = JavaScriptUtils.createJSArray();
				
		int numPts = 5;

		for ( int i = 0; i < numPts * 2; i ++ ) {

		int l = i % 2 == 1 ? 10 : 20;

		double a = (double)i / numPts * Math.PI;

		pts.push( THREE.Vector2 ( Math.cos( a ) * l, Math.sin( a ) * l ) );//pts.push( new THREE.Vector2 ( Math.cos( a ) * l, Math.sin( a ) * l ) );

		}

		shape = THREE.Shape( pts );//var shape = new THREE.Shape( pts );

		geometry = THREE.ExtrudeGeometry( shape, extrudeSettings );//var geometry = new THREE.ExtrudeGeometry( shape, extrudeSettings );

		MeshLambertMaterial material2 = THREE.MeshLambertMaterial( GWTParamUtils.MeshLambertMaterial().color(0xff8000).wireframe(false) );//var material2 = new THREE.MeshLambertMaterial( { color: 0xff8000, wireframe: false } );

		mesh = THREE.Mesh( geometry, material2 );//var mesh = new THREE.Mesh( geometry, material2 );

		scene.add( mesh );
		
		JsArray<Material> materials =JavaScriptUtils.createJSArray(material,material2);//var materials = [ material, material2 ];
		
		extrudeSettings = GWTParamUtils.ExtrudeGeometry().amount(20).steps(1).bevelEnabled(true).bevelThickness(2).bevelSize(4).bevelSegments(1);
		
		geometry = THREE.ExtrudeGeometry( shape, extrudeSettings );//var geometry = new THREE.ExtrudeGeometry( shape, extrudeSettings );

		mesh = THREE.Mesh( geometry, THREE.MultiMaterial( materials ) );//var mesh = new THREE.Mesh( geometry, new THREE.MultiMaterial( materials ) );

		mesh.getPosition().set( 50, 100, 50 );//mesh.position.set( 50, 100, 50 );

		scene.add( mesh );
		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML(
				"<div style='text:white'>" +
				"<a href='http://threejs.org' target='_blank'>three.js</a>" +
				"  - ExtrudeShapes" +
				"</div>"
				,100,10));
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		
	}
	

	
	private VerticalPanel initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		//TODO add other ui or after return;
		return gui;
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
		double delta=clock.getDelta();
		//do something
		
		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "extrude_shapes";
	}
}
