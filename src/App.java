
//import entity.Author;
import entity.Product;
import entity.Sale;
import entity.Buyer;
import java.util.Arrays;
import java.util.Scanner;
import managers.ProductManager;
import managers.SalesManager;
import managers.BuyerManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pupil
 */
public class App {
    private Scanner scanner;
    private Product[] products;
    private Buyer[] buyers;
    private Sale[] sales;
    private double cash = 0;
    ProductManager productManager;
    BuyerManager buyerManager;
    SalesManager saleManager;
    private String imput;
    private int n, m;

    public App() {
        scanner = new Scanner(System.in);
        products = new Product[0];
        buyers = new Buyer[0];
        sales = new Sale[0];
        productManager = new ProductManager();
        buyerManager = new BuyerManager();
        saleManager = new SalesManager();
        this.testAddProduct();
        this.testAddBuyer();
    }

    public void run() {
        boolean repeat = true;
        do {
            System.out.println("1.print shop | 2.add product | 3.remove product | 4.edit product | 5.add buyer | 6.sale | 0.exit");
            System.out.print("> ");
            imput = scanner.nextLine();
            switch (imput) {
                case "0": // exit
                    repeat = false;
                    System.out.println("\nexit\n");
                    break;
                case "1": // print shop
                    this.printShop();
                    break;
                case "2": // add product
                    products = productManager.addProduct(products);
                    break;
                case "3": // remove product
                    products = productManager.removeProduct(products);
                    break;
                case "4": // edit product
                    products = productManager.editProduct(products);
                    break;
                case "5": // add buyer
                    buyers = buyerManager.addBuyer(buyers);
                    break;
                case "6": // sale
                    int before = sales.length;
                    Sale[] oldSales = sales;
                    sales = saleManager.sale(sales, products, buyers);
                    int after = sales.length;
                    if (after == before+1) {
                        double saleCash = 0;
                        saleCash = sales[after-1].getProduct().getCost()*sales[after-1].getProduct().getAmount();
                        sales[after-1].getBuyer().setCash(sales[after-1].getBuyer().getCash()-saleCash);
                        cash = cash + saleCash;
                    }
                    break;
                default:
                    System.out.println("\nno command\n");
            }
        } while (repeat);
    }
    
    private void printShop() {
        System.out.println("\nprint shop");
        System.out.println("products:");
        n = 1;
        for (int i=0; i<products.length; i++) {
            System.out.println(n + ". " + products[i].toString());
            ++n;
        }
        if (n == 1) {
            System.out.println("no");
        }
        System.out.println("buyers:");
        n = 1;
        for (int i=0; i<buyers.length; i++) {
            System.out.println(n + ". " + buyers[i].toString());
            ++n;
        }
        if (n == 1) {
            System.out.println("no");
        }
        System.out.println("sales:");
        n = 1;
        for (int i=0; i<sales.length; i++) {
            if (sales.length != 0) {
                System.out.println((i+1) + ". " + sales[i].toString());
                ++n;
            }
        }
        if (n == 1) {
            System.out.println("no");
        }
        System.out.println("cash: " + cash);
        System.out.println("");
    }
    
    // test dates
    
    private void testAddProduct() {
        Product[] testProduct = {
            new Product("Sneaker", 2.0, 10),
            new Product("Hiking boot", 1.5, 15),
            new Product("Running shoe", 1, 8),
            new Product("Slip-on", 3.2, 11),
            new Product("Ugg", 4.5, 9)
        };
        this.products = testProduct;
    }
    
    private void testAddBuyer() {
        Buyer[] testBuyers = {
            new Buyer("Jon Bull", "+372 5808-4444", 10),
            new Buyer("Alex Mans", "+372 5808-1111", 5),
        };
        this.buyers = testBuyers;
    }
    
}
