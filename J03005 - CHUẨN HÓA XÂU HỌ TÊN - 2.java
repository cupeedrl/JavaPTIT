import java.util.*;
import java.io.*;
public class J03005 {
    public static void normalize(String name) {
        name = name.toLowerCase().trim();

        String[] word = name.split("\\s+");

        word[0] = word[0].toUpperCase();

        if(word.length == 1){
            System.out.print(word[0]);
        }
        else {
            for(int i = 1; i < word.length; i++){
                System.out.print(Character.toUpperCase(word[i].charAt(0)) + word[i].substring(1).toLowerCase());
                if(i != word.length - 1) System.out.print(" ");
            }
            System.out.print(", " + word[0]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String name = sc.nextLine();
            normalize(name);
        }
    }
}
