import java.util.*;
import java.io.*;
public class J03004 {
    public static void normalize(String name) {
        name = name.toLowerCase().trim();

        String[] words = name.split("\\s+");

        for (String word : words) {
            System.out.printf("%c%s", Character.toUpperCase(word.charAt(0)), word.substring(1) + " ");
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
