package com.akjava.gwt.three.client.gwt.core;


public class CameraControler {

	private long mouseLast;
	private double tmpZoom;

	protected int defaultZoomIncrement=3;
	protected int minCameraZ=5;
	protected int maxCameraZ=4000;
	public int getDefaultZoomIncrement() {
		return defaultZoomIncrement;
	}

	public void setPositions(double x,double y,double z){
		setPositionX(x);
		setPositionY(y);
		setPositionZ(z);
	}
	
	public void setRotations(double x,double y,double z){
		setRotationX(x);
		setRotationY(y);
		setRotationZ(z);
	}
	
	public void incrementRotationX(double x){
		rotationX+=x;
		if(rotationX>180){
			rotationX=-180+(rotationX-180);
		}
		if(rotationX<180){
			rotationX=180+(rotationX+180);
		}
	}
	public void incrementRotationY(double y){
		rotationY+=y;
		if(rotationY>180){
			rotationY=-180+(rotationY-180);
		}
		if(rotationY<180){
			rotationY=180+(rotationY+180);
		}
	}
	
	public double getRadiantRotationZ() {
		return Math.toRadians(rotationZ);
	}
	public double getRadiantRotationY() {
		return Math.toRadians(rotationY);
	}
	public double getRadiantRotationX() {
		return Math.toRadians(rotationX);
	}
	
	public double getRotationZ() {
		return rotationZ;
	}

	public void setRotationZ(double rotattionZ) {
		this.rotationZ = rotattionZ;
	}

	public double getRotationX() {
		return rotationX;
	}

	public void setRotationX(double rotattionX) {
		this.rotationX = rotattionX;
	}

	public double getRotationY() {
		return rotationY;
	}

	public void setRotationY(double rotattionY) {
		this.rotationY = rotattionY;
	}

	public void setDefaultZoomIncrement(int defaultZoomIncrement) {
		this.defaultZoomIncrement = defaultZoomIncrement;
	}

	public int getMinCameraZ() {
		return minCameraZ;
	}

	public void setMinCameraZ(int minCameraZ) {
		this.minCameraZ = minCameraZ;
	}

	public int getMaxCameraZ() {
		return maxCameraZ;
	}

	public void setMaxCameraZ(int maxCameraZ) {
		this.maxCameraZ = maxCameraZ;
	}

	protected double positionZ=100;
	protected double positionX;
	protected double positionY;
	
	protected double rotationZ;
	protected double rotationX;
	protected double rotationY;
	
	public double getPositionZ() {
		return positionZ;
	}

	public void setPositionZ(double positionZ) {
		this.positionZ = positionZ;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public void doMouseWheel(int deltaY){
				long t=System.currentTimeMillis();
				if(mouseLast+50>t){
					tmpZoom*=1.2;
				}else{
					tmpZoom=defaultZoomIncrement;
				}
				
				int tmp=(int)(positionZ+deltaY*tmpZoom);
				tmp=Math.min(maxCameraZ, tmp);
				tmp=Math.max(minCameraZ, tmp);
				positionZ=tmp;
				mouseLast=t;
	}
}
