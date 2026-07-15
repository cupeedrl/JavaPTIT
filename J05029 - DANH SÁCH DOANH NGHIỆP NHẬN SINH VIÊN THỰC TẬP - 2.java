import java.util.*;

class Enterprise {
    private String id, name;
    private int num;

    public Enterprise(String id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + num;
    }
}

public class J05028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        List<Enterprise> list = new ArrayList<>();

        while (t-- > 0) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int num = Integer.parseInt(sc.nextLine());

            list.add(new Enterprise(id, name, num));
        }
        list.sort(Comparator.comparing(Enterprise::getNum).reversed().thenComparing(Enterprise::getId));

        int q = Integer.parseInt(sc.nextLine());

        while (q-- > 0) {
           int a = sc.nextInt();
           int b = sc.nextInt();
           System.out.println("DANH SACH DOANH NGHIEP NHAN TU "+ a +" DEN "+ b + " SINH VIEN:");
           for (Enterprise x : list) {
               if(x.getNum()>=a && x.getNum()<=b)
                System.out.println(x);
           }
        }
    }
}
