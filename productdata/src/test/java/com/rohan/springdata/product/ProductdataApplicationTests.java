package com.rohan.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rohan.springdata.product.entities.Product;
import com.rohan.springdata.product.repos.ProductRepository;

@SpringBootTest
class ProductdataApplicationTests {
	@Autowired
	ProductRepository productRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("Awesome");
		product.setPrice(1000d);
		
		productRepository.save(product);
	}
	
	@Test
	public void testRead() {
		Product product = productRepository.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>" + product.getDesc());
		
	}
	
	@Test
	public void testUpdate() {
		Product product = productRepository.findById(1).get();
		assertNotNull(product);
		product.setPrice(1200d);
		productRepository.save(product);
	}
	
	@Test
	public void testDelete() {
		if(productRepository.existsById(1))
		productRepository.deleteById(1);
	}
	
	@Test
	public void testCount() {
		System.out.println(productRepository.count());
	}
	
	
}
