package com.akjava.gwt.three.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CameraMoveWidget extends Composite {

	private static CameraMoveWidgetUiBinder uiBinder = GWT.create(CameraMoveWidgetUiBinder.class);

	interface CameraMoveWidgetUiBinder extends UiBinder<Widget, CameraMoveWidget> {
	}

	public CameraMoveWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		reset();
	}
@UiField Label xl,xv,yl,yv,zl,zv;
@UiField Button foward,left,reset,right,back,up,down;

	
public Label getXl(){
return xl;
}

public Label getXv(){
return xv;
}

public Label getYl(){
return yl;
}

public Label getYv(){
return yv;
}

public Label getZl(){
return zl;
}

public Label getZv(){
return zv;
}

public Button getFoward(){
return foward;
}

public Button getLeft(){
return left;
}

public Button getReset(){
return reset;
}

public Button getRight(){
return right;
}

public Button getBack(){
return back;
}

public Button getUp(){
return up;
}

public Button getDown(){
return down;
}

int x,y,z;
	
public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
	update();
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
	update();
}

public int getZ() {
	return z;
}

public void setZ(int z) {
	this.z = z;
	update();
}

@UiHandler("foward")
void clickFoward(ClickEvent e) {
	z-=increment;
	update();
}
@UiHandler("left")
void clickLeft(ClickEvent e) {
	x-=increment;
	update();
}
@UiHandler("reset")
void clickReset(ClickEvent e) {
reset();
}
private void reset(){
	x=0;
	y=0;
	z=50;
	update();
}
@UiHandler("right")
void clickRight(ClickEvent e) {
	x+=increment;
	update();
}
@UiHandler("back")
void clickBack(ClickEvent e) {
	z+=increment;
	update();
}
@UiHandler("up")
void clickUp(ClickEvent e) {
y+=increment;
update();
}
@UiHandler("down")
void clickDown(ClickEvent e) {
	y-=increment;
	update();
}

int increment=5;
private void update(){
	zv.setText(""+z);
	xv.setText(""+x);
	yv.setText(""+y);
}


}
