package com.akjava.gwt.three.client.java.utils;

import java.util.List;

import com.akjava.gwt.lib.client.experimental.AsyncMultiCaller;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.loaders.TextureLoader;
import com.akjava.gwt.three.client.js.loaders.TextureLoader.TextureLoadHandler;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRErrorHandler;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRProgressHandler;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.google.common.collect.Lists;
import com.google.gwt.dom.client.NativeEvent;

public class MultiTextureLoader {

	public MultiTextureLoader(){
		
	}
	
	public void load(List<String> urls,final MultiTextureLoaderListener listener){
		AsyncMultiCaller<String> caller=new AsyncMultiCaller<String>(urls) {
		final TextureLoader loader=THREE.TextureLoader();
		final List<Texture> textures=Lists.newArrayList();
		final List<String> messages=Lists.newArrayList();
			@Override
			public void doFinally(boolean cancelled) {
				if(cancelled){
					listener.onError(messages);
				}else{
					listener.onLoad(textures);
				}
			}

			@Override
			public void execAsync(final String data) {
				loader.load(data, new TextureLoadHandler() {
					
					@Override
					public void onLoad(Texture texture) {
						texture.setSourceFile(data);
						textures.add(texture);
						done(data, true);
					}
				}, new XHRProgressHandler() {
					
					@Override
					public void onProgress(NativeEvent progress) {
						// skipped
						
					}
				},new XHRErrorHandler() {
					
					@Override
					public void onError(NativeEvent error) {
						messages.add(error.toString());
						done(data,false);
					}
				});
			}
			
		};
		caller.startCall();
	}
	
	public static interface MultiTextureLoaderListener{
		public void onLoad(List<Texture> textures);
		public void onError(List<String> messages);
	}
}
