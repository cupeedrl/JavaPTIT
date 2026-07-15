import java.util.*;

class Teacher {
    private String code, name, role;
    private long baseSalary, level, allowance, income;

    public Teacher(String code, String name, long baseSalary) {
        this.code = code;
        this.name = name;
        this.baseSalary = baseSalary;
        this.role = code.substring(0, 2);
        this.level = Long.parseLong(code.substring(2));

        this.allowance = calAllowance(role);

        this.income = baseSalary * level + allowance;
    }

    public String getRole() {
        return role;
    }

    public long calAllowance(String role) {
        if(role.equals("HT")) return 2000000;
        if(role.equals("HP")) return 900000;
        return 500000;
    }

    @Override
    public String toString() {
        return code + " " + name + " " + level + " " + allowance + " " + income;
    }
}

public class J05064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<Teacher> list = new ArrayList<>();
        int cntHT = 0;
        int cntHP = 0;
        while (t-- > 0){
            String code = sc.nextLine();
            String name = sc.nextLine();
            long baseSalary = Long.parseLong(sc.nextLine());
            Teacher x = new Teacher(code,name,baseSalary);

            if(x.getRole().equals("HT") ){
                cntHT++;
                if(cntHT > 1)
                    continue;;
            }
            if(x.getRole().equals("HP")){
                cntHP++;
                if(cntHP > 2)
                    continue;
            }
            list.add(x);
        }
        for(Teacher x : list){
            System.out.println(x);
        }
    }
}
