package com.boot.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version;
	private String productId;
	private String description;
	private String imageUrl;
	private float price;
	
	
	
	public Product(String productId, String description, String imageUrl, float price) {
		super();
		this.productId = productId;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
	}

	public Product() {
		super();
	}

	public Integer getId() {
		return this.id;
	}
	
	public Integer getVersion() {
		return this.version;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProductId() {
		return this.productId;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getImageUrl() {
		return this.imageUrl;
	}
	
	public float getPrice() {
		return this.price;
	}
}
