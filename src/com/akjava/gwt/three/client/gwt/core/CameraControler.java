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

	public void incrementRotationX(double x){
		rotattionX+=x;
		if(rotattionX>180){
			rotattionX=-180+(rotattionX-180);
		}
		if(rotattionX<180){
			rotattionX=180+(rotattionX+180);
		}
	}
	public void incrementRotationY(double y){
		rotattionY+=y;
		if(rotattionY>180){
			rotattionY=-180+(rotattionY-180);
		}
		if(rotattionY<180){
			rotattionY=180+(rotattionY+180);
		}
	}
	
	public double getRagiantRotattionZ() {
		return Math.toRadians(rotattionZ);
	}
	public double getRagiantRotattionY() {
		return Math.toRadians(rotattionY);
	}
	public double getRagiantRotattionX() {
		return Math.toRadians(rotattionX);
	}
	
	public double getRotattionZ() {
		return rotattionZ;
	}

	public void setRotattionZ(double rotattionZ) {
		this.rotattionZ = rotattionZ;
	}

	public double getRotattionX() {
		return rotattionX;
	}

	public void setRotattionX(double rotattionX) {
		this.rotattionX = rotattionX;
	}

	public double getRotattionY() {
		return rotattionY;
	}

	public void setRotattionY(double rotattionY) {
		this.rotattionY = rotattionY;
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
	
	protected double rotattionZ;
	protected double rotattionX;
	protected double rotattionY;
	
	public double getPositionZ() {
		return positionZ;
	}

	public void setPositionZ(double positionZ) {
		this.positionZ = positionZ;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
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
