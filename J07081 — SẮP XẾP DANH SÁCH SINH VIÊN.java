import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.*;
import java.io.*;
class Student{
    private String id,name,phone,mail;
    private String firstName,lastName;

    public Student(String id, String name, String phone, String mail) {
        this.id = id;
        this.name = normalize(name);
        this.phone = phone;
        this.mail = mail;

        String[] words = name.trim().split("\\s+");

        this.lastName = words[words.length - 1];

        String res = "";
        for(int i = 0; i < words.length - 1; i++){
            this.firstName += words[i] + " ";
        }
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static String normalize (String origin_name){
        String[] words = origin_name.toLowerCase().trim().split("\\s+");
        String name = "";

        for (String word : words){
            name += word.substring(0,1).toUpperCase() + word.substring(1)+ " ";
        }
        return name.trim();
    }

    @Override
    public String toString(){
        return id + " " + name + " " + phone + " " + mail;
    }
}
public class J07081 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Student> list = new ArrayList<>();

        while(n--  > 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String phone = sc.nextLine();
            String mail = sc.nextLine();

            list.add(new Student(id,name,phone,mail));
        }
        list.sort(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName).thenComparing(Student::getId));

        int number = 1;
        float prevScore = -1;
        int pos = 1;

        for (Student x : list){
            System.out.println(x);
        }
    }
}
