package com.akjava.gwt.threejsexamples.client.examples.postprocessing;

import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.postprocessing.EffectComposer;
import com.akjava.gwt.three.client.examples.js.postprocessing.GlitchPass;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.extras.geometries.SphereGeometry;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class GlitchExample extends AbstractExample{

	@Override
	public String getName() {
		return "postprocessing/glitch";
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
	private Object3D object;
	private DirectionalLight light;
	private EffectComposer composer;
	private GlitchPass glitchPass;

	
	

	
	@Override
	public void init() {
	
		 WIDTH = (int)getWindowInnerWidth();
		 HEIGHT = (int)getWindowInnerHeight();

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer();
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( WIDTH, HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );

		// camera
		camera = THREE.PerspectiveCamera(70, getWindowInnerWidth()/getWindowInnerHeight(), 1, 1000);
		camera.getPosition().set(0, 0, 400);
		camera.lookAt(THREE.Vector3());
		
		// scene
		scene = THREE.Scene();
		scene.setFog(THREE.Fog( 0x000000, 1, 1000 ));//scene.fog = new THREE.Fog( 0x000000, 1, 1000 );

		object = THREE.Object3D();//object = new THREE.Object3D();
		scene.add( object );

		SphereGeometry geometry = THREE.SphereGeometry( 1, 4, 4 );//var geometry = new THREE.SphereGeometry( 1, 4, 4 );
		MeshPhongMaterial material = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff).shading(THREE.FlatShading) );//var material = new THREE.MeshPhongMaterial( { color: 0xffffff, shading: THREE.FlatShading } );
	
		for ( int i = 0; i < 100; i ++ ) {
			material = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color((int)(0xffffff * Math.random())).shading(THREE.FlatShading) );//material = new THREE.MeshPhongMaterial( { color: 0xffffff * Math.random(), shading: THREE.FlatShading } );

			Mesh mesh = THREE.Mesh( geometry, material );//var mesh = new THREE.Mesh( geometry, material );
			mesh.getPosition().set( Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5 ).normalize();//mesh.position.set( Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5 ).normalize();
			mesh.getPosition().multiplyScalar( Math.random() * 400 );//mesh.position.multiplyScalar( Math.random() * 400 );
			mesh.getRotation().set( Math.random() * 2, Math.random() * 2, Math.random() * 2 );//mesh.rotation.set( Math.random() * 2, Math.random() * 2, Math.random() * 2 );
			
			double r=Math.random() * 50;
			mesh.getScale().set(r,r,r);
			
			object.add( mesh );

			}

			scene.add( THREE.AmbientLight( 0x222222 ) );//scene.add( new THREE.AmbientLight( 0x222222 ) );

			light = THREE.DirectionalLight( 0xffffff );//light = new THREE.DirectionalLight( 0xffffff );
			light.getPosition().set( 1, 1, 1 );//light.position.set( 1, 1, 1 );
			scene.add( light );
		
	
			composer = THREEExp.EffectComposer( renderer );//composer = new THREE.EffectComposer( renderer );
			composer.addPass( THREEExp.RenderPass( scene, camera ) );//composer.addPass( new THREE.RenderPass( scene, camera ) );

			glitchPass = THREEExp.GlitchPass();//glitchPass = new THREE.GlitchPass();
			glitchPass.setRenderToScreen(true);//glitchPass.renderToScreen = true;
			composer.addPass( glitchPass );
		
		
		

		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - test</a>"
				,100,10));
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		
	}
	

	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
		CheckBox check=new CheckBox("Glitch me wild");
		check.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				glitchPass.setGoWild(event.getValue());
			}
		});
		gui.add(check);
	}
	

	



	
	
	public void onWindowResize() {
		
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
		
	}
	
	public void render(double now) {
		object.getRotation().gwtIncrementX(0.005);//object.rotation.x += 0.005;
		object.getRotation().gwtIncrementY(0.01);//object.rotation.y += 0.01;
		
		composer.render();
	}

	@Override
	public String getTokenKey() {
		return "glitch";
	}
}
