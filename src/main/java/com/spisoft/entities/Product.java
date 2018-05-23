package com.spisoft.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	public static Long nextId = 0L;

	@Id
	@Column(name = "product_id")
	private Long id;

	@Column(name = "name")
	protected String name;

	@Column(name = "type")
	protected String type;

	protected BigDecimal price;

	protected static Long getNextId() {
		synchronized (nextId) {
			return nextId++;
		}
	}

	public Product() {
	}

	public Product(String name, String type) {
		id = getNextId();
		this.name = name;
		this.type = type;
	}

	public Product(String name, String type, BigDecimal price) {
		id = getNextId();
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Product product = (Product) obj;

		return id.equals(product.id);
	}

	@Override
	public String toString() {
		return name + " [" + type + "]: $" + price;
	}

}
