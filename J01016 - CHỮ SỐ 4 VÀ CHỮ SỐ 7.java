import java.util.*;

public class Up {
    static Scanner sc = new Scanner(System.in);

    static void test(){
       String s = sc.nextLine().trim();
        int cnt = 0;
        for(int i = 0; i< s.length();i++)
        {
            char c = s.charAt(i);
            if (c == '7' || c == '4'){
                cnt++;
            }
        }
        if (cnt == 7 || cnt == 4){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");

    }
    public static void main(String[] args)
    {
        test();
    }
}
