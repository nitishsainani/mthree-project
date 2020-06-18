package com.mthree.SORT;

import com.mthree.orders.LimitOrder;
import com.mthree.orderservices.OrderService;

import java.util.ArrayList;
import java.util.List;

public class SORT {
    public static OrderMatchingEngine orderMatchingEngine;
    public static List<Exchange> exchanges;
    private static OrderService orderService;

    public static void initialize() {
        initializeRandomExchanges();
        List<String> stockStrings = getRandomStockSymbols();
        OrderMatchingEngine orderMatchingEngine = new OrderMatchingEngine(stockStrings);
    }

    private static List<String> getRandomStockSymbols() {
        //TODO:
        List<String> strings = new ArrayList<>();
        strings.add("google");
        strings.add("apple");
        strings.add("airbnb");
        return strings;
    }

    private static void initializeRandomExchanges() {
        //TODO:
    }

    public static void addOrder(LimitOrder order) {
        orderMatchingEngine.addOrder(order);
    }

    public static void getStockDetails(String stock) {
        //TODO:
    }

    public static void getStockPrices(String stock) {
        //TODO:
    }

}
