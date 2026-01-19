import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService{
    Inventory inventory;
    int inventoryId;
    private final Map<Integer,Inventory> inventoryMap=new ConcurrentHashMap<>();
    List<Inventory> inventoryList = new ArrayList<>();
//    public InventoryService(Inventory inventory) {
//        this.inventory = inventory;
//    }
//
//    public InventoryService() {
//    }

    public void addItem(Inventory inventory){
         inventoryList.add(inventory);
        inventoryId=inventory.getInventoryId();
        inventoryMap.put(inventoryId,inventory);
        for (Inventory inventory1 : inventoryList){
            System.out.println("Item added Successfully" + inventory1.getInventoryId());
            System.out.println("Item added Successfully" + inventory1.getProductName());
            System.out.println("Item added Successfully" + inventory1.getQuantity());
        }
    }
    public void sellItem(int inventoryId,double quantity){

        Inventory inv=inventoryMap.get(inventoryId);
        if (inv == null) {              //added
            System.out.println("Inventory not found for ID: " + inventoryId);
            return;
        }
        synchronized (inv){

            double stockQuantity=inv.getQuantity();
            if(stockQuantity>=quantity){
                inv.setQuantity(stockQuantity-quantity);

                System.out.println(quantity+" "+inv.getProductName()+" are sold  "+Thread.currentThread().getName()+" "+inv.getQuantity()+" left");


            }
            else{
                System.out.println(inventory.getProductName()+" not available");
            }

        }
    }
    public void display(){
        for(Integer productId:inventoryMap.keySet()){
            System.out.println(productId+" :"+inventoryMap.get(productId).getProductName()+" "+inventoryMap.get(productId).getQuantity());
        }
    }
}