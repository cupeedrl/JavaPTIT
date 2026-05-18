import java.util.*;
import java.io.*;
import java.text.*;

class Online{
    private String name,start, end;
    private long interval;

    public Online(String name, String start, String end) throws ParseException {
        this.name = name;
        this.start = start;
        this.end = end;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date startDate = sdf.parse(start);
        Date endDate = sdf.parse(end);
        this.interval = (endDate.getTime() - startDate.getTime()) / (1000 * 60);
    }

    public String getName() {
        return name;
    }

    public long getInterval() {
        return interval;
    }

    @Override
    public String toString(){
        return name + " " + interval;
    }
}
public class J07084 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {

        Scanner sc = new Scanner(new FileInputStream("ONLINE.in"));

        int n = Integer.parseInt(sc.nextLine());

        List<Online> list = new ArrayList<>();

        while(n--  > 0){
            String name = sc.nextLine();
            String start = sc.nextLine();
            String end = sc.nextLine();

            list.add(new Online(name,start,end));
        }
        list.sort(Comparator.comparing(Online::getInterval).reversed().thenComparing(Online::getName));
        for (Online x : list){
            System.out.println(x);
        }
    }
}
