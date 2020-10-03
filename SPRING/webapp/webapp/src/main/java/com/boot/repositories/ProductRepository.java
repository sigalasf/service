package com.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.boot.entites.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}