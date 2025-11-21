package supermarked;

import supermarked.data.Vare;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class KasseApparat {
    private Map<String, Vare> alleVarer;
    private Map<String, Vare> tilbudsVarer;

    public KasseApparat(Map<String, Vare> alleVarer, Map<String, Vare> tilbudsVarer) {
        this.alleVarer = alleVarer;
        this.tilbudsVarer = tilbudsVarer;
    }

    public Map<String, Vare> getAlleVarer() {
        return alleVarer;
    }

    public void setAlleVarer(Map<String, Vare> alleVarer) {
        this.alleVarer = alleVarer;
    }

    public Map<String, Vare> getTilbudsVarer() {
        return tilbudsVarer;
    }

    public void setTilbudsVarer(Map<String, Vare> tilbudsVarer) {
        this.tilbudsVarer = tilbudsVarer;
    }

    public void udskrivBon(Collection<Vare> kurv) {
        Map<String, Integer> counts = tælVarer(kurv);
        double total = 0;

        System.out.println("------ KASSEBON ------");

        for (String varenr : counts.keySet()) {
            Vare normalVare = alleVarer.get(varenr);
            int antal = counts.get(varenr);

            double stkPris;
            boolean erTilbud = tilbudsVarer.containsKey(varenr);

            if (erTilbud) {
                Vare tilbud = tilbudsVarer.get(varenr);
                stkPris = tilbud.getPris();
            } else {
                stkPris = normalVare.getPris();
            }

            double linjePris = stkPris * antal;
            total += linjePris;

            // Print line
            System.out.println(normalVare.getNavn());
            System.out.println("  " + antal + " x " + stkPris + "   =   " + linjePris);

            if (erTilbud) {
                double rabat = normalVare.getPris() - stkPris;
                System.out.println("  RABAT: -" + rabat * antal);
            }

            System.out.println();
        }

        double moms = total * 0.25;

        System.out.println("-----------------------");
        System.out.println("TOTAL: " + total);
        System.out.println("MOMS:  " + moms);
    }

    // --- Count items in basket ---
    private Map<String, Integer> tælVarer(Collection<Vare> kurv) {
        Map<String, Integer> counts = new HashMap<>();
        for (Vare v : kurv) {
            counts.put(v.getEan(), counts.getOrDefault(v.getEan(), 0) + 1);
        }
        return counts;
    }
}
