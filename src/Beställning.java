import java.time.LocalDate;

public class Beställning {
    private int beställningsId;
    private LocalDate datum;
    private int kundId;
    private String tillstånd;

    public Beställning() {
    }

    public Beställning(int beställningsId, LocalDate datum, int kundId, String tillstånd) {
        this.beställningsId = beställningsId;
        this.datum = datum;
        this.kundId = kundId;
        this.tillstånd = tillstånd;
    }

    public int getBeställningsId() {
        return beställningsId;
    }

    public void setBeställningsId(int beställningsId) {
        this.beställningsId = beställningsId;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public int getKundId() {
        return kundId;
    }

    public void setKundId(int kundId) {
        this.kundId = kundId;
    }

    public String getTillstånd() {
        return tillstånd;
    }

    public void setTillstånd(String tillstånd) {
        this.tillstånd = tillstånd;
    }
}
