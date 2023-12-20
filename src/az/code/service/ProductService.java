package az.code.service;

import az.code.model.Product;
import az.code.model.ProductType;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    public static List<Product> products = new ArrayList<>();
    private static List<String> categoryList = new ArrayList<>();

    public static void productMenuLogic(int choice) {
        for (ProductType p : EnumSet.allOf(ProductType.class)) {
            categoryList.add(String.valueOf(p));
        }

        Scanner sc = new Scanner(System.in);
        switch (choice) {
            case 1 -> {
                Product product = addProduct();
                System.out.println("Product " + product + "has been added.");
            }
            case 2 -> {
                System.out.print("Enter product code which you want to change: ");
                long code = sc.nextLong();
                sc.nextLine();

                for (Product product : products) {
                    if (product.getCode() == code) {
                        System.out.print("Enter new name([Enter]=pass): ");
                        String newName = sc.nextLine();
                        if (newName.isEmpty())
                            newName = product.getName();

                        System.out.print("Enter new price([Enter]=pass): ");
                        double newPrice = sc.nextDouble();
                        if (!sc.hasNextDouble())
                            newName = product.getName();

                        System.out.print("Enter new count([Enter]=pass): ");
                        int newCount = sc.nextInt();
                        if (!sc.hasNextInt())
                            newCount = product.getCount();

                        product.setCount(newCount);
                        product.setName(newName);
                        product.setPrice(newPrice);
                        System.out.println("Product has been changed.");
                        break;
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
                while (!categoryList.contains(catName)) {
                    System.out.print("False category name. Try again:");
                    catName = sc.nextLine();
                }
                List<Product> showProductsByCategory = new ArrayList<>();
                for (Product product : products) {
                    if (String.valueOf(product.getCategory()).equals(catName)) {
                        showProductsByCategory.add(product);
                    }
                }
                if (!showProductsByCategory.isEmpty()) {
                    System.out.println(String.format("Products in category %s: ", catName) + showProductsByCategory);
                } else System.out.println(String.format("There are no products by category %s.", catName));
            }
            case 6 -> {
                System.out.print("Low price: ");
                double asagi = sc.nextDouble();
                System.out.print("Up price: ");
                double yuxari = sc.nextDouble();

                List<Product> showProductsByPrice = new ArrayList<>();
                for (Product product : products) {
                    if (asagi < product.getPrice() && product.getPrice() < yuxari) {
                        showProductsByPrice.add(product);
                    }
                }
                if (!showProductsByPrice.isEmpty()) {
                    System.out.println(String.format("Products in price range %f - %f: ", asagi, yuxari) + showProductsByPrice);
                } else
                    System.out.println(String.format("There are no products in price range %f - %f.", asagi, yuxari));
            }
            case 7 -> {
                System.out.print("Enter product name for search: ");
                String search = sc.nextLine();
                List<Product> results = searchProductByName(search);
                if (results.size()==0)
                    System.out.println(String.format("There are no products for search %s.", search));
                else
                    System.out.println(String.format("There are %d products by search %s: \n", results.size(), search) + results);
            }
        }
    }

    public static Product addProduct() {
        if (products.size() <= 10000) {
            Scanner sc = new Scanner(System.in);
            String catName = chooseCategoryName();

            System.out.print("Input Product name: ");
            String name = sc.nextLine();
            System.out.print(String.format("How many %ss to add: ", name));
            int count = sc.nextInt();
            System.out.print("Input Product Price: ");
            double price = sc.nextDouble();

            long code;
            do {
                code = (long) (Math.random() * 100001);
            } while (codeExists(code));

            Product product = new Product(code, name, ProductType.valueOf(catName), count, price);
            products.add(product);
            product.setCode(products.indexOf(product));

            return product;

        } else {
            System.out.println("Market reached product limit of 100000, \n please delete some products before adding new.");
            return null;
        }
    }

    public static String chooseCategoryName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Available Categories: " + categoryList);
        System.out.print("Input Product Category: ");
        String catName = sc.nextLine();

        while (!categoryList.contains(catName)) {
            System.out.print("False category name. Try again:");
            catName = sc.nextLine();
        }
        return catName;
    }

    public static boolean codeExists (long code) {
        for (Product p : products) {
            if (p.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    public static List<Product> searchProductByName(String search){
        List<Product> searchResults = new ArrayList<>();
        for (Product product : products) {
            String name = product.getName();
            if (name.equals(search) || name.contains(search))
                searchResults.add(product);
        }

        return searchResults;
    }
    public static Product searchProductByCode(long searchCode){
        for (Product product : products) {
            long code = product.getCode();
            if (code == searchCode)
                return product;
        }
        return null;
    }

}
