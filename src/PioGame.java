import java.util.Arrays;
import java.util.List;
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
        Scanner scanner = new Scanner(System.in);
        List<Player> players = Arrays.asList(
                new PlayerHuman("Paweł", scanner),
                new PlayerHuman("Paweł", scanner),
                new PlayerHuman("Paweł", scanner),
                new PlayerComp("Komputer", random)
        );

        Game game = new Game(random);
        players.forEach(game::addPlayer);
        game.removePlayer("Komputer");
        game.printPlayers();
        game.play();
    }
}
