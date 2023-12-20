package az.code.service;

import az.code.model.Product;
import az.code.model.Purchase;
import az.code.model.PurchaseItem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    static List<Long> purchaseIds = new ArrayList<>();
    static List<PurchaseItem> purchaseItemList = new ArrayList<>();
    static List<Long> productCodes = new ArrayList<>();

    public static void saleLogic(int choice){
        for(Purchase p:purchases){
            purchaseIds.add(p.getId());
        }
        for(Product pr:ProductService.products){
            productCodes.add(pr.getCode());
        }

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
                                for(PurchaseItem pI:purchaseItemList){
                                    if(pI.getId()==purchaseItemRandomId){
                                        purchaseItemRandomId = (long) Math.random()*100000;
                                    }
                                }
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
                long saleId = (long) (Math.random()*100001);
                for(PurchaseItem pI:purchaseItemList){
                    if(pI.getId()==saleId){
                        saleId = (long) Math.random()*100000;
                    }
                }

                Purchase purchase = new Purchase(saleId,totalPrice,purchaseItemList, date);
                purchases.add(purchase);
                System.out.printf("Sale created with id: %d, total price: %f date: %s",purchase.getId(),purchase.getTotalPrice(), date + "\n");
            }
            case 2 -> {
                //remove product from purchaseItem list (this returns product from purchaseList, does not delete purchase)
                System.out.println("Enter purchase id you want to return: ");
                long returnSaleId = sc.nextLong();

                if(purchaseIds.contains(returnSaleId)){
                    System.out.println("Enter product id: ");
                    long removeProductCode = sc.nextLong();
                    System.out.println("Enter count of products to return: ");
                    int removeProductCount = sc.nextInt();

                    if(productCodes.contains(removeProductCode)){
                        for(PurchaseItem pi:purchaseItemList){
                            if(pi.getProductCode()==removeProductCode && pi.getCount()==removeProductCount){
                                purchaseItemList.remove(pi);
//                                for(Purchase p:purchases){
//                                    if(p.getId()==returnSaleId)
//                                        purchases.remove(p);
//                                }
                            }
                            else if (pi.getCount()>removeProductCount)
                                System.out.printf("There were more products in this purchase than: %d. \n",removeProductCount);
                            else System.out.println("Something went wrong.");
                        }
                    }else{
                        System.out.printf("The product code: %d  for purchase %d is incorrect. \n",removeProductCode,returnSaleId);
                    }
                }else {
                    System.out.printf("There is no sale with id %d \n",returnSaleId);
                }
            }
            case 3 ->{
                System.out.println("Enter purchase id you want to delete: ");
                long removeSaleId = sc.nextLong();

                for(Purchase p:purchases){
                    if(p.getId()==removeSaleId)
                        purchases.remove(p);
                }
            }

            case 4 -> {
                System.out.println("All purchases: ");
                for (Purchase p:purchases) {
                    System.out.println("Purchase " + p.getId() + " totalPrice: " + p.getTotalPrice()
                            + " product count: " + p.getPurchaseItemsCount() + " date: " + p.getCreationDate());
                }
            }

            case 5->{
                System.out.print("Enter start date <31.12.2000>: ");
                String[] start =  sc.nextLine().split("\\.");
                LocalDate startDate = LocalDate.of(Integer.valueOf(start[2]),Integer.valueOf(start[1]),Integer.valueOf(start[0]));
                System.out.print("Enter end date <31.12.2000>: ");
                String[] end =  sc.nextLine().split("\\.");
                LocalDate endDate = LocalDate.of(Integer.valueOf(start[2]),Integer.valueOf(start[1]),Integer.valueOf(start[0]));
            }
        }
    }

    public static void main(String[] args) {
        //testing
        saleLogic(1);
        saleLogic(1);
        saleLogic(1);
        saleLogic(5);
    }
}

