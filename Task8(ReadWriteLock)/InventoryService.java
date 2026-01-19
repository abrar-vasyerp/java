import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InventoryService{
    Inventory inventory;
    int inventoryId;
    private final Map<Integer,Inventory> inventoryMap=new ConcurrentHashMap<>();
    ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    Lock readLock=lock.readLock();
    Lock writeLock=lock.writeLock();


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


        writeLock.lock();
        try{
            Inventory inv=inventoryMap.get(inventoryId);
            if (inv == null) {              //added
                System.out.println("Inventory not found for ID: " + inventoryId);
                return;
            }
            double stockQuantity=inv.getQuantity();
            if(stockQuantity>=quantity){
                inv.setQuantity(stockQuantity-quantity);

                System.out.println(quantity+" "+inv.getProductName()+" are sold  "+Thread.currentThread().getName()+" "+inv.getQuantity()+" left");


            }
            else{
                System.out.println(inv.getProductName()+" not available");
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());;
        }
        finally {
            writeLock.unlock();
        }
    }
//    public void display(){
//        for(Integer productId:inventoryMap.keySet()){
//            System.out.println(productId+" :"+inventoryMap.get(productId).getProductName()+" "+inventoryMap.get(productId).getQuantity());
//        }
//    }
    public String getInvenetoryInfo(int inventoryId){
        readLock.lock();
        try{
            if(!inventoryMap.containsKey(inventoryId)){
                return "this id does not contains in database";
            }
            return "Id :"+inventoryId+" " +inventoryMap.get(inventoryId).getProductName()+" "+inventoryMap.get(inventoryId).getQuantity();
        }

        finally {
            readLock.unlock();
        }

    }
}