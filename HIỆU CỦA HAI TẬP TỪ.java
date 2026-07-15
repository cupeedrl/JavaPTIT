import java.util.*;
import java.io.*;
import java.text.*;
class WordSet{
    TreeSet<String> set;

    public WordSet(String filename) throws FileNotFoundException{
        set = new TreeSet<>();

        Scanner sc = new Scanner(new FileInputStream(filename));
        while (sc.hasNext()){
            set.add(sc.next().toLowerCase());
        }
    }
    public String difference(WordSet other){
        TreeSet<String> res = new TreeSet<>(this.set);

        String diff = "";
        for (String word : this.set){
            if(!other.set.contains(word)){
                diff += word + " ";
            }
        }
        return diff.trim();
    }
}
public class J07024 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
    public static void main1167943(String[] args) throws IOException {
        WordSet s1 = new WordSet("D:\\PTIT\\Kì 6\\JavaPTIT\\src\\test\\DATA1.in");
        WordSet s2 = new WordSet("D:\\PTIT\\Kì 6\\JavaPTIT\\src\\test\\DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}

