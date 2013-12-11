package com.akjava.gwt.three.client.gwt;

/**
 * 
 * based on three.js webgl - draggable cubes
 */
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Intersect;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.core.Projector;
import com.akjava.gwt.three.client.core.Ray;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.math.Matrix4;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.JsArray;


public class GWTDragObjectControler {
private Projector projector;
private Mesh mouseCatchPlane;
public Mesh getMouseCatchPlane() {
	return mouseCatchPlane;
}
public GWTDragObjectControler(Scene scene,Projector projector){
	this.projector=projector;
	//maybe should black&transparent like js-sample
	mouseCatchPlane=THREE.Mesh(THREE.PlaneGeometry(2000, 2000, 10, 10), THREE.MeshBasicMaterial().color(0x00ffff).wireFrame().build());
	mouseCatchPlane.setVisible(false);
	scene.add(mouseCatchPlane);
}

private Object3D selectedDraggablekObject;
private Object3D intersectedDraggablekObject;

public void copyIntersectedPosition(){
	//intersectedDraggablekObject.updateMatrixWorld(true);
	mouseCatchPlane.getPosition().copy( GWTThreeUtils.toPositionVec(intersectedDraggablekObject.getMatrixWorld()) );
	
}
public Object3D getIntersectedDraggablekObject() {
	return intersectedDraggablekObject;
}



public void setIntersectedDraggablekObject(Object3D intersectedDraggablekObject) {
	this.intersectedDraggablekObject = intersectedDraggablekObject;
	copyIntersectedPosition();
}



public Object3D getSelectedDraggablekObject() {
	return selectedDraggablekObject;
}
private Vector3 draggableOffset=THREE.Vector3();

public Vector3 getDraggableOffset() {
	return draggableOffset;
}



//target must be rayed
/*
 *** sometime it error happend,check
 * double mouseMoved=(Math.abs(diffX)+Math.abs(diffY));
 *double length=newPos.clone().subSelf(getCurrentIkData().getTargetPos()).length(); 
 *  if(length<mouseMoved*5){
 */
public Vector3 moveSelectionPosition(int mouseX,int mouseY,int screenWidth, int screenHeight,Camera camera){
	if(isSelected()){
		try{
		Ray ray=projector.gwtCreateRay(mouseX, mouseY, screenWidth, screenHeight, camera);
		JsArray<Intersect> intersects = ray.intersectObject( mouseCatchPlane );
		
		
		Vector3 newPos=intersects.get(0).getPoint().subSelf( draggableOffset );
		log="newPos-raw:"+ThreeLog.get(newPos);
		Vector3 parentPos=THREE.Vector3();
		if(selectedDraggablekObject.getParent()!=null){
			//selectedDraggablekObject.getParent().updateMatrixWorld(true); //if call it bone moving  will be broken.i have no idea.
			parentPos=GWTThreeUtils.toPositionVec(selectedDraggablekObject.getParent().getMatrixWorld());
			//LogUtils.log("parent:"+ThreeLog.get(parentPos));
			log+="parentPos:"+ThreeLog.get(parentPos);
		}
		newPos.subSelf(parentPos);
		
		
		
		
		Matrix4 rotM=THREE.Matrix4();
		Vector3 rotation=GWTThreeUtils.rotationToVector3((selectedDraggablekObject.getParent().getMatrixWorld()));
		//rotM.getInverse(selectedDraggablekObject.getMatrixRotationWorld());
		
		log+="parentRot:"+ThreeLog.get(GWTThreeUtils.radiantToDegree(rotation));
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
		}catch(Exception e){
			LogUtils.log("moveSelectionPosition:"+e.getMessage());
			return null;
		}
	}else{
		return null;
	}
}
private String log;

	

public String getLog() {
	return log;
}
public void selectObject(Object3D target,int mouseX,int mouseY,int screenWidth, int screenHeight,Camera camera){
	try{
	selectedDraggablekObject=target;
	Ray ray=projector.gwtCreateRay(mouseX, mouseY, screenWidth, screenHeight, camera);
	
	
	
	//ig dry every thing dont work
	//Vector3 rotation=GWTThreeUtils.rotationToVector3((selectedDraggablekObject.getMatrixWorld()));
	//mouseClickCatcher.getRotation().copy(rotation);
	
	
	selectedDraggablekObject.updateMatrixWorld(true);
	mouseCatchPlane.getPosition().copy( GWTThreeUtils.toPositionVec(selectedDraggablekObject.getMatrixWorld()) );
	mouseCatchPlane.updateMatrixWorld(true);//very important
	
	JsArray<Intersect> pintersects=ray.intersectObject(mouseCatchPlane);
	draggableOffset.copy(pintersects.get(0).getPoint()).subSelf(mouseCatchPlane.getPosition());
	/*
	 * make a problem?
	if(draggableOffset.getX()<0.0001){
		draggableOffset.setX(0);
	}
	if(draggableOffset.getY()<0.0001){
		draggableOffset.setY(0);
	}
	if(draggableOffset.getZ()<0.0001){
		draggableOffset.setZ(0);
	}
	*/
	
	}catch(Exception e){
		LogUtils.log("selectObject:"+e.getMessage());
		selectedDraggablekObject=null;
	}
	//LogUtils.log("offset:"+ThreeLog.get(draggableOffset));
}

public void unselectObject(){
	if(selectedDraggablekObject!=null){
	selectedDraggablekObject=null;
	}
}
public boolean isSelected(){
	return selectedDraggablekObject!=null;
}


}
