package com.akjava.gwt.threejsexamples.client.examples;

import com.akjava.gwt.html5.client.file.File;
import com.akjava.gwt.html5.client.file.FileUploadForm;
import com.akjava.gwt.html5.client.file.FileUtils;
import com.akjava.gwt.html5.client.file.FileUtils.DataURLListener;
import com.akjava.gwt.lib.client.CanvasUtils;
import com.akjava.gwt.lib.client.ImageElementUtils;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.GWTExampleParamUtils;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.Water;
import com.akjava.gwt.three.client.examples.js.controls.OrbitControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.extras.Shader;
import com.akjava.gwt.three.client.java.Skybox;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.extras.geometries.IcosahedronGeometry;
import com.akjava.gwt.three.client.js.lights.HemisphereLight;
import com.akjava.gwt.three.client.js.loaders.ImageLoader;
import com.akjava.gwt.three.client.js.loaders.ImageLoader.ImageLoadHandler;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.materials.ShaderMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.renderers.shaders.WebGLShaders.ShaderChunk.ShaderLib;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.CubeTexture;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.akjava.gwt.threejsexamples.client.LabeledInputColorBoxWidget;
import com.akjava.gwt.threejsexamples.client.LabeledInputRangeWidget;
import com.akjava.lib.common.utils.ColorUtils;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;


public class OceanExample extends AbstractExample{

	@Override
	public String getName() {
		return "ocean";
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

	
	int parametersWidth=2000;
	int parametersHeight=2000;
	private OrbitControls controls;
	private Texture waterNormals;
	private Water water;
	private Mesh mirrorMesh;
	private Mesh sphere;
	
	@Override
	public void init() {
	
		 WIDTH = (int)getWindowInnerWidth();//var WIDTH = window.innerWidth;
		 HEIGHT = (int)getWindowInnerHeight();//var HEIGHT = window.innerHeight;

		// camera
		int VIEW_ANGLE = 55;//var VIEW_ANGLE = 45;
		double ASPECT = getWindowInnerWidth() / getWindowInnerHeight();
		double NEAR = 0.5;//var NEAR = 1;
		double FAR = 3000000;
		
		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer();//renderer = new THREE.WebGLRenderer();
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );//renderer.setPixelRatio( window.devicePixelRatio );
		renderer.setSize( WIDTH, HEIGHT );

		// scene
		scene = THREE.Scene();//scene = new THREE.Scene();
	
		// camera
		camera = THREE.PerspectiveCamera(VIEW_ANGLE, ASPECT, NEAR, FAR);//camera = new THREE.PerspectiveCamera(VIEW_ANGLE, ASPECT, NEAR, FAR);
		camera.getPosition().set( 2000, 750, 2000 );

		controls = THREEExp.OrbitControls( camera, renderer.getDomElement());//controls = new THREE.OrbitControls( camera, renderer.domElement );
		//controls.setUserPan(false);//controls.userPan = false;
		//controls.setUserPanSpeed(0.0);//controls.userPanSpeed = 0.0;
		controls.setMaxDistance(5000.0);//controls.maxDistance = 5000.0;
		controls.setMaxPolarAngle(Math.PI * 0.495);//controls.maxPolarAngle = Math.PI * 0.495;
		controls.getCenter().set( 0, 500, 0 );//controls.center.set( 0, 500, 0 );

		container.getElement().appendChild( renderer.getDomElement() );

		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - ocean</a>"
				,100,10));
		
		fillScene();
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
	}
	
	public void fillScene(){
		
		HemisphereLight light = THREE.HemisphereLight( 0xffffbb, 0x080820, 1 );//var light = new THREE.HemisphereLight( 0xffffbb, 0x080820, 1 );
		light.getPosition().set( - 1, 1, - 1 );//light.position.set( - 1, 1, - 1 );
		scene.add( light );
		
//waternormals
		waterNormals = ImageUtils.loadTexture( "textures/waternormals.jpg" );//waterNormals = new THREE.ImageUtils.loadTexture( 'textures/waternormals.jpg' );
		waterNormals.setWrapS(THREE.RepeatWrapping);//waterNormals.wrapS = waterNormals.wrapT = THREE.RepeatWrapping;
		waterNormals.setWrapT(THREE.RepeatWrapping);
		water = THREEExp.Water( renderer, camera, scene, GWTExampleParamUtils.Water().
				textureWidth(512).
				textureHeight(512).
				waterNormals(waterNormals).
				alpha(1.0).
				sunDirection(light.getPosition().clone().normalize()).
				sunColor(0xffffff).
				waterColor(0x001e0f).
				distortionScale(50.0) 
				);
		
	
		mirrorMesh = THREE.Mesh(//mirrorMesh = new THREE.Mesh(
				THREE.PlaneBufferGeometry( parametersWidth * 500, parametersHeight * 500 ),//new THREE.PlaneBufferGeometry( parameters.width * 500, parameters.height * 500 ),
				water.getMaterial()
				);
	
				mirrorMesh.add( water );
				mirrorMesh.getRotation().setX(- Math.PI * 0.5);//mirrorMesh.rotation.x = - Math.PI * 0.5;
				scene.add( mirrorMesh );
				
				
				cubeMap = THREE.CubeTexture();
				cubeMap.setFormat(THREE.RGBFormat);//cubeMap.format = THREE.RGBFormat;
				cubeMap.setFlipY(false);//cubeMap.flipY = false;

				ImageLoader loader = THREE.ImageLoader();//var loader = new THREE.ImageLoader();
				loader.load( "textures/skyboxsun25degtest.png", new ImageLoadHandler() {
					
					@Override
					public void onProgress(NativeEvent progress) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onLoad(ImageElement imageElement) {
						Skybox skybox=new Skybox(imageElement);
						skybox.setToCubeTexture(cubeMap);
						LogUtils.log(cubeMap);
						/*
						cubeMap.getImages().set(0, getSide(imageElement,2,1));
						cubeMap.getImages().set(1, getSide(imageElement,0,1));
						cubeMap.getImages().set(2, getSide(imageElement,1,0));
						cubeMap.getImages().set(3, getSide(imageElement,1,2));
						cubeMap.getImages().set(4, getSide(imageElement,1,1));
						cubeMap.getImages().set(5, getSide(imageElement,3,1));
						cubeMap.setNeedsUpdate(true);//cubeMap.needsUpdate = true;
						*/
					}
					
					@Override
					public void onError(NativeEvent error) {
						// TODO Auto-generated method stub
						
					}
				});
				
				
				
			
				Shader cubeShader = ShaderLib.cube();
				cubeShader.uniforms().set("tCube",cubeMap);//cubeShader.uniforms['tCube'].value = cubeMap;

				ShaderMaterial skyBoxMaterial = THREE.ShaderMaterial( GWTParamUtils.ShaderMaterial().fragmentShader(cubeShader.fragmentShader()).vertexShader(cubeShader.vertexShader()).uniforms(cubeShader.uniforms()).depthWrite(false).side(THREE.BackSide));//var skyBoxMaterial = new THREE.ShaderMaterial( {fragmentShader: cubeShader.fragmentShader,vertexShader: cubeShader.vertexShader,uniforms: cubeShader.uniforms,depthWrite: false,side: THREE.BackSide});
				
			
				Mesh skyBox = THREE.Mesh(//var skyBox = new THREE.Mesh(
						THREE.BoxGeometry( 1000000, 1000000, 1000000 ),//new THREE.BoxGeometry( 1000000, 1000000, 1000000 ),
						skyBoxMaterial
						);

						scene.add( skyBox );

					
						IcosahedronGeometry geometry = THREE.IcosahedronGeometry( 400, 4 );//var geometry = new THREE.IcosahedronGeometry( 400, 4 );

						for ( int i = 0, j = geometry.getFaces().length(); i < j; i ++ ) {//for ( var i = 0, j = geometry.faces.length; i < j; i ++ ) {

						geometry.getFaces().get( i ).getColor().setHex( (int) (Math.random() * 0xffffff) );//geometry.faces[ i ].color.setHex( Math.random() * 0xffffff );

						}
					


						MeshPhongMaterial material = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().vertexColors(THREE.FaceColors).shininess(100).envMap(cubeMap) );//var material = new THREE.MeshPhongMaterial( {vertexColors: THREE.FaceColors,shininess: 100,envMap: cubeMap} );

						sphere = THREE.Mesh( geometry, material );//sphere = new THREE.Mesh( geometry, material );
						scene.add( sphere );
					
	}

	//forced convert canvas as imageelement
	public   native final ImageElement getSide(ImageElement image,int x,int y)/*-{
				var size = 1024;

						var canvas = document.createElement( 'canvas' );
						canvas.width = size;
						canvas.height = size;

						var context = canvas.getContext( '2d' );
						context.drawImage( image, - x * size, - y * size );

						return canvas;
	}-*/;

	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
		CheckBox showSphere=new CheckBox("show sphere");
		showSphere.setValue(true);
		gui.add(showSphere);
		showSphere.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				sphere.setVisible(event.getValue());
			}
		});
		
		LabeledInputRangeWidget distortionScale=new LabeledInputRangeWidget("distortionScale", 10, 400, 10);
		gui.add(distortionScale);
		distortionScale.setValue(50);
		distortionScale.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				water.getMaterial().getUniforms().set("distortionScale", event.getValue().doubleValue());
			}
			
		});
		
		LabeledInputRangeWidget alpha=new LabeledInputRangeWidget("alpha", 0.05, 1, 0.05);
		gui.add(alpha);
		alpha.setValue(1);
		alpha.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				water.getMaterial().getUniforms().set("alpha", event.getValue().doubleValue());
			}
			
		});
		
		LabeledInputRangeWidget speed=new LabeledInputRangeWidget("speed", 1, 200,1);
		gui.add(speed);
		speed.setValue(60);
		speed.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				//water.getMaterial().getUniforms().set("alpha", event.getValue().doubleValue());
				timeSplit=event.getValue().doubleValue();
			}
			
		});
		
		LabeledInputColorBoxWidget waterColor=new LabeledInputColorBoxWidget("waterColor");
		waterColor.setValue("#001E0F");
		waterColor.addListener(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				int value=ColorUtils.toColor(ColorUtils.toRGB(event.getValue()));
				water.getMaterial().getUniforms().set("waterColor", THREE.Color(value));
			}
		});
		gui.add(waterColor);
		
		LabeledInputColorBoxWidget sunColor=new LabeledInputColorBoxWidget("sunColor");
		sunColor.setValue("#ffffff");
		sunColor.addListener(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				int value=ColorUtils.toColor(ColorUtils.toRGB(event.getValue()));
				water.getMaterial().getUniforms().set("sunColor", THREE.Color(value));
			}
		});
		gui.add(sunColor);
		gui.add(new Label("WaterNormals"));
		final FileUploadForm fileUpload=FileUtils.createSingleFileUploadForm(new DataURLListener() {
			@Override
			public void uploaded(File file, String text) {
				ImageElement image=ImageElementUtils.create(text);
				int w=image.getWidth();
				int h=image.getHeight();
				
				//LogUtils.log(w+"x"+h);
				Texture texture;
				if(w!=1024 || h!=1024){
					Canvas canvas=CanvasUtils.createCanvas(1024, 1024);
					CanvasUtils.drawFitCenter(canvas, image);
					
					texture=ImageUtils.loadTexture(canvas.toDataUrl());
				}else{
					texture=ImageUtils.loadTexture(text);
				}
				
				texture.setWrapS(THREE.RepeatWrapping);//waterNormals.wrapS = waterNormals.wrapT = THREE.RepeatWrapping;
				texture.setWrapT(THREE.RepeatWrapping);
				
				water.getMaterial().getUniforms().set("normalSampler", texture);//somehow normalSampler
				//water.updateTextureMatrix();
			}
		},false);
		fileUpload.setAccept(FileUploadForm.ACCEPT_IMAGE);
	
		gui.add(fileUpload);
		
		Button resetTexture=new Button("resetTexture",new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				fileUpload.reset();
				water.getMaterial().getUniforms().set("normalSampler", waterNormals);
				
			}
		});
		gui.add(resetTexture);
		
		gui.add(new Label("Skybox"));
		final FileUploadForm fileUpload2=FileUtils.createSingleFileUploadForm(new DataURLListener() {
			@Override
			public void uploaded(File file, String text) {
				ImageElement image=ImageElementUtils.create(text);
				
				if(!Skybox.isValidImage(image)){
					Window.alert("invalid skybox image-size");
					return;
				}
				
				Skybox skybox=new Skybox(image);
				skybox.setToCubeTexture(cubeMap);
				
				//water.updateTextureMatrix();
			}
		},false);
		fileUpload2.setAccept(FileUploadForm.ACCEPT_IMAGE);
	
		gui.add(fileUpload2);
	}
	

	



	
	
	public void onWindowResize() {
		
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
		
	}
	
	private double timeSplit=60;
	private CubeTexture cubeMap;
	public void render(double now) {//GWT animateFrame has time
		double time = now * 0.001;
	
		sphere.getPosition().setY(Math.sin( time ) * 500 + 250);//sphere.position.y = Math.sin( time ) * 500 + 250;
		sphere.getRotation().setX(time * 0.5);//sphere.rotation.x = time * 0.5;
		sphere.getRotation().setZ(time * 0.51);//sphere.rotation.z = time * 0.51;
		
		((ShaderMaterial)water.getMaterial().cast()).getUniforms().gwtIncrementValue("time",  1.0 / timeSplit);//water.material.uniforms.time.value += 1.0 / 60.0;
		controls.update();
		
		water.render();
		
		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "ocean";
	}
}
