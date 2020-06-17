package com.mthree.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.mthree.LimitOrder.*;
import com.mthree.MarketOrder.*;
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<OrderModel> getAllOrder(){
		return orderRepository.findAll();
	}
	public boolean addNewLimitOrder(LimitOrder order) {
		if(order!=null) {
		    orderRepository.save(order);
		    return true;
		}
		return false;
	}
	public boolean addNewMarketOrder(MarketOrder order) {
		if(order!=null) {
		    orderRepository.save(order);
		    return true;
		}
		return false;
	}
	public void removeOrder(int orderId) {
			orderRepository.deleteById(orderId);
	}
	public OrderModel updateOrderNameById(int orderId,String status) {
		OrderModel order = null;
		Optional<OrderModel> e = orderRepository.findById(orderId);
		if(e.isPresent()) {
			order = e.get();
			order.setStatus(status);
		}
		return orderRepository.save(order);
	}
	public boolean findById(int orderId) {
		Optional<OrderModel> e = orderRepository.findById(orderId);
		if(e.isPresent())return true;
		return false;
	}
}
