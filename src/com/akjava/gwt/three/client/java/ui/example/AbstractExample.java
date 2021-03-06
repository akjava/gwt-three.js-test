package com.akjava.gwt.three.client.java.ui.example;

import com.akjava.gwt.lib.client.LogUtils;
import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.animation.client.AnimationScheduler.AnimationHandle;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public abstract class AbstractExample implements Example,Comparable<Example>{
	private AnimationHandle handler;
	protected Panel parent;
	
	private boolean debugAnimateOneTime;
	
	
	
	public boolean isDebugAnimateOneTime() {
		return debugAnimateOneTime;
	}

	public void setDebugAnimateOneTimeOnly(boolean debugAnimateOneTime) {
		this.debugAnimateOneTime = debugAnimateOneTime;
	}

	public Panel getParent() {
		return parent;
	}

	@Override
	public void start(Panel parent) {
		this.parent=parent;
		init();
		updateGUI();//move gui position;
		execute(System.currentTimeMillis());
	}

	@Override
	public void stop() {
		if(handler!=null){
			handler.cancel();
		}
		
		if(parent!=null){
			parent.clear();
		}
		
		if(popup!=null){
			popup.removeFromParent();
		}
		
		if(resizeHandler!=null){
			resizeHandler.removeHandler();
		}
	}

	@Override
	public void execute(double timestamp) {
		if(!debugAnimateOneTime){//for debug,if error happen on animate
		handler=AnimationScheduler.get().requestAnimationFrame(this);
		}else{
			LogUtils.log("debugAnimateOneTime:true only render called one time for debug");
		}
		animate(timestamp);
	}
	public abstract void animate(double timestamp);
	public abstract void init();
	public abstract void onWindowResize();
	
	protected PopupPanel popup;
	private HandlerRegistration resizeHandler;
	//alternative to dat.GUI
	
	/*
	 * 
	 * it's better to keep Verticalpanel ,it's hard to use Layout*Panel
	 * possible problem,if container size changed after showed,usually problem
	 */
	protected VerticalPanel addResizeHandlerAndCreateGUIPanel(){
		popup=new PopupPanel();	//do sync with demo
		
		VerticalPanel root=new VerticalPanel();
		popup.add(root);
		
		final VerticalPanel controler=new VerticalPanel();
		controler.setWidth("320px");//some widget broke,like checkbox without parent size
		controler.setSpacing(2);
		
		root.add(controler);
		
		final Button bt=new Button("Close Controls");
		bt.setWidth("320px");
		bt.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				controler.setVisible(!controler.isVisible());
				if(controler.isVisible()){
					bt.setText("Close Controls");
				}else{
					bt.setText("Open Controls");
				}
				updateGUI();
			}
		});
		
		root.add(bt);
		
		//popup.show();
		//moveToAroundRightTop(popup);
		
		
		resizeHandler = Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				onWindowResize();
				updateGUI();
			}
		});
		
		return controler;
	}
	
	protected void updateGUI(){
		if(popup==null){
			return;
		}
		popup.show();//for initial,show first before move
		moveToAroundRightTop(popup);
		
	}
	
	/**
	 * 
	 * @return double.this value used for calculate ratio,if return Int it's make problem without cast.
	 * THREE.PerspectiveCamera( 30, SCREEN_WIDTH / SCREEN_HEIGHT, 1, 10000 );
	 */
	public double getWindowInnerWidth(){
		return getParent().getOffsetWidth();
	}
	
	public double getWindowInnerHeight(){
		return getParent().getOffsetHeight();
	}
	
	//for attach event,must be focus panel
	protected FocusPanel createContainerPanel(){
		FocusPanel panel=new FocusPanel();
		getParent().add(panel);
		return panel;
	}
	
	
	//TODO move up
	private void moveToAroundRightTop(PopupPanel dialog){
		int clientWidth=Window.getClientWidth();
		int scrollTopPos=Window.getScrollTop();
		int dw=dialog.getOffsetWidth();
		
		
		
		//LogUtils.log(clientWidth+","+scrollTopPos+","+dw);
		
		
		dialog.setPopupPosition(clientWidth-dw, scrollTopPos+0);
		
	}

	protected HTML createAbsoluteHTML(String html, int x, int y) {
		HTML htmlWidget=new HTML(html);
		htmlWidget.getElement().getStyle().setPosition(Position.ABSOLUTE);
		htmlWidget.getElement().getStyle().setLeft(x, Unit.PX);
		htmlWidget.getElement().getStyle().setTop(y, Unit.PX);
		return htmlWidget;
	}
	@Override
	public int compareTo(Example o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
}
