import java.util.*;
import java.io.*;
import java.text.*;

class Assignment{
    private String id, name, phone,topic;
    private int group;

    public Assignment(String id, String name, String phone, int group) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.group = group;
        this.topic = topic;
    }

    public long getGroup() {
        return group;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString(){
         return id + " " + name + " " + phone;
    }
}

public class J06003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] words = line.trim().split("\\s+");

        int n = Integer.parseInt(words[0]);
        List<Assignment> list = new ArrayList<>();

        int m = Integer.parseInt(words[1]);

        while (n-- > 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String phone = sc.nextLine();
            int group = Integer.parseInt(sc.nextLine());
            list.add(new Assignment(id,name,phone,group));
        }

        for(int i = 1; i <= m ;i++){
            String topic = sc.nextLine();
            for(Assignment x : list){
                if(x.getGroup() == i){
                    x.setTopic(topic);
                }
            }
        }

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0){
            int q = Integer.parseInt(sc.nextLine());
            System.out.printf("DANH SACH NHOM %d:\n", q);
            for(Assignment x : list){
                if (x.getGroup() == q){
                    System.out.println(x);
                }
            }
            String topic = "";

            for(Assignment x : list){
                if(x.getGroup() == q){
                    topic = x.getTopic();
                    break;
                }
            }

            System.out.println("Bai tap dang ky: " + topic);
        }
    }
}
