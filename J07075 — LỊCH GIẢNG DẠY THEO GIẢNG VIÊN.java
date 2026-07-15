import java.util.*;
import java.io.*;
import java.text.*;
import java.util.function.Function;

class Subjects{
    private String code,name;
    private int num;

    public Subjects(String code, String name, int num) {
        this.code = code;
        this.name = name;
        this.num = num;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
class Schedules implements Comparable<Schedules> {
    private String groupID, subjectID, name, lecturer, room;
    private int days, time;
    private static int idx = 1;

    public Schedules(String subjectID, int days, int time, String lecturer, String room) {
        this.groupID = String.format("HP%03d", idx++);
        this.subjectID = subjectID;
        this.days = days;
        this.time = time;
        this.lecturer = lecturer;
        this.room = room;
    }

    public String getLecturer() {
        return lecturer;
    }
    
    public String getSubjectID() {
        return subjectID;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return groupID + " " + name + " " + days + " " + time + " " + room;
    }

    @Override
    public int compareTo(Schedules o) {
        if(this.days != o.days){
            return Long.compare(this.days,o.days);
        }
        else if (this.time != o.time){
            return Long.compare(this.time,o.time);
        }
        return this.lecturer.compareTo(o.lecturer);
    }
}
public class J07074 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Subjects> listSub = new ArrayList<>();

        while(n-- > 0){
            String code = sc.nextLine();
            String name = sc.nextLine();
            int num = Integer.parseInt(sc.nextLine());

            listSub.add(new Subjects(code,name,num));
        }

        sc = new Scanner(new FileInputStream("LICHGD.in"));
        int m = Integer.parseInt(sc.nextLine());
        List<Schedules> listSche = new ArrayList<>();
        while(m-- > 0){
            String subject = sc.nextLine();
            int days = Integer.parseInt(sc.nextLine());
            int time = Integer.parseInt(sc.nextLine());
            String lecturer = sc.nextLine();
            String room = sc.nextLine();
            Schedules infor = new Schedules(subject,days,time,lecturer,room);
            listSche.add(infor);
        }
        Collections.sort(listSche);

        String query = sc.nextLine();
        System.out.println("LICH GIANG DAY GIANG VIEN " + query  + ":");

        for(Subjects x : listSub){
            for(Schedules y : listSche){
                if(x.getCode().equals(y.getSubjectID())){
                    y.setName(x.getName());
                }
            }
        }
        for (Schedules x : listSche){
            if(x.getLecturer().equals(query))
                System.out.println(x);
        }
    }
}
