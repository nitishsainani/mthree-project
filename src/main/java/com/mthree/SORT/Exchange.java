package com.mthree.SORT;

import java.util.HashMap;

public class Exchange {
    public HashMap<String, Stock> stocks;
    public String name;

    public Exchange(HashMap<String, Stock> stocks, String name) {
        this.stocks = stocks;
        this.name = name;
    }
}
