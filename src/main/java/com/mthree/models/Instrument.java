package com.mthree.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mthree.models.OrderModel;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="instrument")
public class Instrument {
    @Id
    @GeneratedValue
	protected int instrumentId;
	protected String name;
	protected Double price;
	@OneToMany(mappedBy="instrument",cascade=CascadeType.ALL)
	@JsonBackReference
	protected List<OrderModel> orders;
	public int getInstrumentId() {
		return instrumentId;
	}
	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
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
	@Override
	public String toString() {
		return "Instrument [instrumentId=" + instrumentId + ", name=" + name + ", price=" + price + "]";
	}
	public Instrument(int instrumentId, String name, Double price) {
		super();
		this.instrumentId = instrumentId;
		this.name = name;
		this.price = price;
	}
	public Instrument()
	{}
	
	
}

