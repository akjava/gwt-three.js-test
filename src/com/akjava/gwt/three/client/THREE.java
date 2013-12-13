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

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.three.client.cameras.OrthographicCamera;
import com.akjava.gwt.three.client.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.core.BufferGeometry;
import com.akjava.gwt.three.client.core.Clock;
import com.akjava.gwt.three.client.core.EventDispatcher;
import com.akjava.gwt.three.client.core.Face3;
import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.core.Projector;
import com.akjava.gwt.three.client.core.Raycaster;
import com.akjava.gwt.three.client.experiments.CSS3DRenderer;
import com.akjava.gwt.three.client.extras.animation.Animation;
import com.akjava.gwt.three.client.extras.animation.AnimationMorphTarget;
import com.akjava.gwt.three.client.extras.animation.KeyFrameAnimation;
import com.akjava.gwt.three.client.extras.cameras.CombinedCamera;
import com.akjava.gwt.three.client.extras.cameras.CubeCamera;
import com.akjava.gwt.three.client.extras.core.Gyroscope;
import com.akjava.gwt.three.client.extras.curves.ArcCurve;
import com.akjava.gwt.three.client.extras.curves.ClosedSplineCurve3;
import com.akjava.gwt.three.client.extras.curves.CubicBezierCurve;
import com.akjava.gwt.three.client.extras.curves.CubicBezierCurve3;
import com.akjava.gwt.three.client.extras.curves.EllipseCurve;
import com.akjava.gwt.three.client.extras.curves.LineCurve;
import com.akjava.gwt.three.client.extras.curves.LineCurve3;
import com.akjava.gwt.three.client.extras.curves.QuadraticBezierCurve;
import com.akjava.gwt.three.client.extras.curves.QuadraticBezierCurve3;
import com.akjava.gwt.three.client.extras.curves.SplineCurve;
import com.akjava.gwt.three.client.extras.curves.SplineCurve3;
import com.akjava.gwt.three.client.extras.geometries.CubeGeometry;
import com.akjava.gwt.three.client.extras.loaders.ColladaLoader;
import com.akjava.gwt.three.client.extras.modifiers.SubdivisionModifier;
import com.akjava.gwt.three.client.gwt.math.XY;
import com.akjava.gwt.three.client.gwt.math.XYZ;
import com.akjava.gwt.three.client.gwt.math.XYZObject;
import com.akjava.gwt.three.client.lights.AmbientLight;
import com.akjava.gwt.three.client.lights.AreaLight;
import com.akjava.gwt.three.client.lights.DirectionalLight;
import com.akjava.gwt.three.client.lights.HemisphereLight;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.lights.PointLight;
import com.akjava.gwt.three.client.lights.SpotLight;
import com.akjava.gwt.three.client.loaders.BufferGeometryLoader;
import com.akjava.gwt.three.client.loaders.GeometryLoader;
import com.akjava.gwt.three.client.loaders.ImageLoader;
import com.akjava.gwt.three.client.loaders.JSONLoader;
import com.akjava.gwt.three.client.loaders.LoadingManager;
import com.akjava.gwt.three.client.loaders.LoadingManager.LoadingManagerHandler;
import com.akjava.gwt.three.client.loaders.MaterialLoader;
import com.akjava.gwt.three.client.loaders.ObjectLoader;
import com.akjava.gwt.three.client.loaders.SceneLoader;
import com.akjava.gwt.three.client.loaders.TextureLoader;
import com.akjava.gwt.three.client.loaders.XHRLoader;
import com.akjava.gwt.three.client.materials.LineBasicMaterial;
import com.akjava.gwt.three.client.materials.LineBasicMaterialBuilder;
import com.akjava.gwt.three.client.materials.LineDashedMaterial;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.materials.MeshBasicMaterial;
import com.akjava.gwt.three.client.materials.MeshBasicMaterialBuilder;
import com.akjava.gwt.three.client.materials.MeshDepthMaterial;
import com.akjava.gwt.three.client.materials.MeshFaceMaterial;
import com.akjava.gwt.three.client.materials.MeshLambertMaterial;
import com.akjava.gwt.three.client.materials.MeshLambertMaterialBuilder;
import com.akjava.gwt.three.client.materials.MeshNormalMaterial;
import com.akjava.gwt.three.client.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.materials.ParticleBasicMaterialBuilder;
import com.akjava.gwt.three.client.materials.ParticleSystemMaterial;
import com.akjava.gwt.three.client.materials.ShaderMaterial;
import com.akjava.gwt.three.client.materials.ShaderMaterialBuilder;
import com.akjava.gwt.three.client.materials.SpriteCanvasMaterial;
import com.akjava.gwt.three.client.materials.SpriteMaterial;
import com.akjava.gwt.three.client.math.Box2;
import com.akjava.gwt.three.client.math.Box3;
import com.akjava.gwt.three.client.math.Color;
import com.akjava.gwt.three.client.math.Euler;
import com.akjava.gwt.three.client.math.Line3;
import com.akjava.gwt.three.client.math.Matrix3;
import com.akjava.gwt.three.client.math.Matrix4;
import com.akjava.gwt.three.client.math.Plane;
import com.akjava.gwt.three.client.math.Quaternion;
import com.akjava.gwt.three.client.math.Ray;
import com.akjava.gwt.three.client.math.Sphere;
import com.akjava.gwt.three.client.math.Spline;
import com.akjava.gwt.three.client.math.Triangle;
import com.akjava.gwt.three.client.math.Vector2;
import com.akjava.gwt.three.client.math.Vector3;
import com.akjava.gwt.three.client.math.Vector4;
import com.akjava.gwt.three.client.math.Vertex;
import com.akjava.gwt.three.client.objects.Bone;
import com.akjava.gwt.three.client.objects.LOD;
import com.akjava.gwt.three.client.objects.Line;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.objects.MorphAnimMesh;
import com.akjava.gwt.three.client.objects.Particle;
import com.akjava.gwt.three.client.objects.ParticleSystem;
import com.akjava.gwt.three.client.objects.SkinnedMesh;
import com.akjava.gwt.three.client.renderers.GWTRenderObject;
import com.akjava.gwt.three.client.renderers.WebGLRenderTarget;
import com.akjava.gwt.three.client.renderers.WebGLRenderTargetCube;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Fog;
import com.akjava.gwt.three.client.scenes.Scene;
import com.akjava.gwt.three.client.textures.CompressedTexture;
import com.akjava.gwt.three.client.textures.DataTexture;
import com.akjava.gwt.three.client.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;





public class THREE {
	public final native SplineCurve3 SplineCurve3(JsArray<XYZ> points)/*-{
	return $wnd.THREE.SplineCurve3(points);
	}-*/;
	
	public final native SplineCurve SplineCurve(JsArray<XY> points)/*-{
	return $wnd.THREE.SplineCurve(points);
	}-*/;
	
	public final native QuadraticBezierCurve3 QuadraticBezierCurve3(XYZ v0,XYZ v1,XYZ v2)/*-{
	return $wnd.THREE.QuadraticBezierCurve3(v0, v1, v2);
	}-*/;
	
	public final native QuadraticBezierCurve QuadraticBezierCurve(XY v0,XY v1,XY v2)/*-{
	return $wnd.THREE.QuadraticBezierCurve(v0, v1, v2);
	}-*/;
	
	public final native LineCurve3 LineCurve3(Vector3 v1,Vector3 v2)/*-{
	return $wnd.THREE.LineCurve3(v1, v2);
	}-*/;
	
	public final native LineCurve LineCurve(Vector2 v1,Vector2 v2)/*-{
	return $wnd.THREE.LineCurve(v1, v2);
	}-*/;
	
	public final native EllipseCurve EllipseCurve(double aX,double  aY,double  xRadius,double  yRadius,double  aStartAngle,double  aEndAngle,boolean aClockwise)/*-{
	return $wnd.THREE.EllipseCurve(aX, aY, xRadius, yRadius, aStartAngle, aEndAngle, aClockwise);
	}-*/;
	
	public final native CubicBezierCurve3 CubicBezierCurve3(XYZ v0,XYZ v1,XYZ v2,XYZ v3)/*-{
	return $wnd.THREE.CubicBezierCurve3(v0, v1, v2, v3);
	}-*/;
	
	public final native CubicBezierCurve CubicBezierCurve(XY v0,XY v1,XY v2,XY v3)/*-{
	return $wnd.THREE.CubicBezierCurve(v0, v1, v2, v3);
	}-*/;
	
	public final native ClosedSplineCurve3 ClosedSplineCurve3(JsArray<XYZ> points)/*-{
	return $wnd.THREE.ClosedSplineCurve3(points);
	}-*/;
	public final native ArcCurve ArcCurve(double aX,double  aY,double  aRadius,double  aStartAngle,double  aEndAngle,boolean aClockwise)/*-{
	return $wnd.THREE.ArcCurve(aX, aY, aRadius, aStartAngle, aEndAngle, aClockwise);
	}-*/;
	
	public final native Gyroscope Gyroscope()/*-{
	return $wnd.THREE.Gyroscope();
	}-*/;
	
	public final native CompressedTexture CompressedTexture( JavaScriptObject mipmaps,int width,int height,int format,int type,int mapping,int wrapS,int wrapT,int magFilter,int minFilter,int anisotropy)/*-{
	return $wnd.THREE.CompressedTexture( mipmaps, width, height, format, type, mapping, wrapS, wrapT, magFilter, minFilter, anisotropy );
	}-*/;
	
	public final native DataTexture DataTexture( JavaScriptObject data,int width,int height,int format,int type,int mapping,int wrapS,int wrapT,int magFilter,int minFilter,int anisotropy)/*-{
	return $wnd.THREE.DataTexture( data, width, height, format, type, mapping, wrapS, wrapT, magFilter, minFilter, anisotropy);
	}-*/;
	
	public final native Fog Fog(int hex, double near, double far)/*-{
	return $wnd.THREE.Fog(hex,near,far);
	}-*/;
	
	public final native Fog FogExp2(int hex, double density)/*-{
	return $wnd.THREE.FogExp2(hex,density);
	}-*/;
	
	public final native WebGLRenderTargetCube WebGLRenderTargetCube(double widht,double height,JavaScriptObject options)/*-{
	return $wnd.THREE.WebGLRenderTargetCube(width,height,options);
	}-*/;
	
	public final native WebGLRenderTarget WebGLRenderTarget(double widht,double height,JavaScriptObject options)/*-{
	return $wnd.THREE.WebGLRenderTarget(width,height,options);
	}-*/;
	public final native LOD LOD()/*-{
	return $wnd.THREE.LOD();
	}-*/;
	
	public final native Bone Bone(SkinnedMesh mesh)/*-{
	return $wnd.THREE.Bone(mesh);
	}-*/;

	public final native Triangle Triangle(Vector3 a,Vector3 b,Vector3 c)/*-{
	return $wnd.THREE.Triangle(a,b,c);
	}-*/;
	
	public final native Spline Spline(JsArray<XYZObject> points)/*-{
	return $wnd.THREE.Spline(points);
	}-*/;
	
	public final native Sphere Sphere(Vector3 center,double radius)/*-{
	return $wnd.THREE.Sphere(center,radius);
	}-*/;
	
	public static final native Plane Plane(Vector3 normal,double constant)/*-{
	return $wnd.THREE.Plane(normal,constant);
	}-*/;
	
	public final native Matrix4 Matrix4(double n11,double n12,double n13,double n14,double n21,double n22,double n23,double n24,double n31,double n32,double n33,double n34,double n41,double n42,double n43,double n44)/*-{
	return $wnd.THREE.Matrix4(n11,n12,n13,n14,n21,n22,n23,n24,n31,n32,n33,n34,n41,n42,n43,n44);
	}-*/;
	
	public static final native Matrix3 Matrix3(double n11,double n12,double n13,double n21,double n22,double n23,double n31,double n32,double n33)/*-{
	return $wnd.THREE.Matrix3(n11,n12,n13,n21,n22,n23,n31,n32,n33);
	}-*/;
	public static final native Matrix3 Matrix3()/*-{
	return $wnd.THREE.Matrix3();
	}-*/;
	
	private static native final Line3 Line3(Vector3 start,Vector3 end)/*-{
	return new $wnd.THREE.Line3(start,end);
	}-*/;
	
	private static native final Euler Euler(double x,double y,double z,String order)/*-{
	return new $wnd.THREE. Euler(x,y,z,order);
	}-*/;
	
	private static native final Box3 Box3(Vector3 min,Vector3 max)/*-{
	return new $wnd.THREE. Box3(min,max);
	}-*/;
	
	private static native final Box2 Box2(Vector2 min,Vector2 max)/*-{
	return new $wnd.THREE. Box2(min,max);
	}-*/;
	
	private static native final LoadingManager LoadingManager()/*-{
	return new $wnd.THREE.LoadingManager();
	}-*/;
	
	public static  native final SpriteMaterial SpriteMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.SpriteMaterial(parameter);
	}-*/;
	
	public static  native final SpriteCanvasMaterial SpriteCanvasMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.SpriteCanvasMaterial(parameter);
	}-*/;
	
	public static  native final ShaderMaterial ShaderMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.ShaderMaterial(parameter);
	}-*/;
	
	public static  native final ParticleSystemMaterial ParticleSystemMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.ParticleSystemMaterial(parameter);
	}-*/;
	
	public static  native final MeshPhongMaterial MeshPhongMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.MeshPhongMaterial(parameter);
	}-*/;
	
	public static  native final MeshNormalMaterial MeshNormalMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.MeshLambertMaterial(parameter);
	}-*/;
	
	public static  native final MeshLambertMaterial MeshLambertMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.MeshLambertMaterial(parameter);
	}-*/;
	
	public static  native final MeshDepthMaterial MeshDepthMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.MeshDepthMaterial(parameter);
	}-*/;
	
	public static  native final MeshBasicMaterial MeshBasicMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.MeshBasicMaterial(parameter);
	}-*/;
	
	public static  native final LineDashedMaterial LineDashedMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.LineDashedMaterial(parameter);
	}-*/;
	
	/**
	 * LineBasicMaterial material=Three.LineBasicMaterial(LineBasicMaterial.create().color(0xff0000).transparent(false));
	 * @param parameter
	 * @return
	 */
	public static  native final LineBasicMaterial LineBasicMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.LineBasicMaterial(parameter);
	}-*/;
	
	public static LoadingManager LoadingManager(LoadingManagerHandler handler){
		LoadingManager manager=LoadingManager();
		manager.setLoadHandler(handler);
		return manager;
	}
	public static  native final BufferGeometryLoader BufferGeometryLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.BufferGeometryLoader(manager);
	}-*/;
	
	public static  native final GeometryLoader GeometryLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.GeometryLoader(manager);
	}-*/;
	
	public static  native final ImageLoader ImageLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.ImageLoader(manager);
	}-*/;
	
	public static  native final MaterialLoader MaterialLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.MaterialLoader(manager);
	}-*/;
	
	public static  native final ObjectLoader ObjectLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.GeometryLoader(manager);
	}-*/;
	
	public static  native final SceneLoader SceneLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.ImageLoader(manager);
	}-*/;
	
	public static  native final TextureLoader TextureLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.ImageLoader(manager);
	}-*/;
	
	public static  native final XHRLoader XHRLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.ImageLoader(manager);
	}-*/;
	
	
	
	public static  native final SpotLight SpotLight(int hex,double intensity,double distance,double angle,double exponent)/*-{
	return  new $wnd.THREE.SpotLight(hex, intensity, distance, angle, exponent );
	}-*/;
	
	public static  native final PointLight PointLight(int hex,double intensity,double distance)/*-{
	return  new $wnd.THREE.PointLight(hex, intensity, distance );
	}-*/;
	
	/**
	 * 
	 * @param intensity default 1
	 * @return
	 */
	public static  native final HemisphereLight HemisphereLight(int skyColorHex, int groundColorHex,double intensity)/*-{
	return  new $wnd.THREE.HemisphereLight(skyColorHex, groundColorHex, intensity);
	}-*/;
	
	/**
	 * 
	 * @param hex
	 * @param intensity default 1
	 * @return
	 */
	public static  native final AreaLight AreaLight(int hex,double intensity)/*-{
	return  new $wnd.THREE.AreaLight(hex,intensity);
	}-*/;
	
	public static  native final Raycaster Raycaster(Vector3 origin,Vector3 direction,double near,double far)/*-{
	return  new $wnd.THREE.Raycaster(origin,direction,near,far);
	}-*/;
	public static  native final EventDispatcher EventDispatcher()/*-{
	return  new $wnd.THREE.EventDispatcher();
	}-*/;
	
	public static  native final BufferGeometry BufferGeometry()/*-{
	return  new $wnd.THREE.BufferGeometry();
	}-*/;
	
	public static  native final Clock Clock(boolean autostart)/*-{
	return  new $wnd.THREE.Clock(autostart);
	}-*/;
	
	public static  native final Ray Ray(Vector3 camera,Vector3 vector)/*-{
	return  new $wnd.THREE.Ray(camera,vector);
	}-*/;
	
	public static  native final Texture Texture(ImageElement image)/*-{
	return  new $wnd.THREE.Texture(image);
	}-*/;
	
	public static  native final Texture Texture(ImageElement image,JavaScriptObject mapping, int wrapS,int  wrapT, int magFilter,int minFilter,int format,int type,int anisotropy)/*-{
	return  new $wnd.THREE.Texture(image,mapping, wrapS, wrapT, magFilter, minFilter, format, type, anisotropy);
	}-*/;
	
	public static  native final Texture Texture(CanvasElement canvas)/*-{
	return  new $wnd.THREE.Texture(canvas);
	}-*/;
	
	public static  native final JSONLoader JSONLoader(boolean showStatus)/*-{
	return  new $wnd.THREE.JSONLoader(showStatus);
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
	
	public static native final PerspectiveCamera PerspectiveCamera(int fieldOfView,double ratio,double near,double far)/*-{
	return new $wnd.THREE.PerspectiveCamera( fieldOfView, ratio, near, far ); 
	}-*/;
	
	public static native final OrthographicCamera OrthographicCamera(double left,double right,double top,double bottom,double near,double far)/*-{
	return new $wnd.THREE.OrthographicCamera( left, right,top,bottom, near, far ); 
	}-*/;
	
	public static native final CombinedCamera CombinedCamera(double width, double height,double fov, double near, double far, double doubleorthoNear,double orthoFar )/*-{
	return new $wnd.THREE.CombinedCamera( width, height, fov, near, far, orthoNear, orthoFar); 
	}-*/;
	
	public static native final CubeCamera CubeCamera(double near,double  far,double  cubeResolution )/*-{
	return new $wnd.THREE.CubeCamera( near, far, cubeResolution ); 
	}-*/;
	
	public static native final Animation Animation(SkinnedMesh root,String name)/*-{
	return new $wnd.THREE.Animation(root,name);
	}-*/;
	public static native final Animation Animation(Object3D root,String name)/*-{
	return new $wnd.THREE.Animation(root,name);
	}-*/;
	
	public static native final AnimationMorphTarget AnimationMorphTarget(Object3D root,String name)/*-{
	return new $wnd.THREE.AnimationMorphTarget(root,name);
	}-*/;
	
	public static native final KeyFrameAnimation KeyFrameAnimation(Object3D root,String name)/*-{
	return new $wnd.THREE.KeyFrameAnimation(root,name);
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
	
	@SuppressWarnings("unchecked")
	public static final JsArray createJsArray(){
		return JavaScriptUtils.createJSArray();
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
	
	
	
	
	public static native final MeshFaceMaterial MeshFaceMaterial(JsArray<Material> materials)/*-{
	return new $wnd.THREE.MeshFaceMaterial(materials);
	}-*/;
	
	/**
	 * @deprecated use LineBasicMaterialParameter.create()
	 * @return
	 */
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
	
	public static native final CSS3DRenderer CSS3DRenderer()/*-{
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
	
	
	/*
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
	*/
	/*

	*/
	public static final class Side{
		public static native final int FrontSide()/*-{
		return $wnd.THREE.FrontSide;
		}-*/;
		public static native final int BackSide()/*-{
		return $wnd.THREE.BackSide;
		}-*/;
		
		public static native final int DoubleSide()/*-{
		return $wnd.THREE.DoubleSide;
		}-*/;
		
	}
	public static final class Shading{
		public static native final int NoShading()/*-{
		return $wnd.THREE.NoShading;
		}-*/;
		public static native final int FlatShading()/*-{
		return $wnd.THREE.FlatShading;
		}-*/;
		
		public static native final int SmoothShading()/*-{
		return $wnd.THREE.SmoothShading;
		}-*/;
		
	}
	public static final class Blending{
		public static native final int NoBlending()/*-{
		return $wnd.THREE.NoBlending;
		}-*/;
		public static native final int NormalBlending()/*-{
		return $wnd.THREE.NormalBlending;
		}-*/;
		public static native final int AdditiveBlending()/*-{
		return $wnd.THREE.AdditiveBlending;
		}-*/;
		public static native final int SubtractiveBlending()/*-{
		return $wnd.THREE.SubtractiveBlending;
		}-*/;
		public static native final int MultiplyBlending()/*-{
		return $wnd.THREE.MultiplyBlending;
		}-*/;
		public static native final int CustomBlending()/*-{
		return $wnd.THREE.CustomBlending;
		}-*/;
	}
	

	public static final class TextureConstants{
		public static native final int MultiplyOperation()/*-{
		return $wnd.THREE.MultiplyOperation;
		}-*/;
		public static native final int MixOperation()/*-{
		return $wnd.THREE.MixOperation;
		}-*/;
		public static native final int AddOperation()/*-{
		return  $wnd.THREE.AddOperation;
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

	public static final class MappingModes{
		public static native final JavaScriptObject UVMapping()/*-{
		return $wnd.THREE.UVMapping;
		}-*/;
		public static native final JavaScriptObject CubeReflectionMapping()/*-{
		return $wnd.THREE.CubeReflectionMapping;
		}-*/;
		public static native final JavaScriptObject CubeRefractionMapping()/*-{
		return $wnd.THREE.CubeRefractionMapping;
		}-*/;
		public static native final JavaScriptObject SphericalReflectionMapping()/*-{
		return $wnd.THREE.SphericalReflectionMapping;
		}-*/;
		public static native final JavaScriptObject SphericalRefractionMapping()/*-{
		return $wnd.THREE.SphericalRefractionMapping;
		}-*/;
	}
	public static final class WrappingModes{
		public static native final int RepeatWrapping()/*-{
		return $wnd.THREE.RepeatWrapping;
		}-*/;
		public static native final int ClampToEdgeWrapping()/*-{
		return $wnd.THREE.ClampToEdgeWrapping;
		}-*/;
		public static native final int MirroredRepeatWrapping()/*-{
		return $wnd.THREE.MirroredRepeatWrapping;
		}-*/;
	}

	public static native final MorphAnimMesh MorphAnimMesh(Geometry geometry,
			Material material) /*-{
	return new $wnd.THREE.MorphAnimMesh(geometry,material);
	}-*/;

	
	
	public static native final Face3 Face3(double a, double b, double c) /*-{
	return new $wnd.THREE.Face3(a,b,c);
	}-*/;
}
