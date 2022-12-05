import java.util.*;
import java.time.LocalDate;

public class MainApp2 {
    public static void main(String[] args) {
        
        final String TEXT_RESET = "\u001B[0m";
        final String TEXT_RED = "\u001B[31m";
        final String TEXT_GREEN = "\u001B[32m";
        final String TEXT_BLUE = "\u001B[34m";
        final String TEXT_YELLOW = "\u001B[33m";
        
        int i = 1;
        int j =1;
        boolean done = false;
        //Date constuction for arrival and order dates
        LocalDate currentdDate1 =  LocalDate.now();
        String date = currentdDate1.toString();

        Scanner in = new Scanner(System.in);

        //Ctalog initializations
        HashMap<Item, Integer> stock = new HashMap<Item, Integer>();
        HashMap<Integer,Order> orders= new HashMap<Integer, Order>();
        HashMap<Integer,Sale> sales= new HashMap<Integer, Sale>();

        //Component initializations
        CPU cpu1 = new CPU("i5", 2022, "Intel", 159, 3, 8, "Yes"); 
        CPU cpu2 = new CPU("Ryzen 7", 2022, "AMD", 230, 4.4, 12, "Yes");
        
        GPU gpu1 = new GPU("VJ-234", 2015, "Patriot", 69, "nVidia", 12);
        GPU gpu2 = new GPU("CL-789", 2019, "Corsair", 112, "AMD", 16);
        
        Hard_drive hd1 = new Hard_drive("ST4000", 2021, "Western Digital", 399, "HDD", 2.5, 3000);
        Hard_drive hd2 = new Hard_drive("EVO 870", 2022, "Samsung", 89, "SSD", 2.5, 500);
        
        Motherboard mb1 = new Motherboard("Pro Z690", 2022, "MSI", 188, "Intel", 32, 8);
        Motherboard mb2 = new Motherboard("B550", 2021, "Gigabyte", 169, "AMD", 64, 6);
        
        RAM ram1 = new RAM("Ripjaws V", 2020, "G.Skill", 62, "DDR4", 16, 3200);
        RAM ram2 = new RAM("Trident Z Neo", 2021, "G.Skil", 145, "DDR4", 32, 3600);
        
        //Peripheral initializations
        Mouse mouse1 = new Mouse("MX Master 3", 2022, "Logitech", 70, "Laser", "Wireless");
        Mouse mouse2 = new Mouse("Magic mouse 2", 2021, "Apple", 75, "Laser", "Wireless");
        
        Keyboard key1 = new Keyboard("MX Keys", 2021, "Logitech", 105, "Wireless");
        Keyboard key2 = new Keyboard("Ornata V2", 2020, "Rayzer", 90, "Wired");
        
        Display dis1 = new Display("Pro Display XDR", 2020, "Apple", 7299, "Monitor", 32, "6016 x 3384", "Type-C");
        Display dis2 = new Display("LS24A400VEUXEN", 2019, "Samsung", 198, "Monitor", 24, "1920 x 1080", "HDMI, Display Port, VGA");
        
        Printer printer1 = new Printer("HP 107a", 2020, "HP", 90, "Laser", "Black/White");
        Printer printer2 = new Printer("Mi Pocket Photo Printer Zink", 2022, "Xiaomi", 45, "inkjet", "color");
        
        //Stock HashMap iinitialization
        stock.put(cpu1, 5); stock.put(cpu2, 1);
        stock.put(gpu1, 1); stock.put(gpu2, 1);
        stock.put(hd1, 0); stock.put(hd2, 1);
        stock.put(mb1, 1); stock.put(mb2, 1);
        stock.put(ram1, 0); stock.put(ram2, 1);
        
        stock.put(dis1,0); stock.put(dis2,1);
        stock.put(printer1,1); stock.put(printer2,1);
        stock.put(mouse1,0); stock.put(mouse2,1);
        stock.put(key1,0); stock.put(key2,1);

        while ( ! done)	{
                
            System.out.println(TEXT_RED + "\n1. View products" + TEXT_RESET);
            System.out.println(TEXT_GREEN + "2. View orders" + TEXT_RESET);
            System.out.println(TEXT_BLUE + "3. View sales" + TEXT_RESET);
            System.out.println(TEXT_YELLOW + "0. exit" + TEXT_RESET);
            
            System.out.print("> ");
            int answer = in.nextInt();

            if(answer == 1){
                System.out.print("Specify the category(1.component of 2.peripheral): ");
            	int category = in.nextInt();
                if (category == 1){
                    System.out.print("\nSpecify the type(1.CPU, 2.GPU, 3.Hard drive, 4.Motheboard, 5.RAM): ");
                    int type = in.nextInt();
                }
            }
        }
    }
}
