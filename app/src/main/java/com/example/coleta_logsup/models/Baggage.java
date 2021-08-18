package com.example.coleta_logsup.models;

public class Baggage {
    private int id;
    private String user;
    private int quantity;
    private double price;

    public Baggage() {
    }

    public Baggage(String name, int category, int quantity, double price) {
        this.user = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void retrieve(int value){
        quantity = quantity - value;
    }

    public void reclaim(int value){
        quantity = quantity + value;
    }

    public String toCurrency(double value){
        return String.format("R$ %.2f", price);
    }
}
