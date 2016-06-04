package com.jsikora;

import java.util.ArrayList;
import java.util.UUID;

public class DataRandom {

    public static ArrayList<Login> prepareData() {
    	
        int loginsNumber = 100;   
        ArrayList<Login> result = new ArrayList<Login>();
        
		for (int j = 0; j < loginsNumber; j++) {
        	String randomLogin = UUID.randomUUID().toString();
        	String randomPassword = UUID.randomUUID().toString();
        	Login newLogin = new Login(randomLogin, randomPassword);
        	result.add(newLogin);
        }
        
        return result;
    }
}
