package com.mthree.responses;

import com.mthree.SORT.Stock;

import java.util.HashMap;

public class StockTableResponse {
    private HashMap<String, Stock> priceData;

    public StockTableResponse(HashMap<String, Stock> priceData) {
        this.priceData = priceData;
    }

    public HashMap<String, Stock> getPriceData() {
        return priceData;
    }

    public void setPriceData(HashMap<String, Stock> priceData) {
        this.priceData = priceData;
    }
}
