package com.akjava.gwt.threejsexamples.client.examples.camera;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.cameras.OrthographicCamera;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.helpers.CameraHelper;
import com.akjava.gwt.three.client.js.math.THREEMath;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Group;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.objects.Points;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class CameraExample extends AbstractExample{

	@Override
	public String getName() {
		return "camera";
	}

	@Override
	public void animate(double timestamp) {

		render(timestamp);
		stats.update();//really deprecate?many still use this
	}

	private WebGLRenderer renderer;
	private Scene scene;
	private PerspectiveCamera cameraPerspective;
	private Stats stats;

	double WIDTH;
	double HEIGHT;

	
	private int windowHalfX,windowHalfY;
	//private int mouseX,mouseY;

	Clock clock;
	private CameraHelper cameraPerspectiveHelper;
	private OrthographicCamera cameraOrtho;
	private CameraHelper cameraOrthoHelper;
	private Camera activeCamera;
	private CameraHelper activeHelper;
	private Group cameraRig;
	private Mesh mesh;
	private PerspectiveCamera camera;
	
	@Override
	public void init() {
	
		clock=THREE.Clock();
		
		 WIDTH = getWindowInnerWidth();
		 HEIGHT = getWindowInnerHeight();
		 
		 windowHalfX=(int) (getWindowInnerWidth()/2);
		 windowHalfY=(int) (getWindowInnerHeight()/2);

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(true) );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( WIDTH, HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );
		renderer.setAutoClear(false);
		
		// scene
		scene = THREE.Scene();
	
		// camera
		

		//cameraPerspective = new THREE.PerspectiveCamera( 50, 0.5 * SCREEN_WIDTH / SCREEN_HEIGHT, 150, 1000 );
		
		camera = THREE.PerspectiveCamera(50, 0.5*getWindowInnerWidth()/getWindowInnerHeight(), 1, 10000);
		camera.getPosition().set(0, 0, 2500);
		
		
		cameraPerspective = THREE.PerspectiveCamera( 50, 0.5 * getWindowInnerWidth() / getWindowInnerHeight(), 150, 1000 );
		
		cameraPerspectiveHelper = THREE.CameraHelper( cameraPerspective );//cameraPerspectiveHelper = new THREE.CameraHelper( cameraPerspective );
		scene.add( cameraPerspectiveHelper );

		cameraOrtho = THREE.OrthographicCamera( 0.5 * WIDTH / - 2, 0.5 * WIDTH / 2, HEIGHT / 2, HEIGHT / - 2, 150, 1000 );//cameraOrtho = new THREE.OrthographicCamera( 0.5 * SCREEN_WIDTH / - 2, 0.5 * SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, SCREEN_HEIGHT / - 2, 150, 1000 );

		cameraOrthoHelper = THREE.CameraHelper( cameraOrtho );//cameraOrthoHelper = new THREE.CameraHelper( cameraOrtho );
		scene.add( cameraOrthoHelper );
		
		activeCamera = cameraPerspective;
		activeHelper = cameraPerspectiveHelper;

		
		cameraOrtho.getRotation().setY(Math.PI);//cameraOrtho.rotation.y = Math.PI;
		cameraPerspective.getRotation().setY(Math.PI);//cameraPerspective.rotation.y = Math.PI;

		cameraRig = THREE.Group();//cameraRig = new THREE.Group();

		cameraRig.add( cameraPerspective );
		cameraRig.add( cameraOrtho );

		scene.add( cameraRig );
		
		
		mesh = THREE.Mesh(//mesh = new THREE.Mesh(
				THREE.SphereBufferGeometry( 100, 16, 8 ),//new THREE.SphereBufferGeometry( 100, 16, 8 ),
				THREE.MeshBasicMaterial( GWTParamUtils.MeshBasicMaterial().color(0xffffff).wireframe(true) )//new THREE.MeshBasicMaterial( { color: 0xffffff, wireframe: true } )
				);
				scene.add( mesh );

				Mesh mesh2 = THREE.Mesh(//var mesh2 = new THREE.Mesh(
				THREE.SphereBufferGeometry( 50, 16, 8 ),//new THREE.SphereBufferGeometry( 50, 16, 8 ),
				THREE.MeshBasicMaterial( GWTParamUtils.MeshBasicMaterial().color(0x00ff00).wireframe(true) )//new THREE.MeshBasicMaterial( { color: 0x00ff00, wireframe: true } )
				);
				mesh2.getPosition().setY(150);//mesh2.position.y = 150;
				mesh.add( mesh2 );

				Mesh mesh3 = THREE.Mesh(//var mesh3 = new THREE.Mesh(
				THREE.SphereBufferGeometry( 5, 16, 8 ),//new THREE.SphereBufferGeometry( 5, 16, 8 ),
				THREE.MeshBasicMaterial( GWTParamUtils.MeshBasicMaterial().color(0x0000ff).wireframe(true) )//new THREE.MeshBasicMaterial( { color: 0x0000ff, wireframe: true } )
				);
				mesh3.getPosition().setZ(150);//mesh3.position.z = 150;
				cameraRig.add( mesh3 );
		
				Geometry geometry = THREE.Geometry();//var geometry = new THREE.Geometry();

				for ( int i = 0; i < 10000; i ++ ) {

				Vector3 vertex = THREE.Vector3();//var vertex = new THREE.Vector3();
				vertex.setX(THREEMath.randFloatSpread( 2000 ));//vertex.x = THREE.Math.randFloatSpread( 2000 );
				vertex.setY(THREEMath.randFloatSpread( 2000 ));//vertex.y = THREE.Math.randFloatSpread( 2000 );
				vertex.setZ(THREEMath.randFloatSpread( 2000 ));//vertex.z = THREE.Math.randFloatSpread( 2000 );

				geometry.getVertices().push( vertex );//geometry.vertices.push( vertex );

				}

				Points particles = THREE.Points( geometry, THREE.PointsMaterial( GWTParamUtils.PointsMaterial().color(0x888888) ) );//var particles = new THREE.Points( geometry, new THREE.PointsMaterial( { color: 0x888888 } ) );
				scene.add( particles );
				
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML(
				"<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - cameras<br/><b>O</b> orthographic <b>P</b> perspective</div>"
				,100,10));
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		container.addKeyDownHandler(new KeyDownHandler() {
			
			@Override
			public void onKeyDown(KeyDownEvent event) {
				switch(event.getNativeKeyCode()){
				case 79: /*O*/

					activeCamera = cameraOrtho;
					activeHelper = cameraOrthoHelper;

					break;

				case 80: /*P*/

					activeCamera = cameraPerspective;
					activeHelper = cameraPerspectiveHelper;

					break;
				}
				
			}
		});
	}
	

	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
	}
	

	



	
	
	public void onWindowResize() {
		WIDTH=getWindowInnerWidth();
		HEIGHT=getWindowInnerHeight();
		renderer.setSize(WIDTH  ,HEIGHT);
		
		camera.setAspect(0.5 * getWindowInnerWidth() / getWindowInnerHeight());//camera.aspect = 0.5 * SCREEN_WIDTH / SCREEN_HEIGHT;
		camera.updateProjectionMatrix();

		cameraPerspective.setAspect(0.5 * getWindowInnerWidth() / getWindowInnerHeight());//cameraPerspective.aspect = 0.5 * SCREEN_WIDTH / SCREEN_HEIGHT;
		cameraPerspective.updateProjectionMatrix();

		cameraOrtho.setLeft(- 0.5 * WIDTH / 2);//cameraOrtho.left   = - 0.5 * SCREEN_WIDTH / 2;
		cameraOrtho.setRight(0.5 * WIDTH / 2);//cameraOrtho.right  =   0.5 * SCREEN_WIDTH / 2;
		cameraOrtho.setTop(HEIGHT / 2);//cameraOrtho.top    =   SCREEN_HEIGHT / 2;
		cameraOrtho.setBottom(- HEIGHT / 2);//cameraOrtho.bottom = - SCREEN_HEIGHT / 2;
		cameraOrtho.updateProjectionMatrix();
		
		
		
		
	
		 windowHalfX=(int) (getWindowInnerWidth()/2);
		 windowHalfY=(int) (getWindowInnerHeight()/2);
	}
	
	public void render(double now) {
		double r = now * 0.0005;

		mesh.getPosition().setX(700 * Math.cos( r ));//mesh.position.x = 700 * Math.cos( r );
		mesh.getPosition().setZ(700 * Math.sin( r ));//mesh.position.z = 700 * Math.sin( r );
		mesh.getPosition().setY(700 * Math.sin( r ));//mesh.position.y = 700 * Math.sin( r );

		mesh.getChildren().get(0).getPosition().setX(70 * Math.cos( 2 * r ));//mesh.children[ 0 ].position.x = 70 * Math.cos( 2 * r );
		mesh.getChildren().get(0).getPosition().setZ(70 * Math.sin( r ));//mesh.children[ 0 ].position.z = 70 * Math.sin( r );

		if ( activeCamera == cameraPerspective ) {

		cameraPerspective.setFov(35 + 30 * Math.sin( 0.5 * r ));//cameraPerspective.fov = 35 + 30 * Math.sin( 0.5 * r );
		cameraPerspective.setFar(mesh.getPosition().length());//cameraPerspective.far = mesh.position.length();
		cameraPerspective.updateProjectionMatrix();

		cameraPerspectiveHelper.update();
		cameraPerspectiveHelper.setVisible(true);//cameraPerspectiveHelper.visible = true;

		cameraOrthoHelper.setVisible(false);//cameraOrthoHelper.visible = false;

		} else {

		cameraOrtho.setFar(mesh.getPosition().length());//cameraOrtho.far = mesh.position.length();
		cameraOrtho.updateProjectionMatrix();

		cameraOrthoHelper.update();
		cameraOrthoHelper.setVisible(true);//cameraOrthoHelper.visible = true;

		cameraPerspectiveHelper.setVisible(false);//cameraPerspectiveHelper.visible = false;

		}

		cameraRig.lookAt( mesh.getPosition());//cameraRig.lookAt( mesh.position );

		renderer.clear();

		activeHelper.setVisible(false);//activeHelper.visible = false;

		renderer.setViewport( 0, 0, WIDTH/2, HEIGHT );
		renderer.render( scene, activeCamera );

		activeHelper.setVisible(true);//activeHelper.visible = true;

		renderer.setViewport( WIDTH/2, 0, WIDTH/2, HEIGHT );
		renderer.render( scene, camera );
		
	}

	@Override
	public String getTokenKey() {
		return "camera";
	}
}
