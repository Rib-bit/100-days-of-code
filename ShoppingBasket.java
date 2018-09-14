package com.example.masterclass;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingBasket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public ShoppingBasket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);//is it in your basket already? if not, 0
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            int desired = inBasket - quantity;

            if ((desired < 0) || (inBasket == 0)) {
                System.out.println("You may not remove more items than you have");
                return 0;
            }

            list.replace(item, inBasket, desired);
            item.reserveItem(-quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\n" + name + "'s shopping basket contains " + list.size() + ((list.size()==1) ? " item" : " items") +"\n";
        double totalCost = 0.0;

        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ", " + item.getValue() + " puchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost: $" + String.format("%.2f", totalCost);
    }

    public void checkOut() {
        System.out.println(this.name + "'s basket: proceeding to checkout");
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            int amountReserved = item.getValue();
            StockItem itemInBasket = item.getKey();

            itemInBasket.reserveItem(-amountReserved);
            itemInBasket.adjustStock(-amountReserved);
        }
        System.out.println(toString());
        System.out.println("Thank you for your business!");
        this.list.clear();
    }
}
