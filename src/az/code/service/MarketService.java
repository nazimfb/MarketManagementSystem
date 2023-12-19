package az.code.service;

import az.code.model.Product;
import az.code.model.ProductType;
import az.code.model.Purchase;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class MarketService {
    private List<Purchase> purchases;

//    public MarketService() {
//        products = new ArrayList<>();
//        purchases = new ArrayList<>();
//    }
//
//    public void addSale(Product product) {
//        product.setCode(1);
//        products.add(product);
//    }

    public static void productLogic(int choice){
        Scanner sc =  new Scanner(System.in);
        List<String> categoryList = new ArrayList<>();
        for (ProductType p : EnumSet.allOf(ProductType.class)) {
            categoryList.add(String.valueOf(p));
        }

        switch (choice){
            case 1 -> {
                System.out.println("Available Categories: " + categoryList);
                System.out.print("Input Product Category: ");
                String catName = sc.nextLine();
                while(!categoryList.contains(catName)){
                    System.out.print("False category name. Try again:");
                    catName = sc.nextLine();
                }

                System.out.print("Input Product name: ");
                String name = sc.nextLine();
                System.out.print("Input Product code: ");
                long code = sc.nextLong();
                System.out.print(String.format("How many %ss: ",name));
                int count = sc.nextInt();
                System.out.print("Input Product Price: ");
                double price = sc.nextDouble();

                Product product = new Product(code,name, ProductType.valueOf(catName),count,price);
                ProductService.products.add(product);
                System.out.println("Product " + product + "has been added.");
            }
            case 2 -> {
                System.out.print("Enter product code which you want to change: ");
                long code = sc.nextLong();

                for (Product product : products) {
                    if(product.getCode()==code){
                        System.out.print("Enter new name([Enter]=pass): ");
                        String newName = sc.nextLine();
                        if(newName.isEmpty()){
                            newName=product.getName();
                        }
                        System.out.print("Enter new price([Enter]=pass): ");
                        double newPrice = sc.nextDouble();
                        if(!sc.hasNextDouble()){
                            newName=product.getName();
                        }

                        System.out.print("Enter new count([Enter]=pass): ");
                        int newCount = sc.nextInt();
                        if(!sc.hasNextInt())
                            newCount=product.getCount();

                        product = new Product(product.getCode(),newName,product.getCategory(),newCount,newPrice);
                        System.out.println("Product has been changed.");
                    }
                }

            }
            case 3 -> {
                System.out.print("Enter product code which you want to delete: ");
                long code = sc.nextLong();
                for (Product product : products) {
                    if (product.getCode() == code) {
                        products.remove(product);
                        System.out.println("Product is deleted.");
                        break;
                    }
                }
            }
            case 4 -> {
                System.out.println("All Available Products: \n" + products + " Products " +
                        "count: " + products.toArray().length);
            }
            case 5 -> {
                System.out.println("Available Categories: " + categoryList);
                System.out.print("Input Product Category: ");
                String catName = sc.nextLine();
                while(!categoryList.contains(catName)){
                    System.out.print("False category name. Try again:");
                    catName = sc.nextLine();
                }
                List<Product> showProductsByCategory = new ArrayList<>();
                for (Product product : products) {
                    if (String.valueOf(product.getCategory()).equals(catName)) {
                        showProductsByCategory.add(product);
                    }
                }
                if(!showProductsByCategory.isEmpty()) {
                    System.out.println(String.format("Products in category %s: ",catName) + showProductsByCategory);
                }
                else System.out.println(String.format("There are no products by category %s.", catName));
            }
            case 6 -> {
                System.out.print("Asagi qiymet: ");
                double asagi = sc.nextDouble();
                System.out.print("Yuxari qiymet: ");
                double yuxari = sc.nextDouble();

                List<Product> showProductsByPrice = new ArrayList<>();
                for (Product product : products) {
                    if (asagi < product.getPrice() && product.getPrice() < yuxari) {
                        showProductsByPrice.add(product);
                    }
                }
                if(!showProductsByPrice.isEmpty()) {
                    System.out.println(String.format("Products in price range %f - %f: ",asagi,yuxari) + showProductsByPrice);
                }
                else System.out.println(String.format("There are no products in price range %f - %f.", asagi, yuxari));
            }
            case 7 -> {
                System.out.print("Enter product name for search: ");
                String search = sc.nextLine();

                List<Product> getProducts = new ArrayList<>();
                for (Product product : products) {
                    String name = product.getName();
                    if (name.equals(search))
                        getProducts.add(product);
                }
                if(!getProducts.isEmpty()) {
                    System.out.println(String.format("There are %d products by name %s: ",getProducts.toArray().length,search) + getProducts);
                }
                else System.out.println(String.format("There are no products with name %s.", search) + getProducts);
            }
        }
    }
}
