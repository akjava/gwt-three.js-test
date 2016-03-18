package com.akjava.gwt.threejsexamples.client;


import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.akjava.gwt.lib.client.URLUtils;
import com.akjava.gwt.threejsexamples.client.examples.DecalExample;
import com.akjava.gwt.threejsexamples.client.examples.MirrorExample;
import com.akjava.gwt.threejsexamples.client.examples.MorphnormalsExample;
import com.akjava.gwt.threejsexamples.client.examples.Ocean2Example;
import com.akjava.gwt.threejsexamples.client.examples.OceanExample;
import com.akjava.gwt.threejsexamples.client.examples.animation.SceneExample;
import com.akjava.gwt.threejsexamples.client.examples.animation.cloth.ClothExample;
import com.akjava.gwt.threejsexamples.client.examples.animation.skinning.BlendingExample;
import com.akjava.gwt.threejsexamples.client.examples.animation.skinning.MorphExample;
import com.akjava.gwt.threejsexamples.client.examples.buffergeometry.BufferGeometryExample;
import com.akjava.gwt.threejsexamples.client.examples.camera.CameraExample;
import com.akjava.gwt.threejsexamples.client.examples.geometries.GeometriesExample;
import com.akjava.gwt.threejsexamples.client.examples.light.HemisphereExample;
import com.akjava.gwt.threejsexamples.client.examples.misc.controls.OrbitExample;
import com.akjava.gwt.threejsexamples.client.examples.morphtargets.HorseExample;
import com.akjava.gwt.threejsexamples.client.examples.morphtargets.MorphTargetsExample;
import com.akjava.gwt.threejsexamples.client.examples.morphtargets.human.HumanExample;
import com.akjava.gwt.threejsexamples.client.examples.postprocessing.AdvancedExample;
import com.akjava.gwt.threejsexamples.client.examples.postprocessing.DofExample;
import com.akjava.gwt.threejsexamples.client.examples.postprocessing.GlitchExample;
import com.akjava.gwt.threejsexamples.client.examples.postprocessing.PostProcessingExample;
import com.akjava.gwt.threejsexamples.client.examples.shading.PhysicalExample;
import com.akjava.gwt.threejsexamples.client.examples.shadowmap.ShadowmapExample;
import com.akjava.gwt.threejsexamples.client.examples.vr.VrStereoExample;
import com.google.common.collect.Lists;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
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
		
		
		List<Example> examples=Lists.newArrayList();
		//examples.add(new MyExample());
		examples.add(new GeometriesExample());
		examples.add(new DecalExample());
		examples.add(new CameraExample());
		
		examples.add(new ShadowmapExample());
		examples.add(new PhysicalExample());
		examples.add(new HumanExample());
		examples.add(new MorphnormalsExample());
		examples.add(new HemisphereExample());
		examples.add(new SceneExample());
		examples.add(new ClothExample());
		examples.add(new MorphExample());
		examples.add(new BlendingExample());
		examples.add(new BufferGeometryExample());
		examples.add(new MorphTargetsExample());
		examples.add(new HorseExample());
		examples.add(new OrbitExample());
		examples.add(new VrStereoExample());
		
		examples.add(new MirrorExample());
		examples.add(new OceanExample());
		examples.add(new Ocean2Example());
		
		examples.add(new PostProcessingExample());
		examples.add(new GlitchExample());
		examples.add(new DofExample());
		examples.add(new AdvancedExample());
		
		
		Collections.sort(examples);
		
		//TODO add scroll
		for(Example exp:examples){
		side.add(new DemoAnchor(this,exp));
		}
		
		Label links=new Label("Links");
		links.setStylePrimaryName("subheader");
		side.add(links);
		side.add(new Anchor("Three.js(github)", "https://github.com/mrdoob/three.js/"));
		side.add(new Anchor("Three.js origin examples", "http://threejs.org/examples/"));
		side.add(new Anchor("GWT-Three.js(github)", "https://github.com/akjava/gwt-three.js-test"));
		side.add(new Anchor("GWT-Three.js old examples", "http://akjava.github.io/gwt-three.js-test/ThreeTest.html"));
		side.add(new Anchor("GWT", "http://www.gwtproject.org/"));
		
		Map<String,List<String>> tokens=URLUtils.parseToken(History.getToken(), false);
		
		for(String key:tokens.keySet()){
			for(final Example exp: examples){
				if(key.equals(exp.getTokenKey())){
					Scheduler.get().scheduleDeferred(new ScheduledCommand() {
						
						@Override
						public void execute() {
							selectNewExample(exp);//wait complete initialize
						}
					});
					
					break;
				}
			}
		}
		
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
		History.newItem(demo.getTokenKey());
	}
}
