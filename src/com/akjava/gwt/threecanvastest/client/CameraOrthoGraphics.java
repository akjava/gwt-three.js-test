package com.akjava.gwt.threecanvastest.client;



import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.lights.AmbientLight;
import com.akjava.gwt.three.client.lights.DirectionalLight;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.objects.Line;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class CameraOrthoGraphics extends AbstractDemo{

	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		GWT.log(width+","+height);
		final Camera camera =  THREE.OrthographicCamera( width / - 2, width / 2,height / 2,height / - 2, - 2000, 1000 );
		camera.setPosition(200, 100, 200);
		
		final Scene scene = THREE.Scene();
		scene.add( camera );
		
		
		Geometry geometry = THREE.Geometry();
		geometry.vertices().push( THREE.Vertex( THREE.Vector3( - 500, 0, 0 ) ) );
		geometry.vertices().push( THREE.Vertex( THREE.Vector3( 500, 0, 0 ) ) );
		
		for ( int i = 0; i <= 20; i ++ ) {

			Line line =  THREE.Line( geometry,THREE.LineBasicMaterial().color(0x000000).opacity(0.2).build());
			line.getPosition().setZ(( i * 50 ) - 500);
			scene.add( line );

			Line line2 =  THREE.Line( geometry,THREE.LineBasicMaterial().color(0x000000).opacity(0.2).build());
			//Line line2 =  THREE.Line( geometry,THREE.LineBasicMaterial().color(0xff0000).opacity(1).linewidth(100).build());
			
			line2.getPosition().setX(( i * 50 ) - 500);
			line2.getRotation().setY(90 * Math.PI / 180);
			scene.add( line2 );

		}
		
		geometry = THREE.CubeGeometry( 50, 50, 50 );
		Material material =  THREE.MeshLambertMaterial().color(0xffffff).overdraw(true).shading(THREE.FlatShading).build();

		for ( int i = 0; i < 100; i ++ ) {

			Mesh cube =  THREE.Mesh( geometry, material );
			cube.setOverdraw(true);

			cube.getScale().setY(Math.floor( Math.random() * 2 + 1 ));

			cube.getPosition().setX(Math.floor( ( Math.random() * 1000 - 500 ) / 50 ) * 50 + 25);
			cube.getPosition().setY(( cube.getScale().getY() * 50 ) / 2);
			cube.getPosition().setZ((Math.floor( ( Math.random() * 1000 - 500 ) / 50 ) * 50 + 25));

			scene.add(cube);

		}
		
		//light
		//AmbientLight ambientLight =  THREE.AmbientLight( Math.random() * 0xffffff );
		AmbientLight ambientLight =  THREE.AmbientLight( Math.random() * 0x10 );
		scene.add( ambientLight );

		DirectionalLight directionalLight = THREE.DirectionalLight( Math.random() * 0xffffff );
		directionalLight.getPosition().setX(Math.random() - 0.5);
		directionalLight.getPosition().setY(Math.random() - 0.5);
		directionalLight.getPosition().setZ(Math.random() - 0.5);
		directionalLight.getPosition().normalize();
		scene.add( directionalLight );
		
		directionalLight = THREE.DirectionalLight( Math.random() * 0xffffff );
		directionalLight.getPosition().setX(Math.random() - 0.5);
		directionalLight.getPosition().setY(Math.random() - 0.5);
		directionalLight.getPosition().setZ(Math.random() - 0.5);
		directionalLight.getPosition().normalize();
		scene.add( directionalLight );
		
		
		//cameraControle.setPositionZ(20);
		
		
		
		
		
		Timer timer = new Timer(){
			public void run(){
				MainWidget.stats.update();
			
				
				double timer = System.currentTimeMillis() * 0.0001;

				camera.getPosition().setX(Math.cos( timer ) * 200);
				camera.getPosition().setZ(Math.sin( timer ) * 200);
				camera.lookAt( scene.getPosition() );

				renderer.render( scene, camera );
				
				
				
				camera.lookAt( scene.getPosition() );
				
				renderer.render(scene, camera);
			}
		};
		
		/*
		Timer timer = new Timer(){
			public void run(){
				camera.lookAt( scene.getPosition() );
				renderer.render(scene, camera);
			}
		};*/
		
		
		startTimer(timer);
	}
	
	@Override
	public String getName() {
		return "Camera Orthographics";
	}

	@Override
	public String getHowToHtml() {
		return "GWt version of <a href='http://mrdoob.github.com/three.js/examples/canvas_camera_orthographic.html' target='threejs'>canvas_camera_orthographics</a>";
	}

}
