import java.util.*;
import java.io.*;
import java.text.*;
class Customers {
    private String customerID, customerName, gender, birthdate, address;
    private static int i = 1;
    public Customers( String customerName, String gender, String birthdate, String address) {
        this.customerID = String.format("KH%03d", i++);
        this.customerName = customerName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }
}

class Goods {
    private String goodID, goodName,unitPrice;
    private long buy, sell;
    private static int i = 1;
    public Goods(String goodName, String unitPrice, long buy, long sell) {
        this.goodID = String.format("MH%03d", i++);
        this.goodName = goodName;
        this.unitPrice = unitPrice;
        this.buy = buy;
        this.sell = sell;
    }

    public String getGoodID() {
        return goodID;
    }

    public String getGoodName() {
        return goodName;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public long getBuy() {
        return buy;
    }

    public long getSell() {
        return sell;
    }
}

class Bills implements Comparable<Bills>{
    private String billID, customerID,customerName, unitPrice, goodID,address,goodName;
    private long quantity,buy,sell;
    private static int i = 1;

    public Bills(String customerID, String goodID, long quantity) {
        this.billID = String.format("HD%03d", i++);;
        this.customerID = customerID;
        this.goodID = goodID;
        this.quantity = quantity;
    }

    public String getBillID() {
        return billID;
    }

    public String getGoodID() {
        return goodID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setBuy(long buy) {
        this.buy = buy;
    }

    public void setSell(long sell) {
        this.sell = sell;
    }

    public long getMoney(){
        return quantity * sell;
    }
    public long getProfit(){
        return (sell - buy) * quantity;
    }
    @Override
    public int compareTo(Bills o){
        if(this.getProfit() != o.getProfit()){
            return Long.compare(o.getProfit(), this.getProfit());
        }
        return this.getBillID().compareTo(o.getBillID());
    }

    @Override
    public String toString(){
        return billID + " " + customerName + " " + " " + address + " " +goodName + " " +quantity + " " + getMoney() + " " + getProfit();
    }
}
public class J06006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Customers> cusMap = new HashMap<>();

        for (int i = 0; i < n; i++){
            String customerName = sc.nextLine();
            String gender = sc.nextLine();
            String birthdate = sc.nextLine();
            String address = sc.nextLine();
            Customers people = new Customers(customerName,gender,birthdate,address);
            cusMap.put(people.getCustomerID(), people);
        }

        int m = Integer.parseInt(sc.nextLine());
        HashMap<String, Goods> gooMap = new HashMap<>();

        for (int i = 0; i < m; i++){
            String goodName = sc.nextLine();
            String unitPrice = sc.nextLine();
            long buy = Long.parseLong(sc.nextLine());
            long sell = Long.parseLong(sc.nextLine());
            Goods stuff = new Goods(goodName,unitPrice,buy,sell);
            gooMap.put(stuff.getGoodID(), stuff);
        }

        int l = Integer.parseInt(sc.nextLine());
        List<Bills> bil = new ArrayList<>();

        for (int i = 0; i < l; i++){
            String[] words = sc.nextLine().trim().split("\\s+");

            String customerID = words[0];
            String goodID = words[1];
            long quantity = Long.parseLong(words[2]);

            bil.add(new Bills (customerID,goodID,quantity));
        }

        for(Bills x : bil){
            Customers c = cusMap.get(x.getCustomerID());
            x.setCustomerName(c.getCustomerName());
            x.setAddress(c.getAddress());

            Goods g = gooMap.get(x.getGoodID());
            x.setGoodName(g.getGoodName());
            x.setUnitPrice(g.getUnitPrice());
            x.setBuy(g.getBuy());
            x.setSell(g.getSell());
        }
        Collections.sort(bil);
        for(Bills x : bil){
            System.out.println(x);
        }
    }
}
