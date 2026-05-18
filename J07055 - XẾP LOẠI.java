import javax.security.auth.Subject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
class Subjects{

    private static int i = 1;
    private String id, name,classify;
    private int exercise,pratice,test;
    public float overall;

    public Subjects(String name, int exercise, int pratice, int test) {
        this.name = normalize(name);
        this.id = String.format("SV%02d", i++);
        this.exercise = exercise;
        this.pratice = pratice;
        this.test = test;
        this.overall = (float)(exercise * 0.25 + pratice * 0.35 + test * 0.4);
        this.classify = category(overall);
    }

    public static String category(float overall){
        if (overall < 5) return "KEM";
        else if (overall >= 5  && overall < 6.5) return "TRUNG BINH";
        else if (overall >= 6.5  && overall < 8) return "KHA";
        else  return "GIOI";
    }

    public float getOverall() {
        return overall;
    }

    public static String normalize(String orgin_name){
        String[] words = orgin_name.toLowerCase().trim().split("\\s++");
        String name = "";
        for (String word : words){
            name += word.substring(0,1).toUpperCase() + word.substring(1) + " ";
        }
        return name.trim();
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f %s", id,name,overall,classify);
    }
}
public class J07055 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("BANGDIEM.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Subjects> list = new ArrayList<>();

        while (n-- > 0) {
            String name = sc.nextLine();
            int exercise = Integer.parseInt(sc.nextLine());
            int pratice = Integer.parseInt(sc.nextLine());
            int test = Integer.parseInt(sc.nextLine());
            list.add(new Subjects(name,exercise,pratice,test));
        }

        list.sort(Comparator.comparing(Subjects::getOverall).reversed());

        for (Subjects x : list){
            System.out.println(x);
        }
    }
}
