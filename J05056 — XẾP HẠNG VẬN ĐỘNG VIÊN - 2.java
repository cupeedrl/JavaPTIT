import java.util.*;
import java.text.*;

class Athlete {
    private String id, name, birthdate, start, finish;
    private int duration,priority,real,rank;
    private static int cnt = 1;

    public Athlete( String name, String birthdate, String start, String finish){
        this.id = String.format("VDV%02d",cnt++);
        this.name = name;
        this.birthdate = birthdate;
        this.start = start;
        this.finish = finish;
        this.priority = calPriority(birthdate);
        this.real = calTime(finish) - calTime(start);
        this.duration = calTime(finish) - calTime(start)- priority;
    }

    public int calPriority(String birthdate){
        int age = 2021 - Integer.parseInt(birthdate.substring(6));
        if (age >= 18 && age < 25) return 1;
        if (age >= 25 && age < 32) return 2;
        if (age >=32 ) return 3;
        else return 0;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDuration() {
        return duration;
    }

    public int calTime(String time){
        String[] res = time.split(":");
        int hours = Integer.parseInt(res[0]);
        int minutes = Integer.parseInt(res[1]);
        int seconds = Integer.parseInt(res[2]);
        return hours * 3600 + minutes * 60 + seconds;
    };

    public String formatTime(int duration){
        int hours = duration / 3600;
        duration%=3600;
        int minutes = duration / 60;
        int seconds = duration % 60;
        return String.format("%02d:%02d:%02d",hours,minutes,seconds);
    };

    @Override
    public String toString(){
        return id + " " + name + " " + formatTime(real) + " " +  formatTime(priority) + " " + formatTime(duration) + " " + rank;
    }
}

public class J05055 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Athlete> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String birthdate = sc.nextLine();
            String start = sc.nextLine();
            String finish = sc.nextLine();

            list.add(new Athlete(name,birthdate,start,finish));
        }

        List<Athlete> res = new ArrayList<>(list);

        res.sort(Comparator.comparing(Athlete::getDuration));

        int i = 0;
        int pos = 1;
        int pre = -1;

        for (Athlete x : res){
            int cur = x.getDuration();
            if( cur != pre){
                pre = cur;
                i = pos;
            }
            x.setRank(i);
            pos++;
        }

        list.sort(Comparator.comparing(Athlete::getRank));

        for (Athlete x : list){
            System.out.println(x);
        }
    }
}
