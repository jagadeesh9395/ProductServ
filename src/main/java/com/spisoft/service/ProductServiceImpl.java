package com.spisoft.service;

import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.spisoft.entities.Product;
import com.spisoft.exceptions.RecordNotFoundException;
import com.spisoft.repository.ProductsRepository;

@Named
public class ProductServiceImpl implements ProductService {

	protected Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class.getName());

	protected ProductsRepository productRepository;

	public ProductServiceImpl(ProductsRepository productRepository) {
		this.productRepository = productRepository;

		logger.info("ProductRepository says system has " + productRepository.countProducts() + " products");
	}

	public Product findByType(String productType) {
		logger.info("products-service byType() invoked: " + productType);
		Product product = productRepository.findByType(productType);
		logger.info("products-service byType() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productType);
		else {
			return product;
		}
	}

	public List<Product> findPriceByName(String productName) {
		logger.info("products-service findPriceByName() invoked: " + productName);
		List<Product> product = productRepository.findPriceByName(productName);
		logger.info("products-service findPriceByName() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productName);
		else {
			return product;
		}
	}

	public int countProducts() {
		return productRepository.countProducts();
	}

	public List<Product> createProduct(Product products) {
		logger.info("products-service createProduct() invoked: " + products);
		/*
		 * productRepository.save(new Product(products.getName(),
		 * products.getType(), products.getPrice()));
		 */
		productRepository.save(products);
		return productRepository.findAll();

	}

	public List<Product> deleteProduct(Long productId) {
		logger.info("products-service deleteProduct() invoked: " + productId);
		productRepository.delete(productId);
		return productRepository.findAll();
	}

	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	public void deleteInBatch(Iterable<Product> arg0) {
		// TODO Auto-generated method stub

	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub

	}

	public Product getOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Product> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Product> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Product> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Long arg0) {
		// TODO Auto-generated method stub

	}

	public void delete(Product arg0) {
		// TODO Auto-generated method stub

	}

	public void delete(Iterable<? extends Product> arg0) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Product findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Product> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
