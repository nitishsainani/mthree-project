package com.mthree.MarketOrder;

import javax.persistence.*;
import com.mthree.Order.*;

@Entity
public class MarketOrder extends OrderModel{
	public MarketOrder(){
		
	}
	public MarketOrder(int orderId, String side, String status, int exchangeId) {
		super(orderId, side, status, exchangeId);	
	}
	
}
