public class lab1_141_4 {
    public static void main(String[] args) {
        int monthDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String months[] = { "Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie", "Iulie", "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie" };

        int totalDays = 0;

        for (int i = 0; i < 12; i++) {
            if (monthDays[i] < 31) {
                totalDays += monthDays[i];
            }
        }

        System.out.println("Numărul total de zile al lunilor cu mai puțin de 31 de zile: " + totalDays);
    }
}
