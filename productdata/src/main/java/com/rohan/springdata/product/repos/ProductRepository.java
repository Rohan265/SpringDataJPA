package com.rohan.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.rohan.springdata.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
