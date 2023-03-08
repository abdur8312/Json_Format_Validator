package com.abdur8312.demo.Validator;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Validator {

	public static boolean isValid(String json) {
		
		boolean retValue = true;
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
		JsonFactory factory = mapper.getFactory();
		JsonParser parser;
		try {
			parser = factory.createParser(json);
			JsonNode node = mapper.readTree(parser);
		} catch (Exception e) {
			retValue = false;
		}
		return retValue;
		
	}
	
}
