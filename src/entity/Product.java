/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Arrays;

/**
 *
 * @author pupil
 */
public class Product {
    
    private String name;
    private double cost;
    private int amount;

    public Product() {
    }
    
    public Product(String name, double cost, int amount) {
        this.name = name;
        this.cost = cost;
        this.amount = amount;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    public int getAmount() {
        return this.amount;
    }
    
    @Override
    public String toString() {
        return "product{" + 
                "name=" + this.name + 
                ", cost=" + this.cost + 
                ", amount=" + this.amount + 
                '}';
    }

}
