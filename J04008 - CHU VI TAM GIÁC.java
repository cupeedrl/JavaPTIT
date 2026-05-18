import java.util.*;
import static java.lang.Math.*;
class Point{

    private double x,y;

    public Point(){
        x = 0;
        y = 0;
    }
    public Point (double a, double b){
        this.x = a;
        this.y = b;
    }
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    double distance(Point p) {
        return sqrt(pow(this.x - p.x, 2) + pow(this.y - p.y, 2));
    }
}

public class Up {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){

            double a = sc.nextDouble(), b = sc.nextDouble();
            Point m = new Point(a, b);

            double c = sc.nextDouble(), d = sc.nextDouble();
            Point n = new Point(c, d);

            double e = sc.nextDouble(), f = sc.nextDouble();
            Point p = new Point(e, f);

            double mn = m.distance(n);
            double np = n.distance(p);
            double pm = p.distance(m);

            if (mn + np <= pm || mn + pm <= np || np + pm <= mn) {
                System.out.println("INVALID");
            } else {
                double perimeter = mn + np + pm;
                System.out.printf("%.3f\n", perimeter);
            }

        }
    }
}
