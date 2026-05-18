import java.util.*;
import static java.lang.Math.*;
class Employee {

    private String full_name = "B20DCCN001";
    private String sex;
    private String birth_date;
    private String address;
    private String tax_ID;
    private String date_sign_contract;

    public Employee(String full_name, String sex, String birth_date, String address, String tax_ID, String date_sign_contract) {
        this.full_name = full_name;
        this.sex = sex;
        this.birth_date = birth_date;
        this.address = address;
        this.tax_ID = tax_ID;
        this.date_sign_contract = date_sign_contract;
    }

    @Override
    public String toString(){
        return "00001 "
                + full_name + " "
                + sex + " "
                + birth_date + " "
                + address + " "
                + tax_ID + " "
                + date_sign_contract;
    }
}

public class Up{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String full_name = sc.nextLine();
        String sex = sc.nextLine();
        String birth_date = sc.nextLine();
        String address = sc.nextLine();
        String tax_ID = sc.nextLine();
        String date_sign_contract = sc.nextLine();

        Employee people = new Employee(full_name,sex, birth_date, address, tax_ID, date_sign_contract);

        System.out.println(people);
    }
}
