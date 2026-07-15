import java.util.*;
import java.text.*;
import java.io.*;

class Goods{
    private String id,name,group;

    public Goods(String id, String name, String group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }
}

class Bills {
    private String id,name;
    private long imTotal,exTotal;

    public Bills(String id, String name, long imTotal, long exTotal) {
        this.id = id;
        this.name = name;
        this.imTotal = imTotal;
        this.exTotal = exTotal;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + imTotal + " " + exTotal;
    }
}
public class J05076 {
    public static long calProfit(String group){
         if (group.equals("A")) return 108;
         if (group.equals("B")) return 105;
         else return 102;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        List<Goods> list = new ArrayList<>();

        while (t-->0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String group = sc.nextLine();
            list.add(new Goods(id,name,group));
        }

        int t2 = Integer.parseInt(sc.nextLine());
        List<Bills> res = new ArrayList<>();

        while (t2-->0){
            String line = sc.nextLine();
            String[] words = line.trim().split("\\s+");

            String id = words[0];
            long imQuantity = Long.parseLong(words[1]);
            long imPrice = Long.parseLong(words[2]);
            long exQuantity = Long.parseLong(words[3]);

            for(Goods x : list){
                if(x.getId().equals(id)){
                    long exTotal  = imPrice * calProfit(x.getGroup()) * exQuantity/100;
                    res.add(new Bills(id,x.getName(),imQuantity*imPrice,exTotal ));
                }
            }
        }

        for (Bills x : res){
            System.out.println(x);
        }
    }
}
