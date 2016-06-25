package com.akjava.gwt.threejsexamples.client.examples.video;

import com.akjava.gwt.html5.client.download.DownloadURL;
import com.akjava.gwt.html5.client.file.File;
import com.akjava.gwt.html5.client.file.FileUtils;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.extras.geometries.SphereGeometry;
import com.akjava.gwt.three.client.js.materials.MeshBasicMaterial;
import com.akjava.gwt.three.client.js.math.THREEMath;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.VideoTexture;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.VideoElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class PanoramaEquirectangularExample extends AbstractExample{

	@Override
	public String getName() {
		return "video/panorama/equirectangular";
	}

	@Override
	public void animate(double timestamp) {

		render(timestamp);
		stats.update();//really deprecate?many still use this
	}

	private WebGLRenderer renderer;
	private Scene scene;
	private PerspectiveCamera camera;
	private Stats stats;

	double SCREEN_WIDTH;
	double SCREEN_HEIGHT;

	
	//private int mouseX,mouseY;

	Vector3 cameraTarget;
	Clock clock;
	private Mesh mesh;
	private double lon,lat,phi,theta;
	@Override
	public void init() {
	
		clock=THREE.Clock();
		
		 SCREEN_WIDTH = getWindowInnerWidth();
		 SCREEN_HEIGHT = getWindowInnerHeight();
		 

		FocusPanel container = createContainerPanel();
		
		// renderer
		renderer = THREE.WebGLRenderer();
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );
		renderer.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		container.getElement().appendChild( renderer.getDomElement() );

		// scene
		scene = THREE.Scene();
	
		// camera
		camera = THREE.PerspectiveCamera(75, getWindowInnerWidth()/getWindowInnerHeight(),1, 1100);
		cameraTarget=THREE.Vector3();
		
		SphereGeometry geometry = THREE.SphereGeometry( 500, 60, 40 );//var geometry = new THREE.SphereGeometry( 500, 60, 40 );
		geometry.scale( - 1, 1, 1 );
		
		videoElement = DOM.createElement("video").cast();
		
		videoElement.setWidth(640);//video.width = 640;
		videoElement.setHeight(360);//video.height = 360;
		videoElement.setAutoplay(true);//video.autoplay = true;
		videoElement.setLoop(true);//video.loop = true;
		videoElement.setSrc("textures/pano.webm");//video.src = "textures/pano.webm";

		texture = THREE.VideoTexture( videoElement );
		texture.setMinFilter(THREE.LinearFilter);//texture.minFilter = THREE.LinearFilter;
		
		MeshBasicMaterial material   = THREE.MeshBasicMaterial( GWTParamUtils.MeshBasicMaterial().map(texture) );//var material   = new THREE.MeshBasicMaterial( { map : texture } );

		mesh = THREE.Mesh( geometry, material );//mesh = new THREE.Mesh( geometry, material );

		scene.add( mesh );
		
		
		

		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML(
				"<div style='text:white'>" +
				"<a href='http://threejs.org' target='_blank'>three.js</a>" +
				"  " +
				"</div>"
				,100,10));
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		//setDebugAnimateOneTimeOnly(true);
		
		//TODO add handling event
		
		container.addMouseDownHandler(new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				isUserInteracting = true;

				onPointerDownPointerX = event.getX();
				onPointerDownPointerY = event.getY();

				onPointerDownLon = lon;
				onPointerDownLat = lat;
			}
		});
		container.addMouseUpHandler(new MouseUpHandler() {
			
			@Override
			public void onMouseUp(MouseUpEvent event) {
				isUserInteracting=false;
			}
		});
		container.addMouseMoveHandler(new MouseMoveHandler() {
			
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				if ( isUserInteracting == true ) {

					lon = ( onPointerDownPointerX - event.getX() ) * 0.1 + onPointerDownLon;
					lat = ( event.getY() - onPointerDownPointerY ) * 0.1 + onPointerDownLat;

				}
			}
		});
		
		container.addMouseWheelHandler(new MouseWheelHandler() {
			
			@Override
			public void onMouseWheel(MouseWheelEvent event) {
				//depend on os & browser
				int direction=1;
				if(event.getDeltaY()<0){
					direction=-1;
				}
				
				double increment=1*direction;
				
				camera.setFov(camera.getFov()-increment);
				
				camera.updateProjectionMatrix();
			}
		});
		
	}
	private int onPointerDownPointerX;
	private int onPointerDownPointerY;
	
	private boolean isUserInteracting;
	private double onPointerDownLon;
	private double onPointerDownLat;
	private VideoElement videoElement;
	private VideoTexture texture;

	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		//TODO add file chooser
		
		FileUpload upload=new FileUpload();
		upload.addChangeHandler(new ChangeHandler() {//TODO method
			
			@Override
			public void onChange(ChangeEvent event) {
				final JsArray<File> files=FileUtils.toFile(event.getNativeEvent());
				if(files.length()>0){
					String url=DownloadURL.get().createObjectURL(files.get(0));
					videoElement.setSrc(url);
					texture.setNeedsUpdate(true);
				}
			}
		});
		gui.add(upload);
		upload.getElement().setAttribute("accept", "video/*");
		
	}
	

	



	
	
	public void onWindowResize() {
		SCREEN_WIDTH = getWindowInnerWidth();
		SCREEN_HEIGHT = getWindowInnerHeight();
	
		//re read because of double
		camera.setAspect(SCREEN_WIDTH / SCREEN_HEIGHT);
		camera.updateProjectionMatrix();

		renderer.setSize( SCREEN_WIDTH , SCREEN_HEIGHT );
	
	}
	
	public void render(double now) {
		lat = Math.max( - 85, Math.min( 85, lat ) );
		phi = THREEMath.degToRad( 90 - lat );
		theta = THREEMath.degToRad( lon );

		cameraTarget.setX(500 * Math.sin( phi ) * Math.cos( theta ));//cameraTarget.x = 500 * Math.sin( phi ) * Math.cos( theta );
		cameraTarget.setY(500 * Math.cos( phi ));//cameraTarget.y = 500 * Math.cos( phi );
		cameraTarget.setZ(500 * Math.sin( phi ) * Math.sin( theta ));//cameraTarget.z = 500 * Math.sin( phi ) * Math.sin( theta );

		camera.lookAt( cameraTarget );


		renderer.render(scene, camera);
	}

	@Override
	public String getTokenKey() {
		return "equirectangular";
	}
}
