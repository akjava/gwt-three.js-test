package com.akjava.gwt.three.client.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;


//TODO retry and timeout
public class MultiImageLoader {
private Map<String,String> lists;
private LoadMonitor monitor;
	public MultiImageLoader(Map<String,String> lists,LoadMonitor monitor){
		this.lists=lists;
		this.monitor=monitor;
	}
private Map<String,Image> geometries;
private List<String> remains;
	public void startLoad(){
		geometries=new HashMap<String,Image>();

		remains=new ArrayList<String>();
		for(String name:lists.keySet()){
			remains.add(name);
		}
		for(String name:lists.keySet()){
			String path=lists.get(name);
			Image img=new Image(lists.get(name));
			img.setVisible(false);
			RootPanel.get().add(img);
			img.addLoadHandler(new Loaded(img,name));
		}
	}
	public synchronized void done(String name){
		remains.remove(name);
		if(remains.size()==0){
			monitor.loadComplete(geometries);
		}
	}
	
	public class Loaded implements LoadHandler{
		private String name;
		private Image img;
		public Loaded(Image img,String name){
			this.img=img;
			this.name=name;
		}
		@Override
		public void onLoad(LoadEvent event) {
			geometries.put(name,img);
			done(name);
		}
	}
	
	
	public interface LoadMonitor{
		public void loadComplete(Map<String,Image> geos);
	}
	

	public static final native void log(JavaScriptObject object)/*-{
	console.log(object);
	}-*/;
	public static final native void log(String object)/*-{
	console.log(object);
	}-*/;
}
