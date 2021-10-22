import java.util.concurrent.ThreadLocalRandom;

/**
 * Gra w odgadywanie wylosowanej liczby.
 * <p>
 * Zasady:
 * - mistrz gry (komputer) rzuca kostką (losuje liczby z zakresu 1..6)
 * - gracz (też komputer) stara się odgadnąć liczbę (też losuje)
 * - jeżeli odgadnie, gra się kończy
 * - jeżeli nie odgadnie, rozpoczyna się kolejna runda (komputer losuje kolejną liczbę i gracz stara się ją odgadnąć)
 */
public class PioGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Player player = new Player("Paweł", random);

        while (true) {
            System.out.println("---------------------");

            int number = player.guess();
            System.out.println("Kostka: " + number);

            int guess = random.nextInt(1, 7);
            System.out.printf("Gracz %s: %d\n", player.getName(), guess);

            if (number != guess) {
                System.out.println("PUDŁO!");
            } else {
                System.out.println("BRAWO!");
                break;
            }
        }
    }
}
