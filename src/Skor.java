public class Skor {

    private int id;
    private String märke;
    private int storlek;
    private String färg;
    private int pris;
    private int lagerSaldo;

    public Skor() {
    }

    public Skor(int id, String märke, int storlek, String färg, int pris, int lagerSaldo) {
        this.märke = märke;
        this.storlek = storlek;
        this.färg = färg;
        this.pris = pris;
        this.lagerSaldo = lagerSaldo;
        this.id = id;
    }

    public String getMärke() {
        return märke;
    }

    public void setMärke(String märke) {
        this.märke = märke;
    }

    public int getStorlek() {
        return storlek;
    }

    public void setStorlek(int storlek) {
        this.storlek = storlek;
    }

    public String getFärg() {
        return färg;
    }

    public void setFärg(String färg) {
        this.färg = färg;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public int getLagerSaldo() {
        return lagerSaldo;
    }

    public void setLagerSaldo(int lagerSaldo) {
        this.lagerSaldo = lagerSaldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Märke: " + märke +
                " | Storlek: " + storlek +
                " | Färg: " + färg +
                " | Pris: " + pris +
                " | LagerSaldo: " + lagerSaldo;
    }
}
