#Change History
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