import java.util.*;
import java.io.*;

class Products {

    public static int i = 1;
    private String id,name;
    private String group;
    private float profit;

    public Products(String name, String group, float profit) {
        this.id = String.format("MH%02d", i++);
        this.name = name;
        this.group = group;
        this.profit = profit;
    }

    public float getProfit() {
        return profit;
    }

    @Override
    public String toString(){
        return String.format("%s %s %s %.2f", id,name,group,profit);

    }

}

public class J07050 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileInputStream("MATHANG.in"));

        List<Products> stuff = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        while(n-- > 0){
            String name = sc.nextLine();
            String group = sc.nextLine();
            float buy = Float.parseFloat(sc.nextLine());
            float sell =  Float.parseFloat(sc.nextLine());
            float profit = sell-buy;
            stuff.add(new Products (name,group,profit));
        }
        stuff.sort(Comparator.comparing(Products::getProfit).reversed());

        for (Products p : stuff){
            System.out.println(p);
        }
    }
}
