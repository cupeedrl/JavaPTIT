import java.util.*;
import java.text.*;

class Product {

    private int id;
    private String name, group;
    private double buy, sell, profit;
    private static int cnt = 1;

    public Product(String name, String group, double buy, double sell) {
        this.id = cnt++;
        this.name = name;
        this.group = group;
        this.buy = buy;
        this.sell = sell;
        this.profit = sell-buy;
    }
    public double getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + group + " " + String.format("%.2f", profit);
    }
}

public class J05010 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String name = sc.nextLine();
            String group = sc.nextLine();
            double buy = sc.nextDouble();
            double sell = sc.nextDouble();
            list.add(new Product(name,group,buy,sell));
        }
        list.sort(Comparator.comparing(Product::getProfit).reversed());
        for (Product x : list){
            System.out.println(x);
        }
    }
}
