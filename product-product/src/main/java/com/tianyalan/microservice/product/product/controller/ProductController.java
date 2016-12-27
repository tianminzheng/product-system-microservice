package com.tianyalan.microservice.product.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tianyalan.microservice.product.product.domain.Product;
import com.tianyalan.microservice.product.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/{productName}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String productName) {
		Product product = productService.getProductByName(productName);
    	return product;
    }
}
