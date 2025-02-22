import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public Main() throws IOException {
        Repository r = new Repository();
        List<Skor> skor = r.getSkor();
        List<Kund> kund = r.getKund();
        List<Beställning> beställning = r.getBeställning();
        Kund köpare = null;
        int bID = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print("Ange ditt användarnamn:");
        String username = scan.nextLine().trim();
        System.out.print("Ange ditt lösenord:");
        String password = scan.nextLine().trim();
        System.out.println("****************************************************************");
        boolean found = false;

        for (Kund c : kund) {
            if (c.getNamn().equalsIgnoreCase(username) && c.getLösenord().equalsIgnoreCase(password)) {
                System.out.println("Välkommen " + c.getNamn());
                köpare = new Kund(c.getId(), c.getNamn(), c.getPersonNummer(), c.getOrt(), c.getLösenord());
                found = true;
                for (Beställning b : beställning) {
                    if (b.getKundId() == köpare.getId()) {
                        if ("AKTIV".equalsIgnoreCase(b.getTillstånd())) {
                            bID = b.getBeställningsId();
                            break;
                        } else if ("BETALD".equalsIgnoreCase(b.getTillstånd()))
                            bID = b.getBeställningsId();
                    }
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Felaktigt användarnamn eller lösenord");
            System.exit(0);
        }

        System.out.println("Produkter till salu: ");
        System.out.println("****************************************************************");
        for (Skor s : skor) {
            System.out.println(s);
        }
        System.out.println("****************************************************************");

        System.out.println("Vilken produkt vill du lägga till i varukorgen?" +
                "\n Ange märke:");
        String märke = scan.nextLine().trim();
        System.out.println("Ange färg");
        String färg = scan.nextLine().trim();
        System.out.println("Ange storlek");
        int storlek = scan.nextInt();

        found = false;
        for (Skor s : skor) {
            if (s.getMärke().equalsIgnoreCase(märke)
                    && s.getFärg().equalsIgnoreCase(färg)
                    && s.getStorlek() == storlek) {
                r.addToCart(köpare.getId(), bID, s.getId());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Produkten hittades inte...");
            System.exit(0);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
    }
}