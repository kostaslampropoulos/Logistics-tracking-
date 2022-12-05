public class GPU extends Component{

    public String chipset;
    public int memory;

    public GPU(String name, int year, String brand, float price, String chipset, int memory) {
        super(name, year, brand, price);

        this.chipset = chipset;
        this.memory =  memory;
    }

    String get_chipset(){
        return chipset;
    }

    int get_memory(){
        return memory;
    }

    public String toString(){
        return super.toString()
            + "\nChipset: " + chipset
            + "\nMemory: " + memory;
    }
}
