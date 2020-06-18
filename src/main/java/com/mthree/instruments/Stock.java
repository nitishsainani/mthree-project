package com.mthree.instruments;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="stock")
public class Stock extends Instrument {

	public Stock() {
		// TODO Auto-generated constructor stub
	}
	public Stock(int instrumentId, String name, Double price) {
		super(instrumentId,name,price);
	}
	@Override
	public String toString() {
		return "Stock [instrumentId=" + instrumentId + ", name=" + name + ", price=" + price + "]";
	}

}
