import java.util.*;
import java.text.*;

class Student {

    private String id, name, rank;
    private double math, literature, foreignLanguage, physics, chemistry,
            biology, history, geography, civic, technology, average;
    private static int cnt = 1;

    public Student(String name, double math, double literature, double foreignLanguage, double physics, double chemistry, double biology, double history, double geography, double civic, double technology) {
        this.id = String.format("HS%02d",cnt++);
        this.name = name;
        this.math = math;
        this.literature = literature;
        this.foreignLanguage = foreignLanguage;
        this.physics = physics;
        this.chemistry = chemistry;
        this.biology = biology;
        this.history = history;
        this.geography = geography;
        this.civic = civic;
        this.technology = technology;

        this.average = (math * 2 + literature * 2 + foreignLanguage
                + physics + chemistry + biology
                + history + geography + civic + technology) / 12;
        this.average = Math.round(this.average * 10.0) / 10.0;
        this.rank = ranking(average);

    }

    public double getAverage() {
        return average;
    }

    public String getId() {
        return id;
    }

    public static String ranking(double average){
        if(average >= 9) return "XUAT SAC";
        if(average >= 8) return "GIOI";
        if(average >= 7) return "KHA";
        if(average >= 5) return "TB";
        return "YEU";
    }

    @Override
    public String toString(){
        return id + " " + name + " " + String.format("%.1f",average) + " " + rank;
    }
}
public class J05018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> list = new ArrayList<>();

        int t = Integer.parseInt(sc.nextLine());

        while(t-- > 0){

            String name = sc.nextLine();

            String[] scores = sc.nextLine().trim().split("\\s+");

            double math = Double.parseDouble(scores[0]);
            double literature = Double.parseDouble(scores[1]);
            double foreignLanguage = Double.parseDouble(scores[2]);
            double physics = Double.parseDouble(scores[3]);
            double chemistry = Double.parseDouble(scores[4]);
            double biology = Double.parseDouble(scores[5]);
            double history = Double.parseDouble(scores[6]);
            double geography = Double.parseDouble(scores[7]);
            double civic = Double.parseDouble(scores[8]);
            double technology = Double.parseDouble(scores[9]);

            list.add(new Student(name,math,literature,foreignLanguage,physics,chemistry,
                    biology,history,geography,civic,technology));
        }
        list.sort(Comparator.comparing(Student::getAverage).reversed().thenComparing(Student::getId));

        for (Student x : list){
            System.out.println(x);
        }
    }
}
