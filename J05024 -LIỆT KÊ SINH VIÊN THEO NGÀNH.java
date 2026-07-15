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

    public static Boolean isCLC(String className) {
        if(className.charAt(0) == 'E') return true;
        return false;
    }

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
            String major = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN NGANH " + major.toUpperCase() + ":");

            String[] words = major.toUpperCase().trim().split("\\s+");
            String abrr = "" + words[0].charAt(0) + words[1].charAt(0);

            for (Student x : list){
                if(isCLC(x.getClassName()) && (abrr.equals("AT") || abrr.equals("CN")) ){
                    continue;
                }
                String grade = x.getId().substring(5,7).toUpperCase();
                if(grade.equals(abrr)){
                    System.out.println(x);
                }
            }
        }
    }
}
