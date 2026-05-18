import java.util.*;
import java.io.*;
import java.text.*;

public class J07085 {

    public static int digit(String num){
        int sum = 0;
        for(int i = 0; i < num.length(); i++){
            sum += num.charAt(i) - '0';
        }
        return sum;
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<String> list = (ArrayList<String>) ois.readObject();
        for (String x : list){

            String num = "";

            for(int i = 0; i < x.length(); i++){
                char c = x.charAt(i);
                if( Character.isDigit(c)){
                    num+=c;
                }
            }

            num = num.replaceFirst("^0+","");

            if(num.isEmpty())
                num = "0";
            System.out.printf("%s %s\n", num, digit(num));
        }
    }
}
