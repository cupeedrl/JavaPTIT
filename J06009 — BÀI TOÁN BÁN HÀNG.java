import java.util.*;
import java.io.*;

class Customer{
    private String CustomerId,CustomerName,gender, birthdate, address;
    private static int i = 1;
    public Customer(String CustomerName, String gender, String birthdate, String address) {
        this.CustomerId = String.format("KH%03d", i++);
        this.CustomerName = CustomerName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.address = address;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getAddress() {
        return address;
    }
}
class Goods{
    private String GoodsId,GoodsName,unitprice;
    private long buy, sell;
    private static int i = 1;

    public Goods(String GoodsName,String unitprice, long buy, long sell) {
        this.GoodsId = String.format("MH%03d", i++);
        this.GoodsName = GoodsName;
        this.unitprice = unitprice;
        this.buy = buy;
        this.sell = sell;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public long getBuy() {
        return buy;
    }

    public long getSell() {
        return sell;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public String getGoodsId() {
        return GoodsId;
    }
}

class Bill{
    private String BillId,CustomerId, GoodsId;
    private long total;
    private String CustomerName, address;

    private String GoodsName,unitprice;
    private long buy, sell;

    private long quantity;
    private static int i = 1;

    public Bill(String CustomerId, String GoodsId, long quantity) {
        this.BillId = String.format("HD%03d", i++);
        this.CustomerId = CustomerId;
        this.GoodsId = GoodsId;
        this.quantity = quantity;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public String getGoodsId() {
        return GoodsId;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public void setBuy(long buy) {
        this.buy = buy;
    }

    public void setSell(long sell) {
        this.sell = sell;
    }

    @Override
    public String toString(){
        return BillId + " " + CustomerName + " " +address + " " +GoodsName + " " + unitprice + " " +buy + " " +sell + " " + quantity + " " + quantity*sell;
    }
}
public class J06009 {
    public static void main(String[] args) throws FileNotFoundException, IOException{

        Scanner sc = new Scanner(new FileInputStream("KH.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Customer> cList = new ArrayList<>();

        while(n-- > 0){
            String name = sc.nextLine();
            String gender = sc.nextLine();
            String birthdate = sc.nextLine();
            String address = sc.nextLine();
            cList.add(new Customer(name,gender,birthdate,address));
        }

        sc = new Scanner(new FileInputStream("MH.in"));
        int m = Integer.parseInt(sc.nextLine());
        List<Goods> gList = new ArrayList<>();

        while(m-- > 0){
            String name = sc.nextLine();
            String unitprice = sc.nextLine();
            long buy = Long.parseLong(sc.nextLine());
            long sell = Long.parseLong(sc.nextLine());
            gList.add(new Goods(name, unitprice,buy,sell));
        }

        sc = new Scanner(new FileInputStream("HD.in"));
        int t = Integer.parseInt(sc.nextLine());
        List<Bill> bList = new ArrayList<>();

        while(t-- > 0){
            String line = sc.nextLine();
            String [] words = line.trim().split("\\s+");

            String CustomerId = words[0];
            String GoodId = words[1];
            long quantity = Long.parseLong(words[2]);

            bList.add(new Bill(CustomerId, GoodId, quantity));
        }

        for (Bill x : bList){
            for (Customer y : cList){
                if(x.getCustomerId().equals(y.getCustomerId())){
                    x.setAddress(y.getAddress());
                    x.setCustomerName(y.getCustomerName());
                }
            }
        }

        for (Bill x : bList){
            for (Goods y : gList){
                if(x.getGoodsId().equals(y.getGoodsId())){
                    x.setGoodsName(y.getGoodsName());
                    x.setUnitprice(y.getUnitprice());
                    x.setBuy(y.getBuy());
                    x.setSell(y.getSell());
                }
            }
        }

        for (Bill x : bList){
            System.out.println(x);
        }
    }
}
