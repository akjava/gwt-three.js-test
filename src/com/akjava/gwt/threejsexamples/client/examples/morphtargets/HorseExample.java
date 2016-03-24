package com.akjava.gwt.threejsexamples.client.examples.morphtargets;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.math.THREEMath;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class HorseExample extends AbstractExample{

	@Override
	public String getName() {
		return "morphtargets/horse";
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
	
	
	private AnimationMixer mixer;
	
	private Vector3 target;
	@Override
	public void init() {
		FocusPanel container = createContainerPanel();
		
		camera = THREE.PerspectiveCamera( 50, getWindowInnerWidth() / getWindowInnerHeight(), 1, 10000 );//camera = new THREE.PerspectiveCamera( 50, window.innerWidth / window.innerHeight, 1, 10000 );
		camera.getPosition().setY(300);//camera.position.y = 300;
		
		target=THREE.Vector3( 0, 150, 0 );
		//camera target dead on r45
		//camera.setTarget(THREE.Vector3( 0, 150, 0 ));//camera.target = new THREE.Vector3( 0, 150, 0 );

		scene = THREE.Scene();//scene = new THREE.Scene();

		//

		DirectionalLight light = THREE.DirectionalLight( 0xefefff, 2 );//var light = new THREE.DirectionalLight( 0xefefff, 2 );
		light.getPosition().set( 1, 1, 1 ).normalize();//light.position.set( 1, 1, 1 ).normalize();
		scene.add( light );

		light = THREE.DirectionalLight( 0xffefef, 2 );//var light = new THREE.DirectionalLight( 0xffefef, 2 );
		light.getPosition().set( -1, -1, -1 ).normalize();//light.position.set( -1, -1, -1 ).normalize();
		scene.add( light );

		JSONLoader loader = THREE.JSONLoader( true );//var loader = new THREE.JSONLoader( true );
		loader.load( "models/animated/horse.js",new JSONLoadHandler() {
			

			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				Mesh mesh = THREE.Mesh( geometry, THREE.MeshLambertMaterial( GWTParamUtils.MeshLambertMaterial().color(0x606060).morphTargets(true) ) );//mesh = new THREE.Mesh( geometry, new THREE.MeshLambertMaterial( { color: 0x606060, morphTargets: true } ) );
				mesh.getScale().set( 1.5, 1.5, 1.5 );//mesh.scale.set( 1.5, 1.5, 1.5 );
				scene.add( mesh );

				
				mixer=THREE.AnimationMixer(mesh);
				
				AnimationClip clip=AnimationClip.CreateFromMorphTargetSequence( "gallop", geometry.getMorphTargets(), 30 );
				mixer.clipAction(clip).setDuration( 1 ).play();
				
				//animation = THREE.MorphAnimation( mesh );//animation = new THREE.MorphAnimation( mesh );
				//animation.play();
			}
		});
		
	


		// renderer

		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(false) );//renderer = new THREE.WebGLRenderer( { antialias: false } );
		renderer.setClearColor( 0xf0f0f0 );//renderer.setClearColor( scene.fog.color );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( (int)getWindowInnerWidth(), (int)getWindowInnerHeight()  );
		container.getElement().appendChild( renderer.getDomElement() );

		

		

		//animate();
		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<a href='http://threejs.org' target='_blank'>three.js</a> webgl - morph targets - horse. model by <a href='http://mirada.com/'>mirada</a> from <a href='http://ro.me'>rome</a>"
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
	
	
	
	
	private Stats stats;
	double theta;
	double prevTime=System.currentTimeMillis();
	double radius=600;
	public void render(double time) {//GWT animateFrame has time
		theta += 0.1;

		camera.getPosition().setX(radius * Math.sin( THREEMath.degToRad( theta ) ));//camera.position.x = radius * Math.sin( THREE.Math.degToRad( theta ) );
		camera.getPosition().setZ(radius * Math.cos( THREEMath.degToRad( theta ) ));//camera.position.z = radius * Math.cos( THREE.Math.degToRad( theta ) );

		camera.lookAt( target);//camera.lookAt( camera.target );

		if ( mixer!=null ) {

		

		mixer.update( (time - prevTime)* 0.001  );

		prevTime = time;

		}

		renderer.render( scene, camera );
	}

	@Override
	public String getTokenKey() {
		return "horse";
	}
}
