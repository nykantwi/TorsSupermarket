package supermarked;

import supermarked.data.Vare;
import supermarked.robot.Robot;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Map<String, Vare> alleVarer = CsvLoader.load("src/supermarked/data/varer.csv");
        //Map<String, Vare> tilbudsVarer = CsvLoader.load("src/supermarked/data/tilbud.csv");



        Map<String, Vare> tilbudsVarer = new HashMap<>(CsvLoader.load("src/supermarked/data/tilbud.csv"));
        tilbudsVarer.put("123", new Vare("123", "Mælk", 22, 8.0,  "liter"));

        KasseApparat kasse = new KasseApparat(alleVarer, tilbudsVarer);

        Robot robot = new Robot();
        Collection<Vare> kurv = robot.fyldIKurv(alleVarer.values());

        kasse.udskrivBon(kurv);
    }
}
