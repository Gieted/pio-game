import java.util.Scanner;
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
        Player player = new PlayerHuman("Paweł", new Scanner(System.in));
        Player player2 = new PlayerHuman("Damian", new Scanner(System.in));

        Game game = new Game(random);
        game.addPlayer(player);
        game.addPlayer(player2);
        game.play();
    }
}
