import java.io.*;
import java.util.*;

class Employee {
    private String name,role,id;
    private int baseSalary,salary, total,workday;
    private static int idx = 1;

    public Employee(String name, int baseSalary, int workday, String role) {
        this.id = String.format("NV%02d",idx++);
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
        this.workday = workday;
        this.salary = this.baseSalary * this.workday;
        this.total = salary + allowance(workday,salary) + bonus(role);
    }

    public static int bonus(String role){
        if(role.equals("GD")) return 250000;
        if(role.equals("PGD")) return 200000;
        if(role.equals("TP")) return 180000;
        return 150000;
    }
    public static int allowance(int workday, int salary){
        if(workday >= 25) return salary * 20 / 100;
        if(workday >= 22) return salary * 10 / 100;
        return 0;
    }
    @Override
    public String toString() {
        return id + " " + name + " " + salary + " " + allowance(workday,salary)+ " "  + bonus(role)+ " " + total;
    }
}
public class J04012{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int salary = Integer.parseInt(sc.nextLine());
        int workday = Integer.parseInt(sc.nextLine());
        String role = sc.nextLine();

        Employee person = new Employee(name, salary, workday, role);

        System.out.println(person);
    }
}
