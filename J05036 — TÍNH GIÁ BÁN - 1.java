import java.util.*;

class Expense {
    private String name,unit,id;
    private long buy,sell,delivery,amount,quantity;
    private static int i = 1;

    public Expense(String name, String unit, long buy, long quantity) {
        this.id = String.format("MH%02d", i++);
        this.name = name;
        this.unit = unit;
        this.buy = buy;
        this.quantity = quantity;

        this.delivery = Math.round(buy*quantity* 0.05f);
        this.amount = buy*quantity + delivery;
        this.sell = Math.round(amount* 1.02f);
    }

    @Override
    public String toString(){
        return String.format("%s %s %s %d %d %d",id,name,unit,delivery,amount,sell);
    }
}

public class J05036 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        List<Expense> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            String name = sc.nextLine();
            String unit = sc.nextLine();
            long buy = Long.parseLong(sc.nextLine());
            long number = Long.parseLong(sc.nextLine());

            list.add(new Expense(name,unit,buy,number));
        }
        for (Expense x : list){
            System.out.println(x);
        }
    }
}
