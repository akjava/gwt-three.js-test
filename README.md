#GWTWrapper for Three.js
##Demo
[Three.js Example ports](http://akjava.github.io/gwt-three.js-test/threejsexamples.html) - same as original example,but not complete

[Old one](http://akjava.github.io/gwt-three.js-test/ThreeTest.html) - but some original demo include
##What is GWT.Why GWT?
<a href="http://www.gwtproject.org/">GWT</a> is one of altJS language written with Java ,developed by Google(until version 2.5.1).  
This is not so popular as other altJS language,but really good at integrate with GAE/Java.

I like Java,Guava-Library and have almost 6 years experience with GWT.  
My java script knowledge is really poor,especially scope and constructing class.

That's why I'm still use Java/GWT.


If you are not familiar with GWT or GoogleAppEngine/Java,you should choice <a href="https://github.com/threeDart/three.dart">dart</a> or <a href="https://github.com/borisyankov/DefinitelyTyped/tree/master/threejs">typescript</a>.  
many people use that.

##Status
developed based Three.js `Rev70` for GWT 2.5.1/2.6(not JSInterop)

I can say this is `ALPHA` version.  
There are still so many bugs.when each time I port a example,I found many critical bugs.

###Plan
port most of webgl demo(not canvas,svg)

##Possible bugs
**wrong type** - sometime I miss understand type.I'm going to compare typescript's "three.d.ts" file soon.
