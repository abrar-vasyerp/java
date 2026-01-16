import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService{
    Inventory inventory;
    int inventoryId;
    private final Map<Integer,Inventory> inventoryMap=new ConcurrentHashMap<>();

//    public InventoryService(Inventory inventory) {
//        this.inventory = inventory;
//    }
//
//    public InventoryService() {
//    }

    public void addItem(Inventory inventory){
        inventoryId=inventory.getInventoryId();
        inventoryMap.put(inventoryId,inventory);
        System.out.println("Item added Successfully");
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