import java.util.*;

class Product {
    private String id, name;
    private long quantity, price;
    private long discount, total;

    private static Map<String, Integer> res = new HashMap<>();

    public Product(String name, long quantity, long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = price * quantity * percent(quantity)/100;
        this.total = quantity*price - discount;

        String code = "";
        String[] words = name.trim().split("\\s+");
        code += Character.toUpperCase(words[0].charAt(0));
        code += Character.toUpperCase(words[1].charAt(0));

        res.put(code, res.getOrDefault(code,0)+1);
        //map.get(key) => return value of key;
        //map.keySet() => return key of value;
        //map.values() => return all values;
        //map.entrySet() => return all values and keys;
        this.id =  code + String.format("%02d",res.get(code));
    }

    public long percent(long quantity){
        if (quantity > 10) return 5;
        if (quantity >= 8) return 2;
        if (quantity >= 5) return 1;
        else return 0;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + discount + " " + total;
    }
}

public class J05046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        List<Product> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            String name = sc.nextLine();
            long quantity = Long.parseLong(sc.nextLine());
            long price = Long.parseLong(sc.nextLine());

            list.add(new Product(name, quantity, price));
        }
        for (Product x : list)
            System.out.println(x);
    }
}
