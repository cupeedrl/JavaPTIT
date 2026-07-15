import java.util.*;

class Salary {
    private String id, name, pos;
    private long salary, days;

    private long monthSalary, bonus, allowance, total;

    private static int cnt = 1;

    public Salary(String name, long salary, long days, String pos) {
        this.id = String.format("NV%02d", cnt++);
        this.name = name;
        this.salary = salary;
        this.days = days;
        this.pos = pos;
        this.monthSalary = salary * days;
        this.allowance =support(pos);
        this.bonus = reward(days,monthSalary);
        this.total = monthSalary + bonus + allowance;
    }

    public static long reward (long days, long monthSalary){
        if(days >= 25) return monthSalary * 20/100;
        if(days >= 22) return monthSalary * 10/100;
        else return 0;
    }

    public static long support(String pos){
        if(pos.equals("GD")) return 250000;
        if(pos.equals("PGD")) return 200000;
        if(pos.equals("TP")) return 180000;
        if(pos.equals("NV")) return 150000;
        else return 0;
    }

    public long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + monthSalary + " " + bonus + " " + allowance + " " + total;
    }
}

public class J05040 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Salary> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            long salary = Long.parseLong(sc.nextLine());
            long days = Long.parseLong(sc.nextLine());
            String pos = sc.nextLine();
            list.add(new Salary(name, salary, days, pos));
        }
        for (Salary x : list) {
            System.out.println(x);
        }
    }
}
