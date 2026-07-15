import javax.security.auth.Subject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
class Electric{

    private String name,type,id;
    private int start,end,used,limit,inside,outside;
    private int pay;
    private int tax;

    public static int i = 1;
    public Electric(String name, String type, int start, int end) {
        this.id = String.format("KH%02d", i++);

        this.name = normalize(name);
        this.type = type;
        this.start = start;
        this.end = end;
        this.used = end-start;

        this.limit = getLimit(type);
        this.inside = Math.min(limit,used) * 450;
        this.outside = Math.max(0,used-limit) * 1000;
        this.tax = (int)(outside * 0.05);

        this.pay = (int) (inside + outside + tax);
    }

    public int getPay() {
        return pay;
    }

    public static String normalize(String orgin_name){
        String[] words = orgin_name.toLowerCase().trim().split("\\s++");
        String name = "";
        for (String word : words){
            name += word.substring(0,1).toUpperCase() + word.substring(1) + " ";
        }
        return name.trim();
    }
    public static int getLimit(String type){
        if(type.equals("A")) return 100;
        if(type.equals("B")) return 500;
        else return 200;
    }
    @Override
    public String toString(){
        return String.format("%s %s %d %d %d %d",id,name,inside,outside,tax,pay);
    }
}
public class J07056 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Electric> list = new ArrayList<>();

        while (n-- > 0) {
            String name = sc.nextLine();

            String[] res = (sc.nextLine()).trim().split("\\s+");

            String type = res[0];
            int start = Integer.parseInt(res[1]);
            int end = Integer.parseInt(res[2]);
            list.add(new Electric(name,type,start,end));
        }

        list.sort(Comparator.comparing(Electric::getPay).reversed());

        for (Electric x : list){
            System.out.println(x);
        }
    }
}
