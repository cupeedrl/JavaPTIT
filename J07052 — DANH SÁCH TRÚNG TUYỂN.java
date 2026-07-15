import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Candidate {

    private String id, name, status;
    private float priority, score;

    public Candidate(String id, String name, float math, float physics, float chemistry) {
        this.id = id;
        this.name = normalize(name);
        this.priority = caculate(id);
        this.score = math * 2 + physics + chemistry + priority;
    }

    public static float caculate (String id){
        char area = id.charAt(2);
        if (area == '1' ) return 0.5f;
        else if (area == '2' ) return  1.0f;
        else return 2.5f;
    }

    public static String normalize(String origin_name){
        String[] name = origin_name.toLowerCase().trim().split("\\s+");
        String res = "";

        for (String word : name){
            res += word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }

    public String displayScore(float score){
        if (score == (int)score){
            return Integer.toString((int) score);
        }
        return Float.toString(score);
    }

    public String displayPriority(float priority){
        if (priority == (int)priority){
            return Integer.toString((int) priority);
        }
        return Float.toString(priority);
    }
    public float getScore() {
        return score;
    }

    public String getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return String.format("%s %s %s %s %s",id,name,displayPriority(priority),displayScore(score),status);
    }
}

public class J07052 {
    public static void main(String[] args) throws IOException, ParseException  {
        Scanner sc = new Scanner(new FileInputStream("THISINH.in"));

        List<Candidate> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            float math = Float.parseFloat(sc.nextLine());
            float physic = Float.parseFloat(sc.nextLine());
            float chemistry = Float.parseFloat(sc.nextLine());

            list.add(new Candidate(id,name,math,physic,chemistry));
        }
        list.sort(Comparator.comparing(Candidate::getScore).reversed().thenComparing(Candidate::getId));

        int target = Integer.parseInt(sc.nextLine());

        float standard = list.get(target-1).getScore();

        System.out.println(standard);

        for (Candidate x : list){
            if(x.getScore() >= standard){
                x.setStatus("TRUNG TUYEN");
                System.out.println(x);
            }
            else{
                x.setStatus("TRUOT");
                System.out.println(x);
            }
        }
    }
}
