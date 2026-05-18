import java.io.*;
import java.util.*;

public class J07031 {
    public static boolean isPrime(int n){
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return n > 1;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));

        ArrayList<Integer> list1 = (ArrayList<Integer>) ois1.readObject();
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois2.readObject();


        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int n : list1){
            if(isPrime(n)) set1.add(n);
        }

        for(int n : list2){
            set2.add(n);
        }

        List<Integer> ans = new ArrayList<>();

        for(int n : set1){
            int m = 1000000 - n;
            if(set1.contains(m) && !set2.contains(m) && !set2.contains(n)  && (n < m) ) {
                ans.add(n);
            }
        }

        ans.sort(Comparator.naturalOrder());

        for(int n : ans){
            int m = 1000000 - n;
            System.out.println(n + " " + m);
        }
    }
}
