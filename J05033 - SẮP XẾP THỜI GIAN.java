import java.util.*;
import java.io.*;
class Time implements Comparable<Time>{
    private Byte hour;
    private Byte minute;
    private Byte second;

    public Time(Byte hour, Byte minute, Byte second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public String toString(){
        return String.format("%d %d %d", this.hour, this.minute, this.second);
    }

    @Override
    public int compareTo(Time o){
        if(this.hour != o.hour)
            return this.hour.compareTo(o.hour);
        if(this.minute != o.minute)
            return this.minute.compareTo(o.minute);
        return this.second.compareTo(o.second);
    }
}
public class J05033 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        List<Time> res = new ArrayList<>();
        while (t-- > 0) {
             res.add(new Time(sc.nextByte(), sc.nextByte(), sc.nextByte()));
        }
        Collections.sort(res);
        for (Time x : res)
            System.out.println(x);
        sc.close();
    }
}
