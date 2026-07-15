import java.util.*;
import static java.lang.Math.*;
import java.io.*;
import java.text.*;

class Products {
    private String id, name, unit;
    private int buy,sell,profit;
    private static int idx = 1;

    public Products(String name, String unit, int buy, int sell) {
        this.id = String.format("MH%03d", idx++);
        this.name = name;
        this.unit = unit;
        this.buy = buy;
        this.sell = sell;
        this.profit = sell - buy;
    }

    public int getProfit() {
        return profit;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + unit + " " + buy + " " + sell + " " + profit;
    }
}

public class J05081 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Products> list = new ArrayList<>();

        int t = sc.nextInt();
        sc.nextLine();
        while(t-- >0){
            String name = sc.nextLine();
            String unit = sc.nextLine();
            int buy = sc.nextInt();
            int sell = sc.nextInt();
            sc.nextLine();
            list.add(new Products(name,unit,buy,sell));
        }
        list.sort(Comparator.comparing(Products::getProfit).reversed());

        for (Products x : list){
            System.out.println(x);
        }
    }
}

