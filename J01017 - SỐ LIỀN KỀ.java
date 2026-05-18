import java.util.*;

public class Up {
    static Scanner sc = new Scanner(System.in);

    static void test(){
        String s = sc.nextLine().trim();

        for(int i = 1; i < s.length();i++)
        {
            int x = s.charAt(i) - '0';
            int y = s.charAt(i-1) - '0';
            if((Math.abs(x-y)) != 1){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    public static void main(String[] args)
    {
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            test();
        }
    }
}
