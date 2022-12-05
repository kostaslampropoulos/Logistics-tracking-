public class CPU extends Component{

    public double speed;
    public int cores;
    public String integrated_gpu;

    protected CPU(String name, int year, String brand, float price, double speed, int cores, String integrated_gpu) {
        super(name, year, brand, price);
        
        this.speed = speed;
        this.cores = cores;
        this.integrated_gpu = integrated_gpu;
    }
    

    double get_speed(){
        return speed;
    }

    int get_cores(){
        return cores;
    }

    String get_integrated_gpu(){
        return integrated_gpu;
    }

    public String toString(){
        return super.toString()
            + "\nSpeed: " + speed
            + "\nCores: " + cores
            + "\nIntegrated graphics: " + integrated_gpu;
    }
}
