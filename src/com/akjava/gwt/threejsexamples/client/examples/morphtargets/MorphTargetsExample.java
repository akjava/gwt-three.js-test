package com.akjava.gwt.threejsexamples.client.examples.morphtargets;

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.extras.geometries.BoxGeometry;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.materials.MeshLambertMaterial;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.LabeledInputRangeWidget;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;


public class MorphTargetsExample extends AbstractExample{

	@Override
	public String getName() {
		return "morphtargets";
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
	
	
	private int windowHalfX,windowHalfY;
	private int mouseX,mouseY;
	@Override
	public void init() {
		FocusPanel container = createContainerPanel();
		
		windowHalfX=(int) (getWindowInnerWidth()/2);
		windowHalfY=(int) (getWindowInnerHeight()/2);
		
		container.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				onDocumentMouseMove(event);
			}
		});
		
		camera = THREE.PerspectiveCamera( 45, getWindowInnerWidth() / getWindowInnerHeight(), 1, 15000 );//camera = new THREE.PerspectiveCamera( 45, window.innerWidth / window.innerHeight, 1, 15000 );
		camera.getPosition().setZ(500);//camera.position.z = 500;

		scene = THREE.Scene();//scene = new THREE.Scene();
		scene.setFog(THREE.Fog( 0x000000, 1, 15000 ));//scene.fog = new THREE.Fog( 0x000000, 1, 15000 );

		Light light = THREE.PointLight( 0xff2200 );//var light = new THREE.PointLight( 0xff2200 );
		light.getPosition().set( 100, 100, 100 );//light.position.set( 100, 100, 100 );
		scene.add( light );

		light = THREE.AmbientLight( 0x111111 );//var light = new THREE.AmbientLight( 0x111111 );
		scene.add( light );


		BoxGeometry geometry = THREE.BoxGeometry( 100, 100, 100 );//var geometry = new THREE.BoxGeometry( 100, 100, 100 );
		MeshLambertMaterial material = THREE.MeshLambertMaterial( GWTParamUtils.MeshLambertMaterial().color(0xffffff).morphTargets(true) );//var material = new THREE.MeshLambertMaterial( { color: 0xffffff, morphTargets: true } );

		// construct 8 blend shapes

		for ( int i = 0; i < geometry.getVertices().length(); i ++ ) {//for ( var i = 0; i < geometry.vertices.length; i ++ ) {

		JsArray<Vector3> vertices = JavaScriptUtils.createJSArray().cast();//var vertices = [];

		for ( int v = 0; v < geometry.getVertices().length(); v ++ ) {//for ( var v = 0; v < geometry.vertices.length; v ++ ) {

		vertices.push( geometry.getVertices().get( v ).clone() );

		if ( v == i ) {
			vertices.get(v).multiplyScalar(2);//only 1 vertex changed on each morph-target,each one linked slider
		}

		}

		geometry.getMorphTargets().push( GWTParamUtils.MorphTarget().name("target" + i).vertices(vertices) );//geometry.morphTargets.push( { name: "target" + i, vertices: vertices } );

		}

		mesh = THREE.Mesh( geometry, material );

		scene.add( mesh );
		
		
	


		// renderer

		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(false) );//renderer = new THREE.WebGLRenderer( { antialias: false } );
		renderer.setClearColor( 0x222222 );//renderer.setClearColor( scene.fog.color );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( (int)getWindowInnerWidth(), (int)getWindowInnerHeight()  );
		container.getElement().appendChild( renderer.getDomElement() );
		renderer.setSortObjects(true);
		

				
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='color:white'><a href='http://threejs.org' target='_blank'>three.js</a> - WebGL morph target example</div>"
				,100,10));
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		
		//setDebugAnimateOneTimeOnly(true);
	}
	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		//gui.setVisible(false);//no need?
		
		gui.add(new Label("Target morph influence"));
		//TODO add  8 slider
		for( int i=0;i<8;i++){
		LabeledInputRangeWidget slider=new LabeledInputRangeWidget("vertex "+i,0,1.0,0.01);
		gui.add(slider);
		slider.setValue(0);//default
		final int index=i;
		slider.addtRangeListener(new ValueChangeHandler<Number>() {
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				mesh.getMorphTargetInfluences().set(index, event.getValue().doubleValue());
			}
		});
		}
	}
	

	



	protected void onDocumentMouseMove(MouseMoveEvent event) {
		mouseX = ( event.getClientX() - windowHalfX );
		mouseY = ( event.getClientY() - windowHalfY )*2;
	}
	
	public void onWindowResize() {
		windowHalfX=(int) (getWindowInnerWidth()/2);
		windowHalfY=(int) (getWindowInnerHeight()/2);
		

		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
	}
	
	
	
	
	private Stats stats;

	private Mesh mesh;
	public void render(double time) {//GWT animateFrame has time
		 mesh.getRotation().gwtIncrementY(0.01);//mesh.rotation.y += 0.01;
		camera.getPosition().gwtIncrementY(( - mouseY - camera.getPosition().getY()) * .01);//camera.position.y += ( - mouseY - camera.position.y ) * .01;
		
		camera.lookAt(scene.getPosition());
		renderer.render( scene, camera );
	}

	@Override
	public String getTokenKey() {
		return "morphtargets";
	}
}
