import java.util.*;
import java.io.*;

class Product {
    private String id, name;
    private long type1, type2;

    public Product(String id, String name, long type1, long type2) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
    }

    public String getName() {
        return name;
    }

    public long getType1() {
        return type1;
    }

    public long getType2() {
        return type2;
    }

    public String getId() {
        return id;
    }
}

class Bill {
    private String id, name;
    private long quantity, discount, type, total, money;
    private static int i = 1;

    public Bill(String id, long quantity) {
        this.id = String.format("%s-%03d", id, i++);
        this.quantity = quantity;
    }

    public static long calDiscount(long quantity, long money) {
        if (quantity >= 150) return money * 50 / 100;
        else if (quantity >= 100) return money * 30 / 100;
        else if (quantity >= 50) return money * 15 / 100;
        return 0;
    }

    public String getId() {
        return id;
    }

    public void setType(long type) {
        this.type = type;
        this.money = quantity * type;
        this.discount = calDiscount(quantity, money);
        this.total = money - discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + discount + " " + total;
    }
}

public class J06001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Product> products = new ArrayList<>();
        while (n-- > 0) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            long type1 = Long.parseLong(sc.nextLine());
            long type2 = Long.parseLong(sc.nextLine());
            products.add(new Product(id, name, type1, type2));
        }

        int m = Integer.parseInt(sc.nextLine());
        List<Bill> bill = new ArrayList<>();
        while (m-- > 0) {
            String[] words = sc.nextLine().trim().split("\\s+");
            String id = words[0];
            long quantity = Long.parseLong(words[1]);
            bill.add(new Bill(id, quantity));
        }

        for (Bill x : bill) {
            String sign = x.getId().substring(0, 2);
            String type = x.getId().substring(2, 3);
            for (Product y : products) {
                if (sign.equals(y.getId())) {
                    if (type.equals("1")) {
                        x.setType(y.getType1());
                    } else {
                        x.setType(y.getType2());
                    }
                    x.setName(y.getName());
                }
            }
        }

        for (Bill x : bill) {
            System.out.println(x);
        }
    }
}
