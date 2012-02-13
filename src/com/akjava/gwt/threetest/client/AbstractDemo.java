package com.akjava.gwt.threetest.client;

import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public abstract class AbstractDemo implements Demo{
	protected Timer timer;

	protected int width,height;
	
	public  void onMouseClick(ClickEvent event){};
	public  void onMouseWheel(MouseWheelEvent event){};
	public  void onMouseMove(MouseMoveEvent event){} ;
	public  void onMouseDown(MouseDownEvent event){} ;
	public  void onMouseUp(MouseUpEvent event){} ;
	public  void onMouseOut(MouseOutEvent event){};
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		this.width=width;
		this.height=height;
		panel.addMouseUpHandler(new MouseUpHandler() {
			
			@Override
			public void onMouseUp(MouseUpEvent event) {
			
				AbstractDemo.this.onMouseUp(event);
			}
		});


		panel.addMouseWheelHandler(new MouseWheelHandler() {
			@Override
			public void onMouseWheel(MouseWheelEvent event) {
				AbstractDemo.this.onMouseWheel(event);
			}
		});
		//hpanel.setFocus(true);
		
		
		panel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AbstractDemo.this.onMouseClick(event);
			}
		});
		
		panel.addMouseDownHandler(new MouseDownHandler() {
			
			@Override
			public void onMouseDown(MouseDownEvent event) {
				AbstractDemo.this.onMouseDown(event);
				
			}
		});
		
		panel.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				AbstractDemo.this.onMouseOut(event);
			}
		});
		
		panel.addMouseMoveHandler(new MouseMoveHandler(){

			@Override
			public void onMouseMove(MouseMoveEvent event) {
				AbstractDemo.this.onMouseMove(event);
			}});
	}
	
	@Override
	public void stop() {
		if(timer!=null){
		timer.cancel();
		timer=null;
		}
	}
	
	@Override
	public void startTimer(){
		timer.scheduleRepeating(1000/60);
	}
	
	public final native void log(JavaScriptObject object)/*-{
	console.log(object);
	}-*/;
	public final native void log(String object)/*-{
	console.log(object);
	}-*/;

}
