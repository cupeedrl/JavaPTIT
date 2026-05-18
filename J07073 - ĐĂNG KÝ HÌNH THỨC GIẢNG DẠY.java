import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Teaching {
    private String id,name;
    private int numbers;
    private String theory, practice;

    private static int i = 1;

    public Teaching(String id, String name, int numbers, String theory, String practice) {
        this.id = id;
        this.name = name;
        this.numbers = numbers;
        this.theory = theory;
        this.practice = practice;
    }

    public String getId() {
        return id;
    }

    public String getPractice() {
        return practice;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + numbers +" " + theory + " " + practice;
    }
}

public class J07073 {
    public static void main(String[] args) throws FileNotFoundException,ParseException {
        Scanner sc = new Scanner(new FileInputStream("MONHOC.in"));

        List<Teaching> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            int numbers = Integer.parseInt(sc.nextLine());
            String theory = sc.nextLine();
            String pratice = sc.nextLine();
            list.add(new Teaching(id,name,numbers, theory, pratice));
        }
        list.sort(Comparator.comparing(Teaching::getId));
        for (Teaching x : list){
            if(x.getPractice().equals("Truc tuyen") || x.getPractice().endsWith(".ptit.edu.vn"))
                System.out.println(x);
        }
    }
}
