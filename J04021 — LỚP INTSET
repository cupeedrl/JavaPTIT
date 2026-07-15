import java.util.*;
import static java.lang.Math.*;

class IntSet{
    private TreeSet<Integer> set;

    public IntSet(int[] a) {
        set = new TreeSet<>();

        for(int x : a){
            set.add(x);
        }
    }

    public IntSet union(IntSet other){
        TreeSet<Integer> res = new TreeSet<>();

        res.addAll(this.set);
        res.addAll(other.set);

        IntSet ans = new IntSet( new int[]{});

        ans.set = res;
        return ans;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int x :set){
            sb.append(x).append(" ");
        }
        return sb.toString().trim();
    }
}
public class J04020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
    public static void main5034235(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
} 

