import java.io.*;
import java.util.*;
import java.text.*;
class Check{
    private String id,name,cla,note;
    private int attendScore;

    public Check(String id, String name, String cla) {
        this.id = id;
        this.name = name;
        this.cla = cla;
    }

    public String getCla() {
        return cla;
    }

    public String getId() {
        return id;
    }

    public void setAttendScore(int attendScore) {
        this.attendScore = attendScore;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getAttendScore() {
        return attendScore;
    }

    @Override
    public String toString(){
        if("KDDK".equals(note)){
            return id + " " + name + " " + cla + " " + attendScore+ " " + note;
        }
        else{
            return id + " " + name + " " + cla + " " + attendScore;
        }
    }
}

public class J05074 {
    public static int cal(String time){
        int score = 10;
        for(int i = 0; i < time.length(); i++){
            String s = "" + time.charAt(i);
            if(s.equals("v")) score-=2;
            else if(s.equals("m")) score-=1;
        }
        return score;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        List<Check> list = new ArrayList<>();
        for(int i = 0; i < t; i++){
            String id = sc.nextLine();
            String name = sc.nextLine();
            String cla = sc.nextLine();
            list.add(new Check(id,name,cla));
        }

        for(int i = 0; i < t; i++){
            String text = sc.nextLine();
            String[] words = text.trim().split("\\s++");

            String id = words[0];
            String time = words[1];

            for(Check x : list){
                int attendScore = cal(time);
                if(id.equals(x.getId())){
                    if(attendScore <= 0){
                        x.setNote("KDDK");
                        x.setAttendScore(0);
                    }
                    else{
                        x.setAttendScore(attendScore);
                    }
                }
            }
        }

        String query = sc.nextLine();
        for(Check x : list){
            if(x.getCla().equals(query))
                System.out.println(x);
        }
    }
}
