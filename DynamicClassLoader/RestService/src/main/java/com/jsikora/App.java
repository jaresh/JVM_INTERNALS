package com.jsikora;

import static spark.Spark.*;
import spark.Spark;

public class App 
{
    	public static void main(String[] args) {
    		Spark.staticFileLocation("/public");
    		get("/hello", (request, responce) -> "Hello world");
    	}
}
