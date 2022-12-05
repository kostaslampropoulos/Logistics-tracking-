public class Order {

        public int code;
        public Item item;
        public String name;
        public String phone;
        public String dateOfArrival;
        public String dateOfOrder;
        public boolean done = false;

        Order(int code, Item item,String name, String phone, String dateOfOrder, String dateOfArrival){
            this.code = code;
            this.item = item;
            this.name = name;
            this.phone = phone;
            this.dateOfOrder = dateOfOrder;
            this.dateOfArrival = dateOfArrival;
        }

        public int get_code() {
            return code;
        }

        public Item get_item() {
            return item;
        }

        public String get_phone(){
            return phone;
        }

        public void arrived(){
            this.done = true;
        }

        public String toString() {
            return "\nCode: " + code
                + "\nItem: " + item.get_brand()+ " " +item.get_name()
                + "\nPhone: " + phone
                + "\nDate of order: " + dateOfOrder
                + "\nDate of arrival: " + dateOfArrival
                + "\nComplete order: " + done;
        }
}
