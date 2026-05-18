import java.util.*;
import static java.lang.Math.*;
class Fraction {

    long t, m;

    Fraction (long t, long m) {
        this.t = t;
        this.m = m;
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    Fraction plus(Fraction p){
        long numerator = this.t * p.m + this.m *p.t;
        long denominator = this.m * p.m;
        long res = gcd(numerator, denominator);
        return new Fraction(numerator/res, denominator/res);
    }
    @Override
    public String toString(){
        return t + "/" + m;
    }
}

public class Up{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long d = sc.nextLong();

        Fraction p = new Fraction(a, b);
        Fraction q = new Fraction(c, d);

        Fraction answer = p.plus(q);

        System.out.println(answer);
    }
}
