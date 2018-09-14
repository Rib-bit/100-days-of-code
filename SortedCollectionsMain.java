package com.example.masterclass;

import java.util.Map;

/*
we've looked at the List interface, its implementations in ArrayList and LinkedList
and the Map interface, and HashMap
and the Set interface, and HashSet

We will come back the the Queue and Deque interfaces later

we'll be looking at variants of HashMap and HashSet today: LinkedHashMap and LinkedHashSet
    maintain insertion order

There are also sorted versions of these: SortedMap and SortedSet, implemented in TreeMap and TreeSet
    we'll take a quick look at those as well

The operations on Sets and Maps are so similar that we can use examples for Maps only and still make sens of it all
 */
public class SortedCollectionsMain {

    private static StockListTim stockList = new StockListTim();

    public static void main(String[] args) {

        StockItemTim temp;

        temp = new StockItemTim("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItemTim("cake", 1.10, 8);
        stockList.addStock(temp);

        temp = new StockItemTim("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItemTim("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItemTim("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItemTim("cup", 0.50, 7);
        stockList.addStock(temp);

        temp = new StockItemTim("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItemTim("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItemTim("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItemTim("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItemTim("vase", 8.76, 40);
        stockList.addStock(temp);

        /*System.out.println(stockList);
        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }
*/
        ShoppingBasketTim myBasket = new ShoppingBasketTim("Alex");
        ShoppingBasketTim hisBasket = new ShoppingBasketTim("Joe");

        System.out.println(stockList);

        sellItem(myBasket, "car", 1);
        System.out.println(myBasket);
        System.out.println(stockList);
        sellItem(myBasket, "car", 1);
//        System.out.println(myBasket);
        sellItem(myBasket, "car", 1);
//        System.out.println(myBasket);
        sellItem(myBasket, "spanner", 1);

        sellItem(myBasket, "juice", 4);
        sellItem(myBasket, "cup", 12);
        sellItem(myBasket, "bread", 1);

        sellItem(hisBasket, "cup", 100);
        sellItem(hisBasket, "juice", 5);
        removeItem(hisBasket, "cup", 1);

        removeItem(myBasket, "car", 1);
        removeItem(myBasket, "cup", 9);
        removeItem(myBasket, "car", 1);
        System.out.println("Cars removed: " + removeItem(myBasket, "car", 1));

        System.out.println(myBasket);

        removeItem(myBasket, "bread", 1);
        removeItem(myBasket, "cup", 3);
        removeItem(myBasket, "juice", 4);
        removeItem(myBasket, "cup", 3);

        System.out.println(myBasket);
        System.out.println(hisBasket);

        System.out.println(stockList);
        checkOut(hisBasket);
        System.out.println(hisBasket);
        System.out.println(stockList);

        checkOut(myBasket);
        System.out.println(myBasket);
        /*temp = new StockItemTim("pen", 1.12);
        stockList.Items().put(temp.getName(), temp); //our unmodifiableMap works, the Map can't be modified externally
        System.out.println(stockList);*/

        /*stockList.Items().get("car").adjustStock(2000);//but we may modify items in the unmodifiableMap
        stockList.get("car").adjustStock(-1000); //although our system is designed with a get method anyway
        System.out.println(stockList);*/

        //if we take a look at our PriceList() method, it returns a LinkedHashMap that is also unmodifiable
        //but it also goes the extra step of not providing the object itself, just the name and the price
       /* for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
        */
    }

    public static int sellItem(ShoppingBasketTim basket, String item, int quantity) {
//        System.out.println("entering sellItem() for " + basket.getName() + "'s " + item + "(" + quantity + ")");
        StockItemTim stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (stockList.reserveStock(item, quantity) != 0) {
            System.out.println("adding " + item + "(" + quantity + ") to " + basket.getName() + "'s basket.");

            return basket.addToBasket(stockItem, quantity);
        }
       /* int available = stockItem.availableQuantity();
        if (available != 0) {
            sellItem(basket, item, available);
            System.out.println("Sorry! We only have " + available + " " + item + (available > 1 ? "s" : "") + " available. " +
                    "We've added " + (available > 1 ? "them" : "it") + " to your basket.");
            return available;
        }
        */
        System.out.println("Apologies! Item -- " + item + " -- out of stock : " + stockItem.availableQuantity());


        return 0;
    }

    public static int removeItem(ShoppingBasketTim basket, String item, int quantity) {
//        System.out.println("entering removeItem() for " + basket.getName() + "'s " + item + "(" + quantity + ")");
        StockItemTim stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (basket.removeFromBasket(stockItem, quantity) == quantity) {//woops, forgot to adapt validation
            System.out.println("The amount of " + item + " in " + basket.getName() + "'s basket has been reduced by " + quantity);
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(ShoppingBasketTim basket) {
        for (Map.Entry<StockItemTim, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());//should really be checking the return value of sellStock()
            //but since the quantities are coming from the basket's Items(), and were checked before being added to it, this approach is safe
            //we could let this method throw an exception if sellStock returns 0
        }
        basket.clearBasket();
    }

}
