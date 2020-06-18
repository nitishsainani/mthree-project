package com.mthree.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.dtos.OrderDTO;
import com.mthree.repositories.OrderRepository;
import com.mthree.models.LimitOrder;
import com.mthree.models.MarketOrder;
import com.mthree.models.OrderModel;
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<OrderModel> getAllOrder(){
		return orderRepository.findAll();
	}
	public List<OrderDTO> displayOrders(int userId){
		
		return orderRepository.displayOrders(userId);
	}
	public boolean addNewLimitOrder(LimitOrder order,int userId,int instrumentId) {
		if(order!=null) {
		    orderRepository.save(order);
		    if(orderRepository.updateLimitOrderById(order.getOrderId(),userId,instrumentId)==1)
		    return true;
		    else 
		    	return false;
		}
		return false;
	}
	public boolean addNewMarketOrder(MarketOrder order,int userId,int instrumentId) {
		if(order!=null) {
		    orderRepository.save(order);
		    
		    if(orderRepository.updateMarketOrderById(order.getOrderId(),userId,instrumentId)==1)
			    return true;
			    else 
			    	return false;
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
