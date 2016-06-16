package com.akjava.gwt.threejsexamples.client.examples.original;

import java.util.Map;

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
import com.akjava.gwt.three.client.js.math.Matrix4;
import com.akjava.gwt.three.client.js.math.Quaternion;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.LineSegments;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.objects.SkinnedMesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threejsexamples.client.AbstractExample;
import com.google.common.collect.Maps;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
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
	private Vector3 point3;
	private Vector3 point2Origin;
	private Vector3 point3Origin;
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
	private Mesh sphere2;
	private Mesh sphere3;
	private Mesh sphere4;
	
	@Override
	public void init() {
		
		
		
		point1=THREE.Vector3();//abstract is not initialized
		point2=THREE.Vector3(x,y,z);
		point3=THREE.Vector3(x2,y2,z2);
		point2Origin=THREE.Vector3().copy(point2);
		point3Origin=THREE.Vector3().copy(point3);//origin must be sub
		
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
		
		sphere1 = THREE.Mesh(THREE.SphereBufferGeometry(5, 5, 5),THREE.MeshLambertMaterial(GWTParamUtils.MeshLambertMaterial().color(0x0000ff).wireframe(true)));
		scene.add(sphere1);
		
		
		sphere2 = THREE.Mesh(THREE.SphereBufferGeometry(5, 5, 5),THREE.MeshLambertMaterial(GWTParamUtils.MeshLambertMaterial().color(0x000088).wireframe(true)));
		scene.add(sphere2);
		
		sphere3 = THREE.Mesh(THREE.SphereBufferGeometry(5, 5, 5),THREE.MeshLambertMaterial(GWTParamUtils.MeshLambertMaterial().color(0x00f800).wireframe(true)));
		scene.add(sphere3);
		
		sphere4 = THREE.Mesh(THREE.SphereBufferGeometry(10, 10, 10),THREE.MeshLambertMaterial(GWTParamUtils.MeshLambertMaterial().color(0xf000f0).wireframe(true)));
		scene.add(sphere4);
		
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
		bone1.setPos(point2);//no need sub,root is 000
		bones.push(bone1);
		
		
		AnimationBone bone2=AnimationUtils.createAnimationBone();
		bone2.setParent(1);
		bone2.setName("bone2");
		bone2.setPos(point3.clone().sub(point2));
		bones.push(bone2);
		
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
		
		
		LabeledInputRangeWidget2 xRange=new LabeledInputRangeWidget2("x", -400, 400, 1);
		xRange.addtRangeListener(new ValueChangeHandler<Number>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				x=event.getValue().doubleValue();
				updadaRange();
			}
		});
		xRange.setValue(x);
		
		LabeledInputRangeWidget2 yRange=new LabeledInputRangeWidget2("y", -400, 400, 1);
		yRange.addtRangeListener(new ValueChangeHandler<Number>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				y=event.getValue().doubleValue();
				updadaRange();
			}
		});
		yRange.setValue(y);
		
		
	final	LabeledInputRangeWidget2 zRange=new LabeledInputRangeWidget2("z", -400, 400, 1);
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
	
		gui.add(new HTML("Sphere2"));
		
		LabeledInputRangeWidget2 xRange2=new LabeledInputRangeWidget2("x", -200, 200, 1);
		xRange2.addtRangeListener(new ValueChangeHandler<Number>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				x2=event.getValue().doubleValue();
				updadaRange();
			}
		});
		xRange2.setValue(x2);
		
		LabeledInputRangeWidget2 yRange2=new LabeledInputRangeWidget2("y", -200, 200, 1);
		yRange2.addtRangeListener(new ValueChangeHandler<Number>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				y2=event.getValue().doubleValue();
				updadaRange();
			}
		});
		yRange2.setValue(y2);
		
		
		 LabeledInputRangeWidget2 zRange2=new LabeledInputRangeWidget2("z", -200, 200, 1);
		zRange2.addtRangeListener(new ValueChangeHandler<Number>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				z2=event.getValue().doubleValue();
				updadaRange();
			}
		});
		zRange2.setValue(z2);
		
		
		gui.add(xRange2);
		gui.add(yRange2);
		gui.add(zRange2);
		
		Button test=new Button("test z=10",new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				zRange.setValue(10, true);
			}
		});
		gui.add(test);
		
		return gui;
	}
	
	Map<String,Euler> ikMap;
	//Map<String,Vector3> ikMap;
	public void updadaRange(){
		point2.set(x, y, z);
		double length=point2.distanceTo(point1);
		Vector3 modified=point2Origin.clone().normalize().multiplyScalar(length);
		
		
		Vector3 baseLine=point2Origin.clone().sub(point1);
		Quaternion quaternion = THREE.Quaternion().setFromEuler(findEuler(baseLine,point2.clone().sub(point1)), false);
		JsArray<KeyframeTrack> tracks1=makeTrackAnimation("test",0,quaternion,modified,true);
		
		
		point3.set(x2, y2, z2);
		
		//where is correct bone
		Vector3 bone2Origin=point3Origin.clone().sub(point2Origin).applyQuaternion(quaternion).add(point2);
		sphere3.getPosition().copy(bone2Origin);
		
		double length2=point3.distanceTo(point2);
		Vector3 modified2=point3Origin.clone().sub(point2Origin).normalize().multiplyScalar(length2);
		
		Vector3 baseLine2=bone2Origin.clone().sub(point2).normalize().multiplyScalar(length2);
		Euler euler=findEuler(baseLine2,point3.clone().sub(point2));
		Quaternion quaternion2 = THREE.Quaternion().setFromEuler(euler, false);
		
		Vector3 tmp=baseLine2.clone().applyQuaternion(quaternion2);
		tmp.add(point2);
		sphere4.getPosition().copy(tmp);
		
		ThreeLog.log("bone[1]",euler);
		
		//quaternion2.multiplyQuaternions(quaternion2, quaternion);
		
		JsArray<KeyframeTrack> tracks2=makeTrackAnimation("test1",1,quaternion2,modified2,false);
		for(int i=0;i<tracks2.length();i++){
			tracks1.push(tracks2.get(i));
		}
		AnimationClip clip=THREE.AnimationClip("test1", -1, tracks1);
		//LogUtils.log(track.validate());
		
		
		mixer.stopAllAction();
		
		mixer.uncacheClip(clip);//reset can cache?
		mixer.clipAction(clip).play();
	}
	
	public Quaternion createAngleQuaternion(double x,double y,double z){
		Quaternion q=THREE.Quaternion();
		
		Quaternion xq=THREE.Quaternion().setFromAxisAngle(THREE.Vector3(1, 0, 0), x);
		q.multiply(xq);
		
		Quaternion yq=THREE.Quaternion().setFromAxisAngle(THREE.Vector3(0, 1, 0), y);
		q.multiply(yq);
		
		Quaternion zq=THREE.Quaternion().setFromAxisAngle(THREE.Vector3(0, 0, 1), z);
		q.multiply(zq);
		
		return q;
	}
	
	private Euler findEuler(Vector3 baseLine,Vector3 target){
		int xincrement=360;
		if(ikMap==null){
			ikMap=Maps.newHashMap();
			
		
		
		for(int x=0;x<360;x+=xincrement){
		for(int y=0;y<360;y++){
			for(int z=0;z<360;z++){
				//ikMap.put(y+","+z,THREE.Euler(0,Math.toRadians( y), Math.toRadians(z),"ZYX"));
				ikMap.put(x+","+y+","+z,THREE.Euler(Math.toRadians( x),Math.toRadians( y), Math.toRadians(z),"XYZ"));
					
			}
			}
		}
		}
		
		
		//pick closed one
		double diff=0;
		
		int closedY=-1;
		int closedZ=-1;
		int closedX=-1;
		
		
		
		for(int x=0;x<360;x+=xincrement){
		for(int y=0;y<360;y+=1){
			for(int z=0;z<360;z+=1){
				if(y==180 && z==180){
					continue;//turn
				}
				Vector3 v=baseLine.clone().applyEuler(ikMap.get(x+","+y+","+z));
				double tmpdiff=v.distanceTo(target);
				if(closedY==-1){//initial
					//ThreeLog.log("point2", point2);
					//ThreeLog.log("v", v);
					//ThreeLog.log("tmpdiff", tmpdiff);
					diff=tmpdiff;
					closedX=x;
					closedY=y;
					closedZ=z;
				}else{
					//ThreeLog.log("tmpdiff-"+y+","+z, tmpdiff);
					if(tmpdiff<diff){
						diff=tmpdiff;
						closedY=y;
						closedZ=z;
						closedX=x;
					}
				}
				
				if(z==0&&y<20){
				//	LogUtils.log(y+","+z+","+tmpdiff);
				}
				
			}
		}
		}
		
		//final
		LogUtils.log(closedY+","+closedZ+","+diff);
		
		Euler euler=THREE.Euler(Math.toRadians(closedX), Math.toRadians(closedY), Math.toRadians(closedZ));
		return euler;
	}
	
	/*
	 * i give up this,i can' test all situation
	 */
	public void updadaRange1(){
		point2.set(x, y, z);
		double length=point2.distanceTo(point1);
		Vector3 modified=point2Origin.clone().normalize().multiplyScalar(length);
		
		/*
		Quaternion quaternion = THREE.Quaternion().setFromUnitVectors( point2Origin.clone().normalize() ,point2.clone().normalize() );
		
		Euler euler=THREE.Euler(0, 0, 0).setFromQuaternion(quaternion, "XYZ", false);
		LogUtils.log("bone1-XY");
		ThreeLog.log(euler);
		*/
		
		//Y-angle
		double ny=point2Origin.clone().setY(0).normalize().angleTo(point2.clone().normalize().setY(0));
		
		
		//Z-angle
		double nz=point2.clone().setY(0).normalize().angleTo(point2.clone().normalize());
		
		
		if(z>0){
			ny*=-1;
		}
		if(y<0){
			nz*=-1;
		}
		//tryturning without Z
		LogUtils.log("Y:"+Math.toDegrees(ny));
		LogUtils.log("Z:"+Math.toDegrees(nz));
		
		Quaternion q=THREE.Quaternion().setFromEuler(THREE.Euler(0, ny, nz), false); 
		doAnimation("test",0,q,modified,true);
		
		
		//bone2
		point3.set(x2, y2, z2);
		
		double length2=point3.distanceTo(point2);
		Vector3 modified2=point3Origin.clone().sub(point2Origin).normalize().multiplyScalar(length2);
		
		Vector3 bone2Origin=point3Origin.clone().applyQuaternion(q);
		LogUtils.log("bone2-origin");
		ThreeLog.log(bone2Origin);
		
		LogUtils.log("pt2");
		LogUtils.log(point2);
		LogUtils.log("sub");
		LogUtils.log(bone2Origin.clone().sub(point2));
		LogUtils.log(point3.clone().sub(point2).setY(0));
		double ny2=bone2Origin.clone().setY(0).angleTo(point3.clone().setY(0));
		
		
		//Z-angle
		double nz2=point3.clone().sub(point2).setY(0).normalize().angleTo(point3.clone().sub(point2).normalize());
		if(z2>0){
			ny2*=-1;
		}
		if(y2<0){
			nz2*=-1;
		}
		LogUtils.log("Y2:"+Math.toDegrees(ny2));
		LogUtils.log("Z2:"+Math.toDegrees(nz2));
		
		Quaternion q2=THREE.Quaternion().setFromEuler(THREE.Euler(0, ny2, nz2), false); 
		
		q2.multiplyQuaternions(q2, q);
		
		doAnimation("test1",1,q2,modified2,false);
		
	}
	//not good when y-changed
	public void updadaRange2(){
		point2.set(x, y, z);
		
		double length=point2.distanceTo(point1);
		
		Vector3 modified=point2Origin.clone().normalize().multiplyScalar(length);
		Vector3 subbed=modified.clone().sub(point2Origin);
		
		Quaternion quaternion = THREE.Quaternion().setFromUnitVectors( point2Origin.clone().normalize() ,point2.clone().normalize() );
		
		doAnimation("test",0,quaternion,modified,true);
		
		Euler euler=THREE.Euler(0, 0, 0).setFromQuaternion(quaternion, "XYZ", false);
		ThreeLog.log("bone[1]",euler);
		
		
		Matrix4 rotate=THREE.Matrix4().makeRotationFromQuaternion(quaternion);
		Matrix4 mixed=THREE.Matrix4().makeTranslation(subbed.getX(), subbed.getY(), subbed.getZ()).multiply(rotate);
		
		
		point3.set(x2, y2, z2);
		
		Vector3 diffPoint=point3.clone().sub(point2);
		double length2=point3.distanceTo(point2);
		
		Vector3 modified2=point3Origin.clone().sub(point2Origin).normalize().multiplyScalar(length2);
		
		ThreeLog.log(point3Origin.clone());
		LogUtils.log("changed1");
		
	 
		//original position seems good
		Vector3 originalPos=point3Origin.clone().sub(point2Origin);
		ThreeLog.log("green-line",originalPos);
		originalPos.applyQuaternion(quaternion);
		//diff.applyMatrix4(mixed);
		originalPos.add(point2);
		
		sphere3.getPosition().copy(originalPos);
		ThreeLog.log(originalPos);
		
		
		//ThreeLog.log(point3Origin.clone().sub(point2Origin).applyMatrix4(m1));
		
		
		Quaternion quaternion2 = THREE.Quaternion().setFromUnitVectors( originalPos.clone().sub(point2).normalize() ,diffPoint.clone().normalize() );
		
		
		//Matrix4 m2=THREE.Matrix4().makeRotationFromQuaternion(quaternion2);
		
		
		//quaternion2=quaternion2.multiplyQuaternions(quaternion2.clone(),quaternion.inverse());
		
		Euler euler2=THREE.Euler(0, 0, 0).setFromQuaternion(quaternion2, "XYZ", false);
		ThreeLog.log("bone[2]",euler2);
		
		doAnimation("test1",1,quaternion2,modified2,false);
	}
	
	private double x=100,y,z;
	private double x2=200,y2=0,z2;

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
	
	
	public JsArray<KeyframeTrack> makeTrackAnimation(String name,int boneIndex,Quaternion q,Vector3 pos,boolean clearAnimation){
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
			
			
		return tracks;
		
		
	}
	
	public void doAnimation(String name,int boneIndex,Quaternion q,Vector3 pos,boolean clearAnimation){
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
		
		if(clearAnimation){
		mixer.stopAllAction();
		}
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
		sphere2.getPosition().copy(point3);
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
