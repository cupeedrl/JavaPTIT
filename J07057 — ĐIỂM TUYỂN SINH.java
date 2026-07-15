import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Pupils {

    private String id, name, ethnic, status;
    private float priority, score;
    private int area;
    private static int i = 1;

    public Pupils(String name, float score, String ethnic, int area) {
        this.id = String.format("TS%02d",i++);
        this.name = normalize(name);
        this.ethnic = ethnic;
        this.area = area;
        this.score = score + priority(ethnic,area);
    }

    public String getStatus() {
        return status;
    }

    public float getScore() {
        return score;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static String normalize(String origin_name){
        String[] name = origin_name.toLowerCase().trim().split("\\s+");
        String res = "";

        for (String word : name){
            res += word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }

    public static float priority(String ethnic, int area){
        float bonus = 0;

        if(area == 1 ) bonus +=1.5;
        else if (area == 2 ) bonus+=1.0;

        if(!ethnic.equals("Kinh")) bonus +=1.5;

        return bonus;
    }
    @Override
    public String toString(){
        return String.format("%s %s %.1f ",id,name,score);
    }
}

public class J07057 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("THISINH.in"));

        List<Pupils> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0){
            String name = sc.nextLine();
            float score = Float.parseFloat(sc.nextLine());
            String ethnic = sc.nextLine();
            int area = Integer.parseInt(sc.nextLine());
            list.add(new Pupils(name,score,ethnic,area));
        }
        list.sort(Comparator.comparing(Pupils::getScore).reversed());
        for (Pupils x : list){
            if(x.getScore() >= 20.5){
                x.setStatus("Do");
            }
            else{
                x.setStatus("Truot");
            }
            System.out.print(x);
            System.out.println(x.getStatus());
        }
    }
}
