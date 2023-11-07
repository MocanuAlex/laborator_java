package classes;
import java.sql.Connection;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CourseManager {
    Map<String,Float> note = new HashMap<>();
    Course[] courses;
    public CourseManager(){
        Connection conn=null;
        courses=new Course[0];
    }
    public void addCourse(Course course){
        int newLength = courses.length +1;
        Course[] aux=new Course[newLength];
        int index=0;
        for(Course c: courses){
            aux[index++]=c;
        }
        aux[index]=course;
        this.courses= new Course[newLength];
        System.arraycopy(aux,0,courses,0, newLength);
    }
    public void displayCoursesToConsole(){
        for(Course c: courses){
            System.out.println(c);
        }
    }
    public void enroll(){
        String curs,firstn,lastn;
        int gn;
        System.out.println("Specify course name");
        Scanner in = new Scanner(System.in);
        curs = in.nextLine();
        for(var c:courses)
        {
            if(c.name.equals(curs))
            {
                System.out.println("Specify first name ");
                firstn= in.nextLine();
                System.out.println("Specify last name ");
                lastn= in.nextLine();

                gn= in.nextInt();System.out.println("Specify group number");
                c.students[c.students.length].setFirstName(firstn);
                c.students[c.students.length].setLastName(lastn);
                c.students[c.students.length].setGroupNumber(gn);
                break;
            }
        }
    }
    public void addnote(){
        System.out.println("Introdu numele si prenumele studentului: ");
        Scanner in=new Scanner(System.in);
        String nume= in.nextLine();
        System.out.println("Introdu nota: ");
        float nota= in.nextFloat();
        note.put(nume,nota);
    }
    public float teacher_average()
    {
        System.out.println("Introdu nume profesor:");
        Scanner in = new Scanner(System.in);
        String prof = in.nextLine();
        float average = 0;
        int nr = 0;
        for(var c:courses)
        {
            if(c.teacher.equals(prof))
            {
                nr++;
                average+=course_average(c.name);
            }
        }
        return average/nr;
    }
    public float course_average(String cursc){
        /*System.out.println("Introdu curs:");
        Scanner in = new Scanner(System.in);
        String cursc = in.nextLine();*/
        float average = 0;
        int nr = 0;
        for(var c : courses)
        {
            if(c.name.equals(cursc))
            {
                for(var d:c.students)
                {
                    for (var a : note.entrySet())
                    {
                        if(d.getFullName().equals(a.getKey()))
                        {
                            nr++;
                            average+=a.getValue();
                        }
                    }
                }
                break;
            }
        }
        return average/nr;
    }
    public void listStudentsInCourse(String courseName) {
        for (var course : courses) {
            if (course.name.equals(courseName)) // == ia hashu si il compara, .equals compara in functie de obiect/ proprietatile obiectului
            {
                for (var student : course.students) {
                    System.out.println(student.getFullName());
                }
                break;
            }
        }
    }
}
