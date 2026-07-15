import java.util.*;
import java.io.*;
import java.text.*;
class Complex{
    private int a,b;;
    public Complex(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //(this.a + this.b*i) *     (other.a + other.b*i);

    public Complex add(Complex other){
        return new Complex(this.a+other.a, this.b + other.b);
    }

    public Complex multi(Complex other){
        return new Complex(this.a*other.a-this.b*other.b, this.a* other.b + this.b * other.a);
    }

    @Override
    public String toString() {
        if (b >= 0) return a + " + " + b + "i";
        else return a + " - " + (-b) + "i";
    }
}

public class J04018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            Complex A = new Complex(sc.nextInt(), sc.nextInt());
            Complex B = new Complex(sc.nextInt(), sc.nextInt());

            Complex res = A.add(B);
            Complex C = res.multi(A);

            Complex D = res.multi(res);
            System.out.println(C + ", " + D);
        }
    }
}
