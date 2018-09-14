package com.example.masterclass;

public class StockItem implements Comparable{
    private final String name;
    private double price;
    private int quantityInStock;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    @Override
    public int compareTo(Object o) {
//        System.out.println("Entering StockItem.compareTo()");
        if (this == o) {
            return 0;
        }
        if (o != null) {
            StockItem obj = (StockItem) o;
            return this.name.compareTo(obj.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public boolean equals(Object obj) {
//        System.out.println("Entering StockItem.equals()");
        if (obj == this) {
         return true;
        }

        if((obj==null) || (obj.getClass()!=this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public String toString() {
        return this.name + ": $" + this.price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getReserved() {
        return reserved;
    }

    public int availableQuantity() {
        return quantityInStock - reserved;
    }

    public void reserveItem(int quantity) {
        int newQuantity = this.reserved + quantity;
        if(newQuantity>=0) {
            this.reserved = newQuantity;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if(newQuantity>=0) {
            this.quantityInStock = newQuantity;
        }
    }
}
