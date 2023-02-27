package main;

import gui.DolgozokGUI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Ember;

public class Dolgozok {

    static List<Ember> emberek = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String fileName = "emberek.txt";
        Path path = Paths.get(fileName);
        List<String> sorok = Files.readAllLines(path);
        System.out.println("Sorok száma: " + sorok.size());

        String fejlec = sorok.get(0);
        sorok.remove(0);

        for (int i = 0; i < sorok.size(); i++) {
            String[] line = sorok.get(i).split(";");
            if (line.length == 4) {
                emberek.add(new Ember(line[0], Integer.parseInt(line[1]), line[2].toCharArray()[0], Integer.parseInt(line[3])));
            } else if (line.length == 3) {
                emberek.add(new Ember(line[0], Integer.parseInt(line[1]), line[2].toCharArray()[0]));
            }
        }

        for (int i = 0; i < emberek.size(); i++) {
            System.out.println(emberek.get(i).toString());
        }

        //new DolgozokGUI().setVisible(true);
    }

}
