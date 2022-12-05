public class Peripheral extends Item{

    private double discount = (double) 0.1; 

    Peripheral(String name, int year, String brand, double price){
        super(name, year, brand, price);
    }
    
    double apply_discount(){
        return super.price - super.price*discount;
    }

    public String toString(){
       return super.toString();
    }
}