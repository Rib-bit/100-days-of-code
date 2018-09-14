package com.example.masterclass;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockListTim {
    private final Map<String, StockItemTim> list;

    public StockListTim() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItemTim item) {
        if (item != null) {
            // check if we already have quantities of this item
            StockItemTim inStock = list.getOrDefault(item.getName(), item);//attribute the item to inStock from the list if it exists
            // , or attribute the item parameter to inStock
            //If there are already stocks, adjust quantities
            if (inStock != item) {
                item.adjustStock(inStock.availableQuantity());
            }

            list.put(item.getName(), item);
            return item.availableQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItemTim inStock = list.get(item);

        if ((inStock != null) && (quantity > 0)) {
            return inStock.finaliseStock(quantity);
        }
        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItemTim inStock = list.get(item);

        if ((inStock != null) && (quantity > 0)) {
            return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item, int quantity) {
        StockItemTim inStock = list.get(item);

        if ((inStock != null) && (quantity > 0)) {
            return inStock.unreserveStock(quantity);
        }
        return 0;
    }

    public StockItemTim get(String itemName) {
        return list.get(itemName);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItemTim> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItemTim> Items() {
        return Collections.unmodifiableMap(list);//what it says on the tin
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItemTim> item : list.entrySet()) {
            StockItemTim stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s = s + stockItem + ", There are " + stockItem.availableQuantity() + " in stock. Value of item: ";
            s = s + String.format("%.2f", itemValue) + "\n";

            totalCost += itemValue;
        }

        return s + "Total stock value " + String.format("%.2f", totalCost);
    }
}
