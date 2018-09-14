package com.example.masterclass;

public class StockItemTim implements Comparable{
    private final String name;
    private double price;
    private int quantityInStock;
    private int reserved;

    public StockItemTim(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;
        this.reserved = 0;
    }

    public StockItemTim(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityStock;
        this.reserved = 0;
    }

    @Override
    public int compareTo(Object o) {
//        System.out.println("Entering StockItem.compareTo()");
        if (this == o) {
            return 0;
        }
        if (o != null) {
            StockItemTim obj = (StockItemTim) o;
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

        String objName = ((StockItemTim) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public String toString() {
        return this.name + ": $" + this.price + ". Reserved: " + this.reserved;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityInStock - reserved;
    }

    public int reserveStock(int quantity) {
        if (quantity <= availableQuantity()) {
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantity) {
        if (quantity <= reserved) {
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int finaliseStock(int quantity) {
        if (quantity <= reserved) {
            quantityInStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if(newQuantity>=0) {
            this.quantityInStock = newQuantity;
        }
    }
}
