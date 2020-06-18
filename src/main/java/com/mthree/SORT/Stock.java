package com.mthree.SORT;

import java.util.HashMap;

public class Stock {
    private String symbol;
    private String name;
    private HashMap<String, Double> priceData;

    public Stock(String symbol, String name, HashMap<String, Double> priceData) {
        this.symbol = symbol;
        this.name = name;
        this.priceData = priceData;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Double> getPriceData() {
        return priceData;
    }

    public void setPriceData(HashMap<String, Double> priceData) {
        this.priceData = priceData;
    }
}
