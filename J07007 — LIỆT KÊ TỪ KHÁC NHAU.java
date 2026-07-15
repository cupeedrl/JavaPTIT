import java.util.*;
import java.io.*;

public class Up {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File ("VANBAN.in"));
        TreeSet<String> set = new TreeSet<>();
        while(sc.hasNext()){
            String word = sc.next().toLowerCase();
            set.add(word);
        }
        sc.close();
        for(String word : set){
            System.out.println(word);
        }
    }
}

