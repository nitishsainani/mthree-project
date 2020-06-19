package com.mthree.controllers;

import com.mthree.SORT.SORT;
import com.mthree.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mthree.models.LimitOrder;
import com.mthree.models.MarketOrder;
import com.mthree.responses.BaseResponse;

@RestController
@CrossOrigin
public class SortController {
	private OrderService orderService;

	public SortController() {
		// TODO Auto-generated constructor stub
	}
//	@Autowired
//	private SortService sortService;
	@PostMapping("/addLimitOrderSort/{userId}/{instrumentId}")
	public BaseResponse addNewLimitOrder(@RequestBody LimitOrder e,@PathVariable("userId")int userId,@PathVariable("instrumentId")int instrumentId) {

		if(orderService.addNewLimitOrder(e, userId, instrumentId))
			return new BaseResponse(200,"Market Order added");
		else
			return new BaseResponse(200,"Market Order cannot be added");


		//SORT.addLimitOrder(e, userId, instrumentId);

		//return new BaseResponse(200,"");
	}

	@PostMapping("/addMarketOrderSort/{userId}/{instrumentId}")
	public BaseResponse addNewMarketOrder(@RequestBody MarketOrder e,@PathVariable("userId")int userId,@PathVariable("instrumentId")int instrumentId) {
		if(orderService.addNewMarketOrder(e,userId,instrumentId))
			return new BaseResponse(200,"Market Order added");
		else
			return new BaseResponse(200,"Market Order cannot be added");
	}

	@RequestMapping(value="/removeOrderSort/{orderId}",method=RequestMethod.DELETE)
	public BaseResponse removeOrder(@PathVariable("orderId") int orderId ) {
		return new BaseResponse(200,"");
		
	}

	@PostMapping("/getStockDetails/{symbol}")
	public BaseResponse getStockDetails(@RequestBody MarketOrder e,@PathVariable("symbol")String symbol) {
		return new BaseResponse(200, "", SORT.getStockDetails(symbol));
	}

	@PostMapping("/getMainPageData/")
	public BaseResponse getTableData() {
		return new BaseResponse(200, "", SORT.getMainPageData());
	}

	@GetMapping("/displayallOrders")
	public BaseResponse getAllOrders(Model m){
		return new BaseResponse(200,"");
	}

}
