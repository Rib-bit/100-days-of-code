package com.example.masterclass;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // check if we already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);//attribute the item to inStock from the list if it exists
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

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null); //here we assume that we are selling something that exists in the list

        if ((inStock != null) && (inStock.availableQuantity() >= quantity) && (quantity > 0)) {
            /*if (checkOut) {
                inStock.adjustStock(-quantity);
            }*/
            inStock.reserveItem(quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String itemName) {
        return list.get(itemName);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);//what it says on the tin
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s = s + stockItem + ", There are " + stockItem.availableQuantity() + " in stock. Value of item: ";
            s = s + String.format("%.2f", itemValue) + "\n";

            totalCost += itemValue;
        }

        return s + "Total stock value " + String.format("%.2f", totalCost);
    }
}
