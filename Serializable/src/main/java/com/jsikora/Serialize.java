package com.jsikora;

import java.io.FileNotFoundException;
import java.io.IOException;


public abstract class Serialize {
	
	String FILE_NAME = "serialized.object";

	abstract void writeObject(Object object) throws FileNotFoundException, IOException;
	abstract Object readObject() throws FileNotFoundException, IOException, ClassNotFoundException;
	
}
