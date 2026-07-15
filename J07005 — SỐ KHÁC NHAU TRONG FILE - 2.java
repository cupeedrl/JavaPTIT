import java.util.*;
import java.io.*;

public class Up {
    public static void main(String[] args) throws IOException{

        int[] arr = new int[1001];
        //Read Binary File
        DataInputStream dis = new DataInputStream(new FileInputStream("DATA.IN"));

        for(int i = 0; i < 100000; i++){
            int num = dis.readInt(); // Read Int from file
            arr[num]++;
        }

        dis.close();

        for(int i = 0; i < 1000;i++){
            if (arr[i] > 0)
                System.out.println(i + " " + arr[i]);
        }
    }
}
