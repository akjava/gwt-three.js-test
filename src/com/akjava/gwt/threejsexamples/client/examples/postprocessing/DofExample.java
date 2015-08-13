package com.akjava.gwt.threejsexamples.client.examples.postprocessing;

import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.postprocessing.BokehPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.EffectComposer;
import com.akjava.gwt.three.client.examples.js.postprocessing.RenderPass;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.gwt.materials.MeshBasicMaterialParameter;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.extras.geometries.SphereGeometry;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.materials.MeshBasicMaterial;
import com.akjava.gwt.three.client.js.materials.MeshDepthMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.akjava.gwt.threejsexamples.client.JsUtils;
import com.akjava.gwt.threejsexamples.client.LabeledInputRangeWidget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.TouchMoveEvent;
import com.google.gwt.event.dom.client.TouchMoveHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class DofExample extends AbstractExample{

	@Override
	public String getName() {
		return "processing/dof";
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
	
	int windowHalfX,windowHalfY;
	private MeshDepthMaterial material_depth;
	private MeshBasicMaterial cubeMaterial;
	private JsArray<JavaScriptObject> zmaterial;
	

	
	
	JsArray<Mesh> objects=JsArray.createArray().cast();
	
	@Override
	public void init() {
	
		 WIDTH = (int)getWindowInnerWidth();
		 HEIGHT = (int)getWindowInnerHeight();
		 
		 windowHalfX=WIDTH/2;
		 windowHalfY=HEIGHT/2;

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer();
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( WIDTH, HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );

		// scene
		scene = THREE.Scene();
	
		// camera
		camera = THREE.PerspectiveCamera(70, getWindowInnerWidth()/getWindowInnerHeight(),1, 3000);
		camera.getPosition().set(0, 0, 200);
		camera.lookAt(THREE.Vector3());

		renderer.setSortObjects(false);//renderer.sortObjects = false;

		material_depth = THREE.MeshDepthMaterial(null);//material_depth = new THREE.MeshDepthMaterial();
		
		String path = "textures/cube/SwedishRoyalCastle/";
		String format = ".jpg";
		JsArrayString urls= JsUtils.of(
				path + "px" + format, path + "nx" + format,
				path + "py" + format, path + "ny" + format,
				path + "pz" + format, path + "nz" + format
			);
		
		Texture textureCube= ImageUtils.loadTextureCube( urls);
		
		MeshBasicMaterialParameter parameters=GWTParamUtils.MeshBasicMaterial().color(0xff1100).envMap(textureCube).shading(THREE.FlatShading);
		
		//cubeMaterial = THREE.MeshBasicMaterial( parameters);//cubeMaterial = new THREE.MeshBasicMaterial(  { color: 0xff1100, envMap: textureCube, shading: THREE.FlatShading });
		
		singleMaterial = false;

		
		//no plan to support single material
		
		//if( singleMaterial ) zmaterial = JsUtils.of(cubeMaterial);

		SphereGeometry geo = THREE.SphereGeometry( 1, 20, 10 );
		
		double start = System.currentTimeMillis();

		int xgrid = 14,
			ygrid = 9,
			zgrid = 14;

		nobjects = xgrid * ygrid * zgrid;

		int c = 0;

		//var s = 0.25;
		int s = 60;
		
		materials = JsArray.createArray().cast();
		 Mesh mesh=null;
		for (int i = 0; i < xgrid; i ++ )
			for (int j = 0; j < ygrid; j ++ )
			for (int k = 0; k < zgrid; k ++ ) {

				if ( singleMaterial ) {

					//mesh = THREE.Mesh( geo, zmaterial ,null);

				} else {
					materials.set(c, THREE.MeshBasicMaterial( parameters ));
					mesh =THREE.Mesh( geo, materials.get(c) );

				}

				double x = 200 * ( i - xgrid/2 );
				double y = 200 * ( j - ygrid/2 );
				double z = 200 * ( k - zgrid/2 );

				mesh.getPosition().set( x, y, z );//mesh.position.set( x, y, z );
				mesh.getScale().set( s, s, s );//mesh.scale.set( s, s, s );

				mesh.setMatrixAutoUpdate(false);//mesh.matrixAutoUpdate = false;
				mesh.updateMatrix();

				scene.add( mesh );
				objects.push( mesh );

				c ++;

			}

		scene.setMatrixAutoUpdate(false);//scene.matrixAutoUpdate = false;

		initPostprocessing();

		renderer.setAutoClear(false);//renderer.autoClear = false;
		
		container.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				onDocumentMouseMove(event);
			}
		});
		container.addTouchStartHandler(new TouchStartHandler() {
			
			@Override
			public void onTouchStart(TouchStartEvent event) {
				onDocumentTouchStart(event);
			}
		});
		container.addTouchMoveHandler(new TouchMoveHandler() {
			
			@Override
			public void onTouchMove(TouchMoveEvent event) {
				onDocumentTouchMove(event);
			}
		});
		
		
		//TODO create GUI
		
		//stats
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
	protected void onDocumentTouchMove(TouchMoveEvent event) {
		if ( event.getTouches().length() == 1 ) {

			event.preventDefault();

			mouseX = event.getTouches().get( 0 ).getPageX() - windowHalfX;
			mouseY = event.getTouches().get( 0 ).getPageY() - windowHalfY;

		}
	}

	protected void onDocumentTouchStart(TouchStartEvent event) {
		if ( event.getTouches().length() == 1 ) {

			event.preventDefault();

			mouseX = event.getTouches().get( 0 ).getPageX() - windowHalfX;
			mouseY = event.getTouches().get( 0 ).getPageY() - windowHalfY;

		}
	}

	int mouseX;
	int mouseY;
	private int nobjects;
	private JsArray<Material> materials;
	private boolean singleMaterial;
	private BokehPass bokehPass;
	private EffectComposer composer;
	protected void onDocumentMouseMove(MouseMoveEvent event) {
		mouseX = ( event.getClientX() - windowHalfX );
		mouseY = ( event.getClientY() - windowHalfY );
	}

	
	private void initPostprocessing() {
		RenderPass renderPass = THREEExp.RenderPass( scene, camera );

		bokehPass = THREEExp.BokehPass( scene, camera, 
				JSParameter.createParameter()
				.set("focus",1.0)
				.set("aperture",0.025)
				.set("maxblur",1.0)
				.set("width",WIDTH)
				.set("height",HEIGHT)
				);
		
		bokehPass.setRenderToScreen(true);//bokehPass.renderToScreen = true;

		composer = THREEExp.EffectComposer( renderer );

		composer.addPass( renderPass );
		composer.addPass( bokehPass );
		
	}

	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
		LabeledInputRangeWidget focus=new  LabeledInputRangeWidget("focus",  0.0, 3.0, 0.025 );
		focus.addtRangeListener(new ValueChangeHandler<Number>() {
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				bokehPass.getUniforms().set("focus",event.getValue().doubleValue());
			}
		});
		LabeledInputRangeWidget aperture=new  LabeledInputRangeWidget("aperture",  0.001, 0.2, 0.001 );
		aperture.addtRangeListener(new ValueChangeHandler<Number>() {
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				bokehPass.getUniforms().set("aperture",event.getValue().doubleValue());
			}
		});
		LabeledInputRangeWidget maxblur=new  LabeledInputRangeWidget("maxblur", 0.0, 3.0, 0.025 );
		maxblur.addtRangeListener(new ValueChangeHandler<Number>() {
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				bokehPass.getUniforms().set("maxblur",event.getValue().doubleValue());
			}
		});
		
		/*
		 focus: 		1.0,
					aperture:	0.025,
					maxblur:	1.0
		 */
		focus.setValue(1.0);
		aperture.setValue(0.025);
		maxblur.setValue(1.0);
		
		gui.add(focus);
		gui.add(aperture);
		gui.add(maxblur);
	}
	

	



	
	
	public void onWindowResize() {
		
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
	
		 windowHalfX=(int)getWindowInnerWidth()/2;
		 windowHalfY=(int)getWindowInnerHeight() /2;
	}
	
	public void render(double now) {
		double time = now * 0.00005;

		camera.getPosition().gwtIncrementX( ( mouseX - camera.getPosition().getX()) * 0.036);//camera.position.x += ( mouseX - camera.position.x ) * 0.036;
		camera.getPosition().gwtIncrementY( ( - (mouseY) - camera.getPosition().getY()) * 0.036);//camera.position.y += ( - (mouseY) - camera.position.y ) * 0.036;

		if ( !singleMaterial ) {
		for(int i = 0; i < nobjects; i ++ ) {

			double h = ( 360 * ( (double)i / nobjects + time ) % 360 ) / 360;
			((MeshBasicMaterial)materials.get(i).cast()).getColor().setHSL( h, 1, 0.5 );//materials[ i ].color.setHSL( h, 1, 0.5 );

			}
		}
		camera.lookAt( scene.getPosition());//camera.lookAt( scene.position );
		composer.render( 0.1 );
	}

	@Override
	public String getTokenKey() {
		return "dof";
	}
}
