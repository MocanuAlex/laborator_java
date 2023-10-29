package clase;

import java.util.Arrays;

public class main {

    public static void main (String[] args)
    {

        student[] studenti = new student[]{new student("Andrei", "Marius", 2231), new student("Ion", "Matei", 4221)};

        curs cursi = new curs("Java");

        System.out.println(Arrays.toString(studenti));
        System.out.println(cursi);
    }
}

