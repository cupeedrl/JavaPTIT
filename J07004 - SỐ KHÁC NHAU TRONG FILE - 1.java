import java.util.*;
import java.io.*;

public class Up {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("DATA.in"));
        int arr[] = new int[100000];
        while(sc.hasNext()){
            String s = sc.next();
            try {
                int num = Integer.parseInt(s);
                arr[num]++;
            }
            catch (Exception e){
            }
        }
        for(int i = 0; i < arr.length;i++){
            if (arr[i] > 0)
                System.out.printf("%d %d\n",i, arr[i]);
        }
    }
}
