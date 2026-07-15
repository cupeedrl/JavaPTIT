import java.io.*;
import java.util.*;

class Subject {

    private String id, name, form;

    public Subject(String id, String name, String form) {
        this.id = id;
        this.name = name;
        this.form = form;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + form;
    }
}

public class J07058 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new File("MONHOC.in"));

        int n = Integer.parseInt(sc.nextLine());

        List<Subject> list = new ArrayList<>();

        while(n-- > 0){

            String id = sc.nextLine();
            String name = sc.nextLine();
            String form = sc.nextLine();

            list.add(new Subject(id, name, form));
        }

        list.sort(Comparator.comparing(Subject::getId));

        for(Subject x : list){
            System.out.println(x);
        }
    }
}
