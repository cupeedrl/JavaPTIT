
import java.util.*;
import java.io.*;
class LoaiPhong implements Comparable<LoaiPhong> {
    private String sign, name;
    private int price;
    private float service;


    public LoaiPhong(String Room) {
        String[] words = Room.trim().split("\\s+");

        sign = words[0];
        name = words[1];
        price = Integer.parseInt(words[2]);
        service = Float.parseFloat(words[3]);
    }

    @Override
    public int compareTo(LoaiPhong other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return sign +" "+name +" "+price +" "+service;
    }
}
public class J07045 {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
    public static void main5915451(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}


