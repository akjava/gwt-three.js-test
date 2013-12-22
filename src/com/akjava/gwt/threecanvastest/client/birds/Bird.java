package com.akjava.gwt.threecanvastest.client.birds;

import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.Geometry;

public class Bird extends Geometry{

	protected Bird(){

		

		
}
	public final void f3(double a,double b,double c ) {

		this.faces().push(  THREE.Face3( a, b, c ) );

	}
	
	public final void v(double x,double  y,double z ) {

		this.vertices().push(  THREE.Vector3( x, y, z ) );

	}
	public final void init() {
		v(   5,   0,   0 );
		v( - 5, - 2,   1 );
		v( - 5,   0,   0 );
		v( - 5, - 2, - 1 );

		v(   0,   2, - 6 );
		v(   0,   2,   6 );
		v(   2,   0,   0 );
		v( - 3,   0,   0 );

		f3( 0, 2, 1 );
		// f3( 0, 3, 2 );

		f3( 4, 7, 6 );
		f3( 5, 6, 7 );

		this.computeCentroids();
		this.computeFaceNormals();

		
	}
	

}
