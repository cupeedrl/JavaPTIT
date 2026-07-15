import java.util.*;
import java.io.*;
import java.text.*;

class Product {
    private String id,name;
    private int price;
    private long duration;

    public Product(String id, String name, int price, long duration) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + price + " " + duration;
    }
}

public class J07048 {
    public static void main(String[] args) throws IOException{
       Scanner sc = new Scanner(new FileInputStream("SANPHAM.in"));
        List<Product> stuff = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        while(n-- > 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            int price = Integer.parseInt(sc.nextLine());
            long duration = Long.parseLong(sc.nextLine());
            stuff.add(new Product(id,name,price,duration));
        }
        stuff.sort(Comparator.comparing(Product::getPrice).reversed().thenComparing(Product::getId));

        for (Product p : stuff){
            System.out.println(p);
        }
    }
}
