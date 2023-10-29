import java.util.ArrayList;
import java.util.List;

class CourseManager {
    private List<Integer> mathGrades;
    private List<Integer> scienceGrades;

    public CourseManager() {
        mathGrades = new ArrayList<>();
        scienceGrades = new ArrayList<>();
    }

    public void addMathGrade(int grade) {
        mathGrades.add(grade);
    }

    public void addScienceGrade(int grade) {
        scienceGrades.add(grade);
    }

    public double calculateAverageMathGrade() {
        if (mathGrades.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (int grade : mathGrades) {
            sum += grade;
        }

        return sum / mathGrades.size();
    }

    public double calculateAverageScienceGrade() {
        if (scienceGrades.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (int grade : scienceGrades) {
            sum += grade;
        }

        return sum / scienceGrades.size();
    }

    public static void main(String[] args) {
        CourseManager courseManager = new CourseManager();

        courseManager.addMathGrade(95);
        courseManager.addMathGrade(85);
        courseManager.addScienceGrade(90);
        courseManager.addScienceGrade(78);

        System.out.println("Media notelor la Matematică: " + courseManager.calculateAverageMathGrade());
        System.out.println("Media notelor la Științe: " + courseManager.calculateAverageScienceGrade());
    }
}
