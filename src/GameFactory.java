import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class GameFactory {

    private final Statistics statistics;
    private final ThreadLocalRandom random;
    private final NullStatistics nullStatistics = new NullStatistics();

    public GameFactory(Statistics statistics, ThreadLocalRandom random) {
        this.statistics = statistics;
        this.random = random;
    }

    public Game create(List<Player> players) {
        Game game = new Game(random, statistics != null ? statistics : nullStatistics);
        
        players.forEach(game::addPlayer);
        
        return game;
    }
}
