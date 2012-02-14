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

	protected int positionZ=100;
	protected int positionX;
	protected int positionY;
	
	public int getPositionZ() {
		return positionZ;
	}

	public void setPositionZ(int positionZ) {
		this.positionZ = positionZ;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
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
