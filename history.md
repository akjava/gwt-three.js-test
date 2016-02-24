#Change History
##for three.js r71
###Audio
support autoplay parameter,play(), pause(), stop() and setVolume()
###BufferGeometry
support center()
###Cache
all method convert to static
###Color
add array and offset arg to toArray()
###DynamicBufferAttribute
create new class
###Euler
add array and offset arg to toArray()
###EdgesHelper
add thresholdAngle on constructor
###Line
Return index in raycast()
###Material
Added blendSrcAlpha, blendDstAlpha and blendEquationAlpha
removed ambient from MeshPhongMaterial and MeshLambertMaterial
###Math
Added nextPowerOfTwo()
###MeshNormalMaterial
Removed shading

###Object3D
Removed recursive arg from getObjectBy*(). 
Added renderOrder field
###PointLight,SpotLight
added Decay
###Texture
Added sourceFile
###Vector2,Vector3,Vector4
Added lerpVectors(). 
Added subScalar().
###WebGLRenderer
add readRenderTargetPixels(),gammaFactor


##for three.js r70
possible warning/erros

###core
####BufferGeometry
 add add merge: function ( geometry, offset )
###Geometry
 add mergeMesh: function ( mesh )
###Object3D
 remove this.renderDepth
 
 add getObjectByProperty: function ( name, value, recursive )
 
 add traverseAncestors: function ( callback )
###Raycaster
 add setFromCamera: function ( coords, camera )
###extras-animation
###MorphAnimation
 add this.lastFrame
 
 add this.currentFrame
###extras-geometries
####CylinderGeometry
 add thetaStart, thetaLength on constructor
####TubeGeometry
 add tapper on constructor
 
 add THREE.TubeGeometry.NoTaper,THREE.TubeGeometry.SinusoidalTaper
###math
####Euler
 add setFromRotationMatrix: function ( m, order, update )
 
 add toVector3: function ( optionalResult ) 
####Matrix4
 add extractBasis: function ( xAxis, yAxis, zAxis )
####Vector2,3,4 
 add fromAttribute: function ( attribute, index, offset )
###objects
####PointCloud
 remove this.sortParticles
###renderers
####WebGLRenderer
 add this.pixelRatio
 
 add getPixelRatio();