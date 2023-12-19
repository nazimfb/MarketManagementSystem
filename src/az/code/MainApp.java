package az.code;

import az.code.model.Product;
import az.code.model.ProductType;
import az.code.service.MarketService;
import az.code.service.ProductService;

import java.util.*;

public class MainApp {
    MarketService marketService = new MarketService();

    public static void main(String[] args) {
        Product milk = new Product(1,"Milk", ProductType.DAIRY,50,2.4);
        Product butter = new Product(2,"Butter", ProductType.DAIRY,30,15.2);
        Product whiteBread = new Product(23,"White Bread", ProductType.BREAD_BAKERY,150,0.55);
        Product cheese = new Product(51,"Cheese", ProductType.DELI,46,16.89);
        Product apple = new Product(40,"Apple", ProductType.FRUITS,60,0.8);
        Product orange = new Product(41,"Orange", ProductType.FRUITS,25,2.99);
        Product banana = new Product(42,"Banana", ProductType.FRUITS,40,2.69);
        ProductService.products.add(butter);
        ProductService.products.add(milk);
        ProductService.products.add(whiteBread);
        ProductService.products.add(cheese);
        ProductService.products.add(apple);
        ProductService.products.add(orange);
        ProductService.products.add(banana);

        Scanner sc = new Scanner(System.in);

        int choice = printMainMenu();
        boolean exit = false;

        while(!exit){
            switch (choice){
                case 1 -> printProductMenu();
                case 2 -> printSaleOpMMenu();
                case 3 -> exit = true; //exit
                default -> {
                    System.out.println("Number should be between 1,2 or 3 (exit): ");
                    exit = true;
                }
            }
            if (!exit) {
                choice = printMainMenu();
            }
        }
    }

    public static int printMainMenu() {
        System.out.println("1 - Product operations");
        System.out.println("2 - Sale operations");
        System.out.println("3 - exit");

        return getChoice(3);
    }
    public static void printProductMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Product operations");
        System.out.println();
        System.out.println("1 - Add Product");
        System.out.println("2 - Modify Product");
        System.out.println("3 - Delete Product");
        System.out.println("4 - Show All Product");
        System.out.println("5 - Show Products by Category");
        System.out.println("6 - Show Products by Price Range");
        System.out.println("7 - Search Products by Name");

        int choice = getChoice(7);
        ProductService.productLogic(choice);
    }
    public static void printSaleOpMMenu() {
        System.out.println("Sale operations");
        System.out.println();
        System.out.println("1 - Add a Sale");
        System.out.println("2 - Return Product from Sale");
        System.out.println("3 - Delete Sale");
        System.out.println("4 - Show All Sales");
        System.out.println("5 - Show Sales by Date Range");
        System.out.println("6 - Show Sales by Price Range");
        System.out.println("7 - Search Sales for One Date");
        System.out.println("8 - Show Sale Info by Sale Number");

        int choice = getChoice(8);
    }

    public static int getChoice(int range) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choice: ");
        int choice = sc.nextInt();

        if (!(choice>0 && choice<=range)) {
            System.out.printf("You must choose between 1-%d%n", range);
            getChoice(range);
        }

        return choice;
    }
}
