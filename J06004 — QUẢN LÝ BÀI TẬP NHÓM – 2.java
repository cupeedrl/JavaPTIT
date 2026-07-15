import java.util.*;
import java.io.*;
import java.text.*;
class Subject{
    private String id,name,phone, topic;
    private long group;

    public Subject(String id, String name, String phone, long group) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public long getGroup() {
        return group;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + phone + " " + group + " " + topic;
    }
}
public class J06004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().trim().split("\\s+");

        int n = Integer.parseInt(words[0]);
        int m = Integer.parseInt(words[1]);
        List<Subject> list = new ArrayList<>();
        while(n-- > 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String phone = sc.nextLine();
            int group = Integer.parseInt(sc.nextLine());
            list.add(new Subject(id,name,phone,group));
        }

        for (int i = 1; i <= m; i++){
            String topic = sc.nextLine();
            for (Subject x : list){
                if(x.getGroup() == i){
                    x.setTopic(topic);
                }
            }
        }
        list.sort(Comparator.comparing(Subject::getId));
        for (Subject x : list){
            System.out.println(x);
        }
    }
}
