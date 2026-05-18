import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class J07029 {
    public static boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if( n % i == 0) return false;
        }
        return n > 1;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ios = new ObjectInputStream(new FileInputStream("DATA.in"));

        ArrayList<Integer> list = (ArrayList<Integer>) ios.readObject();

        Map<Integer,Integer> count = new HashMap<>();

        for(int x : list){
            if(isPrime(x)){
                count.put(x, count.getOrDefault(x,0)+1);
            }
        }
        List<Integer> primes = new ArrayList<>(count.keySet());
        primes.sort(Collections.reverseOrder());

        for(int i = 0; i < 10; i++){
            int x = primes.get(i);
            System.out.println(x + " " + count.get(x));
        }
    }
}
