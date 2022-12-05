public class Motherboard extends Component{

    public String type;
    public int memory;
    public int sata;

    Motherboard(String name, int year, String brand, float price, String type, int memory, int sata){
        super(name, year, brand, price);
        
        this.type = type;
        this.memory = memory;
        this.sata = sata;
    }

    String get_type(){
        return type;
    }

    int het_memory(){
        return memory;
    }

    int get_sata(){
        return sata;
    }

    public String toString(){
        return super.toString()
            + "\nType: " + type
            + "\nMemory: " + memory
            + "\nSata ports: " + sata;
    }
}
