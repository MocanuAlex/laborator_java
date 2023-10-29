package clase;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {

        student[] studenti = new student[]{new student("Andrei", "Marius", 2231), new student("Ion", "Matei", 4221)};

        Profesor prof = new Profesor("Anton", "Marinel");

        System.out.println(Arrays.toString(studenti));
        System.out.println(prof);
    }
    }

