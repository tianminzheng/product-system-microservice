package com.tianyalan.microservice.product.product.service;

import com.tianyalan.microservice.product.product.domain.Product;

public interface ProductService {
	
	Product getProductByName(String productName);
}
