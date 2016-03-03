package jsikora;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

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

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] bytes = null;
		try {
			bytes = loadClassData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Class<?> result = defineClass(name, bytes, 0, bytes.length);
		return result;
	}

	private byte[] loadClassData() throws IOException {
		URLConnection connection = new URL("http://localhost:4567/MessageZ.class").openConnection();
		InputStream input = connection.getInputStream();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int data = input.read();
	
		while (data != -1) {
			buffer.write(data);
			data = input.read();
		}

		input.close();

		return buffer.toByteArray();
	}
		
}
