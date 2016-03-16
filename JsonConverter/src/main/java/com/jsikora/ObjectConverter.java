package com.jsikora;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class ObjectConverter {
	
	public String convertArray(Object array){
		
		StringBuilder arrayString = new StringBuilder();
		
		arrayString.append(" [\n");
		
		for(int i=0; i<Array.getLength(array); i++){
			
			Object aValue = Array.get(array, i);
			arrayString.append("\t\t\"" + aValue + "\"");
			
			if(i != Array.getLength(array) - 1)
				arrayString.append(",");
			
			arrayString.append("\n");
		}
		
		arrayString.append("\t]");
		
		return arrayString.toString();
	}
	
	public void createJsonFromObject(Object object) throws IOException, IllegalArgumentException, IllegalAccessException{
		
		StringBuilder jsonString = new StringBuilder();
		String fName;
		Object fValue;
		Class<?> fType;
		
		Field[] classFields = object.getClass().getDeclaredFields();
		
		jsonString.append("{\"" + object.getClass().getSimpleName() + "\": {\n");
		
		for(int i=0; i<classFields.length; i++){
			
			classFields[i].setAccessible(true);
			fValue = classFields[i].get(object);
			fName = classFields[i].getName();
			fType = classFields[i].getType();
			
			jsonString.append("\t\"" + fName + "\":");
				
			if(fType.isArray()){
				jsonString.append(convertArray(fValue));
			}
			else{
				jsonString.append(" \"" + fValue + "\"");
			}
			
			if(i != classFields.length - 1)
				jsonString.append(",");
				
			jsonString.append("\n");
			
		}
		
		jsonString.append("}}");
		
		Writer writer = new BufferedWriter(
						new OutputStreamWriter(
						new FileOutputStream("Person_myconverter.json"), "utf-8"));
		
		writer.write(jsonString.toString());
		writer.close();
	}
}
