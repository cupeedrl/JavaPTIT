import java.util.*;

class Student {
    private String id, name, className;
    private double p1, p2, p3;

    public Student(String id, String name, String className,
                   double p1, double p2, double p3) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.1f %.1f %.1f",id,name,className,p1,p2,p3);
    }
}
public class J05030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Student> list = new ArrayList<>();

        while (n-- > 0) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            String className = sc.nextLine();

            double p1 = Double.parseDouble(sc.nextLine());
            double p2 = Double.parseDouble(sc.nextLine());
            double p3 = Double.parseDouble(sc.nextLine());

            list.add(new Student(id, name, className, p1, p2, p3));
        }

        list.sort(Comparator.comparing(Student::getName));

        int rank = 1;
        for (Student x : list) {
            System.out.println(rank++ + " " + x);
        }
    }
}
