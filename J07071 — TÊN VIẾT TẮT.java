import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;


public class J07071 {
    public static boolean check(String name, String pattern){
        String[] words = name.trim().split("\\s+");

        String abrr = "";

        for (int i = 0; i < words.length;i++){
            abrr += Character.toUpperCase(words[i].charAt(0));

            if(i != words.length-1){
                abrr+=".";
            }
        }

        String[] a = abrr.split("\\.");
        String[] b = pattern.split("\\.");

        if(a.length != b.length) return  false;

        for(int i = 0; i < a.length; i++){
            if(b[i].equals("*")) continue;

            if(!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("DANHSACH.in"));

        int n = Integer.parseInt(sc.nextLine());

        List<String> list = new ArrayList<>();

        while (n-- > 0){
            String name = sc.nextLine().trim();
            list.add(name);
        }

        list.sort((a,b) -> {
            String[] x = a.split("\\s+");
            String[] y = b.split("\\s+");

            String lastX = x[x.length-1];
            String lastY = y[y.length-1];

            if(!lastX.equals(lastY))
                return lastX.compareTo(lastY);

            return a.compareTo(b);
        });

        int m = Integer.parseInt(sc.nextLine());

        while (m-- > 0){
            String pattern = sc.nextLine().trim();
            for(String name : list){
                if(check(name,pattern)){
                    System.out.println(name);
                }
            }
        }
    }
}
