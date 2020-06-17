package com.mthree.LimitOrder;

import javax.persistence.*;
import com.mthree.Order.*;

@Entity
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

	public LimitOrder(int orderId, String side, String status, int exchangeId, Double price) {
		super(orderId, side, status, exchangeId);
		this.price = price;
	}
	
	
}
