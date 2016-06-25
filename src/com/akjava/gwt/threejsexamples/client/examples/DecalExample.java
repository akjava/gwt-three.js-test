package com.akjava.gwt.threejsexamples.client.examples;

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.examples.js.THREEExp;
import com.akjava.gwt.three.client.examples.js.controls.OrbitControls;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.gwt.core.Intersect;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.core.Raycaster;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.math.Euler;
import com.akjava.gwt.three.client.js.math.Matrix4;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Line;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.akjava.gwt.threejsexamples.client.LabeledInputRangeWidget;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class DecalExample extends AbstractExample{

	@Override
	public String getName() {
		return "decal";
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
	double fov;
	Vector3 cameraTarget;
	private OrbitControls controls;
	private Line line;
	private Raycaster raycaster;
	private Mesh mouseHelper;
	private Vector2 mouse;
	private Mesh mesh;
	
	private JSParameter intersection;
	private JsArray<Mesh> decals;
	@Override
	public void init() {
		decals=JavaScriptUtils.createJSArray();
		
		Texture decalDiffuse = ImageUtils.loadTexture( "textures/decal/decal-diffuse.png" );
		Texture decalNormal = ImageUtils.loadTexture( "textures/decal/decal-normal.jpg" );
		
		decalMaterial = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().specular(0x444444).map(decalDiffuse).normalMap(decalNormal).normalScale(THREE.Vector2(1,1)).shininess(30).transparent(true).depthTest(true).depthWrite(false).polygonOffset(true).polygonOffsetFactor(- 4).wireframe(false) );//var decalMaterial = new THREE.MeshPhongMaterial( {specular: 0x444444,map: decalDiffuse,normalMap: decalNormal,normalScale: new THREE.Vector2( 1, 1 ),shininess: 30,transparent: true,depthTest: true,depthWrite: false,polygonOffset: true,polygonOffsetFactor: - 4,wireframe: false} );
		
		p = THREE.Vector3( 0, 0, 0 );
		r = THREE.Euler( 0, 0, 0 );
		s = THREE.Vector3( 10, 10, 10 );
		up = THREE.Vector3( 0, 1, 0 );
		check = THREE.Vector3( 1, 1, 1 );
		
		intersection=JSParameter.createParameter().set("intersects", false).set("point", THREE.Vector3()).set("normal", THREE.Vector3());
		fov=45;
		mouse=THREE.Vector2();
		
		clock=THREE.Clock();
		
		 SCREEN_WIDTH = getWindowInnerWidth();
		 SCREEN_HEIGHT = getWindowInnerHeight();
		 
		 windowHalfX= (int)(SCREEN_WIDTH/2);
		 windowHalfY= (int)(SCREEN_HEIGHT/2);

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(true) );//THREE.WebGLRenderer( { antialias: true } );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );

		// scene
		scene = THREE.Scene();
	
		// camera
		camera = THREE.PerspectiveCamera(55, getWindowInnerWidth()/getWindowInnerHeight(), 1, 1000);
		camera.getPosition().set(0, 0, 100);
		

		cameraTarget=THREE.Vector3();
		
		controls = THREEExp.OrbitControls( camera, renderer.getDomElement());//controls = new THREE.OrbitControls( camera, renderer.domElement );
		controls.setMinDistance(50);//controls.minDistance = 50;
		controls.setMaxDistance(200);//controls.maxDistance = 200;

		scene.add( THREE.AmbientLight( 0x443333 ) );//scene.add( new THREE.AmbientLight( 0x443333 ) );

		DirectionalLight light = THREE.DirectionalLight( 0xffddcc, 1 );//var light = new THREE.DirectionalLight( 0xffddcc, 1 );
		light.getPosition().set( 1, 0.75, 0.5 );//light.position.set( 1, 0.75, 0.5 );
		scene.add( light );

		light = THREE.DirectionalLight( 0xccccff, 1 );//var light = new THREE.DirectionalLight( 0xccccff, 1 );
		light.getPosition().set( -1, 0.75, -0.5 );//light.position.set( -1, 0.75, -0.5 );
		scene.add( light );

		Geometry geometry = THREE.Geometry();//var geometry = new THREE.Geometry();
		geometry.getVertices().push( THREE.Vector3() );//geometry.vertices.push( new THREE.Vector3(), new THREE.Vector3() );
		geometry.getVertices().push( THREE.Vector3() );
		
		line = THREE.Line( geometry, THREE.LineBasicMaterial( GWTParamUtils.LineBasicMaterial().linewidth(4) ) );//line = new THREE.Line( geometry, new THREE.LineBasicMaterial( { linewidth: 4 } ) );
		scene.add( line );
		
		loadLeePerrySmith();
		
		raycaster = THREE.Raycaster();//raycaster = new THREE.Raycaster();

		mouseHelper = THREE.Mesh( THREE.BoxGeometry( 1, 1, 10 ), THREE.MeshNormalMaterial() );//mouseHelper = new THREE.Mesh( new THREE.BoxGeometry( 1, 1, 10 ), new THREE.MeshNormalMaterial() );
		mouseHelper.setVisible(false);//mouseHelper.visible = false;
		scene.add( mouseHelper );

		
		container.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				moved = false;
			}
		});
		container.addMouseUpHandler(new MouseUpHandler() {
			
			@Override
			public void onMouseUp(MouseUpEvent event) {
				checkIntersection();
				if ( ! moved ) shoot();
			}
		});
		
		container.addMouseMoveHandler(new MouseMoveHandler() {
			
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				//clientX is not support frame
				int x=event.getX();
				int y=event.getY();
				
				mouse.setX(( x / getWindowInnerWidth() ) * 2 - 1);//mouse.x = ( x / window.innerWidth ) * 2 - 1;
				mouse.setY(- ( y / getWindowInnerHeight() ) * 2 + 1);//mouse.y = - ( y / window.innerHeight ) * 2 + 1;

				checkIntersection();
			}
		});
		//TODO
		//container.addTouchMoveHandler(new )
		
		//todo change on UI
		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<strong>Decal Splatter</strong><br />Click or tap to shoot.</p>"
				,100,10));
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
	}
	
	boolean projectionCamera=false;

	private boolean isProjectionCamera(){
		return projectionCamera;
	}
	private double getMaxScale(){
		return maxScale;
	}
	private double getMinScale(){
		return minScale;
	}
	private boolean isRotate(){
		return rotate;
	}
	
	
	protected void shoot() {
		if ( isProjectionCamera()){//if ( params.projection == 'camera' ) {

			Vector3 dir = cameraTarget.clone();//var dir = camera.target.clone();
			dir.sub( camera.getPosition());//dir.sub( camera.position );

			p = intersection.getObject("point").cast();

			Matrix4 m = THREE.Matrix4();//var m = new THREE.Matrix4();
			Vector3 c = dir.clone();
			c.negate();
			c.multiplyScalar( 10 );
			c.add( p );
			m.lookAt( p, c, up );
			m = m.extractRotation( m );

			Object3D dummy = THREE.Object3D();//dummy = new THREE.Object3D();
			dummy.getRotation().setFromRotationMatrix( m );//dummy.rotation.setFromRotationMatrix( m );
			r.set( dummy.getRotation().getX(), dummy.getRotation().getY(), dummy.getRotation().getZ());//r.set( dummy.rotation.x, dummy.rotation.y, dummy.rotation.z );

			} else {

			p = intersection.getObject("point").cast();
			r.copy( mouseHelper.getRotation());//r.copy( mouseHelper.rotation );

			}

			double scale = getMinScale() + Math.random() * (getMaxScale() -getMinScale());//var scale = params.minScale + Math.random() * ( params.maxScale - params.minScale );
			s.set( scale, scale, scale );

			if ( isRotate()) r.setZ(Math.random() * 2 * Math.PI);//if ( params.rotate ) r.z = Math.random() * 2 * Math.PI;

			MeshPhongMaterial material = decalMaterial.clone().cast();
			material.getColor().setHex( (int)(Math.random() * 0xffffff) );//material.color.setHex( Math.random() * 0xffffff );

			Mesh m = THREE.Mesh( THREEExp.DecalGeometry( mesh, p, r, s, check ), material );//var m = new THREE.Mesh( new THREE.DecalGeometry( mesh, p, r, s, check ), material );
			decals.push( m );
			scene.add( m );
	}

	protected void checkIntersection() {
		if (mesh==null ) return;//not loaded

		raycaster.setFromCamera( mouse, camera );

		JsArray<Mesh> array=JavaScriptUtils.createJSArray(mesh);
		
		JsArray<Intersect> intersects = raycaster.intersectObjects(array);

		if ( intersects.length() > 0 ) {

		Vector3 p = intersects.get(0).getPoint();
		mouseHelper.getPosition().copy( p );//mouseHelper.position.copy( p );
		Vector3 pt=intersection.getObject("point").cast();
		pt.copy( p );//intersection.point.copy( p );

		Vector3 n = intersects.get(0).getFace().getNormal().clone();//var n = intersects[ 0 ].face.normal.clone();
		n.multiplyScalar( 10 );
		n.add( p);//n.add( intersects[ 0 ].point );
		Vector3 normal=intersection.getObject("normal").cast();
		normal.copy( intersects.get(0).getFace().getNormal());//intersection.normal.copy( intersects[ 0 ].face.normal );
		mouseHelper.lookAt( n );
		

		line.getGeometry().getVertices().get(0).copy( pt);//line.geometry.vertices[ 0 ].copy( intersection.point );
		line.getGeometry().getVertices().get(1).copy( n );//line.geometry.vertices[ 1 ].copy( n );
		line.getGeometry().setVerticesNeedUpdate(true);//line.geometry.verticesNeedUpdate = true;

		intersection.set("intersects",true);//intersection.intersects = true;

		} else {

		intersection.set("intersects",false);//intersection.intersects = false;

		}
	}

	private boolean moved;
	private Vector3 up;
	private Euler r;
	private Vector3 p;
	private Vector3 s;
	private MeshPhongMaterial decalMaterial;
	private Vector3 check;
	
	private int maxScale=20;
	private int minScale=10;
	private boolean rotate=true;
	
	private void removeDecals(){
		for(int i=0;i<decals.length();i++){
			scene.remove(decals.get(i));
			decals.set(i, null);
		}
		decals=JavaScriptUtils.createJSArray();
	}
	
	private void loadLeePerrySmith() {
		JSONLoader loader=THREE.JSONLoader();
		loader.load("obj/leeperrysmith/LeePerrySmith.js", new JSONLoadHandler() {
			
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				MeshPhongMaterial material = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().specular(0x111111).map(ImageUtils.loadTexture( "obj/leeperrysmith/Map-COL.jpg" )).specularMap(ImageUtils.loadTexture( "obj/leeperrysmith/Map-SPEC.jpg" )).normalMap(ImageUtils.loadTexture( "obj/leeperrysmith/Infinite-Level_02_Tangent_SmoothUV.jpg" )).normalScale(THREE.Vector2( 0.75,0.75)).shininess(25) );//var material = new THREE.MeshPhongMaterial( {specular: 0x111111,map: THREE.ImageUtils.loadTexture( 'obj/leeperrysmith/Map-COL.jpg' ),specularMap: THREE.ImageUtils.loadTexture( 'obj/leeperrysmith/Map-SPEC.jpg' ),normalMap: THREE.ImageUtils.loadTexture( 'obj/leeperrysmith/Infinite-Level_02_Tangent_SmoothUV.jpg' ),normalScale: new THREE.Vector2( 0.75, 0.75 ),shininess: 25} );
				mesh = THREE.Mesh( geometry, material );//mesh = new THREE.Mesh( geometry, material );
				scene.add( mesh );
				mesh.getScale().set( 10, 10, 10 );//mesh.scale.set( 10, 10, 10 );
			}
		});
	}

	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
		
		final ListBox listBox=new ListBox();
		gui.add(listBox);
		listBox.addItem("From cam to mesh");
		listBox.addItem("Normal to mesh");
		listBox.setSelectedIndex(1);
		listBox.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				projectionCamera=listBox.getSelectedIndex()==0;
			}
		});
		
		
		LabeledInputRangeWidget minInput=new LabeledInputRangeWidget("minScale", 1, 30,1);
		gui.add(minInput);
		minInput.setValue(10);
		minInput.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				minScale=event.getValue().intValue();
			}
			
		});
		gui.add(minInput);
		
		LabeledInputRangeWidget maxInput=new LabeledInputRangeWidget("maxScale", 1, 30,1);
		gui.add(maxInput);
		maxInput.setValue(20);
		maxInput.addtRangeListener(new ValueChangeHandler<Number>() {

			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				maxScale=event.getValue().intValue();
			}
			
		});
		gui.add(maxInput);
		
		
		CheckBox rotateCheck=new CheckBox("rotate");
		rotateCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				rotate=event.getValue();
			}
			
		});
		gui.add(rotateCheck);
		rotateCheck.setValue(true);
		
		Button clearBt=new Button("clear",new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				removeDecals();
			}
		});
		gui.add(clearBt);
		
	}
	

	



	
	
	public void onWindowResize() {
		SCREEN_WIDTH = getWindowInnerWidth();
		SCREEN_HEIGHT = getWindowInnerHeight();
	
		//re read because of double
		camera.setAspect(SCREEN_WIDTH / SCREEN_HEIGHT);
		camera.updateProjectionMatrix();

		renderer.setSize( SCREEN_WIDTH , SCREEN_HEIGHT );

	}
	
	public void render(double now) {
		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "decal";
	}
}
