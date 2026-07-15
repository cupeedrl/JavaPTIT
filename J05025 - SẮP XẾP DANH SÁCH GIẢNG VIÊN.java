import java.util.*;
import java.text.*;
class Teach{
    private String name, subject,id,lastname;
    private static int i = 1;
    public Teach(String name, String subject) {
        this.id = String.format("GV%02d",i++);
        this.name = name;
        this.subject = subject;
        this.lastname = take(name);
    }

    public String getLastname() {
        return lastname;
    }

    public String getId() {
        return id;
    }

    public String take(String name){
        String[] words = name.trim().split("\\s+");
        return words[words.length-1];
    }

    public static String getSubjectFormat(String subject){
        String words[] = subject.trim().toUpperCase().split("\\s+");
        String abbr = "";
        for (String word : words){
            abbr += word.charAt(0);
        }
        return abbr;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + getSubjectFormat(subject);
    }
}
public class J05025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        List<Teach> list = new ArrayList<>();

        while (t-->0){
            String name = sc.nextLine();
            String subject = sc.nextLine();
            list.add(new Teach(name,subject));
        }
        list.sort(Comparator.comparing(Teach::getLastname).thenComparing(Teach::getId));
        for(Teach x : list){
            System.out.println(x);
        }
    }
}
