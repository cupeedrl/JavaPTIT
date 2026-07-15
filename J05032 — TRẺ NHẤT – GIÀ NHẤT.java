import java.io.*;
import java.util.*;
import java.text.*;
class People {
    private String name, birthdate;
    private long duration;
    public People(String name, String birthdate) throws Exception{
        this.name = name;

        this.birthdate = birthdate;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(birthdate);
        this.duration = date.getTime();
    }

    public long getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class J05032 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        List<People> list = new ArrayList<>();

        while (t-- > 0){
            String in = sc.nextLine();
            String[] words = in.trim().split("\\s+");
            String name = words[0];
            String birthdate = words[1];
            list.add(new People(name,birthdate));
        }
        list.sort(Comparator.comparing(People::getDuration));
        System.out.println(list.get(list.size()-1).getName());
        System.out.println(list.get(0).getName());
    }
}
