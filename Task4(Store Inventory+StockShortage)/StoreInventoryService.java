import java.time.LocalDate;
import java.util.*;

import MyException.CustomException;
import MyException.StockShortageException;
public class StoreInventoryService {
    StoreInventory storeInventory;
    Map<String,List<StockBatch>> inventory=new HashMap<>();
public void addProduct(String productName, double quantity,LocalDate expiryDate) {

        if(quantity<=0){
            throw new CustomException("Quantity must be graterthan Zero");
        }
        
        if(!inventory.containsKey(productName)){
            inventory.put(productName,new ArrayList<StockBatch>());
        }
        inventory.get(productName).add(new StockBatch(quantity,expiryDate));

        Collections.sort(inventory.get(productName), (a, b) ->
        a.getExpiryDate().compareTo(b.getExpiryDate())
        );

    }
public void sellProduct(String productName,double quantity){
    if(!inventory.containsKey(productName)){
        throw new CustomException("Product not Found...");
    }
    if(!checkStock(productName, quantity)){
        throw new StockShortageException("This much Quantity not available...");
    }
    List<StockBatch> stockBatch=inventory.get(productName);
    double temp=quantity;

    // for(StockBatch s:stockBatch){
    //     if(s.getQuantity()<=temp){
    //         temp-=s.getQuantity();
    //         stockBatch.remove(s);
            
    //     }
    //     else{
    //         s.setQuantity(s.getQuantity()-temp);
    //         temp=0;
    //     }
    // }

    Iterator<StockBatch> it = stockBatch.iterator();

while (it.hasNext() && temp > 0) {
    StockBatch s = it.next();

    if (s.getQuantity() <= temp) {
        temp -= s.getQuantity();
        it.remove();   
    } else {
        s.setQuantity(s.getQuantity() - temp);
        temp = 0;
        System.out.println(productName+" :"+quantity+" Quantities sold");
    }
}

    
}
public boolean checkStock(String productName,double quantity){
    List<StockBatch> stockBatch=inventory.get(productName);
    double temp=quantity;
    Iterator<StockBatch> it = stockBatch.iterator();

    while (it.hasNext() && temp > 0) {
        StockBatch s = it.next();

        if (s.getQuantity() <= temp) {
            temp -= s.getQuantity();
            
        } else {
            
            temp = 0;
        }
    }
    if(temp!=0){
        return false;
    }
    return true;
        
}
public List<String> getProducts(){
    Set<String> products=inventory.keySet();
    List<String> productsList=new ArrayList<>();
    for(String p:products){
        productsList.add(p);
    }
    return productsList;
}
public void display(String productName){
    if(!inventory.containsKey(productName)){
        throw new CustomException("This Name Product does not exists...");
    }
    List<StockBatch> stockBatch=inventory.get(productName);
    System.out.println(productName);
    for(StockBatch s:stockBatch){
        System.out.println("Quantity :"+s.getQuantity()+"Expiry Date:"+s.getExpiryDate());
    }
}

}