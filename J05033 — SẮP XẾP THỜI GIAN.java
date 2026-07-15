import java.util.*;

class Time {
    private int h, m, s;

    public Time(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public int getTotal() {
        return h * 3600 + m * 60 + s;
    }

    @Override
    public String toString() {
        return h + " " + m + " " + s;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            list.add(new Time(h, m, s));
        }

        list.sort(Comparator.comparing(Time::getTotal));

        for (Time x : list) {
            System.out.println(x);
        }
    }
}
