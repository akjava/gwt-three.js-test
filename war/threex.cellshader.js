// define namespaces
var THREEx		= THREEx || {};
THREEx.ShaderLib	= THREEx.ShaderLib	|| {};
THREEx.UniformsLib	= THREEx.UniformsLib	|| {};

// cel shader from ro.me - http://www.ro.me/tech/cel-shader - Apache License 2.0
/*
 * original is 
 * http://learningthreejs.com/data/THREEx/docs/THREEx.CelShader.html
 * 
 * modified
 * objectMatrix  renamed to modelMatrix for r49
 * https://github.com/mrdoob/three.js/wiki/Migration
 * 
 * Not support skinning
 * 
 * by aki miyazaki
 * 
 */
THREEx.UniformsLib['cel']	= {
      "uDirLightPos"		: { type: "v3", value: new THREE.Vector3(1,0,0) },
      "uDirLightColor"		: { type: "c" , value: new THREE.Color( 0xeeeeee ) },
      "uAmbientLightColor"	: { type: "c" , value: new THREE.Color( 0x050505 ) },
      "uBaseColor"		: { type: "c" , value: new THREE.Color( 0xff0000 ) }
};

THREEx.ShaderLib['cel']	= {
	vertexShader:	[
		"varying vec3 vNormal;",
		"varying vec3 vRefract;",
		
		"void main() {",
		
			"vec4 mPosition = modelMatrix * vec4( position, 1.0 );",
			"vec4 mvPosition = modelViewMatrix * vec4( position, 1.0 );",
			"vec3 nWorld = normalize ( mat3( modelMatrix[0].xyz, modelMatrix[1].xyz, modelMatrix[2].xyz ) * normal );",
		      
			"vNormal = normalize( normalMatrix * normal );",
		      
			"vec3 I = mPosition.xyz - cameraPosition;",
			"vRefract = refract( normalize( I ), nWorld, 1.02 );",
		      
			"gl_Position = projectionMatrix * mvPosition;",
		
		"}"		
	].join( "\n" ),
	fragmentShader: [
		"uniform vec3 uBaseColor;",
		
		"uniform vec3 uDirLightPos;",
		"uniform vec3 uDirLightColor;",
		
		"uniform vec3 uAmbientLightColor;",
		
		"varying vec3 vNormal;",
		
		"varying vec3 vRefract;",
		
		"void main() {",
		
			"float directionalLightWeighting = max( dot( normalize( vNormal ), uDirLightPos ), 0.0);",
			"vec3 lightWeighting = uAmbientLightColor + uDirLightColor * directionalLightWeighting;",
		      
			"float intensity = smoothstep( - 0.5, 1.0, pow( length(lightWeighting), 20.0 ) );",
			"intensity += length(lightWeighting) * 0.2;",
		      
			"float cameraWeighting = dot( normalize( vNormal ), vRefract );",
			"intensity += pow( 1.0 - length( cameraWeighting ), 6.0 );",
			"intensity = intensity * 0.2 + 0.3;",
		      
			"if ( intensity < 0.50 ) {",
		      
			  "gl_FragColor = vec4( 2.0 * intensity * uBaseColor, 1.0 );",
		      
			"} else {",
		      
			  "gl_FragColor = vec4( 1.0 - 2.0 * ( 1.0 - intensity ) * ( 1.0 - uBaseColor ), 1.0 );",
		      
			"}",
		
		"}"		
	].join( "\n" )
};