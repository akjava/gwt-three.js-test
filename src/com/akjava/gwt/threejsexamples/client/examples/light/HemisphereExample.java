package com.akjava.gwt.threejsexamples.client.examples.light;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.extras.Uniforms;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.geometries.PlaneBufferGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.SphereGeometry;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.lights.HemisphereLight;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.materials.ShaderMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.akjava.gwt.threejsexamples.client.resources.Bundles;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class HemisphereExample extends AbstractExample{

	@Override
	public String getName() {
		return "lights/hemisphere";
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

	
	
	Clock clock;
	private HemisphereLight hemiLight;
	private DirectionalLight dirLight;
	
	//better to use array for speed-up
	JsArray<AnimationMixer> mixers;
	@Override
	public void init() {
		
		mixers=JavaScriptObject.createArray().cast();
		
		clock=THREE.Clock();
		
		
		
		
	
		 WIDTH = (int)getWindowInnerWidth();
		 HEIGHT = (int)getWindowInnerHeight();

		FocusPanel container = createContainerPanel();
		
		// renderer
		
		
		// scene
		scene = THREE.Scene();
		scene.setFog(THREE.Fog( 0xffffff, 1, 5000 ));//scene.fog = new THREE.Fog( 0xffffff, 1, 5000 );
		scene.getFog().getColor().setHSL( 0.6, 0, 1 );//scene.fog.color.setHSL( 0.6, 0, 1 );
		
		// camera
		camera = THREE.PerspectiveCamera(30, getWindowInnerWidth()/getWindowInnerHeight(), 1, 5000);
		camera.getPosition().set(0, 0, 250);
		

		//light
		hemiLight = THREE.HemisphereLight( 0xffffff, 0xffffff, 0.6 );//hemiLight = new THREE.HemisphereLight( 0xffffff, 0xffffff, 0.6 );
		hemiLight.getColor().setHSL( 0.6, 1, 0.6 );//hemiLight.color.setHSL( 0.6, 1, 0.6 );
		hemiLight.getGroundColor().setHSL( 0.095, 1, 0.75 );//hemiLight.groundColor.setHSL( 0.095, 1, 0.75 );
		hemiLight.getPosition().set( 0, 500, 0 );//hemiLight.position.set( 0, 500, 0 );
		scene.add( hemiLight );

		//

		dirLight = THREE.DirectionalLight( 0xffffff, 1 );//dirLight = new THREE.DirectionalLight( 0xffffff, 1 );
		dirLight.getColor().setHSL( 0.1, 1, 0.95 );//dirLight.color.setHSL( 0.1, 1, 0.95 );
		dirLight.getPosition().set( -1, 1.75, 1 );//dirLight.position.set( -1, 1.75, 1 );
		dirLight.getPosition().multiplyScalar( 50 );//dirLight.position.multiplyScalar( 50 );
		scene.add( dirLight );

		dirLight.setCastShadow(true);//dirLight.castShadow = true;

		dirLight.setShadowMapWidth(2048);//dirLight.shadowMapWidth = 2048;
		dirLight.setShadowMapHeight(2048);//dirLight.shadowMapHeight = 2048;
		
		double d = 50;//var d = 50;

		dirLight.setShadowCameraLeft(-d);//dirLight.shadowCameraLeft = -d;
		dirLight.setShadowCameraRight(d);//dirLight.shadowCameraRight = d;
		dirLight.setShadowCameraTop(d);//dirLight.shadowCameraTop = d;
		dirLight.setShadowCameraBottom(-d);//dirLight.shadowCameraBottom = -d;

		dirLight.setShadowCameraFar(3500);//dirLight.shadowCameraFar = 3500;
		dirLight.setShadowBias(-0.0001);//dirLight.shadowBias = -0.0001;
		
		//ground
		PlaneBufferGeometry groundGeo = THREE.PlaneBufferGeometry( 10000, 10000 );//var groundGeo = new THREE.PlaneBufferGeometry( 10000, 10000 );
		MeshPhongMaterial groundMat = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff).specular(0x050505) );//var groundMat = new THREE.MeshPhongMaterial( { color: 0xffffff, specular: 0x050505 } );
		groundMat.getColor().setHSL( 0.095, 1, 0.75 );//groundMat.color.setHSL( 0.095, 1, 0.75 );

		Mesh ground = THREE.Mesh( groundGeo, groundMat );//var ground = new THREE.Mesh( groundGeo, groundMat );
		ground.getRotation().setX(-Math.PI/2);//ground.rotation.x = -Math.PI/2;
		ground.getPosition().setY(-33);//ground.position.y = -33;
		scene.add( ground );

		ground.setReceiveShadow(true);//ground.receiveShadow = true;

		
		String vertexShader=Bundles.INSTANCE.hemisphere_vertex_shader().getText();
		String fragmentShader=Bundles.INSTANCE.hemisphere_fragment_shader().getText();
		
		Uniforms uniforms=Uniforms.create()
				.setTypeAndValue("topColor", THREE.Color( 0x0077ff ))
				.setTypeAndValue("bottomColor", THREE.Color( 0xffffff ))
				.setTypeAndValue("offset", 33)
				.setTypeAndValue("exponent",  0.6 );
		
		uniforms.getColor("topColor").copy( hemiLight.getColor());//uniforms.topColor.value.copy( hemiLight.color );
		scene.getFog().getColor().copy( uniforms.getColor("bottomColor"));//scene.fog.color.copy( uniforms.bottomColor.value );
		
		
		SphereGeometry skyGeo = THREE.SphereGeometry( 4000, 32, 15 );//var skyGeo = new THREE.SphereGeometry( 4000, 32, 15 );
		ShaderMaterial skyMat = THREE.ShaderMaterial( GWTParamUtils.ShaderMaterial().vertexShader(vertexShader).fragmentShader(fragmentShader).uniforms(uniforms).side(THREE.BackSide) );//var skyMat = new THREE.ShaderMaterial( { vertexShader: vertexShader, fragmentShader: fragmentShader, uniforms: uniforms, side: THREE.BackSide } );

		Mesh sky = THREE.Mesh( skyGeo, skyMat );//var sky = new THREE.Mesh( skyGeo, skyMat );
		scene.add( sky );
		
		
		
		
		
		renderer = THREE.WebGLRenderer();
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( WIDTH, HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );

		renderer.setClearColor( scene.getFog().getColor());//renderer.setClearColor( scene.fog.color );
		renderer.setGammaInput(true);//renderer.gammaInput = true;
		renderer.setGammaOutput(true);//renderer.gammaOutput = true;

		renderer.getShadowMap().setEnabled(true);//renderer.shadowMap.enabled = true;
		renderer.getShadowMap().setCullFace(THREE.CullFaceBack);//renderer.shadowMap.cullFace = THREE.CullFaceBack;
		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - webgl hemisphere light example - flamingo by mirada from rome</a><br>press h to toggle hemisphere light, d to toggle directional light"
				,100,10));
		
		container.addKeyDownHandler(new KeyDownHandler() {
			
			@Override
			public void onKeyDown(KeyDownEvent event) {
				switch ( event.getNativeKeyCode() ) {

				case 72: // h
					hemiLight.setVisible(!hemiLight.isVisible());
				//hemiLight.visible = !hemiLight.visible;
				break;

				case 68: // d
					dirLight.setVisible(!dirLight.isVisible());
				//dirLight.visible = !dirLight.visible;
				break;

				}
			}
		});
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		JSONLoader loader=THREE.JSONLoader();
		loader.load("models/animated/flamingo.js", new JSONLoadHandler() {
			
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				MeshPhongMaterial material = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff).specular(0xffffff).shininess(20).morphTargets(true).vertexColors(THREE.FaceColors).shading(THREE.FlatShading) );//var material = new THREE.MeshPhongMaterial( { color: 0xffffff, specular: 0xffffff, shininess: 20, morphTargets: true, vertexColors: THREE.FaceColors, shading: THREE.FlatShading } );
				Mesh mesh = THREE.Mesh( geometry, material );//var mesh = new THREE.Mesh( geometry, material );

				double s = 0.35;//var s = 0.35;
				mesh.getScale().set( s, s, s );//mesh.scale.set( s, s, s );
				mesh.getPosition().setY(15);//mesh.position.y = 15;
				mesh.getRotation().setY(-1);//mesh.rotation.y = -1;

				mesh.setCastShadow(true);//mesh.castShadow = true;
				mesh.setReceiveShadow(true);//mesh.receiveShadow = true;

				scene.add( mesh );

				AnimationMixer mixer = THREE.AnimationMixer( mesh );//var mixer = new THREE.AnimationMixer( mesh );
				mixer.addAction( THREE.AnimationAction( geometry.getAnimations().get(0) ).warpToDuration( 1 ) );//mixer.addAction( new THREE.AnimationAction( geometry.animations[ 0 ] ).warpToDuration( 1 ) );
				mixers.push( mixer );
			}
		});
		
	}
	

	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
	}
	

	



	
	
	public void onWindowResize() {
		
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
		
	}
	
	public void render(double now) {
		double delta = clock.getDelta();

		for ( int i = 0; i < mixers.length(); i ++ ) {
			mixers.get(i).update( delta );

		}
		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "hemisphere";
	}
}
