package com.example.demo;

public class Product {

    private static int ids;
    private int id;
    private String name;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getIds() {
        return ids;
    }

    public static void setIds(int ids) {
        Product.ids = ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    Product(String name, double price){
        this.id = ++ids;
        this.name = name;
        this.price = price;
    }

}
