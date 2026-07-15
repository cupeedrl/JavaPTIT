import java.util.*;

class Lecturer {
    private String id, name;

    public Lecturer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class J06007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

 
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            sc.nextLine();
        }
        
        int m = Integer.parseInt(sc.nextLine());
        List<Lecturer> lecturers = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            int pos = line.indexOf(' ');
            String id = line.substring(0, pos);
            String name = line.substring(pos + 1);

            lecturers.add(new Lecturer(id, name));
        }
        
        int k = Integer.parseInt(sc.nextLine());
        HashMap<String, Double> totalTime = new HashMap<>();

        for (int i = 0; i < k; i++) {
            String[] s = sc.nextLine().split("\\s+");

            String lecturerID = s[0];
            double time = Double.parseDouble(s[2]);

            totalTime.put(
                    lecturerID,
                    totalTime.getOrDefault(lecturerID, 0.0) + time
            );
        }
        
        for (Lecturer x : lecturers) {
            System.out.printf("%s %.2f\n",
                    x.getName(),
                    totalTime.getOrDefault(x.getId(), 0.0));
        }
    }
}
