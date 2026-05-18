import java.util.*;
import static java.lang.Math.*;
class Rectangle {

    private int width, height;
    private String color;

    public Rectangle (){
        width = 1;
        height = 1;
    }
    public Rectangle(int  width, int  height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public String getColor(){
        return color.substring(0,1).toUpperCase()+ color.substring(1).toLowerCase();
    }
    public int getPerimeter(){
        return 2*(height + width);
    }

    public int getArea(){
        return height * width;
    }

    @Override
    public String toString(){
        return String.format("%d %d %s", getPerimeter(), getArea(), getColor());
    }
}

public class Up {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  w = sc.nextInt();
        int  h = sc.nextInt();
        String c = sc.next();
        if( h > 0 && w > 0) {
            Rectangle Rect = new Rectangle(w,h,c);
            System.out.println(Rect);
        }
        else
            System.out.println("INVALID");
    }
}
