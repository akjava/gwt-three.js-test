package com.akjava.gwt.threejsexamples.client.examples.animation.skinning;

import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.controls.OrbitControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.examples.animation.skinning.BlendCharacterGui.BlendData;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class BlendingExample extends AbstractExample{

	@Override
	public String getName() {
		return "animation/skinning/blending";
	}

	
	@Override
	public void animate(double timestamp) {
		//do requestAnimationFrame on super class
		render(timestamp); 
		stats.update();//really deprecate?many still use this
	}
	
	
	public void weightAnimation(BlendData data){
		
		for ( int i = 0; i < data.getAnims().length(); ++i ) {

			blendCharacter.applyWeight(data.getAnims().get(i), data.getWeights().get(i));

		}
	}
	

	private WebGLRenderer renderer;
	private Scene scene;
	private PerspectiveCamera camera;
	

	Clock clock = THREE.Clock();
	boolean isFrameStepping;
	double timeToStep;

	private Stats stats;
	private BlendCharacter blendCharacter;
	private BlendCharacterGui gui;
	private OrbitControls controls;
	private FocusPanel container;
	@Override
	public void init() {
		
		
		
		
		
		container = createContainerPanel();

		scene = THREE.Scene();
		scene.add(THREE.AmbientLight( 0xaaaaaa ));
		DirectionalLight light = THREE.DirectionalLight( 0xffffff, 1.5 );
		light.getPosition().set( 0, 0, 1000 );
		scene.add( light );

		//create renderer
		renderer = THREE.WebGLRenderer(GWTParamUtils.WebGLRenderer().antialias(true).alpha(false));
		renderer.setClearColor( 0x777777);
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio());
		renderer.setSize( (int)getWindowInnerWidth()  , (int)getWindowInnerHeight() );
		renderer.setAutoClear(true);
		container.getElement().appendChild(renderer.getDomElement());
		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
	
		container.add(createAbsoluteHTML("<a href='http://threejs.org' target='_blank'>three.js</a> - Skeletal Animation Blending" +
				"<br><br> Adjust blend weights to affect the animations that are currently playing." +
				"<br> Cross fades (and warping) blend between 2 animations and end with a single animation."
				,100,10));

		
		//resize-handler generate on super-class,take care of gui
		
		
		blendCharacter = new BlendCharacter();
		blendCharacter.load("models/skinned/marine/marine_anims.js", new JSONLoadHandler() {
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				//camera and gui  would be create on call start
				start();
			}
		});
		
	}
	
	private void start(){
		
		 blendCharacter.getRotation().setY(Math.PI * -135 / 180);
				scene.add( blendCharacter.getSkinnedMesh() );
				scene.add(blendCharacter.getSkeletonHelper());

				double aspect = getWindowInnerWidth() / getWindowInnerHeight();
				double radius = blendCharacter.getGeometry().getBoundingSphere().getRadius();

				camera = THREE.PerspectiveCamera( 45, aspect, 1, 10000 );
				camera.getPosition().set( 0.0, radius, radius * 3.5 );

				
				controls = THREEExp.OrbitControls(camera,container.getElement() );
				controls.setTarget(THREE.Vector3( 0, radius, 0 ));
				controls.update();
				
				// Set default weights

				blendCharacter.applyWeight("idle",1.0/3);//must be double value on java
				blendCharacter.applyWeight("walk",1.0/3);//must be double value on java
				blendCharacter.applyWeight("run",1.0/3);//must be double value on java
				
				pauseAnimation();//for gui weight modify
				
				gui = new BlendCharacterGui(blendCharacter,this);
				
				VerticalPanel controlPanel=addResizeHandlerAndCreateGUIPanel();
				controlPanel.add(gui);
				updateGUI();//for show
				
				//render(0);//test
	}
	
	
	public void onWindowResize() {
	
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
	}
	
	
	
	public void render(double now) {//GWT animateFrame has time
		//check ready
		if(gui==null){
			return;
		}
		
		double scale = gui.getTimeScale();
		double delta = clock.getDelta();
		double stepSize = (!isFrameStepping) ? delta * scale: timeToStep;

		//LogUtils.log(stepSize);
		// modify blend weights

		blendCharacter.update( stepSize );
		
		blendCharacter.getSkeletonHelper().update();
		
		//not-paused,need modify weight by hand on GWT
		if(blendCharacter.getMixer().getTimeScale()!=0){
			gui.update(blendCharacter.getMixer().getTime());
		}


		renderer.render( scene, camera );
		stats.update();

		// if we are stepping, consume time
		// ( will equal step size next time a single step is desired )

		timeToStep = 0;
	}


	public void startAnimation(BlendData data) {
		
		blendCharacter.stopAll();
		blendCharacter.unPauseAll();

		// the blend mesh will combine 1 or more animations
		for ( int i = 0; i < data.getAnims().length(); ++i ) {

			blendCharacter.play(data.getAnims().get(i), data.getWeights().get(i));

		}

		isFrameStepping = false;
	}

	
	/* never called
	public void onStopAnimation() {
		blendCharacter.stopAll();
		isFrameStepping = false;
	}
	*/
	

	public void stepAnimation(double stepSize) {
		blendCharacter.unPauseAll();
		isFrameStepping = true;
		timeToStep = stepSize;
	}


	public void pauseAnimation() {
		if( isFrameStepping ){
			blendCharacter.unPauseAll();
		}else{
			blendCharacter.pauseAll();
		}

		isFrameStepping = false;
	}


	public void crossfade(BlendData data) {
		
		blendCharacter.stopAll();
		blendCharacter.crossfade( data.getFrom(), data.getTo(), data.getTime() );

		isFrameStepping = false;
	}


	public void wrap(BlendData data) {
		
		blendCharacter.stopAll();
		blendCharacter.warp( data.getFrom(), data.getTo(), data.getTime() );

		isFrameStepping = false;
	}

	
	

	public void lockCameraChanged(Boolean value) {
		controls.setEnabled(!value);
	}


	public void showModelChanged(Boolean value) {
		blendCharacter.showModel( value );
	}


	public void showSkeletonChanged(Boolean value) {
		blendCharacter.showSkeleton( value );
	}

	@Override
	public String getTokenKey() {
		return "blending";
	}
	

}
