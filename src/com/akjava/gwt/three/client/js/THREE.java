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
package com.akjava.gwt.three.client.js;

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.three.client.examples.ColladaLoader;
import com.akjava.gwt.three.client.examples.animation.Animation;
import com.akjava.gwt.three.client.examples.animation.AnimationMorphTarget;
import com.akjava.gwt.three.client.examples.animation.KeyFrameAnimation;
import com.akjava.gwt.three.client.examples.animation.MorphAnimation;
import com.akjava.gwt.three.client.examples.camera.CombinedCamera;
import com.akjava.gwt.three.client.examples.modifiers.SubdivisionModifier;
import com.akjava.gwt.three.client.examples.renderers.CSS3DRenderer;
import com.akjava.gwt.three.client.gwt.boneanimation.AnimationData;
import com.akjava.gwt.three.client.gwt.extras.geometries.ExtrudeGeometryParameter;
import com.akjava.gwt.three.client.gwt.renderers.WebGLRendererParameter;
import com.akjava.gwt.three.client.java.LineBasicMaterialBuilder;
import com.akjava.gwt.three.client.java.MeshBasicMaterialBuilder;
import com.akjava.gwt.three.client.java.MeshLambertMaterialBuilder;
import com.akjava.gwt.three.client.java.ParticleBasicMaterialBuilder;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.animation.AnimationMixer;
import com.akjava.gwt.three.client.js.animation.AnimationObjectGroup;
import com.akjava.gwt.three.client.js.animation.KeyframeTrack;
import com.akjava.gwt.three.client.js.animation.PropertyBinding;
import com.akjava.gwt.three.client.js.animation.tracks.BooleanKeyframeTrack;
import com.akjava.gwt.three.client.js.animation.tracks.ColorKeyframeTrack;
import com.akjava.gwt.three.client.js.animation.tracks.NumberKeyframeTrack;
import com.akjava.gwt.three.client.js.animation.tracks.QuaternionKeyframeTrack;
import com.akjava.gwt.three.client.js.animation.tracks.StringKeyframeTrack;
import com.akjava.gwt.three.client.js.animation.tracks.VectorKeyframeTrack;
import com.akjava.gwt.three.client.js.audio.Audio;
import com.akjava.gwt.three.client.js.audio.AudioAnalyser;
import com.akjava.gwt.three.client.js.audio.AudioListener;
import com.akjava.gwt.three.client.js.audio.PositionalAudio;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.cameras.CubeCamera;
import com.akjava.gwt.three.client.js.cameras.OrthographicCamera;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.cameras.StereoCamera;
import com.akjava.gwt.three.client.js.core.BufferAttribute;
import com.akjava.gwt.three.client.js.core.BufferGeometry;
import com.akjava.gwt.three.client.js.core.Clock;
import com.akjava.gwt.three.client.js.core.DynamicBufferAttribute;
import com.akjava.gwt.three.client.js.core.EventDispatcher;
import com.akjava.gwt.three.client.js.core.Face3;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.core.InstancedBufferAttribute;
import com.akjava.gwt.three.client.js.core.InstancedBufferGeometry;
import com.akjava.gwt.three.client.js.core.InstancedInterleavedBuffer;
import com.akjava.gwt.three.client.js.core.InterleavedBuffer;
import com.akjava.gwt.three.client.js.core.InterleavedBufferAttribute;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.core.Raycaster;
import com.akjava.gwt.three.client.js.extras.core.Path;
import com.akjava.gwt.three.client.js.extras.core.Shape;
import com.akjava.gwt.three.client.js.extras.curves.ArcCurve;
import com.akjava.gwt.three.client.js.extras.curves.CatmullRomCurve3;
import com.akjava.gwt.three.client.js.extras.curves.ClosedSplineCurve3;
import com.akjava.gwt.three.client.js.extras.curves.CubicBezierCurve;
import com.akjava.gwt.three.client.js.extras.curves.CubicBezierCurve3;
import com.akjava.gwt.three.client.js.extras.curves.EllipseCurve;
import com.akjava.gwt.three.client.js.extras.curves.LineCurve;
import com.akjava.gwt.three.client.js.extras.curves.LineCurve3;
import com.akjava.gwt.three.client.js.extras.curves.QuadraticBezierCurve;
import com.akjava.gwt.three.client.js.extras.curves.QuadraticBezierCurve3;
import com.akjava.gwt.three.client.js.extras.curves.SplineCurve;
import com.akjava.gwt.three.client.js.extras.curves.SplineCurve3;
import com.akjava.gwt.three.client.js.extras.geometries.BoxGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.CircleBufferGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.CircleGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.CylinderGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.DodecahedronGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.EdgesGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.ExtrudeGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.IcosahedronGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.LatheGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.OctahedronGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.ParametricGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.PlaneBufferGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.PlaneGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.PolyhedronGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.RingGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.ShapeGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.SphereBufferGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.SphereGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.TetrahedronGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.TorusGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.TorusKnotGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.TubeGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.WireframeGeometry;
import com.akjava.gwt.three.client.js.extras.helpers.ArrowHelper;
import com.akjava.gwt.three.client.js.extras.helpers.AxisHelper;
import com.akjava.gwt.three.client.js.extras.helpers.BoundingBoxHelper;
import com.akjava.gwt.three.client.js.extras.helpers.BoxHelper;
import com.akjava.gwt.three.client.js.extras.helpers.CameraHelper;
import com.akjava.gwt.three.client.js.extras.helpers.DirectionalLightHelper;
import com.akjava.gwt.three.client.js.extras.helpers.EdgesHelper;
import com.akjava.gwt.three.client.js.extras.helpers.FaceNormalsHelper;
import com.akjava.gwt.three.client.js.extras.helpers.GridHelper;
import com.akjava.gwt.three.client.js.extras.helpers.HemisphereLightHelper;
import com.akjava.gwt.three.client.js.extras.helpers.PointLightHelper;
import com.akjava.gwt.three.client.js.extras.helpers.SkeletonHelper;
import com.akjava.gwt.three.client.js.extras.helpers.SpotLightHelper;
import com.akjava.gwt.three.client.js.extras.helpers.VertexNormalsHelper;
import com.akjava.gwt.three.client.js.extras.helpers.VertexTangentsHelper;
import com.akjava.gwt.three.client.js.extras.helpers.WireframeHelper;
import com.akjava.gwt.three.client.js.extras.objects.ImmediateRenderObject;
import com.akjava.gwt.three.client.js.extras.objects.MorphBlendMesh;
import com.akjava.gwt.three.client.js.extras.renderers.plugins.DepthPassPlugin;
import com.akjava.gwt.three.client.js.extras.renderers.plugins.LensFlarePlugin;
import com.akjava.gwt.three.client.js.extras.renderers.plugins.ShadowMapPlugin;
import com.akjava.gwt.three.client.js.extras.renderers.plugins.SpritePlugin;
import com.akjava.gwt.three.client.js.lights.AmbientLight;
import com.akjava.gwt.three.client.js.lights.AreaLight;
import com.akjava.gwt.three.client.js.lights.DirectionalLight;
import com.akjava.gwt.three.client.js.lights.HemisphereLight;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.lights.PointLight;
import com.akjava.gwt.three.client.js.lights.SpotLight;
import com.akjava.gwt.three.client.js.loaders.AnimationLoader;
import com.akjava.gwt.three.client.js.loaders.BinaryTextureLoader;
import com.akjava.gwt.three.client.js.loaders.BufferGeometryLoader;
import com.akjava.gwt.three.client.js.loaders.CompressedTextureLoader;
import com.akjava.gwt.three.client.js.loaders.FontLoader;
import com.akjava.gwt.three.client.js.loaders.GeometryLoader;
import com.akjava.gwt.three.client.js.loaders.ImageLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.LoadingManager;
import com.akjava.gwt.three.client.js.loaders.LoadingManager.LoadingManagerHandler;
import com.akjava.gwt.three.client.js.loaders.MaterialLoader;
import com.akjava.gwt.three.client.js.loaders.ObjectLoader;
import com.akjava.gwt.three.client.js.loaders.TextureLoader;
import com.akjava.gwt.three.client.js.loaders.XHRLoader;
import com.akjava.gwt.three.client.js.materials.LineBasicMaterial;
import com.akjava.gwt.three.client.js.materials.LineDashedMaterial;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.materials.MeshBasicMaterial;
import com.akjava.gwt.three.client.js.materials.MeshDepthMaterial;
import com.akjava.gwt.three.client.js.materials.MeshFaceMaterial;
import com.akjava.gwt.three.client.js.materials.MeshLambertMaterial;
import com.akjava.gwt.three.client.js.materials.MeshNormalMaterial;
import com.akjava.gwt.three.client.js.materials.MeshPhongMaterial;
import com.akjava.gwt.three.client.js.materials.MultiMaterial;
import com.akjava.gwt.three.client.js.materials.PointsMaterial;
import com.akjava.gwt.three.client.js.materials.RawShaderMaterial;
import com.akjava.gwt.three.client.js.materials.ShaderMaterial;
import com.akjava.gwt.three.client.js.materials.SpriteCanvasMaterial;
import com.akjava.gwt.three.client.js.materials.SpriteMaterial;
import com.akjava.gwt.three.client.js.math.Box2;
import com.akjava.gwt.three.client.js.math.Box3;
import com.akjava.gwt.three.client.js.math.Color;
import com.akjava.gwt.three.client.js.math.Euler;
import com.akjava.gwt.three.client.js.math.Line3;
import com.akjava.gwt.three.client.js.math.Matrix3;
import com.akjava.gwt.three.client.js.math.Matrix4;
import com.akjava.gwt.three.client.js.math.Plane;
import com.akjava.gwt.three.client.js.math.Quaternion;
import com.akjava.gwt.three.client.js.math.Ray;
import com.akjava.gwt.three.client.js.math.Sphere;
import com.akjava.gwt.three.client.js.math.Spline;
import com.akjava.gwt.three.client.js.math.Triangle;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.math.Vector4;
import com.akjava.gwt.three.client.js.math.Vertex;
import com.akjava.gwt.three.client.js.math.interpolants.CubicInterpolant;
import com.akjava.gwt.three.client.js.math.interpolants.DiscreteInterpolant;
import com.akjava.gwt.three.client.js.math.interpolants.LinearInterpolant;
import com.akjava.gwt.three.client.js.math.interpolants.QuaternionLinearInterpolant;
import com.akjava.gwt.three.client.js.objects.Bone;
import com.akjava.gwt.three.client.js.objects.Group;
import com.akjava.gwt.three.client.js.objects.LOD;
import com.akjava.gwt.three.client.js.objects.LensFlare;
import com.akjava.gwt.three.client.js.objects.Line;
import com.akjava.gwt.three.client.js.objects.LineSegments;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.objects.MorphAnimMesh;
import com.akjava.gwt.three.client.js.objects.Particle;
import com.akjava.gwt.three.client.js.objects.Points;
import com.akjava.gwt.three.client.js.objects.Skeleton;
import com.akjava.gwt.three.client.js.objects.SkinnedMesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderTarget;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderTargetCube;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Fog;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.CanvasTexture;
import com.akjava.gwt.three.client.js.textures.CompressedTexture;
import com.akjava.gwt.three.client.js.textures.CubeTexture;
import com.akjava.gwt.three.client.js.textures.DataTexture;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.akjava.gwt.three.client.js.textures.VideoTexture;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayBoolean;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.VideoElement;



/**
	
 * @author aki
 *
 */


public class THREE {
	public static final native DepthPassPlugin DepthPassPlugin()/*-{
	return new $wnd.THREE.DepthPassPlugin();
	}-*/;
	public static final native LensFlarePlugin LensFlarePlugin()/*-{
	return new $wnd.THREE.LensFlarePlugin();
	}-*/;
	public static final native ShadowMapPlugin ShadowMapPlugin()/*-{
	return new $wnd.THREE.ShadowMapPlugin();
	}-*/;
	public static final native SpritePlugin SpritePlugin()/*-{
	return new $wnd.THREE.SpritePlugin();
	}-*/;
	public static final native ImmediateRenderObject ImmediateRenderObject(Material material)/*-{
	return new $wnd.THREE.ImmediateRenderObject(material);
	}-*/;
	public static final native LensFlare LensFlare(Texture texture,double size,double distance,int blending,Color color)/*-{
	return new $wnd.THREE.LensFlare(texture, size, distance, blending, color);
	}-*/;
	public static final native MorphBlendMesh MorphBlendMesh(Geometry geometry,Material material)/*-{
	return new $wnd.THREE.MorphBlendMesh(geometry, material);
	}-*/;
	
	public static final native ArrowHelper ArrowHelper(Vector3 dir,Vector3 origin,double length,int hex,double headLength,double headWidth)/*-{
	return new $wnd.THREE.ArrowHelper( dir, origin, length, hex,headLength, headWidth);
	}-*/;
	public static final native ArrowHelper ArrowHelper(Vector3 dir,Vector3 origin,double length,int hex)/*-{
	return new $wnd.THREE.ArrowHelper( dir, origin, length, hex);
	}-*/;
	public static final native ArrowHelper ArrowHelper(Vector3 dir,Vector3 origin,double length)/*-{
	return new $wnd.THREE.ArrowHelper( dir, origin, length);
	}-*/;

	public static final native AxisHelper AxisHelper(double size)/*-{
	return new $wnd.THREE.AxisHelper(size);
	}-*/;


	public static final native BoundingBoxHelper BoundingBoxHelper(Object3D object,int hex)/*-{
	return new $wnd.THREE.BoundingBoxHelper(object, hex);
	}-*/;
	public static final native BoxHelper BoxHelper(Object3D object)/*-{
	return new $wnd.THREE.BoxHelper(object);
	}-*/;
	public static final native EdgesHelper EdgesHelper(Mesh object)/*-{
	return new $wnd.THREE.EdgesHelper(object);
	}-*/;
	public static final native EdgesHelper EdgesHelper(Mesh object,int hex)/*-{
	return new $wnd.THREE.EdgesHelper(object,hex);
	}-*/;
	
	/**
	 * document from r71
	 * @author WestLangley / http://github.com/WestLangley
	 * @param object THREE.Mesh whose geometry will be used
	 * @param hex line color
	 * @param thresholdAngle the minimim angle (in degrees),
	 * between the face normals of adjacent faces,
	 * that is required to render an edge. A value of 10 means
	 * an edge is only rendered if the angle is at least 10 degrees.
	 */
	
	public static final native EdgesHelper EdgesHelper(Mesh object,int hex,double thresholdAngle)/*-{
	return new $wnd.THREE.EdgesHelper(object,hex);
	}-*/;
	
	public static final native CameraHelper CameraHelper(Camera camera)/*-{
	return new $wnd.THREE.CameraHelper(camera);
	}-*/;
	public static final native DirectionalLightHelper DirectionalLightHelper(DirectionalLight light,double size)/*-{
	return new $wnd.THREE.DirectionalLightHelper(light, size);
	}-*/;
	public static final native FaceNormalsHelper FaceNormalsHelper(Object3D object,double size,int hex,double linewidth)/*-{
	return new $wnd.THREE.FaceNormalsHelper(object, size, hex, linewidth);
	}-*/;
	public static final native GridHelper GridHelper(int size,int step )/*-{
	return new $wnd.THREE.GridHelper(size, step );
	}-*/;
	public static final native HemisphereLightHelper HemisphereLightHelper(HemisphereLight light,double sphereSize,double arrowLength,double domeSize)/*-{
	return new $wnd.THREE.HemisphereLightHelper(light, sphereSize, arrowLength, domeSize);
	}-*/;
	public static final native PointLightHelper PointLightHelper(PointLight light,double sphereSize)/*-{
	return new $wnd.THREE.PointLightHelper( light, sphereSize);
	}-*/;
	public static final native SpotLightHelper SpotLightHelper(SpotLight light)/*-{
	return new $wnd.THREE.SpotLightHelper(light);
	}-*/;
	public static final native VertexNormalsHelper VertexNormalsHelper(Object3D object,double size,int hex,double linewidth)/*-{
	return new $wnd.THREE.VertexNormalsHelper(object, size, hex, linewidth);
	}-*/;
	public static final native VertexTangentsHelper VertexTangentsHelper(Object3D object,double size,int hex,double linewidth)/*-{
	return new $wnd.THREE.ArrowHelper();
	}-*/;
	public static final native WireframeHelper WireframeHelper(Object3D object)/*-{
	return new $wnd.THREE.WireframeHelper(object);
	}-*/;
	public static final native WireframeHelper WireframeHelper(Object3D object,int lineColor)/*-{
	return new $wnd.THREE.WireframeHelper(object,lineColor);
	}-*/;
	
	
	

	 
	public static final native TubeGeometry TubeGeometry(Path path,int segments,double radius,double radialSegments,boolean closed )/*-{
	return new $wnd.THREE.TubeGeometry(path, segments, radius, radialSegments, closed );
	}-*/;
	public static final native TorusKnotGeometry TorusKnotGeometry(double radius,double tube,int radialSegments,int tubularSegments,double p,double q,double heightScale)/*-{
	return new $wnd.THREE.TorusKnotGeometry(radius, tube, radialSegments, tubularSegments, p, q, heightScale);
	}-*/;
	public static final native TorusKnotGeometry TorusKnotGeometry(double radius,double tube,int radialSegments,int tubularSegments)/*-{
	return new $wnd.THREE.TorusKnotGeometry(radius, tube, radialSegments);
	}-*/;
	
	public static final native TorusGeometry TorusGeometry(double radius,double tube,int radialSegments,int tubularSegments)/*-{
	return new $wnd.THREE.TorusGeometry(radius, tube, radialSegments, tubularSegments);
	}-*/;
	
	public static final native TorusGeometry TorusGeometry(double radius,double tube,int radialSegments,int tubularSegments,double arc)/*-{
	return new $wnd.THREE.TorusGeometry(radius, tube, radialSegments, tubularSegments, arc);
	}-*/;

	public static final native TetrahedronGeometry TetrahedronGeometry(double radius,int detail )/*-{
	return new $wnd.THREE.TetrahedronGeometry(radius, detail );
	}-*/;
	public static final native SphereGeometry SphereGeometry(double radius,int widthSegments,int heightSegments,double phiStart,double phiLength,double thetaStart,double thetaLength)/*-{
	return new $wnd.THREE.SphereGeometry(radius, widthSegments, heightSegments, phiStart, phiLength, thetaStart, thetaLength);
	}-*/;
	public static final native ShapeGeometry ShapeGeometry(JsArray<Shape> shapes,JavaScriptObject options)/*-{
	return new $wnd.THREE.ShapeGeometry(shapes, options);
	}-*/;
	public static final native RingGeometry RingGeometry(double innerRadius,double  outerRadius,int thetaSegments,int phiSegments,double  thetaStart,double  thetaLength)/*-{
	return new $wnd.THREE.RingGeometry(innerRadius, outerRadius, thetaSegments, phiSegments, thetaStart, thetaLength);
	}-*/;
	public static final native PolyhedronGeometry PolyhedronGeometry(JsArray<JsArrayNumber> vertices,JsArray<JsArrayNumber> faces,double radius,int detail)/*-{
	return new $wnd.THREE.PolyhedronGeometry(vertices, faces, radius, detail);
	}-*/;
	
	// on r69 recommending use PlaneBufferGeometry
	public static final native PlaneGeometry PlaneGeometry(double width,double height,int widthSegments,int heightSegments)/*-{
	return new $wnd.THREE.PlaneGeometry(width, height, widthSegments, heightSegments);
	}-*/;
	public static final native ParametricGeometry ParametricGeometry(JavaScriptObject func,int slices,int stacks)/*-{
	return new $wnd.THREE.ParametricGeometry(func, slices, stacks);
	}-*/;
	public static final native OctahedronGeometry OctahedronGeometry(double radius,int detail)/*-{
	return new $wnd.THREE.OctahedronGeometry(radius, detail);
	}-*/;
	public static final native LatheGeometry LatheGeometry(JsArray<Vector2> points,int segments,double phiStart,double phiLength)/*-{
	return new $wnd.THREE.LatheGeometry(points, segments, phiStart, phiLength);
	}-*/;
	public static final native LatheGeometry LatheGeometry(JsArray<Vector2> points,int segments)/*-{
	return new $wnd.THREE.LatheGeometry(points, segments);
	}-*/;
	public static final native IcosahedronGeometry IcosahedronGeometry(double radius,int detail)/*-{
	return new $wnd.THREE.IcosahedronGeometry(radius, detail);
	}-*/;
	public static final native ExtrudeGeometry ExtrudeGeometry(JsArray<Shape> shapes, JavaScriptObject options)/*-{
	return new $wnd.THREE.ExtrudeGeometry(shapes, options);
	}-*/;
	public static final native CylinderGeometry CylinderGeometry(double radiusTop,double  radiusBottom,double  height,int radialSegments,int heightSegments,boolean openEnded)/*-{
	return new $wnd.THREE.CylinderGeometry(radiusTop, radiusBottom, height, radialSegments, heightSegments, openEnded);
	}-*/;
	public static final native CylinderGeometry CylinderGeometry(double radiusTop,double  radiusBottom,double  height,int radialSegments,int heightSegments)/*-{
	return new $wnd.THREE.CylinderGeometry(radiusTop, radiusBottom, height, radialSegments, heightSegments);
	}-*/;
	public static final native BoxGeometry BoxGeometry(double width,double height,double depth,int widthSegments,int heightSegments,int depthSegments )/*-{
	return new $wnd.THREE.BoxGeometry( width, height, depth, widthSegments, heightSegments, depthSegments );
	}-*/;
	public static final native CircleGeometry CircleGeometry(double radius,int segments,double thetaStart,double thetaLength)/*-{
	return new $wnd.THREE.CircleGeometry(radius, segments, thetaStart, thetaLength);
	}-*/;
	public static final native CircleGeometry CircleGeometry(double radius,int segments)/*-{
	return new $wnd.THREE.CircleGeometry(radius, segments);
	}-*/;
	/**
	 * @deprecated
	 * @param points
	 * @return
	 */
	public static final native SplineCurve3 SplineCurve3(JsArray<Vector3> points)/*-{
	return new $wnd.THREE.SplineCurve3(points);
	}-*/;
	

	
	
	public static final native SplineCurve SplineCurve(JsArray<Vector2> points)/*-{
	return new $wnd.THREE.SplineCurve(points);
	}-*/;
	
	public static final native QuadraticBezierCurve3 QuadraticBezierCurve3(Vector3 v0,Vector3 v1,Vector3 v2)/*-{
	return new $wnd.THREE.QuadraticBezierCurve3(v0, v1, v2);
	}-*/;
	
	public static final native QuadraticBezierCurve QuadraticBezierCurve(Vector2 v0,Vector2 v1,Vector2 v2)/*-{
	return new $wnd.THREE.QuadraticBezierCurve(v0, v1, v2);
	}-*/;
	
	public static final native LineCurve3 LineCurve3(Vector3 v1,Vector3 v2)/*-{
	return new $wnd.THREE.LineCurve3(v1, v2);
	}-*/;
	
	public static final native LineCurve LineCurve(Vector2 v1,Vector2 v2)/*-{
	return new $wnd.THREE.LineCurve(v1, v2);
	}-*/;
	
	public static final native EllipseCurve EllipseCurve(double aX,double  aY,double  xRadius,double  yRadius,double  aStartAngle,double  aEndAngle,boolean aClockwise,double aRotation)/*-{
	return new $wnd.THREE.EllipseCurve(aX, aY, xRadius, yRadius, aStartAngle, aEndAngle, aClockwise,aRotation);
	}-*/;
	
	public static final native CubicBezierCurve3 CubicBezierCurve3(Vector3 v0,Vector3 v1,Vector3 v2,Vector3 v3)/*-{
	return new $wnd.THREE.CubicBezierCurve3(v0, v1, v2, v3);
	}-*/;
	
	public static final native CubicBezierCurve CubicBezierCurve(Vector2 v0,Vector2 v1,Vector2 v2,Vector2 v3)/*-{
	return new $wnd.THREE.CubicBezierCurve(v0, v1, v2, v3);
	}-*/;
	
	public static final native ClosedSplineCurve3 ClosedSplineCurve3(JsArray<Vector3> points)/*-{
	return new $wnd.THREE.ClosedSplineCurve3(points);
	}-*/;
	public static final native ArcCurve ArcCurve(double aX,double  aY,double  aRadius,double  aStartAngle,double  aEndAngle,boolean aClockwise)/*-{
	return new $wnd.THREE.ArcCurve(aX, aY, aRadius, aStartAngle, aEndAngle, aClockwise);
	}-*/;
	
	
	
	public static final native CompressedTexture CompressedTexture( JavaScriptObject mipmaps,int width,int height,int format,int type,int mapping,int wrapS,int wrapT,int magFilter,int minFilter,int anisotropy)/*-{
	return new $wnd.THREE.CompressedTexture( mipmaps, width, height, format, type, mapping, wrapS, wrapT, magFilter, minFilter, anisotropy );
	}-*/;
	
	public static final native DataTexture DataTexture( JavaScriptObject data,int width,int height,int format,int type,int mapping,int wrapS,int wrapT,int magFilter,int minFilter,int anisotropy)/*-{
	return new $wnd.THREE.DataTexture( data, width, height, format, type, mapping, wrapS, wrapT, magFilter, minFilter, anisotropy);
	}-*/;
	
	public static final native Fog Fog(int hex, double near, double far)/*-{
	return new $wnd.THREE.Fog(hex,near,far);
	}-*/;
	public static final native Fog Fog(int hex)/*-{
	return new $wnd.THREE.Fog(hex);
	}-*/;
	
	public static final native Fog FogExp2(int hex, double density)/*-{
	return new $wnd.THREE.FogExp2(hex,density);
	}-*/;
	
	public static final native WebGLRenderTargetCube WebGLRenderTargetCube(double width,double height,JavaScriptObject options)/*-{
	return new $wnd.THREE.WebGLRenderTargetCube(width,height,options);
	}-*/;
	
	public static final native WebGLRenderTarget WebGLRenderTarget(double width,double height,JavaScriptObject options)/*-{
	return new $wnd.THREE.WebGLRenderTarget(width,height,options);
	}-*/;
	
	public static final native WebGLRenderTarget WebGLRenderTarget(double width,double height)/*-{
	return new $wnd.THREE.WebGLRenderTarget(width,height);
	}-*/;
	public static final native LOD LOD()/*-{
	return new $wnd.THREE.LOD();
	}-*/;
	
	public static final native Bone Bone(SkinnedMesh mesh)/*-{
	return new $wnd.THREE.Bone(mesh);
	}-*/;

	public static final native Triangle Triangle(Vector3 a,Vector3 b,Vector3 c)/*-{
	return new $wnd.THREE.Triangle(a,b,c);
	}-*/;
	
	public static final native Spline Spline(JsArray<JavaScriptObject> points)/*-{
	return new $wnd.THREE.Spline(points);
	}-*/;
	
	public static final native Sphere Sphere(Vector3 center,double radius)/*-{
	return new $wnd.THREE.Sphere(center,radius);
	}-*/;
	
	public static final native Plane Plane(Vector3 normal,double constant)/*-{
	return new $wnd.THREE.Plane(normal,constant);
	}-*/;
	

	/**
	 * @deprecated
	 * on r69 ,use set()
	 */
	public static final native Matrix4 Matrix4(double n11,double n12,double n13,double n14,double n21,double n22,double n23,double n24,double n31,double n32,double n33,double n34,double n41,double n42,double n43,double n44)/*-{
	return new $wnd.THREE.Matrix4(n11,n12,n13,n14,n21,n22,n23,n24,n31,n32,n33,n34,n41,n42,n43,n44);
	}-*/;
	
	/**
	 * @deprecated
	 * on r69 ,use set()
	 */
	public static final native Matrix3 Matrix3(double n11,double n12,double n13,double n21,double n22,double n23,double n31,double n32,double n33)/*-{
	return new $wnd.THREE.Matrix3(n11,n12,n13,n21,n22,n23,n31,n32,n33);
	}-*/;
	public static final native Matrix3 Matrix3()/*-{
	return new $wnd.THREE.Matrix3();
	}-*/;
	
	public static native final Line3 Line3(Vector3 start,Vector3 end)/*-{
	return new $wnd.THREE.Line3(start,end);
	}-*/;
	
	public static native final Euler Euler(double x,double y,double z,String order)/*-{
	return new $wnd.THREE. Euler(x,y,z,order);
	}-*/;
	
	public static native final Euler Euler()/*-{
	return new $wnd.THREE. Euler();
	}-*/;
	
	public static native final Euler Euler(double x,double y,double z)/*-{
	return new $wnd.THREE. Euler(x,y,z);
	}-*/;
	
	public static native final Box3 Box3(Vector3 min,Vector3 max)/*-{
	return new $wnd.THREE. Box3(min,max);
	}-*/;
	
	public static native final Box3 Box3()/*-{
	return new $wnd.THREE. Box3();
	}-*/;
	
	public static native final Box2 Box2(Vector2 min,Vector2 max)/*-{
	return new $wnd.THREE. Box2(min,max);
	}-*/;
	
	public static native final LoadingManager LoadingManager()/*-{
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
	
	public static  native final PointsMaterial PointsMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.PointsMaterial(parameter);
	}-*/;
	
	public static  native final MeshPhongMaterial MeshPhongMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.MeshPhongMaterial(parameter);
	}-*/;
	public static  native final MeshPhongMaterial MeshPhongMaterial()/*-{
	return  new $wnd.THREE.MeshPhongMaterial();
	}-*/;
	
	public static  native final MeshNormalMaterial MeshNormalMaterial()/*-{
	return  new $wnd.THREE.MeshNormalMaterial();
	}-*/;
	public static  native final MeshNormalMaterial MeshNormalMaterial(JavaScriptObject parameter)/*-{
	return  new $wnd.THREE.MeshNormalMaterial(parameter);
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
	
	public static  native final MeshBasicMaterial MeshBasicMaterial()/*-{
	return  new $wnd.THREE.MeshBasicMaterial();
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
	public static  native final BufferGeometryLoader BufferGeometryLoader()/*-{
	return  new $wnd.THREE.BufferGeometryLoader();
	}-*/;
	
	/**
	 * @deprecated
	 * @param manager
	 * @return
	 */
	public static  native final GeometryLoader GeometryLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.GeometryLoader(manager);
	}-*/;
	
	public static  native final ImageLoader ImageLoader()/*-{
	return  new $wnd.THREE.ImageLoader();
	}-*/;
	
	public static  native final ImageLoader ImageLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.ImageLoader(manager);
	}-*/;
	
	public static  native final MaterialLoader MaterialLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.MaterialLoader(manager);
	}-*/;
	public static  native final MaterialLoader MaterialLoader()/*-{
	return  new $wnd.THREE.MaterialLoader();
	}-*/;
	
	public static  native final ObjectLoader ObjectLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.ObjectLoader(manager);
	}-*/;
	public static  native final ObjectLoader ObjectLoader()/*-{
	return  new $wnd.THREE.ObjectLoader();
	}-*/;
	
	public static  native final TextureLoader TextureLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.TextureLoader(manager);
	}-*/;
	public static  native final TextureLoader TextureLoader()/*-{
	return  new $wnd.THREE.TextureLoader();
	}-*/;
	
	public static  native final XHRLoader XHRLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.XHRLoader(manager);
	}-*/;
	
	public static  native final XHRLoader XHRLoader()/*-{
	return  new $wnd.THREE.XHRLoader();
	}-*/;
	public static  native final AnimationLoader AnimationLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.AnimationLoader(manager);
	}-*/;
	
	public static  native final AnimationLoader AnimationLoader()/*-{
	return  new $wnd.THREE.AnimationLoader();
	}-*/;
	
	public static  native final FontLoader FontLoader(LoadingManager manager)/*-{
	return  new $wnd.THREE.FontLoader(manager);
	}-*/;
	
	public static  native final FontLoader FontLoader()/*-{
	return  new $wnd.THREE.FontLoader();
	}-*/;
	
	
	public static  native final SpotLight SpotLight(int hex,double intensity,double distance,double angle,double exponent)/*-{
	return  new $wnd.THREE.SpotLight(hex, intensity, distance, angle, exponent );
	}-*/;
	
	public static  native final SpotLight SpotLight(int hex,double intensity,double distance,double angle,double exponent,double decay)/*-{
	return  new $wnd.THREE.SpotLight(hex, intensity, distance, angle, exponent ,decay);
	}-*/;
	
	public static  native final PointLight PointLight(int hex,double intensity,double distance)/*-{
	return  new $wnd.THREE.PointLight(hex, intensity, distance );
	}-*/;
	
	public static  native final PointLight PointLight(int hex,double intensity,double distance,double decay)/*-{
	return  new $wnd.THREE.PointLight(hex, intensity, distance , decay);
	}-*/;
	
	/**
	 * 
	 * @param intensity default 1
	 * @return
	 */
	public static  native final HemisphereLight HemisphereLight(double skyColorHex, double groundColorHex,double intensity)/*-{
	return  new $wnd.THREE.HemisphereLight(skyColorHex, groundColorHex, intensity);
	}-*/;
	public static  native final HemisphereLight HemisphereLight(double skyColorHex, double groundColorHex)/*-{
	return  new $wnd.THREE.HemisphereLight(skyColorHex, groundColorHex);
	}-*/;
	
	/**
	 * @deprecated
	 * @param hex
	 * @param intensity default 1
	 * @return
	 */
	public static  native final AreaLight AreaLight(int hex,double intensity)/*-{
	return  new $wnd.THREE.AreaLight(hex,intensity);
	}-*/;
	
	public static  native final Raycaster Raycaster()/*-{
	return  new $wnd.THREE.Raycaster();
	}-*/;
	
	public static  native final Raycaster Raycaster(Vector3 origin,Vector3 direction,double near,double far)/*-{
	return  new $wnd.THREE.Raycaster(origin,direction,near,far);
	}-*/;
	public static  native final Raycaster Raycaster(Vector3 origin,Vector3 direction)/*-{
	return  new $wnd.THREE.Raycaster(origin,direction);
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
	
	public static  native final Clock Clock()/*-{
	return  new $wnd.THREE.Clock();
	}-*/;
	
	public static  native final Ray Ray(Vector3 camera,Vector3 vector)/*-{
	return  new $wnd.THREE.Ray(camera,vector);
	}-*/;
	
	/**
	 * usually texture.setNeedsUpdate(true);
	 * you can use ImageUtils.loadTexture("texture.jpg")
	 * @param image
	 * @return
	 */
	public static  native final Texture Texture(ImageElement image)/*-{
	return  new $wnd.THREE.Texture(image);
	}-*/;
	
	public static  native final Texture Texture(ImageElement image,JavaScriptObject mapping, int wrapS,int  wrapT, int magFilter,int minFilter,int format,int type,int anisotropy)/*-{
	return  new $wnd.THREE.Texture(image,mapping, wrapS, wrapT, magFilter, minFilter, format, type, anisotropy);
	}-*/;
	
	public static  native final CanvasTexture CanvasTexture(CanvasElement canvas)/*-{
	return  new $wnd.THREE.CanvasTexture(canvas);
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
	public static native final OrthographicCamera OrthographicCamera()/*-{
	return new $wnd.THREE.OrthographicCamera( ); 
	}-*/;
	
	public static native final CombinedCamera CombinedCamera(double width, double height,double fov, double near, double far, double doubleorthoNear,double orthoFar )/*-{
	return new $wnd.THREE.CombinedCamera( width, height, fov, near, far, orthoNear, orthoFar); 
	}-*/;
	
	public static native final CubeCamera CubeCamera(double near,double  far,double  cubeResolution )/*-{
	return new $wnd.THREE.CubeCamera( near, far, cubeResolution ); 
	}-*/;
	
	/**
	 * @deprecated
	 */
	public static native final Animation Animation(SkinnedMesh root,String name)/*-{
	return new $wnd.THREE.Animation(root,name);
	}-*/;
	/**
	 * @deprecated
	 */
	public static native final Animation Animation(Object3D root,String name)/*-{
	return new $wnd.THREE.Animation(root,name);
	}-*/;
	

	//SkinnedMesh or Bone?
	public static native final Animation Animation(Object3D root,AnimationData data)/*-{
	return new $wnd.THREE.Animation(root,data);
	}-*/;
	
	/**
	 * @deprecated on r65
	 */
	public static native final AnimationMorphTarget AnimationMorphTarget(Object3D root,String name)/*-{
	return new $wnd.THREE.AnimationMorphTarget(root,name);
	}-*/;

	
	/**
	 * @deprecated
	 * changed on r68
	 */
	public static native final KeyFrameAnimation KeyFrameAnimation(Object3D root,String name)/*-{
	return new $wnd.THREE.KeyFrameAnimation(root,name);
	}-*/;
	
	public static native final KeyFrameAnimation KeyFrameAnimation(AnimationData data)/*-{
	return new $wnd.THREE.KeyFrameAnimation(data);
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
	
	/**
	 * 
	 * @param color because of random 0xffffff*random()
	 * @return
	 */
	public static native final AmbientLight AmbientLight(double color)/*-{
	return new $wnd.THREE.AmbientLight(color);
	}-*/;
	
	public static native final AmbientLight AmbientLight(double color,double intensity)/*-{
	return new $wnd.THREE.AmbientLight(color,intensity);
	}-*/;
	
	
	
	public static  final BoxGeometry BoxGeometry(double x,double y,double z,int xpart,int ypart,int zpart,Material[] material ){
		JsArray<Material> arrays=(JsArray<Material>) JsArray.createArray();
		for(Material m:material){
			arrays.push(m);
		}
		
		return Cube(x,y,z,xpart,ypart,zpart,arrays);
	}
	
	public static  final BoxGeometry Cube(double x,double y,double z,int xpart,int ypart,int zpart,Material[] material ){
		JsArray<Material> arrays=(JsArray<Material>) JsArray.createArray();
		for(Material m:material){
			arrays.push(m);
		}
		
		return Cube(x,y,z,xpart,ypart,zpart,arrays);
	
	}
	
	//TODO support generic
	@SuppressWarnings("unchecked")
	public static final JsArray createJsArray(){
		return JavaScriptUtils.createJSArray();
	}
	
	public static native final BoxGeometry BoxGeometry(double x,double y,double z,int xpart,int ypart,int zpart,JsArray<Material> materials)/*-{
	
	
    var ms= $wnd.eval("new Array()");
    for (var i = 0; i < materials.length; i++) {
		ms.push(materials[i]);
        }
        
	return new $wnd.THREE.BoxGeometry( x, y, z ,xpart,ypart,zpart,ms);
	}-*/;
	
	

	
	//I'm happy to fix array problem.
	public static native final BoxGeometry Cube(double x,double y,double z,int xpart,int ypart,int zpart,JsArray<Material> materials)/*-{
	
	material = new $wnd.THREE.MeshBasicMaterial({color: 0xff0000, wireframe: false});
    var ms=new $wnd.Array();
    for (var i = 0; i < materials.length; i++) {
		ms.push(materials[i]);
        }
        
	return new $wnd.THREE.BoxGeometry( x, y, z ,xpart,ypart,zpart,ms);
	}-*/;
	
	
	
	public static native final Geometry Geometry()/*-{
	return new $wnd.THREE.Geometry();
	}-*/;
	
	public static native final Object3D Object3D()/*-{
	return new $wnd.THREE.Object3D();
	}-*/;
	
	public static native final BoxGeometry BoxGeometry(double x,double y,double z)/*-{
	return new $wnd.THREE.BoxGeometry( x, y, z );
	}-*/;
	
	public static native final PlaneGeometry PlaneGeometry(double x,double y)/*-{
	return new $wnd.THREE.PlaneGeometry( x, y );
	}-*/;

	public static native final SphereGeometry SphereGeometry(double radius ,int segments)/*-{
	return new $wnd.THREE.SphereGeometry( radius, segments);
	}-*/;
	
	public static native final SphereGeometry SphereGeometry(double radius ,int segments,int rings)/*-{
	return new $wnd.THREE.SphereGeometry( radius, segments, rings );
	}-*/;
	
	public static native final CylinderGeometry CylinderGeometry(double topRad,double botRad,double height,int radSegs)/*-{
	return new $wnd.THREE.CylinderGeometry( topRad,botRad,height,radSegs );
	}-*/;
	

	


	
	
	/**
	 * @deprecated
	 * @return
	 */
	public static native final MeshFaceMaterial MeshFaceMaterial()/*-{
	return new $wnd.THREE.MeshFaceMaterial();
	}-*/;
	/**
	 * @deprecated
	 * @return
	 */
	public static native final MeshFaceMaterial MeshFaceMaterial(JsArray<Material> materials)/*-{
	return new $wnd.THREE.MeshFaceMaterial(materials);
	}-*/;
	
	public static native final MultiMaterial MultiMaterial()/*-{
	return new $wnd.THREE.MultiMaterial();
	}-*/;
	
	/**
	 * 
	 * @param materials
	 * create array via JavaScriptUtils.createJSArray() or Uncaught TypeError: Cannot read property 'visible' of undefined
	 * 
	 * it changed empty this line "materials instanceof Array ? "
	 * 
	 * & kep size called materialIndex
	 * 
	 * @return
	 */
	public static native final MultiMaterial MultiMaterial(JsArray<Material> materials)/*-{
	return new $wnd.THREE.MultiMaterial(materials);
	}-*/;
	
	/**
	 * @deprecated use LineBasicMaterialParameter.create()
	 * @return
	 */
	public static  final LineBasicMaterialBuilder LineBasicMaterial(){
		return LineBasicMaterialBuilder.create();
	}
	
	

	
	public static native final RawShaderMaterial RawShaderMaterial(JavaScriptObject parameter)/*-{
	return new $wnd.THREE.RawShaderMaterial(parameter);
	}-*/;
	

	
	
	public static native final Vector2 Vector2(double x,double y)/*-{
	return new $wnd.THREE.Vector2( x,y);
	}-*/;
	public static native final Vector2 Vector2()/*-{
	return new $wnd.THREE.Vector2();
	}-*/;
	
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
	
	
	/**
	 * @deprecated
	 */
	public static native final Particle Particle(Material material )/*-{
	return new $wnd.THREE.Particle(material );
	}-*/;
	public static native final Points Points(Geometry geometry,Material material )/*-{
	return new $wnd.THREE.Points( geometry, material );
	}-*/;

	public static native final Mesh Mesh(Geometry geometry )/*-{
	return new $wnd.THREE.Mesh( geometry );
	}-*/;
	
	public static native final Mesh Mesh(Geometry geometry,Material material )/*-{
	return new $wnd.THREE.Mesh( geometry, material );
	}-*/;
	public static native final Mesh Mesh(BufferGeometry geometry,Material material )/*-{
	return new $wnd.THREE.Mesh( geometry, material );
	}-*/;
	public static native final Mesh Mesh(BufferGeometry geometry)/*-{
	return new $wnd.THREE.Mesh( geometry);
	}-*/;
	public static native final SkinnedMesh SkinnedMesh(Geometry geometry,Material material )/*-{
	return new $wnd.THREE.SkinnedMesh( geometry, material );
	}-*/;
	public static native final Line Line(Geometry geometry,Material material )/*-{
	return new $wnd.THREE.Line( geometry, material );
	}-*/;
	public static native final LineSegments LineSegments(Geometry geometry,Material material )/*-{
	return new $wnd.THREE.LineSegments( geometry, material );
	}-*/;
	
	public static native final Color Color()/*-{
	return new $wnd.THREE.Color();
	}-*/;
	
	public static native final Color Color(int hex)/*-{
	return new $wnd.THREE.Color(hex);
	}-*/;
	public static native final Color Color(int r,int g,int b)/*-{
	return new $wnd.THREE.Color(r,g,b);
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
	
	public static native final WebGLRenderer WebGLRenderer(WebGLRendererParameter object)/*-{
	return new $wnd.THREE.WebGLRenderer(object);
	}-*/;
	
	public static native final PointLight PointLight(double color)/*-{
	return new $wnd.THREE.PointLight(color);
	}-*/;
	public static native final PointLight PointLight(double color,double intensity )/*-{
	return new $wnd.THREE.PointLight(color,intensity);
	}-*/;
	public static native final SpotLight SpotLight(double color)/*-{
	return new $wnd.THREE.SpotLight(color);
	}-*/;
	public static native final SpotLight SpotLight(double color,double intensity)/*-{
	return new $wnd.THREE.SpotLight(color,intensity);
	}-*/;

	public static native final DirectionalLight DirectionalLight(double color)/*-{
	return new $wnd.THREE.DirectionalLight(color);
	}-*/;
	
	public static native final DirectionalLight DirectionalLight(double color,double intensity)/*-{
	return new $wnd.THREE.DirectionalLight(color,intensity);
	}-*/;
	



	

	
	/**
	 * @deprecated use direct
	 * @author aki
	 *
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
	/**
	 * @deprecated use direct
	 * @author aki
	 *
	 */
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
	/**
	 * @deprecated use direct
	 * @author aki
	 *
	 */
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
	
	/**
	 * @deprecated use direct
	 * @author aki
	 *
	 */
	public static final class TextureConstants{
		public static native final int MultiplyOperation()/*-{
		return new $wnd.THREE.MultiplyOperation;
		}-*/;
		public static native final int MixOperation()/*-{
		return new $wnd.THREE.MixOperation;
		}-*/;
		public static native final int AddOperation()/*-{
		return  $wnd.THREE.AddOperation;
		}-*/;
	}
	
	/**
	 * @deprecated use direct
	 * @author aki
	 *
	 */
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

	/**
	 * @deprecated use direct
	 * @author aki
	 *
	 */
	public static final class MappingModes{
		public static native final int UVMapping()/*-{
		return $wnd.THREE.UVMapping;
		}-*/;
		public static native final int CubeReflectionMapping()/*-{
		return $wnd.THREE.CubeReflectionMapping;
		}-*/;
		public static native final int CubeRefractionMapping()/*-{
		return $wnd.THREE.CubeRefractionMapping;
		}-*/;
		
		public static native final int EquirectangularReflectionMapping()/*-{
		return $wnd.THREE.EquirectangularReflectionMapping;
		}-*/;
		
		public static native final int EquirectangularRefractionMapping()/*-{
		return $wnd.THREE.EquirectangularRefractionMapping;
		}-*/;
		
		public static native final int SphericalReflectionMapping()/*-{
		return $wnd.THREE.SphericalReflectionMapping;
		}-*/;
		
		
	}
	/**
	 * @deprecated use direct
	 * @author aki
	 *
	 */
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
	
	/**
	 * @deprecated use direct
	 * @author aki
	 *
	 */
	public static final class Filters{
		public static native final int NearestFilter()/*-{
		return $wnd.THREE.NearestFilter;
		}-*/;
		public static native final int NearestMipMapNearestFilter()/*-{
		return $wnd.THREE.NearestMipMapNearestFilter;
		}-*/;
		public static native final int NearestMipMapLinearFilter()/*-{
		return $wnd.THREE.NearestMipMapLinearFilter;
		}-*/;
		public static native final int LinearFilter()/*-{
		return $wnd.THREE.LinearFilter;
		}-*/;
		public static native final int LinearMipMapNearestFilter()/*-{
		return $wnd.THREE.LinearMipMapNearestFilter;
		}-*/;
		public static native final int LinearMipMapLinearFilter()/*-{
		return $wnd.THREE.LinearMipMapLinearFilter;
		}-*/;
	}
	

	// GL STATE CONSTANTS

	public static final int CullFaceNone = 0;
	public static final int CullFaceBack = 1;
	public static final int CullFaceFront = 2;
	public static final int CullFaceFrontBack = 3;

	public static final int FrontFaceDirectionCW = 0;
	public static final int FrontFaceDirectionCCW = 1;

	// SHADOWING TYPES

	public static final int BasicShadowMap = 0;
	public static final int PCFShadowMap = 1;
	public static final int PCFSoftShadowMap = 2;

	// MATERIAL CONSTANTS

	// side

	public static final int FrontSide = 0;
	public static final int BackSide = 1;
	public static final int DoubleSide = 2;

	// shading

	public static final int NoShading = 0;
	public static final int FlatShading = 1;
	public static final int SmoothShading = 2;

	// colors

	public static final int NoColors = 0;
	public static final int FaceColors = 1;
	public static final int VertexColors = 2;

	// blending modes

	public static final int NoBlending = 0;
	public static final int NormalBlending = 1;
	public static final int AdditiveBlending = 2;
	public static final int SubtractiveBlending = 3;
	public static final int MultiplyBlending = 4;
	public static final int CustomBlending = 5;

	// custom blending equations
	// (numbers start from 100 not to clash with other
	//  mappings to OpenGL constants defined in Texture.js)

	public static final int AddEquation = 100;
	public static final int SubtractEquation = 101;
	public static final int ReverseSubtractEquation = 102;
	public static final int MinEquation = 103;
	public static final int MaxEquation = 104;

	// custom blending destination factors

	public static final int ZeroFactor = 200;
	public static final int OneFactor = 201;
	public static final int SrcColorFactor = 202;
	public static final int OneMinusSrcColorFactor = 203;
	public static final int SrcAlphaFactor = 204;
	public static final int OneMinusSrcAlphaFactor = 205;
	public static final int DstAlphaFactor = 206;
	public static final int OneMinusDstAlphaFactor = 207;

	// custom blending source factors

	//public static final int ZeroFactor = 200;
	//public static final int OneFactor = 201;
	//public static final int SrcAlphaFactor = 204;
	//public static final int OneMinusSrcAlphaFactor = 205;
	//public static final int DstAlphaFactor = 206;
	//public static final int OneMinusDstAlphaFactor = 207;
	public static final int DstColorFactor = 208;
	public static final int OneMinusDstColorFactor = 209;
	public static final int SrcAlphaSaturateFactor = 210;

	
	// depth modes
	public static final int NeverDepth = 0;
	public static final int AlwaysDepth = 1;
	public static final int LessDepth = 2;
	public static final int LessEqualDepth = 3;
	public static final int EqualDepth = 4;
	public static final int GreaterEqualDepth = 5;
	public static final int GreaterDepth = 6;
	public static final int NotEqualDepth = 7;
	

	// TEXTURE CONSTANTS

	public static final int MultiplyOperation = 0;
	public static final int MixOperation = 1;
	public static final int AddOperation = 2;

	// Mapping modes

	public static final int UVMapping = 300;

	public static final int CubeReflectionMapping = 301;
	public static final int CubeRefractionMapping = 302;

	public static final int EquirectangularReflectionMapping = 303;
	public static final int EquirectangularRefractionMapping = 304;

	public static final int SphericalReflectionMapping = 305;

	// Wrapping modes

	public static final int RepeatWrapping = 1000;
	public static final int ClampToEdgeWrapping = 1001;
	public static final int MirroredRepeatWrapping = 1002;

	// Filters

	public static final int NearestFilter = 1003;
	public static final int NearestMipMapNearestFilter = 1004;
	public static final int NearestMipMapLinearFilter = 1005;
	public static final int LinearFilter = 1006;
	public static final int LinearMipMapNearestFilter = 1007;
	public static final int LinearMipMapLinearFilter = 1008;

	// Data types

	public static final int UnsignedByteType = 1009;
	public static final int ByteType = 1010;
	public static final int ShortType = 1011;
	public static final int UnsignedShortType = 1012;
	public static final int IntType = 1013;
	public static final int UnsignedIntType = 1014;
	public static final int FloatType = 1015;

	// Pixel types

	//public static final int UnsignedByteType = 1009;
	public static final int UnsignedShort4444Type = 1016;
	public static final int UnsignedShort5551Type = 1017;
	public static final int UnsignedShort565Type = 1018;

	// Pixel formats

	public static final int AlphaFormat = 1019;
	public static final int RGBFormat = 1020;
	public static final int RGBAFormat = 1021;
	public static final int LuminanceFormat = 1022;
	public static final int LuminanceAlphaFormat = 1023;
	// public static final int RGBEFormat handled as public static final int RGBAFormat in shaders
	public static final int RGBEFormat = RGBAFormat; //1024;

	// DDS / ST3C Compressed texture formats

	public static final int RGB_S3TC_DXT1_Format = 2001;
	public static final int RGBA_S3TC_DXT1_Format = 2002;
	public static final int RGBA_S3TC_DXT3_Format = 2003;
	public static final int RGBA_S3TC_DXT5_Format = 2004;


	// PVRTC compressed texture formats

	public static final int RGB_PVRTC_4BPPV1_Format = 2100;
	public static final int RGB_PVRTC_2BPPV1_Format = 2101;
	public static final int RGBA_PVRTC_4BPPV1_Format = 2102;
	public static final int RGBA_PVRTC_2BPPV1_Format = 2103;
	
	

	public static final MOUSE MOUSE=new MOUSE();
	public static final class MOUSE{
		public  final int LEFT=0;
		public  final int MIDDLE=1;
		public  final int RIGHT=2;
		public static native final int LEFT()/*-{
		return $wnd.THREE.MOUSE.LEFT;
		}-*/;
		
		public static native final int MIDDLE()/*-{
		return $wnd.THREE.MOUSE.MIDDLE;
		}-*/;
		
		public static native final int RIGHT()/*-{
		return $wnd.THREE.MOUSE.RIGHT;
		}-*/;
		
	}

	public static native final MorphAnimMesh MorphAnimMesh(Geometry geometry,
			Material material) /*-{
	return new $wnd.THREE.MorphAnimMesh(geometry,material);
	}-*/;

	
	
	public static native final Face3 Face3(double a, double b, double c) /*-{
	return new $wnd.THREE.Face3(a,b,c);
	}-*/;
	
	public static final native Skeleton Skeleton(JsArray<Bone> bones,JsArray<Matrix4> boneInverses,boolean useVertexTexture)/*-{
	return new $wnd.THREE.Skeleton(bones,boneInverses,useVertexTexture);
	}-*/;
	public static final native Skeleton Skeleton(JsArray<Bone> bones)/*-{
	return new $wnd.THREE.Skeleton(bones);
	}-*/;
	
	public static final native SkeletonHelper SkeletonHelper(Object3D object)/*-{
	return new $wnd.THREE.SkeletonHelper(object);
	}-*/;
	
	public static  native final CubeTexture CubeTexture()/*-{
	return  new $wnd.THREE.CubeTexture([]);
	}-*/;
	public static  native final CubeTexture CubeTexture(JsArray<ImageElement> images,JavaScriptObject mapping, int wrapS,int  wrapT, int magFilter,int minFilter,int format,int type,int anisotropy)/*-{
	return  new $wnd.THREE.CubeTexture(images,mapping, wrapS, wrapT, magFilter, minFilter, format, type, anisotropy);
	}-*/;
	
	public static final native AudioListener AudioListener()/*-{
	return new $wnd.THREE.AudioListener();
	}-*/;
	
	public static final native Audio Audio(AudioListener listener)/*-{
	return new $wnd.THREE.Audio(listener);
	}-*/;
	
	public static  native final CompressedTextureLoader CompressedTextureLoader()/*-{
	return  new $wnd.THREE.CompressedTextureLoader();
	}-*/;
	
	public static  native final DodecahedronGeometry DodecahedronGeometry(double radius,int detail)/*-{
	return  new $wnd.THREE.DodecahedronGeometry(radius, detail);
	}-*/;
	
	public static final native Group Group()/*-{
	return new $wnd.THREE.Group();
	}-*/;
	
	public static  native final VideoTexture VideoTexture(VideoElement image,JavaScriptObject mapping, int wrapS,int  wrapT, int magFilter,int minFilter,int format,int type,int anisotropy)/*-{
	return  new $wnd.THREE.VideoTexture(image,mapping, wrapS, wrapT, magFilter, minFilter, format, type, anisotropy);
	}-*/;
	public static  native final VideoTexture VideoTexture(VideoElement image)/*-{
	return  new $wnd.THREE.VideoTexture(image);
	}-*/;
	
	
	public static native final MorphAnimation MorphAnimation(MorphAnimMesh mesh)/*-{
	return new $wnd.THREE.MorphAnimation(mesh);
	}-*/;
	
	public static native final MorphAnimation MorphAnimation(Mesh mesh)/*-{
	return new $wnd.THREE.MorphAnimation(mesh);
	}-*/;
	
	public static final native CylinderGeometry CylinderGeometry(double radiusTop,double  radiusBottom,double  height,int radialSegments,int heightSegments,boolean openEnded,double thetaStart,double thetaLength)/*-{
	return new $wnd.THREE.CylinderGeometry(radiusTop, radiusBottom, height, radialSegments, heightSegments, openEnded,thetaStart, thetaLength);
	}-*/;
	
	public static final class Tapper{
		public static final native JavaScriptObject NoTaper()/*-{
		return $wnd.THREE.TubeGeometry.NoTaper;
		}-*/;

		public static final native JavaScriptObject SinusoidalTaper()/*-{
		return $wnd.THREE.TubeGeometry.SinusoidalTaper;
		}-*/;
	}
	/**
	 * 
	 * @param path
	 * @param segments
	 * @param radius
	 * @param radialSegments
	 * @param closed
	 * @param tapper ,choice from Tapper class
	 * @return
	 */
	public static final native TubeGeometry TubeGeometry(Path path,int segments,double radius,double radialSegments,boolean closed ,JavaScriptObject tapper)/*-{
	return new $wnd.THREE.TubeGeometry(path, segments, radius, radialSegments, tapper );
	}-*/;
	
	public static  native final BinaryTextureLoader BinaryTextureLoader()/*-{
	return  new $wnd.THREE.BinaryTextureLoader();
	}-*/;
	
	public static final native PlaneBufferGeometry PlaneBufferGeometry(double width,double height,int widthSegments,int heightSegments)/*-{
	return new $wnd.THREE.PlaneBufferGeometry(width, height, widthSegments, heightSegments);
	}-*/;
	public static final native PlaneBufferGeometry PlaneBufferGeometry(double width,double height)/*-{
	return new $wnd.THREE.PlaneBufferGeometry(width, height);
	}-*/;
	
	
	/**
	 * 
	 * @param array usually ArrayBufferViewNative
	 * @param itemSize
	 * @return
	 */
	public static final native BufferAttribute BufferAttribute(JavaScriptObject array,int itemSize)/*-{
	return new $wnd.THREE.BufferAttribute(array, itemSize);
	}-*/;
	

	public static final native DynamicBufferAttribute DynamicBufferAttribute(JavaScriptObject array,int itemSize)/*-{
	return new $wnd.THREE.DynamicBufferAttribute(array, itemSize);
	}-*/;
	
	public static final native WireframeGeometry WireframeGeometry(Geometry geometry)/*-{
	return new $wnd.THREE.WireframeGeometry(geometry);
	}-*/;
	
	public static final native WireframeGeometry WireframeGeometry(BufferGeometry geometry)/*-{
	return new $wnd.THREE.WireframeGeometry(geometry);
	}-*/;
	
	public static final native EdgesGeometry EdgesGeometry(Geometry geometry,double thresholdAngle)/*-{
	return new $wnd.THREE.EdgesGeometry(geometry,thresholdAngle);
	}-*/;
	
	public static final native EdgesGeometry EdgesGeometry(BufferGeometry geometry,double thresholdAngle)/*-{
	return new $wnd.THREE.EdgesGeometry(geometry,thresholdAngle);
	}-*/;
	
	public static final native InstancedBufferAttribute InstancedBufferAttribute(JavaScriptObject array,int itemSize, int meshPerAttribute)/*-{
	return new $wnd.THREE.InstancedBufferAttribute(array,itemSize, meshPerAttribute);
	}-*/;
	
	public static  native final InstancedBufferGeometry InstancedBufferGeometry()/*-{
	return  new $wnd.THREE.InstancedBufferGeometry();
	}-*/;
	
	public static final native InstancedInterleavedBuffer InstancedInterleavedBuffer(JavaScriptObject array,int stride, int meshPerAttribute)/*-{
	return new $wnd.THREE.InstancedInterleavedBuffer(array,stride, meshPerAttribute);
	}-*/;
	
	public static final native InterleavedBuffer InterleavedBuffer(JavaScriptObject array,int stride)/*-{
	return new $wnd.THREE.InterleavedBuffer(array,stride);
	}-*/;
	
	public static final native InterleavedBufferAttribute InterleavedBufferAttribute(InterleavedBuffer buffer,int itemSize,int offset)/*-{
	return new $wnd.THREE.InterleavedBufferAttribute(buffer,itemSize,offset);
	}-*/;
	
	public static final native CatmullRomCurve3 CatmullRomCurve3(JsArray<Vector3> points)/*-{
	return new $wnd.THREE.CatmullRomCurve3(points);
	}-*/;
	
	public static final native CircleBufferGeometry CircleBufferGeometry(double radius,int segments,double thetaStart,double thetaLength)/*-{
	return new $wnd.THREE.CircleBufferGeometry(radius, segments, thetaStart, thetaLength);
	}-*/;


	
	public static final native AnimationClip AnimationClip(String name,double duration, JsArray<? extends KeyframeTrack> tracks)/*-{
	return new $wnd.THREE.AnimationClip( name, duration, tracks);
	}-*/;
	
	
	public static final native AnimationMixer AnimationMixer(JavaScriptObject root)/*-{
	return new $wnd.THREE.AnimationMixer(root);
	}-*/;
	
	
	
	public static final native PropertyBinding PropertyBinding(JavaScriptObject rootNode,String trackName )/*-{
	return new $wnd.THREE.PropertyBinding(rootNode, trackName );
	}-*/;
	
	/*
	 * key fram tracks support typeArray too
	 */
	public static final native BooleanKeyframeTrack BooleanKeyframeTrack(String name, JsArrayNumber times,JsArrayBoolean values)/*-{
	//bug fixing
	$wnd.THREE.IntepolateDiscrete=$wnd.THREE.InterpolateDiscrete;
	$wnd.THREE.BooleanKeyframeTrack.prototype.DefaultInterpolation=$wnd.THREE.InterpolateDiscrete;
	
	return new $wnd.THREE.BooleanKeyframeTrack(name, times,values );
	}-*/;
	public static final native ColorKeyframeTrack ColorKeyframeTrack(String name, JsArrayNumber times,JsArray<Color> values)/*-{
	return new $wnd.THREE.ColorKeyframeTrack(name, times,values );
	}-*/;
	public static final native ColorKeyframeTrack ColorKeyframeTrack(String name, JsArrayNumber times,JsArray<Color> values,int interpolation)/*-{
	return new $wnd.THREE.ColorKeyframeTrack(name, times,values,interpolation );
	}-*/;
	
	public static final native NumberKeyframeTrack NumberKeyframeTrack(String name, JsArrayNumber times,JsArrayNumber values)/*-{
	return new $wnd.THREE.NumberKeyframeTrack(name, times,values );
	}-*/;
	public static final native NumberKeyframeTrack NumberKeyframeTrack(String name, JsArrayNumber times,JsArrayNumber values,int interpolation)/*-{
	return new $wnd.THREE.NumberKeyframeTrack(name, times,values ,interpolation);
	}-*/;
	public static final native StringKeyframeTrack StringKeyframeTrack(String name, JsArrayNumber times,JsArrayString values)/*-{
	$wnd.THREE.IntepolateDiscrete=$wnd.THREE.InterpolateDiscrete;
	$wnd.THREE.StringKeyframeTrack.prototype.DefaultInterpolation=$wnd.THREE.InterpolateDiscrete;
	
	return new $wnd.THREE.StringKeyframeTrack(name, times,values );
	}-*/;
	public static final native StringKeyframeTrack StringKeyframeTrack(String name, JsArrayNumber times,JsArrayString values,int interpolation)/*-{
	$wnd.THREE.IntepolateDiscrete=$wnd.THREE.InterpolateDiscrete;
	$wnd.THREE.StringKeyframeTrack.prototype.DefaultInterpolation=$wnd.THREE.InterpolateDiscrete;
	
	return new $wnd.THREE.StringKeyframeTrack(name, times,values ,interpolation);
	}-*/;
	
	public static final native VectorKeyframeTrack VectorKeyframeTrack(String name, JsArrayNumber times,JsArrayNumber values)/*-{
	return new $wnd.THREE.VectorKeyframeTrack(name, times,values );
	}-*/;
	public static final native VectorKeyframeTrack VectorKeyframeTrack(String name, JsArrayNumber times,JsArrayNumber values,int interpolation)/*-{
	return new $wnd.THREE.VectorKeyframeTrack(name, times,values ,interpolation);
	}-*/;

	public static final native QuaternionKeyframeTrack QuaternionKeyframeTrack(String name, JsArrayNumber times,JsArrayNumber values)/*-{
	return new $wnd.THREE.QuaternionKeyframeTrack(name, times,values );
	}-*/;
	public static final native QuaternionKeyframeTrack QuaternionKeyframeTrack(String name, JsArrayNumber times,JsArrayNumber values,int interpolation)/*-{
	return new $wnd.THREE.QuaternionKeyframeTrack(name, times,values ,interpolation);
	}-*/;
	
	
	public static final native SphereBufferGeometry SphereBufferGeometry(double radius,int widthSegments,int heightSegments,double phiStart,double phiLength,double thetaStart,double thetaLength)/*-{
	return new $wnd.THREE.SphereBufferGeometry(radius, widthSegments, heightSegments, phiStart, phiLength, thetaStart, thetaLength);
	}-*/;
	
	public static final native SphereBufferGeometry SphereBufferGeometry(double radius,int widthSegments,int heightSegments)/*-{
	return new $wnd.THREE.SphereBufferGeometry(radius, widthSegments, heightSegments);
	}-*/;
	
	public static final native AnimationObjectGroup AnimationObjectGroup(JavaScriptObject... objects)/*-{
	return new $wnd.THREE.AnimationObjectGroup(objects);
	}-*/;
	
	public static final native PositionalAudio PositionalAudio(AudioListener listener)/*-{
	return new $wnd.THREE.PositionalAudio(listener);
	}-*/;
	
	public static final native AudioAnalyser AudioAnalyser(Audio audio,int fftSize)/*-{
	return new $wnd.THREE.AudioAnalyser(audio,fftSize);
	}-*/;
	
	public static final native StereoCamera StereoCamera()/*-{
	return new $wnd.THREE.StereoCamera();
	}-*/;
	
	public static final native CubicInterpolant CubicInterpolant(JsArrayNumber parameterPositions,JsArrayMixed sampleValues,int sampleSize,JsArrayMixed resultBuffer )/*-{
	return new $wnd.THREE.CubicInterpolant(parameterPositions, sampleValues, sampleSize, resultBuffer );
	}-*/;
	public static final native DiscreteInterpolant DiscreteInterpolant(JsArrayNumber parameterPositions,JsArrayMixed sampleValues,int sampleSize,JsArrayMixed resultBuffer )/*-{
	return new $wnd.THREE.DiscreteInterpolant(parameterPositions, sampleValues, sampleSize, resultBuffer );
	}-*/;
	public static final native LinearInterpolant LinearInterpolant(JsArrayNumber parameterPositions,JsArrayMixed sampleValues,int sampleSize,JsArrayMixed resultBuffer )/*-{
	return new $wnd.THREE.LinearInterpolant(parameterPositions, sampleValues, sampleSize, resultBuffer );
	}-*/;
	public static final native QuaternionLinearInterpolant QuaternionLinearInterpolant(JsArrayNumber parameterPositions,JsArrayMixed sampleValues,int sampleSize,JsArrayMixed resultBuffer )/*-{
	return new $wnd.THREE.QuaternionLinearInterpolant(parameterPositions, sampleValues, sampleSize, resultBuffer );
	}-*/;
	
	
	public static final native BufferAttribute Float32Attribute(int array,int itemSize)/*-{
	return new $wnd.THREE.Float32Attribute(array, itemSize );
	}-*/;
	
	public static final native BufferAttribute Int8Array(int array,int itemSize)/*-{
	return new $wnd.THREE.Int8Array(array, itemSize );
	}-*/;

public static final native BufferAttribute Uint8Array(int array,int itemSize)/*-{
	return new $wnd.THREE.Uint8Array(array, itemSize );
	}-*/;

public static final native BufferAttribute Uint8ClampedArray(int array,int itemSize)/*-{
	return new $wnd.THREE.Uint8ClampedArray(array, itemSize );
	}-*/;

public static final native BufferAttribute Int16Array(int array,int itemSize)/*-{
	return new $wnd.THREE.Int16Array(array, itemSize );
	}-*/;

public static final native BufferAttribute Uint16Array(int array,int itemSize)/*-{
	return new $wnd.THREE.Uint16Array(array, itemSize );
	}-*/;

public static final native BufferAttribute Int32Array(int array,int itemSize)/*-{
	return new $wnd.THREE.Int32Array(array, itemSize );
	}-*/;

public static final native BufferAttribute Uint32Array(int array,int itemSize)/*-{
	return new $wnd.THREE.Uint32Array(array, itemSize );
	}-*/;

public static final native BufferAttribute Float64Array(int array,int itemSize)/*-{
	return new $wnd.THREE.Float64Array(array, itemSize );
	}-*/;
public static final native Shape Shape(JsArray<Vector2> array)/*-{
return new $wnd.THREE.Shape(array);
}-*/; 
public static final native ExtrudeGeometry ExtrudeGeometry(Shape shape,ExtrudeGeometryParameter options)/*-{
return new $wnd.THREE.ExtrudeGeometry(shape,options);
}-*/;


}
