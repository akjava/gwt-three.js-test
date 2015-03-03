package com.akjava.gwt.threetest.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.examples.renderers.CSS3DRenderer;
import com.akjava.gwt.three.client.gwt.core.CameraControler;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;
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
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class AbstractDemo implements Demo{
	protected Timer timer;

	protected int width,height;
	
	

	
	protected CameraControler cameraControle=new CameraControler();
	
	
	protected boolean mouseDown;
	
	protected int mouseDownX;
	protected int mouseDownY;

	protected WebGLRenderer renderer;

	public void onMouseOut(MouseOutEvent event) {
		mouseDown=false;
	}
	
	public void onMouseDown(MouseDownEvent event) {
		
		mouseDown=true;
		mouseDownX=event.getX();
		mouseDownY=event.getY();
	}


	public void onMouseUp(MouseUpEvent event) {
		mouseDown=false;
	}
	
	
	public void onMouseWheel(MouseWheelEvent event) {
		
		cameraControle.doMouseWheel(event.getDeltaY());
	}
	

	public void onMouseMove(MouseMoveEvent event) {
		
		if(event.getNativeButton()==NativeEvent.BUTTON_MIDDLE && mouseDown){
			int diffX=event.getX()-mouseDownX;
			int diffY=event.getY()-mouseDownY;
			mouseDownX=event.getX();
			mouseDownY=event.getY();
			
			cameraControle.incrementRotationX(diffY);
			cameraControle.incrementRotationY(diffX);
		}
	}

	private List<HandlerRegistration> registrations=new ArrayList<HandlerRegistration>();
	
	
	protected void addHandlerRegistration(HandlerRegistration handlerRegistration){
		registrations.add(handlerRegistration);
	}
	
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		this.width=width;
		this.height=height;
		this.renderer=renderer;
		HandlerRegistration handlerRegistration=panel.addMouseUpHandler(new MouseUpHandler() {
			
			@Override
			public void onMouseUp(MouseUpEvent event) {
			
				AbstractDemo.this.onMouseUp(event);
			}
		});
		registrations.add(handlerRegistration);

		
		
		handlerRegistration=panel.addMouseWheelHandler(new MouseWheelHandler() {
			@Override
			public void onMouseWheel(MouseWheelEvent event) {
				AbstractDemo.this.onMouseWheel(event);
			}
		});
		
		registrations.add(handlerRegistration);
		//hpanel.setFocus(true);
		
		/*
		panel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AbstractDemo.this.onMouseClick(event);
			}
		});
		*/
		
		handlerRegistration=panel.addMouseDownHandler(new MouseDownHandler() {
			
			@Override
			public void onMouseDown(MouseDownEvent event) {
				AbstractDemo.this.onMouseDown(event);
				
			}
		});
		registrations.add(handlerRegistration);
		
		handlerRegistration=panel.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				AbstractDemo.this.onMouseOut(event);
			}
		});
		registrations.add(handlerRegistration);
		
		handlerRegistration=panel.addMouseMoveHandler(new MouseMoveHandler(){

			@Override
			public void onMouseMove(MouseMoveEvent event) {
				AbstractDemo.this.onMouseMove(event);
			}});
		registrations.add(handlerRegistration);
	}
	
	@Override
	public void stop() {
		if(timer!=null){
		timer.cancel();
		timer=null;
		}
		if(renderer.gwtGetType().equals("css3d")){
			CSS3DRenderer css3r=(CSS3DRenderer)renderer;
			css3r.gwtClear();	//to avoid show duplicate content.
		}
		
	}
	
	public void clearHandlerRegistration(){
		for(HandlerRegistration r:registrations){
			r.removeHandler();
		}
		registrations.clear();
	}
	
	@Override
	public void startTimer(Timer timer){
		stop();
		this.timer=timer;
		timer.scheduleRepeating(1000/60);
	}
	
	
	
	@Override
	public Widget getControler() {
		return null;
	}

	public final native void log(JavaScriptObject object)/*-{
	console.log(object);
	}-*/;
	public final native void log(String object)/*-{
	console.log(object);
	}-*/;
	@Override
	public boolean isSupportCanvas(){
		return true;
	}
	@Override
	public boolean isSupportWebGL(){
		return true;
	}
	@Override
	public boolean isSupportCSS3D(){
		return false;
	}

}
