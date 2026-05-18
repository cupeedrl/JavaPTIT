import java.util.*;
import static java.lang.Math.*;
class Fraction {

    private long a,b;

    public Fraction(long a, long b) {
        this.a = a;
        this.b = b;
    }

    Fraction() {
        a = 0;
        b = 1;
    }
    private long gcd(long x, long y) {
        while(y != 0) {
            long z = x % y;
            x = y;
            y = z;
        }
        return x;
    }
    @Override
    public String toString(){
        long res = gcd(this.a, this.b);
        return a/res + "/" + b/res;
    }
}

public class Up {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        Fraction f = new Fraction(a, b);
        System.out.println(f);
    }
}
