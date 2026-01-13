
public class Product{
    private int productId;
    private String name;
    
    
    public Product(int productId,String name){
        this.productId=productId;
        this.name=name;  
    }
    public Product(){}

    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setId(int productId){
        this.productId=productId;
    }
    

    public void display(){
        System.out.println("Name :"+name);
    }

}