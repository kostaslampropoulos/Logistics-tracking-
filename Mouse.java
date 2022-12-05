public class Mouse extends Peripheral{

    private String technology;
    private String connection;

    Mouse(String name, int year, String brand, float price,String technology, String connection) {
        super(name, year, brand, price);

        this.connection = connection;
        this.technology = technology;
    }

    String get_connection(){
        return connection;
    }

    String get_technology(){
        return technology;
    }

    public String toString(){
        return super.toString()
            + "\nTechnology: " + technology
            + "\nConection type: " + connection;
    }
}

