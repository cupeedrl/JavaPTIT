import java.util.*;

public class Up {
    static Scanner sc = new Scanner(System.in);

    static void test(){

        int [] x = new int [4];
        int [] y = new int [4];

        for(int i = 0; i < 4; i++){
            x[i]= sc.nextInt();
            y[i] = sc.nextInt();
        }

        Arrays.sort(x);
        Arrays.sort(y);

        int side = Math.max((x[3]-x[0]), (y[3]-y[0]));
        System.out.println(side * side );
    }

    public static void main(String[] args)
    {
        test();
    }
}
