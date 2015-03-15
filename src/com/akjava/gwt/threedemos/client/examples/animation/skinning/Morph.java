package com.akjava.gwt.threedemos.client.examples.animation.skinning;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.animation.AnimationData;
import com.akjava.gwt.three.client.gwt.animation.AnimationHierarchyItem;
import com.akjava.gwt.three.client.gwt.animation.AnimationKey;
import com.akjava.gwt.three.client.gwt.core.BoundingBox;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.BufferGeometry;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.animation.Animation;
import com.akjava.gwt.three.client.js.extras.animation.AnimationHandler;
import com.akjava.gwt.three.client.js.extras.helpers.SkeletonHelper;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.math.ThreeMath;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threedemos.client.AbstractDemo;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Morph extends AbstractDemo{

	@Override
	public String getName() {
		return "animation/skinning/morph";
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
	
	
	
	Clock clock = THREE.Clock();
	
	SkeletonHelper helper;
	private int windowHalfX,windowHalfY;
	private int mouseX,mouseY;
	@Override
	public void init() {
		
		int SCREEN_WIDTH=getWindowInnerWidth();
		int SCREEN_HEIGHT=getWindowInnerHeight();
		
		windowHalfX=SCREEN_WIDTH/2;
		windowHalfY=SCREEN_HEIGHT/2;
		
		
		
		final int FLOOR = -250;
		
		FocusPanel container = new FocusPanel();//TODO method?
		getParent().add(container);
		
		container.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				onDocumentMouseMove(event);
			}
		});
		/*
		 * no need make dummy html panel?
		HTMLPanel div=new HTMLPanel(""); 
		div.getElement().appendChild(renderer.getDomElement());
		focusPanel.add(div);
		*/
		LogUtils.log(SCREEN_WIDTH+","+SCREEN_HEIGHT);
		
		//critical problem without cast value is Integer!!!
		camera = THREE.PerspectiveCamera( 30, (double)SCREEN_WIDTH / SCREEN_HEIGHT, 1, 10000 );
		camera.getPosition().setZ(2200);
		
		
		scene = THREE.Scene();

		scene.setFog(THREE.Fog( 0xffffff, 2000, 10000 ));

		scene.add( camera );
		// GROUND

		BufferGeometry geometry = THREE.PlaneBufferGeometry( 16000, 16000 );
		Material material = THREE.MeshPhongMaterial(GWTParamUtils.MeshPhongMaterial().emissive(0xbbbbbb));
		
		Mesh ground =  THREE.Mesh( geometry, material );
		ground.getPosition().set( 0, FLOOR, 0 );
		ground.getRotation().setX(-Math.PI/2);
		scene.add( ground );

		ground.setReceiveShadow(true);
		
		// LIGHTS

		Light ambient = THREE.AmbientLight( 0x222222 );
		scene.add( ambient );


		
		DirectionalLight light = THREE.DirectionalLight( 0xebf3ff, 1.6 );
		light.getPosition().set( 0, 140, 500 ).multiplyScalar( 1.1 );
		scene.add( light );
		
		light.setCastShadow(true);

		light.setShadowMapWidth(1024);
		light.setShadowMapHeight(2048);

		int d = 390;
		light.setShadowCameraLeft(-d);
		light.setShadowCameraRight(d);
		light.setShadowCameraTop(d * 1.5);
		light.setShadowCameraBottom(-d);

		light.setShadowCameraFar(3500);
		//light.shadowCameraVisible = true;

		//
		light = THREE.DirectionalLight( 0x497f13, 1 );
		light.getPosition().set( 0, -1, 0 );
		scene.add( light );
		
		renderer = THREE.WebGLRenderer(GWTParamUtils.WebGLRenderer().antialias(true));
		renderer.setClearColor( scene.getFog().getColor());
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio());
		renderer.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		container.getElement().appendChild(renderer.getDomElement());

		renderer.setGammaInput(true);
		renderer.setGammaOutput(true);

		renderer.setShadowMapEnabled(true);
		
		JSONLoader loader =  THREE.JSONLoader();
		loader.load( "models/skinned/knight.js",new JSONLoadHandler() {
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				createScene( geometry, materials, 0, FLOOR, -300, 60 );
			}
		});
		
		
		
		stats = Stats.create();
		container.getElement().appendChild(stats.domElement());
		
		
		initGUI();
		
		/*

				// STATS

				stats = new Stats();
				container.appendChild( stats.domElement );

				//

				// GUI

				

				//

				window.addEventListener( 'resize', onWindowResize, false );
		 */
		
		//resize event catch super class ,just implement onWindowResize method
		
	}
	

	private void initGUI() {
		VerticalPanel gui=createGUIPanel();
		
		CheckBox model=new CheckBox("show model");
		model.setValue(true);
		model.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				mesh.setVisible(event.getValue());
			}
		});
		gui.add(model);
		
		
		CheckBox bone=new CheckBox("how skeleton");
		bone.setValue(false);
		bone.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				helper.setVisible(event.getValue());
			}
		});
		gui.add(bone);
	}
	

	


	protected void onDocumentMouseMove(MouseMoveEvent event) {
		mouseX = ( event.getClientX() - windowHalfX );
		mouseY = ( event.getClientY() - windowHalfY );
	}

	public int getWindowInnerWidth(){
		return getParent().getOffsetWidth();
	}
	
	public int getWindowInnerHeight(){
		return getParent().getOffsetHeight();
	}
	
	
	
	public void onWindowResize() {
		//LogUtils.log(getWindowInnerWidth()+"x"+getWindowInnerHeight());//right?
		windowHalfX = getWindowInnerWidth() / 2;
		windowHalfY = getWindowInnerHeight() / 2;

		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( getWindowInnerWidth() , getWindowInnerHeight() );
	}
	
	
	
	public void ensureLoop(AnimationData animation ) {
		for ( int i = 0; i < animation.getHierarchy().length(); i ++ ) {

			AnimationHierarchyItem bone = animation.getHierarchy().get(i);

			AnimationKey first = bone.getKeys().get(0);
			AnimationKey last = bone.getKeys().get(bone.getKeys().length() - 1 );

			last.setPos(first.getPos());
			last.setRot(first.getRot());
			last.setScl(first.getScl());
		}

	}

	protected void createScene(Geometry geometry, JsArray<Material> materials, int x, int y, int z, int s) {

		ensureLoop( geometry.getAnimation() );

		geometry.computeBoundingBox();
		BoundingBox bb = geometry.getBoundingBox();

		String path = "textures/cube/Park2/";
		String format = ".jpg";
		String[] urls = new String[]{
				path + "posx" + format, path + "negx" + format,
				path + "posy" + format, path + "negy" + format,
				path + "posz" + format, path + "negz" + format
		};


		//var envMap = THREE.ImageUtils.loadTextureCube( urls );

		//var map = THREE.ImageUtils.loadTexture( "textures/UV_Grid_Sm.jpg" );

		//var bumpMap = THREE.ImageUtils.generateDataTexture( 1, 1, new THREE.Color() );
		//var bumpMap = THREE.ImageUtils.loadTexture( "textures/water.jpg" );

		for ( int i = 0; i < materials.length(); i ++ ) {

			MeshPhongMaterial m = materials.get( i ).cast();//how to know this
			m.setSkinning(true);
			m.setMorphTargets(true);

			m.getSpecular().setHSL( 0, 0, 0.1 );

			m.getColor().setHSL( 0.6, 0, 0.6 );
			m.getAmbient().copy( m.getColor() );

			//m.map = map;
			//m.envMap = envMap;
			//m.bumpMap = bumpMap;
			//m.bumpScale = 2;

			//m.combine = THREE.MixOperation;
			//m.reflectivity = 0.75;

			m.setWrapAround(true);

		}

		mesh = THREE.SkinnedMesh( geometry, THREE.MeshFaceMaterial( materials ) );
		mesh.getPosition().set( x, y - bb.getMin().getY() * s, z );
		mesh.getScale().set( s, s, s );
		scene.add( mesh );

		mesh.setCastShadow(true);
		mesh.setReceiveShadow(true);

		helper = THREE.SkeletonHelper( mesh );
		helper.gwtGetMaterial().setLinewidth(3);//TODO cheat way,helper.getMaterila().set("lineWidth",3);
		helper.setVisible(false);
		scene.add( helper );

		Animation animation = THREE.Animation( mesh, geometry.getAnimation() );
		animation.play();
	}
	
	Mesh mesh;
	private Stats stats;
	public void render(double now) {//GWT animateFrame has time
		double delta = 0.75 * clock.getDelta();
		
		camera.getPosition().gwtIncrementX( (mouseX - camera.getPosition().getX() ) * .05);
		camera.getPosition().setY(ThreeMath.clamp( camera.getPosition().getY() + ( - mouseY - camera.getPosition().getY() ) * .05, 0, 1000 ));
		camera.lookAt( scene.getPosition() );
		AnimationHandler.update( delta );

		if ( helper !=null ) helper.update();
		
		// update morphs

		if ( mesh!=null ) {//loaded

			double time = now * 0.001;

			// mouth

			//TODO
			
			mesh.getMorphTargetInfluences().set(1, ( 1 + Math.sin( 4 * time ) ) / 2);

			// frown ?

			mesh.getMorphTargetInfluences().set( 2 ,( 1 + Math.sin( 2 * time ) ) / 2);

			// eyes

			mesh.getMorphTargetInfluences().set( 3 , ( 1 + Math.cos( 4 * time ) ) / 2);

		}

		renderer.render( scene, camera );
	}

}
