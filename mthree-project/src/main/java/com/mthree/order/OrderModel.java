package com.mthree.order;

import javax.persistence.*;
//import java.util.*;
//import com.mthree.*;
@Entity
public class OrderModel {
	@Id
	@GeneratedValue
	private int orderId;
	
	@OneToOne(mappedBy="orderId")
	private int userId;
	
	private String status;
	
	private String side;
	
	private int exchange_id;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public int getExchange_id() {
		return exchange_id;
	}
	public void setExchange_id(int exchange_id) {
		this.exchange_id = exchange_id;
	}
	@Override
	public String toString() {
		return "OrderModel [orderId=" + orderId + ", userId=" + userId + ", status=" + status + ", side=" + side
				+ ", exchange_id=" + exchange_id + "]";
	}
	public OrderModel(int orderId, int userId, String status, String side, int exchange_id) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.status = status;
		this.side = side;
		this.exchange_id = exchange_id;
	}

}
