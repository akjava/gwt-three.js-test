package com.akjava.gwt.three.client.java.ui.experiments;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public abstract class ThreeAppEntryPointWithControler extends SimpleThreeAppEntryPoint{

	protected VerticalPanel controlerRootPanel;
	protected PopupPanel popup;
	
	protected void updateGUI(){
		if(popup==null){
			return;
		}
		popup.show();//for initial,show first before move
		moveToAroundRightTop(popup);
		
	}
	
	
	

	@Override
	public void init() {
		controlerRootPanel=createRightTopPopup();
		super.init();
		updateGUI();
	}

	private void moveToAroundRightTop(PopupPanel dialog){
		int clientWidth=Window.getClientWidth();
		int scrollTopPos=Window.getScrollTop();
		int dw=dialog.getOffsetWidth();
		
		
		
		//LogUtils.log(clientWidth+","+scrollTopPos+","+dw);
		
		
		dialog.setPopupPosition(clientWidth-dw, scrollTopPos+0);
		
	}
	
	protected void addResizeHandler(){
		
		//popup.show();
		//moveToAroundRightTop(popup);
		
		
		resizeHandler = Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				onWindowResize();
				updateGUI();
			}
		});
		
		
	}
	
	/*
	 * 320px
	 */
	protected VerticalPanel createRightTopPopup(){
		popup=new PopupPanel();	
		
		
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
		//root.setSpacing(2);
		
		//popup.show();
		//moveToAroundRightTop(popup);
		
		
		
		
		popup.show();
		moveToAroundRightTop(popup);
		
		return controler;
	}
}
