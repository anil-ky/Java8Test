package com.tutorials.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		String jsonSource = "{\"title\" : \"Basics\" }";
		JsonNode node = Json.parse(jsonSource);
		
		System.out.println(node.get("title"));
	}
	
}
