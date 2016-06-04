package com.jsikora;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class App 
{
	
	public static void testSerializers(ArrayList<Serialize> serializators, ArrayList<Login> logins, int numberOfTests) throws FileNotFoundException, IOException, ClassNotFoundException {
        for (Serialize serializator : serializators) {
        	
        	double timeAvg = 0;
            
        	for (Object login : logins) {
                double time = 0;
                for (int i = 0; i < numberOfTests; i++) {
                	long startTime = System.currentTimeMillis();
                    serializator.writeObject(login);
                    serializator.readObject();
                    long stopTime = System.currentTimeMillis();
                    long elapsedTime = stopTime - startTime;
                    time += elapsedTime;
                }
                timeAvg = time / numberOfTests;
            }
        	
            System.out.println(serializator.getClass().toString() + " Processing time : " + timeAvg);
        }
    }
	
	
    public static void main( String[] args ) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        int numberOfTests = 100;
    	ArrayList<Login> logins = new ArrayList<Login>();
    	ArrayList<Serialize> serializators = new ArrayList<Serialize>();
    	
    	logins = DataRandom.prepareData();

    	serializators.add(new Serializable());
    	serializators.add(new Externalizable());
        serializators.add(new JacksonSerialize());
        
        testSerializers(serializators,logins,numberOfTests);
    }

}
