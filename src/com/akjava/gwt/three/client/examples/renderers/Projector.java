/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2011 aki@akjava.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r45
 https://github.com/mrdoob/three.js
 The MIT License

Copyright (c) 2010-2011 three.js Authors. All rights reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
  
 */
package com.akjava.gwt.three.client.examples.renderers;

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.three.client.gwt.core.Intersect;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.core.Raycaster;
import com.akjava.gwt.three.client.js.math.Ray;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * @deprecated
 * on three.js r69 move to example
 * so i dropped support r69's projector  so far,because too much things todo.
 * maybe this tips help you 
 * http://stackoverflow.com/questions/27409074/three-js-converting-3d-position-to-2d-screen-position-r69
 * @author aki
 *
 */
public class Projector extends JavaScriptObject{
protected Projector(){}

/**
 * temporaly fixed ,now just pick from scene.child() array,not recursive
 * @deprecated no more scene support
 */
public final native JsArray<Intersect> gwtPickIntersects(int mx,int my,int sw,int sh,Camera camera,Scene scene)/*-{	
	var vector = new $wnd.THREE.Vector3( ( mx / sw ) * 2 - 1, - ( my / sh ) * 2 + 1, 0.5 );
				vector.unproject(camera );

				var ray = new $wnd.THREE.Raycaster( camera.position, vector.sub( camera.position ).normalize() );
				return  ray.intersectObjects( scene.children );

}-*/;

/**
 * @deprecated no more scene support r49
 * emporaly fixed ,now  just pick from scene.child() array,not recursive
 */
public final native JsArray<Intersect> gwtPickIntersects(int mx,int my,int sw,int sh,Camera camera,Vector3 position,Scene scene)/*-{

var vector = new $wnd.THREE.Vector3( ( mx / sw ) * 2 - 1, - ( my / sh ) * 2 + 1, 0.5 );
			vector.unproject(camera );

			var ray = new $wnd.THREE.Raycaster(position, vector.sub(position ).normalize() );
			
			return  ray.intersectScene( scene.children );

}-*/;

public final native Ray gwtCreateRay(int mx,int my,int sw,int sh,Camera camera)/*-{

var vector = new $wnd.THREE.Vector3( ( mx / sw ) * 2 - 1, - ( my / sh ) * 2 + 1, 0.5 );
			vector.unproject(camera );

			var ray = new $wnd.THREE.Raycaster( camera.position, vector.sub( camera.position ).normalize() );

			return  ray;

}-*/;
public final JsArray<Intersect> gwtPickIntersectsByList(int mx,int my,int sw,int sh,Camera camera,Iterable<Object3D> objects){
	@SuppressWarnings("unchecked")
	JsArray<Object3D> array=((JsArray<Object3D>) JavaScriptUtils.createJSArray().cast());
	for(Object3D obj:objects){
		array.push(obj);
	}
	return gwtPickIntersects(mx, my, sw, sh, camera, array);
}
public final native JsArray<Intersect> gwtPickIntersects(int mx,int my,int sw,int sh,Camera camera,JsArray<Object3D> objects)/*-{

var vector = new $wnd.THREE.Vector3( ( mx / sw ) * 2 - 1, - ( my / sh ) * 2 + 1, 0.5 );
			vector.unproject(camera);

			var ray = new $wnd.THREE.Raycaster( camera.position, vector.sub( camera.position ).normalize() );

			return  ray.intersectObjects( objects );

}-*/;

public final native JsArray<Intersect> gwtPickIntersectsByObject(int mx,int my,int sw,int sh,Camera camera,Object3D object)/*-{

var vector = new $wnd.THREE.Vector3( ( mx / sw ) * 2 - 1, - ( my / sh ) * 2 + 1, 0.5 );
			vector.unproject(camera );

			var ray = new $wnd.THREE.Raycaster( camera.position, vector.sub( camera.position ).normalize() );

			return  ray.intersectObject( object );

}-*/;

public final native Vector3 projectVector(Vector3 vector,Camera camera)/*-{

return this.projectVector(vector,camera);

}-*/;

public final native Vector3 unprojectVector(Vector3 vector,Camera camera)/*-{
return this.unprojectVector(vector,camera);

}-*/;

public final native Raycaster pickingRay(Vector3 vector,Camera camera)/*-{
return this.pickingRay(vector,camera);
}-*/;

/**
 * FUTURE
 * @return
 */
public final native JavaScriptObject projectScene(Scene scene,Camera camera,Object sortObjects,Object sortElements)/*-{
return this.projectScene(scene,camera,sortObjects,sortElements);
}-*/;


public static native final Projector createProjector()/*-{
return new $wnd.THREE.Projector();
}-*/;

}
