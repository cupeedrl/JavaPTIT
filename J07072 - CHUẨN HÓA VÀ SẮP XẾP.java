import javax.security.auth.Subject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Human {
    private String name,firstName,lastName;

    public Human(String name) {
        this.name = normalize(name);

        String[] words = name.toLowerCase().split("\\s+");

        this.lastName = words[words.length - 1];

        for (int i = 0; i < words.length-1 ;i++)
            this.firstName += words[i];
    }

    public static String normalize(String orgin_name){
        String[] words = orgin_name.toLowerCase().trim().split("\\s++");
        String name = "";
        for (String word : words){
            name += word.substring(0,1).toUpperCase() + word.substring(1) + " ";
        }
        return name.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString(){
        return name;
    }
}

public class J07072 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("DANHSACH.in"));

        List<Human> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            String name = sc.nextLine().trim();
            list.add(new Human (name));
        }
        list.sort(Comparator.comparing(Human::getLastName).thenComparing(Human::getFirstName));
        for (Human x: list){
            System.out.println(x);
        }
    }
}
