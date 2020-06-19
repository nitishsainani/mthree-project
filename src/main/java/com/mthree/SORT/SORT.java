package com.mthree.SORT;

import com.mthree.RandomData.RandomData;
import com.mthree.models.LimitOrder;
import com.mthree.models.MarketOrder;
import com.mthree.models.Notification;
import com.mthree.models.User;
import com.mthree.responses.BaseResponse;
import com.mthree.responses.StockTableResponse;
import com.mthree.services.NotificationService;
import com.mthree.services.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class SORT {
    public static OrderMatchingEngine orderMatchingEngine;
    public static List<Exchange> exchanges;
    private static OrderService orderService = new OrderService();
    private static final RandomData randomData = new RandomData();

    public static void initialize() {
        initializeRandomExchanges();
        List<String> stockSymbolStrings = getRandomStockSymbols();
        orderMatchingEngine = new OrderMatchingEngine(stockSymbolStrings);
        Thread t1 = new Thread(orderMatchingEngine);
        t1.start();
    }

    private static List<String> getRandomStockSymbols() {
        return randomData.companySymbols;
    }

    private static void initializeRandomExchanges() {
        exchanges = randomData.exchanges;
    }

    public static void addMarketOrder(MarketOrder order, int userId, int instrumentId) {
        new OrderService().addNewMarketOrder(order, userId, instrumentId);
        new NotificationService().addNotif(new Notification("Your New Order Added: "+order.getOrderId(), order.getUserId()), userId);
    }

    public static void addLimitOrder(LimitOrder order, int userId, int instrumentId) {
        System.out.println("added order to matching engine");
        orderMatchingEngine.addOrder(order);
    }

    public static String getCurrentTimeInString() {
        return String.valueOf(LocalDateTime.now().getHour()) + String.valueOf(LocalDateTime.now().getMinute());
    }

    public static Stock getStockDetails(String symbol) {
        String time = SORT.getCurrentTimeInString();
        Double minPrice = 10000000.00;
        HashMap<String, Double> minPriceData = exchanges.get(0).stocks.get(symbol).getPriceData();
        for(Exchange exchange: exchanges) {
            Double price = exchange.stocks.get(symbol).getPriceData().get(time);
            HashMap<String, Double> priceData = exchange.stocks.get(symbol).getPriceData();
            if(price < minPrice) {
                minPrice = price;
                minPriceData = priceData;
            }
        }
        return new Stock(symbol, exchanges.get(0).stocks.get(symbol).getName(), minPriceData);
    }

    public static Exchange getAllStocks(String stock) {
        return exchanges.get(0);
    }

    public static StockTableResponse getMainPageData() {
        return new StockTableResponse(exchanges.get(0).stocks);
    }

    public static void main(String[] args) {
        SORT.getStockDetails("");
    }
}
