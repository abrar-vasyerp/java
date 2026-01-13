public class Supplier {
    private int supplierId;
    private String supplierName;
    private String supplierContact;

    public Supplier() {
    }

    public Supplier(int supplierId, String supplierName, String supplierContact) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierContact = supplierContact;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContact() {
        return supplierContact;
    }

    public void setContact(String contact) {
        this.supplierContact = contact;
    }
    public void display(){
        System.out.println(supplierId+" :"+supplierName+" "+supplierContact);
    }
}
