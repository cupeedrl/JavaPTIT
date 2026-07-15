import java.util.*;
import static java.lang.Math.*;
import java.io.*;
import java.text.*;

class Ranking {
    private String  name;
    private long approved, submit;

    public Ranking(String name, long approved, long submit) {
        this.name = normalize(name);
        this.approved = approved;
        this.submit = submit;
    }
    public static String normalize(String orginal_name){
        String[] words = orginal_name.trim().toLowerCase().split("\\s+");
        String name = "";
        for(String word : words){
            name += word.substring(0,1).toUpperCase() +word.substring(1) + " ";
        }
        return name.trim();
    }

    public long getApproved() {
        return approved;
    }

    public long getSubmit() {
        return submit;
    }

    @Override
    public String toString(){
        return name + " " + approved + " " + submit;
    }
}

public class J05042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Ranking> list = new ArrayList<>();

        int t = Integer.parseInt(sc.nextLine());

        while(t-- >0){
            String name = sc.nextLine();
            String infor = sc.nextLine();
            String[] res = infor.trim().split("\\s+");
            long approved = Long.parseLong(res[0]);
            long submit = Long.parseLong(res[1]);
            list.add(new Ranking(name,approved,submit));
        }
        list.sort(Comparator.comparing(Ranking::getApproved).reversed().thenComparing(Ranking::getSubmit));

        for (Ranking x : list){
            System.out.println(x);
        }
    }
}

