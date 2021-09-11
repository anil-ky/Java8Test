package com.java8.json.test;

import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) throws IOException {

		String exception = "400 Bad Request: [{\"code\": 60200, \"message\": \"Invalid parameter\", \"more_info\": \"https://www.twilio.com/docs/errors/60200\", \"status\": 400}]";

		JSONTokener jt = new JSONTokener(exception);
		//jt.nextString(":");
		
		String message = jt.nextTo(":");
		String message2 = (String)jt.nextValue();
		System.out.println(message);
		System.out.println(message2);
		
		/*
		 * while(jt.more()) { System.out.println(jt.next()); }
		 */
		
        //String message = (String) jsonRootNode.get("message");
        
        //System.out.println(message);
	
	}


}
