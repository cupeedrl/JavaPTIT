import java.util.*;

class Student {
    private String id, name, rank;
    private double gpa;
    private long pos;
    private static int cnt = 1;

    public Student(String name, double gpa) {
        this.id = String.format("HS%02d", cnt++);
        this.name = name;
        this.gpa = gpa;
        this.rank = cate(gpa);
    }

    public void setPos(long pos) {
        this.pos = pos;
    }

    public double getGpa() {
        return gpa;
    }

    public String cate(double gpa){
        if(gpa < 5) return "Yeu";
        else if(gpa < 7) return "Trung Binh";
        else if(gpa < 9) return "Kha";
        else return "Gioi";
    }

    @Override
    public String toString(){
        return id + " " + name + " " + gpa + " " +  rank + " " + pos;
    }
}

public class J05054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Student> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double gpa = Double.parseDouble(sc.nextLine());
            list.add(new Student(name, gpa));
        }

        List<Student> res = new ArrayList<>(list);
        res.sort(Comparator.comparing(Student::getGpa).reversed());

        double prev = -1;
        long i = 0;
        int pos = 1;

        for (Student x : res){
            double cur = x.getGpa();
            if(cur != prev){
                i = pos;
                prev = cur;
            }
            x.setPos(i);
            pos ++;
        }

        for (Student x : list){
            System.out.println(x);
        }
    }
}
