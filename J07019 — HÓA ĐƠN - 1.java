import java.util.*;
import java.io.*;
import java.text.*;
import java.util.function.Function;
class Products{
    private String id,name;
    private long price1,price2;

    public Products(String id, String name, long price1, long price2) {
        this.id = id;
        this.name = name;
        this.price1 = price1;
        this.price2 = price2;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice1() {
        return price1;
    }

    public long getPrice2() {
        return price2;
    }
}
class Bills{
    private String code,name;
    private long quantity,price,discount,money,total;
    private static int idx = 1;

    public Bills(String code, long quantity) {
        this.code = String.format("%s-%03d",code,idx++);
        this.quantity = quantity;
    }
    public long calDiscount(long quantity, long total){
        if(quantity >= 150) return total*50/100;
        else if(quantity >= 100) return total*30/100;
        else if(quantity >= 50) return total*15/100;
        else return 0;
    }

    public void setPrice(long price) {
        this.price = price;
        this.money = price*this.quantity;
        this.discount = calDiscount(this.quantity,this.money);
        this.total = money-discount;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return code + " " + name + " " + discount + " " + total;
    }
}
public class J07019 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("DATA1.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Products> proList = new ArrayList<>();
        while(n-- > 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            long price1 = Long.parseLong(sc.nextLine());
            long price2 = Long.parseLong(sc.nextLine());

            Products stuff = new Products(id,name,price1,price2);
            proList.add(stuff);
        }
        sc = new Scanner(new FileInputStream("DATA2.in"));
        int m = Integer.parseInt(sc.nextLine());

        List<Bills> billist = new ArrayList<>();

        while(m-- > 0){
            String[] words = sc.nextLine().trim().split("\\s+");
            String id = words[0];
            long quantity = Long.parseLong(words[1]);
            Bills bill = new Bills(id,quantity);
            billist.add(bill);
        }

        for(Products x : proList){
            for (Bills y : billist){
                String code = y.getCode().substring(0,2);
                String type = y.getCode().substring(2,3);

                if(x.getId().equals(code)){
                    y.setName(x.getName());
                    if(type.equals("1")){
                        y.setPrice(x.getPrice1());
                    }
                    else if (type.equals("2")) {
                        y.setPrice(x.getPrice2());
                    }
                }
            }
        }
        for (Bills x : billist){
            System.out.println(x);
        }
    }
}
