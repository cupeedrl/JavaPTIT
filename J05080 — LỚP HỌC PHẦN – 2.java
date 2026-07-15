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

    public String getLecturer() {
        return lecturer;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + group;
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
        list.sort(Comparator.comparing(Subject::getId).thenComparing(Comparator.comparing(Subject::getGroup)));
        int t1 = Integer.parseInt(sc.nextLine());
        while (t1-- > 0){
            String queryLecturer = sc.nextLine();
            System.out.printf("Danh sach cho giang vien %s:\n",queryLecturer);
            for (Subject x : list){
                if(x.getLecturer().equals(queryLecturer) ){
                    System.out.println(x);
                }
            }
        }
    }
}

