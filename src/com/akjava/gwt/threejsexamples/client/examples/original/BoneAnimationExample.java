package com.akjava.gwt.threejsexamples.client.examples.original;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.boneanimation.AnimationBone;
import com.akjava.gwt.three.client.gwt.ui.LabeledInputRangeWidget2;
import com.akjava.gwt.three.client.java.ThreeLog;
import com.akjava.gwt.three.client.java.utils.AnimationUtils;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.animation.KeyframeTrack;
import com.akjava.gwt.three.client.js.animation.tracks.QuaternionKeyframeTrack;
import com.akjava.gwt.three.client.js.animation.tracks.VectorKeyframeTrack;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.helpers.SkeletonHelper;
import com.akjava.gwt.three.client.js.lights.AmbientLight;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.math.Euler;
import com.akjava.gwt.three.client.js.math.Quaternion;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.LineSegments;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.objects.SkinnedMesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class BoneAnimationExample extends AbstractExample{

	@Override
	public String getName() {
		return "BoneAnimation Example";
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
	
	private SkinnedMesh mesh;
	
	private Vector3 point1;
	private Vector3 point2;
	private Vector3 origin;
	/*
	public double calcurateXZ(Vector3 p1,Vector3 p2){
		Vector3 tmp=THREE.Vector3(p2.getX(),p2.getY(),p2.getZ());
		return p1.angleTo(tmp);
	}
	public double calcurateY(Vector3 p1,Vector3 p2){
		Vector3 tmp=THREE.Vector3(p2.getX(),p2.getY(),p2.getZ());
		return p1.angleTo(tmp);
	}
	*/
	
	@Override
	public void init() {
		
		
		
		point1=THREE.Vector3();//abstract is not initialized
		point2=THREE.Vector3(100,0,0);
		origin=THREE.Vector3().copy(point2);
		
		
		clock=THREE.Clock();
		
		 SCREEN_WIDTH = getWindowInnerWidth();
		 SCREEN_HEIGHT = getWindowInnerHeight();
		 
		 windowHalfX= (int)(SCREEN_WIDTH/2);
		 windowHalfY= (int)(SCREEN_HEIGHT/2);

		FocusPanel container = createContainerPanel();
		container.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				onDocumentMouseMove(event);
			}
		});
		
		container.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				doMouseDown(event);
			}
		});
		
		// renderer
		renderer = THREE.WebGLRenderer(GWTParamUtils.WebGLRenderer().preserveDrawingBuffer(true));
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		renderer.setClearColor( THREE.Color( 0xffffff ) );
		container.getElement().appendChild( renderer.getDomElement() );

		// scene
		scene = THREE.Scene();
	
		
		// camera
		double cameraY=700;
		camera = THREE.PerspectiveCamera(45, getWindowInnerWidth()/getWindowInnerHeight(), .1, 10000);
		camera.getPosition().set(0, cameraY, 500);
		camera.lookAt(point1);
		
		root = THREE.Mesh(THREE.SphereBufferGeometry(10, 10, 10),THREE.MeshLambertMaterial(GWTParamUtils.MeshLambertMaterial().color(0xff0000)));
		scene.add(root);
		root.getPosition().copy(point1);
		
		sphere1 = THREE.Mesh(THREE.SphereBufferGeometry(10, 10, 10),THREE.MeshLambertMaterial(GWTParamUtils.MeshLambertMaterial().color(0x0000ff).wireframe(true)));
		scene.add(sphere1);
		
		
		
		
		Geometry box=THREE.BoxGeometry(30, 30, 30);
		box.setBones(makeBones());
		
	
		//SkinnedMesh
		mesh=THREE.SkinnedMesh(box, THREE.MeshLambertMaterial(GWTParamUtils.MeshLambertMaterial().skinning(true).color(0x00ff00).wireframe(true)));
		scene.add(mesh);
		mixer=THREE.AnimationMixer(mesh);
		
		helper = THREE.SkeletonHelper(mesh);
		scene.add(helper);
		
		
		
		//make light
		AmbientLight ambient = THREE.AmbientLight( 0xaaaaaa );//var ambient = new THREE.AmbientLight( 0xffffff );
		scene.add( ambient );

		DirectionalLight directionalLight = THREE.DirectionalLight( 0x333333 );//var directionalLight = new THREE.DirectionalLight( 0x444444 );
		directionalLight.getPosition().set( -1, 1, 1 ).normalize();//directionalLight.position.set( -1, 1, 1 ).normalize();
		scene.add( directionalLight );

		

		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML(
				"<div style='text:white'>" +
				"<a href='http://threejs.org' target='_blank'>three.js</a>" +
				"  - Bone Animtion" +
				"</div>"
				,100,10));
		
		
		//handle resize & gui
		gui=initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		
	}
	
	public JsArray<AnimationBone> makeBones(){
		JsArray<AnimationBone> bones=JavaScriptObject.createArray().cast();
		AnimationBone bone=AnimationUtils.createAnimationBone();
		bone.setParent(-1);
		bone.setName("root");
		bone.setPos(point1);
		bones.push(bone);
		
		
		
		//bone.setRotq(q);
		
		
		
		AnimationBone bone1=AnimationUtils.createAnimationBone();
		bone1.setParent(0);
		bone1.setName("bone1");
		bone1.setPos(point2);
		bones.push(bone1);
		
		return bones;
	}
	
	
	
	protected void doMouseDown(MouseDownEvent event) {
		//double mx=event.getX();
		//double my=event.getY();
		//point2.setY(point2.getY()+10);
		
		
		
		
		//root.lookAt(point2);
		
		
		/*
		Matrix4 m4=THREE.Matrix4();
		m4.lookAt(point2, point1, Object3D.getDefaultUp());
		
		Euler changedEuler = THREE.Euler(0, 0, 0).setFromRotationMatrix(m4);
		
		ThreeLog.log(point2);
		ThreeLog.log(changedEuler);
		
		double x=changedEuler.getX()-defaultEuler.getX();
		double y=changedEuler.getY()-defaultEuler.getY();
		double z=changedEuler.getZ()-defaultEuler.getZ();
		//Quaternion q=THREE.Quaternion().setFromEuler(THREE.Euler(x, y, z), false);
		
		Quaternion q=THREE.Quaternion().setFromRotationMatrix(m4);
		
		
		//LogUtils.log(q);
		//make angle
		//mesh.getSkeleton().getBones().get(0).setRotationFromQuaternion(q);
		
		*/
		
		
		
		
		/*
		 * i don't know how to update by hand,give up and 
		 */
		/*
		mesh.getSkeleton().getBones().get(0).setRot(quaternion);
		mesh.updateMatrixWorld(true);
		mesh.setMatrixWorldNeedsUpdate(true);
		*/
		
	}
	LineSegments selectedLine;
	private VerticalPanel initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		//TODO add other ui or after return;
		
		
		LabeledInputRangeWidget2 xRange=new LabeledInputRangeWidget2("x", -200, 200, 1);
		xRange.addtRangeListener(new ValueChangeHandler<Number>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				x=event.getValue().doubleValue();
				updadaRange();
			}
		});
		xRange.setValue(x);
		
		LabeledInputRangeWidget2 yRange=new LabeledInputRangeWidget2("y", -200, 200, 1);
		yRange.addtRangeListener(new ValueChangeHandler<Number>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				y=event.getValue().doubleValue();
				updadaRange();
			}
		});
		yRange.setValue(y);
		
		
		LabeledInputRangeWidget2 zRange=new LabeledInputRangeWidget2("z", -200, 200, 1);
		zRange.addtRangeListener(new ValueChangeHandler<Number>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				z=event.getValue().doubleValue();
				updadaRange();
			}
		});
		zRange.setValue(z);
		
		
		gui.add(xRange);
		gui.add(yRange);
		gui.add(zRange);
	
		
		
		return gui;
	}
	
	public void updadaRange(){
		point2.set(x, y, z);
		
		
		double length=point2.distanceTo(point1);
		
		Vector3 modified=origin.clone().normalize().multiplyScalar(length);
		
		
		Quaternion quaternion = THREE.Quaternion().setFromUnitVectors( origin.clone().normalize() ,point2.clone().normalize() );
		
		doAnimation("test",0,quaternion,modified);
	}
	
	private double x=100,y,z;
	

	private VerticalPanel gui;
	

	
	int mouseX,mouseY;
	private Euler defaultEuler;
	private Mesh sphere1;
	private SkeletonHelper helper;
	
	protected void onDocumentMouseMove(MouseMoveEvent event) {
		mouseX = ( event.getClientX() - windowHalfX );
		mouseY = ( event.getClientY() - windowHalfY )*2;
	}
	
	private AnimationMixer mixer;
	private Mesh root;
	public void doAnimation(String name,int boneIndex,Quaternion q,Vector3 pos){
		JsArray<KeyframeTrack> tracks=JavaScriptObject.createArray().cast();
		
			JsArrayNumber times=JavaScriptObject.createArray().cast();
			times.push(0);
			
			//I'm not sure is there reset-pose has value
			JsArrayNumber values=JsArray.createArray().cast();
			concat(values,q.toArray());
			QuaternionKeyframeTrack track=THREE.QuaternionKeyframeTrack(".bones["+boneIndex+"].quaternion", times, values);
			tracks.push(track);
			
			
			//position changed
			if(pos!=null){
				
				JsArrayNumber times2=JavaScriptObject.createArray().cast();
				times2.push(0);
				
				//I'm not sure is there reset-pose has value
				JsArrayNumber values2=JsArray.createArray().cast();
				concat(values2,pos.toArray());
				VectorKeyframeTrack track2=THREE.VectorKeyframeTrack(".bones["+(boneIndex+1)+"].position", times2, values2);
				tracks.push(track2);
			}
			
			
		
		AnimationClip clip=THREE.AnimationClip(name, -1, tracks);
		//LogUtils.log(track.validate());
		
		mixer.stopAllAction();
		mixer.uncacheClip(clip);//reset can cache?
		mixer.clipAction(clip).play();
		
	}
	public void concat(JsArrayNumber target,JsArrayNumber values){
		for(int i=0;i<values.length();i++){
			target.push(values.get(i));
		}
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
		sphere1.getPosition().copy(point2);
		helper.update();
		
		if(mixer!=null){
			mixer.update(1.0/60);
		}
		
		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "boneAnimation";
	}
}
