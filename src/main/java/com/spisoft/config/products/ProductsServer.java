package com.spisoft.config.products;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.spisoft.config.ProductsConfiguration;
import com.spisoft.repository.ProductsRepository;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(ProductsConfiguration.class)
public class ProductsServer {

	@Inject
	protected ProductsRepository productsRepository;

	protected Logger logger = Logger.getLogger(ProductsServer.class.getName());

	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or
		// accounts-server.yml
		System.setProperty("spring.config.name", "products-server");

		SpringApplication.run(ProductsServer.class, args);
	}
}
