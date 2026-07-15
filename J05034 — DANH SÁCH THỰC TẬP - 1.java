import java.util.*;

class Student {
    private int stt;
    private String studentId, name, className, email, enterprise;

    private static int rank = 1;

    public Student(String studentId, String name, String className, String email, String enterprise) {
        this.stt = rank++;
        this.studentId = studentId;
        this.name = name;
        this.className = className;
        this.email = email;
        this.enterprise = enterprise;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return stt + " " + studentId + " " + name + " " + className + " " + email + " " + enterprise;
    }
}

public class J05034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            String studentId = sc.nextLine();
            String name = sc.nextLine();
            String className = sc.nextLine();
            String email = sc.nextLine();
            String enterprise = sc.nextLine();

            list.add(new Student(studentId, name, className, email, enterprise));
        }

        list.sort(Comparator.comparing(Student::getName));
        int q = Integer.parseInt(sc.nextLine());

        while (q-- > 0){
            String intern = sc.nextLine();
            for (Student x : list){
                if(intern.equals(x.getEnterprise())){
                    System.out.println(x);
                }
            }
        }
    }
}
