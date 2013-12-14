package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Projector;
import com.akjava.gwt.three.client.js.math.Matrix4;
import com.akjava.gwt.three.client.js.math.Quaternion;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.google.gwt.core.client.JsArrayNumber;

public class GWTThreeUtils {

	/*
	 * get angle from p1 to p2 ,use Z vector 
	 */
	public static Vector3 getRotation(Vector3 p1,Vector3 p2){
	Vector3 up=THREE.Vector3(0, 1, 0);
	Matrix4 mx=THREE.Matrix4();
	mx.lookAt(p2,p1,up);
	
	Vector3 ret=THREE.Vector3();
	ret.getRotationFromMatrix(mx);
	return ret;
	}
	
	public static Quaternion degreeRotationQuaternion(Vector3 vec){
		return rotationQuaternion(rotationToMatrix4(degreeToRagiant(vec)));
	}
	
	public static Quaternion rotationQuaternion(Vector3 vec){
		return rotationQuaternion(rotationToMatrix4(vec));
	}
	public static Quaternion rotationQuaternion(Matrix4 mx){
		Quaternion q=THREE.Quaternion();
		q.setFromRotationMatrix(mx);
		return q;
	}
	
	//Object positon to Screen Position
	public static native final Vector3 toScreenXY(Vector3 canvasXY,Camera camera,int width,int height)/*-{
	 var pos = canvasXY.clone();
    projScreenMat = new $wnd.THREE.Matrix4();
    projScreenMat.multiply( camera.projectionMatrix, camera.matrixWorldInverse );
    projScreenMat.multiplyVector3( pos );

    return new $wnd.THREE.Vector3( ( pos.x + 1 ) * width / 2,
        ( - pos.y + 1) * height / 2 ,0);
	}-*/;
	
	private static final Projector projector=THREE.Projector();
	
	//for camera position & rotation 0,0,0,
	public static Vector3 toWebGLXY(int mouseX,int mouseY,Camera camera,int width,int height){
		Vector3 mouseXY=THREE.Vector3(mouseX-width/2, -(mouseY-height/2), 0);
		Vector3 pj=projector.projectVector(mouseXY, camera);
		return pj;
	}
	
	public static Mesh createSimpleBox(Vector3 position,double size,int color){
		Mesh mesh=THREE.Mesh(THREE.CubeGeometry(size, size, size), THREE.MeshLambertMaterial().color(color).build());
		mesh.setPosition(position);
		return mesh;
	}
	public static Vector3 radiantToDegree(Vector3 vec){
		Vector3 ret=THREE.Vector3();
		ret.setX(Math.toDegrees(vec.getX()));
		ret.setY(Math.toDegrees(vec.getY()));
		ret.setZ(Math.toDegrees(vec.getZ()));
		return ret;
	}
	public static Vector3 degreeToRagiant(Vector3 vec){
		Vector3 ret=THREE.Vector3();
		ret.setX(Math.toRadians(vec.getX()));
		ret.setY(Math.toRadians(vec.getY()));
		ret.setZ(Math.toRadians(vec.getZ()));
		return ret;
	}
	public static Matrix4 degitRotationToMatrix4(double x,double y,double z){
		return GWTThreeUtils.rotationToMatrix4(GWTThreeUtils.degreeToRagiant(THREE.Vector3(x,y,z)));
	}
	public static Matrix4 degitRotationToMatrix4(Vector3 angle){
		return GWTThreeUtils.rotationToMatrix4(GWTThreeUtils.degreeToRagiant(angle));
	}
	
	public static Matrix4 rotationToMatrix4(Vector3 vec){
		return rotationToMatrix4(vec,"XYZ");
	}
	public static Matrix4 rotationToMatrix4(Quaternion q){
		Matrix4 mx=THREE.Matrix4();
		return mx.setRotationFromQuaternion(q);
	}
	public static Matrix4 rotationToMatrix4(Vector3 vec,String order){
		Matrix4 mx=THREE.Matrix4();
		mx.setRotationFromEuler(vec, order);
		return mx;
	}
	public static Vector3 rotationToVector3(Quaternion q){
		Matrix4 mx=THREE.Matrix4();
		mx.setRotationFromQuaternion(q);
		return rotationToVector3(mx);
	}
	
	public static Vector3 rotationToVector3(Matrix4 mx){
		Vector3 vec=THREE.Vector3();
		vec.getRotationFromMatrix(mx);
		return vec;
	}
	public static Vector3 rotationToDegreeVector3(Matrix4 mx){
		Vector3 vec=THREE.Vector3();
		vec.getRotationFromMatrix(mx);
		return radiantToDegree(vec);
	}
	public static Matrix4 translateToMatrix4(Vector3 vec){
		Matrix4 mx=THREE.Matrix4();
		mx.setTranslation(vec.getX(),vec.getY(),vec.getZ());
		return mx;
	}
	public static Vector3 toPositionVec(Matrix4 mx){
		
		Vector3 vec=THREE.Vector3();
		vec.getPositionFromMatrix(mx);
		return vec;
	}
	public static Vector3 toDegreeAngle(Matrix4 mx){
		Vector3 vec=THREE.Vector3();
		vec.getRotationFromMatrix(mx);
		double x=Math.toDegrees(vec.getX());
		x%=360;
		if(x>180){
			x=-(360-x);
		}
		
		//vec.setX(x);
		
		double y=Math.toDegrees(vec.getY());
		y%=360;
		if(y>180){
			y=-(360-y);
		}
		
		//vec.setY(y);
		
		
		double z=Math.toDegrees(vec.getZ());
		z%=360;
		if(z>180){
			z=-(360-z);
		}
		
		//vec.setY(z);
		
		//return vec; //i have no idea but sometime  return radiant value.
		return THREE.Vector3(x, y, z);
	}
	
	public static final Vector3 jsArrayToVector3(JsArrayNumber array){
		return THREE.Vector3(array.get(0),array.get(1), array.get(2));
	}
	
	public static final JsArrayNumber clone(JsArrayNumber array){
		JsArrayNumber cloned=(JsArrayNumber) JsArrayNumber.createArray();
		for(int i=0;i<array.length();i++){
			cloned.push(array.get(i));
		}
		return cloned;
	}
	
	public static final Quaternion jsArrayToQuaternion(JsArrayNumber array){
		return THREE.Quaternion(array.get(0),array.get(1), array.get(2),array.get(3));
	}
	
	public static final JsArrayNumber createJsArray(double x,double y,double z){
		JsArrayNumber array=(JsArrayNumber) JsArrayNumber.createArray();
		array.push(x);
		array.push(y);
		array.push(z);
		return array;
	}
	public static final JsArrayNumber quaternionToJsArray(Quaternion q){
		JsArrayNumber array=(JsArrayNumber) JsArrayNumber.createArray();
		array.push(q.getX());
		array.push(q.getY());
		array.push(q.getZ());
		array.push(q.getW());
		return array;
	}
}
