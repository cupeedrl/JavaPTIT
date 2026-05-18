import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Candidate {

    private String id, name, status;
    private float priority, score;
    private static float standard = 24;

    public Candidate(String id, String name, float math, float physics, float chemistry) {
        this.id = id;
        this.name = normalize(name);
        this.priority = caculate(id);
        this.score = math * 2 + physics + chemistry;
        if(this.score + priority >= standard){
            this.status = "TRUNG TUYEN";
        }
        else{
            this.status = "TRUOT";
        }
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

    public static String formatNumber(float x){
        if(x == (int)x){
            return Integer.toString((int)x);
        }
        return String.format("%.1f", x);
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
        return String.format("%s %s %s %s %s",id,name,formatNumber(priority),formatNumber(score),status);
    }
}

public class J04013 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();
        String name = sc.nextLine();
        float math = Float.parseFloat(sc.nextLine());
        float physic = Float.parseFloat(sc.nextLine());
        float chemistry = Float.parseFloat(sc.nextLine());

        Candidate person = new Candidate(id,name,math,physic,chemistry);

        System.out.println(person);
    }
}
