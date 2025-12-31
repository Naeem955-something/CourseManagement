
# 🎓 Course Management System

A **Java console application** to manage **Students**, **Courses**, and **Faculty** in a university.
Supports CRUD operations, course enrollment, faculty assignments, and search/report features.

---

## ✨ Features

### 👩‍🎓 Student

* Add / Delete / Update / Search
* Print all students

### 📚 Course

* Add / Delete / Update
* Assign / Drop students
* Assign / Remove faculty
* Print course info & student list

### 👨‍🏫 Faculty

* Add / Delete / Update / Search
* Assign to courses
* Print all faculty

### 🔍 Search & Reports

* Check student enrollment in a course
* Check faculty teaching a course
* List courses per student / faculty

---

## 📂 Structure

```
CourseManagement/
├── Course.java
├── Faculty.java
├── Student.java
└── Main.java
```

**Relationships:**

* Course → has students + faculty
* Student → enrolled in courses
* Faculty → teaches courses

---

## 🚀 How to Run

1. Compile:

```bash
javac CourseManagement/*.java
```

2. Run:

```bash
java CourseManagement.Main
```

3. Follow the menu options to manage data.

---

## 💡 Notes

* Max **40 students per course**
* Duplicate IDs are not allowed
* Faculty assigned only **one course at a time**

---

## 🌟 Future

* GUI interface
* Database persistence
* GPA & course reports

---



Do you want me to do that?
