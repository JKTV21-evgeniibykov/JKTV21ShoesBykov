/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Buyer;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class BuyerManager {
    private final Scanner scanner;
    private String imput;

    public BuyerManager() {
        scanner = new Scanner(System.in);
    }
    
    public Buyer[] addBuyer(Buyer[] buyers) {
        System.out.println("\nadd reader");
        Buyer buyer = new Buyer();
        System.out.print("name: ");
        imput = scanner.nextLine();
        buyer.setName(imput);
        System.out.print("phone: ");
        imput = scanner.nextLine();
        buyer.setPhone(imput);
        System.out.println(buyer.toString() + "\n");
        buyers = Arrays.copyOf(buyers, buyers.length+1);
        buyers[buyers.length-1] = buyer;
        return buyers;
    }
}
