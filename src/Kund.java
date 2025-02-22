public class Kund {
    private int id;
    private String namn;
    private String personNummer;
    private String ort;
    private String lösenord;

    public Kund() {
    }

    public Kund(int id, String namn, String personNummer, String ort, String lösenord) {
        this.id = id;
        this.namn = namn;
        this.personNummer = personNummer;
        this.ort = ort;
        this.lösenord = lösenord;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getPersonNummer() {
        return personNummer;
    }

    public void setPersonNummer(String personNummer) {
        this.personNummer = personNummer;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLösenord() {
        return lösenord;
    }

    public void setLösenord(String lösenord) {
        this.lösenord = lösenord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Kund{" +
                "namn='" + namn + '\'' +
                ", personNummer='" + personNummer + '\'' +
                ", ort='" + ort + '\'' +
                ", lösenord='" + lösenord + '\'' +
                '}';
    }
}
