import java.util.*;
import java.io.*;
import java.text.*;
class Students{
    private String name,code,cla,birthdate;
    private double gpa;
    private static int i = 1;
    public Students(String name, String cla, String birthdate, double gpa) throws ParseException{
        this.code = String.format("B20DCCN%03d", i++);
        this.name = normalize(name);
        this.cla = cla;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(birthdate);
        this.birthdate = sdf.format(date);
        this.gpa = gpa;
    }
    public String normalize(String original_name){
        String[] words = original_name.toLowerCase().trim().split("\\s+");
        String name ="";

        for (String word : words){
            name += word.substring(0,1).toUpperCase() + word.substring(1) + " ";
        }
        return name.trim();
    }
    @Override
    public String toString() {
        return code + " " + name + " " + cla + " " + birthdate + " " + String.format("%.2f",gpa);
    }
}
public class J07018 {
    public static void main(String[] args) throws  FileNotFoundException, ParseException{
        Scanner sc = new Scanner( new FileInputStream("SINHVIEN.in"));

        int n = Integer.parseInt(sc.nextLine());
        List<Students> list = new ArrayList<>();
        while (n-- > 0){
            String name = sc.nextLine();
            String cla = sc.nextLine();
            String birthdate = sc.nextLine();
            double gpa = Double.parseDouble(sc.nextLine());

            Students people = new Students(name,cla,birthdate,gpa);
            list.add(people);
        }

        for (Students x : list){
            System.out.println(x);
        }
    }
}
