/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author pupil
 */
public class Buyer {
    
    private String name;
    private String phone;
    private double cash;
    
    public Buyer() {
    }

    public Buyer(String name, String phone, double cash) {
        this.name = name;
        this.phone = phone;
        this.cash = cash;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return "buyer{" + 
                "name=" + name + 
                ", phone=" + phone + 
                ", cash=" + cash + 
                '}';
    }
    
}
