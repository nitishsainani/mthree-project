package com.mthree.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.services.ExchangeSerrvice;
import com.mthree.models.Exchange;
import com.mthree.responses.BaseResponse;

@RestController
@CrossOrigin
public class ExchangeController {
	@Autowired 
	private ExchangeSerrvice exchangeService;
	
	@PostMapping("/addExchange")
	public BaseResponse addExchange(@RequestBody Exchange e) {
		if(exchangeService.addExchange(e)) {
			return new BaseResponse(200,"Limit Order added");
		}
		else {
			return new BaseResponse(200,"Limit Order cannot be added");
		}
	}
	@PostMapping("/feeLadder")
	public BaseResponse feeLadder() {
		int commission =exchangeService.feeLadder();
		return new BaseResponse(200,"Fee Ladder",commission);
	}
	@PostMapping("/tradeValue")
	public BaseResponse todayTradeValue() {
		String tradeValue = exchangeService.todayTradeValue();
		return new BaseResponse(200,"Fee Ladder",tradeValue);
	}
}

