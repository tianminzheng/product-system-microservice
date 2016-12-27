package com.tianyalan.microservice.product.order.service;

import java.util.List;

import com.tianyalan.microservice.product.order.domain.UserOrder;

public interface OrderService {

	void addOrder(UserOrder order);
	
	List<UserOrder> getOrders(int pageIndex, int pageSize);
	
	UserOrder getOrderById(Long id);
}
