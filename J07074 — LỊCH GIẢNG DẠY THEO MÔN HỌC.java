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

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

}
class Schedules implements Comparable<Schedules> {
    private String groupID, subjectID, lecturer, room;
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

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static int getIdx() {
        return idx;
    }

    public static void setIdx(int idx) {
        Schedules.idx = idx;
    }

    @Override
    public String toString() {
        return groupID + " " + days + " " + time + " " + lecturer + " " + room;
    }

    @Override
    public int compareTo(Schedules o) {
        if(this.days != o.days){
            return Integer.compare(this.days,o.days);
        }
        else if(this.time != o.time){
            return Integer.compare(this.time, o.time);
        }
        return this.lecturer.compareTo(o.lecturer);
    }
}
public class J07074 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Subjects> listSub = new ArrayList<>();

        while(n-- > 0 ){
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

            listSche.add(new Schedules(subject,days,time,lecturer,room));
        }
        Collections.sort(listSche);
        String query = sc.nextLine();
        String subjectName  = "";
        for (Subjects x : listSub){
            if(x.getCode().equals(query)){
                subjectName += x.getName();
                break;
            }
        }
        System.out.println("LICH GIANG DAY MON " + subjectName  + ":");
        for (Schedules x : listSche){
            if(x.getSubjectID().equals(query))
                System.out.println(x);
        }
    }
}
