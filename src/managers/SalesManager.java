/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Product;
import entity.Sale;
import entity.Buyer;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class SalesManager {
    private final Scanner scanner;
    private String imput;

    public SalesManager() {
        scanner = new Scanner(System.in);
    }
    
    public Sale[] sale(Sale[] sales, Product[] products, Buyer[] buyers) {
        System.out.println("\nsale");
        Sale h = new Sale();
        System.out.print("product #: ");
        imput = scanner.nextLine();
        h.setProduct(products[Integer.parseInt(imput)-1]);
        int productId = Integer.parseInt(imput)-1;
        System.out.print("buyer #: ");
        imput = scanner.nextLine();
        h.setBuyer(buyers[Integer.parseInt(imput)-1]);
        System.out.print("amount [max=" + products[productId].getAmount() + "]: ");
        imput = scanner.nextLine();
        if ((h.getBuyer().getCash() >= h.getProduct().getCost()*Integer.parseInt(imput)) && (Integer.parseInt(imput) <= products[productId].getAmount())) {
            Product p = h.getProduct();
            Product newp = new Product(p.getName(), p.getCost(), Integer.parseInt(imput));
            p.setAmount(products[productId].getAmount() - Integer.parseInt(imput));
            h.setProduct(newp);
            h.setSaleDate(new GregorianCalendar().getTime());
            System.out.println(h.toString() + "\n");
            sales = Arrays.copyOf(sales, sales.length+1);
            sales[sales.length-1] = h;
        } else {
            System.out.println("error!\n");
//            System.out.println("error! max=" + products[productId].getAmount() + "\n");
        }
        return sales;
    }
    
}
