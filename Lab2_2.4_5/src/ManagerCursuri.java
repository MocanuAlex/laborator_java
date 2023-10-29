import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ManagerCursuri {
    private Map<String, List<Integer>> profesoriSiNote;

    public ManagerCursuri() {
        profesoriSiNote = new HashMap<>();
    }

    public void adaugaNota(String numeProfesor, int nota) {
        profesoriSiNote.computeIfAbsent(numeProfesor, k -> new ArrayList<>()).add(nota);
    }

    public double calculeazaMediaNotaProfesor(String numeProfesor) {
        List<Integer> note = profesoriSiNote.get(numeProfesor);

        if (note == null || note.isEmpty()) {
            return 0.0; // Returnează 0.0 dacă nu există note pentru profesor.
        }

        double suma = 0;
        for (int nota : note) {
            suma += nota;
        }

        return suma / note.size();
    }

    public static void main(String[] args) {
        ManagerCursuri manager = new ManagerCursuri();

        manager.adaugaNota("Profesor A", 90);
        manager.adaugaNota("Profesor A", 85);
        manager.adaugaNota("Profesor B", 88);
        manager.adaugaNota("Profesor B", 92);

        double mediaProfesorA = manager.calculeazaMediaNotaProfesor("Profesor A");
        double mediaProfesorB = manager.calculeazaMediaNotaProfesor("Profesor B");

        System.out.println("Media notelor pentru Profesor A: " + mediaProfesorA);
        System.out.println("Media notelor pentru Profesor B: " + mediaProfesorB);
    }
}
