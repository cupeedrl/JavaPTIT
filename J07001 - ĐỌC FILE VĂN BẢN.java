import java.io.*;
import java.util.*;

public class Up{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("DATA.in"));
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println(s);
        }
        sc.close();
    }
}
