package com.akjava.gwt.threedemos.client;


import com.akjava.gwt.lib.client.LogUtils;
import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.animation.client.AnimationScheduler.AnimationCallback;
import com.google.gwt.animation.client.AnimationScheduler.AnimationHandle;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;

public class ThreeDemo implements EntryPoint,AnimationCallback {

	private AnimationHandle handler;

	/**
	 * request animation test
	 * 
	 * warning
	 * 
	 * 'webkitRequestAnimationFrame' is vendor-specific. Please use the standard 'requestAnimationFrame' instead.
	 * 'webkitCancelRequestAnimationFrame' is vendor-specific. Please use the standard 'cancelAnimationFrame' instead.
	 */
	@Override
	public void onModuleLoad() {
		handler = AnimationScheduler.get().requestAnimationFrame(this);
		new Timer(){
			@Override
			public void run() {
				handler.cancel();
			}}.schedule(1000);
		
	}

	@Override
	public void execute(double timestamp) {
		handler=AnimationScheduler.get().requestAnimationFrame(this);
		LogUtils.log(timestamp);//c-time?
	}

}
