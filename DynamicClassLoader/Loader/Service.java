package jsikora;

import java.net.URL;
import java.net.URLClassLoader;

public class Service {

	public static MessageInter newInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		URL[] urls = ((URLClassLoader)ClassLoader.getSystemClassLoader()).getURLs();
		
		ClassLoader myCL = new DynamicClassLoader(urls);
		
		return (MessageInter) myCL.loadClass("jsikora.MessageZ").newInstance();
	}

}
