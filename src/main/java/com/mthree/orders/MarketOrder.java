package com.mthree.orders;

import javax.persistence.Entity;

@Entity
public class MarketOrder extends OrderModel{
	public MarketOrder(){
		
	}
	public MarketOrder(int orderId, String side, String status, int exchangeId) {
		super(orderId, side, status, exchangeId);	
	}
	
}
