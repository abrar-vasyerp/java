public class Supplier {

    private int suppllierId;
    private String name;
    private String contact;

    public Supplier(int suppllierId,String name,String contact) {
        this.suppllierId=suppllierId;
        this.name=name;
        this.contact=contact;
    }
    public Supplier(){}

    public String getName(){ 
        return name;
    }
    public String getContact(){
        return contact;
    }

    public void setId(int suppllierId){
        this.suppllierId=suppllierId;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setContact(String contact){
        this.contact=contact;
    }


    public void display(){
        System.out.println("Supplier name:"+name+" contact:"+contact);
        
    }

    
}
