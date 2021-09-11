package com.java8.json.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Reading and Writing Using ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		Car car = new Car("yellow", "renault");
		objectMapper.writeValue(new File("src/main/resources/car.json"), car);
		
		String carAsString = objectMapper.writeValueAsString(car);
		
		System.out.println(carAsString);
		
		// 2. JSON to Java Object
		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		Car car2 = objectMapper.readValue(json, Car.class);
		
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		
		System.out.println(objectMapper.writeValueAsString(list));
		
		JSONArray jsonArray = new JSONArray("[\"one\",\"two\"]");
		System.out.println(jsonArray);
		
		Car car22 = objectMapper.readValue(new File("target/car.json"), Car.class);
		System.out.println(car22.getType());
		
		// 3. Creating a Java List From a JSON Array String
		String jsonCarArray = 
				  "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
				List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});	
				
		System.out.println("listCar.size = " + listCar.size());
		
		// 4. Creating a Java Map From a JSON Array String		
		
		String jsonStr = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		Map<String, Object> map 
		  = objectMapper.readValue(jsonStr, new TypeReference<Map<String,Object>>(){});
		
		
	}

}

class Car {

    private String color;
    private String type;
    
    
    
	/**
	 * @param color
	 * @param type
	 */
	public Car(String color, String type) {
		super();
		this.color = color;
		this.type = type;
	}
	
	public Car() {
		
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}