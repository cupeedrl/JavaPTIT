import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class J07076 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("MATRIX.in"));

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int column = sc.nextInt()-1;

            int[][] a = new int[n][m];

            List<Integer> res = new ArrayList<>();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    a[i][j] =  sc.nextInt();
                    if(j == column) {
                        res.add(a[i][j]);
                    }
                }
            }

            Collections.sort(res);

            int cnt = 0;

            for (int i = 0; i < n; i++) {
                a[i][column] = res.get(cnt++);
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                        System.out.printf("%d ",a[i][j]);
                }
                System.out.println();
            }
        }
    }
}
