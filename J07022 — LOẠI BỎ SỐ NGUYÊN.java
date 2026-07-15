import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J07022 {
    public static boolean check(String word){
        try {
            Integer.parseInt(word);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream("DATA.in"));
        List<String> ans = new ArrayList<String>();
        while(sc.hasNextLine())
        {
            String str = sc.nextLine();
            String[] words = str.trim().split("\\s+");

            for(String word : words){
                if(!check(word)){
                    ans.add(word);
                }
            }
        }
        Collections.sort(ans);
        for(String result : ans){
            System.out.print(result + " ");
        }
        System.out.println();
    }
}
