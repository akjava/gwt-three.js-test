package com.akjava.gwt.threejsexamples.client.examples.misc;

import java.io.IOException;

import com.akjava.gwt.html5.client.media.OscillatorNode;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.controls.FirstPersonControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.audio.Audio;
import com.akjava.gwt.three.client.js.core.audio.AudioAnalyser;
import com.akjava.gwt.three.client.js.core.audio.AudioListener;
import com.akjava.gwt.three.client.js.core.audio.PositionalAudio;
import com.akjava.gwt.three.client.js.extras.geometries.SphereGeometry;
import com.akjava.gwt.three.client.js.extras.helpers.GridHelper;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.akjava.gwt.threejsexamples.client.LabeledInputRangeWidget;
import com.google.common.collect.Lists;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class SoundExample extends AbstractExample{

	@Override
	public String getName() {
		return "misc/sound";
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

	double SCREEN_WIDTH;
	double SCREEN_HEIGHT;

	
	private int windowHalfX,windowHalfY;
	//private int mouseX,mouseY;

	Clock clock;
	private DirectionalLight light;
	private MeshPhongMaterial material_sphere1;
	private MeshPhongMaterial material_sphere2;
	private MeshPhongMaterial material_sphere3;
	private AudioAnalyser analyser1;
	private AudioAnalyser analyser2;
	private AudioAnalyser analyser3;
	private FirstPersonControls controls;
	private PositionalAudio sound1;
	private PositionalAudio sound2;
	private PositionalAudio sound3;
	private Audio sound4;
	private AudioListener listener;
	@Override
	public void init() {
	
		clock=THREE.Clock();
		
		 SCREEN_WIDTH = getWindowInnerWidth();
		 SCREEN_HEIGHT = getWindowInnerHeight();
		 
		 windowHalfX= (int)(SCREEN_WIDTH/2);
		 windowHalfY= (int)(SCREEN_HEIGHT/2);

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer();
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );

		// scene
		scene = THREE.Scene();
		scene.setFog(THREE.FogExp2( 0x000000, 0.0025 ));//scene.fog = new THREE.FogExp2( 0x000000, 0.0025 );

		light = THREE.DirectionalLight( 0xffffff );//light = new THREE.DirectionalLight( 0xffffff );
		light.getPosition().set( 0, 0.5, 1 ).normalize();//light.position.set( 0, 0.5, 1 ).normalize();
		scene.add( light );
	
		// camera
		camera = THREE.PerspectiveCamera(50, getWindowInnerWidth()/getWindowInnerHeight(), 1, 10000);
		camera.getPosition().set( 0, 25, 0 );
		
		listener = THREE.AudioListener();
		camera.add( listener );
		
		SphereGeometry sphere = THREE.SphereGeometry( 20, 32, 16 );//var sphere = new THREE.SphereGeometry( 20, 32, 16 );

		material_sphere1 = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffaa00).shading(THREE.FlatShading).shininess(0) );//material_sphere1 = new THREE.MeshPhongMaterial( { color: 0xffaa00, shading: THREE.FlatShading, shininess: 0 } );
		material_sphere2 = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xff2200).shading(THREE.FlatShading).shininess(0) );//material_sphere2 = new THREE.MeshPhongMaterial( { color: 0xff2200, shading: THREE.FlatShading, shininess: 0 } );
		material_sphere3 = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0x6622aa).shading(THREE.FlatShading).shininess(0) );//material_sphere3 = new THREE.MeshPhongMaterial( { color: 0x6622aa, shading: THREE.FlatShading, shininess: 0 } );

		// sound spheres

		Mesh mesh1 = THREE.Mesh( sphere, material_sphere1 );//var mesh1 = THREE.Mesh( sphere, material_sphere1 );//Mesh mesh1 = THREE.Mesh( sphere, material_sphere1 );//var mesh1 = new THREE.Mesh( sphere, material_sphere1 );
		mesh1.getPosition().set( -250, 30, 0 );//mesh1.getPosition().set( -250, 30, 0 );//mesh1.getPosition().set( -250, 30, 0 );//mesh1.position.set( -250, 30, 0 );
		scene.add( mesh1 );

		sound1 = THREE.PositionalAudio( listener );
		sound1.load( "sounds/358232_j_s_song.ogg" );
		sound1.setRefDistance( 20 );
		sound1.setAutoplay(true);//sound1.setAutoplay(true);//sound1.setAutoplay(true);//sound1.autoplay = true;
		mesh1.add( sound1 );

		//

		Mesh mesh2 = THREE.Mesh( sphere, material_sphere2 );//var mesh2 = THREE.Mesh( sphere, material_sphere2 );//Mesh mesh2 = THREE.Mesh( sphere, material_sphere2 );//var mesh2 = new THREE.Mesh( sphere, material_sphere2 );
		mesh2.getPosition().set( 250, 30, 0 );//mesh2.getPosition().set( 250, 30, 0 );//mesh2.getPosition().set( 250, 30, 0 );//mesh2.position.set( 250, 30, 0 );
		scene.add( mesh2 );

		sound2 = THREE.PositionalAudio( listener );
		sound2.load( "sounds/376737_Skullbeatz___Bad_Cat_Maste.ogg" );
		sound2.setRefDistance( 20 );
		sound2.setAutoplay(true);//sound2.setAutoplay(true);//sound2.setAutoplay(true);//sound2.autoplay = true;
		mesh2.add( sound2 );

		//


		Mesh mesh3 = THREE.Mesh( sphere, material_sphere3 );//var mesh3 = THREE.Mesh( sphere, material_sphere3 );//Mesh mesh3 = THREE.Mesh( sphere, material_sphere3 );//var mesh3 = new THREE.Mesh( sphere, material_sphere3 );
		mesh3.getPosition().set( 0, 30, -250 );//mesh3.getPosition().set( 0, 30, -250 );//mesh3.getPosition().set( 0, 30, -250 );//mesh3.position.set( 0, 30, -250 );
		scene.add( mesh3 );

		sound3 = THREE.PositionalAudio( listener );
		//here is totally part of WebAudio API
		final OscillatorNode oscillator = listener.getContext().createOscillator();//var oscillator = listener.getContext().createOscillator();//var oscillator = listener.getContext().createOscillator();//var oscillator = listener.context.createOscillator();
		oscillator.setType("sine");//oscillator.setType('sine');//oscillator.setType('sine');//oscillator.type = 'sine';
		oscillator.getFrequency().setValue(144);//oscillator.getFrequency().setValue(144);//oscillator.getFrequency().setValue(144);//oscillator.frequency.value = 144;
		oscillator.start(0);
		
		sound3.setNodeSource(oscillator);
		sound3.setRefDistance( 20 );
		sound3.setVolume(0.5);
		mesh3.add(sound3);
		
		// analysers

		analyser1 = THREE.AudioAnalyser( sound1, 32 );//analyser1 = new THREE.AudioAnalyser( sound1, 32 );
		analyser2 = THREE.AudioAnalyser( sound2, 32 );//analyser2 = new THREE.AudioAnalyser( sound2, 32 );
		analyser3 = THREE.AudioAnalyser( sound3, 32 );//analyser3 = new THREE.AudioAnalyser( sound3, 32 );

		// global ambient audio

		sound4 = THREE.Audio( listener );
		sound4.load( "sounds/Project_Utopia.ogg" );
		sound4.setAutoplay(true);//sound4.autoplay = true;
		sound4.setLoop(true);
		sound4.setVolume(0.5);
		
		
		GridHelper helper = THREE.GridHelper( 500, 10 );//var helper = new THREE.GridHelper( 500, 10 );
		helper.getColor1().setHex( 0x444444 );//helper.color1.setHex( 0x444444 );
		helper.getColor2().setHex( 0x444444 );//helper.color2.setHex( 0x444444 );
		helper.getPosition().setY(0.1);//helper.position.y = 0.1;
		scene.add( helper );

		
		controls = THREEExp.FirstPersonControls( camera, renderer.getDomElement());//controls = new THREE.FirstPersonControls( camera, renderer.domElement );

		controls.setMovementSpeed(70);//controls.movementSpeed = 70;
		controls.setLookSpeed(0.05);//controls.lookSpeed = 0.05;
		//controls.setNoFly(true);//controls.noFly = true;
		controls.setLookVertical(false);//controls.lookVertical = false;
		
		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML(
				"<div style='text:white'>" +
				"<a href='http://threejs.org' target='_blank'>three.js</a>" +
				"<a href='http://threejs.org' target='_blank'>three.js</a> - webgl 3d sounds example -music by <a href='http://www.newgrounds.com/audio/listen/358232' target='_blank'>larrylarrybb</a> and<a href='http://www.newgrounds.com/audio/listen/376737' target='_blank'>skullbeatz</a>  and<a href='http://opengameart.org/content/project-utopia-seamless-loop' target='_blank'>congusbongus</a><br/><br/>navigate with WASD / arrows / mouse"+
				"</div>"
				,100,10));
		
		
		//handle resize & gui
		VerticalPanel gui=initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		//TODO implement ui
		gui.add(new Label("sound volume"));
		
		LabeledInputRangeWidget masterVolume=new LabeledInputRangeWidget("master", 0, 1.0, 0.01);
		masterVolume.setValue(listener.getMasterVolume());
		masterVolume.addtRangeListener(new ValueChangeHandler<Number>() {
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				double value=event.getValue().doubleValue();
				listener.setMasterVolume(value);
			}
		});
		gui.add(masterVolume);
		//TODO others volumes
		LabeledInputRangeWidget firstSphereVolume=new LabeledInputRangeWidget("firstSphere", 0, 1.0, 0.01);
		firstSphereVolume.setValue(sound1.getVolume());
		firstSphereVolume.addtRangeListener(new ValueChangeHandler<Number>() {
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				double value=event.getValue().doubleValue();
				sound1.setVolume(value);
			}
		});
		gui.add(firstSphereVolume);
		
		LabeledInputRangeWidget secondSphereVolume=new LabeledInputRangeWidget("secondSphere", 0, 1.0, 0.01);
		secondSphereVolume.setValue(sound2.getVolume());
		secondSphereVolume.addtRangeListener(new ValueChangeHandler<Number>() {
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				double value=event.getValue().doubleValue();
				sound2.setVolume(value);
			}
		});
		gui.add(secondSphereVolume);
		
		LabeledInputRangeWidget thirdSphereVolume=new LabeledInputRangeWidget("thirdSphere", 0, 1.0, 0.01);
		thirdSphereVolume.setValue(sound3.getVolume());
		thirdSphereVolume.addtRangeListener(new ValueChangeHandler<Number>() {
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				double value=event.getValue().doubleValue();
				sound3.setVolume(value);
			}
		});
		gui.add(thirdSphereVolume);
		
		LabeledInputRangeWidget ambientVolume=new LabeledInputRangeWidget("Ambient", 0, 1.0, 0.01);
		ambientVolume.setValue(sound4.getVolume());
		ambientVolume.addtRangeListener(new ValueChangeHandler<Number>() {
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				double value=event.getValue().doubleValue();
				sound4.setVolume(value);
			}
		});
		gui.add(ambientVolume);
		
		
		gui.add(new Label("sound generator"));
		ValueListBox<String> types=new ValueListBox<String>(new Renderer<String>() {

			@Override
			public String render(String object) {
				// TODO Auto-generated method stub
				return object;
			}

			@Override
			public void render(String object, Appendable appendable) throws IOException {
				// TODO Auto-generated method stub
				
			}
		});
		types.setValue("sine");
		types.setAcceptableValues(Lists.newArrayList("sine","square","sawtooth","triangle"));
		types.addValueChangeHandler(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				oscillator.setType(event.getValue());
			}
		});
		gui.add(types);
		
		
		LabeledInputRangeWidget frequency=new LabeledInputRangeWidget("frequency", 50, 5000, 1);
		frequency.setValue(oscillator.getFrequency().getValue());
		frequency.addtRangeListener(new ValueChangeHandler<Number>() {
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				int value=event.getValue().intValue();
				oscillator.getFrequency().setValue(value);
			}
		});
		gui.add(frequency);
	}
	

	
	@Override
	public void stop() {
		super.stop();
		/*
		
		if(sound1.isIsPlaying()){
			sound1.stop();
		}
		if(sound2.isIsPlaying()){
			sound2.stop();
		}
		if(sound3.isIsPlaying()){
			sound3.stop();
		}
		if(sound4.isIsPlaying()){
			sound4.stop();
		}
		*/
		
		listener.getContext().close();//release everything
	}

	private VerticalPanel initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
		return gui;
	}
	

	



	
	
	public void onWindowResize() {
		SCREEN_WIDTH = getWindowInnerWidth();
		SCREEN_HEIGHT = getWindowInnerHeight();
	
		//re read because of double
		camera.setAspect(SCREEN_WIDTH / SCREEN_HEIGHT);
		camera.updateProjectionMatrix();

		renderer.setSize( SCREEN_WIDTH , SCREEN_HEIGHT );
	
		controls.handleResize();
	}
	
	public void render(double now) {
		double delta=clock.getDelta();
		//do something
		
		controls.update( delta );

		//LogUtils.log(analyser1.getData().get(8));
		//LogUtils.log(analyser1.getData().get(8) / 256);
		
		//this is critical java problem take care of math of integer
		
		material_sphere1.getEmissive().setB((analyser1.getData().get(8)) / 256.0);//material_sphere1.emissive.b = analyser1.getData()[ 8 ] / 256;
		material_sphere2.getEmissive().setB(analyser2.getData().get(8)/ 256.0);//material_sphere2.emissive.b = analyser2.getData()[ 8 ] / 256;
		material_sphere3.getEmissive().setB(analyser3.getData().get(8) / 256.0);//material_sphere3.emissive.b = analyser3.getData()[ 8 ] / 256;
		
		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "sound";
	}
}
