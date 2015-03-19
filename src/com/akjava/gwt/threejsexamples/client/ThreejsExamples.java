package com.akjava.gwt.threejsexamples.client;


import com.akjava.gwt.threejsexamples.client.examples.animation.skinning.BlendingExample;
import com.akjava.gwt.threejsexamples.client.examples.animation.skinning.MorphExample;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ThreejsExamples implements EntryPoint,ExampleOwner {
	private DockLayoutPanel center;

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

		DockLayoutPanel root=new DockLayoutPanel(Unit.PX);
		
		RootLayoutPanel.get().add(root);
		
		center = new DockLayoutPanel(Unit.PX);
		
		
		
		
		//left-side
		VerticalPanel side=new VerticalPanel();
		side.setWidth("100%");
		side.setStylePrimaryName("side");
		side.setSpacing(4);
		
		Label title=new Label("GWT-three.js Examples");
		title.setStylePrimaryName("header");
		
		side.add(title);
		
		Label webgl=new Label("webgl");
		webgl.setStylePrimaryName("subheader");
		webgl.setWidth("100%");
		side.add(webgl);
		root.addWest(side, 300);
		root.add(center);
		
		//TODO add scroll
		
		side.add(new DemoAnchor(this,new MorphExample()));
		side.add(new DemoAnchor(this,new BlendingExample()));
	}

	public class DemoAnchor extends Anchor{
		public DemoAnchor(final ExampleOwner owner,final Example demo){
			super(demo.getName());
			this.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					owner.selectNewExample(demo);
				}
			});
		}
	}

	@Override
	public Panel getPanel() {
		return center;
	}

	private Example lastDemo;
	@Override
	public void selectNewExample(Example demo) {
		if(lastDemo!=null){
			lastDemo.stop();
		}
		demo.start(getPanel());
		lastDemo=demo;
	}
}
