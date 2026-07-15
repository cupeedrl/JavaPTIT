import java.util.*;
import java.io.*;
import java.text.*;
class Subject {
    private String id, name, group, lecturer;

    public Subject(String id, String name, String group, String lecturer) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.lecturer = lecturer;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return group + " " + lecturer;
    }

    public String getGroup() {
        return group;
    }
}
public class J05079 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        List<Subject> list = new ArrayList<>();
        while (t-- > 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String group = sc.nextLine();
            String lecturer  = sc.nextLine();
            list.add(new Subject(id,name,group,lecturer));
        }
        list.sort(Comparator.comparing(Subject::getGroup));
        int t1 = Integer.parseInt(sc.nextLine());
        while (t1-- > 0){
            String query = sc.nextLine();

            for (Subject x : list){
                if(x.getId().equals(query) ){
                    System.out.println("Danh sach nhom lop mon " + x.getName() +":");
                    break;
                }
            }
            for (Subject x : list){
                if(x.getId().equals(query) ){
                    System.out.println(x);
                }
            }
        }
    }
}
