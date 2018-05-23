package com.spisoft.service;

import java.util.List;

import com.spisoft.entities.Product;
import com.spisoft.repository.ProductsRepository;

public interface ProductService extends ProductsRepository{

	Product findByType(String productType);

	List<Product> findPriceByName(String productName);

	int countProducts();
	
	

}
