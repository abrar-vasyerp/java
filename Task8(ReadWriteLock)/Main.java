public class Main{
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Inventory inventory;
        InventoryService inventoryService=new InventoryService();;

        inventory=new Inventory();
        inventory.setInventoryId(1);
        inventory.setQuantity(10);
        inventory.setProductName("Oranges");

        inventoryService.addItem(inventory);

        Inventory inventory2=new Inventory();
        inventory2.setInventoryId(2);
        inventory2.setQuantity(5);
        inventory2.setProductName("Apple");

        inventoryService.addItem(inventory2);

        Runnable task1=new Runnable() {
            @Override
            public void run() {
                inventoryService.sellItem(1,5);
            }
        };
        Runnable task2=new Runnable() {
            @Override
            public void run() {
                inventoryService.sellItem(2,3);
            }
        };
        Runnable task3=new Runnable() {
            @Override
            public void run() {
                inventoryService.sellItem(1,2);
            }
        };
        Runnable task4=new Runnable() {
            @Override
            public void run() {
                System.out.println(inventoryService.getInvenetoryInfo(1));
            }
        };
        Runnable task5=new Runnable() {
            @Override
            public void run() {
                System.out.println(inventoryService.getInvenetoryInfo(2));

            }
        };
        Thread thread1=new Thread(task1,"Thread1write");
        Thread thread2=new Thread(task2,"Thread2write");
        Thread thread3=new Thread(task3,"Thread3write");
        Thread thread4=new Thread(task4,"Thread4Read");
        Thread thread5=new Thread(task5,"Thread5read");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
//        inventoryService.display();
    }
}