import java.util.*;

public class Up {
    static Scanner sc = new Scanner(System.in);

    static void test(){
        String s = sc.nextLine().trim();
        int sum = s.charAt(0)- '0';
        for(int i = 1; i < s.length();i++)
        {
            int x = s.charAt(i) - '0';
            int y = s.charAt(i-1) - '0';
            if((Math.abs(x-y)) != 2){
                System.out.println("NO");
                return;
            }
            sum+= x;
        }
        if(sum % 10 == 0) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
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
