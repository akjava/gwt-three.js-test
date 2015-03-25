package com.akjava.gwt.threejsexamples.client;

import com.google.gwt.animation.client.AnimationScheduler.AnimationCallback;
import com.google.gwt.user.client.ui.Panel;

public interface Example extends AnimationCallback{
public void start(Panel parent);
public void stop();
public String getName();
public String getTokenKey();
}
