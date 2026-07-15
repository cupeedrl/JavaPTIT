import java.util.*;
import java.text.*;
class Teaching{
    private String name, subject,id,lastname;
    private static int i = 1;
    public Teaching(String name, String subject) {
        this.id = String.format("GV%02d",i++);
        this.name = name;
        this.subject = subject;
        this.lastname = take(name);

    }

    public String getName() {
        return name;
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
public class J05026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        List<Teaching> list = new ArrayList<>();

        while (t-->0){
            String name = sc.nextLine();
            String subject = sc.nextLine();
            list.add(new Teaching(name,subject));
        }

        int q = Integer.parseInt(sc.nextLine());
        while (q-->0){
            String keyword = sc.nextLine();

            System.out.println("DANH SACH GIANG VIEN THEO TU KHOA "+ keyword +":");

            for(Teaching x : list){
                if(x.getName().toLowerCase().contains(keyword.toLowerCase())){
                    System.out.println(x);
                }
            }
        }
    }
}
