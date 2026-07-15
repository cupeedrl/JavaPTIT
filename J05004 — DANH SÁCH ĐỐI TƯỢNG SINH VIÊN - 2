import java.util.*;
import static java.lang.Math.*;
import java.io.*;
import java.text.*;

class Students {
    private String id, name, birthdate,grade;
    private float gpa;
    private static int cnt = 1;

    public Students(String name, String grade, String birthdate, float gpa)throws Exception {
        this.id = String.format("B20DCCN%03d",cnt++);
        this.name = normalize(name);

        this.grade = grade;
        this.gpa = gpa;

        SimpleDateFormat in = new SimpleDateFormat("d/M/yyyy");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        Date date = in.parse(birthdate);
        this.birthdate = out.format(date);

        this.gpa = gpa;
    }
    public static String normalize(String orginName){
        String[] words = orginName.trim().toLowerCase().split("\\s+");
        String name = "";
        for(String word : words){
            name += word.substring(0,1).toUpperCase() + word.substring(1) + " ";
        }
        return name.trim();
    }
    @Override
    public String toString(){
        return id + " " + name + " " + grade + " " + birthdate + " " + String.format("%.2f", gpa);
    }
}

public class J05003 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        List<Students> list = new ArrayList<>();

        int t = sc.nextInt();
        sc.nextLine();
        while(t-- >0){
            String name = sc.nextLine();
            String grade = sc.nextLine();
            String birthdate = sc.nextLine();
            float gpa = sc.nextFloat();
            sc.nextLine();
            list.add(new Students(name,grade,birthdate,gpa));
        }
        for (Students x : list){
            System.out.println(x);
        }
    }
}


