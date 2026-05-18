import java.util.*;

public class Up {
    static Scanner sc = new Scanner(System.in);

    public static void test() {
        int N = sc.nextInt();
        int n = (int) Math.sqrt(N);
        if (N == n * n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args)
    {
        int t = sc.nextInt();

        while(t-- > 0){
            test();
        }
    }
}
