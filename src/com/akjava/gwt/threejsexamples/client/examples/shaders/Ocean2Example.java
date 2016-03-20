package com.akjava.gwt.threejsexamples.client.examples.shaders;

import com.akjava.gwt.html5.client.file.File;
import com.akjava.gwt.html5.client.file.FileUploadForm;
import com.akjava.gwt.html5.client.file.FileUtils;
import com.akjava.gwt.html5.client.file.FileUtils.DataURLListener;
import com.akjava.gwt.lib.client.CanvasUtils;
import com.akjava.gwt.lib.client.ImageElementUtils;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.GWTExampleParamUtils;
import com.akjava.gwt.three.client.examples.js.Ocean;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.Water;
import com.akjava.gwt.three.client.examples.js.controls.OrbitControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.gwt.extras.Shader;
import com.akjava.gwt.three.client.java.Skybox;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
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
import com.google.gwt.core.client.JsArrayNumber;
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


public class Ocean2Example extends AbstractExample{

	@Override
	public String getName() {
		return "ocean2";
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

	
	
	private OrbitControls controls;
	private Ocean ocean;
	private double lastTime;
	

	
	@Override
	public void init() {
	
		 WIDTH = (int)getWindowInnerWidth();//var WIDTH = window.innerWidth;
		 HEIGHT = (int)getWindowInnerHeight();//var HEIGHT = window.innerHeight;

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer();//renderer = new THREE.WebGLRenderer();
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );//renderer.setPixelRatio( window.devicePixelRatio );
		renderer.setSize( WIDTH, HEIGHT );
		/*
		renderer.getContext().getExtension("OES_texture_float"); //ocean.js do that
		renderer.getContext().getExtension("OES_texture_float_linear");
		*/
		
		//'OES_texture_float' renderer.getContext().

		// scene
		scene = THREE.Scene();//scene = new THREE.Scene();
	
		// camera
		camera = THREE.PerspectiveCamera(55, getWindowInnerWidth()/getWindowInnerHeight(), 0.5, 300000);//camera = new THREE.PerspectiveCamera(VIEW_ANGLE, ASPECT, NEAR, FAR);
		camera.getPosition().set(450, 350, 450);//ms_Camera.position.set(450, 350, 450);
		camera.lookAt(THREE.Vector3());//ms_Camera.lookAt(new THREE.Vector3());

		// Initialize Orbit control
		controls = THREEExp.OrbitControls(camera, renderer.getDomElement());//ms_Controls = new THREE.OrbitControls(ms_Camera, ms_Renderer.domElement);
		//controls.setUserPan(false);//ms_Controls.userPan = false;
		//controls.setUserPanSpeed(0.0);//ms_Controls.userPanSpeed = 0.0;
		controls.setMinDistance(0);//ms_Controls.minDistance = 0;
		controls.setMaxDistance(2000.0);//ms_Controls.maxDistance = 2000.0;
		controls.setMinPolarAngle(0);//ms_Controls.minPolarAngle = 0;
		//controls.setMaxPolarAngle(Math.PI * 0.495);//ms_Controls.maxPolarAngle = Math.PI * 0.495;

		double gsize = 512;//var gsize = 512; //512 is 30fps,256 is wrong,128 is better
		double res = gsize*2;//var res = 1024;
		double gres = res / 2;
		double origx = -gsize / 2;
		double origz = -gsize / 2;
		
		JSParameter param=JSParameter.createParameter();
		param.set("INITIAL_SIZE", 256.0);
		param.setArray("INITIAL_WIND", 10.0, 10.0);
		param.set("INITIAL_CHOPPINESS", 1.5);
		param.setArray("CLEAR_COLOR", 1.0,1.0,1.0,0);
		param.setArray("GEOMETRY_ORIGIN", origx, origz);
		param.setArray("SUN_DIRECTION", -1.0, 1.0, 1.0);
		param.set("OCEAN_COLOR", THREE.Vector3(0.004, 0.016, 0.047));
		param.set("SKY_COLOR", THREE.Vector3(3.2, 9.6, 12.8));
		param.set("EXPOSURE",  0.35);
		param.set("GEOMETRY_RESOLUTION", gres);
		param.set("GEOMETRY_SIZE", gsize);
		param.set("RESOLUTION", res);
		LogUtils.log(param);
		/*
		 INITIAL_SIZE : 256.0,
						INITIAL_WIND : [10.0, 10.0],
						INITIAL_CHOPPINESS : 1.5,
						CLEAR_COLOR : [1.0, 1.0, 1.0, 0.0],
						GEOMETRY_ORIGIN : [origx, origz],
						SUN_DIRECTION : [-1.0, 1.0, 1.0],
						OCEAN_COLOR: new THREE.Vector3(0.004, 0.016, 0.047),
						SKY_COLOR: new THREE.Vector3(3.2, 9.6, 12.8),
						EXPOSURE : 0.35,
						GEOMETRY_RESOLUTION: gres,
						GEOMETRY_SIZE : gsize,
						RESOLUTION : res
		 */
		
		
		
		//create ocean
		ocean = THREEExp.Ocean(renderer, camera, scene,param);
		ocean.gwtInitUniforms(camera);
		
		scene.add(ocean.getOceanMesh());
		
		LogUtils.log(ocean);
		
		container.getElement().appendChild( renderer.getDomElement() );

		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - ocean2</a>"
				,100,10));
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		lastTime=System.currentTimeMillis();
	}
	

	//add js parameter?
	public JsArrayNumber of(double... values){
		JsArrayNumber numbers=JsArrayNumber.createArray().cast();
		for(double v:values){
			numbers.push(v);
		}
		return numbers;
	}

	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
		LabeledInputRangeWidget size=new LabeledInputRangeWidget("size", 10, 1000,10);
		gui.add(size);
		size.setValue(ocean.getSize());
		size.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				ocean.setSize(event.getValue().doubleValue());
				ocean.setChanged(true);
			}
			
		});
		LabeledInputRangeWidget choppiness=new LabeledInputRangeWidget("choppiness", 0.1, 4,0.1);
		gui.add(choppiness);
		choppiness.setValue(ocean.getChoppiness());
		choppiness.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				ocean.setChoppiness(event.getValue().doubleValue());
				ocean.setChanged(true);
			}
			
		});
		
		LabeledInputRangeWidget windX=new LabeledInputRangeWidget("windX",-15, 15,1);
		gui.add(windX);
		windX.setValue(ocean.getWindX());
		windX.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				ocean.setWindX(event.getValue().doubleValue());
				ocean.setChanged(true);
			}
			
		});
		
		LabeledInputRangeWidget windY=new LabeledInputRangeWidget("windY",-15, 15,1);
		gui.add(windY);
		windY.setValue(ocean.getWindY());
		windY.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				ocean.setWindY(event.getValue().doubleValue());
				ocean.setChanged(true);
			}
			
		});
		LabeledInputRangeWidget sunDirectionX=new LabeledInputRangeWidget("sunDirectionX", -1.0, 1.0,0.1);
		gui.add(sunDirectionX);
		sunDirectionX.setValue(ocean.getSunDirectionX());
		sunDirectionX.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				ocean.setSunDirectionX(event.getValue().doubleValue());
				ocean.setChanged(true);
			}
			
		});
		LabeledInputRangeWidget sunDirectionY=new LabeledInputRangeWidget("sunDirectionY", -1.0, 1.0,0.1);
		gui.add(sunDirectionY);
		sunDirectionY.setValue(ocean.getSunDirectionY());
		sunDirectionY.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				ocean.setSunDirectionY(event.getValue().doubleValue());
				ocean.setChanged(true);
			}
			
		});
		LabeledInputRangeWidget sunDirectionZ=new LabeledInputRangeWidget("sunDirectionZ", -1.0, 1.0,0.1);
		gui.add(sunDirectionZ);
		sunDirectionZ.setValue(ocean.getSunDirectionZ());
		sunDirectionZ.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				ocean.setSunDirectionZ(event.getValue().doubleValue());
				ocean.setChanged(true);
			}
			
		});
		
		LabeledInputRangeWidget exposure=new LabeledInputRangeWidget("exposure", 0, 0.5,0.01);
		gui.add(exposure);
		sunDirectionZ.setValue(ocean.getExposure());
		sunDirectionZ.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				ocean.setExposure(event.getValue().doubleValue());
				ocean.setChanged(true);
			}
			
		});
		
	}
	

	



	
	
	public void onWindowResize() {
		
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
		
	}
	
	public void render(double now) {//GWT animateFrame has time
		double deltaTime = (now - lastTime) / 1000 ;
		lastTime = now;
		ocean.setDeltaTime(deltaTime);
		ocean.render();
		
		//TODO overwrite
		ocean.setOverrideMaterial(ocean.getMaterialOcean());
		
		//must need and ocean is changed=false on initialized 
		if(ocean.isChanged()){
			ocean.getMaterialOcean().getUniforms().set("u_size", ocean.getSize());
			ocean.getMaterialOcean().getUniforms().set("u_sunDirection",ocean.getSunDirectionX(),ocean.getSunDirectionY(),ocean.getSunDirectionZ());
			ocean.getMaterialOcean().getUniforms().set("u_exposure", ocean.getExposure());
			ocean.setChanged(false);
		}
		
		ocean.getMaterialOcean().getUniforms().set("u_normalMap", ocean.getNormalMapFramebuffer());
		ocean.getMaterialOcean().getUniforms().set("u_displacementMap", ocean.getDisplacementMapFramebuffer());
		ocean.getMaterialOcean().getUniforms().set("u_projectionMatrix", camera.getProjectionMatrix());
		ocean.getMaterialOcean().getUniforms().set("u_viewMatrix", camera.getMatrixWorldInverse());
		ocean.getMaterialOcean().getUniforms().set("u_cameraPosition", camera.getPosition());
		ocean.getMaterialOcean().setDepthTest(true);
		
		/*
		if (this.ms_Ocean.changed) {
			this.ms_Ocean.materialOcean.uniforms.u_size.value = this.ms_Ocean.size;
			this.ms_Ocean.materialOcean.uniforms.u_sunDirection.value.set( this.ms_Ocean.sunDirectionX, this.ms_Ocean.sunDirectionY, this.ms_Ocean.sunDirectionZ );
			this.ms_Ocean.materialOcean.uniforms.u_exposure.value = this.ms_Ocean.exposure;
			this.ms_Ocean.changed = false;
		}*/
		
		/*
		 this.ms_Ocean.materialOcean.uniforms.u_normalMap.value = this.ms_Ocean.normalMapFramebuffer ;
					this.ms_Ocean.materialOcean.uniforms.u_displacementMap.value = this.ms_Ocean.displacementMapFramebuffer ;
					this.ms_Ocean.materialOcean.uniforms.u_projectionMatrix.value = this.ms_Camera.projectionMatrix ;
					this.ms_Ocean.materialOcean.uniforms.u_viewMatrix.value = this.ms_Camera.matrixWorldInverse ;
					this.ms_Ocean.materialOcean.uniforms.u_cameraPosition.value = this.ms_Camera.position;
					this.ms_Ocean.materialOcean.depthTest = true;
		 */
		
		//update value by UI
		
		controls.update();
		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "ocean2";
	}
}
