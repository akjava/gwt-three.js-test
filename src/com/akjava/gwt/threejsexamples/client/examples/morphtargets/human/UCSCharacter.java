package com.akjava.gwt.threejsexamples.client.examples.morphtargets.human;

import java.util.Map;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.core.BoundingBox;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.extras.ImageUtils.ImageUtilsLoadHandler;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class UCSCharacter {


private int numSkins;
private int numMorphs;
private Object3D root;
public Object3D getRoot() {
	return root;
}

//private double scale=1.0;
private JsArray<Texture> skins;
public JsArray<Texture> getSkins() {
	return skins;
}

private JsArray<Material> materials ;
private JsArrayString morphs;

public JsArrayString getMorphs() {
	return morphs;
}

private AnimationMixer mixer;
public AnimationMixer getMixer() {
	return mixer;
}

private int loadCounter=1;

private CheckLoadComplete checkLoadComplete;
//onLoadComplete

public void setCheckLoadComplete(CheckLoadComplete checkLoadComplete) {
	this.checkLoadComplete = checkLoadComplete;
}

private Mesh mesh;

public UCSCharacter(){
	root=THREE.Object3D();
	mixer=THREE.AnimationMixer(root);
}

public void loadParts(JSONValue json){
	final JSONObject config=json.isObject();
	JsArrayString skinNames=config.get("skins").isArray().getJavaScriptObject().cast();
	numSkins=skinNames.length();
	
	JSONArray morphNames=config.get("morphs").isArray();
	numMorphs=morphNames.size();
	
	loadCounter=1+numSkins;
	
	String baseUrl=config.get("baseUrl").isString().stringValue();
	
	this.skins = loadTextures( baseUrl + "skins/", skinNames );
	this.materials = createMaterials( this.skins );
	this.morphs=morphNames.getJavaScriptObject().cast();
	
	final String characterName=config.get("character").isString().stringValue();
	JSONLoader loader=THREE.JSONLoader();
	loader.load(baseUrl+characterName, new JSONLoadHandler() {
		
		@Override
		public void loaded(Geometry geometry, JsArray<Material> materials) {
			geometry.computeBoundingBox();
			geometry.computeVertexNormals();

			mesh = THREE.SkinnedMesh( geometry, THREE.MeshFaceMaterial() );//mesh = new THREE.SkinnedMesh( geometry, new THREE.MeshFaceMaterial() );
			mesh.setName(characterName);//mesh.name = config.character;
			root.add( mesh );//scope.root.add( mesh );

			double scale=config.get("s").isNumber().doubleValue();
			double x=config.get("x").isNumber().doubleValue();
			double y=config.get("y").isNumber().doubleValue();
			double z=config.get("z").isNumber().doubleValue();
			
			BoundingBox bb = geometry.getBoundingBox();
			root.getScale().set( scale,scale,scale);//scope.root.scale.set( config.s, config.s, config.s );
			root.getPosition().set( x, y - bb.getMin().getY() * scale, z);//scope.root.position.set( config.x, config.y - bb.min.y * config.s, config.z );

			mesh.setCastShadow(true);//mesh.castShadow = true;
			mesh.setReceiveShadow(true);//mesh.receiveShadow = true;

			mixer.clipAction( geometry.getAnimations().get(0) ,mesh ).play();//scope.mixer.addAction( new THREE.AnimationAction( geometry.animations[0] ).setLocalRoot( mesh ) );

			setSkin( 0 );

			checkLoadComplete();
			
		}
	});
}

//called by user selection
public void setSkin(int index) {

	if ( mesh!=null && materials!=null ) {

		mesh.setMaterial(materials.get(index));

	}

};

public void updateMorphs(Map<String,Double> influences ) {

	if ( mesh!=null ) {

		for ( int i = 0; i < numMorphs; i ++ ) {

			mesh.getMorphTargetInfluences().set( i ,influences.get(morphs.get( i )) / 100);

		}

	}

};

public JsArray<Material> createMaterials( JsArray<Texture> skins ) {

	JsArray<Material> materials = JavaScriptObject.createArray().cast();
	
	for ( int i = 0; i < skins.length(); i ++ ) {
		Material material=
				THREE.MeshLambertMaterial( GWTParamUtils.MeshLambertMaterial().color(0xeeeeee)
						//.specular(10.0)
						.map(skins.get(i)).skinning(true).morphTargets(true) );//var x=new THREE.MeshLambertMaterial( {color: 0xeeeeee,specular: 10.0,map: skins[ i ],skinning: true,morphTargets: true} );

			materials.push(material);
	}
	
	return materials;

}

/*
 * call loadParts first
 */
public JsArray<Texture> loadTextures(String baseUrl, JsArrayString textureUrls ) {

	
	int mapping = THREE.UVMapping;
	JsArray<Texture> textures = JavaScriptObject.createArray().cast();

	for ( int i = 0; i < textureUrls.length(); i ++ ) {

		Texture texture=ImageUtils.loadTexture( baseUrl + textureUrls.get(i), mapping,new ImageUtilsLoadHandler(){

			@Override
			public void onLoad(JavaScriptObject object) {
				checkLoadComplete();
			}

			@Override
			public void onError(NativeEvent error) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		textures.set(i, texture);
		
		texture.setName(textureUrls.get(i));

	}
	return textures;
}

private void checkLoadComplete(){
	loadCounter -= 1;

	if ( loadCounter == 0 ) {

		checkLoadComplete.onLoadComplete();

	}
}

public static interface CheckLoadComplete{
	public void onLoadComplete();
}


}
