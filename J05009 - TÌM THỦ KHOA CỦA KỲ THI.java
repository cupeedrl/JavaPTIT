import java.util.*;
import java.text.*;

class Attendees {
    private String name, date;
    private int id;
    private double sub1, sub2, sub3, overall;
    private static int i = 1;

    public Attendees(String name, String date, double sub1, double sub2, double sub3) {
        this.id = i++;
        this.name = name;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.overall = sub1 + sub2 + sub3;
        this.date = date;
    }

    public double getOverall() {
        return overall;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + date + " " + String.format("%.1f", overall);
    }
}

public class J05009 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        List<Attendees> list = new ArrayList<>();

        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String name = sc.nextLine();
            String date = sc.nextLine();
            double sub1 = sc.nextDouble();
            double sub2 = sc.nextDouble();
            double sub3 = sc.nextDouble();
            list.add(new Attendees(name, date, sub1, sub2, sub3));
        }

        list.sort(Comparator.comparing(Attendees::getOverall).reversed()
                .thenComparing(Attendees::getId));

        double prev = list.get(0).getOverall();

        for (Attendees x : list){
            double cur = x.getOverall();
            if(cur != prev)
                break;
            System.out.println(x);
            prev = cur;
        }
    }
}
