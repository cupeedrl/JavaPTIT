import java.util.*;
import java.io.*;
class Student{
    private String id,name,birth_date,room;
    private double gpa;

    public Student(int id, String name, String room, String birth_date, double gpa) {
        this.id = String.format("B20DCCN%03d",id);
        this.name = name;
        this.room = room;
        this.birth_date = normalize(birth_date);
        this.gpa = gpa;
    }
    public String normalize(String birth_date){
        birth_date = birth_date.trim();
        String[] parts = birth_date.split("/");
        String d = parts[0], m = parts[1], y = parts[2];
        if(d.length() == 1)  d = "0"+ d;
        if(m.length() == 1)  m = "0"+ m;
        return d + "/" + m + "/" + y;
    }
    @Override
    public String toString(){
        return id + " " + name + " " + room + " " + birth_date + " " + String.format("%.2f",gpa);
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File ("SV.in"));

        int n = Integer.parseInt(sc.nextLine());
        List<Student> group_student = new ArrayList<>();

        for(int i = 1; i <=n; i++){
            String name = sc.nextLine();
            String room = sc.nextLine();
            String birth_date = sc.nextLine();
            double gpa = Double.parseDouble(sc.nextLine());
            group_student.add(new Student(i, name, room, birth_date, gpa));
        }

        for(Student student : group_student){
            System.out.println(student);
        }
    }
}
