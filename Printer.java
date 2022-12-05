public class Printer extends Peripheral{

    private String technology;
    private String type;

    Printer(String name, int year, String brand, float price, String technology, String type) {
        super(name, year, brand, price);

        this.technology = technology;
        this.type = type;
    }

    String get_technology(){
        return technology;
    }

    String get_type(){
        return type;
    }

     public String toString(){
        return super.toString()
            + "\nTechnology: " + technology
            + "\nType: " + type;
    }
}