public class Hard_drive extends Component{

    public String type;
    public double size;
    public int capacity;

    Hard_drive(String name, int year, String brand, float price, String type, double size, int capacity) {
        super(name, year, brand, price);

        this.type  = type;
        this.size  = size;
        this.capacity = capacity;
    }

    String get_type(){
        return type;
    }

    double get_size(){
        return size;
    }

    int get_capacity(){
        return capacity;
    }

    public String toString(){
        return super.toString()
            + "\nType: " + type
            + "\nSize: " + size
            + "\nCapacity: " + capacity;
    }
}
