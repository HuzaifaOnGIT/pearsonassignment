package com.pearson.storey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.storey.model.Store;
import com.pearson.storey.service.StoreService;

import lombok.extern.slf4j.Slf4j; 
@RestController
@Slf4j
public class StoreController {

	@Autowired
	private StoreService service;
	
	
	@GetMapping("/{storeId}")
	public ResponseEntity <?> getStoreById(@PathVariable String storeId) {
		Store storeById = service.getStoreById(storeId);
		if(storeById!=null)
			return new ResponseEntity<>(storeById,HttpStatus.OK);
		else
			return new ResponseEntity<>("Data not found",HttpStatus.NOT_FOUND);
	}

	@GetMapping("/fetch/{para}")
	public ResponseEntity getStoresByCity(@PathVariable String para) {
		List<Store> storesByCity = service.fetchAllStores(para);
		if(storesByCity.size()>0) {
			return new ResponseEntity(storesByCity,HttpStatus.OK);
		}
		else {
			return new ResponseEntity("Based on City no stores is present",HttpStatus.NOT_FOUND);
		}
	}
//	
}
