package supermarked;

import supermarked.data.Vare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

    public class CsvLoader  {
        public static Map<String, Vare> load(String filename) {

        Map<String, Vare> varer = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {

                String[] c = line.split(";");


                Vare v = new Vare(
                        c[0],
                        c[1],
                        c[2],
                        Double.parseDouble(c[3]),
                        Integer.parseInt(c[4]),
                        c[5]
                );

                varer.put(c[0], v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return varer;
    }

}
