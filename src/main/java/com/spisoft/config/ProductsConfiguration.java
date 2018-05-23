package com.spisoft.config;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
@ComponentScan
@EntityScan("com.spisoft.entities")
@EnableJpaRepositories("com.spisoft.repository")
@PropertySource("classpath:db-config.properties")
public class ProductsConfiguration {

	protected Logger logger;

	public ProductsConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

	@Named
	public DataSource dataSource() {
		logger.info("dataSource() invoked");

		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:testdb/schema.sql")
				.addScript("classpath:testdb/data-products.sql").build();

		logger.info("dataSource = " + dataSource);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> products = jdbcTemplate.queryForList("SELECT name FROM PRODUCT");
		logger.info("System has " + products.size() + " products");

		// Populate with random balances
		Random rand = new Random();

		for (Map<String, Object> item : products) {
			String name = (String) item.get("name");
			BigDecimal price = new BigDecimal(rand.nextInt(10000000) / 100.0).setScale(2, BigDecimal.ROUND_HALF_UP);
			jdbcTemplate.update("UPDATE PRODUCT SET price = ? WHERE name = ?", price, name);
		}

		return dataSource;
	}
}
