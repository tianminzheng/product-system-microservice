package com.tianyalan.microservice.product.ui.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tianyalan.microservice.product.ui.base.ResultMessageBuilder;
import com.tianyalan.microservice.product.ui.base.ResultMessageBuilder.ResultMessage;
import com.tianyalan.microservice.product.ui.domain.Order;
import com.tianyalan.microservice.product.ui.domain.Product;
import com.tianyalan.microservice.product.ui.service.OrderHystrixService;
import com.tianyalan.microservice.product.ui.service.ProductHystrixService;

@RestController
public class UiController {

	@Autowired
	private OrderHystrixService orderHystrixService;
	
	@Autowired
	private ProductHystrixService productHystrixService;
		
	@RequestMapping("/gateway")
	public ResultMessage gateway(Long userId, String items) throws Exception {
		Order order = new Order();
		
		//根据Product服务验证该商品是否存在
		Product product = productHystrixService.getProduct(items);
		if(product == null || product.getDescription().contains("fail")) {
			return ResultMessageBuilder.build(false, "The product for " + items + " is not existed!");
		}
			
		order.setUserId(userId);
		order.setItems(items);
		order.setCreateTime(new Date());
		List<Order> orders = orderHystrixService.save(order);
		
		return ResultMessageBuilder.build(orders);
	}
}
