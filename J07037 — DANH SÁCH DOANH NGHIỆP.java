package test;

import java.io.*;
import java.util.*;

class Company{
    private String code, name;
    private int number;

    public Company(String code, String name, int number) {
        this.code = code;
        this.name = name;
        this.number = number;
    }

    public String getCode() {
        return code;
    }


    @Override
    public String toString() {
        return code + " " + name + " " +  number;
    }
}
public class J07037 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("DN.in"));
        int n = Integer.parseInt(sc.nextLine());

        List<Company> intern  = new ArrayList<>();

        for (int i = 0; i < n; i++){
            String code = sc.nextLine();
            String name = sc.nextLine();
            int number = Integer.parseInt(sc.nextLine());
            intern.add(new Company(code,name,number));
        }

        intern.sort(Comparator.comparing(Company::getCode));

        for (Company c : intern ){
            System.out.println(c);
        }

    }

}
