import java.io.*;
import java.util.*;

public class Up{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("DATA.in"));
        long d = 0;
        while(sc.hasNext()){
            String s = sc.next();
            try{
                d+= Integer.parseInt(s); //take all except char
            }
            catch (Exception e){
            }
        }
        System.out.println(d);
        sc.close();
    }
}
