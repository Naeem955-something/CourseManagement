package CourseManagement;
public class Faculty {

     private int facultyid;
     private String facultyName;
     private String facultyPosition;
    public Faculty() {
    }
    public Faculty(int facultyid, String facultyName, String facultyPosition) {
        this.facultyid = facultyid;
        this.facultyName = facultyName;
        this.facultyPosition = facultyPosition;
    }
    
    public int getFacultyid() {
        return facultyid;
    }
    public void setFacultyid(int facultyid) {
        this.facultyid = facultyid;
    }
    public String getFacultyName() {
        return facultyName;
    }
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
    public String getFacultyPosition() {
        return facultyPosition;
    }
    public void setFacultyPosition(String facultyPosition) {
        this.facultyPosition = facultyPosition;
    }
    @Override
    public String toString() {
        return "Faculty [facultyid=" + facultyid + ", facultyName=" + facultyName + ", facultyPosition="
                + facultyPosition + "]";
    }
     
}
