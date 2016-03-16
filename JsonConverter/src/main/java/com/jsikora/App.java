package com.jsikora;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{	
    public static void main( String[] args ) throws IOException, IllegalArgumentException, IllegalAccessException 
    {
    	ObjectConverter converter = new ObjectConverter();
    	ObjectMapper mapper = new ObjectMapper();
    	
    	Person person = new Person();
    	
    	long startTime = System.nanoTime();    
    	mapper.writeValue(new File("Person_jackson.json"), person);
    	long jacksonEstimatedTime = System.nanoTime() - startTime;
    	
    	startTime = System.nanoTime(); 
    	converter.createJsonFromObject(person);
    	long myEstimatedTime = System.nanoTime() - startTime;
    	
    	System.out.println("Jackson convert time: " + jacksonEstimatedTime);
    	System.out.println("My convert time: " + myEstimatedTime);
    }
}
