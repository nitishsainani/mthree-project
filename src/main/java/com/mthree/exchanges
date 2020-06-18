package com.mthree.exchanges;
import com.mthree.orders.*;
import java.util.*;
import javax.persistence.*;

@Entity
public class Exchange {
	@Id
	@GeneratedValue
	private int exchangeId;
    private String exchangeName;
    private Double fee;
    //private StockData stockData;
    
    @OneToMany(mappedBy="exchangeId")
    private List<OrderModel> order = new ArrayList<>();

	public Exchange() {
		super();
		// TODO Auto-generated constructor stub
	}
public Exchange(int exchangeId, String exchangeName, Double fee, List<OrderModel> order) {
	super();
	this.exchangeId = exchangeId;
	this.exchangeName = exchangeName;
	this.fee = fee;
	this.order = order;
}
public int getExchangeId() {
	return exchangeId;
}
public void setExchangeId(int exchangeId) {
	this.exchangeId = exchangeId;
}
public String getExchangeName() {
	return exchangeName;
}
public void setExchangeName(String exchangeName) {
	this.exchangeName = exchangeName;
}
public Double getFee() {
	return fee;
}
public void setFee(Double fee) {
	this.fee = fee;
}
public List<OrderModel> getOrder() {
	return order;
}
public void setOrder(List<OrderModel> order) {
	this.order = order;
}
@Override
public String toString() {
	return "Exchange [exchangeId=" + exchangeId + ", exchangeName=" + exchangeName + ", fee=" + fee + ", order=" + order
			+ "]";
}
	       
	
    
}
