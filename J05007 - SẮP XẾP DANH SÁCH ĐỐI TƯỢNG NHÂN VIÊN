import java.util.*;
import static java.lang.Math.*;
import java.io.*;
import java.text.*;

class Employees {
    private String id, name, gender, birthdate,address,tax, sign;
    private static int cnt = 1;
    private Date birth;

    public Employees(String name, String gender, String birthdate, String address, String tax, String sign) throws Exception {
        this.id = String.format("%05d", cnt++);
        this.name = normalize(name);
        this.gender = gender;
        this.address = address;
        this.tax = tax;

        SimpleDateFormat in = new SimpleDateFormat("d/M/yyyy");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        this.birth = in.parse(birthdate);

        this.birthdate = out.format(in.parse(birthdate));
        this.sign = out.format(in.parse(sign));
    }

    public Date getBirth() {
        return birth;
    }

    public static String normalize(String orginName){
        String[] words = orginName.trim().toLowerCase().split("\\s+");
        String name = "";
        for(String word : words){
            name += word.substring(0,1).toUpperCase() + word.substring(1) + " ";
        }
        return name.trim();
    }
    @Override
    public String toString(){
        return id + " " + name + " " + gender  + " " + birthdate + " " + address + " " + tax + " " + sign;
    }
}

public class J05003 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        List<Employees> list = new ArrayList<>();

        int t = sc.nextInt();
        sc.nextLine();
        while(t-- >0){
            String name = sc.nextLine();
            String gender = sc.nextLine();
            String birthdate = sc.nextLine();
            String address = sc.nextLine();
            String tax = sc.nextLine();
            String sign = sc.nextLine();
            list.add(new Employees(name,gender,birthdate,address,tax,sign));
        }
        list.sort(Comparator.comparing(Employees::getBirth));
        for (Employees x : list){
            System.out.println(x);
        }
    }
}
