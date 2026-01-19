import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Inventory inventory;
        InventoryService inventoryService=new InventoryService();;

        inventory=new Inventory();
        inventory.setInventoryId(10);
        inventory.setQuantity(10);
        inventory.setProductName("Oranges");
//
//        inventoryService.addItem(inventory);

        Inventory inventory2=new Inventory();
        inventory2.setInventoryId(20);
        inventory2.setQuantity(5);
        inventory2.setProductName("Apple");
//
//        inventoryService.addItem(inventory2);
        Inventory inventory3=new Inventory();
        inventory3.setInventoryId(30);
        inventory3.setQuantity(5);
        inventory3.setProductName("Watermelon");

        Inventory inventory4=new Inventory();
        inventory4.setInventoryId(40);
        inventory4.setQuantity(5);
        inventory4.setProductName("Pineapple");

        Inventory inventory5=new Inventory();
        inventory5.setInventoryId(50);
        inventory5.setQuantity(10);
        inventory5.setProductName("Blueberry");


//
//        Runnable task1=new Runnable() {
//            @Override
//            public void run() {
//                inventoryService.sellItem(1,5);
//            }
//        };
//        Runnable task2=new Runnable() {
//            @Override
//            public void run() {
//                inventoryService.sellItem(2,3);
//            }
//        };
//        Runnable task3=new Runnable() {
//            @Override
//            public void run() {
//                inventoryService.sellItem(1,2);
//            }
//        };
//        Thread thread1=new Thread(task1,"Thread1");
//        Thread thread2=new Thread(task2,"Thread2");
//        Thread thread3=new Thread(task3,"Thread3");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
////        inventoryService.display();
        List<Inventory> inventoryList=new ArrayList<>();
        inventoryList.add(inventory);
        inventoryList.add(inventory2);
        inventoryList.add(inventory3);
        inventoryList.add(inventory4);
        inventoryList.add(inventory5);
        Scanner sc=new Scanner(System.in);
        System.out.println("Give id");
        int input=sc.nextInt();
        for(Inventory inv:inventoryList){
//            if(input==inv.getInventoryId()){
                System.out.println(inv.getInventoryId()+":"+inv.getProductName()+" "+inv.getQuantity()+" ");
//                break;
            //}

        }

    }
}