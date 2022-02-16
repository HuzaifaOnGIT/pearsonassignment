package com.pearson.storey.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.pearson.storey.exception.CustomException;
import com.pearson.storey.model.Store;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class StoreServiceImplementation implements StoreService {

	@Override
	public Store getStoreById(String id) {
		int count = 0;
		Store store = new Store();
		List<String> list = new ArrayList<>();
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/stores.csv"));) {
			String[] values = new String[10];
			while ((values = csvReader.readNext()) != null) {
				list = Arrays.asList(values);
				if ((Arrays.asList(values).get(0)).equals(id)) {
					store.setStoreId(list.get(0));
					store.setPostCode(list.get(1));
					store.setCity(list.get(2));
					store.setAddress(list.get(3));
					store.setOpenedDate(new SimpleDateFormat("dd/mm/yyyy").parse(list.get(4)));
					count++;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count > 0)
			return store;
		else
			throw new CustomException("Please provide valid Store Id!");

	}


	@Override
	public List<Store> fetchAllStores(String parameter)  {
		
		List<String> list = new ArrayList<>();
		List<Store> storeList = new ArrayList<>();
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/stores.csv"));) {
			String[] values = new String[10];
			while ((values = csvReader.readNext()) != null) {
				list = Arrays.asList(values);
				Store store = new Store();
				store.setStoreId(list.get(0));
				store.setPostCode(list.get(1));
				store.setCity(list.get(2));
				store.setAddress(list.get(3));
				store.setOpenedDate(new SimpleDateFormat("dd/mm/yyyy").parse(list.get(4)));
				storeList.add(store);
			}
			
			Comparator<Store> sort = null;
			if (parameter.equalsIgnoreCase("city")) {
				sort = (city1,city2)->{
					return city1.getCity().compareTo(city2.getCity());
				};
			} else if (parameter.equalsIgnoreCase("date")) {
				sort =(date1,date2)->{
					return date1.getOpenedDate().compareTo(date2.getOpenedDate());
				};
			}
			
			Collections.sort(storeList,sort);

			return storeList;

		}catch (Exception e) {
			e.printStackTrace();
		}
		throw new CustomException("Provide proper parameter!!");
	}

}
