package com.akjava.gwt.threejsexamples.client.examples.postprocessing;

import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.postprocessing.BloomPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.ClearMaskPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.DotScreenPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.EffectComposer;
import com.akjava.gwt.three.client.examples.js.postprocessing.FilmPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.MaskPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.RenderPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.ShaderPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.TexturePass;
import com.akjava.gwt.three.client.examples.js.shaders.ExampleShaders;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.extras.Shader;
import com.akjava.gwt.three.client.gwt.renderers.WebGLRenderTargetParameter;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.OrthographicCamera;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.materials.MeshBasicMaterial;
import com.akjava.gwt.three.client.js.materials.MeshLambertMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class AdvancedExample extends AbstractExample{

	@Override
	public String getName() {
		return "processing/advanced";
	}

	@Override
	public void animate(double timestamp) {

		render(timestamp);
		stats.update();//really deprecate?many still use this
	}

	private WebGLRenderer renderer;
	private Scene scene;

	private Stats stats;

	int WIDTH;
	int HEIGHT;
	
	int halfWidth,halfHeight;
	private OrthographicCamera cameraOrtho;
	private PerspectiveCamera cameraPerspective;
	private Scene sceneModel;
	private Scene sceneBG;
	private DirectionalLight directionalLight;
	private JSONLoader loader;
	private Mesh quadBG;
	private Mesh quadMask;
	private EffectComposer composerScene;
	private TexturePass renderScene;
	private EffectComposer composer1;
	private EffectComposer composer2;
	private EffectComposer composer3;
	private EffectComposer composer4;

	@Override
	public void init() {
	
		 WIDTH = (int)getWindowInnerWidth();
		 HEIGHT = (int)getWindowInnerHeight();
		 
		 halfWidth=(int) (getWindowInnerWidth()/2);
		 halfHeight=(int) (getWindowInnerHeight()/2);

		FocusPanel container = createContainerPanel();
		
		
		// scene
		scene = THREE.Scene();
	


		cameraOrtho = THREE.OrthographicCamera( -halfWidth, halfWidth, halfHeight, -halfHeight, -10000, 10000 );//cameraOrtho = new THREE.OrthographicCamera( -halfWidth, halfWidth, halfHeight, -halfHeight, -10000, 10000 );
		cameraOrtho.getPosition().setZ(100);//cameraOrtho.position.z = 100;

		cameraPerspective = THREE.PerspectiveCamera( 50, getWindowInnerWidth() / getWindowInnerHeight(), 1, 10000 );//cameraPerspective = new THREE.PerspectiveCamera( 50, width / height, 1, 10000 );
		cameraPerspective.getPosition().setZ(900);//cameraPerspective.position.z = 900;

		//

		sceneModel = THREE.Scene();//sceneModel = new THREE.Scene();
		sceneBG = THREE.Scene();//sceneBG = new THREE.Scene();

		//

		directionalLight = THREE.DirectionalLight( 0xffffff );//directionalLight = new THREE.DirectionalLight( 0xffffff );
		directionalLight.getPosition().set( 0, -0.1, 1 ).normalize();//directionalLight.position.set( 0, -0.1, 1 ).normalize();
		sceneModel.add( directionalLight );

		loader = THREE.JSONLoader( true );//loader = new THREE.JSONLoader( true );
		container.getElement().appendChild(loader.getStatusDomElement());
		
		loader.load("obj/leeperrysmith/LeePerrySmith.js", new JSONLoadHandler() {
			
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				createMesh( geometry, sceneModel, 100 );
			}
		});
		MeshBasicMaterial materialColor = THREE.MeshBasicMaterial( GWTParamUtils.MeshBasicMaterial().map(ImageUtils.loadTexture( "textures/cube/SwedishRoyalCastle/pz.jpg" )).depthTest(false) );//var materialColor = new THREE.MeshBasicMaterial( {map: THREE.ImageUtils.loadTexture( "textures/cube/SwedishRoyalCastle/pz.jpg" ),depthTest: false} );
		quadBG = THREE.Mesh( THREE.PlaneBufferGeometry( 1, 1 ), materialColor );//quadBG = new THREE.Mesh( new THREE.PlaneBufferGeometry( 1, 1 ), materialColor );
		quadBG.getPosition().setZ(-500);//quadBG.position.z = -500;
		quadBG.getScale().set( WIDTH, HEIGHT, 1 );//quadBG.scale.set( width, height, 1 );
		sceneBG.add( quadBG );

		//

		Scene sceneMask = THREE.Scene();//var sceneMask = new THREE.Scene();

		quadMask = THREE.Mesh( THREE.PlaneBufferGeometry( 1, 1 ), THREE.MeshBasicMaterial( GWTParamUtils.MeshBasicMaterial().color(0xffaa00) )  );//quadMask = new THREE.Mesh( new THREE.PlaneBufferGeometry( 1, 1 ), new THREE.MeshBasicMaterial( { color: 0xffaa00 } )  );
		quadMask.getPosition().setZ(-300);//quadMask.position.z = -300;
		quadMask.getScale().set( (double)WIDTH / 2, (double)HEIGHT / 2, 1 );//quadMask.scale.set( width / 2, height / 2, 1 );
		sceneMask.add( quadMask );

		//

		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(false) );//renderer = new THREE.WebGLRenderer( { antialias: false } );
		renderer.setClearColor( 0x000000 );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );//renderer.setPixelRatio( window.devicePixelRatio );
		renderer.setSize( WIDTH, HEIGHT );
		renderer.setAutoClear(false);//renderer.autoClear = false;
		container.getElement().appendChild( renderer.getDomElement() );
		//

		renderer.setGammaInput(true);//renderer.gammaInput = true;
		renderer.setGammaOutput(true);//renderer.gammaOutput = true;
		
		
		Shader shaderBleach = ExampleShaders.BleachBypassShader();
		Shader shaderSepia = ExampleShaders.SepiaShader();
		Shader shaderVignette = ExampleShaders.VignetteShader();
		Shader shaderCopy = ExampleShaders.CopyShader();

		ShaderPass effectBleach = THREEExp.ShaderPass( shaderBleach );//var effectBleach = new THREE.ShaderPass( shaderBleach );
		ShaderPass effectSepia = THREEExp.ShaderPass( shaderSepia );//var effectSepia = new THREE.ShaderPass( shaderSepia );
		ShaderPass effectVignette = THREEExp.ShaderPass( shaderVignette );//var effectVignette = new THREE.ShaderPass( shaderVignette );
		ShaderPass effectCopy = THREEExp.ShaderPass( shaderCopy );//var effectCopy = new THREE.ShaderPass( shaderCopy );
		

		effectBleach.getUniforms().set("opacity",0.95);//effectBleach.uniforms[ "opacity" ].value = 0.95;

		effectSepia.getUniforms().set("amount",0.9);//effectSepia.uniforms[ "amount" ].value = 0.9;

		effectVignette.getUniforms().set("offset",0.95);//effectVignette.uniforms[ "offset" ].value = 0.95;
		effectVignette.getUniforms().set("darkness",1.6);//effectVignette.uniforms[ "darkness" ].value = 1.6;
		
		BloomPass effectBloom = THREEExp.BloomPass( 0.5 );//var effectBloom = new THREE.BloomPass( 0.5 );
		FilmPass effectFilm = THREEExp.FilmPass( 0.35, 0.025, 648, false );//var effectFilm = new THREE.FilmPass( 0.35, 0.025, 648, false );
		FilmPass effectFilmBW = THREEExp.FilmPass( 0.35, 0.5, 2048, true );//var effectFilmBW = new THREE.FilmPass( 0.35, 0.5, 2048, true );
		DotScreenPass effectDotScreen = THREEExp.DotScreenPass( THREE.Vector2( 0, 0 ), 0.5, 0.8 );//var effectDotScreen = new THREE.DotScreenPass( new THREE.Vector2( 0, 0 ), 0.5, 0.8 );

		ShaderPass effectHBlur = THREEExp.ShaderPass( ExampleShaders.HorizontalBlurShader() );//var effectHBlur = new THREE.ShaderPass( THREE.HorizontalBlurShader );
		ShaderPass effectVBlur = THREEExp.ShaderPass( ExampleShaders.VerticalBlurShader() );//var effectVBlur = new THREE.ShaderPass( THREE.VerticalBlurShader );
		effectHBlur.getUniforms().set("h",(double)2 / ((double) WIDTH / 2 ));//effectHBlur.uniforms[ 'h' ].value = 2 / ( width / 2 );
		effectVBlur.getUniforms().set("v",(double)2 / ( (double)HEIGHT / 2 ));//effectVBlur.uniforms[ 'v' ].value = 2 / ( height / 2 );

		ShaderPass effectColorify1 = THREEExp.ShaderPass( ExampleShaders.ColorifyShader() );//var effectColorify1 = new THREE.ShaderPass( THREE.ColorifyShader );
		ShaderPass effectColorify2 = THREEExp.ShaderPass( ExampleShaders.ColorifyShader() );//var effectColorify2 = new THREE.ShaderPass( THREE.ColorifyShader );
		effectColorify1.getUniforms().setRGB("color",1, 0.8, 0.8);//effectColorify1.uniforms[ 'color' ].value.setRGB( 1, 0.8, 0.8 );
		effectColorify2.getUniforms().setRGB("color",1, 0.75, 0.5);//effectColorify2.uniforms[ 'color' ].value.setRGB( 1, 0.75, 0.5 );

		ClearMaskPass clearMask = THREEExp.ClearMaskPass();//var clearMask = new THREE.ClearMaskPass();
		MaskPass renderMask = THREEExp.MaskPass( sceneModel, cameraPerspective );//var renderMask = new THREE.MaskPass( sceneModel, cameraPerspective );
		MaskPass renderMaskInverse = THREEExp.MaskPass( sceneModel, cameraPerspective );//var renderMaskInverse = new THREE.MaskPass( sceneModel, cameraPerspective );

		renderMaskInverse.setInverse(true);//renderMaskInverse.inverse = true;

		effectVignette.setRenderToScreen(true);//effectVignette.renderToScreen = true;
		
		
		
		double rtWidth  = (double)WIDTH / 2;
		double rtHeight = (double)HEIGHT / 2;

		//

		WebGLRenderTargetParameter rtParameters = GWTParamUtils.WebGLRenderTarget().minFilter(THREE.LinearFilter).magFilter(THREE.LinearFilter).format(THREE.RGBFormat).stencilBuffer(true);
		
		RenderPass renderBackground = THREEExp.RenderPass( sceneBG, cameraOrtho );//var renderBackground = new THREE.RenderPass( sceneBG, cameraOrtho );
		RenderPass renderModel = THREEExp.RenderPass( sceneModel, cameraPerspective );//var renderModel = new THREE.RenderPass( sceneModel, cameraPerspective );

		renderModel.setClear(false);//renderModel.clear = false;
		
		composerScene = THREEExp.EffectComposer( renderer, THREE.WebGLRenderTarget( rtWidth * 2, rtHeight * 2,rtParameters ));//composerScene = new THREE.EffectComposer( renderer, new THREE.WebGLRenderTarget( rtWidth * 2, rtHeight * 2, { minFilter: THREE.LinearFilter, magFilter: THREE.LinearFilter, format: THREE.RGBFormat, stencilBuffer: true }) );
		
		composerScene.addPass( renderBackground );
		composerScene.addPass( renderModel );
		composerScene.addPass( renderMaskInverse );
		composerScene.addPass( effectHBlur );
		composerScene.addPass( effectVBlur );
		composerScene.addPass( clearMask );

		//

		renderScene = THREEExp.TexturePass( composerScene.getRenderTarget2());//renderScene = new THREE.TexturePass( composerScene.renderTarget2 );

		//

		composer1 = THREEExp.EffectComposer( renderer, THREE.WebGLRenderTarget( rtWidth, rtHeight, rtParameters ) );//composer1 = new THREE.EffectComposer( renderer, new THREE.WebGLRenderTarget( rtWidth, rtHeight, rtParameters ) );

		composer1.addPass( renderScene );
		//composer1.addPass( renderMask );
		composer1.addPass( effectFilmBW );
		//composer1.addPass( clearMask );
		composer1.addPass( effectVignette );

		//

		composer2 = THREEExp.EffectComposer( renderer, THREE.WebGLRenderTarget( rtWidth, rtHeight, rtParameters ) );//composer2 = new THREE.EffectComposer( renderer, new THREE.WebGLRenderTarget( rtWidth, rtHeight, rtParameters ) );

		composer2.addPass( renderScene );
		composer2.addPass( effectDotScreen );
		composer2.addPass( renderMask );
		composer2.addPass( effectColorify1 );
		composer2.addPass( clearMask );
		composer2.addPass( renderMaskInverse );
		composer2.addPass( effectColorify2 );
		composer2.addPass( clearMask );
		composer2.addPass( effectVignette );

		//

		composer3 = THREEExp.EffectComposer( renderer, THREE.WebGLRenderTarget( rtWidth, rtHeight, rtParameters ) );//composer3 = new THREE.EffectComposer( renderer, new THREE.WebGLRenderTarget( rtWidth, rtHeight, rtParameters ) );

		composer3.addPass( renderScene );
		//composer3.addPass( renderMask );
		composer3.addPass( effectSepia );
		composer3.addPass( effectFilm );
		//composer3.addPass( clearMask );
		composer3.addPass( effectVignette );

		//

		composer4 = THREEExp.EffectComposer( renderer, THREE.WebGLRenderTarget( rtWidth, rtHeight, rtParameters ) );//composer4 = new THREE.EffectComposer( renderer, new THREE.WebGLRenderTarget( rtWidth, rtHeight, rtParameters ) );

		composer4.addPass( renderScene );
		//composer4.addPass( renderMask );
		composer4.addPass( effectBloom );
		composer4.addPass( effectFilm );
		composer4.addPass( effectBleach );
		//composer4.addPass( clearMask );
		composer4.addPass( effectVignette );

		//

		//onWindowResize();

		renderScene.getUniforms().set("tDiffuse",composerScene.getRenderTarget2());//renderScene.uniforms[ "tDiffuse" ].value = composerScene.renderTarget2;
		
		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  -  advanced postprocessing</a>"
				,100,10));
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		
	}
	

	protected void createMesh(Geometry geometry, Scene scene, int scale) {
		geometry.computeTangents();
		
		//these are for MeshPhongMaterial material
		//.specular(0x080808).shininess(20) .normalMap(ImageUtils.loadTexture( "obj/leeperrysmith/Infinite-Level_02_Tangent_SmoothUV.jpg" )).normalScale(THREE.Vector2( 0.75) )omitted
		MeshLambertMaterial mat2 = THREE.MeshLambertMaterial( GWTParamUtils.MeshLambertMaterial().color(0x999999).ambient(0x444444).map(ImageUtils.loadTexture( "obj/leeperrysmith/Map-COL.jpg" )));//var mat2 = new THREE.MeshLambertMaterial( {color: 0x999999,ambient: 0x444444,specular: 0x080808,shininess: 20,map: THREE.ImageUtils.loadTexture( "obj/leeperrysmith/Map-COL.jpg" ),normalMap: THREE.ImageUtils.loadTexture( "obj/leeperrysmith/Infinite-Level_02_Tangent_SmoothUV.jpg" ),normalScale: new THREE.Vector2( 0.75, 0.75 )} );
	
		mesh = THREE.Mesh( geometry, mat2 );//mesh = new THREE.Mesh( geometry, mat2 );
		mesh.getPosition().set( 0, -50, 0 );//mesh.position.set( 0, -50, 0 );
		mesh.getScale().set( scale, scale, scale );//mesh.scale.set( scale, scale, scale );

		scene.add( mesh );

		loader.getStatusDomElement().getStyle().setDisplay(Display.NONE);
	}

	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
		
	}
	

	



	
	/*
	 
	 halfWidth = window.innerWidth / 2;
				halfHeight = window.innerHeight / 2;

				cameraPerspective.aspect = window.innerWidth / window.innerHeight;
				cameraPerspective.updateProjectionMatrix();

				cameraOrtho.left = -halfWidth;
				cameraOrtho.right = halfWidth;
				cameraOrtho.top = halfHeight;
				cameraOrtho.bottom = -halfHeight;

				cameraOrtho.updateProjectionMatrix();

				renderer.setSize( window.innerWidth, window.innerHeight );

				composerScene.setSize( halfWidth * 2, halfHeight * 2 );

				composer1.setSize( halfWidth, halfHeight );
				composer2.setSize( halfWidth, halfHeight );
				composer3.setSize( halfWidth, halfHeight );
				composer4.setSize( halfWidth, halfHeight );

				renderScene.uniforms[ "tDiffuse" ].value = composerScene.renderTarget2;

				quadBG.scale.set( window.innerWidth, window.innerHeight, 1 );
				quadMask.scale.set( window.innerWidth / 2, window.innerHeight / 2, 1 );
	 
	 */
	public void onWindowResize() {
		halfWidth = (int) (getWindowInnerWidth() / 2);//halfWidth = window.innerWidth / 2;
		halfHeight = (int) (getWindowInnerHeight() / 2);//halfHeight = window.innerHeight / 2;
		
		cameraPerspective.setAspect(getWindowInnerWidth() / getWindowInnerHeight());//cameraPerspective.aspect = window.innerWidth / window.innerHeight;
		cameraPerspective.updateProjectionMatrix();
		
		
		cameraOrtho.setLeft(-halfWidth);//cameraOrtho.left = -halfWidth;
		cameraOrtho.setRight(halfWidth);//cameraOrtho.right = halfWidth;
		cameraOrtho.setTop(halfHeight);//cameraOrtho.top = halfHeight;
		cameraOrtho.setBottom(-halfHeight);//cameraOrtho.bottom = -halfHeight;

		cameraOrtho.updateProjectionMatrix();
		

		renderer.setSize( getWindowInnerWidth(), getWindowInnerHeight() );//renderer.setSize( window.innerWidth, window.innerHeight );

		
		composerScene.setSize( halfWidth * 2, halfHeight * 2 );

		composer1.setSize( halfWidth, halfHeight );
		composer2.setSize( halfWidth, halfHeight );
		composer3.setSize( halfWidth, halfHeight );
		composer4.setSize( halfWidth, halfHeight );

		renderScene.getUniforms().set("tDiffuse",composerScene.getRenderTarget2());//renderScene.uniforms[ "tDiffuse" ].value = composerScene.renderTarget2;

		quadBG.getScale().set( getWindowInnerWidth(), getWindowInnerHeight(), 1 );//quadBG.scale.set( window.innerWidth, window.innerHeight, 1 );
		quadMask.getScale().set( getWindowInnerWidth() / 2, getWindowInnerHeight() / 2, 1 );//quadMask.scale.set( window.innerWidth / 2, window.innerHeight / 2, 1 );
		
	}
	private double delta=0.01;
	private Mesh mesh;
	public void render(double now) {
		double time = now * 0.0004;

		if ( mesh!=null ) mesh.getRotation().setY(-time);//if ( mesh ) mesh.rotation.y = -time;

		renderer.setViewport( 0, 0, 2 * halfWidth, 2 * halfHeight );

		renderer.clear();
		composerScene.render( delta );

		renderer.setViewport( 0, 0, halfWidth, halfHeight );
		composer1.render( delta );

		renderer.setViewport( halfWidth, 0, halfWidth, halfHeight );
		composer2.render( delta );

		renderer.setViewport( 0, halfHeight, halfWidth, halfHeight );
		composer3.render( delta );

		renderer.setViewport( halfWidth, halfHeight, halfWidth, halfHeight );
		composer4.render( delta );
	}

	@Override
	public String getTokenKey() {
		return "advanced";
	}
}
