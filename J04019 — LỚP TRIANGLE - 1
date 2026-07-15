import java.util.*;
import static java.lang.Math.*;
import java.io.*;
import java.text.*;

class Point{
    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point nextPoint(Scanner sc) {
        return new Point(sc.nextDouble(),sc.nextDouble());
    }

    public double distance(Point p) {
        return sqrt(pow(this.x - p.x, 2) + pow(this.y - p.y, 2));
    }
}

class Triangle{
    private Point A, B, C;

    public Triangle(Point A, Point B, Point C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public boolean valid(){
        double a = B.distance(C);
        double b = A.distance(C);
        double c = A.distance(B);

        return a+b> c && a+c >b && b+c > a;
    }

    public String getPerimeter(){
        double a = B.distance(C);
        double b = A.distance(C);
        double c = A.distance(B);

        double result = a + b + c;

        return String.format("%.3f", result);
    }
}

public class J04019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
    public static void main7454533(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}

