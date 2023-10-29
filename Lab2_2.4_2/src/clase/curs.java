package clase;
public class curs {
    String nume;

    public curs(String nume) {
    }

    @Override
    public String toString() {
        return " S au inscris pentru cursul de Java";
    }
    public curs(String nume, int i)
    {
        this.nume = nume;
    }
}