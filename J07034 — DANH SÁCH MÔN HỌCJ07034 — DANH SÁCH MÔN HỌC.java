package test;
import java.io.*;
import java.util.*;

class subject {
    private String code, name;
    private int credit;

    public subject(String code, String name, int credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return code + ' ' + name + ' ' +  credit;
    }
}
public class J07034 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream("MONHOC.in"));

        int n = Integer.parseInt(sc.nextLine());

        List<subject> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String code = sc.nextLine();
            String name = sc.nextLine();
            int credit = Integer.parseInt(sc.nextLine());

            subject subj = new subject(code,name,credit);
            ans.add(subj);
        }
        ans.sort(Comparator.comparing(subject::getName));

        for(subject s : ans){
            System.out.println(s);
        }
    }
}
