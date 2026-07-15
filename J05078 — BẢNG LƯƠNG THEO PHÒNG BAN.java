import java.util.*;
import java.io.*;
import java.text.*;
class Department{
    private String abbr, dep;

    public Department(String abbr, String dep) {
        this.abbr = abbr;
        this.dep = dep;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getDep() {
        return dep;
    }
}

class Infor{
    private String id, name, dep;
    private long total;

    public Infor(String id, String name, String dep, long total) {
        this.id = id;
        this.name = name;
        this.dep = dep;
        this.total = total;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + total;
    }

    public String getDep() {
        return dep;
    }
}
public class J05077 {

    public static long cal (String id){
        String group = "" + id.trim().substring(0,1);
        long years = Long.parseLong("" + id.trim().substring(1,3));

        switch (group){
            case "A":
                if(years<=3) return 10;
                else if(years<=8 && years >=4) return 12;
                else if(years<=15 && years >=9) return 14;
                else return 20;
            case "B":
                if(years<=3) return 10;
                else if(years<=8 && years >=4) return 11;
                else if(years<=15 && years >=9) return 13;
                else return 16;
            case "C":
                if(years<=3) return  9;
                else if(years<=8 && years >=4) return 10;
                else if(years<=15 && years >=9) return 12;
                else return 14;
            case "D":
                if(years<=3) return 8;
                else if(years<=8 && years >=4) return 9;
                else if(years<=15 && years >=9) return 11;
                else return 13;
            default:
                return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        List<Department> list = new ArrayList<>();
        while (t-- > 0){
            String line = sc.nextLine().trim();
            String abbr = line.trim().substring(0,2);
            String dep = line.trim().substring(3);
            list.add(new Department(abbr,dep));
        }

        int t2 = Integer.parseInt(sc.nextLine());
        List<Infor> res = new ArrayList<>();
        while (t2-- > 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            long baseSalary = Long.parseLong(sc.nextLine());
            long days = Long.parseLong(sc.nextLine());

            String abbr = id.trim().substring(3);
            long coefficent = cal(id);
            long total = baseSalary * days * coefficent * 1000;

            for(Department x : list){
                if(abbr.equals(x.getAbbr()))
                res.add(new Infor(id,name, x.getDep(), total));
            }
        }

        String query = sc.nextLine();

        String tmp = "";
        for (Department x : list){
            if(x.getAbbr().equals(query))
                tmp += x.getDep();
        }
        System.out.println("Bang luong phong " + tmp + ":");
        for (Infor x : res){
            if(x.getDep().equals(tmp))
                System.out.println(x);
        }
    }
}
