import java.util.*;
import java.text.*;
import java.io.*;

class Elec {
    private String id, type;
    private long oldIndex, newIndex, coefficient, excessive, amount,total;

    private static int cnt = 1;

    public Elec(String type, long oldIndex, long newIndex) {
        this.id = String.format("KH%02d", cnt++);
        this.type = type;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        this.coefficient = calCoefficient(type);
        this.amount = (newIndex-oldIndex)* coefficient * 550;
        this.excessive = calExcessive(oldIndex,newIndex,amount);
        this.total= amount + excessive;
    }

    public long getTotal() {
        return total;
    }

    public long calCoefficient(String type){
        if(type.equals("KD")) return 3;
        if(type.equals("NN")) return 5;
        if(type.equals("TT")) return 4;
        if(type.equals("CN")) return 2;
        else return 0;
    }
    public long calExcessive(long oldIndex, long newIndex, long amount){
        long diff = newIndex - oldIndex;
        if(diff >= 50 && diff <=100) return Math.round(amount*35.0/100);
        if(diff >100) return Math.round(amount*100.0/100);
        else return 0;
    }

    @Override
    public String toString(){
        return id + " " + coefficient + " " + amount + " " + excessive + " " + total;
    }
}
public class J05050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Elec> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.nextLine();
            long oldIndex = Long.parseLong(sc.nextLine());
            long newIndex = Long.parseLong(sc.nextLine());

            list.add(new Elec(type, oldIndex, newIndex));
        }
        list.sort(Comparator.comparing(Elec::getTotal).reversed());
        for (Elec x : list)
            System.out.println(x);
    }
}
