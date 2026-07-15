import java.util.*;
import java.io.*;
import java.text.*;
class WordSet {
    private TreeSet<String> set;

    public WordSet(String filename) throws FileNotFoundException {
        set = new TreeSet<>();
        Scanner sc = new Scanner(new FileInputStream(filename));

        while (sc.hasNext()){
            set.add(sc.next().toLowerCase());
        }
        sc.close();
    }

    public String union(WordSet other){
        TreeSet<String> uniSet = new TreeSet<>(set);
        uniSet.addAll(other.set);

        String words = "";

        for (String x : uniSet){
            words += x + " ";
        }
        return words;
    }

    public String intersection(WordSet other){
        TreeSet<String> interSet = new TreeSet<>(set);
        interSet.retainAll(other.set);

        String words = "";

        for (String x : interSet){
            words += x + " ";
        }
        return words;
    }
}
public class J07014 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
    public static void main1440805(String[] args) throws IOException {
        WordSet s1 = new WordSet("D:\\PTIT\\Kì 6\\JavaPTIT\\src\\test\\DATA1.in");
        WordSet s2 = new WordSet("D:\\PTIT\\Kì 6\\JavaPTIT\\src\\test\\DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
