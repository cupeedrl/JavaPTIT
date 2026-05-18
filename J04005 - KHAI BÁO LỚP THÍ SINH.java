import java.util.*;
import static java.lang.Math.*;
class Candidate {

    private String full_name, birth_date;
    private float mark1, mark2, mark3;

    public Candidate(String full_name, String birth_date, float mark1, float mark2, float mark3) {
        this.full_name = full_name;
        this.birth_date = birth_date;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3= mark3;
    }

    public double sum(){
        return (mark1 + mark2 + mark3);
    }

    @Override
    public String toString(){
        return full_name + " " + birth_date + " " + String.format("%.1f", sum());
    }
}

public class Up{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String full_name = sc.nextLine();
        String birth_date = sc.nextLine();
        float mark1 = sc.nextFloat();
        float mark2 = sc.nextFloat();
        float mark3 = sc.nextFloat();

        Candidate people = new Candidate(full_name,birth_date,mark1,mark2,mark3);
        System.out.println(people);
    }
}
