package com.pearson.storey.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.opencsv.CSVReader;
import com.pearson.storey.model.Store;


@ExtendWith(MockitoExtension.class)
class StoreServiceImplementationTest {
	
	CSVReader reader;

	@InjectMocks
	private StoreServiceImplementation service;
	
	public StoreServiceImplementationTest() {
		reader = mock(CSVReader.class);
	}
	
	
	@Test
	void testGetStoreById() {
		Store store =new Store();
		store.setStoreId("1525eec4-7bed-4597-bf5a-e06fcede5f4f");
		store.setCity("abc");
		store.setPostCode("dfsr555");
		
		assertEquals("1525eec4-7bed-4597-bf5a-e06fcede5f4f", service.getStoreById("1525eec4-7bed-4597-bf5a-e06fcede5f4f").getStoreId());
	}

	@Test
	void testFetchAllStores() {
		Store store =new Store();
		store.setStoreId("1525eec4-7bed-4597-bf5a-e06fcede5f4f");
		store.setCity("abc");
		store.setPostCode("dfsr555");
		List<Store> list = new ArrayList<>();
		list.add(store);
		
		assertEquals("1525eec4-7bed-4597-bf5a-e06fcede5f4f", service.fetchAllStores("city").get(0).getStoreId());
	}

}
