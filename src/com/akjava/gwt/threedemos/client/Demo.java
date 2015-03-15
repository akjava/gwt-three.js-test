package com.akjava.gwt.threedemos.client;

import com.google.gwt.animation.client.AnimationScheduler.AnimationCallback;
import com.google.gwt.user.client.ui.Panel;

public interface Demo extends AnimationCallback{
public void start(Panel parent);
public void stop();
public String getName();
}
