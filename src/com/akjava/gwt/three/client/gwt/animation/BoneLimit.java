package com.akjava.gwt.three.client.gwt.animation;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.core.Vector3;

public class BoneLimit {
public final static double MAX=Math.toRadians(180);
public final static double MIN=Math.toRadians(-180);
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

	public static BoneLimit createBoneLimit(double minx,double maxx,double miny,double maxy,double minz,double maxz){
		BoneLimit limit=new BoneLimit();
		
		limit.setMinX(Math.toRadians(minx));
		limit.setMaxX(Math.toRadians(maxx));
		limit.setMinY(Math.toRadians(miny));
		limit.setMaxY(Math.toRadians(maxy));
		limit.setMinZ(Math.toRadians(minz));
		limit.setMaxZ(Math.toRadians(maxz));
		return limit;
	}
private double minX,minY,minZ,maxX,maxY,maxZ;
public void apply(Vector3 angles) {
	if(angles.getX()<minX){
		angles.setX(minX);
	}
	else if(angles.getX()>maxX){
		angles.setX(maxX);
	}
	
	
	
	if(angles.getY()<minY){
		angles.setY(minY);
	}
	else if(angles.getY()>maxY){
		angles.setY(maxY);
	}
	
	if(angles.getZ()<minZ){
		angles.setZ(minZ);
	}
	else if(angles.getZ()>maxZ){
		angles.setZ(maxZ);
	}
	
	
	if("NaN".equals(""+angles.getX())){
		angles.setX(0);
		LogUtils.log("Nan-x");
	}
	if("NaN".equals(""+angles.getY())){
		angles.setY(0);
	}
	if("NaN".equals(""+angles.getZ())){
		angles.setZ(0);
	}
	}

}
