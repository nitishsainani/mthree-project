package com.mthree.sortcontrollers;

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

import com.mthree.orders.LimitOrder;
import com.mthree.orders.MarketOrder;
import com.mthree.orders.OrderModel;
import com.mthree.orderservices.OrderService;
import com.mthree.responses.BaseResponse;

@RestController
public class SortController {

	public SortController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired 
//	private SortService sortService;
	@PostMapping("/addLimitOrderSort/{userId}/{instrumentId}")
	public BaseResponse addNewLimitOrder(@RequestBody LimitOrder e,@PathVariable("userId")int userId,@PathVariable("instrumentId")int instrumentId) {
		
		return new BaseResponse(200,"");
	}
	@PostMapping("/addMarketOrderSort/{userId}/{instrumentId}")
	public BaseResponse addNewMarketOrder(@RequestBody MarketOrder e,@PathVariable("userId")int userId,@PathVariable("instrumentId")int instrumentId) {
		return new BaseResponse(200,"");
	}
	@RequestMapping(value="/removeOrderSort/{orderId}",method=RequestMethod.DELETE)
	public BaseResponse removeOrder(@PathVariable("orderId") int orderId ) {
		return new BaseResponse(200,"");
		
	}
	@GetMapping("/displayallOrders")
	public BaseResponse getAllOrders(Model m){
		return new BaseResponse(200,"");
	}

}
