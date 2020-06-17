package com.mthree.stock;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Stock {
    @Id
	private int stockId;
	private String name;
	private Double price;
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Stock(int stockId, String name, Double price) {
		super();
		this.stockId = stockId;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", name=" + name + ", price=" + price + "]";
	}
	
}

