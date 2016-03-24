package com.akjava.gwt.threejsexamples.client.examples.animation.skinning;

import java.util.HashMap;
import java.util.Map;

import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationMixerAction;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.helpers.SkeletonHelper;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.math.Euler;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.SkinnedMesh;
import com.google.gwt.core.client.JsArray;

public class BlendCharacter {
	private SkinnedMesh skinnedMesh;
	public SkinnedMesh getSkinnedMesh() {
		return skinnedMesh;
	}

	
	private SkeletonHelper skeletonHelper;
	public SkeletonHelper getSkeletonHelper() {
		return skeletonHelper;
	}

	//private Map<String,AnimationClip> animations=new HashMap<String,AnimationClip>();
	
	/*
	public Map<String, AnimationClip> getAnimations() {
		return animations;
	}
	*/

	//private List<JSParameter> weightSchedule=new ArrayList<JSParameter>();
	//private List<WrapSchedule> warpScheduleList=new ArrayList<WrapSchedule>();
	private AnimationMixer mixer;
	public void load(String url,final JSONLoadHandler callback){
		
		JSONLoader loader=THREE.JSONLoader();
		loader.load(url, new JSONLoadHandler() {
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				// TODO Auto-generated method stub
				Material originalMaterial=materials.get(0);
				originalMaterial.gwtSet("skinning",true);
				
				/*
				 * 
				 * it's impossible emulate js-call
				 * extends js-class has made more problems
				 * so just simply hold skinnedMesh instance
				 * 
				 */
				skinnedMesh=THREE.SkinnedMesh(geometry, originalMaterial);
				
				mixer = THREE.AnimationMixer( skinnedMesh );
				
				for(int i=0;i<geometry.getAnimations().length();i++){
					
					mixer.clipAction( geometry.getAnimations().get(i) );
				}
				
				skeletonHelper=THREE.SkeletonHelper(skinnedMesh);
				skeletonHelper.gwtGetMaterial().setLinewidth(3);
				showSkeleton(false);
				
				if(callback!=null){
					callback.loaded(geometry, materials);
				}
			}
		});
	}
	
	
	
	public double getWeight(String animName){
		return this.mixer.clipAction( animName ).getEffectiveWeight();
	}
	
	public void update(double dt ) {
		mixer.update(dt);

	};
	
	
	public AnimationMixerAction play(String animName,double weight) {
		
		return this.mixer.clipAction(animName).setEffectiveWeight(weight).play();

	};
	
	boolean needSyncWeight;
	public boolean isNeedSyncWeight(){
		return needSyncWeight;
	}
	
	public void crossfade(String fromAnimName,String toAnimName,double duration ) {
		this.mixer.stopAllAction();
		 
		AnimationMixerAction fromAction =  play(fromAnimName,1) ;
		AnimationMixerAction toAction =  play(toAnimName,1);

		fromAction.crossFadeTo(toAction, duration, false);
		
		
		needSyncWeight=true;
	};
	
	public void warp(String fromAnimName,String toAnimName,double duration) {

		this.mixer.stopAllAction();
		 
		AnimationMixerAction fromAction =  play(fromAnimName,1) ;
		AnimationMixerAction toAction =  play(toAnimName,1);


		fromAction.crossFadeTo( toAction, duration, true );
		
		needSyncWeight=true;
	};
	
	
	
	public void applyWeight(String animName,double weight) {
		this.mixer.clipAction( animName ).setEffectiveWeight( weight );
	};
	
	public void pauseAll() {
		mixer.setTimeScale(0);
	};


	public void unPauseAll(){
		mixer.setTimeScale(1);
	}
	
	public void stopAll(){

		this.mixer.stopAllAction();
	}
	
	
	public void showSkeleton(boolean visible){
		skeletonHelper.setVisible(visible);
	}
	
	
	public void showModel(boolean visible){
		skinnedMesh.setVisible(visible);
	}
	
	private Vector3 forward=THREE.Vector3();
	public Vector3 getForward(){
		forward.set(
				-skinnedMesh.getMatrix().getElements().get(8),
				-skinnedMesh.getMatrix().getElements().get(9),
				-skinnedMesh.getMatrix().getElements().get(10)
			);
		return forward;
	}



	public Euler getRotation() {
		return skinnedMesh.getRotation();
	}
	
	public AnimationMixer getMixer(){
		return mixer;
	}



	public Geometry getGeometry() {
		return skinnedMesh.getGeometry();
	}
	
}
