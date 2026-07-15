import java.util.*;

class Business {
    private String id;
    private long imp,exp,unit,price,money,tax;

    public Business(String id, long imp) {
        this.id = id;
        this.imp = imp;
        this.exp =calExport(id,imp);
        this.unit= calUnit(id);
        this.money = exp*unit;
        this.tax = calTax(id,exp,unit,money);
    }

    public long calExport(String id, long imp){
        String first = id.substring(0,1);

        if(first.equals("A")) return  Math.round(imp*60.0/100);
        if(first.equals("B")) return  Math.round(imp*70.0/100);
        return  0;
    };

    public long calUnit(String id){
        String last = id.substring(id.length()-1);

        if(last.equals("Y")) return  110000;
        if(last.equals("N")) return  135000;
        return 0;
    };

    public long calTax(String id, long exp, long unit, long money){
        String first = id.substring(0,1);
        String last = id.substring(id.length()-1);

        if(first.equals("A") && last.equals("Y")) return money*8/100;
        if(first.equals("A") && last.equals("N")) return money*11/100;
        if(first.equals("B") && last.equals("Y")) return money*17/100;
        if(first.equals("B") && last.equals("N")) return money*22/100;

        return 0;
    };

    @Override
    public String toString() {
        return id + " " + imp + " " + exp + " " +unit + " " + money + " " + tax;
    }
}

public class J05048 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Business> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            Long imp = Long.parseLong(sc.nextLine());
            list.add(new Business(id,imp));
        }
        for (Business x : list) {
            System.out.println(x);
        }
    }
}
