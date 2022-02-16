package com.pearson.storey.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class StoreTest {

	String json ="{\"storeId\":null,\"postCode\":\"dfsr555\",\"city\":\"abc\",\"address\":null,\"openedDate\":null}";
	
	ObjectMapper  mapper = new ObjectMapper();
	
	@Test
	void serializationTest() throws JsonProcessingException {
		
		Store store =new Store();
		store.setCity("abc");
		store.setPostCode("dfsr555");
		
//		System.out.println(mapper.writeValueAsString(store));
		
		Store readValue = mapper.readValue(json,Store.class);
		
		assertEquals(json,mapper.writeValueAsString(readValue));
	}
	
	@Test
	void deserializationTest() throws JsonMappingException, JsonProcessingException {
		
		Store readValue = mapper.readValue(json, Store.class);
		
		assertEquals(json, mapper.writeValueAsString(readValue));
	}

}
