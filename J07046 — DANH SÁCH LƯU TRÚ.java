import java.util.*;
import java.io.*;
import java.text.*;

class Customer {
    private static int cnt = 1;
    private String id, name, room;
    private long duration;

    public Customer(String name, String room, long duration){
        this.id = String.format("KH%02d", cnt++);
        this.name = name;
        this.room = room;

        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + room + " " + duration;
    }
}

public class J07046 {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(new File("KHACH.in"));

        int n = Integer.parseInt(sc.nextLine().trim());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Customer> visitor = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine().trim();
            String room = sc.nextLine().trim();
            Date start = sdf.parse(sc.nextLine());
            Date end = sdf.parse(sc.nextLine());
            long duration = (end.getTime()-start.getTime()) / (1000 * 60 * 60 * 24);

            visitor.add(new Customer(name, room, duration));
        }

        visitor.sort(Comparator.comparing(Customer::getDuration).reversed());

        visitor.forEach(System.out::println);
    }
}
