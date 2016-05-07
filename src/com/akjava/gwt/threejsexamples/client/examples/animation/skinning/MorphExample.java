package com.akjava.gwt.threejsexamples.client.examples.animation.skinning;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.boneanimation.AnimationData;
import com.akjava.gwt.three.client.gwt.boneanimation.AnimationHierarchyItem;
import com.akjava.gwt.three.client.gwt.boneanimation.AnimationKey;
import com.akjava.gwt.three.client.gwt.core.BoundingBox;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.BufferGeometry;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.helpers.SkeletonHelper;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.math.THREEMath;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.objects.Points;
import com.akjava.gwt.three.client.js.objects.SkinnedMesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class MorphExample extends AbstractExample{

	@Override
	public String getName() {
		return "animation/skinning/morph";
	}

	@Override
	public void animate(double timestamp) {
		//do requestAnimationFrame on super class
		render(timestamp);
		stats.update();//really deprecate?many still use this
	}

	private WebGLRenderer renderer;
	private Scene scene;
	private PerspectiveCamera camera;
	
	
	
	Clock clock = THREE.Clock();
	
	SkeletonHelper helper;
	private int windowHalfX,windowHalfY;
	private int mouseX,mouseY;
	
	AnimationMixer mixer;
	@Override
	public void init() {
		
		double SCREEN_WIDTH=getWindowInnerWidth();
		double SCREEN_HEIGHT=getWindowInnerHeight();
		
		windowHalfX=(int) (SCREEN_WIDTH/2);
		windowHalfY=(int) (SCREEN_HEIGHT/2);
		
		
		
		final int FLOOR = -250;
		
		FocusPanel container = createContainerPanel();
		
		
		
		container.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				onDocumentMouseMove(event);
			}
		});
		/*
		 * no need make dummy html panel?
		HTMLPanel div=new HTMLPanel(""); 
		div.getElement().appendChild(renderer.getDomElement());
		focusPanel.add(div);
		*/
		
		//critical problem without cast value is Integer!!!
		camera = THREE.PerspectiveCamera( 30, SCREEN_WIDTH / SCREEN_HEIGHT, 1, 10000 );
		camera.getPosition().setZ(2200);
		
		
		scene = THREE.Scene();

		scene.setFog(THREE.Fog( 0xffffff, 2000, 10000 ));

		scene.add( camera );
		// GROUND

		BufferGeometry geometry = THREE.PlaneBufferGeometry( 16000, 16000 );
		Material material = THREE.MeshPhongMaterial(GWTParamUtils.MeshPhongMaterial().emissive(0xbbbbbb));
		
		Mesh ground =  THREE.Mesh( geometry, material );
		ground.getPosition().set( 0, FLOOR, 0 );
		ground.getRotation().setX(-Math.PI/2);
		scene.add( ground );

		ground.setReceiveShadow(true);
		
		// LIGHTS

		Light ambient = THREE.HemisphereLight(  0x111111, 0x444444 );
		scene.add( ambient );


		
		DirectionalLight light = THREE.DirectionalLight( 0xebf3ff, 1.5 );
		light.getPosition().set( 0, 140, 500 ).multiplyScalar( 1.1 );
		scene.add( light );
		
		light.setCastShadow(true);

		light.setShadowMapWidth(1024);
		light.setShadowMapHeight(2048);

		int d = 390;
		light.setShadowCameraLeft(-d);
		light.setShadowCameraRight(d);
		light.setShadowCameraTop(d * 1.5);
		light.setShadowCameraBottom(-d);

		light.setShadowCameraFar(3500);
		//light.shadowCameraVisible = true;

		
		
		renderer = THREE.WebGLRenderer(GWTParamUtils.WebGLRenderer().antialias(true));
		renderer.setClearColor( scene.getFog().getColor());
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio());
		renderer.setSize( (int)SCREEN_WIDTH, (int)SCREEN_HEIGHT );
		container.getElement().appendChild(renderer.getDomElement());

		renderer.setGammaInput(true);
		renderer.setGammaOutput(true);
		//renderer.getDomElement().getStyle().setPosition(Position.RELATIVE);

		renderer.getShadowMap().setEnabled(true);
		
		JSONLoader loader =  THREE.JSONLoader();
		loader.load( "models/skinned/knight.js",new JSONLoadHandler() {
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				createScene( geometry, materials, 0, FLOOR, -300, 60 );
			}
		});
		
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//TODO HTML method
		
		
		//container.getElement().appendChild(test.getElement());
		container.add(createAbsoluteHTML("<a href='http://threejs.org' target='_blank'>three.js</a> webgl - skinning + morphing- knight by <a href='http://vimeo.com/36113323'>apendua</a>"
				,100,10));
		
		initGUI();
		
	}
	
	private void initGUI() {
		
		
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
		CheckBox model=new CheckBox("show model");
		model.setValue(true);
		model.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				mesh.setVisible(event.getValue());
			}
		});
		gui.add(model);
		
		
		CheckBox bone=new CheckBox("show skeleton");
		bone.setValue(false);
		bone.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				helper.setVisible(event.getValue());
			}
		});
		gui.add(bone);
	}
	

	


	protected void onDocumentMouseMove(MouseMoveEvent event) {
		mouseX = ( event.getClientX() - windowHalfX );
		mouseY = ( event.getClientY() - windowHalfY );
	}


	
	
	
	public void onWindowResize() {
		windowHalfX =(int) getWindowInnerWidth() / 2;
		windowHalfY = (int)getWindowInnerHeight() / 2;

		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
	}
	
	
	
	public void ensureLoop(AnimationData animation ) {
		for ( int i = 0; i < animation.getHierarchy().length(); i ++ ) {

			AnimationHierarchyItem bone = animation.getHierarchy().get(i);

			AnimationKey first = bone.getKeys().get(0);
			AnimationKey last = bone.getKeys().get(bone.getKeys().length() - 1 );

			last.setPos(first.getPos());
			last.setRot(first.getRot());
			last.setScl(first.getScl());
		}

	}

	protected void createScene(Geometry geometry, JsArray<Material> materials, int x, int y, int z, int s) {

		//ensureLoop( geometry.getAnimation() );

		geometry.computeBoundingBox();
		BoundingBox bb = geometry.getBoundingBox();
		
		/* useless comment out
		

		String path = "textures/cube/Park2/";
		String format = ".jpg";
		String[] urls = new String[]{
				path + "posx" + format, path + "negx" + format,
				path + "posy" + format, path + "negy" + format,
				path + "posz" + format, path + "negz" + format
		};
	  */

		//var envMap = THREE.ImageUtils.loadTextureCube( urls );

		//var map = THREE.ImageUtils.loadTexture( "textures/UV_Grid_Sm.jpg" );

		//var bumpMap = THREE.ImageUtils.generateDataTexture( 1, 1, new THREE.Color() );
		//var bumpMap = THREE.ImageUtils.loadTexture( "textures/water.jpg" );

		for ( int i = 0; i < materials.length(); i ++ ) {

			MeshPhongMaterial m = materials.get( i ).cast();//how to know this
			m.setSkinning(true);
			m.setMorphTargets(true);

			m.getSpecular().setHSL( 0, 0, 0.1 );

			m.getColor().setHSL( 0.6, 0, 0.6 );
			//m.getAmbient().copy( m.getColor() );

			//m.map = map;
			//m.envMap = envMap;
			//m.bumpMap = bumpMap;
			//m.bumpScale = 2;

			//m.combine = THREE.MixOperation;
			//m.reflectivity = 0.75;

			//m.setWrapAround(true);

		}

		
		//faild convert geometry to buffergeometry
		mesh = THREE.SkinnedMesh( geometry, THREE.MeshFaceMaterial( materials ) );
		
		LogUtils.log(mesh);
		
		
		mesh.getPosition().set( x, y - bb.getMin().getY() * s, z );
		mesh.getScale().set( s, s, s );
		scene.add( mesh );
		mesh.updateMatrixWorld();//ref later

		mesh.setCastShadow(true);
		mesh.setReceiveShadow(true);

		helper = THREE.SkeletonHelper( mesh );
		helper.gwtGetMaterial().setLinewidth(3);//TODO cheat way,helper.getMaterila().set("lineWidth",3);
		helper.setVisible(false);
		scene.add( helper );

		AnimationClip clipMorpher = AnimationClip.CreateFromMorphTargetSequence( "facialExpressions", mesh.getGeometry().getMorphTargets(), 3 );//var clipMorpher = THREE.AnimationClip.CreateFromMorphTargetSequence( 'facialExpressions', mesh.geometry.morphTargets, 3 );
		AnimationClip clipBones = geometry.getAnimations().get(0);
		
		
		mixer = THREE.AnimationMixer( mesh );//mixer = new THREE.AnimationMixer( mesh );
		mixer.clipAction( clipMorpher ).play();//mixer.addAction( new THREE.AnimationAction( clipMorpher ) );
		mixer.clipAction(  clipBones  ).play();//mixer.addAction( new THREE.AnimationAction( clipBones ) );
		
		//make particles
		Geometry pointGeometry=THREE.Geometry();
		for(int i=0;i<geometry.getVertices().length();i++){
			Vector3 vec=THREE.Vector3().copy(geometry.getVertices().get(i)).applyMatrix4(mesh.getMatrixWorld());
			pointGeometry.getVertices().push(vec);
		}
		points = THREE.Points(pointGeometry,THREE.PointsMaterial(
				GWTParamUtils.PointsMaterial().side(20).color(0xff0000))
				);
		
		//scene.add(points);
		//Points
	}
	
	boolean first;
	SkinnedMesh mesh;
	private Stats stats;
	private Points points;
	public void render(double now) {//GWT animateFrame has time
		double delta = 0.75 * clock.getDelta();
		
		camera.getPosition().gwtIncrementX( (mouseX - camera.getPosition().getX() ) * .05);
		camera.getPosition().setY(THREEMath.clamp( camera.getPosition().getY() + ( - mouseY - camera.getPosition().getY() ) * .05, 0, 1000 ));
		camera.lookAt( scene.getPosition() );
		
		if( mixer!=null ) {
			mixer.update( delta );
			helper.update();
			
			//updateVertexTest();
		}
		
		renderer.render( scene, camera );
	}

	private void updateVertexTest() {
		for(int i=0;i<mesh.getGeometry().getVertices().length();i++){
			points.getGeometry().getVertices().get(i).copy(transformedSkinVertex(mesh,i).applyMatrix4(mesh.getMatrixWorld()));
		}
		points.getGeometry().setVerticesNeedUpdate(true);
	}

	@Override
	public String getTokenKey() {
		return "morph";
	}
	
	//
	public final native Vector3 transformedSkinVertex (SkinnedMesh skin,int index)/*-{
	
	//var skinIndices = (new $wnd.THREE.Vector4 ()).fromAttribute (skin.geometry.getAttribute ('skinIndex'), index);
    //var skinWeights = (new $wnd.THREE.Vector4 ()).fromAttribute (skin.geometry.getAttribute ('skinWeight'), index);
    //var skinVertex = (new $wnd.THREE.Vector3 ()).fromAttribute (skin.geometry.getAttribute ('position'), index).applyMatrix4 (skin.bindMatrix);
   var skinIndices =skin.geometry.skinIndices[index];
   var skinWeights =skin.geometry.skinWeights[index];
   var skinVertex =skin.geometry.vertices[index].clone().applyMatrix4(skin.bindMatrix);
	
    var result = new $wnd.THREE.Vector3 (), temp = new $wnd.THREE.Vector3 (), tempMatrix = new $wnd.THREE.Matrix4 (); properties = ['x', 'y', 'z', 'w'];
    for (var i = 0; i < 4; i++) {
        var boneIndex = skinIndices[properties[i]];
        tempMatrix.multiplyMatrices (skin.skeleton.bones[boneIndex].matrixWorld, skin.skeleton.boneInverses[boneIndex]);
       // result.add (temp.copy (skinVertex).multiplyScalar (skinWeights[properties[i]]).applyMatrix4 (tempMatrix));
        result.add (temp.copy (skinVertex).applyMatrix4 (tempMatrix).multiplyScalar (skinWeights[properties[i]]));
    }
    return result.applyMatrix4 (skin.bindMatrixInverse);
	}-*/;
}
