import java.util.*;
import java.text.*;

class Student {

    private String id, name, className, email;

    public Student(String id, String name, String className, String email) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + className + " " + email;
    }
}
public class J05020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> list = new ArrayList<>();

        while(sc.hasNextLine()){
            String id = sc.nextLine();
            if(id.isEmpty()) break;
            String name = sc.nextLine();
            String className = sc.nextLine();
            String email = sc.nextLine();
            list.add(new Student(id,name,className,email));
        }
        list.sort(Comparator.comparing(Student::getId));

        for (Student x : list){
            System.out.println(x);
        }
    }
}
