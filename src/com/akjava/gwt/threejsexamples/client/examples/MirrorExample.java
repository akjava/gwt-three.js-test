package com.akjava.gwt.threejsexamples.client.examples;

import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.GWTExampleParamUtils;
import com.akjava.gwt.three.client.examples.js.Mirror;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.controls.OrbitControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.extras.geometries.CylinderGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.IcosahedronGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.PlaneBufferGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.SphereGeometry;
import com.akjava.gwt.three.client.js.lights.PointLight;
import com.akjava.gwt.three.client.js.materials.MeshLambertMaterial;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class MirrorExample extends AbstractExample{

	@Override
	public String getName() {
		return "mirror";
	}

	@Override
	public void animate(double timestamp) {
		
		//do requestAnimationFrame on super class
		
		double timer = timestamp * 0.01;

		sphereGroup.getRotation().gwtIncrementY(- 0.002);//sphereGroup.rotation.y -= 0.002;

		smallSphere.getPosition().set(//smallSphere.position.set(
		Math.cos( timer * 0.1 ) * 30,
		Math.abs( Math.cos( timer * 0.2 ) ) * 20 + 5,
		Math.sin( timer * 0.1 ) * 30
		);
		smallSphere.getRotation().setY(( Math.PI / 2 ) - timer * 0.1);//smallSphere.rotation.y = ( Math.PI / 2 ) - timer * 0.1;
		smallSphere.getRotation().setZ(timer * 0.8);//smallSphere.rotation.z = timer * 0.8;

		cameraControls.update();
		
		
		render(timestamp);
		stats.update();//really deprecate?many still use this
	}

	private WebGLRenderer renderer;
	private Scene scene;
	private PerspectiveCamera camera;
	private Stats stats;

	private Mesh mesh;
	private OrbitControls cameraControls;
	int WIDTH;
	int HEIGHT;
	private Mirror groundMirror;
	private Mirror verticalMirror;
	private Object3D sphereGroup;
	private Mesh smallSphere;
	@Override
	public void init() {
		 WIDTH = (int)getWindowInnerWidth();//var WIDTH = window.innerWidth;
		 HEIGHT = (int)getWindowInnerHeight();//var HEIGHT = window.innerHeight;

		// camera
		int VIEW_ANGLE = 45;//var VIEW_ANGLE = 45;
		double ASPECT = getWindowInnerWidth() / getWindowInnerHeight();
		double NEAR = 1;//var NEAR = 1;
		double FAR = 500;//var FAR = 500;
		
		FocusPanel container = createContainerPanel();

		// renderer
		renderer = THREE.WebGLRenderer();//renderer = new THREE.WebGLRenderer();
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );//renderer.setPixelRatio( window.devicePixelRatio );
		renderer.setSize( WIDTH, HEIGHT );

		// scene
		scene = THREE.Scene();//scene = new THREE.Scene();

		// camera
		camera = THREE.PerspectiveCamera(VIEW_ANGLE, ASPECT, NEAR, FAR);//camera = new THREE.PerspectiveCamera(VIEW_ANGLE, ASPECT, NEAR, FAR);
		camera.getPosition().set( 0, 75, 160 );//camera.position.set( 0, 75, 160 );

		cameraControls = THREEExp.OrbitControls(camera, renderer.getDomElement());//cameraControls = new THREE.OrbitControls(camera, renderer.domElement);
		cameraControls.getTarget().set( 0, 40, 0);//cameraControls.target.set( 0, 40, 0);
		cameraControls.setMaxDistance(400);//cameraControls.maxDistance = 400;
		cameraControls.setMinDistance(10);//cameraControls.minDistance = 10;
		cameraControls.update();

		
		container.getElement().appendChild( renderer.getDomElement() );

		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - mirror</a>"
				,100,10));
		
		
		fillScene();
		
		//handle resize & gui
		//initResizeHandlerAndGUI();
		
	}
	
	public void fillScene(){
		
		PlaneBufferGeometry planeGeo = THREE.PlaneBufferGeometry( 100.1, 100.1 );//var planeGeo = new THREE.PlaneBufferGeometry( 100.1, 100.1 );

		// MIRORR planes
		groundMirror = THREEExp.Mirror( renderer, camera, GWTExampleParamUtils.Mirror().clipBias(0.003).textureWidth(WIDTH).textureHeight(HEIGHT).color(0x777777) );//groundMirror = new THREE.Mirror( renderer, camera, { clipBias: 0.003, textureWidth: WIDTH, textureHeight: HEIGHT, color: 0x777777 } );

		Mesh mirrorMesh = THREE.Mesh( planeGeo, groundMirror.getMaterial());//var mirrorMesh = new THREE.Mesh( planeGeo, groundMirror.material );
		mirrorMesh.add( groundMirror );
		mirrorMesh.rotateX( - Math.PI / 2 );
		scene.add( mirrorMesh );

		verticalMirror = THREEExp.Mirror( renderer, camera, GWTExampleParamUtils.Mirror().clipBias(0.003).textureWidth(WIDTH).textureHeight(HEIGHT).color(0x889999) );//verticalMirror = new THREE.Mirror( renderer, camera, { clipBias: 0.003, textureWidth: WIDTH, textureHeight: HEIGHT, color:0x889999 } );

		Mesh verticalMirrorMesh = THREE.Mesh( THREE.PlaneBufferGeometry( 60, 60 ), verticalMirror.getMaterial());//var verticalMirrorMesh = new THREE.Mesh( new THREE.PlaneBufferGeometry( 60, 60 ), verticalMirror.material );
		verticalMirrorMesh.add( verticalMirror );
		verticalMirrorMesh.getPosition().setY(35);//verticalMirrorMesh.position.y = 35;
		verticalMirrorMesh.getPosition().setZ(-45);//verticalMirrorMesh.position.z = -45;
		scene.add( verticalMirrorMesh );

		sphereGroup = THREE.Object3D();//sphereGroup = new THREE.Object3D();
		scene.add( sphereGroup );

		CylinderGeometry geometry = THREE.CylinderGeometry( 0.1, 15 * Math.cos( Math.PI / 180 * 30 ), 0.1, 24, 1 );//var geometry = new THREE.CylinderGeometry( 0.1, 15 * Math.cos( Math.PI / 180 * 30 ), 0.1, 24, 1 );
		MeshPhongMaterial material = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff).emissive(0x444444) );//var material = new THREE.MeshPhongMaterial( { color: 0xffffff, emissive: 0x444444 } );
		Mesh sphereCap = THREE.Mesh( geometry, material );//var sphereCap = new THREE.Mesh( geometry, material );
		sphereCap.getPosition().setY(-15 * Math.sin( Math.PI / 180 * 30 ) - 0.05);//sphereCap.position.y = -15 * Math.sin( Math.PI / 180 * 30 ) - 0.05;
		sphereCap.rotateX(-Math.PI);

		SphereGeometry geometry2 = THREE.SphereGeometry( 15, 24, 24, Math.PI / 2, Math.PI * 2, 0, Math.PI / 180 * 120 );//var geometry = new THREE.SphereGeometry( 15, 24, 24, Math.PI / 2, Math.PI * 2, 0, Math.PI / 180 * 120 );
		Mesh halfSphere = THREE.Mesh( geometry2, material );//var halfSphere = new THREE.Mesh( geometry, material );
		halfSphere.add( sphereCap );
		halfSphere.rotateX( - Math.PI / 180 * 135 );
		halfSphere.rotateZ( - Math.PI / 180 * 20 );
		halfSphere.getPosition().setY(7.5 + 15 * Math.sin( Math.PI / 180 * 30 ));//halfSphere.position.y = 7.5 + 15 * Math.sin( Math.PI / 180 * 30 );

		sphereGroup.add( halfSphere );

		IcosahedronGeometry geometry3 = THREE.IcosahedronGeometry( 5, 0 );//var geometry = new THREE.IcosahedronGeometry( 5, 0 );
		MeshLambertMaterial material3 = THREE.MeshLambertMaterial( GWTParamUtils.MeshLambertMaterial().color(0xffffff).emissive(0x333333).shading(THREE.FlatShading) );//var material = new THREE.MeshLambertMaterial( { color: 0xffffff, emissive: 0x333333, shading: THREE.FlatShading } );
		smallSphere = THREE.Mesh( geometry3, material3 );//smallSphere = new THREE.Mesh( geometry, material );
		scene.add(smallSphere);
		
		// walls
		Mesh planeTop = THREE.Mesh( planeGeo, THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff) ) );//var planeTop = new THREE.Mesh( planeGeo, new THREE.MeshPhongMaterial( { color: 0xffffff } ) );
		planeTop.getPosition().setY(100);//planeTop.position.y = 100;
		planeTop.rotateX( Math.PI / 2 );
		scene.add( planeTop );

		Mesh planeBack = THREE.Mesh( planeGeo, THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff) ) );//var planeBack = new THREE.Mesh( planeGeo, new THREE.MeshPhongMaterial( { color: 0xffffff } ) );
		planeBack.getPosition().setZ(-50);//planeBack.position.z = -50;
		planeBack.getPosition().setY(50);//planeBack.position.y = 50;
		scene.add( planeBack );

		Mesh planeFront = THREE.Mesh( planeGeo, THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0x7f7fff) ) );//var planeFront = new THREE.Mesh( planeGeo, new THREE.MeshPhongMaterial( { color: 0x7f7fff } ) );
		planeFront.getPosition().setZ(50);//planeFront.position.z = 50;
		planeFront.getPosition().setY(50);//planeFront.position.y = 50;
		planeFront.rotateY( Math.PI );
		scene.add( planeFront );
		
		Mesh planeRight = THREE.Mesh( planeGeo, THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0x00ff00) ) );//var planeRight = new THREE.Mesh( planeGeo, new THREE.MeshPhongMaterial( { color: 0x00ff00 } ) );
		planeRight.getPosition().setX(50);//planeRight.position.x = 50;
		planeRight.getPosition().setY(50);//planeRight.position.y = 50;
		planeRight.rotateY( - Math.PI / 2 );
		scene.add( planeRight );

		Mesh planeLeft = THREE.Mesh( planeGeo, THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xff0000) ) );//var planeLeft = new THREE.Mesh( planeGeo, new THREE.MeshPhongMaterial( { color: 0xff0000 } ) );
		planeLeft.getPosition().setX(-50);//planeLeft.position.x = -50;
		planeLeft.getPosition().setY(50);//planeLeft.position.y = 50;
		planeLeft.rotateY( Math.PI / 2 );
		scene.add( planeLeft );

		// lights
		PointLight mainLight = THREE.PointLight( 0xcccccc, 1.5, 250 );//var mainLight = new THREE.PointLight( 0xcccccc, 1.5, 250 );
		mainLight.getPosition().setY(60);//mainLight.position.y = 60;
		scene.add( mainLight );

		PointLight greenLight = THREE.PointLight( 0x00ff00, 0.25, 1000 );//var greenLight = new THREE.PointLight( 0x00ff00, 0.25, 1000 );
		greenLight.getPosition().set( 550, 50, 0 );//greenLight.position.set( 550, 50, 0 );
		scene.add( greenLight );

		PointLight redLight = THREE.PointLight( 0xff0000, 0.25, 1000 );//var redLight = new THREE.PointLight( 0xff0000, 0.25, 1000 );
		redLight.getPosition().set( - 550, 50, 0 );//redLight.position.set( - 550, 50, 0 );
		scene.add( redLight );

		PointLight blueLight = THREE.PointLight( 0x7f7fff, 0.25, 1000 );//var blueLight = new THREE.PointLight( 0x7f7fff, 0.25, 1000 );
		blueLight.getPosition().set( 0, 50, 550 );//blueLight.position.set( 0, 50, 550 );
		scene.add( blueLight );
		
	}

	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
	}
	

	



	
	
	public void onWindowResize() {
		//TODO support mirror resize
		
		/*
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
		*/
	}
	
	
	public void render(double now) {//GWT animateFrame has time
		groundMirror.renderWithMirror( verticalMirror );
		verticalMirror.renderWithMirror( groundMirror );
		
		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "mirror";
	}
}
