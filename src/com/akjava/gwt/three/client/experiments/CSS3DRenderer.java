package com.akjava.gwt.three.client.experiments;

import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.Element;

public class CSS3DRenderer extends WebGLRenderer{
protected CSS3DRenderer(){}

public  native final Element getCameraElement()/*-{
return this.cameraElement;
}-*/;

public  native final void removeCameraElement(Camera camera)/*-{
return this.cameraElement.removeChild(camera);
}-*/;


public final void gwtClear(){
	NodeList<Node> nodes=getCameraElement().getChildNodes();
	for(int i=0;i<nodes.getLength();i++){
		Node node=nodes.getItem(i);
		getCameraElement().removeChild(node);
	}
}

public  native final void clearCameraElement()/*-{
var nodes=this.cameraElement.childNodes();
for(var i=0;i<nodes.length();i++){
	var node=nodes.item(i);
	this.cameraElement.removeChild(node);
	}
}-*/;

}
