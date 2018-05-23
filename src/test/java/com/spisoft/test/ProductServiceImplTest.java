package com.spisoft.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.spisoft.entities.Product;
import com.spisoft.repository.ProductsRepository;
import com.spisoft.service.ProductServiceImpl;

public class ProductServiceImplTest {

	protected static final String PRODUCT_NAME_1 = "Lenovo";
	protected static final String PRODUCT_TYPE_1 = "Laptops";

	protected static final Product theProduct = new Product(PRODUCT_NAME_1, PRODUCT_TYPE_1);

	@Inject
	ProductServiceImpl productServiceImpl;

	protected TestProductsRepository testRepo = new TestProductsRepository();

	@Test
	public void validProductType() {
		Logger.getGlobal().info("Start validProductType test");
		Product product = productServiceImpl.findByType(PRODUCT_TYPE_1);

		Assert.assertNotNull(product);
		Assert.assertEquals(PRODUCT_TYPE_1, product.getType());
		Assert.assertEquals(PRODUCT_NAME_1, product.getName());
		Logger.getGlobal().info("End validAccount test");
	}

	@Before
	public void setup() {
		productServiceImpl = new ProductServiceImpl(testRepo);
	}

	protected static class TestProductsRepository implements ProductsRepository {

		public Product findByType(String productType) {
			if (productType.equals(PRODUCT_TYPE_1))
				return theProduct;
			else
				return null;
		}

		public List<Product> findPriceByName(String productName) {
			List<Product> products = new ArrayList<Product>();

			if (PRODUCT_NAME_1.toLowerCase().indexOf(productName.toLowerCase()) != -1)
				products.add(theProduct);
			else
				return null;

			return products;
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

		public int countProducts() {
			// TODO Auto-generated method stub
			return 0;
		}

	}
}
