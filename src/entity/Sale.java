/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pupil
 */
public class Sale {
    
    private Product product;
    private Buyer buyer;
    private Date saleDate;

    public Sale() {
    }

    public Sale(Product product, Buyer buyer, Date saleDate) {
        this.product = product;
        this.buyer = buyer;
        this.saleDate = saleDate;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Product getProduct() {
        return this.product;
    }

    public Buyer getBuyer() {
        return this.buyer;
    }

    public Date getSaleDate() {
        return this.saleDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return "sale{" + 
                "product=" + product + 
                ", buyer=" + buyer + 
                ", saleDate=" + sdf.format(saleDate) + 
                '}';
    }
    
}
