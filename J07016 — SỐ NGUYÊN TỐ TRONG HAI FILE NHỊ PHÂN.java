import java.util.*;
import java.io.*;
import java.text.*;
public class J07016 {
    public static boolean isPrime(int n){
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0)
                return false;
        }
        return n >= 2;
    }
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> list1 = (ArrayList<Integer>) ois1.readObject();
        ois1.close();

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois2.readObject();
        ois2.close();

        HashMap<Integer,Integer> map1 =  new HashMap<>();
        HashMap<Integer,Integer> map2 =  new HashMap<>();
        for (int x : list1){
            map1.put(x, map1.getOrDefault(x,0)+1);
        }

        for (int x : list2){
            map2.put(x, map2.getOrDefault(x,0)+1);
        }

        for(int i = 2; i < 10000; i++){
            if(isPrime(i)  && map1.containsKey(i) && map2.containsKey(i)){
                System.out.println(i + " " + map1.get(i) + " " + map2.get(i));
            }
        }
    }
}
