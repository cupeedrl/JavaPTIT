import java.io.*;
import java.util.*;

public class J07021 {
    public static void normalize(String name){
        String [] words = name.trim().split("\\s+");

        for(String word : words){
            System.out.print(Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase() + " ") ;
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream("DATA.in"));
        while(sc.hasNextLine())
        {
            String name = sc.nextLine();
            if (name.equals("END")) break;
            normalize(name);
        }
    }
}
