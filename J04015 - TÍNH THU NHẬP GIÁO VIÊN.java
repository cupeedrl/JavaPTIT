import java.awt.*;
import java.util.*;
import static java.lang.Math.*;
class Teacher {

    private String code;
    private String name;
    private long baseSalary;
    private int salary_coefficent;
    private long allowance;
    private long income;

    public Teacher(String a, String b, long c) {
        code = a;
        name = b;
        baseSalary = c;

        String position = a.substring(0, 2);
        salary_coefficent = Integer.parseInt(a.substring(2));
        switch (position){
            case "HT":
                allowance = 2000000;
                break;
            case "HP":
                allowance = 900000;
                break;
            case "GV":
                allowance = 500000;
                break;
            default:
                allowance = 0;
        }
        income = baseSalary * salary_coefficent + allowance;
    }

    @Override
    public String toString(){
        return code +" " + name + " " + salary_coefficent + " " + allowance + " " + income + " ";
    }
}

public class Up{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String code = sc.nextLine();
        String name = sc.nextLine();
        long basicSalary = sc.nextLong();

        Teacher people = new Teacher(code, name,basicSalary);
        System.out.println(people);
    }
}
