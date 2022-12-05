import java.util.*;
import java.time.LocalDate;

public class MainApp {
    
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
        
        //initializations inside an exception
        try (Scanner in = new Scanner(System.in)){
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
            
            
            //Main app
            while ( ! done)	{
                
                System.out.println(TEXT_RED + "\n1. View products" + TEXT_RESET);
                System.out.println(TEXT_GREEN + "2. View orders" + TEXT_RESET);
                System.out.println(TEXT_BLUE + "3. View sales" + TEXT_RESET);
                System.out.println(TEXT_YELLOW + "0. exit" + TEXT_RESET);
                
                System.out.print("> ");
                String answer = in.nextLine();
                
                if(answer.equals("1")){
                    System.out.print("Specify the category(1.component of 2.peripheral): ");
            		String category = in.nextLine();
                    if (category.equals("1")){
                        System.out.print("\nSpecify the type(1.CPU, 2.GPU, 3.Hard drive, 4.Motheboard, 5.RAM): ");
            			String type = in.nextLine();
                        //CPU
                        if (type.equals("1")){
                            
                            System.out.print("Choose a specific CPU(1. " + cpu1.get_name()+ " " + "or" + " 2. " + cpu2.get_name() + "): ");
                            String spes = in.nextLine();
                            //CPU1
                            if (spes.equals("1")){
                                
                                System.out.println(cpu1.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){
                                    
                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();
                                    
                                    if (stock.get(cpu1) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");
                                        
                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();
                                        
                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();
                                        
                                        orders.put(i, new Order(i, cpu1, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(cpu1, stock.get(cpu1) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(cpu1) + " items left.");
                                        sales.put(j, new Sale(j, cpu1, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + cpu1.get_price() + "$");
                                    double price = cpu1.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                                //CPU2
                            }else if (spes.equals("2")){
                                
                                System.out.println(cpu2.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();
                                    
                                    if (stock.get(cpu2) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");
                                        
                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();
                                        
                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();
                                        
                                        orders.put(i, new Order(i, cpu2, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(cpu2, stock.get(cpu2) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(cpu2) + " items left.");
                                        sales.put(j, new Sale(j, cpu2, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + cpu2.get_price() + "$");
                                    double price = cpu2.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            }else {
                                System.out.println("\nNo such CPU!");
                            }
                            //GPU
                        } else if (type.equals("2")){
                            
                            System.out.print("Choose a specific GPU(1. " + gpu1.get_name()+ " " + "or" + " 2. " + gpu2.get_name() + "): ");
                            String spes=in.nextLine();
                            //GPU1
                            if (spes.equals("1")){
                                
                                System.out.println(gpu1.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){
                                    
                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();
                                    
                                    if (stock.get(gpu1) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");
                                        
                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();
                                        
                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();
                                        
                                        orders.put(i, new Order(i, gpu1, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(gpu1, stock.get(gpu1) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(gpu1) + " items left.");
                                        sales.put(j, new Sale(j, gpu1, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + gpu1.get_price() + "$");
                                    double price = gpu1.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                                //GPU2
                            }else if (spes.equals("2")){
                                
                                System.out.println(gpu2.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("Yes")){
                                    
                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();
                                    
                                    if (stock.get(gpu2) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");
                                        
                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();
                                        
                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();
                                        
                                        orders.put(i, new Order(i, gpu2, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(gpu2, stock.get(gpu2) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(gpu2) + " items left.");
                                        sales.put(j, new Sale(j, gpu2, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + gpu2.get_price() + "$");
                                    double price = gpu2.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            }else {
                                System.out.println("\nNo such GPU!");
                            }
                            //Hard drive
                        }else if (type.equals("3")){
                            
                            System.out.print("Choose a specific Hard Drive(1. " + hd1.get_name()+ " " + "or" + " 2. " + hd2.get_name() + "): ");
                            String spes=in.nextLine();
                            //Hard drive 1
                            if (spes.equals("1")){
                                
                                System.out.println(hd1.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();
                                    
                                    if (stock.get(hd1) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");
                                        
                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();
                                        
                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();
                                        
                                        orders.put(i, new Order(i, hd1, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(hd1, stock.get(hd1) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(hd1) + " items left.");
                                        sales.put(j, new Sale(j, hd1, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + hd1.get_price() + "$");
                                    double price = hd1.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                                //Hard drive 2
                            }else if (spes.equals("2")){
                                
                                System.out.println(hd2.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){
                                    
                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();
                                    
                                    if (stock.get(hd2) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, hd2, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(hd2, stock.get(hd2) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(hd2) + " items left.");
                                        sales.put(j, new Sale(j, hd2, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + hd2.get_price() + "$");
                                    double price = hd2.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            }else {
                                System.out.println("\nNo such Hard Drive!");
                            }
                        //Motherboard
                        }else if (type.equals("4")){

                            System.out.print("Choose a specific Motherboard(1. " + mb1.get_name()+ " " + "or" + " 2. " + mb2.get_name() + "): ");
                            String spes=in.nextLine();
                            //Motherboard 1
                            if (spes.equals("1")){

                                System.out.println(mb1.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();

                                    if (stock.get(mb1) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, mb1, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(mb1, stock.get(mb1) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(mb1) + " items left.");
                                        sales.put(j, new Sale(j, mb1, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + mb1.get_price() + "$");
                                    double price = mb1.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            //Motherboard 2
                            }else if (spes.equals("2")){

                                System.out.println(mb2.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();

                                    if (stock.get(mb2) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, mb2, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(mb2, stock.get(mb2) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(mb2) + " items left.");
                                        sales.put(j, new Sale(j, mb2, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + mb2.get_price() + "$");
                                    double price = mb2.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }

                            }else {
                                System.out.println("\nNo such Motherboard!");
                            }
                        //RAM
                        }else if (type.equals("5")){

                            System.out.print("Choose a specific RAM(1. " + ram1.get_name()+ " " + "or" + " 2. " + ram2.get_name() + "): ");
                            String spes=in.nextLine();
                            //RAM 1
                            if (spes.equals("1")){

                                System.out.println(ram1.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();

                                    if (stock.get(ram1) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, ram1, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(ram1, stock.get(ram1) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(ram1) + " items left.");
                                        sales.put(j, new Sale(j, ram1, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + ram1.get_price() + "$");
                                    double price = ram1.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            //RAM 2
                            }else if (spes.equals("2")){

                                System.out.println(ram2.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();

                                    if (stock.get(ram2) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, ram2, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(ram2, stock.get(ram2) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(ram2) + " items left.");
                                        sales.put(j, new Sale(j, ram2, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + ram2.get_price() + "$");
                                    double price = ram2.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            }else {
                                System.out.println("\nNo such RAM!");}
                        }

                    } else if (category.equals("2")){
                        System.out.print("\nSpecify the type(1.Mouse, 2.Keyboard, 3.Display, 4.Printer): ");
            			String type = in.nextLine();
                        //Mouse
                        if (type.equals("1")){
                                
                            System.out.print("Choose a specific Mouse(1. " + mouse1.get_name()+ " " + "or" + " 2. " + mouse2.get_name() + "): ");
                            String spes=in.nextLine();
                            //Mouse1
                            if (spes.equals("1")){

                                System.out.println(mouse1.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();

                                    if (stock.get(mouse1) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, mouse1, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(mouse1, stock.get(mouse1) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(mouse1) + " items left.");
                                        sales.put(j, new Sale(j, mouse1, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + mouse1.get_price() + "$");
                                    double price = mouse1.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            //Mouse2
                            }else if (spes.equals("2")){

                                System.out.println(mouse2.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();

                                    if (stock.get(mouse2) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, mouse2, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(mouse2, stock.get(mouse2) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(mouse2) + " items left.");
                                        sales.put(j, new Sale(j, mouse2, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + mouse2.get_price() + "$");
                                    double price = mouse2.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            }else {
                                System.out.println("\nNo such Mouse!");}
                        //Keyboard
                        }else if (type.equals("2")){

                            System.out.print("Choose a specific Keyboard(1. " + key1.get_name()+ " " + "or" + " 2. " + key2.get_name() + "): ");
                            String spes=in.nextLine();
                            //Keyboard 1
                            if (spes.equals("1")){

                                System.out.println(key1.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();

                                    if (stock.get(key1) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, key1, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(key1, stock.get(key1) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(key1) + " items left.");
                                        sales.put(j, new Sale(j, key1, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + key1.get_price() + "$");
                                    double price = key1.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            //Keyboard 2
                            }else if (spes.equals("2")){

                                System.out.println(key2.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();

                                    if (stock.get(key2) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, key2, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(key2, stock.get(key2) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(key2) + " items left.");
                                        sales.put(j, new Sale(j, key2, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + key2.get_price() + "$");
                                    double price = key2.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            }else {
                                System.out.println("\nNo such Keyboard!");}
                           //Display
                        }else if (type.equals("3")){
                               
                            System.out.print("Choose a specific Display(1. " + dis1.get_name()+ " " + "or" + " 2. " + dis2.get_name() + "): ");
                            String spes=in.nextLine();
                            //Display 1
                            if (spes.equals("1")){
                                
                                System.out.println(dis1.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();

                                    if (stock.get(dis1) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name:  ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, dis1, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(dis1, stock.get(dis1) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(dis1) + " items left.");
                                        sales.put(j, new Sale(j, dis1, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + dis1.get_price() + "$");
                                    double price = dis1.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            //Display 2
                            }else if (spes.equals("2")){
                                
                                System.out.println(dis2.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();

                                    if (stock.get(dis2) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, dis2, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(dis2, stock.get(dis2) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(dis2) + " items left.");
                                        sales.put(j, new Sale(j, dis2, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + dis2.get_price() + "$");
                                    double price = dis2.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            }else {
                                System.out.println("\nNo such Display!");}
                        //Printer
                        }else if(type.equals("4")){
                                
                            System.out.print("Choose a specific Printer(1. " + printer1.get_name()+ " " + "or" + " 2. " + printer2.get_name() + "): ");
                            String spes=in.nextLine();
                            //Printer 1
                            if (spes.equals("1")){

                                System.out.println(printer1.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();

                                    if (stock.get(printer1) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, printer1, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(printer1, stock.get(printer1) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(printer1) + " items left.");
                                        sales.put(j, new Sale(j, printer1, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + printer1.get_price() + "$");
                                    double price = printer1.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            //Printer 2
                            }else if (spes.equals("2")){

                                System.out.println(printer2.toString());
                                System.out.print("\nWould you like to purchase the item(1.Yes or 2.No)? ");
                                String res = in.nextLine();
                                if (res.equals("1")){

                                    System.out.print("Please enter your phone number: ");
                                    String phone = in.nextLine();

                                    if (stock.get(printer2) == 0){
                                        System.out.println("\nWe do not have the item in stock so we would have to place an order.");

                                        System.out.print("Please enter your full name: ");
                                        String name = in.nextLine();

                                        System.out.print("In how many days would you like the item to arrive: ");
                                        int days = in.nextInt();
                                        LocalDate currentDatePlus1 = currentdDate1.plusDays(days);
                                        String arr_date = currentDatePlus1.toString();

                                        orders.put(i, new Order(i, printer2, name, phone, date, arr_date));
                                        System.out.println("The delivery code for your order is: "+ i + "\n");
                                        i++;
                                    }else{
                                        stock.put(printer2, stock.get(printer2) - 1);
                                        System.out.println("\nWe have that in stock. " + stock.get(printer2) + " items left.");
                                        sales.put(j, new Sale(j, printer2, phone, date));
                                        j++;
                                    }
                                    System.out.println("\nStarting price: " + printer2.get_price() + "$");
                                    double price = printer2.apply_discount();
                                    System.out.println("Your final cost with the 25% discount is: " + price + "$");
                                }
                            }else {
                                System.out.println("\nNo such Printer!");}
                        }
                    }else{
                        System.out.println("No such category found!");
                    }
                }else if(answer.equals("2")){
                    System.out.print("Would you like to view a specific Order? (1.Yes or 2.No): ");
                    String ap = in.nextLine();

                    if (ap.equals("1")){
                        System.out.print("Put the code of the order you would like to view: ");
                        int code = in.nextInt();

                        if(orders.containsKey(code)){
                            System.out.println(orders.get(code));
                            System.out.print("\nHas the order arrived? (1.Yes or 2.No): ");
                            ap = in.next();
                            
                            if(ap.equals("1")){
                                orders.get(code).arrived();
                                System.out.printf("The arrival status of the order with code %d has been set to true.\n", code);
                                sales.put(j, new Sale(j, orders.get(code).get_item(), orders.get(code).get_phone(), date));
                            }
                        }else{
                            System.out.println("Opps, no such code found!");
                        }
                    }else if (ap.equals("2")){
                        for(HashMap.Entry order : orders.entrySet())
			                System.out.println(order.getValue());
                            System.out.println("\n");
                    }
                }else if(answer.equals("3")){
                    for(HashMap.Entry sale : sales.entrySet())
			                System.out.println(sale.getValue());
                            System.out.println("\n");
                }else if(answer.equals("0")){
                    System.out.println("Thanks for visiting our store! \nCome back soon!");
                    
                    System.out.println();
                    System.out.println("           ** ** **       **        **       ** ** ** **        ** ** ** **        ");
                    System.out.println("           **     **      **        **       **                 **       **        ");
                    System.out.println("           **     **       **      **        **                 **       **        ");
                    System.out.println("           **    **          **  **          **                 **       **        ");
                    System.out.println("           **  **              **            ** ** ** **        **       **        ");
                    System.out.println("           **    **            **            **                   **   **          ");
                    System.out.println("           **     **           **            **                     **             ");
                    System.out.println("           **     **           **            **                  **    **          ");
                    System.out.println("           ** ** **            **            ** ** ** **            **             ");
                    System.out.println();
                    done = true;
                }//if
            }//while
        }//try
    }//main
}//MainApp