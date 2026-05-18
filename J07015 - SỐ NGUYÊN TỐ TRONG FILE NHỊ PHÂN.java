import java.util.*;
import java.io.*;
import java.lang.Math;


public class Main {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true; // nếu không tìm thấy ước nào
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream ios = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));

        ArrayList<Integer> list = (ArrayList<Integer>) ios.readObject();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int x : list) {
            if (isPrime(x)) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
