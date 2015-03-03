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
package com.akjava.gwt.threetest.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.client.GWTHTMLUtils;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.lib.client.URLUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.java.ui.CameraMoveWidget;
import com.akjava.gwt.three.client.java.ui.CameraRotationWidget;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;
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
	final Demo[] demos=new Demo[]{new CellShaderDemo(),new DragDemo(),new BoneDemo(),new CanvasDemo(),
			new SimpleCubeDemo(),new SphereDemo(),new SplineDemo(),new LoadObjDemo()
	,new ParticleDemo(),new ParticleSmoke(),new GeometryCube(),new CameraOrthoGraphics(),new HelloCSS3DDemo(),new PlainDemo(),new PickDemo(),new TileDemo(),
	new SkeletonHelperDemo()
	
	//new AngleDemo(), some of them for test,others now upgrading
			/*
			new DragDemo(),
			new SplineDemo(),//new CanvasDemo(),
			new NormalmapDemo(),new  SimpleAnimation(),new ParticleDemo2(),
			new ExplotionDemo3(),new ExplotionDemo2(),new ParticleDemo(),
			new ExplotionDemo(),new QuotaViewDemo(),new LoadObjDemo(),
			new PickDemo(),new ShadowDemo(),new TextureDemo(),
			new CylinderDemo(),new PlainDemo(),new SimpleDemo(),new SphereDemo()
			*/
			};
	int width=500,height=500;
	private int rendererType;
	public static final int RENDERER_WEBGL=0;
	public static final int RENDERER_CANVAS=1;
	public static final int RENDERER_CSS3D=2;
	public void stop(){
		if(lastDemo!=null){
			lastDemo.stop();
			lastDemo.clearHandlerRegistration();
		}
	}
	
	
	private void changeRenderer(String renderer){
		String token="renderer="+renderer.toLowerCase();
		Window.open(URLUtils.getLocalChangedUrl("default",token), "_self", null);
	}
	public MainWidget() {
		try{
			stats=Stats.insertStatsToRootPanel();
		stats.setPosition(8, 0);
		initWidget(uiBinder.createAndBindUi(this));
		
		Label dummy=new Label();
		dummy.setHeight("50px");
		side.add(dummy);
		
		side.add(new Label("Renderer"));
		VerticalPanel renderers=new VerticalPanel();
		side.add(renderers);
		RadioButton webglButton=new RadioButton("renderer", "WebGL");
		webglButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				changeRenderer("webgl");
			}
		});
		renderers.add(webglButton);
		webglButton.setValue(true);
		
		
		RadioButton canvasButton=new RadioButton("renderer", "Canvas");
		canvasButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				changeRenderer("canvas");
			}
		});
		renderers.add(canvasButton);
		
		/*
		 * somehow not work
		 * 
		RadioButton css3dButton=new RadioButton("renderer", "CSS3D");
		css3dButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				changeRenderer("css3d");
			}
		});
		renderers.add(css3dButton);
		*/
		
		
		/*
		final ListBox rendererListBox=new ListBox(false);
		rendererListBox.setWidth("90px");
		rendererListBox.addItem("WebGL");
		rendererListBox.addItem("Canvas");
		rendererListBox.addItem("CSS3D");
		rendererListBox.setSelectedIndex(0);
		side.add(rendererListBox);
rendererListBox.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				String token="renderer="+rendererListBox.getItemText(rendererListBox.getSelectedIndex()).toLowerCase();
				
				Window.open(URLUtils.getLocalChangedUrl("default",token), "_self", null);
			}
		});
		*/
		
		String type=URLUtils.getFirstTokenValue("renderer","webgl");
		
		if(type.equals("canvas")){
		rendererType=RENDERER_CANVAS;
		renderer = THREE.CanvasRenderer();
		renderer.gwtSetType("canvas");
		}else if(type.equals("css3d")){
		renderer=THREE.CSS3DRenderer();
		rendererType=RENDERER_CSS3D;
		renderer.gwtSetType("css3d");
		}
		else{
		renderer = THREE.WebGLRenderer();
		rendererType=RENDERER_WEBGL;
		if(renderer!=null){
		renderer.gwtSetType("webgl");
		}
		}
		
		
		
		if(renderer!=null){
		//for canvas
		GWTHTMLUtils.disableSelectionStart(renderer.getDomElement());
		//for css3
		GWTHTMLUtils.disableOnDragAndDrop(renderer.getDomElement());
		
		renderer.setSize(width, height);
		}else{
			}
		
		TabPanel stackPanel = new TabPanel();
		stackPanel.setSize("360px","506px");
		controler.add(stackPanel);
		
		howToPanel = new ScrollPanel();
		howToPanel.setSize("360px","480px");
		
		stackPanel.add(howToPanel,"How to");
		
		stackPanel.selectTab(0);
		
		controlPanel = new VerticalPanel();
		controlPanel.setSize("100%","100%");
		
		stackPanel.add(controlPanel,"Controler");
		
		CameraMoveWidget cameraMove=new CameraMoveWidget();
		cameraMove.setVisible(false);//useless
		controler.add(cameraMove);
		
		MainWidget.cameraMove=cameraMove;
		
		CameraRotationWidget cameraRotation=new CameraRotationWidget();
		cameraRotation.setVisible(false);//useless
		controler.add(cameraRotation);
		
		MainWidget.cameraRotation=cameraRotation;
		
		
		
		
		if(renderer!=null){
		HTMLPanel div=new HTMLPanel("");
		div.getElement().appendChild(renderer.getDomElement());
		focusPanel = new FocusPanel();
		focusPanel.add(div);
		}
		
		
		
		
		
		
		getMain().add(focusPanel);
		
		
		int selection=0;
		if(rendererType==RENDERER_CANVAS){
			selection=1;
			canvasButton.setValue(true);
		}else if(rendererType==RENDERER_CSS3D){
			selection=2;
			//css3dButton.setValue(true);
		}
		//rendererListBox.setSelectedIndex(selection);
		
		
		
		
		List<Demo> supportedDemo=new ArrayList<Demo>();
		for(int i=0;i<demos.length;i++){
			if(renderer==null){
				break;
			}
			if(rendererType==RENDERER_CANVAS){
				if(demos[i].isSupportCanvas()){
					supportedDemo.add(demos[i]);
				}
			}else if(rendererType==RENDERER_CSS3D){
				if(demos[i].isSupportCSS3D()){
					supportedDemo.add(demos[i]);
				}
			}else{
				if(demos[i].isSupportWebGL()){
					supportedDemo.add(demos[i]);
				}
			}
		}
		
		for(int i=0;i<supportedDemo.size();i++){
			DemoButton demoButton=new DemoButton(supportedDemo.get(i));
			side.add(demoButton);
			
			if(i==0){
				demoButton.startDemo();
			}
		}
		
		}catch (Exception e) {
			LogUtils.log(e.getMessage());
			side.add(new Label("maybe your browser not support webgl.use Chrome Browser or click canvas or css3d renderer.sadly mobile browser does not support webgl."));
			
		}
		
	}

@UiField VerticalPanel main,side,controler;
private WebGLRenderer renderer;

private FocusPanel focusPanel;
private ScrollPanel howToPanel;
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
	stop();
	demo.start(renderer,width,height,focusPanel);
	//howToPanel.clear();
	howToPanel.setWidget(new HTMLPanel(demo.getHowToHtml()));
	
	controlPanel.clear();
	Widget w=demo.getControler();
	if(w!=null){
		controlPanel.add(w);
		}
	
	lastDemo=demo;
}
	
}



}
