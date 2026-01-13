import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        StoreInventory item=new StoreInventory();
        // item.addProduct("Oranges",5,LocalDate.of(2026, 7, 01));
        // item.addProduct("Oranges",5,LocalDate.of(2026, 5, 01));
        // item.addProduct("Oranges",5,LocalDate.of(2026, 2, 01));
        
        // item.sellProduct("Oranges", 11);
        // item.display("Oranges");
        int choice;
        String productName;
        double quantity;
        int year;
        int day;
        int month;
        int supplierId;
        String supplierName;
        String supplierContact;
        List<Supplier> supplierList=new ArrayList<>();
        Map<Integer,Supplier> supplierMap=new HashMap<>();
        
        Scanner sc=new Scanner(System.in);
        Supplier supplier;
        // supplier.setContact("1234567890");
        // supplier.setSupplierId(1);
        // supplier.setSupplierName("Dhruv");
        
        do {
            System.out.println("Choose operation what to do:");
            System.out.println("1.Add Product");
            System.out.println("2.Sell Product");
            System.out.println("3.Display Stock");
            System.out.println("4.Add Supplier");
            
            System.out.println("5.display Supplier");
            
            System.out.println("6.Last 30 days Supplierwise ProductStock");
            
        choice=sc.nextInt();
            switch (choice) {
                case 1:
                System.out.print("Add Product Name:");
                productName=sc.next();
                
                System.out.print("Add Quantity:");
                quantity=sc.nextDouble();
                
                System.out.print("Add Expiry Year:");
                year=sc.nextInt();
                
                System.out.print("Add Expiry Month:");
                month=sc.nextInt();
                
                System.out.print("Add Expiry DayOfMonth:");
                day=sc.nextInt();
                System.out.println("Supplier Id:");
                supplierId=sc.nextInt();
                supplier=supplierMap.get(supplierId);
                    item.addProduct(productName,quantity,LocalDate.of(year, month, day),supplier);
                break;

                case 2:
                 System.out.print("Product Name:");
                productName=sc.next();
                System.out.println();
                System.out.print("Quantity:");
                quantity=sc.nextDouble();
                System.out.println();
                item.sellProduct(productName, quantity);
                    break;
                
                case 3:
                 System.out.print("Product Name:");
                productName=sc.next();
                item.display(productName);
                System.out.println();

                break;
                case 4:
                System.out.print("Supplier Id:");
                supplierId=sc.nextInt();
                System.out.print("Supplier Name:");
                supplierName=sc.next();
                System.out.print("Supplier Contact:");
                supplierContact=sc.next();
                supplier=new Supplier();
                supplier.setContact(supplierContact);
                supplier.setSupplierId(supplierId);
                supplier.setSupplierName(supplierName);
                supplierMap.put(supplierId,supplier);
                
                case 5:
                for(Integer key:supplierMap.keySet()){
                    supplierMap.get(key).display();
                }
                break;
                case 6:
                Map<Supplier,List<StockBatch>> expiryIn30Days=item.reportService();
                for(Supplier sup:expiryIn30Days.keySet()){
                    System.out.println(sup.getSupplierName()+": ");
                    for(StockBatch batch:expiryIn30Days.get(sup)){
                        batch.display();
                    }
                }

                break;
                case -1:
                    System.out.println("Exit successfully...");
                default:
                    break;
            }
        } while (choice!=-1);
    }
}
