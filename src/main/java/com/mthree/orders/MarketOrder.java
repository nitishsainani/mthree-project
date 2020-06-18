package com.mthree.orders;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="marketOrder")
public class MarketOrder extends OrderModel{
	public MarketOrder(){
		
	}
	public MarketOrder(int orderId, String side, String status, int exchangeId, Double price,String instrumentName,int quantity) {
		super(orderId, side, status, exchangeId,instrumentName,quantity);
		
	}
	
}
