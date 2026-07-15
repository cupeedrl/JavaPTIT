import java.util.*;

class Petrol {
    private String code,type,company;
    private long quantity, unit,tax,amount;

    public Petrol(String code, long quantity) {
        this.code = code;
        this.quantity = quantity;
        this.type = code.substring(0,1);
        this.company = calCompany(code.substring(3));
        this.unit = calUnit(type);
        if(company.equals("Trong Nuoc")){
            this.tax = 0;
        }
        else{
            this.tax = quantity * unit * calTax(type)/1000;
        }
        this.amount = (quantity*unit) + tax;
    }

    public long getAmount() {
        return amount;
    }

    public long calUnit(String type) {
        if(type.equals("X")) return 128000;
        if(type.equals("D")) return 11200;
        if(type.equals("N")) return 9700;
        return 0;
    }
    public String calCompany(String company){
        if(company.equals("BP")) return "British Petro";
        if(company.equals("ES")) return "Esso";
        if(company.equals("SH")) return "Shell";
        if(company.equals("CA")) return "Castrol";
        if(company.equals("MO")) return "Mobil";
        return "Trong Nuoc";
    }

    public long calTax(String type){
        if(type.equals("X")) return 30;
        if(type.equals("D")) return 35;
        if(type.equals("N")) return 20;
        return 0;
    }

    @Override
    public String toString(){
        return code + " " + company + " " + unit + " " + tax + " " + amount;
    }
}

public class J05067 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        List<Petrol> list = new ArrayList<>();

        while (t-- > 0){
            String keyword = sc.nextLine();
            String[] words = keyword.trim().split("\\s+");
            String code = words[0];
            long quantity = Integer.parseInt(words[1]);
            list.add(new Petrol(code,quantity));
        }
        list.sort(Comparator.comparing(Petrol::getAmount).reversed());
        for (Petrol x : list){
            System.out.println(x);
        }
    }
}
