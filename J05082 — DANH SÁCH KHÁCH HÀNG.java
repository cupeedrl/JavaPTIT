import java.util.*;
import java.io.*;
import java.text.*;
class Information{
    private String id,name,gender,birthdate,address;
    private static int i = 1;
    private long old;
    public Information(String name, String gender, String birthdate, String address) throws Exception{
        this.id = String.format("KH%03d", i++);
        this.name = nomarlize(name);
        this.gender = gender;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(birthdate);
        this.old = date.getTime();
        this.birthdate = sdf.format(date);
        this.address = address;
    }

    public String nomarlize(String orignalName){
        String[] words = orignalName.trim().toLowerCase().split("\\s+");
        String name = "";

        for (String word : words){
            name += Character.toUpperCase(word.charAt(0))+ word.substring(1) + " ";
        }
        return name.trim();
    }

    public long getOld() {
        return old;
    }

    @Override
    public String toString(){
        return id+ " " + name + " " + gender  + " " + address  + " " + birthdate;
    }
}
public class J05082 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        List<Information> list = new ArrayList<>();
        while (t-- > 0){
            String name = sc.nextLine();
            String gender = sc.nextLine();
            String birthdate  = sc.nextLine();
            String address  = sc.nextLine();
            list.add(new Information(name,gender,birthdate,address));
        }
        list.sort(Comparator.comparing(Information::getOld));
        for (Information x : list){
            System.out.println(x);
        }
    }
}
