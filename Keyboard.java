public class Keyboard extends Peripheral{

    private String connection;

    Keyboard(String name, int year, String brand, float price, String connection) {
        super(name, year, brand, price);

        this.connection = connection;
    }

    String get_connection(){
        return connection;
    }

    public String toString(){
        return super.toString()
            + "\nConnection type: " + connection;
    }
}
