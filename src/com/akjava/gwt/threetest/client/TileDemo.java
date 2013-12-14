package com.akjava.gwt.threetest.client;



import com.akjava.gwt.html5.client.InputRangeListener;
import com.akjava.gwt.html5.client.InputRangeWidget;
import com.akjava.gwt.lib.client.CanvasUtils;
import com.akjava.gwt.lib.client.GWTHTMLUtils;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.experiments.CSS3DObject;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.lights.AmbientLight;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.event.dom.client.DragEvent;
import com.google.gwt.event.dom.client.DragHandler;
import com.google.gwt.event.dom.client.DragStartEvent;
import com.google.gwt.event.dom.client.DragStartHandler;
import com.google.gwt.event.dom.client.DropEvent;
import com.google.gwt.event.dom.client.DropHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class TileDemo extends AbstractDemo{

	private VerticalPanel controler;
	private Scene scene;
	private Camera camera;


	int cpos=1200;
	private InputRangeWidget range;
	private Vector3 cameraBase=THREE.Vector3();
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		
		
		camera = THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.setPosition(cpos, 600, cpos);
		
		scene = THREE.Scene();
		scene.add( camera );
		
		
		String wood="img/wood64.png";
		String plain="img/plain64.png";
		
		for ( int j = 0; j < 20; j ++ ) {
		for ( int i = 0; i < 20; i ++ ) {
			Object3D object;
			int num=(int) (Math.random()*2);
			String url=wood;
			if(num==1){
				url=plain;
			}
			if(renderer.gwtGetType().equals("css3d")){
				Image img=new Image(url);
				
				img.setWidth("50px");
				img.setHeight("50px");
				
				
				object= CSS3DObject.createObject(img.getElement());
				
			}else{
				
				
			Geometry g=THREE.PlaneGeometry(50, 50);
			object=THREE.Mesh(g, THREE.MeshBasicMaterial().map(ImageUtils.loadTexture(url)).build());
			
			}
			object.setPosition(i*50+25-500, 0,j*50+25-500);
			object.getRotation().setX(Math.toRadians(-90));
			scene.add(object);
		}
		}
		
		
		
		
		
		AmbientLight ambientLight =  THREE.AmbientLight( Math.random() * 0x10 );
		scene.add( ambientLight );

		
		DirectionalLight directionalLight = THREE.DirectionalLight(0xffffff );
		directionalLight.getPosition().setX(1);
		directionalLight.getPosition().setY(1);
		directionalLight.getPosition().setZ(1);
		directionalLight.getPosition().normalize();
		scene.add( directionalLight );
		
	
		
		controler = new VerticalPanel();
		range = InputRangeWidget.createInputRange(-180, 180, 0);
		range.setWidth(380);
		controler.add(range);
		range.addInputRangeListener(new InputRangeListener() {
			@Override
			public void changed(int newValue) {
				updateCamera();
			}
		});
		
		
		camera.lookAt( scene.getPosition() );
		
		Timer timer = new Timer(){
			public void run(){
				MainWidget.stats.begin();
			
				
				renderer.render( scene, camera );
				
				
				MainWidget.stats.end();
				
			}
		};
		
		
		
		startTimer(timer);
	}
	
	/*
	@Override
	public void onDoubleClick(DoubleClickEvent event) {
		Projector projector=THREE.Projector();
		JsArray<Intersect> intersects=projector.gwtPickIntersects(event.getX(), event.getY(), width, height, camera,scene);
		for(int i=0;i<intersects.length();i++){
			Intersect intersect=intersects.get(i);
			picker.setPosition(intersect.getObject().getPosition());
			
			
			
			cameraBase=intersect.getObject().getPosition().clone();
			updateCamera();
			
		}
	}
	*/
	
	public void onMouseMove(MouseMoveEvent event) {
		super.onMouseMove(event);
		if(mouseDown){
		int diff=event.getX()-mouseDownX;
		range.setValue(range.getValue()+diff);
		mouseDownX=event.getX();
		mouseDownY=event.getY();
		}
	}

	public void onMouseWheel(MouseWheelEvent event) {
		//GWT.log(""+event.getDeltaY());
		cpos+=event.getDeltaY()*10;
		cpos=Math.max(200, cpos);
		cpos=Math.min(2000, cpos);
		
		updateCamera();
		
		//cameraControle.doMouseWheel(event.getDeltaY());
	}
	
	private void updateCamera(){
		double rad=Math.toRadians(range.getValue());
		camera.getPosition().setX(Math.cos( rad ) * cpos);
		camera.getPosition().setZ(Math.sin( rad ) * cpos);
		camera.getPosition().addSelf(cameraBase);
		//GWT.log(ThreeLog.get(camera.getPosition()));
		camera.lookAt( cameraBase );
	}
	
	@Override
	public Widget getControler() {
		return controler;
	}
	
	@Override
	public String getName() {
		return "Tile";
	}

	@Override
	public String getHowToHtml() {
		return "Wheel to zoom,mouse drog to rotate";
	}
	@Override
	public boolean isSupportCSS3D(){
		return true;
	}

}
