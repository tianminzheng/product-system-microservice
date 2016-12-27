package com.tianyalan.microservice.product.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tianyalan.microservice.product.product.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProductName(String productName);
}
