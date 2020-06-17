package com.mthree.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.ui.Model;
import com.mthree.LimitOrder.*;
import com.mthree.MarketOrder.*;
import com.mthree.responses.*;
@RestController
public class OrderController {
	@Autowired 
	private OrderService orderService;
	
	@PostMapping("/addLimitOrder")
	public BaseResponse addNewLimitOrder(@RequestBody LimitOrder e) {
		if(orderService.addNewLimitOrder(e)) {
			return new BaseResponse(200,"Limit Order added");
		}
		else {
			return new BaseResponse(200,"Limit Order cannot be added");
		}
	}
	@PostMapping("/addMarketOrder")
	public BaseResponse addNewMarketOrder(@RequestBody MarketOrder e) {
		if(orderService.addNewMarketOrder(e))
			return new BaseResponse(200,"Market Order added");
		else
			return new BaseResponse(200,"Market Order cannot be added");
	}
	@GetMapping("/allOrders")
	public Model getAllOrders(Model m){
		List<OrderModel> o = orderService.getAllOrder();
		m.addAllAttributes(o);
		return m;
	}
	
	@RequestMapping(value="/removeOrder/{orderId}",method=RequestMethod.DELETE)
	public String removeOrder(@PathVariable("orderId") int orderId ) {
		if(orderService.findById(orderId)) {
			orderService.removeOrder(orderId);
			return "The order is removed";
		}
		return "The Id cannot be found";
	}
	@PostMapping("/updateOrder/{orderId}/{status}")
	public String updateOrderNamebyId(@PathVariable("orderId") int orderId,@PathVariable("status") String status) {
		if(orderService.findById(orderId)) {
			orderService.updateOrderNameById(orderId, status);
			return "The order status is updated to "+status;
		}
		return "The Id cannot be found. Order cannot be updated";
		
	}
}
