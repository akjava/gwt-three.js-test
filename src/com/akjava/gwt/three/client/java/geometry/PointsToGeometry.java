package com.akjava.gwt.three.client.java.geometry;

import java.util.List;

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.Face3;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JsArray;

/**
 * basically designed doubleside and connected
 * @author aki
 *
 */
public class PointsToGeometry {
	double tickUv=0.01;//Texture area 
	/*
	 * left-top is center area.bottom edge is top.right edge is left
	 * 
	 */
	//double tickUv=0.25;//for debug
	/*
	 * hand make geometry
	 * 
	 * UV is totall broken so far
	 */
	
	private double uBase=1.0;
	private int slicesPlus;
	double vBase;
	int stacks;
	
	private Vector3 normal;
	
	public Vector3 getVertexNormal() {
		return normal;
	}
	public void setVertexNormal(Vector3 normal) {
		this.normal = normal;
	}
	
	public PointsToGeometry vertexNormal(Vector3 normal){
		this.normal = normal;
		return this;
	}
	
	private Vector2 getUv(int u,int v){
		return THREE.Vector2( (double)u / slicesPlus*uBase, (double)v / stacks *vBase);
	}
	/*
	 * not thread safe
	 */
	public Geometry createGeometry(List<Vector3> points,int slices,double thick,boolean connectHorizontal){
		if(thick==0){
			LogUtils.log("0 thick not support yet");
		}
		
		Geometry geometry=THREE.Geometry();
		
		stacks=(points.size()/(slices+1))-1; //stacks is face count.not vertex count
		
		
		vBase=1.0-tickUv*2;
		
		for(int i=0;i<=stacks;i++){
			for(int j=0;j<=slices;j++){
				int index=i*(slices+1)+j;
				geometry.getVertices().push(points.get(index).clone());
			}
		}
		
		int sliceCount=slices+1;
		
		slicesPlus=connectHorizontal?slices+1:slices;
		if(!connectHorizontal){
			uBase-=tickUv*2;
		}
		
		
		JsArray<JsArray<Vector2>> uvs=geometry.getFaceVertexUvs().get(0).cast();
		
		for ( double i = 0; i < stacks; i ++ ) {

			for ( double j = 0; j < slices; j ++ ) {

			int	a = (int)(i * sliceCount + j);
			int	b = (int)(i * sliceCount + j + 1);
			int	c = (int)(( i + 1 ) * sliceCount + j + 1);
			int	d = (int)(( i + 1 ) * sliceCount + j);

			Vector2	uva = getUv((int)j,(int)i);
			Vector2	uvb = getUv((int)j+1,(int)i);
			Vector2	uvc = getUv((int)j+1,(int)i+1);
			Vector2	uvd = getUv((int)j,(int)i+1);
			
			
			

				geometry.getFaces().push( THREE.Face3( d, b, a ) );
				pushUv(uvs,uvd, uvb, uva  );

				geometry.getFaces().push(THREE.Face3( d, c, b ) );
				pushUv(uvs,uvd.clone() , uvc, uvb.clone() );

			}

		}
		
		int frontGeometrySize=geometry.getVertices().length();
		
		//LogUtils.log("first-surface:"+frontGeometrySize);
		
		geometry.computeFaceNormals();
		geometry.computeVertexNormals();
		
		
		
		//create second one
		//TODO option to reverse.
		//calcurate normals
		JsArray<Vector3> normals=JsArray.createArray().cast();
		for(int i=0;i<geometry.getFaces().length();i++){
			Face3 face=geometry.getFaces().get(i);
			for(int j=0;j<3;j++){
				int vindex=face.gwtGet(j);
				
				Vector3 normalValue=normals.get(vindex);
				if(normalValue==null){
					normalValue=THREE.Vector3();
					normals.set(vindex, normalValue);
				}
				normalValue.add(face.getVertexNormals().get(j));
				
			}
		}
		
		if(normal!=null){
			normal.normalize();
		}
		
		//second one
		for(int i=0;i<=stacks;i++){
			for(int j=0;j<=slices;j++){
				int index=i*(slices+1)+j;
				Vector3 v=points.get(index).clone();
				//ThreeLog.log("normal:",normals.get(index));
				
				Vector3 vertexNormal=normal;
				if(vertexNormal==null){
					vertexNormal=normals.get(index).normalize();
				}
				
				//ThreeLog.log("upNormal",vertexNormal.clone().multiplyScalar(thick));
				
				v.add(vertexNormal.clone().multiplyScalar(thick));
				
				geometry.getVertices().push(v);
			}
		}
		
		for ( double i = 0; i < stacks; i ++ ) {

			for ( double j = 0; j < slices; j ++ ) {

			int	a = (int)(i * sliceCount + j)+frontGeometrySize;
			int	b = (int)(i * sliceCount + j + 1)+frontGeometrySize;
			int	c = (int)(( i + 1 ) * sliceCount + j + 1)+frontGeometrySize;
			int	d = (int)(( i + 1 ) * sliceCount + j)+frontGeometrySize;
			
			Vector2	uva = getUv((int)j,(int)i);
			Vector2	uvb = getUv((int)j+1,(int)i);
			Vector2	uvc = getUv((int)j+1,(int)i+1);
			Vector2	uvd = getUv((int)j,(int)i+1);
			
			
			geometry.getFaces().push( THREE.Face3( d, b, a ) );
			pushUv(uvs,uvd, uvb, uva ) ;

			geometry.getFaces().push(THREE.Face3( d, c, b ) );
			pushUv(uvs, uvd.clone(), uvc,uvb.clone()   );
			
			}
		}
		
		//top
		
		if(thick!=0){
		
		for ( double j = 0; j < slices; j ++ ) {
			int i=0;
			int	a = (int)(i * sliceCount + j);
			int	b = (int)(i * sliceCount + j +1);
			int	c = (int)(i * sliceCount + j+1)+frontGeometrySize;
			int	d = (int)(i * sliceCount + j)+frontGeometrySize;
			
			//TODO modify uv
			Vector2	uva = getUv((int)j,(int)i);
			Vector2	uvb = getUv((int)j+1,(int)i);
			Vector2	uvc = getUv((int)j+1,(int)i);
			Vector2	uvd = getUv((int)j,(int)i);
			
			uva.setY(vBase+tickUv);
			uvb.setY(vBase+tickUv);
			uvc.setY(1);
			uvd.setY(1);
			
			
			geometry.getFaces().push( THREE.Face3( a, b, d ) );
			pushUv(uvs, uva, uvb, uvd );

			geometry.getFaces().push(THREE.Face3( b, c, d ) );
			pushUv(uvs, uvb.clone(), uvc, uvd.clone());
			
		}
		
		//bottom
		
		for ( double j = 0; j < slices; j ++ ) {
			int i=stacks;
			int	a = (int)(i * sliceCount + j);
			int	b = (int)(i * sliceCount + j +1);
			int	c = (int)(i * sliceCount + j+1)+frontGeometrySize;
			int	d = (int)(i * sliceCount + j)+frontGeometrySize;
			
			Vector2	uva = getUv((int)j,(int)i);
			Vector2	uvb = getUv((int)j+1,(int)i);
			Vector2	uvc = getUv((int)j+1,(int)i);
			Vector2	uvd = getUv((int)j,(int)i);
			
			uva.setY(vBase);
			uvb.setY(vBase);
			uvc.setY(vBase+tickUv);
			uvd.setY(vBase+tickUv);
			
			geometry.getFaces().push( THREE.Face3( d, b, a ) );
			pushUv(uvs, uvd, uvb, uva );

			geometry.getFaces().push(THREE.Face3( d, c, b ) );
			pushUv(uvs, uvd.clone(), uvc, uvb.clone());
			
		}
		}
		
		if(connectHorizontal){
			int primaryFirstTop=0;
			int primaryLastTop=0;
			int secondaryFirstTop=0;
			int secondaryLastTop=0;
			
		int primaryFirstBottom=0;
		int primaryLastBottom=0;
		int secondaryFirstBottom=0;
		int secondaryLastBottom=0;
		for ( double i = 0; i < stacks; i ++ ) {
			int j=0;
			int j2=slices;
			int	a = (int)(i * sliceCount + j);
			int	b = (int)(( i + 1 ) * sliceCount + j);
			int	d = (int)(i * sliceCount + j2);
			int	c = (int)(( i + 1 ) * sliceCount + j2);
			
			Vector2	uva = getUv(slices,(int)i);
			Vector2	uvb = getUv(slices+1,(int)i);
			Vector2	uvc = getUv(slices+1,(int)i+1);
			Vector2	uvd = getUv(slices,(int)i+1);
			
			geometry.getFaces().push( THREE.Face3( d, b, a) );
			pushUv(uvs, uvd, uvb,uva  );

			geometry.getFaces().push(THREE.Face3( d, c, b ) );
			pushUv(uvs, uvd.clone(), uvc,uvb.clone() );	
			
			if(i==0){
				primaryFirstTop=a;
				primaryLastTop=d;
			}
			else if(i==stacks-1){
				primaryFirstBottom=b;
				primaryLastBottom=c;
			}
		}
		for ( double i = 0; i < stacks; i ++ ) {
			int j=0;
			int j2=slices;
			int	a = (int)(i * sliceCount + j)+frontGeometrySize;
			int	b = (int)(( i + 1 ) * sliceCount + j)+frontGeometrySize;
			int	d = (int)(i * sliceCount + j2)+frontGeometrySize;
			int	c = (int)(( i + 1 ) * sliceCount + j2)+frontGeometrySize;
			
			Vector2	uva = getUv(slices,(int)i);
			Vector2	uvb = getUv(slices+1,(int)i);
			Vector2	uvc = getUv(slices+1,(int)i+1);
			Vector2	uvd = getUv(slices,(int)i+1);
			
			geometry.getFaces().push( THREE.Face3( d, b, a ) );
			pushUv(uvs, uvd, uvb, uva );

			geometry.getFaces().push(THREE.Face3( d, c, b ) );
			pushUv(uvs, uvd.clone(), uvc,uvb.clone() );	
			if(i==0){
				secondaryFirstTop=a;
				secondaryLastTop=d;
			}
			else 
			if(i==stacks-1){
				secondaryFirstBottom=b;
				secondaryLastBottom=c;
			}
		}
		if(thick!=0){
			//add bottom
			Vector2	uva = getUv(slices+1,0);
			Vector2	uvb = getUv(slices+1,0);
			Vector2	uvc = getUv(slices+1,0);
			Vector2	uvd = getUv(slices+1,0);
			//LogUtils.log("top:"+primaryFirstTop+","+primaryLastTop+","+secondaryFirstTop+","+secondaryLastTop);
			
			//set first
			uva.setY(vBase+tickUv);
			uvb.setY(vBase+tickUv);
			uvc.setY(1);
			uvd.setY(1);
			
			geometry.getFaces().push( THREE.Face3(primaryFirstTop, secondaryFirstTop,primaryLastTop  ) );
			pushUv(uvs, uva, uvb, uvd );
			
			geometry.getFaces().push( THREE.Face3( secondaryFirstTop ,secondaryLastTop,primaryLastTop) );
			pushUv(uvs, uvb.clone(), uvc, uvd.clone());	
			//LogUtils.log("bottom:"+primaryFirstBottom+","+primaryLastBottom+","+secondaryFirstBottom+","+secondaryLastBottom);
			
			//set bottom
			uva.setY(vBase);
			uvb.setY(vBase);
			uvc.setY(vBase+tickUv);
			uvd.setY(vBase+tickUv);
			
			geometry.getFaces().push( THREE.Face3( primaryFirstBottom, primaryLastBottom, secondaryLastBottom ) );
			pushUv(uvs, uva, uvb, uvd );
			
			geometry.getFaces().push( THREE.Face3( secondaryLastBottom , secondaryFirstBottom, primaryFirstBottom) );
			pushUv(uvs, uvb.clone(), uvc, uvd.clone());	
		}
		
		/*
		if(thick!=0){
			
			for ( double j = slices; j <= slices; j ++ ) {
				int i=0;
				int	a = (int)(i * sliceCount + j);
				int	b = (int)(i * sliceCount + j +1);
				int	c = (int)(i * sliceCount + j+1)+frontGeometrySize;
				int	d = (int)(i * sliceCount + j)+frontGeometrySize;
				
				//TODO modify uv
				Vector2	uva = getUv((int)j,(int)i);
				Vector2	uvb = getUv((int)j+1,(int)i);
				Vector2	uvc = getUv((int)j+1,(int)i);
				Vector2	uvd = getUv((int)j,(int)i);
				
				uva.setY(vBase+tickUv);
				uvb.setY(vBase+tickUv);
				uvc.setY(1);
				uvd.setY(1);
				
				
				geometry.getFaces().push( THREE.Face3( a, b, d ) );
				pushUv(uvs, uva, uvb, uvd );

				geometry.getFaces().push(THREE.Face3( b, c, d ) );
				pushUv(uvs, uvb.clone(), uvc, uvd.clone());
				
			}
			
			//bottom
			
			for ( double j = slices; j <= slices; j ++ ) {
				int i=stacks;
				int	a = (int)(i * sliceCount + j);
				int	b = (int)(i * sliceCount + j +1);
				int	c = (int)(i * sliceCount + j+1)+frontGeometrySize;
				int	d = (int)(i * sliceCount + j)+frontGeometrySize;
				
				Vector2	uva = getUv((int)j,(int)i);
				Vector2	uvb = getUv((int)j+1,(int)i);
				Vector2	uvc = getUv((int)j+1,(int)i);
				Vector2	uvd = getUv((int)j,(int)i);
				
				uva.setY(vBase);
				uvb.setY(vBase);
				uvc.setY(vBase+tickUv);
				uvd.setY(vBase+tickUv);
				
				geometry.getFaces().push( THREE.Face3( d, b, a ) );
				pushUv(uvs, uvd, uvb, uva );

				geometry.getFaces().push(THREE.Face3( d, c, b ) );
				pushUv(uvs, uvd.clone(), uvc, uvb.clone());
				
			}
			}
			*/
		
		}else{//create side
			if(thick!=0){
			for ( double i = 0; i < stacks; i ++ ) {
				int j=0;
				int	a = (int)(i * sliceCount + j);
				int	b = (int)(( i + 1 ) * sliceCount + j);
				int	c = (int)(( i + 1 ) * sliceCount + j)+frontGeometrySize;
				int	d = (int)(i * sliceCount + j)+frontGeometrySize;
				
				//TODO modify uv
				Vector2	uva = getUv(0,(int)i);
				Vector2	uvb = getUv(0,(int)i);
				Vector2	uvc = getUv(0,(int)i+1);
				Vector2	uvd = getUv(0,(int)i+1);
				uva.setX(1);
				uvb.setX(1.0-tickUv);
				uvc.setX(1.0-tickUv);
				uvd.setX(1);
				
				geometry.getFaces().push( THREE.Face3( d, b, a ) );
				pushUv(uvs, uvd, uvb, uva );

				geometry.getFaces().push(THREE.Face3( d, c, b ) );
				pushUv(uvs, uvd.clone(), uvc, uvb.clone());	
			}
			
			for ( double i = 0; i < stacks; i ++ ) {
				int j=slices;
				int	a = (int)(i * sliceCount + j);
				int	b = (int)(( i + 1 ) * sliceCount + j);
				int	c = (int)(( i + 1 ) * sliceCount + j)+frontGeometrySize;
				int	d = (int)(i * sliceCount + j)+frontGeometrySize;
				
				Vector2	uva = getUv(0,(int)i);
				Vector2	uvb = getUv(0,(int)i);
				Vector2	uvc = getUv(0,(int)i+1);
				Vector2	uvd = getUv(0,(int)i+1);
				uva.setX(1-tickUv);
				uvb.setX(1.0-tickUv*2);
				uvc.setX(1.0-tickUv*2);
				uvd.setX(1-tickUv);
				
				geometry.getFaces().push( THREE.Face3( a, b, d ) );
				pushUv(uvs, uva, uvb, uvd );

				geometry.getFaces().push(THREE.Face3( b, c, d ) );
				pushUv(uvs, uvb.clone(), uvc, uvd.clone());	
			}
			}
		}
		
		
		geometry.computeFaceNormals();
		geometry.computeVertexNormals();
		
		
		return geometry;
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	private void pushUv(JsArray<JsArray<Vector2>> target,Vector2 uv1,Vector2 uv2,Vector2 uv3){
		target.push(JavaScriptUtils.createJSArray(uv1,uv2,uv3));
	}
}
