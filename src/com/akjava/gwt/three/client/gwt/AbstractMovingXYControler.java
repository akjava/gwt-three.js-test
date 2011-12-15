package com.akjava.gwt.three.client.gwt;

import java.util.List;

import com.akjava.gwt.lib.client.LogUtils;

public abstract class AbstractMovingXYControler {
	protected long duration;
	protected long total;
	protected boolean moving;
	protected List<Point> points;

	

public AbstractMovingXYControler(List<Point> points,long duration){
	this.points=points;
	this.duration=duration;
	moving=true;
}


public long getDuration() {
	return duration;
}


public void setDuration(long duration) {
	this.duration = duration;
}


public long getTotal() {
	return total;
}


public void setTotal(long total) {
	this.total = total;
}


public boolean isMoving() {
	return moving;
}


public void setMoving(boolean moving) {
	this.moving = moving;
}


public List<Point> getPoints() {
	return points;
}


public void setPoints(List<Point> points) {
	this.points = points;
}

public abstract void moveEnd();
public abstract void moveTo(double x,double y);

public void update(long delta){
if(!moving){
	return;
}
total+=delta;
if(total<duration){
	Point pt=Spline.get2DPoint(points, (double)total/duration);
	LogUtils.log(pt);
	moveTo(pt.getX(),pt.getY());
}else{
	moving=false;
	moveEnd();
}

}

}
