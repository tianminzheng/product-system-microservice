package com.tianyalan.microservice.product.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tianyalan.microservice.product.order.domain.UserOrder;

public interface OrderRepository extends JpaRepository<UserOrder, Long> {

}
