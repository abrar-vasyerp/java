import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
public class StoreInventory {

    Map<String,List<StockBatch>> inventory=new HashMap<>();
public void addProduct(String productName, double quantity,LocalDate expiryDate,Supplier supplier) {
        if(!inventory.containsKey(productName)){
            inventory.put(productName,new ArrayList<StockBatch>());
        }
        inventory.get(productName).add(new StockBatch(productName,quantity,expiryDate,supplier));

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
public void display(String productName){
    List<StockBatch> stockBatch=inventory.get(productName);
    
    for(StockBatch s:stockBatch){
        System.out.println("Quantity :"+s.getQuantity()+"Expiry Date:"+s.getExpiryDate());
    }
}
public Map<Supplier,List<StockBatch>> reportService(){
    LocalDate today=LocalDate.now();
    LocalDate in30Days=today.plusDays(30);
    Map<Supplier,List<StockBatch>> report=inventory.values()
                                                   .stream()
                                                   .flatMap(List::stream)
                                                   .filter(batch->batch.getExpiryDate().isAfter(today)&&batch.getExpiryDate().isBefore(in30Days)).collect(Collectors.groupingBy(StockBatch::getSupplier));
    return report;
}
}