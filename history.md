#Change History
##for three.js r70
possible warning/erros

###core
####BufferGeometry
 + add merge: function ( geometry, offset )
###Geometry
 + mergeMesh: function ( mesh )
###Object3D
 - this.renderDepth
 + getObjectByProperty: function ( name, value, recursive )
 + traverseAncestors: function ( callback )
###Raycaster
 + setFromCamera: function ( coords, camera )
###extras-animation
###MorphAnimation
 + this.lastFrame
 + this.currentFrame
###extras-geometries
####CylinderGeometry
 + thetaStart, thetaLength on constructor
####TubeGeometry
 + tapper on constructor
 + THREE.TubeGeometry.NoTaper,THREE.TubeGeometry.SinusoidalTaper
###math
####Euler
 + setFromRotationMatrix: function ( m, order, update )
 + toVector3: function ( optionalResult ) 
####Matrix4
 + extractBasis: function ( xAxis, yAxis, zAxis )
####Vector2,3,4 
 + fromAttribute: function ( attribute, index, offset )
###objects
####PointCloud
 - this.sortParticles
###renderers
####WebGLRenderer
 + this.pixelRatio
 + getPixelRatio();