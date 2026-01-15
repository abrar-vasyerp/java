public class Main{
    public static void main(String[] args) {
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
        Thread thread1=new Thread(task1,"Thread1");
        Thread thread2=new Thread(task2,"Thread2");
        Thread thread3=new Thread(task3,"Thread3");

        thread1.start();
        thread2.start();
        thread3.start();
//        inventoryService.display();
    }
}