import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository {

    private Properties p = new Properties();

    public Repository() {
        try {
            p.load(new FileInputStream("src/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Beställning> getBeställning() {

        List<Beställning> beställning = new ArrayList<>();

        try (Connection c = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("select id, datum, kundId, tillstånd from beställning")

        ) {

            while (rs.next()) {
                Beställning temp = new Beställning();
                int id = rs.getInt("id");
                temp.setBeställningsId(id);
                LocalDate datum = rs.getDate("datum").toLocalDate();
                temp.setDatum(datum);
                int kundId = rs.getInt("kundId");
                temp.setKundId(kundId);
                String tillstånd = rs.getString("tillstånd");
                temp.setTillstånd(tillstånd);
                beställning.add(temp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return beställning;
    }

    public List<Kund> getKund() {

        List<Kund> kund = new ArrayList<>();

        try (Connection c = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("select id, namn, personnummer, ort, lösenord from kund")

        ) {

            while (rs.next()) {
                Kund temp = new Kund();
                int id = rs.getInt("id");
                temp.setId(id);
                String namn = rs.getString("namn");
                temp.setNamn(namn);
                String personnummer = rs.getString("personnummer");
                temp.setPersonNummer(personnummer);
                String ort = rs.getString("ort");
                temp.setOrt(ort);
                String lösenord = rs.getString("lösenord");
                temp.setLösenord(lösenord);
                kund.add(temp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return kund;
    }

    public List<Skor> getSkor() {

        List<Skor> skor = new ArrayList<>();

        try (Connection c = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("select id, märke, storlek, färg, pris, lagersaldo from skor")

        ) {

            while (rs.next()) {
                Skor temp = new Skor();
                int id = rs.getInt("id");
                temp.setId(id);
                String märke = rs.getString("märke");
                temp.setMärke(märke);
                int storlek = rs.getInt("storlek");
                temp.setStorlek(storlek);
                String färg = rs.getString("färg");
                temp.setFärg(färg);
                int pris = rs.getInt("pris");
                temp.setPris(pris);
                int lagersaldo = rs.getInt("lagersaldo");
                temp.setLagerSaldo(lagersaldo);
                skor.add(temp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return skor;
    }

    public void addToCart(int kundId, int beställningsId, int skoId) {

        try (Connection c = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));

             CallableStatement stmt = c.prepareCall("call AddToCart(?, ?, ?)");
        ) {

            stmt.setInt(1, kundId);
            stmt.setInt(2, beställningsId);
            stmt.setInt(3, skoId);

            stmt.executeUpdate();
            System.out.println("Produkten har lagts till i varukorgen");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
