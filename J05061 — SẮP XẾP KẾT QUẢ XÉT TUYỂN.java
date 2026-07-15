import java.util.*;

class Worker {
    private String id, name, birth;
    private double theory, practice;
    private int age, avg;
    private String rank;

    private static int cnt = 1;

    public Worker(String name, String birth, double theory, double practice) {
        this.id = String.format("PH%02d", cnt++);
        this.name = name;
        this.birth = birth;
        this.theory = theory;
        this.practice = practice;

        this.age = 2021 - Integer.parseInt(birth.substring(6));

        double bonus = calBonus(theory, practice);

        this.avg = (int)Math.round((theory + practice) / 2 + bonus);

        if(this.avg > 10) this.avg = 10;

        this.rank = calRank(avg);
    }

    public int getAvg() {
        return avg;
    }

    public String getId() {
        return id;
    }

    public double calBonus(double theory, double practice){
        if(theory >= 8 && practice >= 8) return 1;
        if(theory >= 7.5 && practice >= 7.5) return 0.5;
        return 0;
    }

    public String calRank(int avg){
        if(avg < 5) return "Truot";
        if(avg <= 6) return "Trung binh";
        if(avg == 7) return "Kha";
        if(avg == 8) return "Gioi";
        return "Xuat sac";
    }

    @Override
    public String toString(){
        return id + " " + name + " " + age + " " + avg + " " + rank;
    }
}

public class J05060 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Worker> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String name = sc.nextLine();
            String birth = sc.nextLine();
            double theory = Double.parseDouble(sc.nextLine());
            double practice = Double.parseDouble(sc.nextLine());

            list.add(new Worker(name, birth, theory, practice));
        }
        list.sort(Comparator.comparing(Worker::getAvg).reversed().thenComparing(Worker::getId));
        for(Worker x : list){
            System.out.println(x);
        }
    }
}
