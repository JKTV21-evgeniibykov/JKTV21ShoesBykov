/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Product;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ProductManager {
    private final Scanner scanner;
    private String imput;
    private int n, m;
    
    public ProductManager() {
        scanner = new Scanner(System.in);
    }
    
    public Product[] addProduct(Product[] products) {
        System.out.println("\nadd product");
        Product product = new Product();
        System.out.print("name: ");
        imput = scanner.nextLine();
        product.setName(imput);
        System.out.print("cost: ");
        imput = scanner.nextLine();
        product.setCost(Double.parseDouble(imput));
        System.out.print("amount: ");
        imput = scanner.nextLine();
        product.setAmount(Integer.parseInt(imput));
        System.out.println(product.toString() + "\n");
        products = Arrays.copyOf(products, products.length+1);
        products[products.length-1] = product;
        return products;
    }
    
    public Product[] editProduct(Product[] products) {
        System.out.println("\nedit product");
         System.out.print("product #: ");
         imput = scanner.nextLine();
         n = Integer.parseInt(imput)-1;
         Product oldProduct = products[n];
         Product chProduct = new Product();
         System.out.print("name [" + oldProduct.getName() + " / -]: ");
         imput = scanner.nextLine();
         if (!imput.equals("-")) {
             chProduct.setName(imput);
         } else {
             chProduct.setName(oldProduct.getName());
         }
         System.out.print("cost [" + oldProduct.getCost() + " / -]: ");
         imput = scanner.nextLine();
         if (!imput.equals("-")) {
             chProduct.setCost(Double.parseDouble(imput));
         } else {
             chProduct.setCost(oldProduct.getCost());
         }
         System.out.print("amount [" + oldProduct.getAmount() + " / -]: ");
         imput = scanner.nextLine();
         if (!imput.equals("-")) {
             chProduct.setAmount(Integer.parseInt(imput));
         } else {
             chProduct.setAmount(oldProduct.getAmount());
         }

         System.out.println(chProduct.toString() + "\n");
         products[n] = chProduct;        
        return products;
    }
    
    public Product[] removeProduct(Product[] products) {
        System.out.println("\nremove product");
        System.out.print("product #: ");
        imput = scanner.nextLine();
        n = Integer.parseInt(imput)-1;
        Product[] newProducts = Arrays.copyOf(products, products.length-1);
        int j = 0;
        for (int i=0; i<products.length; i++) {
            if (n != i) {
                newProducts[j] = products[i];
                ++j;
            }
        }
        System.out.println("");
        return newProducts;
    }
    
}
