import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Students{
    private String name,id;
    private int rank;
    private float score;
    private static int i = 1;

    public Students(String name, int oop, int c, int thcs2) {
        this.name = normalize(name);
        this.score = (oop*3 + c*3 + thcs2*2)/8f;
        this.id = String.format("SV%02d",i++);
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    public static String normalize (String origin_name){
        String[] words = origin_name.toLowerCase().trim().split("\\s+");
        String name = "";

        for (String word : words){
            name += word.substring(0,1).toUpperCase() + word.substring(1)+ " ";
        }
        return name.trim();
    }


    @Override
    public String toString(){
        return String.format("%s %s %.2f %d",id,name,score,rank);
    }
}
public class J07054 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("BANGDIEM.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Students> list = new ArrayList<>();

        while(n--  > 0){
            String name = sc.nextLine();
            int oop = Integer.parseInt(sc.nextLine());
            int c = Integer.parseInt(sc.nextLine());
            int thcs2 = Integer.parseInt(sc.nextLine());

            list.add(new Students(name,oop,c,thcs2));
        }
        list.sort(Comparator.comparing(Students::getScore).reversed());

        int number = 1;
        float prevScore = -1;
        int pos = 1;

        for (Students x : list){
            float curScore = x.getScore();
            if(curScore != prevScore){
                prevScore = curScore;
                number = pos;
            }
            x.setRank(number);
            System.out.println(x);
            pos++;
        }
    }
}
