import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class ManagerCursuri {
    private Map<String, List<String>> cursuriSiStudenti = new HashMap<>();

    public void adaugaCurs(String numeCurs) {
        cursuriSiStudenti.put(numeCurs, new ArrayList<>());
    }

    public void inscrieStudentInCurs(String numeStudent, String numeCurs) {
        List<String> studenti = cursuriSiStudenti.get(numeCurs);

        if (studenti != null) {
            studenti.add(numeStudent);
        } else {
            System.out.println("Cursul nu a fost găsit.");
        }
    }

    public List<String> listaStudentiInCurs(String numeCurs) {
        return cursuriSiStudenti.get(numeCurs);
    }

    public static void main(String[] args) {
        ManagerCursuri manager = new ManagerCursuri();

        manager.adaugaCurs("Matematică");
        manager.adaugaCurs("Știință");

        manager.inscrieStudentInCurs("Alice", "Matematică");
        manager.inscrieStudentInCurs("Bob", "Matematică");
        manager.inscrieStudentInCurs("Charlie", "Știință");

        List<String> studentiMatematica = manager.listaStudentiInCurs("Matematică");
        List<String> studentiStiinta = manager.listaStudentiInCurs("Știință");

        System.out.println("Studenți în cursul de Matematică: " + studentiMatematica);
        System.out.println("Studenți în cursul de Știință: " + studentiStiinta);
    }
}
