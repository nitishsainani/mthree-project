package com.mthree.dtos;

public class OrderDTO {

	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}
	protected int orderId;
	protected int userId;
	protected String instrumentName;
	protected String side;
	protected String status;
	protected int exchangeId;
	public OrderDTO(int orderId, int userId, String side, String status, int exchangeId )
		{super();
		this.orderId = orderId;
		this.userId = userId;
		//this.instrumentId = instrumentId;
		this.side = side;
		this.status = status;
		this.exchangeId = exchangeId;
	}
	
	public OrderDTO(int orderId, int userId,String instrumentId, String side, String status, int exchangeId) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.instrumentName = instrumentId;
		this.side = side;
		this.status = status;
		this.exchangeId = exchangeId;
	}

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

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

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
	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", userId=" + userId +  ", side=" + side
				+ ", status=" + status + ", exchangeId=" + exchangeId + "]";
	}

}
