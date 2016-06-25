package com.akjava.gwt.three.client.java.ui.example;

import com.google.gwt.animation.client.AnimationScheduler.AnimationCallback;
import com.google.gwt.user.client.ui.Panel;

public interface Example extends AnimationCallback,Comparable<Example>{
public void start(Panel parent);
public void stop();
public String getName();
public String getTokenKey();
}
