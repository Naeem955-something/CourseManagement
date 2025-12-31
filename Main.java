package CourseManagement;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Faculty> faculty = new ArrayList<>();
    public static ArrayList<Course> course = new ArrayList<>();

    public static boolean studentAlreadyExists(int sid) {

        boolean flag = true;
        for (Student s : students) {
            if (s.getStudentid() == sid) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static Student findStudentByID(int stdid) {
        Student selectedStudent = null;
        for (Student s : students) {
            if (s.getStudentid() == stdid) {
                selectedStudent = s;
            }
        }
        return selectedStudent;
    }

    public static boolean courseAlreadyExists(Course c) {
        boolean flag = true;
        for (Course x : course) {
            if (x.getCouresId().equals(c.getCouresId()) || x.getCourseTitle().equals(c.getCourseTitle())) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static Course findcouresbyId(String courseid) {
        Course selectedC = null;
        for (Course y : course) {
            if (y.getCouresId().equals(courseid)) {
                selectedC = y;
            }
        }
        return selectedC;
    }

    public static boolean facultyAlreadyExists(Faculty f) {
        boolean flag = true;
        for (Faculty m : faculty) {
            if (m.getFacultyid() == f.getFacultyid()) {
                flag = false;
            }
        }
        return flag;
    }

    public static Faculty findFacultyByID(int fid) {
        Faculty selectedF = null;
        for (Faculty f : faculty) {
            if (f.getFacultyid() == fid) {
                selectedF = f;
            }
        }
        return selectedF;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Menu \n1. Add \n2. Delete \n3. Update \n4. Print \n5.Search \n0. Exit");
            System.out.print("Enter your X : ");
            int x = input.nextInt();

            if (x == 0) {
                break;
            }

            else if (x == 1) {
                while (true) {

                    System.out.println("\nAdd Options \n1. Add Student \n2. Add Course \n3. Add Faculty" +
                            "\n4. Add a Student to a Course \n5. Add a Faculty to a Course \n0. Back to Menu.");
                    System.out.print("Enter your Y: ");
                    int y = input.nextInt();

                    if (y == 0) {
                        break;
                    }

                    else if (y == 1) {
                        System.out.print("Enter how many students you want to add: ");
                        int std_num = input.nextInt();

                        for (int i = 0; i < std_num; i++) {
                            System.out.println("Enter Information of Student-" + (i + 1));

                            System.out.print("Name: ");
                            input.nextLine();
                            String name = input.nextLine();
                            System.out.print("Student ID: ");
                            int id = input.nextInt();
                            System.out.print("CGPA: ");
                            double cgpa = input.nextDouble();

                            Student s = new Student(id, name, cgpa);

                            if (studentAlreadyExists(s)) {
                                System.out.println("Student ID: " + id + " already exists.");
                            } else {
                                students.add(s);
                            }
                        }
                    }

                    else if (y == 2) {
                        System.out.print("Enter how many course you want to add: ");
                        int course_num = input.nextInt();

                        for (int i = 0; i < course_num; i++) {
                            System.out.println("Enter Information of Course-" + (i + 1));

                            System.out.print("Course ID: ");
                            input.nextLine();
                            String cid = input.nextLine();
                            System.out.print("Course Title: ");

                            String ctitle = input.nextLine();
                            System.out.print("Credit: ");
                            int credit = input.nextInt();

                            Course c = new Course(ctitle, cid, credit);

                            if (courseAlreadyExists(c)) {
                                System.out.println("Course  ID: " + cid + ", Course Title: "
                                        + ctitle + " already exists.");
                            } else {
                                course.add(c);
                            }
                        }

                    }

                    else if (y == 3) {
                        System.out.print("Enter how many faculty you want to add: ");
                        int facnum = input.nextInt();

                        for (int i = 0; i < facnum; i++) {
                            System.out.println("Enter Information of Faculty-" + (i + 1));

                            System.out.print("Faculty ID : ");
                            int faid = input.nextInt();
                            System.out.print("Faculty Name: ");
                            input.nextLine();
                            String faname = input.nextLine();
                            System.out.print("Faculty Position: ");
                            String faposition = input.nextLine();

                            Faculty f = new Faculty(faid, faname, faposition);

                            if (facultyAlreadyExists(f)) {
                                System.out.println("Faculty [Faculty ID: " + faid + "] already exists");
                            }
                        }
                    }

                    else if (y == 4) {
                        System.out.print("Enter the Course ID where you want to add the student: ");
                        input.nextLine();
                        String courseID = input.nextLine();
                        Course selectedcourse = findcouresbyId(courseID);

                        if (selectedcourse == null) {
                            System.out.println("Course [ID: " + courseID + "] does not exists");
                        } else {
                            System.out.print("Enter the Student ID to add to the course: ");
                            int studentID = input.nextInt();
                            Student selectedStudent = findStudentByID(studentID);

                            if (selectedcourse.getnumberofStudent() < 40) {
                                selectedcourse.addStudent(selectedStudent);
                            } else {
                                System.out.println("Course [ID: " + courseID + "]");
                            }
                        }
                    }

                    else if (y == 5) {
                        System.out.print("Enter the Course ID where you want to add the faculty: ");
                        input.nextLine();
                        String courseid = input.nextLine();
                        Course selected_course = findcouresbyId(courseid);

                        if (selected_course == null) {
                            System.out.println("Course [ID: " + courseid + "]  not exists");
                        } else {
                            if (selected_course.getFaculty() != null) {
                                System.out.println("There's already a faculty present in this course.");
                            } else {
                                System.out.print("Enter the Faculty ID to add to the course: ");
                                int facultyID = input.nextInt();
                                Faculty selectedFaculty = findFacultyByID(facultyID);

                                if (selectedFaculty == null) {
                                    System.out.println("Faculty [Faculty ID: " + facultyID + " does not exist");
                                } else {
                                    selected_course.addFaculty(selectedFaculty);
                                }
                            }
                        }
                    }
                }
            }

            else if (x == 2) {
                while (true) {

                    System.out.println(
                            "\nDelete Options \n1. Delete a Student \n2. Delete a Course \n3. Delete a Faculty" +
                                    "\n4. Drop a Student from a Course \n5. Drop a Faculty from a Course \n0. Back to Menu.");
                    System.out.print("Enter your choice: ");
                    int ch = input.nextInt();

                    if (ch == 0) {
                        break;
                    }

                    else if (ch == 1) {
                        System.out.print("Enter the Student ID of the student who you want to delete: ");
                        int studentid = input.nextInt();
                        Student selectedStudent = findStudentByID(studentid);

                        if (selectedStudent == null) {
                            System.out.println("Student ID: " + studentid + " doesn't exist");
                        } else {
                            students.remove(selectedStudent);
                        }
                    }

                    else if (ch == 2) {
                        System.out.print("Enter the Course ID of the course which you want to delete: ");
                        input.nextLine();
                        String courseID = input.nextLine();
                        Course selectedCourse = findcouresbyId(courseID);

                        if (selectedCourse == null) {
                            System.out.println("Course ID: " + courseID + " doesn't exist");
                        } else if (selectedCourse.getnumberofStudent() < 8) {
                            course.remove(selectedCourse);
                        }

                    }

                    else if (ch == 3) {
                        System.out.print("Enter the Faculty ID of the faculty who you want to delete: ");
                        int facultyid = input.nextInt();
                        Faculty selectedFaculty = findFacultyByID(facultyid);

                        if (selectedFaculty == null) {
                            System.out.println("Faculty ID: " + facultyid + " not exist");
                        } else {
                            faculty.remove(selectedFaculty);
                        }
                    }

                    else if (ch == 4) {

                        System.out.print("Enter the Course ID from where you want to drop the student: ");
                        input.nextLine();
                        String courseID = input.nextLine();
                        Course selectedcourse = findcouresbyId(courseID);

                        if (selectedcourse == null) {
                            System.out.println("Course ID: " + courseID + " does not exists");
                        } else {
                            System.out.print("Enter the Student ID to drop from the course: ");
                            int studentID = input.nextInt();
                            Student selectedStudent = findStudentByID(studentID);

                            if (selectedcourse.getnumberofStudent() < 40) {
                                selectedcourse.addStudent(selectedStudent);
                            } else {
                                System.out.println("Course ID: " + courseID + " is full Can't add  student");
                            }
                        }
                    } else if (ch == 5) {
                        System.out.println("Enter the Course ID from where you want to remove a Faculty:");
                        input.nextLine();
                        String courseid = input.nextLine();
                        Course selectedCourse = findcouresbyId(courseid);
                        if (selectedCourse == null) {
                            System.out.println("Course ID: " + courseid + " does not exists");
                        } else {
                            System.out.print("Enter the faculty  ID to drop from the course: ");
                            int facultyid = input.nextInt();
                            Faculty selectedfaculty = findFacultyByID(facultyid);
                            if (selectedfaculty == null) {
                                System.out.println("faculty not exist ");
                            } else {
                                faculty.remove(selectedfaculty);
                            }

                        }
                    }
                }
            } else if (x == 3) {
                while (true) {
                    System.out.println(
                            "\nupdate  Options \n1. update after Add a Student \n2. update after Add a Course \n3. Update after Add a Faculty"
                                    +
                                    "\n4. update after Add a Student to a Course \n5. update after Add a Faculty to a Course \n0. Back to Menu.");
                    System.out.print("Enter your z : ");
                    int z = input.nextInt();

                    if (z == 0) {
                        break;
                    } else if (z == 1) {
                        System.out.print("Enter the Student ID of the student you want to update: ");
                        int studentid = input.nextInt();
                        Student selectedStudent = findStudentByID(studentid);

                        if (selectedStudent == null) {
                            System.out.println("Student ID: " + student_id + " doesn't exist");
                        } else {
                            System.out.println("Updating Information of Student ID: " + studentid);
                            System.out.print("Enter New Name: ");
                            input.nextLine();
                            String newName = input.nextLine();
                            System.out.print("Enter New CGPA: ");
                            double newCGPA = input.nextDouble();

                            selectedStudent.setStudentName(newName);
                            selectedStudent.setStudentCGPA(newCGPA);

                            System.out.println("Student ID: " + student_id + " updated successfully.");
                        }
                    } else if (z == 2) {
                        System.out.print("Enter the Course ID of the course you want to update: ");
                        input.nextLine();
                        String courseid = input.nextLine();
                        Course selectedCourse = findCourseByID(courseid);

                        if (selectedCourse == null) {
                            System.out.println("Student ID: " + courseid + " doesn't exist");
                        } else {
                            System.out.println("Updating Information of Course ID: " + courseid);
                            System.out.print("Enter New Course Title: ");
                            String newTitle = input.nextLine();
                            System.out.print("Enter New Credit: ");
                            double newCredit = input.nextDouble();

                            selectedCourse.setCourseTitle(newTitle);
                            selectedCourse.setCredit(newCredit);
                            System.out.println("Course ID: " + courseid + " updated successfully.");
                        }
                    } else if (z == 3) {
                        System.out.print("Enter the Faculty ID of the faculty you want to update: ");
                        int facultyid = input.nextInt();
                        Faculty selectedFaculty = findFacultyByID(facultyid);

                        if (selectedFaculty == null) {
                            System.out.println("Faculty ID: " + facultyid + " doesn't exist");
                        } else {
                            System.out.println("Updating Information of Faculty ID: " + facultyid);
                            System.out.print("Enter New Name : ");
                            input.nextLine();
                            String newName = input.nextLine();
                            System.out.print("Enter New Position : ");
                            String newPosition = input.nextLine();

                            selectedFaculty.setFacultyName(newName);
                            selectedFaculty.setFacultyPosition(newPosition);

                            System.out.println("Faculty ID : " + facultyid + " updated successfully.");
                        }
                    }
                }
            } else if (x == 4) {
                while (true) {
                    System.out.println(
                            "\nPrint Options \n1. Print all students \n2. Print all course \n3. Print all faculties" +
                                    "\n4. Print information of a student \n5. Print information of a course" +
                                    "\n6. Print information of a faculty \n7. Print student list and faculty information of a course"
                                    +
                                    "\n8. Print courses taken by a student \n0. Back to Menu");

                    System.out.println("Enter your choice: ");
                    int h = input.nextInt();

                    if (h == 0) {
                        break;
                    } else if (h == 1) {
                        System.out.println("All Students in the University: ");
                        for (Student s : students) {
                            System.out.println(s.toString());
                        }
                    } else if (h == 2) {
                        System.out.println("All Courses in the University: ");
                        for (Course c : course) {
                            System.out.println(c.toString());
                        }
                    } else if (h == 3) {
                        System.out.println("All Faculties in the University: ");
                        for (Faculty f : faculty) {
                            System.out.println(f.toString());
                        }
                    } else if (h == 4) {
                        System.out.print("Enter the Student's ID to see the Information: ");
                        int studentid = input.nextInt();

                        Student selectedStudent = findStudentByID(studentid);

                        if (selectedStudent == null) {
                            System.out.println("Student ID: " + studentid + " doesn't exist");
                        } else {
                            System.out.println("Student ID: " + studentid + " Information: ");
                            System.out.println(selectedStudent.toString());
                        }
                    } else if (h == 5) {
                        System.out.print("Enter the Course's ID to see the Information: ");
                        String courseid = input.nextLine();

                        Course selectedCourse = findCourseByID(courseid);

                        if (selectedCourse == null) {
                            System.out.println("Course ID: " + courseid + " doesn't exist");
                        } else {
                            System.out.println("Course ID: " + course_id + " Information: ");
                            System.out.println(selectedCourse.toString());
                        }
                    } else if (h == 6) {
                        System.out.print("Enter the Faculty's ID to see the Information : ");
                        int facultyid = input.nextInt();

                        Faculty selectedFaculty = findFacultyByID(facultyid);

                        if (selectedFaculty == null) {
                            System.out.println("Faculty ID: " + facultyid + " doesn't exist");
                        } else {
                            System.out.println("Faculty ID: " + facultyid + " Information: ");
                            System.out.println(selectedFaculty.toString());
                        }
                    } else if (h == 7) {
                        System.out.println(
                                "Enter the Course ID to see student list and faculty information of a course: ");
                        input.nextLine();
                        String courseID = input.nextLine();

                        Course selectedCourse = findCourseByID(courseID);
                        if (selectedCourse == null) {
                            System.out.println("Course ID: " + courseID + " doesn't exist");
                        } else {
                            System.out.println("Course ID: " + courseID + " Information: ");
                            System.out.println(selectedCourse.toString());
                            System.out.println("Student List: ");
                            for (Student s : selectedCourse.getStudenList()) {
                                System.out.println(s.toString());
                            }

                            Faculty selectedFaculty = selectedCourse.getFaculty();
                            if (selectedFaculty != null) {
                                System.out.println("Faculty Information: ");
                                System.out.println(selectedFaculty.toString());
                            } else {
                                System.out.println("No faculty  this course.");
                            }
                        }
                    } else if (h == 8) {
                        System.out.print("Enter the Student's ID to see the courses : ");
                        int studentID = input.nextInt();

                        Student selectedStudent = findStudentByID(studentID);

                        if (selectedStudent == null) {
                            System.out.println("Student ID: " + studentID + " doesn't exist");
                        } else {
                            System.out.println("Courses taken by Student ID: " + studentID);
                            for (Course c : course) {
                                for (Student s : c.getStudentList()) {
                                    if (s.getStudentId() == studentID) {
                                        System.out.println(c.toString());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (x == 5) {
                while (true) {
                    System.out.println(
                            "\nSearch Options: \n1. Search a Student \n2. Search a Course \n3.Search a Faculty" +
                                    "'\n4. Search whether a student takes a course \n5. Search whether a faculty teaches a course"
                                    +
                                    "\n6. Search courses taken by a student \n7. Search courses taught by a faculty \n0. Back to Menu");
                    System.out.print("Enter your choice: ");
                    int ch = input.nextInt();

                    if (ch == 0) {
                        break;
                    } else if (ch == 1) {
                        System.out.println("Enter Student ID to search: ");
                        int studentID = input.nextInt();
                        Student selectedStudent = findStudentByID(studentID);
                        if (selectedStudent == null) {
                            System.out.println("Student ID: " + studentID + " doesn't exist.");
                        } else {
                            System.out.println("Student Information: ");
                            System.out.println(selectedStudent.toString());
                        }
                    } else if (ch == 2) {
                        System.out.println("Enter Course ID to search: ");
                        String courseID = input.nextLine();
                        Course selectedCourse = findCourseByID(courseID);
                        if (selectedCourse == null) {
                            System.out.println("Course ID: " + courseID + " doesn't exist.");
                        } else {
                            System.out.println("Course Information: ");
                            System.out.println(selectedCourse.toString());
                        }
                    } else if (ch == 3) {
                        System.out.println("Enter Faculty ID to search: ");
                        int facultyID = input.nextInt();
                        Faculty selectedFaculty = findFacultyByID(facultyID);
                        if (selectedFaculty == null) {
                            System.out.println("Faculty ID: " + facultyID + " doesn't exist.");
                        } else {
                            System.out.println("Faculty Information: ");
                            System.out.println(selectedFaculty.toString());
                        }
                    } else if (ch == 4) {
                        System.out.print("Enter Student ID: ");
                        int studentID = input.nextInt();
                        System.out.print("Enter Course ID: ");
                        input.nextLine();
                        String courseID = input.nextLine();
                        Course selectedCourse = findCourseByID(courseID);

                        if (selectedCourse == null) {
                            System.out.println("Course ID: " + courseID + " doesn't exists.");
                        } else {
                            boolean checkStudentInCourse = false;
                            for (Student s : selectedCourse.getStudentList()) {
                                if (s.getStudentId() == studentID) {
                                    checkStudentInCourse = true;
                                    break;
                                }
                            }
                            if (checkStudentInCourse) {
                                System.out.println("Student ID : " + studentID + " is enrolled in course " + courseID);
                            } else {
                                System.out.println(
                                        "Student ID : " + studentID + " is not enrolled in course " + courseID);
                            }
                        }
                    } else if (ch == 5) {
                        System.out.print("Enter Faculty ID: ");
                        int facultyID = input.nextInt();
                        System.out.print("Enter Course ID: ");
                        input.nextLine();
                        String courseID = input.nextLine();
                        Course selectedCourse = findCourseByID(courseID);

                        if (selectedCourse == null) {
                            System.out.println("Course ID: " + courseID + " doesn't exists.");
                        } else {
                            Faculty searchFaculty = selectedCourse.getFaculty();
                            if (searchFaculty != null && searchFaculty.getFacultyId() == facultyID) {
                                System.out.println("Faculty ID: " + facultyID + " teaches course " + courseID);
                            } else {
                                System.out.println("Faculty ID: " + facultyID + " does not teaches course " + courseID);
                            }
                        }
                    } else if (ch == 6) {
                        System.out.println("Enter Student ID to search for taken courses: ");
                        int studentID = input.nextInt();
                        Student selectedStudent = findStudentByID(studentID);

                        if (selectedStudent == null) {
                            System.out.println("Student ID: " + studentID + " doesn't exists");
                        } else {
                            System.out.println("Courses taken by Student ID: " + studentID);
                            for (Course c : course) {
                                for (Student s : c.getStudentList()) {
                                    if (s.getStudentId() == studentID) {
                                        System.out.println(c.toString());
                                        break;
                                    }
                                }
                            }
                        }
                    } else if (ch == 7) {
                        System.out.println("Enter Faculty ID to search for taken courses: ");
                        int facultyID = input.nextInt();
                        Faculty selectedFaculty = findFacultyByID(facultyID);
                        if (selectedFaculty == null) {
                            System.out.println("Faculty ID: " + facultyID + " does not exists");
                        } else {
                            System.out.println("Courses taught by Faculty ID: " + facultyID);
                            for (Course c : course) {
                                if (c.getFaculty() != null && c.getFaculty().getFacultyId() == facultyID) {
                                    System.out.println(c.toString());
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid Choice");
                    }
                }
            } else {
                System.out.println("Invalid Choice!");
            }
        }
        input.close();
    }
}
