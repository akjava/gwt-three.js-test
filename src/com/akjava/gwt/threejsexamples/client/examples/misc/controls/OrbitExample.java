package com.akjava.gwt.threejsexamples.client.examples.misc.controls;

import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.controls.OrbitControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.extras.geometries.CylinderGeometry;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.materials.MeshLambertMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class OrbitExample extends AbstractExample{

	@Override
	public String getName() {
		return "misc/controls/orbit";
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
	
	
	private OrbitControls controls;
	private Light light;
	@Override
	public void init() {
		FocusPanel container = createContainerPanel();
		
		camera = THREE.PerspectiveCamera( 60, getWindowInnerWidth() / getWindowInnerHeight(), 1, 1000 );//camera = new THREE.PerspectiveCamera( 60, window.innerWidth / window.innerHeight, 1, 1000 );
		camera.getPosition().setZ(500);//camera.position.z = 500;

		controls = THREEExp.OrbitControls( camera,container.getElement() );//controls = new THREE.OrbitControls( camera );
		//controls.setDamping(0.2);//controls.damping = 0.2;
		//controls.addEventListener( 'change', render );

		scene = THREE.Scene();//scene = new THREE.Scene();
		scene.setFog(THREE.FogExp2( 0xcccccc, 0.002 ));//scene.fog = new THREE.FogExp2( 0xcccccc, 0.002 );

		// world

		CylinderGeometry geometry = THREE.CylinderGeometry( 0, 10, 30, 4, 1 );//var geometry = new THREE.CylinderGeometry( 0, 10, 30, 4, 1 );
		MeshLambertMaterial material =  THREE.MeshLambertMaterial( GWTParamUtils.MeshLambertMaterial().color(0xffffff).shading(THREE.FlatShading) );//var material =  new THREE.MeshLambertMaterial( { color:0xffffff, shading: THREE.FlatShading } );

		for ( int i = 0; i < 500; i ++ ) {

		Mesh mesh = THREE.Mesh( geometry, material );//var mesh = new THREE.Mesh( geometry, material );
		mesh.getPosition().setX(( Math.random() - 0.5 ) * 1000);//mesh.position.x = ( Math.random() - 0.5 ) * 1000;
		mesh.getPosition().setY(( Math.random() - 0.5 ) * 1000);//mesh.position.y = ( Math.random() - 0.5 ) * 1000;
		mesh.getPosition().setZ(( Math.random() - 0.5 ) * 1000);//mesh.position.z = ( Math.random() - 0.5 ) * 1000;
		mesh.updateMatrix();
		mesh.setMatrixAutoUpdate(false);//mesh.matrixAutoUpdate = false;
		scene.add( mesh );

		}


		// lights

		light = THREE.DirectionalLight( 0xffffff );//light = new THREE.DirectionalLight( 0xffffff );
		light.getPosition().set( 1, 1, 1 );//light.position.set( 1, 1, 1 );
		scene.add( light );

		light = THREE.DirectionalLight( 0x002288 );//light = new THREE.DirectionalLight( 0x002288 );
		light.getPosition().set( -1, -1, -1 );//light.position.set( -1, -1, -1 );
		scene.add( light );

		light = THREE.AmbientLight( 0x222222 );//light = new THREE.AmbientLight( 0x222222 );
		scene.add( light );


		// renderer

		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(false) );//renderer = new THREE.WebGLRenderer( { antialias: false } );
		renderer.setClearColor( scene.getFog().getColor() );//renderer.setClearColor( scene.fog.color );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( (int)getWindowInnerWidth(), (int)getWindowInnerHeight()  );

		
		container.getElement().appendChild( renderer.getDomElement() );

		

		

		//animate();
		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<a href='http://threejs.org' target='_blank'>three.js</a> - orbit controls example"
				,100,10));
		
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
	public void render(double now) {//GWT animateFrame has time
		renderer.render( scene, camera );
	}

	@Override
	public String getTokenKey() {
		return "orbit";
	}
}
