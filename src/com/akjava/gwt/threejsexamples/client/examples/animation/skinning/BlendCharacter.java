package com.akjava.gwt.threejsexamples.client.examples.animation.skinning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.BufferGeometry;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.animation.Animation;
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
	private Map<String,Animation> animations=new HashMap<String,Animation>();
	
	public Map<String, Animation> getAnimations() {
		return animations;
	}

	private List<JSParameter> weightSchedule=new ArrayList<JSParameter>();
	private List<WrapSchedule> warpScheduleList=new ArrayList<WrapSchedule>();
	public void load(String url,final JSONLoadHandler callback){
		
		JSONLoader loader=THREE.JSONLoader();
		loader.load(url, new JSONLoadHandler() {
			@Override
			public void loaded(Geometry geometry, JsArray<Material> materials) {
				// TODO Auto-generated method stub
				Material originalMaterial=materials.get(0);
				originalMaterial.gwtSet("skinning",true);
				
				//maybe impossible javascript/call on Java
				skinnedMesh=THREE.SkinnedMesh(geometry, originalMaterial);
				
				for(int i=0;i<geometry.getAnimations().length();i++){
					String animName = geometry.getAnimations().get(i).getName();
					animations.put(animName,THREE.Animation( skinnedMesh, geometry.getAnimations().get(i)));
				}
				
				skeletonHelper=THREE.SkeletonHelper(skinnedMesh);
				skeletonHelper.gwtGetMaterial().setLinewidth(3);
				
				skinnedMesh.add(skeletonHelper);
				
				showSkeleton(false);
				
				if(callback!=null){
					callback.loaded(geometry, materials);
				}
			}
		});
	}
	
	
	
	public void update(double dt ) {

		if(needSyncWeight && weightSchedule.size()==0 && warpScheduleList.size()==0){
			needSyncWeight=false;
		}
		
		for ( int i = this.weightSchedule.size() - 1; i >= 0; i-- ) {
			
			JSParameter data = this.weightSchedule.get(i);
			
			
			data.set("timeElapsed",data.getDouble("timeElapsed") + dt);
			

			// If the transition is complete, remove it from the schedule
			Animation anim=data.getObject("anim").cast();
			
			if ( data.getDouble("timeElapsed") > data.getDouble("duration") ) {
				
				
				anim.setWeight(data.getDouble("endWeight"));
				weightSchedule.remove( i);//tha's why last first

				// If we've faded out completely, stop the animation
				if ( anim.getWeight() == 0 ) {
					anim.stop();
				}

			} else {
				// interpolate the weight for the current time
				anim.setWeight(
						data.getDouble("startWeight") + (data.getDouble("endWeight") - data.getDouble("startWeight")) * data.getDouble("timeElapsed") / data.getDouble("duration")
						);

			}

		}

		this.updateWarps( dt );
		this.skeletonHelper.update();

	};
	
	boolean needSyncWeight;
	public boolean isNeedSyncWeight(){
		return needSyncWeight;
	}
	/*
	 * possible multi ?
	 */
	public void updateWarps(double dt ) {

		// Warping modifies the time scale over time to make 2 animations of different
		// lengths match. This is useful for smoothing out transitions that get out of
		// phase such as between a walk and run cycle

		for ( int i = this.warpScheduleList.size() - 1; i >= 0; i-- ) {

			WrapSchedule data = this.warpScheduleList.get(i);
			data.timeElapsed=data.timeElapsed+dt;
			
			if ( data.timeElapsed > data.duration ) {
				
				Animation toAnim=data.to;
				toAnim.setWeight(1);
				toAnim.setTimeScale(1);
				Animation fromAnim=data.from;
				fromAnim.setWeight(0);
				fromAnim.setTimeScale(1);
				
				fromAnim.stop();
				
				this.warpScheduleList.remove(i);
			} else {
				/*
				 * matching timescale is essense
				 */
				
				
				double alpha = data.timeElapsed / data.duration;

				Animation toAnim=data.to;
				Animation fromAnim=data.from;
				
				
				double fromLength = fromAnim.getData().getLength();
				double toLength = toAnim.getData().getLength();

				double fromToRatio = fromLength / toLength;
				double toFromRatio = toLength / fromLength;

				// scale from each time proportionally to the other animation
				
				fromAnim.setTimeScale(( 1 - alpha ) + fromToRatio * alpha);
				toAnim.setTimeScale(alpha + toFromRatio * ( 1 - alpha ));

				fromAnim.setWeight(1.0 - alpha);
				toAnim.setWeight(alpha);
			}

		}

	}
	
	public void play(String animName,double weight) {

		this.animations.get(animName).play( 0, weight );

	};
	
	public void crossfade(String fromAnimName,String toAnimName,double duration ) {

		Animation fromAnim = this.animations.get(fromAnimName);
		Animation toAnim = this.animations.get(toAnimName);

		fromAnim.play( 0, 1 );
		toAnim.play( 0, 0 );


		
		
		weightSchedule.add(JSParameter.createParameter()
				.set("anim", fromAnim)
				.set("startWeight",1.0)
				.set("endWeight",0.0)
				.set("timeElapsed",0.0)
				.set("duration",duration)
				);
		
		weightSchedule.add(JSParameter.createParameter()
				.set("anim", toAnim)
				.set("startWeight",0.0)
				.set("endWeight",1)
				.set("timeElapsed",0.0)
				.set("duration",duration)
				);
		
		needSyncWeight=true;
	};
	
	public void warp(String fromAnimName,String toAnimName,double duration) {

		Animation fromAnim = this.animations.get(fromAnimName);
		Animation toAnim = this.animations.get(toAnimName);

		fromAnim.play( 0, 1 );
		toAnim.play( 0, 0 );

		//TODO find more smart way
		warpScheduleList.add(
				new WrapSchedule(fromAnim,toAnim,0,duration)
				);
		
		needSyncWeight=true;
	};
	
	public class WrapSchedule{
		Animation from;
		public WrapSchedule(Animation from, Animation to, double timeElapsed, double duration) {
			super();
			this.from = from;
			this.to = to;
			this.timeElapsed = timeElapsed;
			this.duration = duration;
		}
		Animation to;
		double timeElapsed;
		double duration;
	}
	
	public void applyWeight(String animName,double weight) {

		this.animations.get(animName).setWeight(weight);

	};
	
	public void pauseAll() {
		
		for (String a:animations.keySet()) {
			if ( this.animations.get(a).isIsPlaying() ) {
				this.animations.get(a).stop();
			}
		}
		//TODO get current time for unpause
	};

	public void unPauseAll(){
		//TODO implement other way
	}
	
	public void stopAll(){
		for (String a:animations.keySet()) {

			if ( this.animations.get(a).isIsPlaying() ) {
				this.animations.get(a).stop();
			}

			this.animations.get(a).setWeight(0);

		}

		this.weightSchedule.clear();
		this.warpScheduleList.clear();
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



	public Geometry getGeometry() {
		return skinnedMesh.getGeometry();
	}
	
}
