package test;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class J07032 {
    public static boolean isReverse(int n){
        int origin = n;
        int res = 0;
        int cnt = 0;

        while (n > 0) {
            int digit = n % 10;

            if (digit % 2 == 0) return false;

            res = res * 10 + digit;
            n/= 10;
            cnt++;
        }

        if( cnt <= 1 || cnt % 2 == 0) return false;
        return res == origin;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream osi1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream osi2 = new ObjectInputStream(new FileInputStream("DATA2.in"));

        ArrayList<Integer> list1 =  (ArrayList<Integer>) osi1.readObject();
        ArrayList<Integer> list2 = (ArrayList<Integer>) osi2.readObject();

        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();

        for(int x : list1) {
            if(isReverse(x)) {
                count1.put(x,count1.getOrDefault(x,0)+1);
            }
        }

        for(int x : list2) {
            if(isReverse(x)) {
                count2.put(x,count2.getOrDefault(x,0)+1);
            }
        }
        //common statisfied nummber
        Set<Integer> common = new HashSet<>(count1.keySet());
        common.retainAll(count2.keySet());

        ArrayList<Integer> ans = new ArrayList<>(common);

        ans.sort(Comparator.naturalOrder());

        int cnt = 0;
        for (int x : ans){
            int total = count1.get(x) + count2.get(x); // get(x): take value of x;
            System.out.println(x + " " + total);
            cnt++;
            if(cnt == 10) break;
        }
    }
}

