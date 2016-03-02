package com.jsikora;

import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClassLoader extends URLClassLoader{

	public DynamicClassLoader(URL[] urls) {
		super(urls);
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		if (name.contains("MessageZ")) {
			return findClass(name);
		}
		return super.loadClass(name);
	}
		
}
