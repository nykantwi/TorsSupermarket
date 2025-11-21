package supermarked.data;

public class Vare {

    private String ean;
    private String navn;
    private double pris;
    private double maengde;
    private String enhed;

    public Vare(String ean, String navn, double pris, double maengde, String enhed) {
        this.ean = ean;
        this.navn = navn;
        this.pris = pris;
        this.maengde = maengde;
        this.enhed = enhed;
    }

    public String getEan() {
        return ean;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

    public double getMaengde() {
        return maengde;
    }

    public String getEnhed() {
        return enhed;
    }

    @Override
    public String toString() {
        return "Vare{" +
                "ean='" + ean + '\'' +
                ", navn='" + navn + '\'' +
                ", pris=" + pris +
                ", maengde=" + maengde +
                ", enhed='" + enhed + '\'' +
                '}';
    }
}
