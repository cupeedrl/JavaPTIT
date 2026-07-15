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
    
    public String getClassName() {
        return className;
    }
    @Override
    public String toString() {
        return id + " " + name + " " + className + " " + email;
    }
}
public class J05022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> list = new ArrayList<>();

        int t = Integer.parseInt(sc.nextLine());

        while(t--> 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String className = sc.nextLine();
            String email = sc.nextLine();
            list.add(new Student(id, name, className, email));
        }
        int q = Integer.parseInt(sc.nextLine());

        while(q-- > 0){
            String query = sc.nextLine();
            String year = query.substring(2);
            System.out.println("DANH SACH SINH VIEN KHOA " + query + ":");
            for (Student x : list){
                String grade = x.getClassName().substring(1,3);
                if(grade.equals(year)){
                    System.out.println(x);
                }
            }
        }
    }
}
