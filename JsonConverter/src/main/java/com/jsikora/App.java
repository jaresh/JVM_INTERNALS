package com.jsikora;

import java.io.IOException;

import com.jsikora.ObjectConverter;
import com.jsikora.Person;

public class App 
{	
    public static void main( String[] args ) throws IOException, IllegalArgumentException, IllegalAccessException 
    {
    	ObjectConverter converter = new ObjectConverter();
    	Person person = new Person();
    	
    	converter.createJsonFromObject(person);
    }
}
