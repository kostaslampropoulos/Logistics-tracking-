public class Sale {
    public int code;
    public Item item;
    public String phone;
    public String dateOfSale;

    Sale(int code,Item item,String phone,String dateOfSale){
        this.code=code;
        this.item=item;
        this.phone=phone;
        this.dateOfSale=dateOfSale;
    }
    
    int get_code(){
        return code;
    }
    
    public String toString() {
        return "\nCode: " + code
            + "\nItem: " + item.get_brand()+ " " +item.get_name()
            + "\nPhone: " + phone
            + "\nDate of Sale: " + dateOfSale; 
    }  
        
}