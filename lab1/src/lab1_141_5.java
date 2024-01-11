public class lab1_141_5 {
    public static void main(String[] args) {
        int monthDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String months[] = { "Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie", "Iulie", "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie" };

        for (int i = 0; i < 12; i++) {
            String firstThreeChars = months[i].substring(0, 3);
            System.out.println(firstThreeChars + ": " + monthDays[i] + " zile");
        }
    }
}
