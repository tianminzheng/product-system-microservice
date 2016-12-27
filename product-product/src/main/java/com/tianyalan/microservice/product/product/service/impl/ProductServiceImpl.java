package com.tianyalan.microservice.product.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyalan.microservice.product.product.domain.Product;
import com.tianyalan.microservice.product.product.repository.ProductRepository;
import com.tianyalan.microservice.product.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProductByName(String productName) {
		return productRepository.findByProductName(productName);
	}

}
