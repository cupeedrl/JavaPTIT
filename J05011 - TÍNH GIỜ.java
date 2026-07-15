import java.util.*;
import java.text.*;

class Bill {

    private String id;
    private String name, from,to, duration;
    private int interval;
    public Bill(String id, String name, String from, String to) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;

        String res[] = from.trim().split(":");
        int startTime = Integer.parseInt(res[0]) * 60 + Integer.parseInt(res[1]);

        res = to.trim().split(":");
        int endTime = Integer.parseInt(res[0]) * 60 + Integer.parseInt(res[1]);

        this.interval = endTime-startTime;
        int hour = interval / 60;
        int minute = interval % 60;

        this.duration = hour  + " gio " + minute + " phut";
    }

    public int getInterval() {
        return interval;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + duration;
    }
}

public class J05011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Bill> list = new ArrayList<>();

        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String from = sc.nextLine();
            String to = sc.nextLine();
            list.add(new Bill(id,name,from,to));
        }
        list.sort(Comparator.comparing(Bill::getInterval).reversed());
        for (Bill x : list){
            System.out.println(x);
        }
    }
}
