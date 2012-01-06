package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Projector;
import com.akjava.gwt.three.client.core.Vector3;

public class GWTUtils {

	/*
	 * get angle from p1 to p2 ,use Z vector 
	 */
	public Vector3 getRotation(Vector3 p1,Vector3 p2){
	Vector3 up=THREE.Vector3(0, 1, 0);
	Matrix4 mx=THREE.Matrix4();
	mx.lookAt(p2,p1,up);
	
	Vector3 ret=THREE.Vector3();
	ret.setRotationFromMatrix(mx);
	return ret;
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
	public static Vector3 toWebGLXY(int mouseX,int mouseY,Camera camera,int width,int height){
		Vector3 mouseXY=THREE.Vector3(mouseX-width/2, -(mouseY-height/2), 0);
		Vector3 pj=projector.projectVector(mouseXY, camera);
		return pj;
	}
	
}
