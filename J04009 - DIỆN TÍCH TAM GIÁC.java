import java.util.*;

import static java.lang.Math.*;

class Point{
    private double x, y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    double distance(Point p) {
        return sqrt(pow(this.x - p.x, 2) + pow(this.y - p.y, 2));
    }

    @Override
    public String toString(){
        return x +" "+ y;
    }
}
public class J04009 {

    public static boolean isTriangle(double a, double b, double c){
        return a + b > c && a + c > b && b + c > a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){

            Point A = new Point(sc.nextDouble(), sc.nextDouble());
            Point B = new Point(sc.nextDouble(), sc.nextDouble());
            Point C = new Point(sc.nextDouble(), sc.nextDouble());

            double c = A.distance(B);
            double a = B.distance(C);
            double b = C.distance(A);
            if(a + b <= c || a + c <= b || b + c <= a){
                System.out.println("INVALID");
                continue;
            }

            double p = (a + b + c) / 2.0;

            double area = sqrt(p * (p-a) * (p-b) * (p-c));

            System.out.printf("%.2f\n", area);

        }
    }
}
