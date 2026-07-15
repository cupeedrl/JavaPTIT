import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Candidates{
    private String id, name, date,status;
    private int score;
    private static int i = 1;
    public Candidates(String name, String date, float theory, float practice) {
        this.id = String.format("PH%02d", i++);
        this.name = normalize(name);
        this.date = date;

        float bonus = getBonus(theory,practice);

        this.score = Math.round((theory + practice) / 2 + bonus);

        if(this.score > 10){
            this.score = 10;
        }
        this.status = classify(score);
    }

    public static String normalize (String origin_name){
        String[] words = origin_name.toLowerCase().trim().split("\\s+");
        String name = "";

        for (String word : words){
            name += word.substring(0,1).toUpperCase() + word.substring(1)+ " ";
        }
        return name.trim();
    }

    public static int age (String date){
        String[] words = date.split("/");
        int year = 2021 - Integer.parseInt(words[2]);
        return year;
    }

    public static float getBonus(float theory, float practice){
        if(theory >= 8 && practice >= 8) return 1.0f;
        if(theory >= 7.5 && practice >= 7.5) return 0.5f;
        else return 0f;
    }
    public static String classify(float score){
        if (score > 10) score = 10f;
        if (score < 5) return "Truot";
        else if (score <= 6) return "Trung binh";
        else if (score == 7) return "Kha";
        else if (score == 8) return "Gioi";
        else return "Xuat sac";
    }

    @Override
    public String toString(){
        return id + " " + name + " " + age(date) + " " + score + " " + status;
    }
}
public class J07053 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("XETTUYEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Candidates> list = new ArrayList<>();

        while(n--  > 0){
            String name = sc.nextLine();
            String date = sc.nextLine();
            float theory = Float.parseFloat(sc.nextLine());
            float practice = Float.parseFloat(sc.nextLine());
            list.add(new Candidates(name,date,theory,practice));
        }
        for (Candidates x : list){
            System.out.println(x);
        }
    }
}
