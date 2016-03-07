package com.akjava.gwt.threejsexamples.client.examples.animation.skinning;

import java.util.Map;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.js.animation.AnimationAction;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.threejsexamples.client.LabeledInputRangeWidget;
import com.akjava.gwt.threejsexamples.client.Range;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BlendCharacterGui extends VerticalPanel{

	private Map<String,AnimationClip> animations;
	
	BlendingExample blendingExample;

	private LabeledInputRangeWidget idleRange;

	private LabeledInputRangeWidget walkRange;

	private LabeledInputRangeWidget runRange;

	private LabeledInputRangeWidget timeScaleRange;

	private LabeledInputRangeWidget stepSizeRange;

	private LabeledInputRangeWidget crossfadeTimeRange;
	
	private AnimationMixer mixer;
	public double getTimeScale(){
		return timeScaleRange.getValue();
	}

	public BlendCharacterGui(AnimationMixer mixer,final BlendingExample blendingExample) {
		this.blendingExample=blendingExample;
		this.mixer=mixer;
		
		VerticalPanel settings=new VerticalPanel();
		add(settings);
		Label settingsLabel=new Label("Settings");
		
		settings.add(settingsLabel);
		
		CheckBox lockCamera=new CheckBox("Lock Camera");
		lockCamera.setValue(false);
		settings.add(lockCamera);
		
		CheckBox showModel=new CheckBox("Show Model");
		showModel.setValue(true);
		settings.add(showModel);
		
		CheckBox showSkeleton=new CheckBox("Show Skeleton");
		showSkeleton.setValue(false);
		settings.add(showSkeleton);
		
		timeScaleRange = new LabeledInputRangeWidget("Time Scale",0,1,0.01);
		settings.add(timeScaleRange);
		timeScaleRange.setValue(1);
		
		
		stepSizeRange = new LabeledInputRangeWidget("Step Size",0.01, 0.1, 0.01 );
		settings.add(stepSizeRange);
		stepSizeRange.setValue(0.016);
		
		crossfadeTimeRange = new LabeledInputRangeWidget("Crossfade Time",0.1, 6.0, 0.05 );
		settings.add(crossfadeTimeRange);
		crossfadeTimeRange.setValue(3.5);
		
		
		LabeledInputRangeWidget test=new LabeledInputRangeWidget("Time scale",0,1,0.01);
		settings.add(test);
		
		//TODO need code compatible
		VerticalPanel playback=new VerticalPanel();
		add(playback);
		Label playbackLabel=new Label("Playback");
		playback.add(playbackLabel);
		
		Button startBt=new Button("start");
		startBt.setWidth("200px");
		playback.add(startBt);
		
		Button pauseBt=new Button("pause");
		pauseBt.setWidth("200px");
		playback.add(pauseBt);
		
		Button stepBt=new Button("step");
		stepBt.setWidth("200px");
		playback.add(stepBt);
		
		Button idletowalkBt=new Button("idle to walk");
		idletowalkBt.setWidth("200px");
		playback.add(idletowalkBt);
		
		Button walktorunBt=new Button("walk to run");
		walktorunBt.setWidth("200px");
		playback.add(walktorunBt);
		
		Button warpwalktorunBt=new Button("warp walk to run");
		warpwalktorunBt.setWidth("200px");
		playback.add(warpwalktorunBt);
	
		
		VerticalPanel blendTurning=new VerticalPanel();
		add(blendTurning);
		Label blendTurningLabel=new Label("Blend Tuning");
		blendTurning.add(blendTurningLabel);
		
		idleRange = new LabeledInputRangeWidget("idle",0,1,0.01);
		blendTurning.add(idleRange);
		
		walkRange = new LabeledInputRangeWidget("walk",0,1,0.01);
		blendTurning.add(walkRange);
		
		runRange = new LabeledInputRangeWidget("run",0,1,0.01);
		blendTurning.add(runRange);
		
		
		//set values
		idleRange.setValue(0.33);
		walkRange.setValue(0.33);
		runRange.setValue(0.33);
		
		
		
		startBt.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				blendingExample.startAnimation(getAnimationData());
			}
		});
		
		stepBt.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				blendingExample.stepAnimation(stepSizeRange.getValue());
			}
		});
		
		pauseBt.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				blendingExample.pauseAnimation();
			}
		});
		
		idletowalkBt.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				crossfade("idle", "walk");
			}
		});
		
		walktorunBt.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				crossfade("walk", "run");
			}
		});
		
		warpwalktorunBt.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				wrap("walk", "run");
			}
		});
		
		
		lockCamera.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				blendingExample.lockCameraChanged(event.getValue());
			}
		});
		
		showModel.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				blendingExample.showModelChanged(event.getValue());
			}
		});
		
		showSkeleton.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				blendingExample.showSkeletonChanged(event.getValue());
			}
		});
		
		ValueChangeHandler<Number> onBlendChanged=new ValueChangeHandler<Number>() {
			@Override
			public void onValueChange(ValueChangeEvent<Number> event) {
				//weight(((Range)event.getSource()).getName());
				//LogUtils.log("weight-changed");
				//onWeight();
			}
		};
		
		
		
		idleRange.addtRangeListener(onBlendChanged);
		walkRange.addtRangeListener(onBlendChanged);
		runRange.addtRangeListener(onBlendChanged);
		
	}
	
	private double getWeight(String name,double time){
		
		for(int i=0;i<mixer.getActions().length();i++){
			if(mixer.getActions().get(i).getClip().getName().equals(name)){
				return mixer.getActions().get(i).getWeightAt(time);
			}
		}
		return 0;
		
	}
	
	public void update(double time){
		//TODO update only crossfade or wraping
		idleRange.setValue(getWeight("idle",time));
		walkRange.setValue(getWeight("walk",time));
		runRange.setValue(getWeight("run",time));
	}
	
	protected void onWeight(){
		/*
		 * var data = event.detail;
				for ( var i = 0; i < data.anims.length; ++i ) {

					for( var j = 0; j < blendMesh.mixer.actions.length; j ++ ) {
						var action = blendMesh.mixer.actions[j];
						if( action.clip.name === data.anims[i] ) {
							if( action.getWeightAt( blendMesh.mixer.time ) !== data.weights[i] ) {
								action.weight = data.weights[i];
							}
						}
					}

				}
		 */
		
	String[] names={"idle","walk","run"};
	
			
	for(String name:names){
		for(int i=0;i<mixer.getActions().length();i++){
			AnimationAction action=mixer.getActions().get(i);
			if(action.getClip().getName().equals(name)){
				
				double value=0;
				if(name.equals("idle")){
					value=idleRange.getValue();
				}else if(name.equals("walk")){
					value=walkRange.getValue();
				}else{
					value=runRange.getValue();
				}
				
				if(action.getWeightAt(mixer.getTime())!=value){
					action.setWeight(value);
					//LogUtils.
				}
			}
		}
		}
	}
	/*
	protected void weight(String name) {
		
		
		LabeledInputRangeWidget main;
		LabeledInputRangeWidget remain1;
		LabeledInputRangeWidget remain2;
		
		if(name.equals("idle")){
			main=idleRange;
			remain1=walkRange;
			remain2=runRange;
		}else if(name.equals("walk")){
			main=walkRange;
			remain1=idleRange;
			remain2=runRange;
		}else{
			main=runRange;
			remain1=walkRange;
			remain2=idleRange;
		}
		
		//TODO make group range function?
		double remain=1.0-main.getValue();
		if(remain1.getValue()==0 && remain2.getValue()==0){
			remain1.setValue(remain/2);
			remain2.setValue(remain/2);
		}else{
		double sum=remain1.getValue()+remain2.getValue();
		remain1.setValue(remain*(remain1.getValue()/sum));
		remain2.setValue(remain*(remain2.getValue()/sum));
		}
		
		//call event
		blendingExample.weightAnimation(getAnimationData());
	}
*/

	private BlendData getAnimationData() {
		return createAnimationData(idleRange.getValue(),walkRange.getValue(),runRange.getValue());
	}
	
	  public final native BlendData createAnimationData(double idle,double walk,double run) /*-{
	  	return {

			detail: {

				anims: [ "idle", "walk", "run" ],

				weights: [ idle,
						   walk,
						   run ]
			}

		};
	}-*/;
	  
	  public final native BlendData createAnimationData(String from,String to,double time) /*-{
	  	return {

			detail: {
				from:from,
				to:to,
				time:time
			}

		};
	}-*/;
	  
		public void crossfade(String from,String to ) {

			BlendData data=createAnimationData(from,to,crossfadeTimeRange.getValue());
			
			blendingExample.crossfade(data);
		}
		
		public void wrap(String from,String to ) {

			BlendData data=createAnimationData(from,to,crossfadeTimeRange.getValue());
			
			blendingExample.wrap(data);
		}
	  
	  
	  
	  public static final   class BlendData extends JavaScriptObject{
		  protected BlendData(){}
		  public final native JsArrayString getAnims() /*-{
		  	return this.detail.anims;
		}-*/;
		  
		  public final native JsArrayNumber getWeights() /*-{
		  	return this.detail.weights;
		}-*/;
		  
		  public final native String getFrom() /*-{
		  	return this.detail.from;
		}-*/;
		  public final native String getTo() /*-{
		  	return this.detail.to;
		}-*/;
		  public final native double getTime() /*-{
		  	return this.detail.time;
		}-*/;
	  }

	//TODO support oninput
	

	
	

}
