package com.kevinlorenzo.learning.junit.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private List<Double> prices = new ArrayList<>();

    private double discount;

    public double getTotal() {
        return this.prices.stream().mapToDouble(d -> (d * ((100 - discount) / 100))).sum();
    }

    public void addPrice(double price) {
        this.prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
}