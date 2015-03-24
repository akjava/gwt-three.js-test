package com.akjava.gwt.threejsexamples.client.examples.animation.cloth;

import java.util.List;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.extras.Uniforms;
import com.akjava.gwt.three.client.gwt.materials.ShaderMaterialParameter;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.extras.geometries.BoxGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.ParametricGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.SphereGeometry;
import com.akjava.gwt.three.client.js.extras.helpers.ArrowHelper;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.akjava.gwt.threejsexamples.client.examples.animation.cloth.Cloth.Particle;
import com.akjava.gwt.threejsexamples.client.resources.Bundles;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/*
 * TODO implement GUI
 */
public class ClothExample extends AbstractExample {

	
	Cloth cloth;

	private FocusPanel container;
	private Scene scene;
	private PerspectiveCamera camera;

	private ParametricGeometry clothGeometry;

	private Mesh sphere;

	private ArrowHelper arrow;

	private WebGLRenderer renderer;

	private Stats stats;
	
	private boolean rotate=true;
	
	public void init(){
		
		cloth=new Cloth();
		
		
		container = createContainerPanel();

		// scene

		scene = THREE.Scene();

		scene.setFog(THREE.Fog( 0xcce0ff, 500, 10000 ));
		
		// camera

		camera = THREE.PerspectiveCamera( 30, getWindowInnerWidth() / getWindowInnerHeight(), 1, 10000 );
		camera.getPosition().setY(50) ;
		camera.getPosition().setZ(1500);
		scene.add( camera );
		
		// lights

		DirectionalLight light;
		//materials;

		scene.add(THREE.AmbientLight( 0x666666 ) );
		
		light = THREE.DirectionalLight( 0xdfebff, 1.75 );
		light.getPosition().set( 50, 200, 100 );
		light.getPosition().multiplyScalar( 1.3 );

		light.setCastShadow(true);
		//light.shadowCameraVisible = true;

		light.setShadowMapWidth(1024);
		light.setShadowMapHeight(1024);

		double d = 300;

		light.setShadowCameraLeft(-d);
		light.setShadowCameraRight(d);
		light.setShadowCameraTop(d);
		light.setShadowCameraBottom(-d);

		light.setShadowCameraFar(1000);
		light.setShadowDarkness(0.5);

		scene.add( light );
		
		// cloth material

		Texture clothTexture = ImageUtils.loadTexture( "textures/patterns/circuit_pattern.png" );
		clothTexture.setWrapS(THREE.WrappingModes.RepeatWrapping());
		clothTexture.setWrapT(THREE.WrappingModes.RepeatWrapping());
		clothTexture.setAnisotropy(16);

		MeshPhongMaterial clothMaterial = THREE.MeshPhongMaterial(
				GWTParamUtils.MeshPhongMaterial().alphaTest(0.5).ambient(0xffffff).color(0xffffff).specular(0x030303).emissive(0x111111).shiness(10)
				.map(clothTexture).side(THREE.Side.DoubleSide()));

		// cloth geometry
		clothGeometry = THREE.ParametricGeometry( cloth.clothFunction, cloth.w, cloth.h );
		clothGeometry.setDynamic(true);
		clothGeometry.computeFaceNormals();

		//shadow
		Uniforms uniforms=Uniforms.create().setTexture("texture", clothTexture);
		String vertexShader=Bundles.INSTANCE.vertexShaderDepth().getText();
		String fragmentShader=Bundles.INSTANCE.fragmentShaderDepth().getText();
		// cloth mesh

		Mesh object = THREE.Mesh( clothGeometry, clothMaterial );
		object.getPosition().set( 0, 0, 0 );
		object.setCastShadow(true);
		object.setReceiveShadow(true);
		scene.add( object );

		
		object.setCustomDepthMaterial(THREE.ShaderMaterial(GWTParamUtils.ShaderMaterial().uniforms(uniforms).vertexShader(vertexShader).fragmentShader(fragmentShader)));
		

		// sphere

		SphereGeometry ballGeo = THREE.SphereGeometry( cloth.ballSize, 20, 20 );//var ballGeo = new THREE.SphereGeometry( ballSize, 20, 20 );
		MeshPhongMaterial ballMaterial = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff));//		var ballMaterial = new THREE.MeshPhongMaterial( { color: 0xffffff } );

		sphere = THREE.Mesh( ballGeo, ballMaterial );//		sphere = new THREE.Mesh( ballGeo, ballMaterial );
		sphere.setCastShadow(true);//		sphere.castShadow = true;
		sphere.setReceiveShadow(true);//		sphere.receiveShadow = true;
		scene.add( sphere );

		// arrow

		arrow = THREE.ArrowHelper( THREE.Vector3( 0, 1, 0 ), THREE.Vector3( 0, 0, 0 ), 50, 0xff0000 );//arrow = new THREE.ArrowHelper( new THREE.Vector3( 0, 1, 0 ), new THREE.Vector3( 0, 0, 0 ), 50, 0xff0000 );
		arrow.getPosition().set( -200, 0, -200 );//arrow.position.set( -200, 0, -200 );
		// scene.add( arrow );
		
		// ground

		Texture groundTexture = ImageUtils.loadTexture( "textures/terrain/grasslight-big.jpg" );//var groundTexture = THREE.ImageUtils.loadTexture( "textures/terrain/grasslight-big.jpg" );
		groundTexture.setWrapS(THREE.WrappingModes.RepeatWrapping());//groundTexture.wrapS = groundTexture.wrapT = THREE.RepeatWrapping;
		groundTexture.setWrapT(THREE.WrappingModes.RepeatWrapping());
		groundTexture.getRepeat().set( 25, 25 );//groundTexture.repeat.set( 25, 25 );
		groundTexture.setAnisotropy(16);//groundTexture.anisotropy = 16;
		
		MeshPhongMaterial groundMaterial = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff).specular(0x111111).map(groundTexture) );//var groundMaterial = new THREE.MeshPhongMaterial( { color: 0xffffff, specular: 0x111111, map: groundTexture } );

		Mesh mesh = THREE.Mesh( THREE.PlaneBufferGeometry( 20000, 20000 ), groundMaterial );//var mesh = new THREE.Mesh( new THREE.PlaneBufferGeometry( 20000, 20000 ), groundMaterial );
		mesh.getPosition().setY(-250);//mesh.position.y = -250;
		mesh.getRotation().setX(- Math.PI / 2);//mesh.rotation.x = - Math.PI / 2;
		mesh.setReceiveShadow(true);//mesh.receiveShadow = true;
		scene.add( mesh );

		// poles

		BoxGeometry poleGeo = THREE.BoxGeometry( 5, 375, 5 );//var poleGeo = new THREE.BoxGeometry( 5, 375, 5 );
		MeshPhongMaterial poleMat = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff).specular(0x111111).shiness(100) );//var poleMat = new THREE.MeshPhongMaterial( { color: 0xffffff, specular: 0x111111, shiness: 100 } );

		mesh = THREE.Mesh( poleGeo, poleMat );//var mesh = new THREE.Mesh( poleGeo, poleMat );
		mesh.getPosition().setX(-125);//mesh.position.x = -125;
		mesh.getPosition().setY(-62);//mesh.position.y = -62;
		mesh.setReceiveShadow(true);//mesh.receiveShadow = true;
		mesh.setCastShadow(true);//mesh.castShadow = true;
		scene.add( mesh );

		mesh = THREE.Mesh( poleGeo, poleMat );//var mesh = new THREE.Mesh( poleGeo, poleMat );
		mesh.getPosition().setX(125);//mesh.position.x = 125;
		mesh.getPosition().setY(-62);//mesh.position.y = -62;
		mesh.setReceiveShadow(true);//mesh.receiveShadow = true;
		mesh.setCastShadow(true);//mesh.castShadow = true;
		scene.add( mesh );

		mesh = THREE.Mesh( THREE.BoxGeometry( 255, 5, 5 ), poleMat );//var mesh = new THREE.Mesh( new THREE.BoxGeometry( 255, 5, 5 ), poleMat );
		mesh.getPosition().setY(-250 + 750/2);//mesh.position.y = -250 + 750/2;
		mesh.getPosition().setX(0);//mesh.position.x = 0;
		mesh.setReceiveShadow(true);//mesh.receiveShadow = true;
		mesh.setCastShadow(true);//mesh.castShadow = true;
		scene.add( mesh );

		BoxGeometry gg = THREE.BoxGeometry( 10, 10, 10 );//var gg = new THREE.BoxGeometry( 10, 10, 10 );
		mesh = THREE.Mesh( gg, poleMat );//var mesh = new THREE.Mesh( gg, poleMat );
		mesh.getPosition().setY(-250);//mesh.position.y = -250;
		mesh.getPosition().setX(125);//mesh.position.x = 125;
		mesh.setReceiveShadow(true);//mesh.receiveShadow = true;
		mesh.setCastShadow(true);//mesh.castShadow = true;
		scene.add( mesh );

		mesh = THREE.Mesh( gg, poleMat );//var mesh = new THREE.Mesh( gg, poleMat );
		mesh.getPosition().setY(-250);//mesh.position.y = -250;
		mesh.getPosition().setX(-125);//mesh.position.x = -125;
		mesh.setReceiveShadow(true);//mesh.receiveShadow = true;
		mesh.setCastShadow(true);//mesh.castShadow = true;
		scene.add( mesh );

		//
		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(true) );//renderer = new THREE.WebGLRenderer( { antialias: true } );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize((int)getWindowInnerWidth()  , (int)getWindowInnerHeight());
		renderer.setClearColor( scene.getFog().getColor() );//renderer.setClearColor( scene.fog.color );

		
		container.getElement().appendChild(renderer.getDomElement());

		renderer.setGammaInput(true);//renderer.gammaInput = true;
		renderer.setGammaOutput(true);//renderer.gammaOutput = true;

		renderer.setShadowMapEnabled(true);//renderer.shadowMapEnabled = true;

		//

		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());

		//

		//window.addEventListener( 'resize', onWindowResize, false );

		sphere.setVisible(false);
		
		//TODO create-gui
		
		//setDebugAnimateOneTimeOnly(false);
		
		createGUI();
		
	}
	
	public void createGUI(){
		VerticalPanel gui=addResizeHandlerAndcreateGUIPanel();//need for window-resize
		
		CheckBox lockCamera=new CheckBox("Lock Camera");
		gui.add(lockCamera);
		lockCamera.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				rotate=!event.getValue();
			}
		});
		
		CheckBox wind=new CheckBox("Wind");
		gui.add(wind);
		wind.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				cloth.wind=event.getValue();
			}
		});
		wind.setValue(true);
		
		CheckBox showSphere=new CheckBox("Show Ball");
		gui.add(showSphere);
		showSphere.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				sphere.setVisible(event.getValue());
			}
		});
		
		final ListBox pinsBox=new ListBox();
		pinsBox.addItem("Center only pin");
		pinsBox.addItem("Top all pins");
		pinsBox.addItem("First only pin");
		pinsBox.addItem("No pin");
		pinsBox.addItem("2 pins");
		
		pinsBox.setSelectedIndex(1);//default
		
		pinsBox.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				int selection=pinsBox.getSelectedIndex();
				cloth.pins=cloth.pinsFormation.get(selection);
			}
		});
		gui.add(pinsBox);
		
	}
	
	public void render(double time){
		
		double timer = time * 0.0002;

		List<Particle> p = cloth.particles;

		for ( int i = 0, il = p.size(); i < il; i ++ ) {

			clothGeometry.getVertices().get(i).copy( p.get(i).position);

		}

		clothGeometry.computeFaceNormals();
		clothGeometry.computeVertexNormals();

		clothGeometry.setNormalsNeedUpdate(true);//clothGeometry.normalsNeedUpdate = true;
		clothGeometry.setVerticesNeedUpdate(true);//clothGeometry.verticesNeedUpdate = true;

		sphere.getPosition().copy( cloth.ballPosition );//sphere.position.copy( ballPosition );

		if ( rotate ) {

			camera.getPosition().setX(Math.cos( timer ) * 1500);//camera.position.x = Math.cos( timer ) * 1500;
			camera.getPosition().setZ(Math.sin( timer ) * 1500);//camera.position.z = Math.sin( timer ) * 1500;
		}

		camera.lookAt( scene.getPosition() );

		renderer.render( scene, camera );
		
	}
	@Override
	public String getName() {
		return "animation/cloth";
	}
	@Override
	public void animate(double time) {
		
		cloth.windStrength = Math.cos( time / 7000 ) * 20 + 40;
		cloth.windForce.set( Math.sin( time / 2000 ), Math.cos( time / 3000 ), Math.sin( time / 1000 ) ).normalize().multiplyScalar( cloth.windStrength );
		
		arrow.setLength( cloth.windStrength );
		arrow.setDirection( cloth.windForce );
		
		cloth.simulate(time,clothGeometry,sphere);//set otherwhere?
		
		render(time); 
		stats.update();//really deprecate?many still use this
	}
	@Override
	public void onWindowResize() {
		LogUtils.log("windows-resized:"+getWindowInnerWidth() +","+ getWindowInnerHeight());
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
	}
}
