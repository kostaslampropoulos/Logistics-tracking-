public class Item {
    protected String name;
    protected int year; 
    protected String brand;
    protected double price;

    Item(String name, int year, String brand, double price){
        this.name = name;
        this.year = year;
        this.brand = brand;
        this.price = price;
    }

    String get_name(){
        return name;
    }

    int get_year(){
        return year;
    }
    
    String get_brand(){
        return brand;
    }

    double get_price(){
        return price;
    }

    public String toString(){
        return "\nName: " + name 
             + "\nYear: " + year
             + "\nBrand: " + brand
             + "\nPrice: " + price;
    }
}
