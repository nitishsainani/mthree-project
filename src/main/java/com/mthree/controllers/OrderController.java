package com.mthree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.dtos.OrderDTO;
import com.mthree.models.LimitOrder;
import com.mthree.models.MarketOrder;
import com.mthree.models.OrderModel;
import com.mthree.services.OrderService;
import com.mthree.responses.BaseResponse;
@RestController
public class OrderController {
	@Autowired 
	private OrderService orderService;
	
	@PostMapping("/addLimitOrder/{userId}/{instrumentId}")
	public BaseResponse addNewLimitOrder(@RequestBody LimitOrder e,@PathVariable("userId")int userId,@PathVariable("instrumentId")int instrumentId) {
		if(orderService.addNewLimitOrder(e,userId,instrumentId)) {
			return new BaseResponse(200,"Limit Order added");
		}
		else {
			return new BaseResponse(200,"Limit Order cannot be added");
		}
	}
	@PostMapping("/addMarketOrder/{userId}/{instrumentId}")
	public BaseResponse addNewMarketOrder(@RequestBody MarketOrder e,@PathVariable("userId")int userId,@PathVariable("instrumentId")int instrumentId) {
		if(orderService.addNewMarketOrder(e,userId,instrumentId))
			return new BaseResponse(200,"Market Order added");
		else
			return new BaseResponse(200,"Market Order cannot be added");
	}
	@GetMapping("/allOrders")
	public BaseResponse getAllOrders(Model m){
		List<OrderModel> o = orderService.getAllOrder();
		//m.addAllAttributes(o);
		//return m;
		return new BaseResponse(200,"get all orders",o);
	}
	@GetMapping("/displayOrders/{userId}")
	public BaseResponse displayOrders(@PathVariable("userId")int userId){
		List<OrderDTO> o = orderService.displayOrders(userId);
		//m.addAllAttributes(o);
		//return m;
		return new BaseResponse(200,"get all orders",o);
	}
	
	@RequestMapping(value="/removeOrder/{orderId}",method=RequestMethod.DELETE)
	public BaseResponse removeOrder(@PathVariable("orderId") int orderId ) {
		if(orderService.findById(orderId)) {
			orderService.removeOrder(orderId);
			//return "The order is removed";
			return new BaseResponse(200,"order removed");
		}
		//return "The Id cannot be found";
		return new BaseResponse(200,"Id not found");
	}
	@PostMapping("/updateOrder/{orderId}/{status}")
	public BaseResponse updateOrderNamebyId(@PathVariable("orderId") int orderId,@PathVariable("status") String status) {
		if(orderService.findById(orderId)) {
			orderService.updateOrderNameById(orderId, status);
			//return "The order status is updated to "+status;
			return new BaseResponse(200,"The order status is updated to "+status);
		}
		//return "The Id cannot be found. Order cannot be updated";
		return new BaseResponse(200,"The Id cannot be found. Order cannot be updated");
		
	}
}
