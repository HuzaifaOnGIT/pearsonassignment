package com.pearson.storey.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pearson.storey.model.Store;
import com.pearson.storey.service.StoreService;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StoreControllerTest {
	
	@MockBean
	private StoreService service;
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void testGetStoreById() throws UnsupportedEncodingException, Exception {
		
		Store store =new Store();
		store.setCity("abc");
		store.setPostCode("dfsr555");
		store.setStoreId("12");
		
		when(service.getStoreById(Mockito.anyString())).thenReturn(store);
		
		String contentAsString = mockMvc.perform(get("/12").contentType(MediaType.APPLICATION_JSON_VALUE).content(mapper.writeValueAsBytes(store)))
		.andExpect(status().isFound()).andReturn().getResponse().getContentAsString();
		
		assertEquals(mapper.writeValueAsString(store),contentAsString);
	}

	@Test
	void testFetchAllStoreDetails() throws JsonProcessingException, UnsupportedEncodingException, Exception {
		
		List<Store> list = new ArrayList<>();
		
		Store store =new Store();
		store.setCity("abc");
		store.setPostCode("dfsr555");
		store.setStoreId("12");
		list.add(store);
		
		when(service.fetchAllStores(Mockito.anyString())).thenReturn(list);
		
		String contentAsString = mockMvc.perform(get("/fetch/city").contentType(MediaType.APPLICATION_JSON_VALUE).content(mapper.writeValueAsString(store)))
		.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		
		assertEquals(mapper.writeValueAsString(list),contentAsString);
	}

}
