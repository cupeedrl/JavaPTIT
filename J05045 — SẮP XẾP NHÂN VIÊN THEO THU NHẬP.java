import java.util.*;

class Emp {
    private String id, name, pos;
    private long salary, days;

    private long monthSalary, allowance, pre, remain,total;

    private static int cnt = 1;

    public Emp(String name, String pos, long salary, long days) {
        this.id = String.format("NV%02d", cnt++);
        this.name = name;
        this.pos = pos;
        this.salary = salary;
        this.days = days;

        this.monthSalary = salary * days;
        this.allowance = support(pos);
        this.pre =takePrev(monthSalary,allowance);
        this.remain = monthSalary +allowance - pre;
        this.total = monthSalary + allowance;
    }

    public long getTotal() {
        return total;
    }

    public String getId() {
        return id;
    }

    public static long takePrev(long monthSalary, long allowance){
        double amount = (monthSalary + allowance) * 2.0 / 3;
        if(amount < 25000)
            return Math.round(amount / 1000) * 1000;
        return 25000;
    }

    public static long support(String pos){
        if(pos.equals("GD")) return 500;
        if(pos.equals("PGD")) return 400;
        if(pos.equals("TP")) return 300;
        if(pos.equals("KT")) return 250;
        else return 100;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + allowance  + " " + monthSalary + " " + pre + " " + remain;
    }
}

public class J05044 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Emp> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String pos = sc.nextLine();
            long salary = Long.parseLong(sc.nextLine());
            long days = Long.parseLong(sc.nextLine());
            list.add(new Emp(name,pos,salary,days));
        }

        list.sort(Comparator.comparing(Emp::getTotal).reversed().thenComparing(Emp::getId));
        for (Emp x : list) {
            System.out.println(x);
        }
    }
}
