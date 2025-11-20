package supermarked.data;

public class Vare {
    private String varenummer;
    private String navn;
    private String prisAendringsDato;
    private double pris;
    private int antal;
    private String enhed;


    public Vare(String varenummer, String navn, String prisAendringsDato, double pris, int antal, String enhed) {
        this.varenummer = varenummer;
        this.navn = navn;
        this.prisAendringsDato = prisAendringsDato;
        this.pris = pris;
        this.antal = antal;
        this.enhed = enhed;
    }

    public String getPrisAendringsDato() {
        return prisAendringsDato;
    }

    public String getNavn() {
        return navn;
    }

    public String getVarenummer() {
        return varenummer;
    }

    public String getEnhed() {
        return enhed;
    }

    public int getAntal() {
        return antal;
    }

    public double getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return "Vare{" +
                "enhed='" + enhed + '\'' +
                ", navn='" + navn + '\'' +
                ", prisAendringsDato=" + prisAendringsDato +
                '}';
    }

}