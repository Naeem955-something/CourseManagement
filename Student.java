package CourseManagement;
public class Student{
   private int Studentid ;
   private String Studentname;
   private double Studentcgpa;
public Student() {
}
public Student(int studentid, String studentname, double studentcgpa) {
    Studentid = studentid;
    Studentname = studentname;
    Studentcgpa = studentcgpa;
}

public int getStudentid() {
    return Studentid;
}
public void setStudentid(int studentid) {
    Studentid = studentid;
}
public String getStudentname() {
    return Studentname;
}
public void setStudentname(String studentname) {
    Studentname = studentname;
}
public double getStudentcgpa() {
    return Studentcgpa;
}
public void setStudentcgpa(double studentcgpa) {
    Studentcgpa = studentcgpa;
}
@Override
public String toString() {
    return "Student [Studentid=" + Studentid + ", Studentname=" + Studentname + ", Studentcgpa=" + Studentcgpa + "]";
}
    
}
