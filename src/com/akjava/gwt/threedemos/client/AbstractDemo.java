package com.akjava.gwt.threedemos.client;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.animation.client.AnimationScheduler.AnimationHandle;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public abstract class AbstractDemo implements Demo{
	private AnimationHandle handler;
	protected Panel parent;
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
		handler=AnimationScheduler.get().requestAnimationFrame(this);
		animate(timestamp);
	}
	public abstract void animate(double timestamp);
	public abstract void init();
	public abstract void onWindowResize();
	
	private PopupPanel popup;
	private HandlerRegistration resizeHandler;
	//alternative to dat.GUI
	
	/*
	 * 
	 * possible problem,if container size changed after showed,usually problem
	 */
	protected VerticalPanel createGUIPanel(){
		popup=new PopupPanel();	//do sync with demo
		VerticalPanel controler=new VerticalPanel();
		controler.setWidth("200px");//some widget broke,like checkbox without parent size
		
		controler.setSpacing(2);
		popup.add(controler);
		
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
	
	
	
	//TODO move up
	private void moveToAroundRightTop(PopupPanel dialog){
		int clientWidth=Window.getClientWidth();
		int scrollTopPos=Window.getScrollTop();
		int dw=dialog.getOffsetWidth();
		
		
		
		//LogUtils.log(clientWidth+","+scrollTopPos+","+dw);
		
		
		dialog.setPopupPosition(clientWidth-dw, scrollTopPos+0);
		
	}
}
