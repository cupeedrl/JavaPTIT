import java.util.*;
import java.text.*;

class Student {

    private String id, name, status;
    private double math,physics, chemistry,priority,total;

    public Student(String id, String name, double math, double physics, double chemistry) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        this.priority = calPriority(id);
        this.total = physics + math * 2 + chemistry + priority;
        this.status = calStatus(total);
    }

    public double getTotal() {
        return total;
    }

    public String getId() {
        return id;
    }

    public String formatScore(double score){
        if(score == (long) score) return String.format("%d", (long)score);
        return String.format("%.1f", score);
    }

    public double calPriority (String id){
        String area = id.substring(0,3).toUpperCase();
        if(area.equals("KV1")) return 0.5;
        if(area.equals("KV2")) return 1.0;
        return 2.5;
    }

    public String calStatus (double total){
        if(total >= 24) return "TRUNG TUYEN";
        else return "TRUOT";
    }
    @Override
    public String toString(){
        return id + " " + name + " " + formatScore(priority) + " " + formatScore(total) + " " + status;
    }
}
public class J05057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> list = new ArrayList<>();

        int t = Integer.parseInt(sc.nextLine());

        while(t-- > 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            double math = Double.parseDouble(sc.nextLine());
            double physics = Double.parseDouble(sc.nextLine());
            double chemistry = Double.parseDouble(sc.nextLine());
            list.add(new Student(id,name,math,physics,chemistry));
        }
        list.sort(Comparator.comparing(Student::getTotal).reversed().thenComparing(Student::getId));
        for (Student x : list){
            System.out.println(x);
        }
    }
}
