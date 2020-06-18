package com.mthree.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="order_model")
public class OrderModel {
	@Id
	@GeneratedValue
	protected int orderId;
	@ManyToOne
	@JoinColumn(name = "user_id")
	//@JsonBackReference
	protected User userId;
	@ManyToOne
	@JoinColumn(name = "instrument_id")
	protected Instrument instrument;
	protected String side;
	protected String status;
	protected int exchangeId;
	protected String instrumentName;
	protected int quantity;
	public OrderModel(int orderId, String side, String status, int exchangeId,
			String instrumentName,int quantity) {
		super();
		this.orderId = orderId;
//		this.userId = userId;
//		this.instrument = instrument;
		this.side = side;
		this.status = status;
		this.exchangeId = exchangeId;
		this.instrumentName = instrumentName;
		this.quantity=quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	public String getInstrumentName() {
		return instrumentName;
	}
	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
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
//	public OrderModel(int orderId, String side, String status, int exchangeId) {
//		super();
//		this.orderId = orderId;
//		//this.userId = userId;
////		this.instrumentId = instrumentId;
//		this.side = side;
//		this.status = status;
//		this.exchangeId = exchangeId;
//	}

	
	public OrderModel() {}
	@Override
	public String toString() {
		return "OrderModel [orderId=" + orderId + ", userId=" + userId + ", instrument=" + instrument + ", side=" + side
				+ ", status=" + status + ", exchangeId=" + exchangeId + ", instrumentName=" + instrumentName + "]";
	}
	
//	User userId, Instrument instrumentId

}

