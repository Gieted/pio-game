import java.util.Arrays;
import java.util.List;
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
        List<Player> players = Arrays.asList(
                new PlayerComp("Paweł", random),
                new PlayerComp("Paweł", random),
                new PlayerComp("Paweł", random),
                new PlayerComp("Komputer", random)
        );


        Statistics statistics = new WinStatistics();

        GameFactory gameFactory = new GameFactory(statistics, random);

        for (int i = 0; i < 100; i++) {
            Game game = gameFactory.create(players);
            game.play();
        }

        System.out.println("--------------");
        statistics.print();
    }
}
