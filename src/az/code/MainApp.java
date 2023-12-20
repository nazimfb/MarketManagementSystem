package az.code;

import az.code.model.Product;
import az.code.model.ProductType;
import az.code.service.MarketService;
import az.code.service.ProductService;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {
        createDefaultProducts();

        int choice;
        boolean exit = false;
        choice = printMainMenu();

        do{
            switch (choice) {
                case 1 -> printProductMenu();
                case 2 -> printSaleOpMMenu();
                case 3 -> exit = true; //exit
            }
        }while (!exit);
    }

    public static int printMainMenu() {
        System.out.println("1 - Product operations");
        System.out.println("2 - Sale operations");
        System.out.println("3 - exit");
        int choice = getChoice(3); //limit options to [1-3]

        return choice;
    }

    public static void printProductMenu() {
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
        ProductService.productMenuLogic(choice);
    }

    public static void printSaleOpMMenu() {
        System.out.println("Sale operations");
        System.out.println();
        System.out.println("1 - Add a Purchase");
        System.out.println("2 - Return Product from Purchase");
        System.out.println("3 - Delete Purchase");
        System.out.println("4 - Show All Purchases");
        System.out.println("5 - Show Purchases by Date Range");
        System.out.println("6 - Show Purchases by Price Range");
        System.out.println("7 - Search Purchases for One Date");
        System.out.println("8 - Show Purchase Info by Purchase Number");

        int choice = getChoice(8);
        MarketService.saleLogic(choice);
    }

    public static int getChoice(int range) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choice: ");
        int choice = scanner.nextInt();

        if (!(choice > 0 && choice <= range)) {
            System.out.printf("You must choose between 1-%d%n", range);
            choice=
            getChoice(range);
        }

        return choice;
    }

    public static void createDefaultProducts(){
        Product milk = new Product(1, "Milk", ProductType.DAIRY, 50, 2.4);
        Product butter = new Product( 2,"Butter", ProductType.DAIRY, 30, 15.2);
        Product whiteBread = new Product( 3,"White Bread", ProductType.BREAD_BAKERY, 150, 0.55);
        Product cheese = new Product( 4,"Cheese", ProductType.DELI, 46, 16.89);
        Product apple = new Product( 5,"Apple", ProductType.FRUITS, 60, 0.8);
        Product orange = new Product( 6,"Orange", ProductType.FRUITS, 25, 2.99);
        Product banana = new Product( 7,"Banana", ProductType.FRUITS, 40, 2.69);
        ProductService.products.add(butter);
        ProductService.products.add(milk);
        ProductService.products.add(whiteBread);
        ProductService.products.add(cheese);
        ProductService.products.add(apple);
        ProductService.products.add(orange);
        ProductService.products.add(banana);
    }
}
