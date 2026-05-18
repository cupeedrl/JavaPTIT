import java.util.*;
import static java.lang.Math.*;
class Student {

    private String full_name = "B20DCCN001";
    private String class_name;
    private String birth_date;
    private float gpa;

    public Student() {
        this.full_name = "";
        this.class_name = "";
        this.birth_date = "";
        this.gpa = 0;
    }

    public void fill(Scanner sc){
        this.full_name = sc.nextLine();
        this.class_name = sc.nextLine();
        this.birth_date = sc.nextLine();
        this.gpa = sc.nextFloat();
    }
    private String normalize(String birth_date){
        String parts[] = birth_date.split("/");
        for(int i = 0; i < parts.length; i++){
            if(parts[i].length() < 2){
                parts[i] = "0" + parts[i];
            }
        }
        return parts[0] + "/"+ parts[1] + "/"+ parts[2];
    }
    @Override
    public String toString(){
        return "B20DCCN001 "
                + full_name + " "
                + class_name + " "
                + normalize(birth_date) + " "
                + String.format("%.2f", gpa);
    }
}

public class Up{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student people = new Student();
        people.fill(sc);
        System.out.println(people);
    }
}
