package com.pearson.storey.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pearson.storey.model.Store;

@Service
public interface StoreService {
	public Store getStoreById(String id);
	
	public List<Store> fetchAllStores(String parameter);

}
