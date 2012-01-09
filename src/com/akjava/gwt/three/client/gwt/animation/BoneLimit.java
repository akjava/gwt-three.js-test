package com.akjava.gwt.three.client.gwt.animation;

public class BoneLimit {
public double getMinX() {
		return minX;
	}

	public void setMinX(double minX) {
		this.minX = minX;
	}

	public double getMinY() {
		return minY;
	}

	public void setMinY(double minY) {
		this.minY = minY;
	}

	public double getMinZ() {
		return minZ;
	}

	public void setMinZ(double minZ) {
		this.minZ = minZ;
	}

	public double getMaxX() {
		return maxX;
	}

	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}

	public double getMaxY() {
		return maxY;
	}

	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}

	public double getMaxZ() {
		return maxZ;
	}

	public void setMaxZ(double maxZ) {
		this.maxZ = maxZ;
	}

	public static BoneLimit createBoneLimit(double mx,double xx,double my,double xy,double mz,double xz){
		BoneLimit limit=new BoneLimit();
		limit.setMinX(mx);
		limit.setMaxX(xx);
		limit.setMinY(my);
		limit.setMaxY(xy);
		limit.setMinZ(mz);
		limit.setMaxZ(xz);
		return limit;
	}
private double minX,minY,minZ,maxX,maxY,maxZ;
}
