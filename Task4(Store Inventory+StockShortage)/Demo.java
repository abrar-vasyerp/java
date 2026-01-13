import java.time.*;
import java.util.*;
public class Demo {
    public static void main(String[] args) {
        StoreInventoryService item=new StoreInventoryService();
        // item.addProduct("Oranges",5,LocalDate.of(2026, 7, 01));
        // item.addProduct("Oranges",5,LocalDate.of(2026, 5, 01));
        // item.addProduct("Oranges",5,LocalDate.of(2026, 2, 01));
        
        // item.sellProduct("Oranges", 11);
        // item.display("Oranges");
        int choice;
        String productName;
        double quantity;
        String date;
        int index;
        List<String> productsList;
        Scanner sc=new Scanner(System.in);
        
        do {
            System.out.println("Choose operation what to do:");
            System.out.println("1.Add Product");
            System.out.println("2.Sell Product");
            System.out.println("3.Display Stock");
            System.out.println("-1 for Exit");
            System.out.print("select :");
        choice=sc.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Add Product Name:");
                        productName=sc.next();
                        productName=productName.toUpperCase();
                        System.out.println();
                        System.out.print("Add Quantity:");
                        quantity=sc.nextDouble();
                        System.out.println();
                        System.out.print("Add Date in this format yyyy-MM-dd :");
                        date=sc.next();
                        LocalDate expiryDate=DateValidator.validateExpiry(date);
                        item.addProduct(productName,quantity,expiryDate);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    
                break;

                case 2:
                try {
                    productsList=item.getProducts();
                    for(int i=0;i<productsList.size();i++){
                        System.out.println((i+1)+" :"+productsList.get(i));
                    }
                    System.out.print("Choose Product Number from above List:");
                    index=sc.nextInt();
                    if(index<1 || index>productsList.size()){
                        System.out.println("invalid input...");
                    }
                    System.out.print("Quantity:");
                    quantity=sc.nextDouble();
                    item.sellProduct(productsList.get(index-1), quantity);
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
                    break;
                
                case 3:
                    
                try {
                    productsList=item.getProducts();
                    for(int i=0;i<productsList.size();i++){
                        System.out.println((i+1)+" :"+productsList.get(i));
                    }
                    System.out.print("Choose Product Number from above List:");
                    index=sc.nextInt();
                    if(index<1 || index>productsList.size()){
                        System.out.println("invalid input...");
                    }
                    item.display(productsList.get(index-1));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
                System.out.println();

                break;
                case 4:
                System.out.println("exit");
                default:
                    break;
            }
        } while (choice!=-1);
    }
}
