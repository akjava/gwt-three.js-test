package com.akjava.gwt.threejsexamples.client.examples.animation.cloth;

import java.util.List;
import java.util.Map;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.boneanimation.AnimationBone;
import com.akjava.gwt.three.client.gwt.extras.Uniforms;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.AnimationUtils;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.animation.KeyframeTrack;
import com.akjava.gwt.three.client.js.animation.tracks.QuaternionKeyframeTrack;
import com.akjava.gwt.three.client.js.animation.tracks.VectorKeyframeTrack;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.geometries.BoxGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.ParametricGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.SphereGeometry;
import com.akjava.gwt.three.client.js.extras.helpers.ArrowHelper;
import com.akjava.gwt.three.client.js.extras.helpers.SkeletonHelper;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.math.Quaternion;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Bone;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.objects.SkinnedMesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.akjava.gwt.threejsexamples.client.examples.animation.cloth.Cloth.Particle;
import com.akjava.gwt.threejsexamples.client.resources.Bundles;
import com.google.common.collect.Maps;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/*
 * TODO implement GUI
 */
public class ClothExample3 extends AbstractExample {

	
	Cloth cloth;

	private FocusPanel container;
	private Scene scene;
	private PerspectiveCamera camera;

	private ParametricGeometry clothGeometry;

	private Mesh sphere;

	private ArrowHelper arrow;

	private WebGLRenderer renderer;

	private Stats stats;
	
	private boolean rotate=false;

	private SkeletonHelper helper;

	private SkinnedMesh clothBoxMesh;
	
	
	
	JsArray<AnimationBone> createBone(Cloth cloth){
		JsArray<AnimationBone> bones=JavaScriptObject.createArray().cast();
		AnimationBone bone=AnimationUtils.createAnimationBone();
		bone.setParent(-1);
		bone.setName("root");
		bone.setPos(THREE.Vector3());
		bones.push(bone);
		
		int index=1;
		
		for(int i=0;i<=cloth.w;i++){
			int parent=0;
			Vector3 parentPos=THREE.Vector3();
			
			for(int j=0;j<=cloth.h;j++){
				
				int ind=(cloth.w+1)*j+i;
				Particle p=cloth.particles.get(ind);
				
				AnimationBone childBone=AnimationUtils.createAnimationBone();
				childBone.setParent(parent);
				childBone.setName(i+","+j);
				
				childBone.setPos(p.getOriginal().clone().sub(parentPos));
				bones.push(childBone);
				
				parent=index;
				index++;
				parentPos=p.getOriginal();
				
			}
			
		}
		
		
		return bones;
	}
	
	AnimationMixer mixer;
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

		
		//light.setShadowMapWidth(1024);
		light.getShadow().getMapSize().setWidth(1024);
		//light.setShadowMapHeight(1024);
		light.getShadow().getMapSize().setHeight(1024);
		double d = 300;

		
		//DirectionalLight return use OrthographicCamera;
		
		light.getShadow().getCamera().gwtCastOrthographicCamera().setLeft(-d);
		light.getShadow().getCamera().gwtCastOrthographicCamera().setRight(d);
		light.getShadow().getCamera().gwtCastOrthographicCamera().setTop(d);
		light.getShadow().getCamera().gwtCastOrthographicCamera().setBottom(-d);
		
		light.getShadow().getCamera().gwtCastOrthographicCamera().setFar(1000);
		
		

		scene.add( light );
		
		// cloth material

		Texture clothTexture = THREE.TextureLoader().load( "textures/patterns/circuit_pattern.png" );
		clothTexture.setWrapS(THREE.RepeatWrapping);
		clothTexture.setWrapT(THREE.RepeatWrapping);
		clothTexture.setAnisotropy(16);

		MeshPhongMaterial clothMaterial = THREE.MeshPhongMaterial(
				GWTParamUtils.MeshPhongMaterial().alphaTest(0.5).color(0xffffff).specular(0x030303).emissive(0x111111).shininess(10)
				.map(clothTexture).side(THREE.DoubleSide).wireframe(true));

		// cloth geometry
		clothGeometry = THREE.ParametricGeometry( cloth.clothFunction, cloth.w, cloth.h );
		clothGeometry.setDynamic(true);
		clothGeometry.computeFaceNormals();
		
		
		BoxGeometry clothBox=THREE.BoxGeometry(cloth.w*cloth.restDistance, cloth.restDistance*cloth.h, 40);
		clothBox.applyMatrix( THREE.Matrix4().makeTranslation( 0,250,0 ) );
		clothBox.setBones(createBone(cloth));
		
		
		
		MeshPhongMaterial boxhMaterial = THREE.MeshPhongMaterial(
				GWTParamUtils.MeshPhongMaterial().alphaTest(0.5).color(0xffffff).specular(0x030303).emissive(0x111111).shininess(10)
				.map(clothTexture).skinning(true));
		
		clothBoxMesh = THREE.SkinnedMesh(clothBox,boxhMaterial);
		mixer=THREE.AnimationMixer(clothBoxMesh);
		scene.add(clothBoxMesh);
		clothBoxMesh.getPosition().set(0, 0, 0);
		
		//LogUtils.log(clothBoxMesh.getSkeleton());
		
		helper = THREE.SkeletonHelper(clothBoxMesh);
		scene.add(helper);

		//shadow
		Uniforms uniforms=Uniforms.create().setTypeAndValue("texture", clothTexture);
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

		Texture groundTexture = THREE.TextureLoader().load( "textures/terrain/grasslight-big.jpg" );//var groundTexture = THREE.ImageUtils.loadTexture( "textures/terrain/grasslight-big.jpg" );
		groundTexture.setWrapS(THREE.RepeatWrapping);//groundTexture.wrapS = groundTexture.wrapT = THREE.RepeatWrapping;
		groundTexture.setWrapT(THREE.RepeatWrapping);
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
		MeshPhongMaterial poleMat = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xffffff).specular(0x111111).shininess(100) );//var poleMat = new THREE.MeshPhongMaterial( { color: 0xffffff, specular: 0x111111, shiness: 100 } );

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

		//renderer.setShadowMapEnabled(true);//renderer.shadowMapEnabled = true;
		renderer.getShadowMap().setEnabled(true);
		//

		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());

		container.add(createAbsoluteHTML("Simple Cloth Simulation<br>Verlet integration with Constrains relaxation"
				,100,10));

		//window.addEventListener( 'resize', onWindowResize, false );

		sphere.setVisible(false);
		
		//TODO create-gui
		
		setDebugAnimateOneTimeOnly(true);
		
		createGUI();
		
	}
	
	public void createGUI(){
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();//need for window-resize
		
		CheckBox lockCamera=new CheckBox("Lock Camera");
		gui.add(lockCamera);
		lockCamera.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				rotate=!event.getValue();
			}
		});
		lockCamera.setValue(!rotate);
		
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
		
		//setDebugAnimateOneTimeOnly(true);
		
		Button bt=new Button("test",new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				animate(System.currentTimeMillis());
			}
		});
		gui.add(bt);
		
	}
	
	//do something cloth
	public void render(double time){
		
		double timer = time * 0.0002;

		List<Particle> p = cloth.particles;

		for ( int i = 0, il = p.size(); i < il; i ++ ) {

			clothGeometry.getVertices().get(i).copy( p.get(i).getPosition());

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
		return "animation/skinning-cloth";
	}
	@Override
	public void animate(double time) {
		
		
		
		cloth.windStrength = Math.cos( time / 7000 ) * 20 + 40;
		cloth.windForce.set( Math.sin( time / 2000 ), Math.cos( time / 3000 ), Math.sin( time / 1000 ) ).normalize().multiplyScalar( cloth.windStrength );
		
		arrow.setLength( cloth.windStrength );
		arrow.setDirection( cloth.windForce );
		
		cloth.simulate(time,clothGeometry,sphere);//set otherwhere?
		
		syncBones();
		
		if(mixer!=null){
			mixer.update(1.0/60);
		}
		
		helper.update();
		
		render(time); 
		stats.update();//really deprecate?many still use this
	}
	
	
	public void syncBones(){
		
		
		JsArray<Bone> bones=clothBoxMesh.getSkeleton().getBones();
		
		Map<Bone,Bone> childAndParent=childAndParentMap(bones);
		Map<String,Vector3> origins=getOriginalPosition(clothBoxMesh.getGeometry());
		Map<Bone,Integer> boneIndex=getBoneIndex(bones);
		
		JsArray<KeyframeTrack> allTracks=JavaScriptObject.createArray().cast();
		
		//no need [0] root
		for(int i=1;i<bones.length();i++){
			int childIndex=i;
			
			Bone child=bones.get(i);
			Bone parent=childAndParent.get(child);
			if(parent==null || parent.getName().equals("root")){
				continue;
			}else{
				//seems ok
				//LogUtils.log("modified");
			}
			int parentIndex=boneIndex.get(parent);
			
			Vector3 childPosition=getPositionByBoneName(child.getName());
			Vector3 parentPosition=getPositionByBoneName(parent.getName());
			
			
			
			
			Vector3 origin=origins.get(child.getName());//origin position already relative parent
			Vector3 point2=childPosition.clone().sub(parentPosition);
			
			/*
			 *
			if(!origin.equals(point2)){
				LogUtils.log("somehow invalid:"+child.getName());
				ThreeLog.log(origins.get(child.getName()));
				ThreeLog.log(origins.get(parent.getName()));
				ThreeLog.log(childPosition);
				ThreeLog.log(parentPosition);
			}
			*/
			
			Vector3 point1=THREE.Vector3();
			
			double length=point2.distanceTo(point1);
			
			//pos for child
			Vector3 modified=origin.clone().normalize().multiplyScalar(length);
			//angle for parent
			Quaternion quaternion = THREE.Quaternion().setFromUnitVectors( origin.clone().normalize() ,point2.clone().normalize() );
			
			mergeTracks(allTracks,makeTracks(childIndex, parentIndex, modified, quaternion));
		}
		
		//LogUtils.log("tracks:"+allTracks.length());//220 tracks
		AnimationClip clip=THREE.AnimationClip("bones", -1, allTracks);
		//LogUtils.log(track.validate());
		
		mixer.stopAllAction();
		mixer.uncacheClip(clip);
		mixer.clipAction(clip).play();
	}
	
	public void mergeTracks(JsArray<KeyframeTrack> allTracks,JsArray<KeyframeTrack> tracks){
		for(int i=0;i<tracks.length();i++){
			allTracks.push(tracks.get(i));
		}
	}
	
	public JsArray<KeyframeTrack> makeTracks(int childIndex,int parentIndex,Vector3 pos,Quaternion q){
		JsArray<KeyframeTrack> tracks=JavaScriptObject.createArray().cast();
		
			JsArrayNumber times=JavaScriptObject.createArray().cast();
			times.push(0);
			
			//I'm not sure is there reset-pose has value
			JsArrayNumber values=JsArray.createArray().cast();
			concat(values,q.toArray());
			QuaternionKeyframeTrack track=THREE.QuaternionKeyframeTrack(".bones["+parentIndex+"].quaternion", times, values);
			tracks.push(track);
			
			
			//position changed
			if(pos!=null){
				
				JsArrayNumber times2=JavaScriptObject.createArray().cast();
				times2.push(0);
				
				//I'm not sure is there reset-pose has value
				JsArrayNumber values2=JsArray.createArray().cast();
				concat(values2,pos.toArray());
				VectorKeyframeTrack track2=THREE.VectorKeyframeTrack(".bones["+(childIndex)+"].position", times2, values2);
				//tracks.push(track2);
			}
			
			
		return tracks;
		
	}
	public void concat(JsArrayNumber target,JsArrayNumber values){
		for(int i=0;i<values.length();i++){
			target.push(values.get(i));
		}
	}
	
	public Vector3 getPositionByBoneName(String name){
		String[] xy=name.split(",");
		int x=Integer.parseInt(xy[0]);
		int y=Integer.parseInt(xy[1]);
		Particle particle=cloth.particles.get((cloth.w+1)*y+x);
		return particle.getPosition().clone();
	}
	
	//TODO make method
	public Map<Bone,Bone> childAndParentMap(JsArray<Bone> bones){
		Map<Bone,Bone> map=Maps.newHashMap();
		for(int i=1;i<bones.length();i++){
			Bone parent=bones.get(i);
			for(int j=0;j<parent.getChildrenBones().length();j++){
				Bone child=parent.getChildrenBones().get(j);
				map.put(child, parent);
			}
		}
		return map;
	}
	
	public Map<Bone,Integer> getBoneIndex(JsArray<Bone> bones){
		Map<Bone,Integer> map=Maps.newHashMap();
		for(int i=0;i<bones.length();i++){
			map.put(bones.get(i),i);
		}
		return map;
	}
	
	public Map<String,Vector3> getOriginalPosition(Geometry geometry){
		Map<String,Vector3> map=Maps.newHashMap();
		for(int i=0;i<geometry.getBones().length();i++){
			//Bone parent=bones.get(i);
			AnimationBone ab=geometry.getBones().get(i);
			map.put(ab.getName(), THREE.Vector3().fromArray(ab.getPos()));
			LogUtils.log(ab);
			
		}
		return map;
	}
	
	@Override
	public void onWindowResize() {
		
		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
	}
	
	@Override
	public String getTokenKey() {
		return "cloth3";
	}
}
