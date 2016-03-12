package com.akjava.gwt.threejsexamples.client.examples.shading;

import com.akjava.gwt.lib.client.GWTUtils;
import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.TWEEN;
import com.akjava.gwt.three.client.examples.js.controls.TrackballControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.gwt.extras.Shader;
import com.akjava.gwt.three.client.gwt.renderers.WebGLRendererParameter;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.cameras.CubeCamera;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.extras.geometries.BoxGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.PlaneBufferGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.SphereGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.TorusGeometry;
import com.akjava.gwt.three.client.js.lights.AmbientLight;
import com.akjava.gwt.three.client.js.lights.PointLight;
import com.akjava.gwt.three.client.js.lights.SpotLight;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.materials.ShaderMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.renderers.shaders.WebGLShaders.ShaderChunk.ShaderLib;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.CanvasTexture;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.akjava.gwt.threejsexamples.client.LabeledInputRangeWidget;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class PhysicalExample extends AbstractExample{

	@Override
	public String getName() {
		return "shading/physical";
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

	
	private int windowHalfX,windowHalfY;
	//private int mouseX,mouseY;

	Clock clock;
	
	private double FAR=10000;
	private CubeCamera cubeCamera;
	
	private Mesh mesh;
	private AnimationMixer mixer;
	
	private boolean DAY;
	private AmbientLight ambientLight;
	private PointLight pointLight;
	private SpotLight sunLight;
	private TrackballControls controls;
	
	private int tweenDirection;
	private TWEEN tweenDay,tweenNight;
	private JSParameter parameters;
	@Override
	public void init() {
	
		clock=THREE.Clock();
		
		 WIDTH = (int)getWindowInnerWidth();
		 HEIGHT = (int)getWindowInnerHeight();
		 
		 windowHalfX=(int) (getWindowInnerWidth()/2);
		 windowHalfY=(int) (getWindowInnerHeight()/2);

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer(WebGLRendererParameter.create().antialias(true));
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( WIDTH, HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );
		
		renderer.getShadowMap().setEnabled(true);//renderer.shadowMap.enabled = true;
		renderer.getShadowMap().setType(THREE.PCFSoftShadowMap);//renderer.shadowMap.type = THREE.PCFSoftShadowMap;

		//

		renderer.setGammaInput(true);//renderer.gammaInput = true;
		renderer.setGammaOutput(true);//renderer.gammaOutput = true;
		

		// scene
		scene = THREE.Scene();
		scene.setFog(THREE.Fog( 0x00aaff, 1000, FAR ));
	
		// camera
		camera = THREE.PerspectiveCamera(45, getWindowInnerWidth()/getWindowInnerHeight(), 2, FAR);
		camera.getPosition().set(500, 400, 1200 );
		
		cubeCamera = THREE.CubeCamera( 1, FAR, 128 );
		scene.add( cubeCamera );
		
		Canvas x = Canvas.createIfSupported();
		Context2d xc = x.getContext2d();
		x.setSize(128+"px", 128+"px");
		
		xc.setFillStyle("#fff");
		xc.fillRect(0, 0, 128, 128);
		xc.setFillStyle("#000");
		xc.fillRect(0, 0, 64, 64);
		xc.setFillStyle("#999");
		xc.fillRect(32, 32, 32, 32);
		xc.setFillStyle("#000");
		xc.fillRect(64, 64, 64, 64);
		xc.setFillStyle("#555");
		xc.fillRect(96, 96, 32, 32);
		
	
		CanvasTexture texturePattern = THREE.CanvasTexture(x.getCanvasElement());// var
																					// texturePattern
																					// =
																					// new
																					// THREE.CanvasTexture(
																					// x
																					// )
		texturePattern.setFormat(THREE.RGBFormat);// texturePattern.format =
													// THREE.RGBFormat;
		texturePattern.getRepeat().set(1000, 1000);// texturePattern.repeat.set(
													// 1000, 1000 );
		texturePattern.setWrapS(THREE.RepeatWrapping);// texturePattern.wrapS =
														// THREE.RepeatWrapping;
		texturePattern.setWrapT(THREE.RepeatWrapping);// texturePattern.wrapT =
														// THREE.RepeatWrapping;

		Texture textureSquares = ImageUtils.loadTexture("textures/patterns/bright_squares256.png");// var
																									// textureSquares
																									// =
																									// THREE.ImageUtils.loadTexture(
																									// "textures/patterns/bright_squares256.png"
																									// );
		textureSquares.getRepeat().set(50, 50);// textureSquares.repeat.set( 50,
												// 50 );
		textureSquares.setWrapS(THREE.RepeatWrapping);// textureSquares.wrapS =
														// textureSquares.wrapT
														// =
														// THREE.RepeatWrapping;
		textureSquares.setWrapT(THREE.RepeatWrapping);
		textureSquares.setMagFilter(THREE.NearestFilter);// textureSquares.magFilter
															// =
															// THREE.NearestFilter;
		textureSquares.setFormat(THREE.RGBFormat);// textureSquares.format =
													// THREE.RGBFormat;

		Texture textureNoiseColor = ImageUtils.loadTexture("textures/disturb.jpg");// var
																					// textureNoiseColor
																					// =
																					// THREE.ImageUtils.loadTexture(
																					// "textures/disturb.jpg"
																					// );
		textureNoiseColor.getRepeat().set(1, 1);// textureNoiseColor.repeat.set(
												// 1, 1 );
		textureNoiseColor.setWrapS(THREE.RepeatWrapping);// textureNoiseColor.wrapS
															// =
															// textureNoiseColor.wrapT
															// =
															// THREE.RepeatWrapping;
		textureNoiseColor.setWrapT(THREE.RepeatWrapping);
		textureNoiseColor.setFormat(THREE.RGBFormat);// textureNoiseColor.format
														// = THREE.RGBFormat;

		Texture textureLava = ImageUtils.loadTexture("textures/lava/lavatile.jpg");// var
																					// textureLava
																					// =
																					// THREE.ImageUtils.loadTexture(
																					// "textures/lava/lavatile.jpg"
																					// );
		textureLava.getRepeat().set(6, 2);// textureLava.repeat.set( 6, 2 );
		textureLava.setWrapS(THREE.RepeatWrapping);// textureLava.wrapS =
													// textureLava.wrapT =
													// THREE.RepeatWrapping;
		textureLava.setWrapT(THREE.RepeatWrapping);
		textureLava.setFormat(THREE.RGBFormat);// textureLava.format =
												// THREE.RGBFormat;

		String path = "textures/cube/SwedishRoyalCastle/";// var path =
															// "textures/cube/SwedishRoyalCastle/";
		String format = ".jpg";// var format = '.jpg';
		String[] urls = { path + "px" + format, path + "nx" + format, path + "py" + format, path + "ny" + format, path + "pz" + format, path + "nz" + format };
		;

		Texture reflectionCube = ImageUtils.loadTextureCube(JavaScriptUtils.toArray(urls));// var
																							// reflectionCube
																							// =
																							// THREE.ImageUtils.loadTextureCube(
																							// urls
																							// );

		// ground

		MeshPhongMaterial groundMaterial = THREE.MeshPhongMaterial(GWTParamUtils.MeshPhongMaterial().shininess(80).color(0xffffff).specular(0xffffff)
				.map(textureSquares));// var groundMaterial = new
										// THREE.MeshPhongMaterial( {shininess:
										// 80,color: 0xffffff,specular:
										// 0xffffff,map: textureSquares} );
		PlaneBufferGeometry planeGeometry = THREE.PlaneBufferGeometry(100, 100);// var
																				// planeGeometry
																				// =
																				// new
																				// THREE.PlaneBufferGeometry(
																				// 100,
																				// 100
																				// );

		Mesh ground = THREE.Mesh(planeGeometry, groundMaterial);// var ground =
																// new
																// THREE.Mesh(
																// planeGeometry,
																// groundMaterial
																// );
		ground.getPosition().set(0, 0, 0);// ground.position.set( 0, 0, 0 );
		ground.getRotation().setX(-Math.PI / 2);// ground.rotation.x = - Math.PI
												// / 2;
		ground.getScale().set(1000, 1000, 1000);// ground.scale.set( 1000, 1000,
												// 1000 );

		ground.setReceiveShadow(true);// ground.receiveShadow = true;

		scene.add(ground);

		// materials
		Shader shader = ShaderLib.cube();
		shader.uniforms().set("tCube", cubeCamera.getRenderTarget());// shader.uniforms[
																		// "tCube"
																		// ].texture
																		// =
																		// cubeCamera.renderTarget;
		shader.uniforms().set("tFlip", 1);// shader.uniforms[ "tFlip" ].value =
											// 1;

		ShaderMaterial materialCube = THREE.ShaderMaterial(GWTParamUtils.ShaderMaterial().fragmentShader(shader.fragmentShader())
				.vertexShader(shader.vertexShader()).uniforms(shader.uniforms()));// var
																					// materialCube
																					// =
																					// new
																					// THREE.ShaderMaterial(
																					// {fragmentShader:
																					// shader.fragmentShader,vertexShader:
																					// shader.vertexShader,uniforms:
																					// shader.uniforms}
																					// );

		MeshPhongMaterial materialLambert = THREE.MeshPhongMaterial(GWTParamUtils.MeshPhongMaterial().shininess(50).color(0xffffff).map(textureNoiseColor));// var
																																							// materialLambert
																																							// =
																																							// new
																																							// THREE.MeshPhongMaterial(
																																							// {
																																							// shininess:
																																							// 50,
																																							// color:
																																							// 0xffffff,
																																							// map:
																																							// textureNoiseColor
																																							// }
																																							// );
		MeshPhongMaterial materialPhong = THREE.MeshPhongMaterial(GWTParamUtils.MeshPhongMaterial().shininess(50).color(0xffffff).specular(0x999999)
				.map(textureLava));// var materialPhong = new
									// THREE.MeshPhongMaterial( { shininess: 50,
									// color: 0xffffff, specular: 0x999999, map:
									// textureLava } );

		MeshPhongMaterial materialPhongCube = THREE.MeshPhongMaterial(GWTParamUtils.MeshPhongMaterial().shininess(50).color(0xffffff).specular(0x999999)
				.envMap(cubeCamera.getRenderTarget().gwtCastTexture()));// var
																		// materialPhongCube
																		// = new
																		// THREE.MeshPhongMaterial(
																		// {
																		// shininess:
																		// 50,
																		// color:
																		// 0xffffff,
																		// specular:
																		// 0x999999,
																		// envMap:
																		// cubeCamera.renderTarget
																		// } );
		// stats

		// object
		SphereGeometry sphereGeometry = THREE.SphereGeometry(100, 64, 32);// var
																			// sphereGeometry
																			// =
																			// new
																			// THREE.SphereGeometry(
																			// 100,
																			// 64,
																			// 32
																			// );
		TorusGeometry torusGeometry = THREE.TorusGeometry(240, 60, 32, 64);// var
																			// torusGeometry
																			// =
																			// new
																			// THREE.TorusGeometry(
																			// 240,
																			// 60,
																			// 32,
																			// 64
																			// );
		BoxGeometry cubeGeometry = THREE.BoxGeometry(150, 150, 150);// var
																	// cubeGeometry
																	// = new
																	// THREE.BoxGeometry(
																	// 150, 150,
																	// 150 );

		addObject(torusGeometry, materialPhong, 0, 100, 0, 0);
		addObject(cubeGeometry, materialLambert, 350, 75, 300, 0);
		mesh = addObject(sphereGeometry, materialPhongCube, 350, 100, -350, 0);

		BoxGeometry bigCube = THREE.BoxGeometry(50, 500, 50);
		BoxGeometry midCube = THREE.BoxGeometry(50, 200, 50);
		BoxGeometry smallCube = THREE.BoxGeometry(100, 100, 100);

		addObjectColor(bigCube, 0xff0000, -500, 250, 0, 0);
		addObjectColor(smallCube, 0xff0000, -500, 50, -150, 0);

		addObjectColor(midCube, 0x00ff00, 500, 100, 0, 0);
		addObjectColor(smallCube, 0x00ff00, 500, 50, -150, 0);

		addObjectColor(midCube, 0x0000ff, 0, 100, -500, 0);
		addObjectColor(smallCube, 0x0000ff, -150, 50, -500, 0);

		addObjectColor(midCube, 0xff00ff, 0, 100, 500, 0);
		addObjectColor(smallCube, 0xff00ff, -150, 50, 500, 0);

		addObjectColor(THREE.BoxGeometry(500, 10, 10), 0xffff00, 0, 600, 0, Math.PI / 4);
		addObjectColor(THREE.BoxGeometry(250, 10, 10), 0xffff00, 0, 600, 0, 0);

		addObjectColor(THREE.SphereGeometry(100, 32, 26), 0xffffff, -300, 100, 300, 0);
						
		
		JSONLoader loader=THREE.JSONLoader();
		loader.load("models/animated/sittingBox.js", new JSONLoadHandler() {
			
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				MeshPhongMaterial morphMaterial = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0x000000).specular(0xff9900).shininess(50).morphTargets(true).side(THREE.DoubleSide).shading(THREE.FlatShading) );//var morphMaterial = new THREE.MeshPhongMaterial( { color: 0x000000, specular: 0xff9900, shininess: 50, morphTargets: true, side: THREE.DoubleSide, shading: THREE.FlatShading } );

				mesh = THREE.Mesh( geometry, morphMaterial );//mesh = new THREE.Mesh( geometry, morphMaterial );

				mixer = THREE.AnimationMixer( mesh );//mixer = new THREE.AnimationMixer( mesh );

				mixer.addAction( THREE.AnimationAction( geometry.getAnimations().get(0) ).warpToDuration( 10 ) );//mixer.addAction( new THREE.AnimationAction( geometry.animations[0] ).warpToDuration( 10 ) );

				double s = 200;//var s = 200;
				mesh.getScale().set( s, s, s );//mesh.scale.set( s, s, s );

				//morph.setDuration(8000);////morph.duration = 8000;
				//morph.setMirroredLoop(true);////morph.mirroredLoop = true;

				mesh.setCastShadow(true);//mesh.castShadow = true;
				mesh.setReceiveShadow(true);//mesh.receiveShadow = true;

				scene.add( mesh );
			}
		});
		
		double sunIntensity = 0.3;
		double		pointIntensity = 1;
		int pointColor = 0xffaa00;

				if ( DAY ) {

				sunIntensity = 1;
				pointIntensity = 0.5;
				pointColor = 0xffffff;

				}

				ambientLight = THREE.AmbientLight( 0x3f2806 );//ambientLight = new THREE.AmbientLight( 0x3f2806 );
				scene.add( ambientLight );

				pointLight = THREE.PointLight( 0xffaa00, pointIntensity, 5000 );//pointLight = new THREE.PointLight( 0xffaa00, pointIntensity, 5000 );
				pointLight.getPosition().set( 0, 0, 0 );//pointLight.position.set( 0, 0, 0 );
				scene.add( pointLight );

				sunLight = THREE.SpotLight( 0xffffff, sunIntensity, 0, Math.PI/2, 1 );//sunLight = new THREE.SpotLight( 0xffffff, sunIntensity, 0, Math.PI/2, 1 );
				sunLight.getPosition().set( 1000, 2000, 1000 );//sunLight.position.set( 1000, 2000, 1000 );

				sunLight.setCastShadow(true);//sunLight.castShadow = true;

				sunLight.setShadowBias(-0.0002);//sunLight.shadowBias = -0.0002;

				sunLight.setShadowCameraNear(750);//sunLight.shadowCameraNear = 750;
				sunLight.setShadowCameraFar(4000);//sunLight.shadowCameraFar = 4000;
				sunLight.setShadowCameraFov(30);//sunLight.shadowCameraFov = 30;

				sunLight.setShadowCameraVisible(false);//sunLight.shadowCameraVisible = false;

				scene.add( sunLight );
		
				
				//trackball consume keydown event.this is the way to add keydown on root
				//TODO method
				
				GWTUtils.addKeyDownHandlerToDocument(new KeyDownHandler() {
					@Override
					public void onKeyDown(KeyDownEvent event) {
						
						if(event.getNativeKeyCode() ==78){
							if ( tweenDirection == 1 ) {
								
								tweenDay.stop();
								tweenNight.start();

								tweenDirection = -1;

							} else {

								tweenNight.stop();
								tweenDay.start();

								tweenDirection = 1;

							}
						}
					}
				});
		
	
				//control
				
				controls = THREEExp.TrackballControls( camera, renderer.getDomElement());//controls = new THREE.TrackballControls( camera, renderer.domElement );
				controls.getTarget().set( 0, 120, 0 );//controls.target.set( 0, 120, 0 );

				controls.setRotateSpeed(1.0);//controls.rotateSpeed = 1.0;
				controls.setZoomSpeed(1.2);//controls.zoomSpeed = 1.2;
				controls.setPanSpeed(0.8);//controls.panSpeed = 0.8;

				controls.setNoZoom(false);//controls.noZoom = false;
				controls.setNoPan(false);//controls.noPan = false;

				controls.setStaticMoving(true);//controls.staticMoving = true;
				controls.setDynamicDampingFactor(0.15);//controls.dynamicDampingFactor = 0.15;

				controls.setKeys(JavaScriptUtils.toArray(new int[]{65, 83, 68 }));//controls.keys = [ 65, 83, 68 ];
				
				
				//Tween
				tweenDirection = -1;
				
				parameters = JSParameter.createParameter().set("control", 0);
				
				tweenDay = TWEEN.Tween( parameters ).to("control",1 , 1000 ).easing( TWEEN.Easing_Exponential_Out());
				tweenNight =  TWEEN.Tween( parameters ).to( "control",0, 1000 ).easing( TWEEN.Easing_Exponential_Out() );

				
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
	

	
	private Mesh addObject(Geometry geometry,Material material,double x,double y,double z,double ry){
		Mesh tmpMesh = THREE.Mesh( geometry, material );//var tmpMesh = new THREE.Mesh( geometry, material );

		tmpMesh.getMaterial().gwtCastMeshPhongMaterial().getColor().offsetHSL( 0.1, -0.1, 0 );//tmpMesh.material.color.offsetHSL( 0.1, -0.1, 0 );

		tmpMesh.getPosition().set( x, y, z );//tmpMesh.position.set( x, y, z );

		tmpMesh.getRotation().setY(ry);//tmpMesh.rotation.y = ry;

		tmpMesh.setCastShadow(true);//tmpMesh.castShadow = true;
		tmpMesh.setReceiveShadow(true);//tmpMesh.receiveShadow = true;

		scene.add( tmpMesh );

		return tmpMesh;
	}
	private Mesh addObjectColor(Geometry geometry,int color,double x,double y,double z,double ry){
		MeshPhongMaterial material = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff) );//var material = new THREE.MeshPhongMaterial( { color: 0xffffff } );

		return addObject( geometry, material, x, y, z, ry );
	}

	
	/*
	 * var gui, shadowConfig = {

				shadowCameraVisible: false,
				shadowCameraNear: 750,
				shadowCameraFar: 4000,
				shadowCameraFov: 30,
				shadowBias: -0.0002

			}, gamma = {
				gammaFactor: 2.0,
				gammaInput: true,
				gammaOutput: true
			};
	 */
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
		gui.add(new Label("Shadow"));
		
		/* not work on r73
		final CheckBox shadowCameraVisible=new CheckBox("shadowCameraVisible");
		shadowCameraVisible.setValue(false);
		shadowCameraVisible.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				// don't work,need helper
				sunLight.setShadowCameraVisible(shadowCameraVisible.getValue());
			}
		});
		
		gui.add(shadowCameraVisible);
		*/
		
		
		final LabeledInputRangeWidget shadowCameraNear=new LabeledInputRangeWidget("shadowCameraNear", 1, 1500, 1);
		shadowCameraNear.setValue(750);
		shadowCameraNear.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				sunLight.setShadowCameraNear(shadowCameraNear.getValue());//sunLight.shadowCamera.near = shadowConfig.shadowCameraNear;
				sunLight.getShadow().getCamera().gwtCastPerspectiveCamera().updateProjectionMatrix();
				//sunLight.getShadowCamera().updateProjectionMatrix();//sunLight.shadowCamera.updateProjectionMatrix();
			}
		});
		gui.add(shadowCameraNear);
		
		
		
		final LabeledInputRangeWidget shadowCameraFar=new LabeledInputRangeWidget("shadowCameraFar", 1501, 5000, 1);
		shadowCameraFar.setValue(4000);
		shadowCameraFar.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				sunLight.setShadowCameraFar(shadowCameraFar.getValue());
				sunLight.getShadow().getCamera().gwtCastPerspectiveCamera().updateProjectionMatrix();
				
			}
		});
		gui.add(shadowCameraFar);
		
		final LabeledInputRangeWidget shadowCameraFov=new LabeledInputRangeWidget("shadowCameraFov", 1, 120, 1);
		shadowCameraFov.setValue(30);
		shadowCameraFov.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				sunLight.setShadowCameraFov(shadowCameraFov.getValue());
				sunLight.getShadow().getCamera().gwtCastPerspectiveCamera().updateProjectionMatrix();
				
			}
		});
		gui.add(shadowCameraFov);
		
		final LabeledInputRangeWidget shadowBias=new LabeledInputRangeWidget("shadowBias", -0.01, 0.01, 0.0001);
		shadowBias.setValue(0);
		shadowBias.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				sunLight.setShadowBias(shadowBias.getValue());
				sunLight.getShadow().getCamera().gwtCastPerspectiveCamera().updateProjectionMatrix();
				
			}
		});
		gui.add(shadowBias);
		
		gui.add(new Label("Ganmma"));
		final LabeledInputRangeWidget gammaFactor=new LabeledInputRangeWidget("gammaFactor", 0.1, 4.0, 0.1);
		gammaFactor.setValue(2);
		gammaFactor.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				renderer.setGammaFactor(gammaFactor.getValue());
			}
		});
		gui.add(gammaFactor);
		
	}
	

	



	
	
	public void onWindowResize() {
		
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
	
		 windowHalfX=(int) (getWindowInnerWidth()/2);
		 windowHalfY=(int) (getWindowInnerHeight()/2);
		 
		// controls.handleResize();
	}
	
	public void render(double now) {
		double delta = clock.getDelta();

		TWEEN.update();
		controls.update();

		if ( mixer!=null ) {

			mixer.update( delta );

		}
		

		scene.getFog().getColor().setHSL( 0.63, 0.05, parameters.getDouble("control"));//scene.fog.color.setHSL( 0.63, 0.05, parameters.control );
		renderer.setClearColor( scene.getFog().getColor());//renderer.setClearColor( scene.fog.color );

		sunLight.setIntensity(parameters.getDouble("control") * 0.7 + 0.3);//sunLight.intensity = parameters.control * 0.7 + 0.3;
		pointLight.setIntensity(- parameters.getDouble("control") * 0.5 + 1);//pointLight.intensity = - parameters.control * 0.5 + 1;

		pointLight.getColor().setHSL( 0.1, 0.75, parameters.getDouble("control") * 0.5 + 0.5 );//pointLight.color.setHSL( 0.1, 0.75, parameters.control * 0.5 + 0.5 );

		// render cube map

		mesh.setVisible(false);//mesh.visible = false;

		renderer.setAutoClear(true);//renderer.autoClear = true;
		cubeCamera.getPosition().copy( mesh.getPosition());//cubeCamera.position.copy( mesh.position );
		cubeCamera.updateCubeMap( renderer, scene );
		renderer.setAutoClear(false);//renderer.autoClear = false;

		mesh.setVisible(true);//mesh.visible = true;
		
		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "shading_physical";
	}
}
