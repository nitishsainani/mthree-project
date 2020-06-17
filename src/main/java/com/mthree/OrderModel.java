package com.mthree.Order;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mthree.stock.*;
import com.mthree.user.*;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)   
public class OrderModel {
	@Id
	@GeneratedValue
	private int orderId;
	@OneToOne
	@JoinColumn(name = "user")
	@JsonBackReference
	private User user;
	@ManyToOne
	@JoinColumn(name = "stock")
	private Stock stock;
	private String side;
	private String status;
	private int exchangeId;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
//	public User getUserId() {
//		return userId;
//	}
//	public void setUserId(User userId) {
//		this.userId = userId;
//	}
//	public Instrument getInstrumentId() {
//		return instrumentId;
//	}
//	public void setInstrumentId(Instrument instrumentId) {
//		this.instrumentId = instrumentId;
//	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getExchangeId() {
		return exchangeId;
	}
	public void setExchangeId(int exchangeId) {
		this.exchangeId = exchangeId;
	}
	public OrderModel(int orderId, String side, String status, int exchangeId) {
		super();
		this.orderId = orderId;
//		this.userId = userId;
//		this.instrumentId = instrumentId;
		this.side = side;
		this.status = status;
		this.exchangeId = exchangeId;
	}
	@Override
	public String toString() {
		return "OrderModel [orderId=" + orderId + ", side=" + side + ", status=" + status + ", exchangeId=" + exchangeId
				+ "]";
	}
	public OrderModel() {}
	
//	User userId, Instrument instrumentId

}

