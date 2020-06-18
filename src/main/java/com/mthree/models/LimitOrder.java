package com.mthree.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="limitOrder")
public class LimitOrder extends OrderModel {
	private Double price;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LimitOrder() {
		super();
	}

	public LimitOrder(int orderId, String side, String status, int exchangeId, Double price,String InstrumentName,int quantity) {
		super(orderId, side, status, exchangeId,InstrumentName,quantity);
		this.price = price;
	}

	 

	
	
	
}
