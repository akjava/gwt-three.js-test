package com.akjava.gwt.three.client.java.file;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * TODO move three test
 * @author aki
 *
 */
public class MorphtargetsModifier {
private Map<String,Double> modifier;

public MorphtargetsModifier(){
	this(new HashMap<String, Double>());
}
public MorphtargetsModifier(Map<String, Double> modifier) {
	super();
	this.modifier = modifier;
}

public Set<String> keySet(){
	return modifier.keySet();
}

public boolean containsKey(String key){
	return modifier.containsKey(key);
}

/**
 * @param key
 * @return possible null
 */
public Double get(String key){
	return modifier.get(key);
}

public void remove(String key){
	modifier.remove(key);
}

public void set(String key,double value){
	modifier.put(key, value);
}

public double getModifiedValue(String key,double value){
	double mod=get(key)!=null?get(key):1;
	return mod*value;
}

}
