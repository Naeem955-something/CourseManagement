package CourseManagement;
import java.util.ArrayList;

public class Course {
    private String couresId;
    private String courseTitle;
    private int credit;
   private  ArrayList<Student>studenList =new ArrayList<Student>();
  private int numberofStudent;
  private Faculty faculty;
public Course() {
}
public Course(String couresId, String courseTitle, int credit){
    this.couresId = couresId;
    this.courseTitle = courseTitle;
    this.credit = credit;
   
}

public String getCouresId() {
    return couresId;
}
public void setCouresId(String couresId) {
    this.couresId = couresId;
}
public String getCourseTitle() {
    return courseTitle;
}
public void setCourseTitle(String courseTitle) {
    this.courseTitle = courseTitle;
}
public int getCredit() {
    return credit;
}
public void setCredit(int credit) {
    this.credit = credit;
}
public int getNumberofStudent() {
    return numberofStudent;
}
public void setNumberofStudent(int numberofStudent) {
    this.numberofStudent = numberofStudent;
}

public ArrayList<Student> getStudenList() {
    return studenList;
}
public void setStudenList(ArrayList<Student> studenList) {
    this.studenList = studenList;
}
public void setFaculty(Faculty faculty) {
    this.faculty = faculty;
}
@Override
public String toString() {
    return "Course [couresId=" + couresId + ", courseTitle=" + courseTitle + ", credit=" + credit +"]";
}
public void addStudent(Student S){
    boolean flag =true;
    for(Student X : studenList){
       if(X.getStudentid() ==S.getStudentid()){
        flag =false;
        break;
        }
        if(flag==true){
            studenList.add(S);
            numberofStudent++;
            System.out.println("student added ");
        }
        else{
            System.out.println("student already exist");
        }

    }
}
public void dropStudent(int sid){
    int studentIn=-1;
    for(int i=0;i<studenList.size();i++){
        if(studenList.get(i).getStudentid()==sid){
            studentIn=i;
            break;
        }
    }
    if(studentIn==-1){
        System.out.println("student not int the course ");
    }
    else{
        studenList.remove(studentIn);
        numberofStudent--;
    }

}
public void addFaculty(Faculty f){
    this.faculty = f;
}
public void dropFaculty(){
    this.faculty = null;
}
// public int getnumberofStudent(){
//     return numberofStudent;
// }

public Faculty getFaculty() {
    return faculty;
}
public void printstudentList(){
    System.out.println("The students in the " +getCouresId() + " course are: ");
    for(Student s : studenList){
    System.out.println(s.toString());
    }
}
}
