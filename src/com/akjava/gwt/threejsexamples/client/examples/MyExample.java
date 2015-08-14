package com.akjava.gwt.threejsexamples.client.examples;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.shaders.ExampleShaders;
import com.akjava.gwt.three.client.gwt.extras.Uniforms;
import com.akjava.gwt.three.client.gwt.materials.MeshBasicMaterialParameter;
import com.akjava.gwt.three.client.gwt.materials.MeshLambertMaterialParameter;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.loaders.ImageLoader.ImageLoadHandler;
import com.akjava.gwt.three.client.js.materials.MeshBasicMaterial;
import com.akjava.gwt.three.client.js.materials.MeshLambertMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderTarget;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.renderers.shaders.WebGLShaders.ShaderChunk.UniformsUtils;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class MyExample extends AbstractExample{

	@Override
	public String getName() {
		return "test";
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
	private Scene textureScene;
	private Camera textureCamera;

	
	

	
	@Override
	public void init() {
	
		 WIDTH = (int)getWindowInnerWidth();//var WIDTH = window.innerWidth;
		 HEIGHT = (int)getWindowInnerHeight();//var HEIGHT = window.innerHeight;

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer();//renderer = new THREE.WebGLRenderer();
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );//renderer.setPixelRatio( window.devicePixelRatio );
		renderer.setSize( WIDTH, HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );
		
		// scene
		scene = THREE.Scene();//scene = new THREE.Scene();
	
		// camera
		camera = THREE.PerspectiveCamera(55, getWindowInnerWidth()/getWindowInnerHeight(), 0.5, 300000);//camera = new THREE.PerspectiveCamera(VIEW_ANGLE, ASPECT, NEAR, FAR);
		
		
		

		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - test</a>"
				,100,10));
		
		
		scene.add(THREE.AmbientLight(0xffffff));
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		scene.add(light);
		
		
		//this is fullscreen plain geometry
		//TODO create method
		Texture texture=ImageUtils.loadTexture("tmpnormal.jpg");
		final Mesh mesh=THREE.Mesh(THREE.PlaneBufferGeometry(WIDTH, HEIGHT, 1, 1), THREE.MeshLambertMaterial(MeshLambertMaterialParameter.create().map(texture)));
		scene.add(mesh);
		
		double vFOV = camera.getFov() * Math.PI / 180; 
		double cameraZ= HEIGHT / (2 * Math.tan(vFOV / 2) );
		
		//i'm not sure?
		 	
		  //  double ratio = 2 * Math.tan( vFOV / 2 );
		    //double screen = ratio * ((double)WIDTH / HEIGHT) ; 

		    //double size = THREE.Box3().setFromObject(mesh).getMax().getY();

		   
		    
		   // double dist = (size/screen) / 4; 
		    
		    LogUtils.log("distance:"+cameraZ);
		    
		    camera.getPosition().set(0, 0, cameraZ);
		    //camera.getPosition().set(0, 0, boxSize+dist);//ms_Camera.position.set(450, 350, 450);
			//camera.lookAt(THREE.Vector3());//ms_Camera.lookAt(new THREE.Vector3());
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		textureCamera = THREE.OrthographicCamera();
		textureCamera.getPosition().setZ(1);
		
		textureScene = THREE.Scene();
		final Mesh  textureMesn=THREE.Mesh(  THREE.PlaneBufferGeometry( 2, 2 ) );
		textureScene.add(textureMesn);
		
		textureMesn.setMaterial(THREE.MeshBasicMaterial(MeshBasicMaterialParameter.create().color(0xffffff)));
		
		
		final WebGLRenderTarget textureBuffer=THREE.WebGLRenderTarget(512, 512);//maybe work
		textureBuffer.setGenerateMipmaps(false);
		
		THREE.ImageLoader().load("textures/waternormals.jpg", new ImageLoadHandler() {
			
			@Override
			public void onProgress(NativeEvent progress) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLoad(ImageElement imageElement) {
				/*
				Texture texture=THREE.Texture(imageElement);
				texture.setNeedsUpdate(true);
				
				
				Uniforms uniforms=UniformsUtils.clone( ExampleShaders.TriangleBlurShader().uniforms());
				uniforms.set("texture", texture);
				uniforms.set("delta", 4,4);
				//ShaderMaterial material=THREE.ShaderMaterial(GWTParamUtils.ShaderMaterial().uniforms(uniforms).fragmentShader(ExampleShaders.TriangleBlurShader().fragmentShader()).vertexShader(ExampleShaders.TriangleBlurShader().vertexShader()));
				
				MeshBasicMaterial material=THREE.MeshBasicMaterial(MeshBasicMaterialParameter.create().color(0xffffff));
				
				textureMesn.setMaterial(material);
				
				renderer.render(textureScene, textureCamera, textureBuffer, true);
				
				//so now draw
				
				
				//MeshLambertMaterial meshMaterial=THREE.MeshLambertMaterial(MeshLambertMaterialParameter.create().color(0xffffff));
				//meshMaterial.setMap(textureBuffer);
				MeshLambertMaterial meshMaterial=mesh.getMaterial().cast();
				
				//somehow not work
				//meshMaterial.setMap(texture);
				
				
				meshMaterial.setMap(textureBuffer);
				
				
				//meshMaterial.setMap(ImageUtils.loadTexture("textures/waternormals.jpg"));
				
				
				meshMaterial.setNeedsUpdate(true);
				*/
			}
			
			@Override
			public void onError(NativeEvent error) {
				// TODO Auto-generated method stub
				
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
		renderer.render(scene, camera);
		//renderer.render(textureScene, textureCamera);
	}

	@Override
	public String getTokenKey() {
		return "test";
	}
}
