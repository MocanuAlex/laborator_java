package clase;
public class student {
    String nume;
    String prenume;
    @Override
    public String toString() {
        return "student{" + "nume=" + nume + ", prenume=" + prenume + '}';
    }
    public student(String nume, String prenume, int i)
    {
        this.nume = nume;
        this.prenume = prenume;
    }
}