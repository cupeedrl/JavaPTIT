import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Bill {

    public static int i = 1;

    private String id,name,room;
    private long duration;
    private int extra;
    private long price;

    public Bill(String name, String room, long duration, int extra) {
        this.id = String.format("KH%02d", i++);
        this.name = normalize(name);
        this.room = room;
        this.duration = duration;
        this.extra = extra;
        this.price = cal(room, duration, extra);
    }

    public long getPrice() {
        return price;
    }

    public static String normalize(String orgin_name){
        String[] res = orgin_name.toLowerCase().trim().split("\\s+");

        String name = "";
        for (String word : res){
            name += word.substring(0,1).toUpperCase() + word.substring(1) + " ";
        }
        return name.trim();
    }

    public static long cal (String room, long duration, int extra){
        int floor = Integer.parseInt(room.substring(0,1));
        if (floor == 1 ) return 25 * duration + extra;
        else if (floor == 2 ) return 34 * duration + extra;
        else if (floor == 3 ) return 50 * duration + extra;
        else return 80 * duration + extra;
    }

    @Override
    public String toString(){
        return String.format("%s %s %s %d %d", id, name, room, duration, price);
    }
}

    public class J07051 {
    public static void main(String[] args) throws IOException, ParseException  {
        Scanner sc = new Scanner(new FileInputStream("KHACHHANG.in"));

        List<Bill> apartment = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int n = Integer.parseInt(sc.nextLine());

        while(n-- > 0){
            String name = sc.nextLine();
            String room = sc.nextLine();
            Date start = sdf.parse(sc.nextLine().trim());
            Date end = sdf.parse(sc.nextLine().trim());
            int extra = Integer.parseInt(sc.nextLine());
            long duration = (end.getTime()-start.getTime()) / (1000L*60*60*24) + 1;
            apartment.add(new Bill (name,room,duration,extra));
        }

        apartment.sort(Comparator.comparing(Bill::getPrice).reversed());

        for (Bill b : apartment) {
            System.out.println(b);
        }
    }
}
