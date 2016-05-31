package com.akjava.gwt.threetest.client;

import com.akjava.gwt.three.client.java.MeshBasicMaterialBuilder;
import com.akjava.gwt.three.client.java.MeshLambertMaterialBuilder;
import com.akjava.gwt.three.client.java.ParticleBasicMaterialBuilder;

public class THREEDep {
	public static  final MeshBasicMaterialBuilder MeshBasicMaterial(){
		return MeshBasicMaterialBuilder.create();
	}
	public static  final MeshLambertMaterialBuilder MeshLambertMaterial(){
		return MeshLambertMaterialBuilder.create();
	}
	public static  final ParticleBasicMaterialBuilder ParticleBasicMaterial(){
		return ParticleBasicMaterialBuilder.create();
	}
}
