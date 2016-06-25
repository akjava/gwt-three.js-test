package com.akjava.gwt.threejsexamples.client.examples.buffergeometry;

import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.GWTParamUtils;
import com.akjava.gwt.three.client.gwt.core.Offset;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.BufferGeometry;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.math.Color;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.typedarrays.client.Float32ArrayNative;
import com.google.gwt.typedarrays.client.Uint16ArrayNative;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class BufferGeometryExample extends AbstractExample{

	@Override
	public String getName() {
		return "buffergeometry";
	}

	@Override
	public void animate(double timestamp) {
		//do requestAnimationFrame on super class
		render(timestamp);
		stats.update();//really deprecate?many still use this
	}

	private WebGLRenderer renderer;
	private Scene scene;
	private PerspectiveCamera camera;
	private Stats stats;

	private Mesh mesh;
	@Override
	public void init() {
		FocusPanel container = createContainerPanel();

		
		
		camera = THREE.PerspectiveCamera( 27, getWindowInnerWidth() / getWindowInnerHeight(), 1, 3500 );//camera = new THREE.PerspectiveCamera( 27, window.innerWidth / window.innerHeight, 1, 3500 );
		camera.getPosition().setZ(2750);//camera.position.z = 2750;

		scene = THREE.Scene();//scene = new THREE.Scene();
		scene.setFog(THREE.Fog( 0x050505, 2000, 3500 ));//scene.fog = new THREE.Fog( 0x050505, 2000, 3500 );

		//

		scene.add( THREE.AmbientLight( 0x444444 ) );//scene.add( new THREE.AmbientLight( 0x444444 ) );

		DirectionalLight light1 = THREE.DirectionalLight( 0xffffff, 0.5 );//var light1 = new THREE.DirectionalLight( 0xffffff, 0.5 );
		light1.getPosition().set( 1, 1, 1 );//light1.position.set( 1, 1, 1 );
		scene.add( light1 );

		DirectionalLight light2 = THREE.DirectionalLight( 0xffffff, 1.5 );//var light2 = new THREE.DirectionalLight( 0xffffff, 1.5 );
		light2.getPosition().set( 0, -1, 0 );//light2.position.set( 0, -1, 0 );
		scene.add( light2 );

		//

		int triangles = 160000;//var triangles = 160000;

		BufferGeometry geometry = THREE.BufferGeometry();//var geometry = new THREE.BufferGeometry();

		
		int chunkSize = 21845;//var chunkSize = 21845;

		Uint16ArrayNative indices = Uint16ArrayNative.create(triangles * 3);

		for ( int i = 0; i < indices.length(); i ++ ) {

		indices.set(i, i % ( 3 * chunkSize ));

		}

		Float32ArrayNative positions = Float32ArrayNative.create( triangles * 3 * 3 );
		Float32ArrayNative normals = Float32ArrayNative.create( triangles * 3 * 3 );
		Float32ArrayNative colors = Float32ArrayNative.create( triangles * 3 * 3 );

		Color color = THREE.Color(0);//var color = new THREE.Color();

		int n = 800, n2 = n/2;	// triangles spread in the cube
		int d = 12, d2 = d/2;	// individual triangle size

		Vector3 pA = THREE.Vector3();//var pA = new THREE.Vector3();
		Vector3 pB = THREE.Vector3();//var pB = new THREE.Vector3();
		Vector3 pC = THREE.Vector3();//var pC = new THREE.Vector3();

		Vector3 cb = THREE.Vector3();//var cb = new THREE.Vector3();
		Vector3 ab = THREE.Vector3();//var ab = new THREE.Vector3();
		

		for ( int i = 0; i < positions.length(); i += 9 ) {

			// positions

			double x = Math.random() * n - n2;
			double y = Math.random() * n - n2;
			double z = Math.random() * n - n2;

			double ax = x + Math.random() * d - d2;
			double ay = y + Math.random() * d - d2;
			double az = z + Math.random() * d - d2;

			double bx = x + Math.random() * d - d2;
			double by = y + Math.random() * d - d2;
			double bz = z + Math.random() * d - d2;

			double cx = x + Math.random() * d - d2;
			double cy = y + Math.random() * d - d2;
			double cz = z + Math.random() * d - d2;

			positions.set( i ,(float)ax);
			positions.set( i+1 ,(float)ay);
			positions.set( i+2 ,(float)az);
			

			positions.set( i+3 ,(float)bx);
			positions.set( i+4 ,(float)by);
			positions.set( i+5 ,(float)bz);
			
			positions.set( i+6 ,(float)cx);
			positions.set( i+7 ,(float)cy);
			positions.set( i+8 ,(float)cz);

			
			// flat face normals

			pA.set( ax, ay, az );
			pB.set( bx, by, bz );
			pC.set( cx, cy, cz );

			cb.subVectors( pC, pB );
			ab.subVectors( pA, pB );
			cb.cross( ab );

			cb.normalize();

			double nx = cb.getX();
			double ny = cb.getY();
			double nz = cb.getZ();

			normals.set( i , (float)nx);
			normals.set( i + 1 ,(float) ny);
			normals.set( i + 2 ,(float) nz);

			normals.set( i + 3 ,(float) nx);
			normals.set(i + 4 , (float)ny);
			normals.set( i + 5 ,(float) nz);

			normals.set( i + 6 ,(float) nx);
			normals.set( i + 7 ,(float) ny);
			normals.set( i + 8 ,(float) nz);

			// colors

			double vx = ( x / n ) + 0.5;
			double vy = ( y / n ) + 0.5;
			double vz = ( z / n ) + 0.5;

			color.setRGB( vx, vy, vz );

			colors.set( i ,(float) color.getR());
			colors.set( i + 1 ,(float) color.getG());
			colors.set( i + 2 ,(float)color.getB());

			colors.set( i + 3 ,(float) color.getR());
			colors.set( i + 4 ,(float) color.getG());
			colors.set( i + 5 ,(float) color.getB());

			colors.set( i + 6 ,(float) color.getR());
			colors.set( i + 7 ,(float) color.getG());
			colors.set( i + 8 ,(float) color.getB());

		}
		
		geometry.addAttribute( "index", THREE.BufferAttribute( indices, 1 ) );//geometry.addAttribute( 'index', new THREE.BufferAttribute( indices, 1 ) );
		geometry.addAttribute( "position", THREE.BufferAttribute( positions, 3 ) );//geometry.addAttribute( 'position', new THREE.BufferAttribute( positions, 3 ) );
		geometry.addAttribute( "normal", THREE.BufferAttribute( normals, 3 ) );//geometry.addAttribute( 'normal', new THREE.BufferAttribute( normals, 3 ) );
		geometry.addAttribute( "color", THREE.BufferAttribute( colors, 3 ) );//geometry.addAttribute( 'color', new THREE.BufferAttribute( colors, 3 ) );

		int offsets = triangles / chunkSize;

		for ( int i = 0; i < offsets; i ++ ) {

		Offset offset=GWTParamUtils.Offset()
				.start( i * chunkSize * 3)
				.index(i * chunkSize * 3)
				.count(Math.min( triangles - ( i * chunkSize ), chunkSize ) * 3);
		
		geometry.getOffsets().push( offset );//geometry.offsets.push( offset );

		}
		
		geometry.computeBoundingSphere();

		MeshPhongMaterial material = THREE.MeshPhongMaterial( GWTParamUtils.MeshPhongMaterial().color(0xaaaaaa).specular(0xffffff).shininess(250).side(THREE.DoubleSide).vertexColors(THREE.VertexColors) );//var material = new THREE.MeshPhongMaterial( {color: 0xaaaaaa, specular: 0xffffff, shininess: 250,side: THREE.DoubleSide, vertexColors: THREE.VertexColors} );

		mesh = THREE.Mesh( geometry, material );//mesh = new THREE.Mesh( geometry, material );
		scene.add( mesh );

		//

		renderer = THREE.WebGLRenderer( GWTParamUtils.WebGLRenderer().antialias(false) );//renderer = new THREE.WebGLRenderer( { antialias: false } );
		renderer.setClearColor( scene.getFog().getColor());//renderer.setClearColor( scene.fog.color );
		renderer.setPixelRatio( GWTThreeUtils.getWindowDevicePixelRatio() );//renderer.setPixelRatio( window.devicePixelRatio );
		renderer.setSize( getWindowInnerWidth(), getWindowInnerHeight() );//renderer.setSize( window.innerWidth, window.innerHeight );

		renderer.setGammaInput(true);//renderer.gammaInput = true;
		renderer.setGammaOutput(true);//renderer.gammaOutput = true;

		

		
		// renderer
		
		container.getElement().appendChild( renderer.getDomElement() );

		
		//stats
		stats = Stats.create();
		stats.setPosition(0, 0);
		container.getElement().appendChild(stats.domElement());
		
		//add html info
		container.add(createAbsoluteHTML("<div style='text:white'><a href='http://threejs.org' target='_blank'>three.js</a>  - buffergeometry</a>"
				,100,10));
		
		
		//handle resize & gui
		initResizeHandlerAndGUI();
		
	}

	
	private void initResizeHandlerAndGUI() {
		VerticalPanel gui=addResizeHandlerAndCreateGUIPanel();
		
		gui.setWidth("200px");//some widget broke,like checkbox without parent size
		gui.setSpacing(2);
		
		//TODO create-gui
		
		//something strange when re-set true
		/*
		CheckBox ganmacheck=new CheckBox("use ganmaInput/Output");
		ganmacheck.setValue(true);
		gui.add(ganmacheck);
		ganmacheck.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				renderer.setGammaInput(event.getValue());
				renderer.setGammaOutput(event.getValue());
			}
		});
		*/
	}
	

	



	
	
	public void onWindowResize() {

		camera.setAspect(getWindowInnerWidth() / getWindowInnerHeight());
		camera.updateProjectionMatrix();

		renderer.setSize( (int)getWindowInnerWidth() , (int)getWindowInnerHeight() );
	}
	
	
	public void render(double now) {//GWT animateFrame has time
		double time = now * 0.001;

		mesh.getRotation().setX(time * 0.25);//mesh.rotation.x = time * 0.25;
		mesh.getRotation().setY(time * 0.5);//mesh.rotation.y = time * 0.5;
		
		renderer.render( scene, camera );
	}

	@Override
	public String getTokenKey() {
		return "buffergeometry";
	}
}
