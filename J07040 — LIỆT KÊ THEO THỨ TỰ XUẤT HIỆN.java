import java.util.*;
import java.io.*;

public class J07040 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));

       List<String> ans = (ArrayList<String>) ois.readObject();

        Set<String> textbin = new HashSet<>();

        for(String s : ans){
            String[] words = s.toLowerCase().trim().split("\\s+");

            for (String word : words){
                textbin.add(word);
            }
        }

        Scanner sc = new Scanner(new FileInputStream("VANBAN.in"));

        Set<String> text = new HashSet<>();

        while(sc.hasNext()){
            String word = sc.next().toLowerCase();

            if(textbin.contains(word) && !text.contains(word)){
                System.out.println(word);

                text.add(word);
            }
        }
    }
}
