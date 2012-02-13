package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Intersect;
import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.core.Projector;
import com.akjava.gwt.three.client.core.Ray;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.JsArray;

public class DragObjectControler {
private Projector projector;
private Mesh mouseClickCatcher;
public DragObjectControler(Scene scene,Projector projector){
	this.projector=projector;
	mouseClickCatcher=THREE.Mesh(THREE.PlaneGeometry(200, 200, 10, 10), THREE.MeshBasicMaterial().color(0xffff00).wireFrame().build());
	mouseClickCatcher.setVisible(false);
	scene.add(mouseClickCatcher);
}
private Object3D selectedDraggablekObject;
private Vector3 draggableOffset=THREE.Vector3();

//target must be rayed
/*
 *** sometime it error happend,check
 * double mouseMoved=(Math.abs(diffX)+Math.abs(diffY));
 *double length=newPos.clone().subSelf(getCurrentIkData().getTargetPos()).length(); 
 *  if(length<mouseMoved*5){
 */
public Vector3 moveSelectionPosition(int mouseX,int mouseY,int screenWidth, int screenHeight,Camera camera){
	if(isSelected()){
		
		Ray ray=projector.gwtCreateRay(mouseX, mouseY, screenWidth, screenHeight, camera);
		JsArray<Intersect> intersects = ray.intersectObject( mouseClickCatcher );
		
		
		Vector3 newPos=intersects.get(0).getPoint().subSelf( draggableOffset );
		Vector3 parentPos=THREE.Vector3();
		if(selectedDraggablekObject.getParent()!=null){
			parentPos=GWTThreeUtils.toPositionVec(selectedDraggablekObject.getParent().getMatrixWorld());
			//LogUtils.log("parent:"+ThreeLog.get(parentPos));
		}
		newPos.subSelf(parentPos);
		
		
		
		
		Matrix4 rotM=THREE.Matrix4();
		Vector3 rotation=GWTThreeUtils.rotationToVector3((selectedDraggablekObject.getParent().getMatrixWorld()));
		//rotM.getInverse(selectedDraggablekObject.getMatrixRotationWorld());
		rotM.getInverse(GWTThreeUtils.rotationToMatrix4(rotation));
		
		rotM.multiplyVector3(newPos);
		
		//Vector3 parentRotation=THREE.Vector3();
		
		/*
		Object3D obj=selectedDraggablekObject;
		while(obj.getParent()!=null){
			parentPos.addSelf(obj.getParent().getPosition());
			parentRotation.addSelf(obj.getParent().getRotation());
			obj=obj.getParent();
		}
		
		LogUtils.log("parent-rot:"+ThreeLog.get(GWTThreeUtils.radiantToDegree(parentRotation)));
		*/
		//Matrix4 mx=GWTThreeUtils.rotationToMatrix4(parentRotation);
		//mx.multiplyVector3(parentPos);
		
		
		/*
		log("m:"+ThreeLog.get(selectedDraggablekObject.getPosition()));
		log("m:"+ThreeLog.get(GWTThreeUtils.toPositionVec(selectedDraggablekObject.getMatrix())));
		log("mw:"+ThreeLog.get(GWTThreeUtils.toPositionVec(selectedDraggablekObject.getMatrixWorld())));
		*/
		//must be same as selectedDraggablekObject
		return newPos;
	}else{
		return null;
	}
}

	

public void selectObject(Object3D target,int mouseX,int mouseY,int screenWidth, int screenHeight,Camera camera){
	selectedDraggablekObject=target;
	Ray ray=projector.gwtCreateRay(mouseX, mouseY, screenWidth, screenHeight, camera);
	mouseClickCatcher.getPosition().copy( GWTThreeUtils.toPositionVec(target.getMatrixWorld()) );
	
	
	
	//ig dry every thing dont work
	//Vector3 rotation=GWTThreeUtils.rotationToVector3((selectedDraggablekObject.getMatrixWorld()));
	//mouseClickCatcher.getRotation().copy(rotation);
	
	
	
	mouseClickCatcher.updateMatrixWorld(true);//very important
	
	JsArray<Intersect> pintersects=ray.intersectObject(mouseClickCatcher);
	draggableOffset.copy(pintersects.get(0).getPoint()).subSelf(mouseClickCatcher.getPosition());
	//LogUtils.log("offset:"+ThreeLog.get(draggableOffset));
}

public void unselectObject(){
	//follow moved
	if(selectedDraggablekObject!=null){
	mouseClickCatcher.getPosition().copy( GWTThreeUtils.toPositionVec(selectedDraggablekObject.getMatrixWorld()) );
	selectedDraggablekObject=null;
	}
}
public boolean isSelected(){
	return selectedDraggablekObject!=null;
}


}
