public class Display extends Peripheral{

    private String type;
    private float size;
    private String resolution;
    private String ports;

    Display(String name, int year, String brand, float price, String type, float size, String resolution, String ports) {
        super(name, year, brand, price);

        this.type  = type;
        this.size  = size;
        this.resolution = resolution;
        this.ports  = ports;
    }

    String get_type(){
        return type;
    }

    float get_size(){
        return size;
    }

    String get_resolution(){
        return resolution;
    }

    String get_ports(){
        return ports;
    }

    public String toString(){
        return super.toString()
            + "\nType: " + type
            + "\nSize: " + size
            + "\nResolution: " + resolution
            + "\nPorts: " + ports;
    }
    
}
