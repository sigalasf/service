package com.boot.services;

import com.boot.entites.Product;

public interface ProductService {

	Iterable<Product> listAllProducts();
	
	Product getProductById(Integer id);
	
	Product saveProduct(Product product);
	
	void deleteProduct(Integer id);
}
