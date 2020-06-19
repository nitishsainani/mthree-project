package com.mthree.SORT;

import com.mthree.models.LimitOrder;
import com.mthree.models.Notification;
import com.mthree.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class OrderMatchingEngine implements Runnable {
    public OrderBook orderBook;
    public List<String> stockStrings;

    @Autowired
    private NotificationService notificationService;

    public OrderMatchingEngine(List<String> stockStrings) {
        this.stockStrings = stockStrings;
        this.orderBook = new OrderBook(stockStrings);
    }

    public void addOrder(LimitOrder order) {
        if(order.getSide().equals("buy")) {
            orderBook.buyOrders.get(order.getInstrumentName()).add(order);
        } else if(order.getSide().equals("sell")) {
            orderBook.sellOrders.get(order.getInstrumentName()).add(order);
        }
    }

    private void updateOrder(LimitOrder order) {
        //TODO: add notification
        System.out.println("*********************");
        System.out.println(order.getOrderId() + " Partial Completed   " + order.toString() + order.getPrice() + " " + order.getQuantity());
//        notificationService.addNotif(new Notification("Your order is partially filled", order.getUserId()), order.getUserId().getUserId());
        System.out.println("*********************");
    }

    private void completeOrder(LimitOrder order) {
        //TODO: update order in database
        System.out.println("*********************");
        System.out.println(order.getOrderId() + " Completed   " + order.toString() + order.getPrice() + " " + order.getQuantity());
        System.out.println("*********************");
//        notificationService.addNotif(new Notification("Your order is Completely filled", order.getUserId()), order.getUserId().getUserId());
    }

    private void startMatching() {
        while(true) {
            for(String symbol : stockStrings) {
                try {
                    PriorityQueue<LimitOrder> stockBuyOrders = orderBook.buyOrders.get(symbol);
                    PriorityQueue<LimitOrder> stockSellOrders = orderBook.sellOrders.get(symbol);
                    LimitOrder bestBuyOrder = stockBuyOrders.peek();
                    LimitOrder bestSellOrder = stockSellOrders.peek();
//                    System.out.println("order comparing" + bestBuyOrder.getOrderId() + " " + bestSellOrder.getOrderId());
                    if(bestBuyOrder.getPrice() >= bestSellOrder.getPrice()) {
                        int buyQuantity = bestBuyOrder.getQuantity();
                        int sellQuantity = bestSellOrder.getQuantity();
                        if(buyQuantity > sellQuantity) {
                            completeOrder(stockSellOrders.poll());
                            bestBuyOrder.setQuantity(buyQuantity - sellQuantity);
                            updateOrder(bestBuyOrder);
                        } else if (sellQuantity > buyQuantity) {
                            completeOrder(stockBuyOrders.poll());
                            bestSellOrder.setQuantity(sellQuantity - buyQuantity);
                            updateOrder(bestSellOrder);
                        } else {
                            completeOrder(stockBuyOrders.poll());
                            completeOrder(stockSellOrders.poll());
                        }
                    }
                } catch (Exception ignored) {}
            }
        }
    }

    @Override
    public void run() {
        startMatching();
    }

    public static void main(String[] args) {
        String google = "google";
        String apple = "apple";
        String airbnb = "airbnb";
        List<String> strings = new ArrayList<>();
        strings.add(google);
        strings.add(apple);
        strings.add(airbnb);

        OrderMatchingEngine orderMatchingEngine = new OrderMatchingEngine(strings);
        Thread t1 = new Thread(orderMatchingEngine);
        t1.start();
        OrderBook orderBook = orderMatchingEngine.orderBook;
        orderBook.buyOrders.get(google).add(new LimitOrder(
                1, "buy", "pending", 1, 300.00, google, 100));
        orderBook.buyOrders.get(google).add(new LimitOrder(
                2, "buy", "pending", 1, 400.00, google, 100));
        orderBook.sellOrders.get(google).add(new LimitOrder(
                3, "sell", "pending", 1, 300.00, google, 150));
    }
}
