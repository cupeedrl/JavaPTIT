import java.util.*;
import java.io.*;
import java.text.*;

class Student{
    private String studentId, studentName, studentClass, studentEmail;

    public Student(String studentId, String studentName, String studentClass, String studentEmail) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentEmail = studentEmail;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getStudentName() {
        return studentName;
    }
}

class Enterprise {
    private String enterpriseId, enterpriseName;
    private long numStudent;

    public Enterprise(String enterpriseId, String enterpriseName, long numStudent) {
        this.enterpriseId = enterpriseId;
        this.enterpriseName = enterpriseName;
        this.numStudent = numStudent;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public long getNumStudent() {
        return numStudent;
    }
}

class Intern{
    private String studentId, studentName, studentClass, enterpriseName, enterpriseId;

    public Intern(String studentId, String enterpriseId) {
        this.studentId = studentId;
        this.enterpriseId = enterpriseId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    @Override
    public String toString(){
        return studentId + " " + studentName + " " + studentClass ;
    }
}

public class J07038 {
    public static String nomarlize(String orignalName){
        String[] words = orignalName.trim().toLowerCase().split("\\s+");
        String name = "";

        for (String word : words){
            name += Character.toUpperCase(word.charAt(0))+ word.substring(1) + " ";
        }
        return name.trim();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner sc = new Scanner(new FileInputStream("SINHVIEN.in"));

        int t = Integer.parseInt(sc.nextLine());

        List<Student> listS = new ArrayList<>();
        while (sc.hasNextLine() && t-- > 0){
            String studentId = sc.nextLine();
            String studentName = nomarlize(sc.nextLine());
            String studentClass = sc.nextLine();
            String studentEmail  = sc.nextLine();
            listS.add(new Student(studentId,studentName,studentClass,studentEmail));
        }

        sc = new Scanner(new FileInputStream("DN.in"));
        int t2 = Integer.parseInt(sc.nextLine());

        List<Enterprise> listE = new ArrayList<>();
        while (sc.hasNextLine() && t2-- > 0){
            String enterpriseId = sc.nextLine();
            String enterpriseName = sc.nextLine();
            long numStudent = Long.parseLong(sc.nextLine());
            listE.add(new Enterprise(enterpriseId,enterpriseName,numStudent));
        }

        sc = new Scanner(new FileInputStream("THUCTAP.in"));
        int t3 = Integer.parseInt(sc.nextLine());

        List<Intern> listI = new ArrayList<>();
        while (sc.hasNextLine() && t3-- > 0){
            String line = sc.nextLine();
            String[] words = line.trim().split("\\s+");

            String studentId = words[0];
            String enterpriseId = words[1];
            listI.add(new Intern(studentId,enterpriseId));
        }
        //mã, tên, lớp
        for (Intern x : listI){
            for (Student y : listS){
                if(x.getStudentId().equals(y.getStudentId())){
                    x.setStudentClass(y.getStudentClass());
                    x.setStudentName(y.getStudentName());
                }
            }
        }

        int test = Integer.parseInt(sc.nextLine());
        while (sc.hasNextLine() && test-- >0 ){
            String query = sc.nextLine();
            long limit = 0;

            for (Enterprise x : listE) {
                if (x.getEnterpriseId().equals(query)) {
                    System.out.printf("DANH SACH THUC TAP TAI %s:\n", x.getEnterpriseName());
                    limit = x.getNumStudent();
                    break;
                }
            }

            List<Intern> ans = new ArrayList<>();
            for (Intern x : listI) {
                if (x.getEnterpriseId().equals(query)) {
                    ans.add(x);
                }
            }
            ans.sort(Comparator.comparing(Intern::getStudentId));

            for (int i = 0; i < Math.min(ans.size(), (int)limit); i++ ){
                System.out.println(ans.get(i));
            }
        }
    }
}
