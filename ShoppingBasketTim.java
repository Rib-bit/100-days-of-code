package com.example.masterclass;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingBasketTim {
    private final String name;
    private final Map<StockItemTim, Integer> list;

    public ShoppingBasketTim(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItemTim item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return quantity;
        }
        return 0;
    }

    public int removeFromBasket(StockItemTim item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            int newQuantity = inBasket - quantity;

            if (newQuantity > 0) {
                list.put(item, newQuantity);
                return quantity;
            } else if(newQuantity == 0){
                list.remove(item); //Now *that* I forgot about
                return quantity;
            }
        }
        return 0;
    }

    public Map<StockItemTim, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\n" + name + "'s shopping basket contains " + list.size() + ((list.size()==1) ? " item" : " items") +"\n";
        double totalCost = 0.0;

        for (Map.Entry<StockItemTim, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ", " + item.getValue() + " in this basket\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost: $" + String.format("%.2f", totalCost);
    }

    public void clearBasket() {
        this.list.clear();
    }

    public String getName() {
        return name;
    }
}
