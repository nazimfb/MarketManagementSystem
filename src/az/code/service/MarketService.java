package az.code.service;

import az.code.model.Product;
import az.code.model.ProductType;
import az.code.model.Purchase;
import az.code.model.PurchaseItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class MarketService {
//    public MarketService() {
//        products = new ArrayList<>();
//    }
//
//    public void addSale(Product product) {
//        product.setCode(1);
//        products.add(product);
//    }
    static List<Purchase> purchases = new ArrayList<>();

    public static void saleLogic(int choice){
        List<PurchaseItem> purchaseItemList = new ArrayList<>();

        Scanner sc =  new Scanner(System.in);
        switch (choice){
            case 1 -> {
                System.out.println("How many types of products will be sold: ");
                int productsCount = Integer.valueOf(sc.nextLine());

                String[] str;
                PurchaseItem purchaseItem;

                long purchaseItemRandomId;
                double totalPrice = 0;
                long code;
                int count;

                for (int i = 1; i <= productsCount; i++) {
                    System.out.print("Input Product <code:count>: ");
                    str = sc.nextLine().split(":");
                    code = Long.valueOf(str[0]);
                    count = Integer.valueOf(str[1]);
                    if (count>0) {
                        for (Product p: ProductService.products){
                            if (p.getCount()>=count && p.getCode()==code){
                                totalPrice += (p.getPrice()*count);
                                purchaseItemRandomId = (long) Math.random()*100000;
//                                for(PurchaseItem pI:purchaseItemList){
//                                    if(pI.getId()==purchaseItemRandomId){
//                                        System.out.printf("Purchase Item with id %d already exists.",purchaseItemRandomId);
//    //                                  break;
//                                        purchaseItemRandomId = (long) Math.random()*100000;
//                                    }
//                                }
                                p.setCount(p.getCount()-count);
                                purchaseItem = new PurchaseItem(1L,p.getCode(),count);
                                purchaseItemList.add(purchaseItem);
                                }
                        }
                    }
                        else if(count<=0){
                            System.out.println("<count> should be positive number");
                        }
                    }
                LocalDateTime date = LocalDateTime.now();
                long id = (long) (Math.random()*100001);
                Purchase purchase = new Purchase(id,totalPrice,purchaseItemList, date);
                purchases.add(purchase);
                System.out.printf("Sale created with id: %d, total price: %f date: %s",purchase.getId(),purchase.getTotalPrice(),String.valueOf(date) + "\n");
            }

            case 4 ->{
                System.out.println("All purchases: ");
                for (Purchase p:purchases) {
                    System.out.println("Purchase " + p.getId() + " totalPrice: " + p.getTotalPrice()
                            + " mehsul sayi: " + p.getPurchaseItemsCount() + " tarixi: " + p.getCreationDate());
                }
            }
        }
    }
}

