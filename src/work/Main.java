package work;
import items.CreateItems;
import items.Items;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Arena arena = Arena.Instance();

        //File-ul unde vreau sa scriu output-ul din consola
        File file = new File("C://Users/david.mihalcenco" +
        "/IdeaProjects/proiectPoo/Results/test.10");

        // pentru a scrie in file decomentez linia
        System.setOut(new PrintStream(file));

        //Testul care vreau sa-l incerc
        String test1 = "C://Users/david.mihalcenco" +
                "/IdeaProjects/proiectPoo/Coaches/Trainer10";

        arena.randomOpponent(test1);


    }
}
