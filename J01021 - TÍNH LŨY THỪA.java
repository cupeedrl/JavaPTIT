import java.util.*;

public class Up {
    static Scanner sc = new Scanner(System.in);

    public static final long MOD = 1_000_000_007L;

    public static long test(long a, long b) {
        if(b == 0)
            return 1;
        if(b == 1)
            return a;
        long tmp = test(a, b / 2);
        if(b % 2 == 0)
            return (tmp * tmp) % MOD;
        return (((tmp * tmp) % MOD) * a % MOD);
    }

    public static void main(String[] args)
    {
        while (true) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a == 0 && b == 0) {
                return;
            }
            System.out.println(test(a,b));
        }
    }
}
