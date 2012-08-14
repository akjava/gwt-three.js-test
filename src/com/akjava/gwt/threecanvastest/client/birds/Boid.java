package com.akjava.gwt.threecanvastest.client.birds;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.core.Vector3;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;

public class Boid {
	Vector3 position,velocity;
	Vector3 _goal;
	int _width = 500, _height = 500, _depth = 200, _neighborhoodRadius = 100;
	int _maxSpeed = 4;double _maxSteerForce = 0.1;boolean _avoidWalls = false;
	Vector3 vector = THREE.Vector3();
	Vector3 _acceleration = THREE.Vector3();
	
	public Vector3 getPosition() {
		return position;
	}
	public void setPosition(Vector3 position) {
		this.position = position;
	}
	public Vector3 getVelocity() {
		return velocity;
	}
	public void setVelocity(Vector3 velocity) {
		this.velocity = velocity;
	}
	public Boid(){
		
		
		
		this.setPosition( THREE.Vector3());
		this.setVelocity( THREE.Vector3());

			
	}
	
	public void setGoal(Vector3 target ) {

		_goal = target;

	}

	public void  setAvoidWalls(boolean value ) {

		_avoidWalls = value;

	}

	public void setWorldSize(int  width, int height,int depth ) {

		_width = width;
		_height = height;
		_depth = depth;

	}
	

	public void run(Boid[] boids ) {

		if ( _avoidWalls ) {

			vector.set( - _width, this.position.getY(), this.position.getZ() );
			vector = this.avoid( vector );
			vector.multiplyScalar( 5 );
			_acceleration.addSelf( vector );

			vector.set( _width, this.position.getY(), this.position.getZ() );
			vector = this.avoid( vector );
			vector.multiplyScalar( 5 );
			_acceleration.addSelf( vector );

			vector.set( this.position.getX(), - _height, this.position.getZ() );
			vector = this.avoid( vector );
			vector.multiplyScalar( 5 );
			_acceleration.addSelf( vector );

			vector.set( this.position.getX(), _height, this.position.getZ() );
			vector = this.avoid( vector );
			vector.multiplyScalar( 5 );
			_acceleration.addSelf( vector );

			vector.set( this.position.getX(), this.position.getY(), - _depth );
			vector = this.avoid( vector );
			vector.multiplyScalar( 5 );
			_acceleration.addSelf( vector );

			vector.set( this.position.getX(), this.position.getY(), _depth );
			vector = this.avoid( vector );
			vector.multiplyScalar( 5 );
			_acceleration.addSelf( vector );

		}/* else {

			this.checkBounds();

		}
		*/

		if ( Math.random() > 0.5 ) {

			this.flock( boids );

		}

		this.move();

	}
	

public void flock(Boid[] boids){

if ( _goal !=null ) {

_acceleration.addSelf( this.reach( _goal, 0.005 ) );

}

_acceleration.addSelf( this.alignment( boids ) );
_acceleration.addSelf( this.cohesion( boids ) );
_acceleration.addSelf( this.separation( boids ) );

}

public void move(){

this.velocity.addSelf( _acceleration );

double l = this.velocity.length();

if ( l > _maxSpeed ) {

this.velocity.divideScalar( l / _maxSpeed );

}

this.position.addSelf( this.velocity );
_acceleration.set( 0, 0, 0 );

}

public void checkBounds(){

if ( this.position.getX() >   _width ) this.position.setX(- _width) ;
if ( this.position.getX() < - _width ) this.position.setX(_width);
if ( this.position.getY() >   _height ) this.position.setY(- _height) ;
if ( this.position.getY() < - _height ) this.position.setY(_height);
if ( this.position.getZ() >  _depth ) this.position.setZ( - _depth);
if ( this.position.getZ() < - _depth ) this.position.setZ(  _depth);

}

	public Vector3 avoid(Vector3 target ) {

		Vector3 steer =  THREE.Vector3();

		steer.copy( this.position );
		steer.subSelf( target );

		steer.multiplyScalar( 1 / this.position.distanceToSquared( target ) );

		return steer;

	}
	

public void repulse(Vector3 target){

double distance = this.position.distanceTo( target );


if ( distance < 150 ) {
Vector3 steer = THREE.Vector3();

steer.sub( this.position, target );
steer.multiplyScalar( 0.5 / distance );

_acceleration.addSelf( steer );

}

}

public Vector3 reach(Vector3 target,double amount){

Vector3 steer = THREE.Vector3();

steer.sub( target, this.position );
steer.multiplyScalar( amount );

return steer;

}

public Vector3 alignment(Boid[] boids){

Boid boid;
Vector3 velSum = THREE.Vector3();
int count = 0;

for ( int i = 0, il = boids.length; i < il; i++ ) {

if ( Math.random() > 0.6 ) continue;

boid = boids[ i ];

double distance = boid.position.distanceTo( this.position );

if ( distance > 0 && distance <= _neighborhoodRadius ) {

velSum.addSelf( boid.velocity );
count++;

}

}

if ( count > 0 ) {

velSum.divideScalar( count );

double l = velSum.length();

if ( l > _maxSteerForce ) {

velSum.divideScalar( l / _maxSteerForce );

}

}

return velSum;

}

public Vector3 cohesion(Boid[] boids){

Boid boid;
double distance;
Vector3 posSum = THREE.Vector3();
Vector3 steer = THREE.Vector3();
int count = 0;

for ( int i = 0, il = boids.length; i < il; i ++ ) {

if ( Math.random() > 0.6 ) continue;

boid = boids[ i ];
distance = boid.position.distanceTo( this.position );

if ( distance > 0 && distance <= _neighborhoodRadius ) {

posSum.addSelf( boid.position );
count++;

}

}

if ( count > 0 ) {

posSum.divideScalar( count );

}

steer.sub( posSum, this.position );

double l = steer.length();

if ( l > _maxSteerForce ) {

steer.divideScalar( l / _maxSteerForce );

}

return steer;

}

public Vector3 separation(Boid[] boids){

Boid boid;
double distance;
Vector3 posSum = THREE.Vector3();
Vector3 repulse = THREE.Vector3();

for ( int i = 0, il = boids.length; i < il; i ++ ) {

if ( Math.random() > 0.6 ) continue;

boid = boids[ i ];
distance = boid.position.distanceTo( this.position );

if ( distance > 0 && distance <= _neighborhoodRadius ) {

repulse.sub( this.position, boid.position );
repulse.normalize();
repulse.divideScalar( distance );
posSum.addSelf( repulse );

}

}

return posSum;

}

}
