package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseManager{
    Course[] courses;

    public CourseManager(){
        Connection conn = null;
        courses = new Course[0];
    }

    public void addCourse(Course course){
        int newLength = courses.length + 1;
        Course[] aux = new Course[newLength];
        int index = 0;

        for(Course c : courses){
            aux[index++]=c;
        }
        aux[index] = course;
        this.courses = new Course[newLength];
        System.arraycopy(aux, 0, courses, 0, newLength);
    }

    public void displayCoursesToConsole(){
        for(Course course: courses){
            System.out.println(course);
        }
    }

    public void enrollStudentInCourse(String courseName, Student student) {
        for (Course course : courses) {
            if (course.name.equals(courseName)) {
                course.addStudent(student);
                break;
            }
        }
    }

    public void listStudentsInCourse(String courseName) {
        for (Course course : courses) {
            if (course.name.equals(courseName)) {
                System.out.println("Studentii participanti la cursul de " + course.name + " sunt:");

                for(Student student : course.students){
                    System.out.println(student.getFullName());
                }
                break;
            }
            else{
                System.out.println("Nu exista studenti participanti la curs ");
            }
        }
    }

    public void calculateAverageGradeForCourse(String courseName) {
        for (Course course : courses) {
            if (course.name.equals(courseName)) {
                Student[] studentsInCourse = course.students;

                if (studentsInCourse.length == 0) {
                    System.out.println("Nu exista studenti participanti la curs ");
                }
                int totalGrade = 0;

                for (Student student : studentsInCourse) {
                    totalGrade += student.grade;
                }
                System.out.println("Media cursului " + course.name + " este egal cu: " + (double) totalGrade / studentsInCourse.length);
            }
            else{
                System.out.println("Cursul nu exista");
            }
        }
    }

    public void calculateAverageGradeByProfessor(Professor professor) {
        int totalGrade = 0;
        int totalStudents = 0;

        for (Course course : courses) {
            if (course.teacher.equals(professor)) {
                Student[] studentsInCourse = course.students;
                totalStudents += studentsInCourse.length;

                for (Student student : studentsInCourse) {
                    totalGrade += student.grade;
                }
            }
        }

        System.out.println("Media cursurilor profesorului " + professor.getFullName() + " este egala cu: " + (double) totalGrade / totalStudents);
    }
}