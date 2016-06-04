package com.jsikora;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Externalizable extends Serialize{
	
	@Override
	void writeObject(Object object) throws FileNotFoundException, IOException
	{
		Login login = (Login) object;
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Ext_" + FILE_NAME));
		os.writeObject(login);
		os.close();
	}

	@Override
	Object readObject() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Login login;
		ObjectInputStream is = new ObjectInputStream(new FileInputStream("Ext_" + FILE_NAME));
		login = (Login) is.readObject();
		is.close();
		return login;
	}
}
