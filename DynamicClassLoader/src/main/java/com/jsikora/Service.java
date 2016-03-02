package com.jsikora;

import java.net.URL;
import java.net.URLClassLoader;

public class Service {

public static MessageInter newInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
	/*
		URL classUrl;
		classUrl = new URL("http://localhost:4567/hello");
		URL[] urls = { classUrl };
	*/
	
		URL[] urls = ((URLClassLoader)ClassLoader.getSystemClassLoader()).getURLs();
		
		ClassLoader myCL = new DynamicClassLoader(urls);
		
		return (MessageInter) myCL.loadClass("com.jsikora.MessageZ").newInstance();
	}

}
