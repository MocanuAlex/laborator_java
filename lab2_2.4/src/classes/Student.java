package classes;

import java.util.Objects;

public class Student {
    String firstName;
    String lastName;
    int groupNumber;
    public Student(String firstName, String lastName, int groupNumber){
        this.firstName=firstName;
        this.lastName=lastName;
        this.groupNumber=groupNumber;
    }
    public String toString(){
        return "Student["+"firstName="+firstName+", lastName="+lastName+", groupNumber="+groupNumber+']';
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName (String firstName){
        this.firstName=firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName (String lastName){
        this.lastName=lastName;
    }
    public int getGroupNumber(){
        return groupNumber;
    }
    public void setGroupNumber(int groupNumber){
        this.groupNumber=groupNumber;
    }
    public String getFullName(){
        return firstName+lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student Student = (Student) o;
        return groupNumber == Student.groupNumber && Objects.equals(firstName, Student.firstName) && Objects.equals(lastName, Student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, groupNumber);
    }
}
