
public class Varient {
    private int varientId;
    private String colour;
    private String size;
    private Product product;

    public Varient(int varientId,String colour,String size,Product product){
        this.varientId=varientId;
        this.colour=colour;
        this.size=size;
        this.product=product;
    }
    public Varient(){}
    
    public String getColour(){
        return colour;
    }
    public String getSize(){
        return size;
    }
    public Product getProduct(){
        return product;
    }

    public void setColour(String colour){
        this.colour=colour;
    }
    public void setSize(String size){
        this.size=size;
    }
    public void setProduct(Product product){
        this.product=product;
    }
    public void setId(int varientId){
        this.varientId=varientId;
    }

    public void display(){
        System.out.println("Colour :"+colour+" Size: "+size);
    }
    

}
