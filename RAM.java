public class RAM extends Component{

    public String type;
    public int size;
    public int frequency;

    RAM(String name, int year, String brand, float price, String type, int size, int frequency) {
        super(name, year, brand, price);

        this.type = type;
        this.size  = size;
        this.frequency = frequency;
    }

    String get_type(){
        return type;
    }

    int get_size(){
        return size;
    }

    int get_frequency(){
        return frequency;
    }
    public String toString(){
        return super.toString()
            + "\nType: " + type
            + "\nSize: " + size
            + "\nFrequency: " + frequency;
    }
}
