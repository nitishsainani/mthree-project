package com.mthree.services;


import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.repositories.ExchangeRepository;
import com.mthree.models.Exchange;
import com.mthree.models.LimitOrder;
import com.mthree.models.OrderModel;

@Service
public class ExchangeSerrvice {
	@Autowired
	private ExchangeRepository exchangeRepository;
	
	@Autowired
	private OrderService orderService;
	
	public boolean addExchange(Exchange e) {
		if(e!=null) {
			exchangeRepository.save(e);
			return true;
		}
		return false;
	}
	public int feeLadder() {
		List<OrderModel> order;
		order=orderService.getAllOrder();
		new Exchange().setOrder(order);
		int fee=0,commissionPercent=15;
		Iterator<OrderModel> iterator = order.iterator();
		int quantity=0;
		while(iterator.hasNext()) {
			Object o =iterator.next();
			OrderModel mobj = OrderModel.class.cast(o);
			quantity+=mobj.getQuantity();
		
		}
                fee+= quantity * commissionPercent;
		return fee;
	}
	public String todayTradeValue() {
		List<OrderModel> order;
		order = orderService.getAllOrder();
		Iterator<OrderModel> iterator = order.iterator();
		Double totalprice=0.0;
		String tradeValue;
		while(iterator.hasNext()) {
			Object o = iterator.next();
			OrderModel mobj = OrderModel.class.cast(o);
			if(mobj instanceof LimitOrder) {
				LimitOrder l = (LimitOrder) mobj;
				if(l.getStatus().equalsIgnoreCase("Active"))
				totalprice+= l.getPrice();
			}
		}
		tradeValue = String.format("%.2f", totalprice/(double)order.size());
		return tradeValue;
	}

}

