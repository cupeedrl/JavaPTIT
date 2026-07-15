import java.util.*;
import java.io.*;

public class Up {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("DATA.in"));

        HashMap<Integer, Integer> map = new HashMap<>();

        while (sc.hasNext()) {
            String s = sc.next();

            try {
                int num = Integer.parseInt(s);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } catch (Exception e) {
                // bỏ qua token không phải số
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int x : list) {
            System.out.println(x + " " + map.get(x));
        }
    }
}
