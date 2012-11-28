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
package com.akjava.gwt.three.client;

import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Color;
import com.akjava.gwt.three.client.core.Face;
import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.core.Projector;
import com.akjava.gwt.three.client.core.Quaternion;
import com.akjava.gwt.three.client.core.Ray;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.core.Vector4;
import com.akjava.gwt.three.client.core.Vertex;
import com.akjava.gwt.three.client.extras.animation.Animation;
import com.akjava.gwt.three.client.extras.geometries.CubeGeometry;
import com.akjava.gwt.three.client.extras.loaders.ColladaLoader;
import com.akjava.gwt.three.client.extras.loaders.JSONLoader;
import com.akjava.gwt.three.client.extras.modifiers.SubdivisionModifier;
import com.akjava.gwt.three.client.lights.AmbientLight;
import com.akjava.gwt.three.client.lights.DirectionalLight;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.materials.LineBasicMaterialBuilder;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.materials.MeshBasicMaterialBuilder;
import com.akjava.gwt.three.client.materials.MeshLambertMaterialBuilder;
import com.akjava.gwt.three.client.materials.ParticleBasicMaterialBuilder;
import com.akjava.gwt.three.client.materials.ShaderMaterialBuilder;
import com.akjava.gwt.three.client.objects.Line;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.objects.MorphAnimMesh;
import com.akjava.gwt.three.client.objects.Particle;
import com.akjava.gwt.three.client.objects.ParticleSystem;
import com.akjava.gwt.three.client.objects.SkinnedMesh;
import com.akjava.gwt.three.client.renderers.GWTRenderObject;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.akjava.gwt.three.client.textures.Texture;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;





public class THREE {

	public static  native final Ray Ray(Vector3 camera,Vector3 vector)/*-{
	return  new $wnd.THREE.Ray(camera,vector);
	}-*/;
	
	public static  native final Texture Texture(ImageElement image)/*-{
	return  new $wnd.THREE.Texture(image);
	}-*/;
	
	public static  native final Texture Texture(CanvasElement canvas)/*-{
	return  new $wnd.THREE.Texture(canvas);
	}-*/;
	
	public static  native final JSONLoader JSONLoader()/*-{
	return  new $wnd.THREE.JSONLoader();
	}-*/;
	public static  native final ColladaLoader ColladaLoader()/*-{
	return  new $wnd.THREE.ColladaLoader();
	}-*/;
	

	public static  native final SubdivisionModifier SubdivisionModifier(int subdiv)/*-{
	return  new $wnd.THREE.SubdivisionModifier(subdiv);
	}-*/;
	
	public static  native final SubdivisionModifier SubdivisionModifier()/*-{
	return  new $wnd.THREE.SubdivisionModifier();
	}-*/;
	
	public static native final Camera PerspectiveCamera(int fieldOfView,double ratio,double near,double far)/*-{
	return new $wnd.THREE.PerspectiveCamera( fieldOfView, ratio, near, far ); 
	}-*/;
	
	public static native final Camera OrthographicCamera(double left,double right,double top,double bottom,double near,double far)/*-{
	return new $wnd.THREE.OrthographicCamera( left, right,top,bottom, near, far ); 
	}-*/;
	
	
	public static native final Animation Animation(SkinnedMesh root,String name)/*-{
	return new $wnd.THREE.Animation(root,name);
	}-*/;
	
	public static native final Vector4 Vector4()/*-{
	return new $wnd.THREE.Vector4();
	}-*/;
	public static native final Vector4 Vector4(double x,double y,double z,double w)/*-{
	return new $wnd.THREE.Vector4(x,y,z,w);
	}-*/;

	
	public static native final Matrix4 Matrix4()/*-{
	return new $wnd.THREE.Matrix4();
	}-*/;
	
	public static native final Quaternion Quaternion()/*-{
	return new $wnd.THREE.Quaternion();
	}-*/;
	public static native final Quaternion Quaternion(double x,double y,double z,double w)/*-{
	return new $wnd.THREE.Quaternion(x,y,z,w);
	}-*/;
	
	public static native final Scene Scene()/*-{
	return new $wnd.THREE.Scene();
	}-*/;
	
	public static native final AmbientLight AmbientLight(int color)/*-{
	return new $wnd.THREE.AmbientLight(color);
	}-*/;
	public static final  AmbientLight AmbientLight(double color){
	return AmbientLight((int)color);
	}
	
	
	
	public static  final CubeGeometry CubeGeometry(double x,double y,double z,int xpart,int ypart,int zpart,Material[] material ){
		JsArray<Material> arrays=(JsArray<Material>) JsArray.createArray();
		for(Material m:material){
			arrays.push(m);
		}
		
		return Cube(x,y,z,xpart,ypart,zpart,arrays);
	}
	
	public static  final CubeGeometry Cube(double x,double y,double z,int xpart,int ypart,int zpart,Material[] material ){
		JsArray<Material> arrays=(JsArray<Material>) JsArray.createArray();
		for(Material m:material){
			arrays.push(m);
		}
		
		return Cube(x,y,z,xpart,ypart,zpart,arrays);
	
	}
	public static native final CubeGeometry CubeGeometry(double x,double y,double z,int xpart,int ypart,int zpart,JsArray<Material> materials)/*-{
	
	
    var ms= $wnd.eval("new Array()");
    for (var i = 0; i < materials.length; i++) {
		ms.push(materials[i]);
        }
        
	return new $wnd.THREE.CubeGeometry( x, y, z ,xpart,ypart,zpart,ms);
	}-*/;
	
	
public static native final CubeGeometry CubeGeometry(double x,double y,double z,int xpart,int ypart,int zpart)/*-{
	return new $wnd.THREE.CubeGeometry( x, y, z ,xpart,ypart,zpart);
	}-*/;
	
	//I'm happy to fix array problem.
	public static native final CubeGeometry Cube(double x,double y,double z,int xpart,int ypart,int zpart,JsArray<Material> materials)/*-{
	
	material = new $wnd.THREE.MeshBasicMaterial({color: 0xff0000, wireframe: false});
    var ms=new $wnd.Array();
    for (var i = 0; i < materials.length; i++) {
		ms.push(materials[i]);
        }
        
	return new $wnd.THREE.CubeGeometry( x, y, z ,xpart,ypart,zpart,ms);
	}-*/;
	
	
	
	public static native final Geometry Geometry()/*-{
	return new $wnd.THREE.Geometry();
	}-*/;
	
	public static native final Object3D Object3D()/*-{
	return new $wnd.THREE.Object3D();
	}-*/;
	
	public static native final CubeGeometry CubeGeometry(double x,double y,double z)/*-{
	return new $wnd.THREE.CubeGeometry( x, y, z );
	}-*/;
	
	public static native final Geometry PlaneGeometry(double x,double y)/*-{
	return new $wnd.THREE.PlaneGeometry( x, y );
	}-*/;
	public static native final Geometry PlaneGeometry(double x,double y,int sx,int sy)/*-{
	return new $wnd.THREE.PlaneGeometry( x, y ,sx,sy);
	}-*/;
	
	public static native final Geometry SphereGeometry(double radius ,int segments,int rings)/*-{
	return new $wnd.THREE.SphereGeometry( radius, segments, rings );
	}-*/;
	
	public static native final Geometry CylinderGeometry(double topRad,double botRad,double height,int radSegs)/*-{
	return new $wnd.THREE.CylinderGeometry( topRad,botRad,height,radSegs );
	}-*/;
	

	
	public static  final MeshBasicMaterialBuilder MeshBasicMaterial(){
		return MeshBasicMaterialBuilder.create();
	}
	public static  final MeshLambertMaterialBuilder MeshLambertMaterial(){
		return MeshLambertMaterialBuilder.create();
	}
	public static  final ParticleBasicMaterialBuilder ParticleBasicMaterial(){
		return ParticleBasicMaterialBuilder.create();
	}
	
	
	
	
	public static native final Material MeshFaceMaterial()/*-{
	return new $wnd.THREE.MeshFaceMaterial();
	}-*/;
	
	
	public static  final LineBasicMaterialBuilder LineBasicMaterial(){
		return LineBasicMaterialBuilder.create();
	}
	
	

	
	
	
	public static  final ShaderMaterialBuilder ShaderMaterial(){
		return ShaderMaterialBuilder.create();
	}
	
	
	
	
	/**
	 * @deprecated r49
	 * @param vector3f
	 * @return
	 */
	public static native final Vertex Vertex(Vector3 vector3f )/*-{
	return new $wnd.THREE.Vertex( vector3f);
	}-*/;
	
	public static native final Vector3 Vector3(double x,double y,double z)/*-{
	return new $wnd.THREE.Vector3( x,y,z);
	}-*/;
	public static native final Vector3 Vector3()/*-{
	return new $wnd.THREE.Vector3(0,0,0);
	}-*/;
	
	
	
	public static native final Particle Particle(Material material )/*-{
	return new $wnd.THREE.Particle(material );
	}-*/;
	public static native final ParticleSystem ParticleSystem(Geometry geometry,Material material )/*-{
	return new $wnd.THREE.ParticleSystem( geometry, material );
	}-*/;
	
	public static native final Mesh Mesh(Geometry geometry,Material material )/*-{
	return new $wnd.THREE.Mesh( geometry, material );
	}-*/;
	public static native final SkinnedMesh SkinnedMesh(Geometry geometry,Material material )/*-{
	return new $wnd.THREE.SkinnedMesh( geometry, material );
	}-*/;
	public static native final Line Line(Geometry geometry,Material material )/*-{
	return new $wnd.THREE.Line( geometry, material );
	}-*/;
	
	public static native final Color Color(int hex)/*-{
	return new $wnd.THREE.Color(hex);
	}-*/;
	
	public static native final WebGLRenderer CSS3DRenderer()/*-{
	return new $wnd.THREE.CSS3DRenderer();
	}-*/;
	
	public static native final WebGLRenderer WebGLRenderer()/*-{
	return new $wnd.THREE.WebGLRenderer();
	}-*/;
	
	public static native final WebGLRenderer CanvasRenderer()/*-{
	return new $wnd.THREE.CanvasRenderer();
	}-*/;
	
	public static native final WebGLRenderer WebGLRenderer(GWTRenderObject object)/*-{
	return new $wnd.THREE.WebGLRenderer(object);
	}-*/;
	
	public static native final Light PointLight(int color)/*-{
	return new $wnd.THREE.PointLight(color);
	}-*/;
	public static native final Light SpotLight(int color)/*-{
	return new $wnd.THREE.SpotLight(color);
	}-*/;
	public static native final DirectionalLight DirectionalLight(int color,int intensity)/*-{
	return new $wnd.THREE.DirectionalLight(color,intensity);
	}-*/;
	public static native final DirectionalLight DirectionalLight(int color)/*-{
	return new $wnd.THREE.DirectionalLight(color);
	}-*/;
	public static  final DirectionalLight DirectionalLight(double color,int intensity){
		return DirectionalLight(color,intensity);
	}
	public static  final DirectionalLight DirectionalLight(double color){
		return DirectionalLight((int)color);
	}
	public static native final Projector Projector()/*-{
	return new $wnd.THREE.Projector();
	}-*/;
	
	

	public static final int FrontSide = 0;
	public static final int BackSide = 1;
	public static final int DoubleSide = 2;
	
	public static final int NoShading = 0;
	public static final int FlatShading = 1;
	public static final int SmoothShading = 2;

	public static final int NoColors = 0;
	public static final int FaceColors = 1;
	public static final int VertexColors = 2;
	
	public static final int UVMapping =0;
	public static final int LatitudeReflectionMapping =1;
	public static final int CubeReflectionMapping =2;
	public static final int SphericalReflectionMapping =3;
	
	/*
	THREE.NoBlending = 0;
	THREE.NormalBlending = 1;
	THREE.AdditiveBlending = 2;
	THREE.SubtractiveBlending = 3;
	THREE.MultiplyBlending = 4;
	THREE.CustomBlending = 5;
	*/
	
	public static final class Blending{
		
		
		
		
		public static native final int NoBlending()/*-{
		return $wnd.THREE.NoBlending;
		}-*/;
	}
	
	

	public static final class Colors{
		public static native final int NoColors()/*-{
		return $wnd.THREE.NoColors;
		}-*/;
		public static native final int FaceColors()/*-{
		return $wnd.THREE.FaceColors;
		}-*/;
		public static native final int VertexColors()/*-{
		return  $wnd.THREE.VertexColors;
		}-*/;
	}
	
	public static final int NoBlending = 0;
	public static final int NormalBlending = 1;
	public static final int AdditiveBlending = 2;
	public static final int SubtractiveBlending = 3;
	public static final int MultiplyBlending = 4;
	public static final int CustomBlending=5;
	/**
	 * @deprecated anymore
	 */
	public static final int AdditiveAlphaBlending = 0;

	public static native final MorphAnimMesh MorphAnimMesh(Geometry geometry,
			Material material) /*-{
	return new $wnd.THREE.MorphAnimMesh(geometry,material);
	}-*/;

	public static native final Face Face3(double a, double b, double c) /*-{
	return new $wnd.THREE.Face3(a,b,c);
	}-*/;
}
