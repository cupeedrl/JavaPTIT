import java.util.*;

class Order {
    private String name, id, orderNumber;
    private long price, quantity, discount, total,type;

    public Order(String name, String id, long price, long quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.type = Long.parseLong(id.substring(id.length()-1));
        this.orderNumber = id.substring(1, 4);
        this.discount = calDiscount(type,price,quantity);
        this.total = quantity * price - discount;
    }

    public long calDiscount (long type, long price, long quantity){
        if (type == 1) return price*quantity*50/100;
        if (type == 2) return price*quantity*30/100;
        else return 0;
    }

    @Override
    public String toString(){
        return name + " " + id + " " + orderNumber + " " + discount + " " + total;
    }
}

public class J05052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        List<Order> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            String name = sc.nextLine();
            String id = sc.nextLine();
            long price = Long.parseLong(sc.nextLine());
            long quantity = Long.parseLong(sc.nextLine());

            list.add(new Order(name, id, price, quantity));
        }
        for (Order x : list){
            System.out.println(x);
        }
    }
}
