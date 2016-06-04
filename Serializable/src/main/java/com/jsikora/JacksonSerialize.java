package com.jsikora;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerialize extends Serialize{

	@Override
	void writeObject(Object object) throws FileNotFoundException, IOException {
		Login login = (Login) object;
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("result.json"), login);
	}

	@Override
	Object readObject() throws FileNotFoundException, IOException,ClassNotFoundException {
		ObjectMapper mapper = new ObjectMapper();
		Login login = new Login();
		login = mapper.readValue(new File("result.json"), Login.class);
		return login;
	}

}
