package com.akjava.gwt.threecanvastest.client;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Color;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.materials.MeshBasicMaterial;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.akjava.gwt.threecanvastest.client.birds.Bird;
import com.akjava.gwt.threecanvastest.client.birds.Boid;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class GeometryBird extends AbstractDemo{

	int SCREEN_WIDTH ,
			SCREEN_HEIGHT,
			SCREEN_WIDTH_HALF,
			SCREEN_HEIGHT_HALF;

			Camera camera;
			Scene scene;
			WebGLRenderer renderer;
			Mesh[] birds;
			Mesh bird;

			Boid boid;
			Boid[] boids;


			
@Override
public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
	super.start(renderer, width, height, panel);
	SCREEN_WIDTH=width;
	SCREEN_HEIGHT=height;
	SCREEN_WIDTH_HALF=width/2;
	SCREEN_HEIGHT_HALF=height/2;
	this.renderer=renderer;
init();



Timer timer = new Timer(){
	public void run(){
		MainWidget.stats.update();
		render();
	}
};

startTimer(timer);
}

public void init() {

camera = THREE.PerspectiveCamera( 75, SCREEN_WIDTH / SCREEN_HEIGHT, 1, 10000 );
camera.getPosition().setZ( 450);

scene = THREE.Scene();

scene.add( camera );

birds = new Mesh[200];
boids = new Boid[200];

for ( int i = 0; i < 200; i ++ ) {

boid = boids[ i ] = new Boid();
boid.getPosition().setX( Math.random() * 400 - 200);
boid.getPosition().setY( Math.random() * 400 - 200);
boid.getPosition().setZ( Math.random() * 400 - 200);
boid.getVelocity().setX( Math.random() * 2 - 1);
boid.getVelocity().setY( Math.random() * 2 - 1);
boid.getVelocity().setZ( Math.random() * 2 - 1);
boid.setAvoidWalls( true );
boid.setWorldSize( 500, 500, 400 );

Bird b=(Bird) THREE.Geometry();
b.init();

Material material=THREE.MeshBasicMaterial().color(Math.random() * 0xffffff ).build() ;
bird = birds[ i ] = THREE.Mesh( b, 
		material );

bird.setPhase( Math.floor( Math.random() * 62.83 ));
bird.setPosition( boids[ i ].getPosition());
bird.setDoubleSided( true);
// bird.scale.x = bird.scale.y = bird.scale.z = 10;
scene.add( bird );


}

//renderer = THREE.CanvasRenderer();
// renderer.autoClear = false;
//renderer.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );

//document.addEventListener( 'mousemove', onDocumentMouseMove, false );
//document.body.appendChild( renderer.domElement );
/*
stats = new Stats();
stats.getDomElement().getStyle().setPosition( 'absolute');
stats.getDomElement().getStyle().setLeft( '0px');
stats.getDomElement().getStyle().setTop( '0px');

document.getElementById( 'container' ).appendChild(stats.domElement);
*/
}

/* TODO mouse
function onDocumentMouseMove( event ) {

Vector3 vector = THREE.Vector3( event.clientX - SCREEN_WIDTH_HALF, - event.clientY + SCREEN_HEIGHT_HALF, 0 );

for ( int i = 0, il = boids.length; i < il; i++ ) {

boid = boids[ i ];

vector.setZ( boid.position.z);

boid.repulse( vector );

}

}
*/

//

@Override
public void onMouseMove(MouseMoveEvent event) {
super.onMouseMove(event);
Vector3 vector = THREE.Vector3( event.getX() - SCREEN_WIDTH_HALF, - event.getY() + SCREEN_HEIGHT_HALF, 0 );

//LogUtils.log(""+ThreeLog.get(vector));

for ( int i = 0, il = boids.length; i < il; i++ ) {

boid = boids[ i ];

vector.setZ( boid.getPosition().getZ());

boid.repulse( vector );

}

}



public void render() {
//LogUtils.log("render");

for ( int i = 0, il = birds.length; i < il; i++ ) {

boid = boids[ i ];
boid.run( boids );

bird = birds[ i ];

Color color = ((MeshBasicMaterial)bird.getMaterial()).getColor();
double c=( 500 - bird.getPosition().getZ() ) / 1000;
color.setRGB(c,c,c);
bird.getRotation().setY( Math.atan2( - boid.getVelocity().getZ(), boid.getVelocity().getX() ));
bird.getRotation().setZ( Math.asin( boid.getVelocity().getY() / boid.getVelocity().length() ));

bird.setPhase( ( bird.getPhase() + ( Math.max( 0, bird.getRotation().getZ() ) + 0.1 )  ) % 62.83);
double y=Math.sin( bird.getPhase() ) * 5;
bird.getGeometry().vertices().get( 5 ).setY(y);
bird.getGeometry().vertices().get( 4 ).setY(y);
}

renderer.render( scene, camera );

}

@Override
public String getName() {
	return "Geometry Bird";
}

@Override
public String getHowToHtml() {
	return "now working yet<br>GWt version of <a href='http://mrdoob.github.com/three.js/examples/canvas_geometry_birds.html' target='threejs'>canvas_geometry_birds</a>";
}
}
