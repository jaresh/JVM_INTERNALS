package com.jsikora;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializable extends Serialize{

	@Override
	void writeObject(Object object) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
    	out.writeObject(object);
    	out.close();	
	}

	@Override
	Object readObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
	    Object result = in.readObject();
	    in.close();
	    return result;
	}
}
