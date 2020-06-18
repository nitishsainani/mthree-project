package com.mthree.SORT;

import com.mthree.orders.LimitOrder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class OrderBook {
    public HashMap<String, PriorityQueue<LimitOrder>> buyOrders = new HashMap<>();
    public HashMap<String, PriorityQueue<LimitOrder>> sellOrders = new HashMap<>();
    List<String> stockStrings;

    public OrderBook(List<String> stockStrings) {
        this.stockStrings = stockStrings;
        for (String symbol :
                stockStrings) {
            buyOrders.put(symbol, new PriorityQueue<LimitOrder>((o1, o2) -> {
                return o1.getPrice().equals(o2.getPrice()) ? 0 : (o1.getPrice() < o2.getPrice() ? 1 : -1);
            }));
            sellOrders.put(symbol,new PriorityQueue<LimitOrder>((o1, o2) -> {
                return o1.getPrice().equals(o2.getPrice()) ? 0 : (o1.getPrice() > o2.getPrice() ? 1 : -1);
            }));
        }
    }


    public HashMap<String, PriorityQueue<LimitOrder>> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(HashMap<String, PriorityQueue<LimitOrder>> buyOrders) {
        this.buyOrders = buyOrders;
    }

    public HashMap<String, PriorityQueue<LimitOrder>> getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(HashMap<String, PriorityQueue<LimitOrder>> sellOrders) {
        this.sellOrders = sellOrders;
    }
}
