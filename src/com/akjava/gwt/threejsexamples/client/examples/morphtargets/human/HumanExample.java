package com.akjava.gwt.threejsexamples.client.examples.morphtargets.human;

import java.util.List;
import java.util.Map;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.controls.OrbitControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.loaders.XHRLoader;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRLoadHandler;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.akjava.gwt.threejsexamples.client.LabeledInputRangeWidget;
import com.akjava.gwt.threejsexamples.client.examples.morphtargets.human.UCSCharacter.CheckLoadComplete;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;


public class HumanExample extends AbstractExample{

	@Override
	public String getName() {
		return "morphtargets/human";
	}

	@Override
	public void animate(double timestamp) {
		//do requestAnimationFrame on super class
		controls.update();
		render(timestamp);
		stats.update();//really deprecate?many still use this
	}

	private WebGLRenderer renderer;
	private Scene scene;
	private PerspectiveCamera camera;
	
	
	private int windowHalfX,windowHalfY;
	private int mouseX,mouseY;
	Clock clock;
	private OrbitControls controls;
	@Override
	public void init() {
		//setDebugAnimateOneTimeOnly(true);
		clock=THREE.Clock();
		
		FocusPanel container = createContainerPanel();
		
		windowHalfX=(int) (getWindowInnerWidth()/2);
		windowHalfY=(int) (getWindowInnerHeight()/2);
		
		container.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				onDocumentMouseMove(event);
			}
		});
		
		camera = THREE.PerspectiveCamera( 60, getWindowInnerWidth() / getWindowInnerHeight(), 1, 15000 );//camera = new THREE.PerspectiveCamera( 45, window.innerWidth / window.innerHeight, 1, 15000 );
		camera.getPosition().set(2000, 5000, 5000);//camera.position.z = 500;

		scene = THREE.Scene();//scene = new THREE.Scene();
		
		
		DirectionalLight light = THREE.DirectionalLight( 0xffffff, 1 );//var light = new THREE.DirectionalLight( 0xffffff, 1 );
		light.getPosition().set( 0, 140, 500 );//light.position.set( 0, 140, 500 );
		light.getPosition().multiplyScalar( 1.1 );//light.position.multiplyScalar( 1.1 );
		light.getColor().setHSL( 0.6, 0.075, 1 );//light.color.setHSL( 0.6, 0.075, 1 );
		scene.add( light );

		//

		light = THREE.DirectionalLight( 0xffffff, 1 );//var light = new THREE.DirectionalLight( 0xffffff, 1 );
		light.getPosition().set( 0, -1, 0 );//light.position.set( 0, -1, 0 );
		scene.add( light );


		
		
	


		// renderer

		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(false) );//renderer = new THREE.WebGLRenderer( { antialias: false } );
		renderer.setClearColor( 0xffffff );//renderer.setClearColor( scene.fog.color );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( (int)getWindowInnerWidth(), (int)getWindowInnerHeight()  );
		container.getElement().appendChild( renderer.getDomElement() );
		
		
		character = new UCSCharacter();
		character.setCheckLoadComplete(new CheckLoadComplete() {
			
			@Override
			public void onLoadComplete() {
				setupSkinsGUI();
				setupMorphsGUI();
			}
		});
				
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
		
		XHRLoader loader=THREE.XHRLoader();
		loader.load("models/skinned/UCS_config.json", new XHRLoadHandler() {
			
			
			
			@Override
			public void onLoad(String text) {
				JSONValue value=JSONParser.parseStrict(text);
				
				character.loadParts( value );
				scene.add( character.getRoot() );
			}
			
		});
		
		controls = THREEExp.OrbitControls( camera, renderer.getDomElement());//controls = new THREE.OrbitControls( camera, renderer.domElement );
		controls.getCenter().set( 0, 3000, 0);//controls.center.set( 0, 3000, 0);
		
		//controls.addEventListener( 'change', render );
		
	}
	
	private List<LabeledInputRangeWidget> sliders=Lists.newArrayList();
	protected void setupMorphsGUI() {
		guiRootPanel.add(new Label("Morphs"));
		
		JsArrayString morphs=character.getMorphs();
		for( int i=0;i<morphs.length();i++){
			LabeledInputRangeWidget slider=new LabeledInputRangeWidget(morphs.get(i),0,100,1);
			guiRootPanel.add(slider);
			slider.setValue(0);//default
			
			slider.addtRangeListener(new ValueChangeHandler<Number>() {
				@Override
				public void onValueChange(ValueChangeEvent<Number> event) {
					callbackMorph();
				}
			});
			sliders.add(slider);
			}
	}

	Map<String,Double> influences=Maps.newHashMap();
	protected void callbackMorph() {
		
		JsArrayString morphs=character.getMorphs();
		for( int i=0;i<morphs.length();i++){
			String name=morphs.get(i);
			double value=sliders.get(i).getValue();
			influences.put(name, value);
		}
		character.updateMorphs(influences);
	}

	protected void setupSkinsGUI() {
		guiRootPanel.add(new Label("Skins"));
		
		JsArray<Texture> skins=character.getSkins();
		
		for(int i=0;i<skins.length();i++){
			final int index=i;
			Button bt=new Button(skins.get(i).getName());
			bt.setWidth("200px");
			bt.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					character.setSkin(index);
				}
			});
			guiRootPanel.add(bt);
		}
	}

	private void initResizeHandlerAndGUI() {
		guiRootPanel = addResizeHandlerAndCreateGUIPanel();
		
		guiRootPanel.setWidth("200px");//some widget broke,like checkbox without parent size
		guiRootPanel.setSpacing(2);
		
		//add widget on loaded
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

	private UCSCharacter character;
	private VerticalPanel guiRootPanel;
	public void render(double time) {//GWT animateFrame has time

		double delta = 0.75 * clock.getDelta();

		// update skinning

		character.getMixer().update( delta );//character.mixer.update( delta );

		renderer.render( scene, camera );
	}

	@Override
	public String getTokenKey() {
		return "morphtargets";
	}
}
