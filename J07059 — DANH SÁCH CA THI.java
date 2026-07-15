import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Schedule {
    private String id;
    private String date;
    private Date examDate;
    private String time;
    private String room;

    private static int i = 1;

    public Schedule(String date, String time, String room) throws ParseException {
        this.id = String.format("C%03d", i++);
        this.date = date;
        this.time = time;
        this.room = room;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.examDate = sdf.parse(date + " " + time);
    }

    public Date getExamDate() {
        return examDate;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + date + " " + time + " " + room;
    }
}

public class J07059 {
    public static void main(String[] args) throws FileNotFoundException,ParseException {
        Scanner sc = new Scanner(new FileInputStream("CATHI.in"));

        List<Schedule> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (n-- > 0){
            String date = sc.nextLine();
            String time = sc.nextLine();
            String room = sc.nextLine();
            list.add(new Schedule(date, time, room));
        }
        list.sort(Comparator.comparing(Schedule::getExamDate).thenComparing(Schedule::getId));
        for (Schedule x : list){
            System.out.println(x);
        }
    }
}
