/*
 * Copyright (C) 2011 aki@akjava.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.akjava.gwt.threecanvastest.client;

import com.akjava.gwt.lib.client.GWTHTMLUtils;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.java.ui.CameraMoveWidget;
import com.akjava.gwt.three.client.java.ui.CameraRotationWidget;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainWidget extends Composite {

	public static CameraMoveWidget cameraMove;
	public static CameraRotationWidget cameraRotation;
	private static MainWidgetUiBinder uiBinder = GWT.create(MainWidgetUiBinder.class);

	interface MainWidgetUiBinder extends UiBinder<Widget, MainWidget> {
	}

	private Demo lastDemo;
	public static Stats stats;
	final Demo[] demos=new Demo[]{//new HelloCSS3DDemo()
	new BoxDemo()
	
	};
	
	int width=500,height=500;
	public MainWidget() {
		stats=Stats.insertStatsToRootPanel();
		initWidget(uiBinder.createAndBindUi(this));
		
		
		renderer = THREE.CanvasRenderer();
		//renderer = THREE.CSS3DRenderer();
		LogUtils.log("renderer:"+renderer);
		LogUtils.log(renderer.getDomElement());
		GWTHTMLUtils.disableSelectionStart(renderer.getDomElement());
		
		renderer.setSize(width, height);
		
		
		StackLayoutPanel stackPanel = new StackLayoutPanel(Unit.PX);
		stackPanel.setSize("400px","506px");
		controler.add(stackPanel);
		
		howToPanel = new VerticalPanel();
		howToPanel.setSize("100%","100%");
		
		stackPanel.add(howToPanel,"How to",30);
		
		controlPanel = new VerticalPanel();
		controlPanel.setSize("100%","100%");
		
		stackPanel.add(controlPanel,"Controler",30);
		
		CameraMoveWidget cameraMove=new CameraMoveWidget();
		cameraMove.setVisible(false);//useless
		controler.add(cameraMove);
		
		MainWidget.cameraMove=cameraMove;
		
		CameraRotationWidget cameraRotation=new CameraRotationWidget();
		cameraRotation.setVisible(false);//useless
		controler.add(cameraRotation);
		
		MainWidget.cameraRotation=cameraRotation;
		
		
		
		
		HTMLPanel div=new HTMLPanel("");
		div.getElement().appendChild(renderer.getDomElement());
		focusPanel = new FocusPanel();
		focusPanel.add(div);
		
		
		
		
		
		
		
		getMain().add(focusPanel);
		
		for(int i=0;i<demos.length;i++){
			DemoButton demoButton=new DemoButton(demos[i]);
			side.add(demoButton);
			if(i==0){
				demoButton.startDemo();
			}
		}
		
		
		
	}

@UiField VerticalPanel main,side,controler;
private WebGLRenderer renderer;

private FocusPanel focusPanel;
private VerticalPanel howToPanel;
private VerticalPanel controlPanel;
	


public VerticalPanel getMain(){
return main;
}


public class DemoButton extends Button implements ClickHandler{
	Demo demo;
public DemoButton(Demo demo){
	super();
	this.demo=demo;
	setText(demo.getName());
	this.addClickHandler(this);
}
@Override
public void onClick(ClickEvent event) {
	startDemo();
}
public void startDemo(){
	if(lastDemo!=null){
		lastDemo.stop();
	}
	demo.start(renderer,width,height,focusPanel);
	howToPanel.clear();
	howToPanel.add(new HTMLPanel(demo.getHowToHtml()));
	
	controlPanel.clear();
	Widget w=demo.getControler();
	if(w!=null){
		controlPanel.add(w);
		}
	
	lastDemo=demo;
}
	
}



}
