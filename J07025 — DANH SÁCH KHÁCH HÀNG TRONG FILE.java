import java.io.*;
import java.text.*;
import java.util.*;

class Customer{
    private String id, name, gender, address;
    private Date birth;
    private static int idx = 1;
    private long old;
    public Customer(String name, String gender, String birth, String address) throws ParseException {
        this.id = String.format("KH%03d", idx++);
        this.name = normalize(name);
        this.gender = gender;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.birth = sdf.parse(birth);
        this.address = address;
        this.old = this.birth.getTime();
    }

    private String normalize(String s) {
        String[] parts = s.trim().toLowerCase().split("\\s+");
        String res = "";
        for (String x : parts) {
            res += Character.toUpperCase(x.charAt(0)) + x.substring(1) + " ";
        }
        return res.trim();
    }

    public long getOld() {
        return this.old;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return id + " " + name + " " + gender + " " + address + " " +sdf.format(birth);
    }
//
//    @Override
//    public int compareTo(Customer o) {
//        return Long.compare(this.old, o.old);
//    }
}

public class J07025 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileInputStream("KHACHHANG.in"));

        int n = Integer.parseInt(sc.nextLine());
        List<Customer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String gender = sc.nextLine();
            String birth = sc.nextLine();
            String address = sc.nextLine();

            list.add(new Customer(name, gender, birth, address));
        }
        list.sort(Comparator.comparing(Customer::getOld));
        for (Customer x : list) {
            System.out.println(x);
        }
    }
}
